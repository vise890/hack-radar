(ns hack-radar.db.tech
  (:require [hack-radar.db.core :refer [coll db]]
            [monger.collection :as mc]
            [schema.core :as schema]))

(def Tech
     "A tech in the TW radar"
     {:name schema/Str
      :status (schema/enum :adopt :assess :hold :trial)
      :area (schema/enum :techniques :tools :platforms :languages-and-frameworks)
      :url schema/Str})

(defn remove-id [db-tech]
  (dissoc db-tech :_id))

(defn get-techs [query]
  (map remove-id (mc/find-maps db coll query)))

(defn get-all-techs []
  (get-techs {}))

