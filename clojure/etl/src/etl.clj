(ns etl)
(require '[clojure.string :as str])

(defn transform [source] ;; <- arglist goes here
  ;; your code goes here
(map (fn [[key value]] (merge (map (fn [word] (hash-map (str/lower-case word) key)) value))) source)
  )

(transform {1 ["APPLE" "ARTICHOKE"], 2 ["BOAT" "BALLERINA"]})