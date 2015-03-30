(ns demo.evaluate)

; Assume we have an abstract syntax tree
; {:operator + :left {:value 1} :right {:value 2}}
; we want it to evaluate to 3

(defn evaluate [tree]
  "evaluate tree to its value"
  (if (:operator tree)
    ((:operator tree) (evaluate (:left tree)) (evaluate (:right tree)))
    (:value tree)))


