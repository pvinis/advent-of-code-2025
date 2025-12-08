(ns solutions.day03-part01
  (:require [utils.input :refer [read-lines]]))

(defn max-two-digit [line]
  (->> (for [i (range (count line))
             j (range (inc i) (count line))]
         (js/parseInt (str (nth line i) (nth line j))))
       (apply max)))

(defn solve []
  (let [lines (read-lines *input-file*)
        total (->> lines
                   (map max-two-digit)
                   (reduce +))]
    (println "answer:")
    (println total)))

(solve)
