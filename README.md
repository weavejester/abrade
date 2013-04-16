# Abrade

A Clojure library for scraping web sites, even ones that heavily rely
on Javascript. The Java [HtmlUnit][1] library is used under the hood.

## Installation

Add the following dependency to your project.clj file:

    [abrade "0.0.2"]

## Usage

```clojure
(use 'abrade.client)

(map text
     (-> (browser :firefox)
         (open "http://bbc.co.uk/news")
         (css "a.story")))
```

## License

Copyright © 2013 James Reeves

Distributed under the Eclipse Public License, the same as Clojure.
