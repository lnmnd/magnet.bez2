(ns magnet.bez2.views
  (:require [re-frame.core :as re-frame :refer [subscribe dispatch]]))

(defn current-page []
  (let [title (subscribe [:title])
        loading (subscribe [:loading])
        books (subscribe [:books])]
    (fn []
      [:div
       [:div [:h2 @title]]
       (when @loading
         [:p "Loading..."])
       [:ul (for [book @books]
              ^{:key (:id book)}
              [:li (:titulua book)])]])))
