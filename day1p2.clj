; copied from https://stackoverflow.com/questions/5621279/in-clojure-how-can-i-convert-a-string-to-a-number
(defn parse-int [s]
     (Integer. (re-find  #"\d+" s )))

(defn getvec [string] 
  (vec (map parse-int (clojure.string/split-lines string))))


(defn main []
  (println (remove nil?(let [input (getvec (slurp "day1p2.in"))]
    (for [x input y input z input] 
      (if (= 2020 (+ x y z))
             (* x y z)))))))

(main)
