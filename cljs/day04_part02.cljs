(ns solutions.day04-part02
  (:require [utils.input :refer [read-lines]]))

(defn count-neighbors [grid y x]
  (let [height (count grid)
        width (count (nth grid y))]
    (reduce
     (fn [cnt [dy dx]]
       (if (and (= dy 0) (= dx 0))
         cnt
         (let [ny (+ y dy)
               nx (+ x dx)]
           (if (and (>= ny 0) (< ny height)
                    (>= nx 0) (< nx (count (nth grid ny)))
                    (= (nth (nth grid ny) nx) \@))
             (inc cnt)
             cnt))))
     0
     (for [dy (range -1 2) dx (range -1 2)] [dy dx]))))

(defn find-to-remove [grid]
  (for [y (range (count grid))
        x (range (count (nth grid y)))
        :when (and (= (nth (nth grid y) x) \@)
                   (< (count-neighbors grid y x) 4))]
    [y x]))

(defn remove-cells [grid cells]
  (reduce
   (fn [g [y x]]
     (assoc g y (assoc (nth g y) x \.)))
   grid
   cells))

(defn solve []
  (let [lines (read-lines *input-file*)
        grid (vec (map vec lines))]
    (loop [g grid
           total 0]
      (let [to-remove (find-to-remove g)]
        (if (empty? to-remove)
          (do
            (println "answer:")
            (println total))
          (recur (remove-cells g to-remove)
                 (+ total (count to-remove))))))))

(solve)
