(ns msg-http.resource.database
  (:require [mount :refer [defstate]]
            [qbits.alia :as alia]))

(def cluster (alia/cluster {:contact-points ["localhost"]}))

(defstate session
          :start (alia/connect cluster))


