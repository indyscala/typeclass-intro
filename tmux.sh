#!/bin/sh

set -e

S=typeclasses

if [ "$1" = "close" ]; then
    for W in 8 7 6 5 4 3 2 1 0; do
        tmux select-window -t $W
        tmux send-keys ':q' C-m
    done
    tmux kill-session -t $S
    exit
fi

tmux start-server
tmux new-session -d -s $S
tmux set-option -g -t $S allow-rename off

for P in a b c d e f g h; do
    tmux new-window -t $S -n $P \; send-keys "vi src/main/scala/org/indyscala/typeclasses/$P/Pretty.scala" C-m
done

tmux select-window -t 0
tmux rename-window naive
tmux send-keys "vi src/main/scala/org/indyscala/typeclasses/naive/Pretty.scala" C-m

tmux attach -t typeclasses
