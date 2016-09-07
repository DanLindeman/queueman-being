(ns queueman-being.views
    (:require [re-frame.core :as re-frame]))

(def x 0)

(defn select-box []
  (let [next-symbol (re-frame/subscribe [:symbol])]
    (fn []
      [:div
       [:div "Current Queue:"]
       [:div {:style {:border "5px solid black"
                      :height "50px"
                      :width "50px"
                      :font-size "xx-large"
                      :text-align "center"}}
        @next-symbol]
       [:div "Time left: " 5000]])))

(defn main-panel []
  (fn []
    [:div
     [select-box]
     [:div {:style {:border "5px solid black"
                    :height "500px"
                    :width "500px"}} ""]]))
