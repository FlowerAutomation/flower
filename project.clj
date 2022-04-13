(defproject flower "0.5.0"
  :description "Flower is a library for integration with task trackers, repositories, messaging systems and more"
  :url "http://github.com/FlowerAutomation/flower"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :plugins [[org.clojure/core.unify "0.5.7"]
            [jonase/eastwood "0.3.11"]
            [lein-sub "0.3.0"]
            [lein-ancient "0.6.15" :exclusions [[rewrite-clj]]]
            [lein-bump-version "0.1.6"]]
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/core.unify "0.5.7"]
                 [flower/flower-tracker "0.5.0"]
                 [flower/flower-repository "0.5.0"]
                 [flower/flower-messaging "0.5.0"]
                 [flower/flower-team "0.5.0"]
                 [flower/flower-utilities "0.5.0"]
                 [flower/flower-integration-default "0.5.0"]
                 [flower/flower-integration-github "0.5.0"]
                 [flower/flower-integration-gitlab "0.5.0"]
                 [flower/flower-integration-jira "0.5.0"]
                 [flower/flower-integration-tfs "0.5.0"]]
  :aliases {"test" ["do" ["ancient-all"] ["sub" "lint-and-test-all"]]
            "bump-all" ["do" ["bump-version"] ["sub" "bump-version"]]
            "ancient-all" ["do" ["ancient"] ["sub" "ancient"]]
            "deploy-all" ["do" ["sub" "deploy" "clojars"] ["deploy" "clojars"]]}
  :sub ["flower-proto"
        "flower-common"
        "flower-integration-default"
        "flower-integration-github"
        "flower-integration-gitlab"
        "flower-integration-jira"
        "flower-integration-tfs"
        "flower-integration-exchange"
        "flower-integration-slack"
        "flower-tracker"
        "flower-repository"
        "flower-messaging"
        "flower-team"
        "flower-utilities"
        "lein-template"]
  :profiles {:1.10 {:dependencies [[org.clojure/clojure "1.10.1"]]}
             :dev {:dependencies [[org.clojure/tools.namespace "1.2.0"]]}})

