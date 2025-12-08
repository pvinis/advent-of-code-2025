(ns solutions.day05-part02
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn parse-input [lines]
  (let [empty-idx (.indexOf lines "")
        range-lines (take empty-idx lines)]
    (->> range-lines
         (map (fn [line]
                (let [[s e] (str/split line #"-")]
                  [(js/parseInt s) (js/parseInt e)]))))))

(defn merge-ranges [ranges]
  (let [sorted (sort-by first ranges)]
    (reduce
     (fn [acc [start end]]
       (if (empty? acc)
         [[start end]]
         (let [[last-start last-end] (peek acc)]
           (if (<= start (inc last-end))
             (conj (pop acc) [last-start (max last-end end)])
             (conj acc [start end])))))
     []
     sorted)))

(defn solve []
  (let [lines (read-lines *input-file*)
        ranges (parse-input lines)
        merged (merge-ranges ranges)
        total (->> merged
                   (map (fn [[s e]] (inc (- e s))))
                   (reduce +))]
    (println "answer:")
    (println total)))

(solve)
