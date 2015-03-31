(ns demo.solution
  (:use [demo.tree :only [generate-structure-tree]])
  (:use [demo.transform :only [decorate]])
  (:use [demo.evaluate :only [save-evaluate]])
  (:use [clojure.math.combinatorics :only [selections permutations]]))

; Putting it all together
; combinatorics example
(permutations [1 2 3])
(selections [:a :b] 2)

(defn solve
  ([values]
   "Returns all trees that use the standard arithmetic operators to form 24"
   (solve 24 values))
  ([target values]
   "Returns all trees that use the standard arithmetic operators to form target"
   (solve [+ - * /] target values))
  ([operators target values]
   "Returns all trees that use operators to form target"
   (filter #(= target (save-evaluate %))
           (let [nodes (dec (count values))]
             (for [os (selections operators nodes)
                   vs (permutations values)
                   tree (generate-structure-tree nodes)]
               (decorate os vs tree))))))

(defn infix [tree]
  (let [operator-representation {+ "+" - "-" * "*" / "/"}
        subtree (fn [sub]
                  (if (nil? (:operator sub))
                    (infix sub)
                    (str "(" (infix sub) ")")))]
    (if (:value tree)
      (str (:value tree))
      (str (subtree (:left tree))
           (operator-representation (:operator tree))
           (subtree (:right tree))))))

(infix (first (solve [3 3 8 8])))
