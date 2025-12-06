(ns solutions.day02-part01
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn solve []
  (let [lines (read-lines *input-file*)
        input (first lines)
        pairs (str/split input #",")
        doubles (for [pair pairs
                      :let [[low-str high-str] (str/split pair #"-")
                            low (js/parseInt low-str)
                            high (js/parseInt high-str)]
                      :when (not (and (= (count low-str) (count high-str))
                                      (odd? (count low-str))))
                      n (range low (inc high))
                      :let [s (str n)]
                      :when (even? (count s))
                      :let [half (/ (count s) 2)
                            left (subs s 0 half)
                            right (subs s half)]
                      :when (= left right)]
                  n)
        sum (reduce + 0 doubles)]
    (println "answer:")
    (println sum)))

(solve)
