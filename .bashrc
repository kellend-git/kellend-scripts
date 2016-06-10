# Kellen Donohue
# 09-23-2011
# .bashrc

# Source global definitions
if [ -f /etc/bashrc ]; then
   . /etc/bashrc
fi

# enable programmable completion features (you don't need to enable
# this, if it's already enabled in /etc/bash.bashrc and /etc/profile
# sources /etc/bash.bashrc).
if [ -f /etc/bash_completion ]; then
    . /etc/bash_completion
fi

# Secrets
umask 077

# User specific aliases and functions
alias mc='mv'
alias v='vim'
alias sml='rlwrap sml -Cprint.length=1000'
alias wireshark='/usr/sbin/wireshark'
alias xlock="xlock -bg blue -info \"To use this terminal: Ctrl-Alt-F6, login, Execute: startx -- :2\""

alias ...='cd ...'
alias ..=' cd ..'

alias vbrc='vim ~/.bashrc'
alias sbrc='source ~/.bashrc'

alias mx='chmod a+x'
alias firefox='firefox 2>/dev/null &'

# ls aliases
alias ls='ls -h --color=auto'
alias ll='ls -l'
alias la='ls -A'

# Colors
alias less='less -r'
alias tree='tree -C'
alias grep="grep --color=auto"

# git aliases
alias g='git'
alias ga='git add'
alias gbr='git branch'
alias gc='git commit'
alias gcam='git commit -am'
alias gcamm='git commit -a --amend'
alias gco='git checkout'
alias gcm='git commit -m'
alias gd='git diff'
alias gf='git fetch'
alias gl='git log'
alias grbi='git rebase -i master'
alias grbc='git rebase --continue'
alias grv='git checkout HEAD --'
alias gs='git status'
alias gsh='git show'
alias gst='git stash'
alias gsta='git stash apply'
alias gup='git fetch && git pull'

# hg aliases
alias h='hg'
alias ha='hg add'
alias hcm='hg commit -m'
alias hd='hg diff'
alias hf='hg fetch'
alias hp='hg push'
alias hs='hg status'

# screen aliases
alias sls='screen -ls'
alias sr='screen -r'
alias srd='screen -rD'
alias ss='screen -S'
alias sw='screen -wipe'

# You better not change this
export EDITOR=vim

alias tarup='tar -vczf'
alias untar='tar -vxzf'
alias findn='find . -name'
