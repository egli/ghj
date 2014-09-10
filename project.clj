(defproject ghj "0.1.0-SNAPSHOT"
  :description "A command line interface to the Github API"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.cli "0.3.1"]
                 [tentacles "0.2.5"]]
  :plugins [[lein-bin "0.3.4"]]
  :bin {:name "ghj"
        :bin-path "~/bin"}
  :main ^:skip-aot ghj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
