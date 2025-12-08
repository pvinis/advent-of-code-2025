(ns solutions.day01-part02
  (:require [utils.input :refer [read-lines]]))

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
           (if (= dir \R)
             (let [new-dial (mod (+ dial amount) 100)
                   crossings (quot (+ dial amount) 100)]
               {:dial new-dial :count (+ count crossings)})
             (let [reversed (mod (- 100 dial) 100)
                   crossings (quot (+ reversed amount) 100)
                   new-dial (mod (+ (- 100 reversed amount) 100) 100)]
               {:dial new-dial :count (+ count crossings)})))
         {:dial 50 :count 0}
         instructions)]
    (println "answer:")
    (println count)))

(solve)
