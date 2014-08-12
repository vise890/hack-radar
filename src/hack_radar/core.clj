(ns hack-radar.core
  (:require [hack-radar.db.tech]
            [compojure.route :as route]
            [compojure.core :refer :all]
            [cheshire.core :refer :all]))

(defroutes app
  (GET "/" [] "hello")
  (route/not-found "<h1>Page not found</h1>"))
