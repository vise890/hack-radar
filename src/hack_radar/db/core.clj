(ns hack-radar.db.core
  (:require [monger.collection :as mc]
            [monger.core :as mg]))

;;; NOTE: a SQL db would have prb worked as well if not better
;;; NOTE: using h2 would have removed the *massive* dep on mongo, but oh well
;;;       this PJ is for trying new tech out

(def db-name "hackRadar")
(def coll "techs")

(def conn (mg/connect))
(def db (mg/get-db conn db-name))

(defn- drop-db []
  (mg/drop-db conn db-name))

(defn init-db []
  (do (drop-db)
      (mc/create db coll {})))
