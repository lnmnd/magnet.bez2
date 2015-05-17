(ns magnet.bez2.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [register-sub]]))

(register-sub
 :active-panel
 (fn [db]
   (reaction (:active-panel @db))))

(register-sub
 :title
 (fn [db]
   (reaction (:title @db))))
