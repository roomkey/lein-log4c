(ns leiningen.log4c)

(defn- log4c-included? [{dependencies :dependencies}]
  (some (fn [[d v]] (= 'com.hotelicopter/log4c d) ) dependencies))

;; TODO: remove this from list of available tasks
(defn log4c [eip project form & [init]]
  ;; Don't force the issue with tasks that don't include the dev profile
  (if (log4c-included? project)
    (let [form `(do (log4c.core/init!)
                    (log4c.core/configure-log-levels!)
                    ~form)
          init `(do (require 'log4c.core)
                    ~init)]
      (eip project form init))
    (eip project form init)))