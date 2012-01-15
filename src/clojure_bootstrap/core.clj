(ns clojure-bootstrap.core
  (:use [compojure.core])
  (:require [ring.adapter.jetty :as ring]
            [compojure.route :as route]
            [compojure.handler :as handler]))

(defroutes main-routes
  (GET "/" [] "<h2>Hello World</h2>")
  (route/files "/" {:root "public"})
  (route/not-found "Page not found"))

(defn start []
  (ring/run-jetty main-routes {:port 8080 :join? false}))
