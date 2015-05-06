(ns magnet.bez2.views
  (:require [re-frame.core :as re-frame :refer [subscribe dispatch]]))

(defn current-page []
  (let [title (subscribe [:title])]
    (fn []
      [:div
       [:div [:h2 @title]]])))
