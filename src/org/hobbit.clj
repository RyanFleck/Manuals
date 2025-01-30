(ns org.hobbit
  (:require
    [clojure.string :as s]))

;; Brave Clojure p. 59
;; C-c C-x C-x <RET> - Start Cider

(def asym-hobbit-body-parts
  [{:name "head" :size 3}
   {:name "left-eye" :size 1}
   {:name "left-ear" :size 1}
   {:name "mouth" :size 1}
   {:name "nose" :size 1}
   {:name "neck" :size 2}
   {:name "left-shoulder" :size 3}
   {:name "left-upper-arm" :size 3}
   {:name "chest" :size 10}
   {:name "back" :size 10}
   {:name "left-forearm" :size 3}
   {:name "abdomen" :size 6}
   {:name "left-kidney" :size 1}
   {:name "left-hand" :size 2}
   {:name "left-knee" :size 2}
   {:name "left-thigh" :size 4}
   {:name "left-lower-leg" :size 3}
   {:name "left-achilles" :size 1}
   {:name "left-foot" :size 2}])

(defn matching-part
  "Returns the 'right' part for a left equivalent."
  [part]
  {:name (s/replace (:name part) #"^left-" "right-")
   :size (:size part)})

;; This learning function is on page 60
;; ...and contains a LOT of new stuff for a beginner

;; If you’re new to this kind of programming, this code might take
;; some time to puzzle out. Stick with it! Once you understand what’s
;; happening, you’ll feel like a million bucks! -> P.66

(defn symmetrize-body-parts
  "Given a seq of maps that have a :name and :size, complete the seq."
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]

    (if (empty? remaining-asym-parts) final-body-parts
        ;; This is [first|rest] -> [[part & remaining] remaining-asym-parts]
        (let [[part & remaining] remaining-asym-parts]
          (recur remaining
                 ;; Into conj'es each item.
                 (into final-body-parts
                       ;; Here the 'set' function removes duplicates.
                       (set [part (matching-part part)])))))))

(defn symmetrize-v2 [asym-body-parts]
  (reduce (fn [final-parts part]
            (into final-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(defn hit
  [asym-body-parts]
  (let [sym-parts (symmetrize-v2 asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))


(comment
  (hit asym-hobbit-body-parts)
  (symmetrize-v2 asym-hobbit-body-parts)
  (matching-part {:name "left-ear" :size 4})
  (symmetrize-body-parts asym-hobbit-body-parts)

  (reduce (fn [a b] {:value b :child a}) nil [1 2 3])

  (into '(1 2 3 4) '(3))
  (loop [a 10]
    (when (> a -10)
      (println a)
      (recur (- a 1))))

;; If the number of arguments in 'recur' doesn't match its parent
;; 'loop' then it will throw an error. Cool.

  (loop [i 0
         list []]
    (if (< i 10)
      (recur (+ i 1) (conj list i))
      list))

  (do
    (println "Let's go:")
    (loop [x 10] ;; These things in the loop are like let bindings.
      (when (> x 1)
        (println x)
        (recur (- x 2)))))

;; End of scratchzone
  )
