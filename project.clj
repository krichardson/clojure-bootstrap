(defproject clojure-bootstrap "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [compojure "1.0.1"]
                 [ring/ring-jetty-adapter "1.0.1"]
                 [hiccup "0.3.8"]]
  :dev-dependencies [[lein-ring "0.5.4"]]
  :ring {:handler clojure-bootstrap.core/app})