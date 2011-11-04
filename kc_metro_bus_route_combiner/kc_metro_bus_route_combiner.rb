# Kellen Donohue
# Sep 23, 2011
# Combines KC Metro's route-level data with bus routes with multiple rows into one.

f = File.open('bus_data.txt')
data = []
f.each do |line|
  # Build an entry -- a list of all numerical values
  entry = []
  # Columns are separated by spaces
  split = line.split(' ')
  patched = false
  split.each do |val|
    val.gsub!(',', '')
    val.gsub!('$', '')
    # Differentiate route segments
    if val == "S" || val == "N" || val == "W" || val == "E" then
      entry.unshift(entry.shift.to_s + val)
    # Add only the numerical values
    elsif val.to_i > 0 then
      entry << val.to_i
    end
  end
  # Add the entry to data
  data << entry.compact
end

processed = {}

data.each do |entry|
  if entry.size == 0 then next end
  combined = []
  count = 0
  # Select all the duplicate entries
  data.select{|x| x[0] == entry[0]}.each do |dup|
    combined[0] = entry[0]
    for i in 1...dup.size      
      combined[i] = dup[i] + (combined[i] || 0)
    end
  end
  processed[combined[0]] = combined
end

# Print out the results
processed.each do |val|
  if val then 
    puts val * ","
  end
end