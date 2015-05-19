(ns magnet.bez2.handlers
  (:require [re-frame.core :refer [register-handler]]
            [magnet.bez2.db :refer [default-value]]))

(register-handler
 :init
 (fn [db]
   default-value))

(register-handler
 :set-active-panel
 (fn [db [_ panel]]
   (assoc-in db [:active-panel] panel)))
