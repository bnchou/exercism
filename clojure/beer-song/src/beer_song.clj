(ns beer-song)
(require '[clojure.string :as string])

(defn verse
  "Returns the nth verse of the song."
  [num] (case num
           2 (str num " bottles of beer on the wall, " num " bottles of beer.\n" 
                          "Take one down and pass it around, " (dec num) " bottle of beer on the wall.\n")
           1 (str num " bottle of beer on the wall, " num " bottle of beer.\n" 
                          "Take it down and pass it around, no more bottles of beer on the wall.\n")
           0 (str "No more bottles of beer on the wall, no more bottles of beer.\n"
                          "Go to the store and buy some more, 99 bottles of beer on the wall.\n")
           (str num " bottles of beer on the wall, " num " bottles of beer.\n"
                "Take one down and pass it around, " (dec num) " bottles of beer on the wall.\n")))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end] (string/join "\n" (map verse (range start (dec end) -1)))))