(ns solutions.day04-part02-v2
  (:require [utils.input :refer [read-lines]]))

(def diagonal-offsets
  [[-1 -1] [-1 0] [-1 1]
   [0 -1]         [0 1]
   [1 -1]  [1 0]  [1 1]])

(defn get-cell [grid y x]
  (when (and (>= y 0) (< y (count grid))
             (>= x 0) (< x (count (nth grid y))))
    (get-in grid [y x])))

(defn count-diagonal-neighbors [grid y x]
  (->> diagonal-offsets
       (filter (fn [[dy dx]]
                 (= (get-cell grid (+ y dy) (+ x dx)) \@)))
       count))

(defn find-removable [grid]
  (for [y (range (count grid))
        x (range (count (nth grid y)))
        :when (= (get-in grid [y x]) \@)
        :when (< (count-diagonal-neighbors grid y x) 4)]
    [y x]))

(defn remove-cells [grid cells]
  (reduce (fn [g [y x]]
            (assoc-in g [y x] \.))
          grid
          cells))

(defn solve []
  (let [lines (read-lines *input-file*)
        grid (mapv vec lines)]
    (loop [g grid
           total 0]
      (let [to-remove (find-removable g)]
        (if (empty? to-remove)
          (do
            (println "answer:")
            (println total))
          (recur (remove-cells g to-remove)
                 (+ total (count to-remove))))))))

(solve)
