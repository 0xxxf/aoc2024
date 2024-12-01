(ns first)

(defn list-differences [list1 list2]
  (map #(Math/abs (- %1 %2)) list1 list2))

(defn parse-input [filename]
  (let [content (slurp filename)
        lines (clojure.string/split-lines content)
        parsed-lines (map #(clojure.string/split % #"\s+") lines)]
    [(map #(Integer/parseInt (first %)) parsed-lines)
     (map #(Integer/parseInt (second %)) parsed-lines)]))

(defn part-one [input]
  (let [[raw-left raw-right] (parse-input input)
        left (sort raw-left)
        right (sort raw-right)
        difference (list-differences right left)]
    (println (reduce + difference))))

(defn count-occurences [list1 list2]
  (let [freq-map (frequencies list2)]
    (map #(get freq-map % 0) list1)))

(defn part-two [input]
  (let [[left right] (parse-input input)
        occurs (count-occurences left right)
        left-occurs (map * left occurs)]
    (println (reduce + left-occurs)))
)

(defn run [opts]
  (part-two "inputs/1.txt"))