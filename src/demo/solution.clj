(ns demo.solution
  (:use [demo.tree :only [generate-structure-tree]])
  (:use [demo.transform :only [decorate]])
  (:use [demo.evaluate :only [save-evaluate]])
  (:use [clojure.math.combinatorics :only [selections permutations]]))

; Putting it all together
(permutations [1 2 3])
