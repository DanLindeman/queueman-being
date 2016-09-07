(ns queueman-being.db
  (:require [queueman-being.directions :refer [get-next-symbol]]))

(def default-db
  {:name "re-frame"
   :timeout nil
   :symbol-queue []
   :symbol (get-next-symbol)})
