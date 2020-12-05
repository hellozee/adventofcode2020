; copied from https://stackoverflow.com/questions/5621279/in-clojure-how-can-i-convert-a-string-to-a-number
(defn parse-int [s]
     (Integer. (re-find  #"\d+" s )))

(defn getvec [string] 
  (vec (map parse-int (clojure.string/split-lines string))))

(defn get-ans [sorted-vec] 
  (if (= 2020 (+ (first sorted-vec) (last sorted-vec)))
    (* (first sorted-vec) (last sorted-vec))
    (if (< (+ (first sorted-vec) (last sorted-vec)) 2020)
      (get-ans (rest sorted-vec))
      (get-ans (drop-last sorted-vec)))))

(defn main [] 
  (println (get-ans (sort (getvec (slurp "day1.in"))))))

(main)
