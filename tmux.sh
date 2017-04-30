#!/bin/sh

set -e

S=typeclasses

tmux start-server
tmux new-session -d -s $S
tmux set-option -g -t $S allow-rename off

for P in a b c d e f g h; do
    tmux new-window -t $S -n $P \; send-keys "vi src/main/scala/org/indyscala/typeclasses/$P/Pretty.scala" C-m

done
