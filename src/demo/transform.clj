(ns demo.transform)

; We can generate structure trees
; We can evaluate abstract syntax trees
; how do we go from on to the other?

(defn map-tree [f tree]
  "Let f operate on all the nodes of the tree"
  (if (nil? tree)
    (f tree nil nil)
    (f tree (map-tree f (:left tree)) (map-tree f (:right tree)))))

; a map-tree example
(map-tree (fn [tree left right]
            (if (nil? tree)
              1
              (+ left right)))
          {:left nil :right nil})

(defn generator [elements]
  "Creates a generator that loops through the vector elements"
  (let [index (atom 0)]
    (fn []
      (let [current-index @index]
        (do
          (swap! index #(mod (inc %) (count elements)))
          (nth elements current-index))))))

; a generator example
(def g (generator [1 2 3]))
(g)
(g)
(g)
(g)
