(defproject com.hotelicopter/lein-log4c "lein-version"
  :description "A Leiningen plugin to configure the log4j configuration"
  :dependencies [[org.clojure/clojure "[1.2.1,1.3.0]"]]
  :repositories {"releases" ~(str user/local-maven-clone "/releases")
                 "snapshots" ~(str user/local-maven-clone "/snapshots")
                 "hotelicopter_snapshots" "https://raw.github.com/g1nn13/maven/master/snapshots"
                 "hotelicopter_releases" "https://raw.github.com/g1nn13/maven/master/releases"}
  :hooks [leiningen.v])