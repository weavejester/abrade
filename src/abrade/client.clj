(ns abrade.client
  (:import [com.gargoylesoftware.htmlunit
            BrowserVersion WebClient]))

(defmulti browser
  "Return a browser object of the specified type."
  identity)

(defmethod browser :firefox [_]
  (WebClient. (BrowserVersion/FIREFOX_17)))

(defmethod browser :chrome [_]
  (WebClient. (BrowserVersion/CHROME)))

(defn open
  "Open a page in the supplied browser."
  [browser url]
  (.getPage browser url))

(defn tag
  "Get the tag name of an element."
  [element]
  (.getTagName element))

(defn attrs
  "Get the attributes of an element."
  [element]
  (->> (.getAttributes element)
       (map #(.getValue %))
       (map #(vector (.getName %) (.getValue %)))
       (into {})))

(defn text
  "Return the text in an element."
  [element]
  (.asText element))

(defn css
  "Get elements in a page by CSS selector."
  [page selector]
  (seq (.querySelectorAll page selector)))
