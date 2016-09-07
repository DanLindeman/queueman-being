(ns queueman-being.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [devtools.core :as devtools]
            [queueman-being.handlers]
            [queueman-being.subs]
            [queueman-being.views :as views]
            [queueman-being.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")
    (devtools/install!)))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (set! (.-onkeydown js/document) #(re-frame/dispatch [:q-pressed]))
  (dev-setup)
  (mount-root))
