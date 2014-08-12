(ns hack-radar.scraper
  (:require [clojure.string :as s]
            [schema.core :as schema]
            [net.cgrand.enlive-html :refer :all]
            [hack-radar.tech-schema :refer :all])
  (:import java.net.URL))

(def tech-radar-page
  (-> "http://www.thoughtworks.com/radar/a-z"
      URL.
      html-resource))

;; [] -> [<tech-html>]
(defn- get-tech-htmls []
  (-> tech-radar-page
      (select [:body :div.a-z-links :ul :li.blip])))

(defn- get-url [tech-content]
  (let [slug (-> tech-content
                 (first)
                 (get-in [:attrs :href]))]
       (str "http://www.thoughtworks.com" slug)))

(defn- get-tech-name [tech-content]
    (-> tech-content
        (first)
        (get-in [:content])
        (first)))

(defn- get-status [tech-content]
  (-> tech-content
      (second)
      (:content)
      (second)
      (s/lower-case)
      (keyword)))

(defn- get-area [tech-content]
  (-> tech-content
      (second)
      (get-in [:attrs :class])
      (s/split #" ")
      (second)
      (s/lower-case)
      (keyword)))

;; <tech-html> -> Tech
(defn- techify-html [tech-html]
  (let [tech-content (:content tech-html)
        tech {:name (get-tech-name tech-content)
             :status (get-status tech-content)
             :area (get-area tech-content)
             :url (get-url tech-content)}]
    (schema/validate Tech tech)))

;; [] -> [Tech]
(defn scrape-tw-tech-radar []
  (map techify-html (get-tech-htmls)))

(scrape-tw-tech-radar)
