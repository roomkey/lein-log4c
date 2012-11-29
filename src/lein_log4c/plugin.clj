(ns lein-log4c.plugin
  (:require [leiningen.compile :only [eval-in-project]]
            [leiningen.log4c]
            [robert.hooke]))

(defn hooks []
  (robert.hooke/add-hook #'leiningen.core.eval/eval-in-project leiningen.log4c/log4c))

(defn middleware [project]
  (update-in project [:profiles :dev :dependencies]
             (fn [deps]
               ;; It appears that leiningen handles duplicates reasonably
               (conj (or deps []) ['com.hotelicopter/log4c "1.2.2"]))))