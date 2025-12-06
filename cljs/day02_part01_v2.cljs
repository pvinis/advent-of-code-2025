(ns solutions.day02-part01-v2
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn double-number? [n]
  (let [s (str n)
        len (count s)]
    (and (even? len)
         (let [half (/ len 2)]
           (= (subs s 0 half) (subs s half))))))

(defn parse-ranges [line]
  (->> (str/split line #",")
       (map (fn [pair]
              (let [[low high] (str/split pair #"-")]
                [(js/parseInt low) (js/parseInt high)])))))

(defn solve []
  (let [lines (read-lines *input-file*)
        ranges (parse-ranges (first lines))
        doubles (for [[low high] ranges
                      n (range low (inc high))
                      :when (double-number? n)]
                  n)
        total (reduce + 0 doubles)]
    (println "answer:")
    (println total)))

(solve)
