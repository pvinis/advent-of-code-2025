(ns solutions.day05-part02
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn solve []
  (let [lines (read-lines *input-file*)
        empty-idx (.indexOf lines "")
        range-lines (take empty-idx lines)
        ranges (map (fn [line]
                      (let [[start end] (map js/parseInt (str/split line #"-"))]
                        [start end]))
                    range-lines)
        sorted-ranges (sort-by first ranges)
        merged (reduce
                (fn [acc [start end]]
                  (if (empty? acc)
                    [[start end]]
                    (let [[last-start last-end] (last acc)]
                      (if (< last-end (dec start))
                        (conj acc [start end])
                        (conj (vec (butlast acc))
                              [last-start (max last-end end)])))))
                []
                sorted-ranges)
        count (reduce
               (fn [acc [start end]]
                 (+ acc (- end start) 1))
               0
               merged)]
    (println "answer:")
    (println count)))

(solve)
