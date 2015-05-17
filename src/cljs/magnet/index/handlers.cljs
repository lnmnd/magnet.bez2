(ns magnet.index.handlers
  (:require [re-frame.core :refer [register-handler dispatch]]
            [ajax.core :refer [GET]]))

(register-handler
 :index/request-books
 (fn [db]
   (GET
    "http://localhost:3000/v1/liburuak"
    {:response-format :json
     :keywords? true
     :handler #(dispatch [:index/process-books %])
     :error-handler #(println "do nothing")})
   (assoc-in db [:index :loading] true)))

(register-handler
 :index/process-books
 (fn [db [_ res]]
   (-> db
       (assoc-in [:index :loading] false)
       (assoc-in [:index :books] (:liburuak res)))))
