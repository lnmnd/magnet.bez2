(ns magnet.bez2.handlers
  (:require [re-frame.core :refer [register-handler]]))

(register-handler
 :init
 (fn [db]
   {:title "my title"
    :loading false
    :books []}))
