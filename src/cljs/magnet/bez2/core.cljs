(ns magnet.bez2.core
  (:require [reagent.core :as reagent :refer [atom]]
            [re-frame.core :as re-frame :refer [dispatch]]
            [magnet.bez2.handlers]
            [magnet.index.handlers]
            [magnet.index.subs]
            [magnet.index.views :refer [current-page]]))

;; -------------------------
;; Initialize app
(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (dispatch [:init])
  (dispatch [:index/request-books])
  (mount-root))
