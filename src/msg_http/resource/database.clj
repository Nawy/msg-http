(ns msg-http.resource.database
  (:require [mount :refer [defstate]]
            [qbits.alia :as alia]))

(def cluster (alia/cluster {:contact-points ["localhost"]}))
(defstate session
          :start (alia/connect cluster))

(def save-statement (alia/prepare session "INSERT INTO messages(sender, recipient, date, text) VALUES(?, ?, ?)"))
(def find-recipient-stat (alia/prepare session "SELECT recipient, sender, date, text FROM messages WHERE recipient=?"))

(defn save
  [msg]
  (alia/execute session save-statement {:values (into [] (vals msg))}))

(defn find-by-recipient
  [recipient]
  (alia/execute sesssion find-recipient-stat {:values [recipient]}))
