(ns queueman-being.views
    (:require [re-frame.core :as re-frame]))

(def x 0)

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div
       [:div "Hello from " @name]
       [:div "This is Dan's code"]
       [:button "Press me!"]])))
