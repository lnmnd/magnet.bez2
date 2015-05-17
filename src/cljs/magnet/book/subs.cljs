(ns magnet.book.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [register-sub]]))

(register-sub
 :book/loading
 (fn [db]
   (let [book (reaction (:book @db))]
     (reaction (:loading @book)))))

(register-sub
 :book/book
 (fn [db]
   (let [book (reaction (:book @db))]
     (reaction (:book @book)))))

