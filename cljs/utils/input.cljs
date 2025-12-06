(ns utils.input
  (:require ["fs" :as fs]
            [clojure.string :as str]))

(defn read-lines [path]
  (-> (fs/readFileSync path "utf8")
      str/trim
      (str/split #"\n")))
