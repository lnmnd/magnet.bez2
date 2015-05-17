(ns magnet.book.views
  (:require [re-frame.core :as re-frame :refer [dispatch subscribe]]))

(defn book-page []
  (let [loading (subscribe [:book/loading])]
    (fn []
      (if @loading
        [:p "Loading..."]
        [:div
         [:h2 "book"]
         [:p "todo"]]))))
