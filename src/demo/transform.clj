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

(defn decorate [operators values tree]
  "Transforms a structured tree into a tree ready for evaluation. It walks the tree
   and transform nil nodes into value-nodes, and non-nil nodes into operator nodes.
   This is done in a cyclic fashion, both for the operators and the values."
  (let [
        operator-generator (generator operators)
        value-generator    (generator values)
        transformer        (fn [tree left right]
                             (if (nil? tree)
                               {:value (value-generator)}
                               {:operator (operator-generator) :left left :right right}))]
    (map-tree transformer tree)))

; a decorate example
(decorate
 [+ -]
 [1 2 3]
 {:left nil :right {:left nil :right nil}})
