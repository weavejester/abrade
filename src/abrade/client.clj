(ns abrade.client
  (:import [com.gargoylesoftware.htmlunit
            BrowserVersion WebClient]))

(defmulti browser
  "Return a browser object of the specified type."
  identity)

(defmethod browser :firefox [_]
  (WebClient. (BrowserVersion/FIREFOX_3_6)))

(defn open
  "Open a page in the supplied browser."
  [browser url]
  (.getPage browser url))

(defn css
  "Get elements in a page by CSS selector."
  [page selector]
  (seq (.querySelectorAll page selector)))

(defn text
  "Return the text in an element."
  [element]
  (.asText element))
