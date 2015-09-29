(defproject com.hotelicopter/lein-log4c :lein-v
  :description "A Leiningen plugin to configure the log4j configuration"
  :url "https://github.com/roomkey/lein-log4c"
  :license {:name "None"
            :distribution :manual
            :comments "All rights reserved"}
  :plugins [[com.roomkey/lein-v "5.0.0"]]
  :min-lein-version "2.5.1"
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :repositories {"rk-public" {:url "http://rk-maven-public.s3-website-us-east-1.amazonaws.com/releases/"}
                 "releases" {:url "s3://rk-maven/releases/"}}
  :release-tasks [["vcs" "assert-committed"]
                  ["v" "update"] ;; compute new version & tag it
                  ["vcs" "push"]
                  ["deploy"]]
  :profiles {:dev {:resource-paths ["test-resources"]
                   :dependencies [[midje "1.7.0"]]}}
  :eval-in-leiningen true)
