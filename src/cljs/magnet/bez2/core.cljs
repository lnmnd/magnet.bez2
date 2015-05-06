(ns magnet.bez2.core
  (:require-macros [reagent.ratom  :refer [reaction]])
  (:require [reagent.core :as reagent :refer [atom]]
            [re-frame.core :as re-frame :refer [register-handler register-sub subscribe dispatch]]
            [ajax.core :refer [GET]]))

(register-handler
 :init
 (fn [db]
   {:title "my title"}))

(register-sub
 :title
 (fn [db]
   (reaction (:title @db))))

;; -------------------------
;; Views

(defn current-page []
  (let [title (subscribe [:title])]
    (fn []
      [:div
       [:div [:h2 @title]]])))

;; -------------------------
;; Initialize app
(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (dispatch [:init])
  (mount-root))
