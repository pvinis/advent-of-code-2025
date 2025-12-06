(ns solutions.day01-part02
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
              [final-dial final-count]
              (loop [i 0 d dial c count]
                (if (>= i num)
                  [d c]
                  (let [new-d (if (= dir \L)
                                (if (zero? d) 99 (dec d))
                                (if (= d 99) 0 (inc d)))
                        new-c (if (zero? new-d) (inc c) c)]
                    (recur (inc i) new-d new-c))))]
          (recur (rest lines) final-dial final-count))))))

(solve)
