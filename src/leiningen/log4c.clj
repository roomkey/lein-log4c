(ns leiningen.log4c)

(defn log4c [eip project form init]
  (let [form `(do (try (log4c.core/init!)
                       (log4c.core/configure-log-levels!)
                       (catch Throwable _#))
                  ~form)
        init `(do (try (require 'log4c.core)
                       (catch Throwable _#))
                  ~init)]
    (eip project form init)))