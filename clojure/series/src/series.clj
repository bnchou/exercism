(ns series)

(defn slices
  ([string length] (slices string length []))
  ([string length vector] (case length
    0 [""]
    (if (< (count string) length)
      vector
      (slices (subs string 1 (count string)) length (conj vector (subs string 0 length)))))))