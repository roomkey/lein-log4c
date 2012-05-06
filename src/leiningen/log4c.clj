(ns leiningen.log4c
  (:require [leiningen.compile :only [eval-in-project]]
            [robert.hooke :as hook]))

(defn log4c [eip project form & [handler skip-auto-compile init]]
  (let [project (if (some #(= 'com.hotelicopter/log4c (first %)) (:dev-dependencies project))
                  project
                  (update-in project [:dev-dependencies] conj ['com.hotelicopter/log4c "1.2.0"]))
        form `(do (clj-logging-config.log4j/set-logger!)
                  (log4c.core/configure-log-levels!)
                  ~form)
        init `(do (require 'log4c.core)
                  (require 'clj-logging-config.log4j)
                  ~init)]
    (eip project form handler skip-auto-compile init)))

(defn activate []
  (hook/add-hook #'leiningen.compile/eval-in-project log4c))

(activate)