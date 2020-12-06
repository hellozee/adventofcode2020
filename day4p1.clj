(def keywords ["byr" "iyr" "eyr" "hgt" "hcl" "ecl" "pid"])


(defn count-correct [passport-vector] 
  (case passport-vector
    [] 0
    (if (every? identity (map #(.contains (first passport-vector) %) keywords))
      (+ (count-correct (rest passport-vector)) 1)
      (count-correct (rest passport-vector)))))

(defn main []
  (println (count-correct (clojure.string/split (slurp "day4.in") #"\n{2}"))))

(main)
