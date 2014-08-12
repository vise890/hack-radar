(ns hack-radar.db.seed
  (:require [hack-radar.db.core :as db]
            [hack-radar.scraper :as scraper]
            [monger.collection :as mc]))

(defn refresh-techs-db []
  (let [techs (scraper/scrape-tw-tech-radar)]
       (db/init-db)
       (mc/insert-batch db/db db/coll techs)))

(refresh-techs-db)
