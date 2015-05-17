(ns magnet.book.views
  (:require [re-frame.core :as re-frame :refer [dispatch subscribe]]))

(defn book-page []
  (let [loading (subscribe [:book/loading])
        book (subscribe [:book/book])]
    (fn []
      (if @loading
        [:p "Loading..."]
        [:div
         [:h2 (:titulua @book)]
         [:a {:href (:magnet @book)} [:strong "Magnet link"]]
         [:dl
          [:dt "Authors"]
          [:dd (for [x (interpose ", " (:egileak @book))]
                 [:span x])]
          [:dt "Language"]
          [:dd (:hizkuntza @book)]]
          [:dt "User"]
          [:dd (:erabiltzailea @book)]
         [:dt "Date"]
         [:dd (take 10 (:igotze_data @book))]
         [:dt "Synopsis"]
         [:dd (:sinopsia @book)]]))))
