(ns solutions.day07-part02
  (:require [utils.input :refer [read-lines]]))

(defn get-cell [lines y x]
  (get-in lines [y x]))

(defn should-count? [lines y x]
  (loop [scan-y (dec y)]
    (when (>= scan-y 0)
      (let [left (or (get-cell lines scan-y (dec x)) \.)
            mid (get-cell lines scan-y x)
            right (or (get-cell lines scan-y (inc x)) \.)]
        (cond
          (= mid \^) false
          (= mid \S) true
          (or (= left \^) (= right \^)) true
          :else (recur (dec scan-y)))))))

(defn find-s [lines]
  (first (for [y (range (count lines))
               x (range (count (nth lines y)))
               :when (= (get-cell lines y x) \S)]
           [y x])))

(defn solve []
  (let [lines (mapv vec (read-lines *input-file*))
        valid-carets (->> (for [y (range (count lines))
                                x (range (count (nth lines y)))
                                :when (= (get-cell lines y x) \^)
                                :when (should-count? lines y x)]
                            [y x])
                          set)
        [s-y s-x] (find-s lines)
        height (count lines)
        final-paths
        (loop [y (inc s-y)
               paths {s-x (js/BigInt 1)}]
          (if (>= y height)
            paths
            (recur (inc y)
                   (reduce-kv
                    (fn [acc x cnt]
                      (if (valid-carets [y x])
                        (-> acc
                            (update (dec x) #(+ (or % (js/BigInt 0)) cnt))
                            (update (inc x) #(+ (or % (js/BigInt 0)) cnt)))
                        (update acc x #(+ (or % (js/BigInt 0)) cnt))))
                    {}
                    paths))))
        total (reduce + (js/BigInt 0) (vals final-paths))]
    (println "answer:")
    (println (.toString total))))

(solve)
