(defn parse-int [s]
     (Integer. (re-find  #"\d+" s )))

(defn split [string]
  (clojure.string/split string #""))

(defn split-space [string]
  (clojure.string/split string #" "))

(defn split-hyphen [string]
  (clojure.string/split string #"-"))

(defn count-letters [{:keys [password low high letter]}]
  (<= low (or (get (frequencies password) letter) 0) high ))

(defn parse-pass [pass] 
  (let [words (split-space pass)] 
    {
      :password (split (last words))
      :low (parse-int (first (split-hyphen (first words))))
      :high (parse-int (last (split-hyphen (first words))))
      :letter (first (split (second words)))
      }))

(defn correct-pass [password-vector]
  (case password-vector
    [] 0
    (if (count-letters (parse-pass (first password-vector)))
      (+ (correct-pass (rest password-vector)) 1)
      (correct-pass (rest password-vector)))))

(defn main []
  (println (correct-pass (clojure.string/split-lines (slurp "day2p1.in")))))

(main)

