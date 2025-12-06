(ns solutions.day03-part02-v2
  (:require [utils.input :refer [read-lines]]))

(defn select-max-n-digits [line n]
  (let [len (count line)
        end (- len n)]
    (loop [pos 0
           remaining n
           result ""]
      (if (zero? remaining)
        result
        (let [search-end (inc (- len remaining))
              [best-char best-pos]
              (reduce (fn [[best-c best-p] i]
                        (if (> (nth line i) best-c)
                          [(nth line i) i]
                          [best-c best-p]))
                      [\0 pos]
                      (range pos search-end))]
          (recur (inc best-pos)
                 (dec remaining)
                 (str result best-char)))))))

(defn solve []
  (let [lines (read-lines *input-file*)
        total (->> lines
                   (map #(js/BigInt (select-max-n-digits % 12)))
                   (reduce +))]
    (println "answer:")
    (println (.toString total))))

(solve)
