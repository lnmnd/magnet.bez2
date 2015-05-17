(ns magnet.book.handlers
  (:require [re-frame.core :refer [register-handler dispatch]]
            [ajax.core :refer [GET]]))

(defn- liburua->book [x]
  {:title (:titulua x)
   :magnet (:magnet x)
   :authors (:egileak x)
   :language (:hizkuntza x)
   :user (:erabiltzailea x)
   :date (:igotze_data x)
   :synopsis (:sinopsia x)})

(register-handler
 :book/request-book
 (fn [db [_ id]]
   (GET
    (str "http://localhost:3000/v1/liburuak/" id)
    {:response-format :json
     :keywords? true
     :handler #(dispatch [:book/process-book %])
     :error-handler #(println "do nothing")})
   (assoc-in db [:book :loading] true)))

(register-handler
 :book/process-book
 (fn [db [_ res]]
   (-> db
       (assoc-in [:book :loading] false)
       (assoc-in [:book :book] (liburua->book (:liburua res))))))
