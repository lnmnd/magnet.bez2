(ns magnet.bez2.prod
  (:require [magnet.bez2.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
