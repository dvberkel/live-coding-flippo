(defproject demo "0.1.0-SNAPSHOT"
  :description "Live coding flippo"
  :url "https://github.com/dvberkel/live-coding-flippo"
  :license {:name "The MIT License (MIT)"
            :url "https://github.com/dvberkel/live-coding-flippo/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/math.combinatorics "0.0.8"]]
  :main ^:skip-aot demo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
