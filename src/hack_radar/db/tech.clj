(ns hack-radar.db.tech
  (:require [hack-radar.db.core :refer [coll db]]
            [monger.collection :as mc]
            [monger.query :as mq]
            [schema.core :as schema]))

(def Tech
     "A tech in the TW radar"
     {:name schema/Str
      :status (schema/enum :adopt :assess :hold :trial)
      :area (schema/enum :techniques :tools :platforms :languages-and-frameworks)
      :date schema/Str
      :url schema/Str})

(defn remove-id [db-tech]
  (dissoc db-tech :_id))

(defn get-techs [query]
  (let [techs (mq/with-collection db coll
                (mq/find query)
                (mq/sort (array-map :date -1)))]
  (map remove-id techs)))

(defn get-all-techs []
  (get-techs {}))

