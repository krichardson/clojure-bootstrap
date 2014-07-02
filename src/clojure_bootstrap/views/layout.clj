(ns clojure-bootstrap.views.layout
  (:use [hiccup.core]
        [hiccup.page])
  (:require [clojure-bootstrap.views.utils :as utils]
            [clojure-bootstrap.config :as config]))

(def nav
  {:home
    {:name "Home" :href "#"}
   :about
    {:name "About" :href "#about"}
   :contact
    {:name "Contact" :href "#contact"}})

(defn nav-with-active
  "Marks a nav element active"
  [nav active-one]
  (println active-one)
  (if (nil? active-one)
    nav
    (assoc-in nav [active-one :active] true)))


(defn layout-head [title]
  [:head
   [:title title]
   (utils/include-css "/css/bootstrap.min.css")
   (utils/include-js "/js/jquery-2.1.1.min.js")
   (utils/include-js "/js/bootstrap.js")
   (utils/inline-css "body { padding-top: 60px; }")])

(defn nav-fixed [links]
  [:div.navbar.navbar-fixed
   [:div.container
    [:div.navbar-header
     [:a.navbar-brand {:href config/SITE-ROOT-PATH} config/SITE-TITLE]
     [:ul.nav.navbar-nav
      (for [key (keys links)]
        (let [link (links key)]
          [:li
           (when (link :active) {:class "active"})
           [:a {:href (link :href)} (link :name)]]))]]]])

(defn layout [title body active-nav]
  (html
   "<!DOCTYPE html>"
   [:html
    (layout-head title)
    [:body
     (nav-fixed (nav-with-active nav active-nav))
     [:div.container body]
     [:footer.footer
      [:div.container
       [:p.pull-right
        [:a {:href "#"} "Back to top"]]
       [:p "Built with Twitter Bootstrap"]]]]]))
