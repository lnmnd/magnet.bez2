(ns magnet.bez2.handlers
  (:require [re-frame.core :refer [register-handler]]))

(register-handler
 :init
 (fn [db]
   {:active-panel :index
    :title "my title"
    :index {:loading false
            :books []}}))

(register-handler
 :set-active-panel
 (fn [db [_ panel]]
   (assoc-in db [:active-panel] panel)))
