(ns org.core
  (:require [clj-http.client :as client]
            [clojure.string :as s])
  (:gen-class))

(defn helper [] (println "Hello!"))

(defn get [link] (client/get link))

