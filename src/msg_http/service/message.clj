(ns msg-http.service.message
  (:require [msg-http.resource.database :as db]
            [clj-time.local :as l]))

(defrecord Msg
  [key date text])

(defrecord MsgConnect [sender recipient text])

(defn save
  [msg]
  (db/save
    (Msg.
      (concat (:sender msg) (:recipient msg))
      (l/local-now)
      (:text msg)
      )))

(defn get
  [key amount]
  nil)