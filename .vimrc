# Kellen Donohue
# 09-23-2011
# .vimrc

set smartindent
set autochdir
set backspace=indent,eol,start
set mouse=a
set iskeyword+=_,$,@,%,# 
set cursorline " highlight current line
set number
set showcmd
set showmatch
set statusline=%F%m%r%h%w[%L][%{&ff}]%y[%p%%][%04l,%04v]
set ignorecase
set infercase
set foldenable
set wildmode=full
set wildmenu
autocmd BufReadPost *
\ if line("'\"") > 0 && line("'\"") <= line("$") |
  \   exe "normal g`\"" |
      \ endif
