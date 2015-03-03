(ns core
  ; (:require [cemerick.friend :as friend]

  ;      (cemerick.friend [workflows :as workflows]

    ;                 [credentials :as creds]))
  )


(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(def db (atom {:count 0 :users {}}))

;;users are now added by name

(defn add-user [{:keys [count users]} name] {:count (inc count) :users (assoc users (first name) (rest name))})
(defn add-user! [name] (swap! db add-user name))

(defn delete-user [{:keys [count users]} name] {:count (dec count) :users (dissoc users name)})
(defn delete-user! [count] (swap! db delete-user count))


;;make a user to admin
; (defn make-admin! [name]
;(let [user (assoc (get (get @db :users) name) "admin" 1)])
;delete-user! name
;add-user! (cons name user))

;
;; this function should be called whenever a user is added
;; (defn check-first,
;;
;;(cond (= 1 (count (keys (get @db :users))))
;;      (let user '(keys (get @db :users)))
;;      make-admin! user
;;)))

