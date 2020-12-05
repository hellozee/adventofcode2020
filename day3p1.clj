(defn get-vec [string] 
  (clojure.string/split-lines string))

(defn count-trees [area-vec pos]
  (case area-vec
    [] 0
    (if (= \# (nth (first area-vec) pos))
      (+ (count-trees (rest area-vec) (mod (+ pos 3) (count (first area-vec)))) 1)
      (count-trees (rest area-vec) (mod (+ pos 3) (count (first area-vec)))))))

(defn main [] 
  (println (count-trees (get-vec (slurp "day3.in")) 0)))

(main)
