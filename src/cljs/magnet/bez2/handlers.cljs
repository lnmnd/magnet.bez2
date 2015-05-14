(ns magnet.bez2.handlers
  (:require [re-frame.core :refer [register-handler dispatch]]
            [ajax.core :refer [GET]]))

(register-handler
 :init
 (fn [db]
   {:title "my title"
    :loading false
    :books []}))

(register-handler
 :request-books
 (fn [db]
   (GET
    "http://localhost:3000/v1/liburuak"
    {:response-format :json
     :keywords? true
     :handler #(dispatch [:process-books %])
     :error-handler #(println "do nothing")})
   (assoc-in db [:loading] true)))

(register-handler
 :process-books
 (fn [db [_ res]]
   (-> db
       (assoc-in [:loading] false)
       (assoc-in [:books] (:liburuak res)))))
