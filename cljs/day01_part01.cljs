(ns solutions.day01-part01
  (:require [utils.input :refer [read-lines]]))

(defn solve []
  (let [lines (read-lines *input-file*)]
    (loop [lines lines
           dial 50
           count 0]
      (if (empty? lines)
        (do
          (println "answer:")
          (println count))
        (let [line (first lines)
              dir (first line)
              num (js/parseInt (subs line 1))
              new-dial (if (= dir \L)
                         (- dial num)
                         (+ dial num))
              normalized (mod (+ (mod new-dial 100) 100) 100)
              new-count (if (zero? normalized) (inc count) count)]
          (recur (rest lines) normalized new-count))))))

(solve)
