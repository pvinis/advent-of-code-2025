(ns solutions.day04-part01
  (:require [utils.input :refer [read-lines]]))

(def diagonal-offsets
  [[-1 -1] [-1 0] [-1 1]
   [0 -1]         [0 1]
   [1 -1]  [1 0]  [1 1]])

(defn get-cell [grid y x]
  (when (and (>= y 0) (< y (count grid))
             (>= x 0) (< x (count (nth grid y))))
    (nth (nth grid y) x)))

(defn count-diagonal-neighbors [grid y x]
  (->> diagonal-offsets
       (filter (fn [[dy dx]]
                 (= (get-cell grid (+ y dy) (+ x dx)) \@)))
       count))

(defn solve []
  (let [lines (read-lines *input-file*)
        boundary-count
        (->> (for [y (range (count lines))
                   x (range (count (nth lines y)))
                   :when (= (nth (nth lines y) x) \@)
                   :when (< (count-diagonal-neighbors lines y x) 4)]
               1)
             count)]
    (println "answer:")
    (println boundary-count)))

(solve)
