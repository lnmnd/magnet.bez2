(ns magnet.bez2.handlers
  (:require [re-frame.core :refer [register-handler]]
            [ajax.core :refer [GET]]))

(register-handler
 :init
 (fn [db]
   {:title "my title"}))
