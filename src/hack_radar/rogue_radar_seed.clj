(ns hack-radar.rogue-radar-seed
  (:require [hack-radar.scraper :as scraper]
            [hack-radar.db.core :as db]
            [monger.collection :as mc]
            [monger.core :as mg]))

(defn refresh-techs-db []
  (let [techs (scraper/scrape-tw-tech-radar)]
       (db/init-db)
       (mc/insert-batch db/db db/coll-name techs)))

(refresh-techs-db)
