(ns solutions.day01-part01
  (:require [utils.input :refer [read-lines]]
            [clojure.string :as str]))

(defn parse-instruction [line]
  (let [dir (first line)
        amount (js/parseInt (subs line 1))]
    [dir amount]))

(defn solve []
  (let [lines (read-lines *input-file*)
        instructions (map parse-instruction lines)
        {:keys [count]}
        (reduce
         (fn [{:keys [dial count]} [dir amount]]
           (let [new-dial (-> (if (= dir \R)
                                (+ dial amount)
                                (- dial amount))
                              (mod 100)
                              (+ 100)
                              (mod 100))]
             {:dial new-dial
              :count (if (zero? new-dial) (inc count) count)}))
         {:dial 50 :count 0}
         instructions)]
    (println "answer:")
    (println count)))

(solve)
