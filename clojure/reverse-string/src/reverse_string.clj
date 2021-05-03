(ns reverse-string)

(defn reverse-string [s]
  (into [] (for [x (range (dec (count s)) -1 -1)] (get s x)))
)