(ns queueman-being.handlers
    (:require [re-frame.core :as re-frame]
              [queueman-being.db :as db]
              [queueman-being.directions :refer [get-next-symbol]]))

(def timeout-step 50)

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :q-pressed
 (fn  [db _]
   (let [symbol (:symbol db)]
     (js/console.log "Key got pressed")
     (js/console.log symbol)
     (re-frame/dispatch [:start-timeout])
     (update-in db [:symbol-queue] conj symbol))))

(re-frame/reg-event-db
 :start-timeout
 (fn  [db _]
   (if-not (:timeout db)
     (let [timeout 5000]
       (js/setTimeout #(re-frame/dispatch [:decrement-timeout]) timeout-step)
       (assoc db :timeout timeout))
     db)))

(re-frame/reg-event-db
 :decrement-timeout
 (fn  [db _]
   (let [timeout (:timeout db)
         new-timeout (max (- timeout timeout-step) 0)]
     (if (= new-timeout 0)
       (re-frame/dispatch [:stop-timeout])
       (js/setTimeout #(re-frame/dispatch [:decrement-timeout]) timeout-step))
     (assoc db :timeout new-timeout))))


(re-frame/reg-event-db
 :stop-timeout
 (fn  [db _]
   (js/console.log (str (:symbol-queue db)))
   (-> db
       (assoc :symbol (get-next-symbol))
       (assoc :symbol-queue [])
       (assoc :timeout nil))))
