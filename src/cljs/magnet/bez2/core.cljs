(ns magnet.bez2.core
    (:require [reagent.core :as reagent :refer [atom]]))

;; -------------------------
;; Views

(defn current-page []
  [:div
   [:div [:h2 "Welcome to magnet.bez2"]]])

;; -------------------------
;; Initialize app
(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
