(ns demo.tree)

; Lets generate all tree structures.
; 1. nil is a tree; leaf
; 2. if L and R are trees, so is { :left L :right R }

; some examples of trees
nil
{:left nil :right nil}
{:left {:left nil :righ :nil} :right nil}

