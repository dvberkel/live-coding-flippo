(ns demo.tree)

; Lets generate all tree structures.
; 1. nil is a tree; leaf
; 2. if L and R are trees, so is { :left L :right R }

; some examples of trees
nil
{:left nil :right nil}
{:left {:left nil :righ :nil} :right nil}

; keys are accessor functions for maps
(:right {:left nil :right {:left nil :right nil}})


(defn adjoin [tree part]
  "Return a sequence of trees where each leave of tree is replaced once with part"
  (if (nil? tree)
    (seq [part])
    (concat
     (map (fn [t] {:left t :right (:right tree)}) (adjoin (:left tree) part))
     (map (fn [t] {:left (:left tree) :right t}) (adjoin (:right tree) part)))))

; some examples of the adjoin function
(adjoin nil {:left nil :right nil})
(adjoin
 {:left nil :right nil}
 {:left nil :right nil})
