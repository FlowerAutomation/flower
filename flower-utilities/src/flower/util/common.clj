(ns flower.util.common
  (:import [org.jsoup Jsoup]
           [org.jsoup.nodes Document$OutputSettings]
           [org.jsoup.safety Safelist]))


(defn strip-html [html]
  (let [document (Jsoup/parse html)
        not-pretty (.prettyPrint (Document$OutputSettings.) false)]
    (.outputSettings document not-pretty)
    (.append (.select document "br") "\\n")
    (.prepend (.select document "p") "\\n\\n")
    (Jsoup/clean (-> (.html document)
                     (.replaceAll "\\\\n" "\n")
                     (.replaceAll "\\r" ""))
                 ""
                 (Safelist/none)
                 not-pretty)))
