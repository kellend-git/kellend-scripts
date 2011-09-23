# Kellen Donohue
# 09-23-2011
# .bashrc

# Source global definitions
if [ -f /etc/bashrc ]; then
	. /etc/bashrc
fi

CLASSPATH=$CLASSPATH:$HOME/CSE_446/446_hw3/weka-3-6-4/weka.jar
export CLASSPATH

# Secrets
umask 077

# User specific aliases and functions
alias office='/uns/opt/openoffice.org2.0/program/soffice'
alias mc='mv'
alias v='vim'
alias sml='rlwrap sml -Cprint.length=1000'
alias wireshark='/usr/sbin/wireshark'
alias xlock="xlock -bg blue -info \"To use this terminal: Ctrl-Alt-F6, login, Execute: startx -- :2\""

alias ...='cd ...'
alias ..=' cd ..'

alias vbrc='vim ~/.bashrc'
alias sbrc='source ~/.bashrc'
