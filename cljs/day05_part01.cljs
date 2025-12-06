(ns solutions.day05-part01
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn solve []
  (let [lines (read-lines *input-file*)
        empty-idx (.indexOf lines "")
        range-lines (take empty-idx lines)
        number-lines (drop (inc empty-idx) lines)
        ranges (map (fn [line]
                      (let [[start end] (map js/parseInt (str/split line #"-"))]
                        {:start start :end end}))
                    range-lines)
        numbers (map js/parseInt number-lines)
        count (reduce
               (fn [cnt num]
                 (if (some #(and (>= num (:start %)) (<= num (:end %))) ranges)
                   (inc cnt)
                   cnt))
               0
               numbers)]
    (println "answer:")
    (println count)))

(solve)
