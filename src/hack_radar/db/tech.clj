(ns hack-radar.db.tech
  (:require [schema.core :as schema]
            [monger.collection :as mc]
            [hack-radar.db.core :refer [db coll]]))

(def Tech
     "A tech in the TW radar"
     {:name schema/Str
      :status (schema/enum :adopt :assess :hold :trial)
      :area (schema/enum :techniques :tools :platforms :languages-and-frameworks)
      :url schema/Str})

(defn remove-id [db-tech]
  (dissoc db-tech :_id))

(defn get-all-techs []
  (map remove-id (mc/find-maps db coll)))
