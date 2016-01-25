(ns lein-log4c.plugin
  (:require [leiningen.core.eval]
            [leiningen.core.project :as project]
            [robert.hooke]))

(def log4c-profile {:dependencies [['com.hotelicopter/log4c "3.0.0"]]})

(defn- configure-logging [eip project form & [init]]
  (let [profile (or (:log4c (:profiles project)) log4c-profile)
        project (project/merge-profiles project [profile])
        form `(do (log4c.core/init!)
                  (log4c.core/configure! :CLJ_LOG_LEVEL)
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
