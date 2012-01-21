(ns clojure-bootstrap.core
  (:use [compojure.core])
  (:require [ring.adapter.jetty :as ring]
            (compojure
              [route :as route]
              [handler :as handler])
            (clojure-bootstrap.views
              [index :as index])))

(defroutes main-routes
  (GET "/" [] (index/view-index))
  (route/files "/" {:root "public"})
  (route/not-found "Page not found"))

(def app
  (handler/site main-routes))

;(defn start []
;  (ring/run-jetty main-routes {:port 8080 :join? false}))
