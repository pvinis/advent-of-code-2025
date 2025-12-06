(ns solve
  (:require [nbb.core :refer [load-string]]
            ["fs" :as fs]
            [clojure.string :as str]))

(defn pad-start [s len char]
  (let [pad-len (- len (count s))]
    (if (pos? pad-len)
      (str (apply str (repeat pad-len char)) s)
      s)))

(def cli-args
  (let [args (js->clj js/process.argv)]
    (drop-while #(not (re-find #"solve\.cljs$" %)) args)))

(defn -main []
  (let [args (vec (rest cli-args))
        day (some-> (get args 0) (pad-start 2 "0"))
        part (some-> (get args 1) (pad-start 2 "0"))
        input-type (get args 2)]

    (when (or (nil? day) (nil? part) (nil? input-type))
      (println "Usage: bun solve:cljs <day> <part> <input>")
      (println "Example: bun solve:cljs 01 1 test")
      (js/process.exit 1))

    (let [input-file (if (= input-type "test") "test.txt" "input.txt")
          input-path (str "input/" day "/" input-file)
          solution-file (str "cljs/day" day "_part" part ".cljs")
          solution-code (fs/readFileSync solution-file "utf8")
          modified-code (str/replace solution-code
                                     #"\(read-lines \*input-file\*\)"
                                     (str "(read-lines \"" input-path "\")"))]
      (load-string modified-code))))

(-main)
