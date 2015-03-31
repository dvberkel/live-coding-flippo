(ns demo.evaluate)

; Assume we have an abstract syntax tree
; {:operator + :left {:value 1} :right {:value 2}}
; we want it to evaluate to 3

(defn evaluate [tree]
  "evaluate tree to its value"
  (if (:operator tree)
    ((:operator tree) (evaluate (:left tree)) (evaluate (:right tree)))
    (:value tree)))

; some examples of evaluate
(evaluate {:value 1})
(evaluate {:operator + :left {:value 1} :right {:value 2}})


; problem with evaluate
;(evaluate {:operator / :left {:value 1} :right {:value 0}})

(defn save-evaluate [tree]
  "safely evaluate tree, return nil on ArithmeticException"
  (try
    (evaluate tree)
    (catch ArithmeticException e nil)))

; and a demonstration
(save-evaluate {:operator / :left {:value 1} :right {:value 0}})
