(ns msg-http.service.message
  (:require [msg-http.resource.database :as db]
            [clj-time.local :as l]))

(defrecord Msg
  [sender recipient date text])

(defrecord MsgConnect [sender recipient text])

(defn save
  [msg]
  (db/save
    (Msg.
      (:sender msg)
      (:recipient msg)
      (l/local-now)
      (:text msg))))

(defn get-by-recipient
  [recipient]
  nil)