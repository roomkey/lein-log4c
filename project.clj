(defproject com.hotelicopter/lein-log4c :lein-v
  :description "A Leiningen plugin to configure the log4j configuration"
  :url "https://github.com/g1nn13/lein-log4c"
  :license {:name "None"
            :distribution :manual
            :comments "All rights reserved"}
  :plugins [[s3-wagon-private "1.1.2"]
            [com.roomkey/lein-v "3.3.4"]]
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :repositories {"releases" {:url "s3p://rk-maven/releases/"}}
  :profiles {:dev {:resource-paths ["test-resources"]
                   :dependencies [[midje "1.4.0"]]}}
  :eval-in-leiningen true)