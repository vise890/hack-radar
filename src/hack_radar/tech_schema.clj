(ns hack-radar.tech-schema
  (:require [schema.core :as schema]))

(def Tech
     "A tech in the TW radar"
     {:name schema/Str
      :status (schema/enum :adopt :assess :hold :trial)
      :area (schema/enum :techniques :tools :platforms :languages-and-frameworks)
      :url schema/Str})

;; FIXME: move to tests (and make a bit less ridiculous by adding test cases)
(schema/validate Tech {:name "UltraTech"
                       :status :adopt
                       :area :techniques
                       :url "www.foo.com"})
