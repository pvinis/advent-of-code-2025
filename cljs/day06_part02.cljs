(ns solutions.day06-part02
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn find-operator-positions [op-line]
  (->> (keep-indexed
        (fn [i ch]
          (when (or (= ch \+) (= ch \*))
            {:pos i :op ch}))
        op-line)
       vec))

(defn extract-numbers-by-column [data-lines start-col end-col]
  (let [height (count data-lines)]
    (->> (range start-col end-col)
         (keep (fn [x]
                 (let [num-str (->> (range height)
                                    (keep (fn [y]
                                            (let [line (nth data-lines y)]
                                              (when (< x (count line))
                                                (let [ch (nth line x)]
                                                  (when (not= ch \space)
                                                    ch))))))
                                    (apply str))]
                   (when (seq num-str)
                     (js/BigInt (js/parseInt num-str)))))))))

(defn solve []
  (let [lines (read-lines *input-file*)
        op-line-idx (->> (range (count lines))
                         (filter #(or (str/includes? (nth lines %) "+")
                                      (str/includes? (nth lines %) "*")))
                         first)
        op-line (nth lines op-line-idx)
        data-lines (take op-line-idx lines)
        operators (find-operator-positions op-line)
        max-len (apply max (map count data-lines))
        total (->> (range (count operators))
                   (map (fn [i]
                          (let [{:keys [pos op]} (nth operators i)
                                end-col (if (< i (dec (count operators)))
                                          (:pos (nth operators (inc i)))
                                          max-len)
                                nums (extract-numbers-by-column data-lines pos end-col)]
                            (if (= op \+)
                              (reduce + (js/BigInt 0) nums)
                              (reduce * (js/BigInt 1) nums)))))
                   (reduce +))]
    (println "answer:")
    (println (.toString total))))

(solve)
