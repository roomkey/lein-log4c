(ns leiningen.test.log4c
  (:use [leiningen.log4c])
  (:use [midje.sweet]))

(future-fact "whatever" (+ 4 5) => 9)