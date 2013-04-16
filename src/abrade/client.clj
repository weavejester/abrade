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

(defn form
  "Get a form by name."
  [page form-name]
  (.getFormByName page form-name))

(defn input
  "Get an input by name from a form."
  [form input-name]
  (.getInputByName form input-name))

(defn set-value
  "Set the value of an input."
  [input value]
  (.setValueAttribute input value))

(defn click
  "Click the supplied element. Returns a new page object."
  [element]
  (.click element))
