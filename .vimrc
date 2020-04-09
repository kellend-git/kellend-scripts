" Kellen Donohue
" 09-23-2011
" .vimrc
set nocompatible              " be iMproved, required
filetype off                  " required


syntax on
set smartindent
set autochdir
set backspace=indent,eol,start
set mouse=a " Might cause your vim to hang on Cygwin
set ttymouse=xterm2 " make the mouse work on screen
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
set incsearch ignorecase hlsearch
" Press space to clear search highlighting and any message already displayed.
noremap <silent> <Space> :silent noh<Bar>echo<CR>
set expandtab
set tabstop=2
set shiftwidth=2

" Cursor column, toggle with \ then c
:hi CursorColumn cterm=NONE ctermbg=21 ctermfg=white
:nnoremap <Leader>c :set cursorcolumn!<CR>

" Home / End
:map <Home> ^
:imap <Home> <Esc>^i
:map <End> $
:imap <End> <Esc>^i

nnoremap ; :
vnoremap ; :
