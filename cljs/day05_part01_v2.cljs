(ns solutions.day05-part01-v2
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn parse-input [lines]
  (let [empty-idx (.indexOf lines "")
        range-lines (take empty-idx lines)
        id-lines (drop (inc empty-idx) lines)
        ranges (->> range-lines
                    (map (fn [line]
                           (let [[s e] (str/split line #"-")]
                             [(js/parseInt s) (js/parseInt e)]))))
        ids (->> id-lines
                 (map js/parseInt))]
    [ranges ids]))

(defn in-any-range? [ranges n]
  (some (fn [[start end]]
          (and (>= n start) (<= n end)))
        ranges))

(defn solve []
  (let [lines (read-lines *input-file*)
        [ranges ids] (parse-input lines)
        cnt (->> ids
                 (filter #(in-any-range? ranges %))
                 count)]
    (println "answer:")
    (println cnt)))

(solve)
