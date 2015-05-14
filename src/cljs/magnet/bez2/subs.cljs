(ns magnet.bez2.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [register-sub]]))

(register-sub
 :title
 (fn [db]
   (reaction (:title @db))))

(register-sub
 :loading
 (fn [db]
   (reaction (:loading @db))))

(register-sub
 :books
 (fn [db]
   (reaction (:books @db))))
