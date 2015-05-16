(ns magnet.index.views
  (:require [re-frame.core :as re-frame :refer [subscribe]]))

(defn current-page []
  (let [title (subscribe [:index/title])
        loading (subscribe [:index/loading])
        books (subscribe [:index/books])]
    (fn []
      [:div
       [:div [:h2 @title]]
       (when @loading
         [:p "Loading..."])
       [:ul (for [book @books]
              ^{:key (:id book)}
              [:li (:titulua book)])]])))
