(ns solutions.day02-part02
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn repeating-pattern? [s]
  (let [len (count s)]
    (->> (range 1 (inc (/ len 2)))
         (some (fn [pattern-len]
                 (when (zero? (mod len pattern-len))
                   (let [pattern (subs s 0 pattern-len)
                         times (/ len pattern-len)]
                     (= s (apply str (repeat times pattern))))))))))

(defn parse-ranges [line]
  (->> (str/split line #",")
       (map (fn [pair]
              (let [[low high] (str/split pair #"-")]
                [(js/parseInt low) (js/parseInt high)])))))

(defn solve []
  (let [lines (read-lines *input-file*)
        ranges (parse-ranges (first lines))
        repeating (for [[low high] ranges
                        n (range low (inc high))
                        :when (repeating-pattern? (str n))]
                    n)
        total (reduce + 0 repeating)]
    (println "answer:")
    (println total)))

(solve)
