(defproject flower/flower-integration-slack "0.5.0"
  :description "Flower integration with Slack"
  :url "http://github.com/FlowerAutomation/flower"
  :scm {:dir ".."}
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :plugins [[org.clojure/core.unify "0.5.7"]
            [jonase/eastwood "0.3.11"]
            [lein-cljfmt "0.5.7"]
            [lein-bump-version "0.1.6"]]
  :cljfmt {:remove-consecutive-blank-lines? false}
  :aliases {"lint" ["do" ["cljfmt" "check"] ["eastwood"]]
            "test-all" ["with-profile" "default:+1.10" "test"]
            "lint-and-test-all" ["do" ["lint"] ["test-all"]]}
  :dependencies [[org.clojure/clojure "1.11.1" :scope "provided"]
                 [org.clojure/core.async "1.5.648"]
                 [org.clojure/data.json "2.4.0"]
                 [org.julienxx/clj-slack "0.6.3"]
                 [stylefruits/gniazdo "1.2.0"]
                 [flower/flower-common "0.5.0"]
                 [flower/flower-proto "0.5.0"]]
  :profiles {:1.10 {:dependencies [[org.clojure/clojure "1.10.1"]]}})
