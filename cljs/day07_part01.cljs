(ns solutions.day07-part01
  (:require [utils.input :refer [read-lines]]))

(defn get-cell [lines y x]
  (get-in lines [y x]))

(defn should-count? [lines y x]
  (loop [scan-y (dec y)]
    (when (>= scan-y 0)
      (let [left (or (get-cell lines scan-y (dec x)) \.)
            mid (get-cell lines scan-y x)
            right (or (get-cell lines scan-y (inc x)) \.)]
        (cond
          (= mid \^) false
          (= mid \S) true
          (or (= left \^) (= right \^)) true
          :else (recur (dec scan-y)))))))

(defn solve []
  (let [lines (mapv vec (read-lines *input-file*))
        count (->> (for [y (range (count lines))
                         x (range (count (nth lines y)))
                         :when (= (get-cell lines y x) \^)
                         :when (should-count? lines y x)]
                     1)
                   (reduce +))]
    (println "answer:")
    (println count)))

(solve)
