(ns hack-radar.core
  (:require [cheshire.core :as json]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [hack-radar.db.tech :refer [get-all-techs get-techs]]))

(defn- json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defroutes app
  (GET "/" [] (json-response (get-all-techs)))
  (GET "/:area" [area] (json-response (get-techs {:area area})))
  (GET "/on/:status" [status] (json-response (get-techs {:status status})))
  (GET "/:area/:status" [area status] (json-response (get-techs {:area area, :status status})))
  (route/not-found "<h1>Page not found</h1>"))
