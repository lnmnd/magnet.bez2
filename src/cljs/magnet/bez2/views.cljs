(ns magnet.bez2.views
  (:require [re-frame.core :as re-frame :refer [dispatch subscribe]]
            [magnet.index.views :refer [index-page]]))

(defn current-page []
  (let [active-panel (subscribe [:active-panel])]
    (fn []
      [:div
       [:h1 "magnet bez"]
       [:div
        [:a {:href "#"} "index"]]
       (condp = @active-panel
         :index [index-page])])))
