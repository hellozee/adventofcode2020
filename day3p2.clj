(defn get-vec [string] 
  (clojure.string/split-lines string))

(defn count-trees [area-vec pos right]
  (case area-vec
    [] 0
    (if (= \# (nth (first area-vec) pos))
      (+ (count-trees (rest area-vec) (mod (+ pos right) (count (first area-vec))) right) 1)
      (count-trees (rest area-vec) (mod (+ pos right) (count (first area-vec))) right))))

(defn count-treesd [area-vec pos]
  (case area-vec
    [] 0
    (if (= \# (nth (first area-vec) pos))
      (+ (count-treesd (nthrest area-vec 2) (mod (+ pos 1) (count (first area-vec)))) 1)
      (count-treesd (nthrest area-vec 2) (mod (+ pos 1) (count (first area-vec)))))))

(defn main [] 
  (let [area-vec (get-vec (slurp "day3.in"))]
    (println (* (count-trees area-vec 0 1)
                (count-trees area-vec 0 3)
                (count-trees area-vec 0 5)
                (count-trees area-vec 0 7)
                (count-treesd area-vec 0)))))

(main)
