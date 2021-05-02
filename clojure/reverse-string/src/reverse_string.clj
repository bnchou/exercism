(ns reverse-string)

(defn reverse-string [s] ;; <- arglist goes here
  ;; your code goes here
  (apply str (for [x (range (dec (count s)) -1 -1)] (get s x)))
)