(ns etl)
(require '[clojure.string :as str])

(defn transform [source] ;; <- arglist goes here
  ;; your code goes here
  (into {} (for [[k v] source] (into {} (for [w v] {(str/lower-case w) k})))))