(defproject com.hotelicopter/lein-log4c :lein-v
  :description "A Leiningen plugin to configure the log4j configuration"
  :url "https://github.com/g1nn13/lein-log4c"
  :license {:name "None"
            :distribution :manual
            :comments "All rights reserved"}
  :plugins [[lein-maven-s3-wagon "0.2.4"]
            [com.roomkey/lein-v "3.3.4"]]
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :repositories {"rk-public" {:url "http://rk-maven-public.s3-website-us-east-1.amazonaws.com/releases/"} "releases" {:url "s3://rk-maven/releases/"}}
  :profiles {:dev {:resource-paths ["test-resources"]
                   :dependencies [[midje "1.4.0"]]}}
  :eval-in-leiningen true)
