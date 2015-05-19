(ns magnet.bez2.db
  (:require [magnet.index.db :as index]
            [magnet.book.db :as book]))

(def default-value
  {:active-panel :index
   :title "my title"
   :index index/default-value
   :book book/default-value})
