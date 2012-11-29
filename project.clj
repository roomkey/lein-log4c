(defproject com.hotelicopter/lein-log4c "lein-v"
  :description "A Leiningen plugin to configure the log4j configuration"
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :repositories {"releases" {:url "s3p://rk-maven/releases/"}}
  :plugins [[s3-wagon-private "1.1.2"]
            [com.roomkey/lein-v "3.1.0"]]
  :eval-in-leiningen true)