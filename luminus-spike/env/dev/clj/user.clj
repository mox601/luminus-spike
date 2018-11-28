(ns user
  (:require [luminus-spike.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [luminus-spike.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'luminus-spike.core/repl-server))

(defn stop []
  (mount/stop-except #'luminus-spike.core/repl-server))

(defn restart []
  (stop)
  (start))


