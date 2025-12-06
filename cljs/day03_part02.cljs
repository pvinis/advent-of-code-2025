(ns solutions.day03-part02
  (:require [utils.input :refer [read-lines]]))

(defn find-max-12-digit [line]
  (loop [d 0
         result ""
         start-pos 0
         remaining 12]
    (if (>= d 12)
      result
      (let [[max-digit max-pos]
            (reduce
             (fn [[best-digit best-pos] i]
               (if (> (nth line i) best-digit)
                 [(nth line i) i]
                 [best-digit best-pos]))
             ["" start-pos]
             (range start-pos (inc (- (count line) remaining))))]
        (recur (inc d)
               (str result max-digit)
               (inc max-pos)
               (dec remaining))))))

(defn solve []
  (let [lines (read-lines *input-file*)
        sum (reduce
             (fn [acc line]
               (+ acc (js/BigInt (find-max-12-digit line))))
             (js/BigInt 0)
             lines)]
    (println "answer:")
    (println (.toString sum))))

(solve)
