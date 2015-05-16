(ns magnet.index.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [register-sub]]))

(register-sub
 :index/loading
 (fn [db]
   (let [index (reaction (:index @db))]
     (reaction (:loading @index)))))

(register-sub
 :index/books
 (fn [db]
   (let [index (reaction (:index @db))
         books (reaction (:books @index))]
     (reaction (sort :id @books)))))
