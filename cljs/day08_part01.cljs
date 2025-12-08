(ns solutions.day08-part01
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn parse-point [line]
  (let [[x y z] (map js/parseInt (str/split line #","))]
    {:x x :y y :z z}))

(defn distance [p1 p2]
  (let [dx (- (:x p1) (:x p2))
        dy (- (:y p1) (:y p2))
        dz (- (:z p1) (:z p2))]
    (js/Math.sqrt (+ (* dx dx) (* dy dy) (* dz dz)))))

(defn make-uf [n]
  {:parent (vec (range n))
   :rank (vec (repeat n 0))})

(defn find-root [uf x]
  (let [parent (:parent uf)]
    (if (= (parent x) x)
      [uf x]
      (let [[uf' root] (find-root uf (parent x))]
        [(assoc-in uf' [:parent x] root) root]))))

(defn union [uf x y]
  (let [[uf1 px] (find-root uf x)
        [uf2 py] (find-root uf1 y)]
    (if (= px py)
      [uf2 false]
      (let [rx (get-in uf2 [:rank px])
            ry (get-in uf2 [:rank py])]
        (cond
          (< rx ry) [(assoc-in uf2 [:parent px] py) true]
          (> rx ry) [(assoc-in uf2 [:parent py] px) true]
          :else [(-> uf2
                     (assoc-in [:parent py] px)
                     (assoc-in [:rank px] (inc rx))) true])))))

(defn solve []
  (let [lines (filter seq (read-lines *input-file*))
        points (mapv parse-point lines)
        n (count points)
        pairs (for [i (range n)
                    j (range (inc i) n)]
                {:i i :j j :dist (distance (points i) (points j))})
        sorted-pairs (sort-by :dist pairs)
        num-connections 1000
        final-uf (reduce
                  (fn [uf {:keys [i j]}]
                    (first (union uf i j)))
                  (make-uf n)
                  (take num-connections sorted-pairs))
        roots (map (fn [i] (second (find-root final-uf i))) (range n))
        sizes (->> roots
                   frequencies
                   vals
                   (sort >))
        answer (* (first sizes) (second sizes) (nth sizes 2))]
    (println "answer:")
    (println answer)))

(solve)
