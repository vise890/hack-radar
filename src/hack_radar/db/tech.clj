(ns hack-radar.db.tech
  (:require [schema.core :as schema]))

(def Tech
     "A tech in the TW radar"
     {:name schema/Str
      :status (schema/enum :adopt :assess :hold :trial)
      :area (schema/enum :techniques :tools :platforms :languages-and-frameworks)
      :url schema/Str})
