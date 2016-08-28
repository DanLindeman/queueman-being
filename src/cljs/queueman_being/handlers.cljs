(ns queueman-being.handlers
    (:require [re-frame.core :as re-frame]
              [queueman-being.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
