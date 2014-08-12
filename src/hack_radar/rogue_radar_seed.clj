(ns hack-radar.rogue-radar-seed
  (:require [hack-radar.scraper :as scraper]
            [monger.collection :as mc]
            [monger.core :as mg]))

;;; NOTE: a SQL db would have prb worked as well if not better
;;; NOTE: using h2 would have removed the *massive* dep on mongo, but oh well
;;;       this PJ is for trying new tech out

(def db-name "rougueRadar")
(def coll-name "techs")

(def conn (mg/connect))
(def db (mg/get-db conn db-name))

(defn- drop-db []
  (mg/drop-db conn db-name))

(defn- init-db [techs]
  (do (mc/create db coll-name {})
      (mc/insert-batch db coll-name techs)))

(defn refresh-techs-db []
  (let [techs (scraper/scrape-tw-tech-radar)]
  (do (drop-db)
      (init-db techs))))

(refresh-techs-db)
