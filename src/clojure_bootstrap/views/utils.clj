(ns clojure-bootstrap.views.utils
  (:use [hiccup.core]))

(defn include-css
  "creates a css stylesheet link"
  [href]
  [:link {:rel "stylesheet" :href href}])

(defn include-js
  "creates a javascript link"
  [src]
  [:script {:type "text/javascript" :src src}])

(defn inline-js
  "includes inline js"
  [content]
  [:script {:type "text/javascript"} content])

(defn inline-css
  "includes inline css"
  [content]
  [:style {:type "text/css"} content])

(defn summary-block
  "creates a summary block with button to view details"
  [width heading text button-href button-text]
  [:div {:class (str "span" width)}
   [:h2 heading]
   [:p text]
   [:p [:a.btn {:href button-href} button-text]]])
