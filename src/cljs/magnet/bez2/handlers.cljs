(ns magnet.bez2.handlers
  (:require [re-frame.core :refer [register-handler]]))

(register-handler
 :init
 (fn [db]
   {:active-panel :index
    :title "my title"
    :index {:loading false
            :books []}}))
