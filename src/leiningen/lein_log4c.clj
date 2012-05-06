(ns leiningen.lein-log4c
  (:require [leiningen.compile :only [eval-in-project]]
            [robert.hooke :as hook]))

(defn lein-log4c [eip project form & [handler skip-auto-compile init]]
  (let [form `(do (log4c.core/configure-log-levels!)
                  ~form)
        init `(do (require 'log4c.core)
                  ~init)]
    (eip project form handler skip-auto-compile init)))

(hook/add-hook #'leiningen.compile/eval-in-project lein-log4c)