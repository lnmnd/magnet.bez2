(ns magnet.index.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [register-sub]]))

(register-sub
 :index/title
 (fn [db]
   (reaction (:title @db))))

(register-sub
 :index/loading
 (fn [db]
   (reaction (:loading @db))))

(register-sub
 :index/books
 (fn [db]
   (let [books (reaction (:books @db))]
     (reaction (sort :id @books)))))
