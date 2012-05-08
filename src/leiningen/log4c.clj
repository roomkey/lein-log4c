(ns leiningen.log4c
  (:require [leiningen.compile :only [eval-in-project]]
            [robert.hooke :as hook]))

(let [addl-deps {'com.hotelicopter/log4c "[1.2.0,2.0)"
                 'log4j/log4j "[1.2.16,2.0)"}]
  (defn log4c [eip project form & [handler skip-auto-compile init]]
    (let [names (set (map first (:dev-dependencies project)))
          ;; Merge dependencies, preserving order and omitting duplicate names
          deps (reduce (fn [m me] (if (names (key me)) m (conj m me))) (:dev-dependencies project) addl-deps)
          project (assoc project :dev-dependencies deps)
          form `(do (alter-var-root (var clojure.tools.logging/*logger-factory*)
                                    (constantly (clojure.tools.logging.impl/log4j-factory)))
                    (clj-logging-config.log4j/set-logger!)
                    (log4c.core/configure-log-levels!)
                    ~form)
          init `(do (require 'clojure.tools.logging)
                    (require 'clojure.tools.logging.impl)
                    (require 'log4c.core)
                    (require 'clj-logging-config.log4j)
                    ~init)]
      (eip project form handler skip-auto-compile init))))

(defn activate []
  (hook/add-hook #'leiningen.compile/eval-in-project log4c))

(activate)