(ns etl)
(require '[clojure.string :as str])

(defn transform [source]
  (into {} (for [[k v] source] (into {} (for [w v] {(str/lower-case w) k})))))