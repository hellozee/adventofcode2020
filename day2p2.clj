(defn parse-int [s]
     (Integer. (re-find  #"\d+" s )))

(defn split [string]
  (clojure.string/split string #""))

(defn split-space [string]
  (clojure.string/split string #" "))

(defn split-hyphen [string]
  (clojure.string/split string #"-"))

(defn xor [p q]
  (and (or p q) (not (and p q))))

(defn count-letters [{:keys [password low high letter]}]
  (xor (= letter (nth password low)) (= letter (nth password high))))

(defn parse-pass [pass] 
  (let [words (split-space pass)] 
    {
      :password (split (last words))
      :low (- (parse-int (first (split-hyphen (first words)))) 1)
      :high (- (parse-int (last (split-hyphen (first words)))) 1)
      :letter (first (split (second words)))
      }))

(defn correct-pass [password-vector]
  (case password-vector
    [] 0
    (if (count-letters (parse-pass (first password-vector)))
      (+ (correct-pass (rest password-vector)) 1)
      (correct-pass (rest password-vector)))))

(defn main []
  (println (correct-pass (clojure.string/split-lines (slurp "day2.in")))))

(main)

