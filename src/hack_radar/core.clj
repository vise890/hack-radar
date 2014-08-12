(ns hack-radar.core
  (:require [cheshire.core :as json]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [hack-radar.db.tech :refer [get-all-techs]]))

(defn- json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defroutes app
  (GET "/" [] (json-response (get-all-techs)))
  (route/not-found "<h1>Page not found</h1>"))
