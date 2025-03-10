(defproject flower/flower-integration-github "0.5.0"
  :description "Flower integration with GitHub"
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
  :repositories {"eclipse-releases" "https://repo.eclipse.org/content/groups/releases/"
                 "egit-releases" "https://repo.eclipse.org/content/repositories/egit-releases/"}
  :dependencies [[org.clojure/clojure "1.11.1" :scope "provided"]
                 [com.google.code.gson/gson "2.9.0"]
                 [org.eclipse.mylyn.github/org.eclipse.egit.github.core "4.9.0.201710071750-r"]
                 [clj-time "0.15.2"]
                 [flower/flower-common "0.5.0"]
                 [flower/flower-proto "0.5.0"]]
  :profiles {:1.10 {:dependencies [[org.clojure/clojure "1.10.1"]]}})
