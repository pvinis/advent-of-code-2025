(ns solutions.day06-part01
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn find-columns [line]
  (keep-indexed
   (fn [i ch]
     (when (or (= ch \+) (= ch \*))
       {:start i :op (str ch)}))
   line))

(defn solve []
  (let [lines (read-lines *input-file*)
        op-line-idx (reduce
                     (fn [_ i]
                       (when (or (str/includes? (nth lines i) "+")
                                 (str/includes? (nth lines i) "*"))
                         (reduced i)))
                     nil
                     (range (count lines)))
        last-line (nth lines op-line-idx)
        data-lines (take op-line-idx lines)
        columns (vec (find-columns last-line))
        max-line-len (apply max (map count data-lines))
        total (reduce
               (fn [acc c]
                 (let [{:keys [start op]} (nth columns c)
                       end-col (if (< c (dec (count columns)))
                                 (dec (:start (nth columns (inc c))))
                                 max-line-len)
                       numbers (keep
                                (fn [line]
                                  (when (> (count line) start)
                                    (let [slice (str/trim (subs line start (min end-col (count line))))]
                                      (when (seq slice)
                                        (js/parseInt slice)))))
                                data-lines)
                       result (if (= op "+")
                                (reduce (fn [a n] (+ a (js/BigInt n))) (js/BigInt 0) numbers)
                                (reduce (fn [a n] (* a (js/BigInt n))) (js/BigInt 1) numbers))]
                   (+ acc result)))
               (js/BigInt 0)
               (range (count columns)))]
    (println "answer:")
    (println (.toString total))))

(solve)
