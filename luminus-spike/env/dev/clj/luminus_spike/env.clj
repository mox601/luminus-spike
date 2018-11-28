(ns luminus-spike.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [luminus-spike.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[luminus-spike started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[luminus-spike has shut down successfully]=-"))
   :middleware wrap-dev})
