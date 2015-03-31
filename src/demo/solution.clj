(ns demo.solution
  (:use [demo.tree :only [generate-structure-tree]])
  (:use [demo.transform :only [decorate]])
  (:use [demo.evaluate :only [save-evaluate]]))

; Putting it all together
