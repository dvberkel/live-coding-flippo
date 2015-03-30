(ns demo.transform)

; We can generate structure trees
; We can evaluate abstract syntax trees
; how do we go from on to the other?

(defn map-tree [f tree]
  "Let f operate on all the nodes of the tree"
  (if (nil? tree)
    (f tree nil nil)
    (f tree (map-tree f (:left tree)) (map-tree f (:right tree)))))
