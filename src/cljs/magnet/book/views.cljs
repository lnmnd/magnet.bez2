(ns magnet.book.views
  (:require [re-frame.core :as re-frame :refer [dispatch subscribe]]))

(defn book-page []
  (let [loading (subscribe [:book/loading])
        book (subscribe [:book/book])]
    (fn []
      (if @loading
        [:p "Loading..."]
        [:div
         [:h2 (:title @book)]
         [:a {:href (:magnet @book)} [:strong "Magnet link"]]
         [:dl
          [:dt "Authors"]
          [:dd (for [x (interpose ", " (:authors @book))]
                 [:span x])]
          [:dt "Language"]
          [:dd (:language @book)]]
          [:dt "User"]
          [:dd (:user @book)]
         [:dt "Date"]
         [:dd (take 10 (:date @book))]
         [:dt "Synopsis"]
         [:dd (:synopsis @book)]]))))
