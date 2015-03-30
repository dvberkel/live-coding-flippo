(ns demo.introduction)

;; An short introduction to clojure
; this is a comment

; clojure expressions have the following form
; (function argument argument argument .... argument)

(+ 1 2)
(* 2 3)
(* 2 (+ 1 2))

; there is syntactic sugar
[1 2 3 4]      ; for arrays
{ "a" 1 "b" 2} ; for maps

; def binds a variable
(def a 2)

; that can be used in expressions
(* 3 a)
