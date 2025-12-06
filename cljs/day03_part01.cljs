(ns solutions.day03-part01
  (:require [utils.input :refer [read-lines]]))

(defn solve []
  (let [lines (read-lines *input-file*)
        sum (reduce
             (fn [acc line]
               (let [max-val (reduce
                              (fn [mx i]
                                (reduce
                                 (fn [mx2 j]
                                   (let [num (js/parseInt (str (nth line i) (nth line j)))]
                                     (max mx2 num)))
                                 mx
                                 (range (inc i) (count line))))
                              0
                              (range (count line)))]
                 (+ acc max-val)))
             0
             lines)]
    (println "answer:")
    (println sum)))

(solve)
