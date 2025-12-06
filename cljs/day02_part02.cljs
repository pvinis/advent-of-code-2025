(ns solutions.day02-part02
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn repeating? [s]
  (let [len (count s)]
    (some (fn [pattern-len]
            (when (zero? (mod len pattern-len))
              (let [pattern (subs s 0 pattern-len)
                    repeated (apply str (repeat (/ len pattern-len) pattern))]
                (= repeated s))))
          (range 1 (inc (/ len 2))))))

(defn solve []
  (let [lines (read-lines *input-file*)
        input (first lines)
        pairs (str/split input #",")
        invalids (for [pair pairs
                       :let [[low-str high-str] (str/split pair #"-")
                             low (js/parseInt low-str)
                             high (js/parseInt high-str)]
                       n (range low (inc high))
                       :when (repeating? (str n))]
                   n)
        sum (reduce + 0 invalids)]
    (println "answer:")
    (println sum)))

(solve)
