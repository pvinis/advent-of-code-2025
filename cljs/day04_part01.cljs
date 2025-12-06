(ns solutions.day04-part01
  (:require [utils.input :refer [read-lines]]))

(defn count-neighbors [lines y x]
  (let [height (count lines)
        width (count (nth lines y))]
    (reduce
     (fn [cnt [dy dx]]
       (if (and (= dy 0) (= dx 0))
         cnt
         (let [ny (+ y dy)
               nx (+ x dx)]
           (if (and (>= ny 0) (< ny height)
                    (>= nx 0) (< nx (count (nth lines ny)))
                    (= (nth (nth lines ny) nx) \@))
             (inc cnt)
             cnt))))
     0
     (for [dy (range -1 2) dx (range -1 2)] [dy dx]))))

(defn solve []
  (let [lines (read-lines *input-file*)
        count (reduce
               (fn [cnt y]
                 (reduce
                  (fn [cnt2 x]
                    (if (and (= (nth (nth lines y) x) \@)
                             (< (count-neighbors lines y x) 4))
                      (inc cnt2)
                      cnt2))
                  cnt
                  (range (count (nth lines y)))))
               0
               (range (count lines)))]
    (println "answer:")
    (println count)))

(solve)
