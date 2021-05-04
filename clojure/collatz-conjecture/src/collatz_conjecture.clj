(ns collatz-conjecture)

(defn collatz
  ([num] (if (<= num 0)
           (throw "Argument has to be greater than 0.")
           (collatz num 0)))
  ([num it] (cond
    (= num 1) it
    (even? num) (collatz (/ num 2) (inc it))
    :else (collatz (+ (* num 3) 1) (inc it)))))