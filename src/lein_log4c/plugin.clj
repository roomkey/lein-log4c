(ns lein-log4c.plugin
  (:require [leiningen.core.eval]
            [robert.hooke]))

(defn- log4c-included? [{dependencies :dependencies}]
  (some (fn [[d _]] (= 'com.hotelicopter/log4c d) ) dependencies))

(defn- ensure-dependency
  [project]
  (if (log4c-included? project)
    project
    (update-in project [:dependencies] concat ,, [['com.hotelicopter/log4c "1.3.2"]])))

(defn- configure-logging [eip project form & [init]]
  (let [project (ensure-dependency project)
        form `(do (log4c.core/init!)
                  (log4c.core/configure-log-levels!)
                  ~form)
        init `(do (require 'log4c.core)
                  ~init)]
    (eip project form init)))

;; We inject the dependency in an eip hook because adding it in
;; middleware is too intrusive (it must be added to the project
;; itself as profiles have already been merged into the project
;; and that would apply to all tasks, not just those that use
;; eval-in-project.).
(defn hooks []
  (robert.hooke/add-hook #'leiningen.core.eval/eval-in-project #'configure-logging))
