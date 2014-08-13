(defproject hack-radar "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]

                 [clj-time "0.8.0"]

                 [enlive "1.1.5"]

                 [com.novemberain/monger "2.0.0"]
                 [prismatic/schema "0.2.6"]

                 [cheshire "5.3.1"]
                 [compojure "1.1.8"]]

  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler hack-radar.core/app}
  :main ^:skip-aot hack-radar.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
