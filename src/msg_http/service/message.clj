(ns msg-http.service.message)

(defrecord Message
  [key date text])

(defrecord NewMsg
  [recipient])

(defn create
  [new-msg])

(defn save
  [msg]
  nil)

(defn get
  [key amount]
  nil)