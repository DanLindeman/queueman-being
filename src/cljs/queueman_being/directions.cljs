(ns queueman-being.directions)

(def symbols ["^" "V" "<" ">"])

(defn get-next-symbol []
  (rand-nth symbols))
