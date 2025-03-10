# Flower

[![Clojars](https://img.shields.io/clojars/v/flower.svg)](https://clojars.org/flower)
[![MELPA](https://melpa.org/packages/flower-badge.svg)](https://melpa.org/#/flower)
[![Build Status](https://app.travis-ci.com/FlowerAutomation/flower.svg?branch=master)](https://app.travis-ci.com/FlowerAutomation/flower)
[![Dependencies Status](https://versions.deps.co/FlowerAutomation/flower/status.svg)](https://versions.deps.co/FlowerAutomation/flower)

Handles all your issue tracking tools and version control systems for you!

<img src="/images/logo/flower-logo.png" width="200px" height="209px"
    alt="Flower logo" align="right" />

The `Flower` library is a set of common protocols for repositories, task trackers, and messaging
systems that includes integrations with the most common ones like Jira, TFS, GitLab, GitHub, and
Exchange. It may be useful for creating external automation scenarios.

Initially, it was designed to handle all routine operations of the
[PT Application Firewall](https://www.ptsecurity.com/ww-en/products/af/) development team:

* Merge opened interlinked pull requests in different GitLab repositories or servers, once MRs
are marked with 'LGTM', and then close issues in TFS.
* Notify about team members' birthdays.
* Create email requests to the company’s IT Helpdesk in order to give access rights
to new team members.
* Search for current 'In Progress' issues from the CLI.
* And much more.

If you need separate Python libraries with similar functionality, you may visit
[DevOpsHQ](https://github.com/DevOpsHQ).

## Installation

To install, add the following to your project `:dependencies`:

    [flower "0.5.0"]

Or use the [Leiningen](https://leiningen.org/) template to build a new application from scratch:

    lein new flower my-flower-application

To install `Flower` as Emacs package, [set up MELPA](https://melpa.org/#/getting-started) and then do the following:

<kbd>M-x</kbd> package-install <kbd>[RET]</kbd> flower <kbd>[RET]</kbd>

## Usage

This library supports multiple integrations with various systems related to development flow.

So the best way to showcase its potential is to demonstrate how it handles each of them by example.
We will keep adding to the existing examples upon introducing new functionality.

However, there is a certain caveat you should be aware of before we go any further. Any function in
the library may be considered pure (except ones having exclamation marks) only on the top level.
Underlying code implicitly uses cache that may be explicitly cleared by a user after each query
if so needed. To do it, the user needs to rebind `flower.common/*behavior-implicit-cache*` variable
using `flower.macros/without-implicit-cache` macro or call `(function-name-clear-cache!)` where
`function-name` is a function defined with the `flower.macros/public-definition` macro.

### For the impatient

```clj
(require 'flower.tracker.core)

;; Print all opened tasks in our task tracker
(let [url "https://github.com/FlowerAutomation/flower"]
  (doall (map (comp (partial apply println)
                    (juxt :task-type :task-id :task-title))
              (.get-tasks (flower.tracker.core/get-tracker url))))
  nil)
```

### For Emacs users

```lisp
(require 'flower)

;; Each element of `flower-tracker-queries` vector has the following format:
;; * Tracker URL or nil if only query changed
;; * Use tracker without auth if nil or with default auth otherwise - see Flower auth
;; * Tracker query or nil for default query if applicable
(setq flower-tracker-queries [("https://github.com/FlowerAutomation/flower" nil nil)
                              ("https://github.com/melpa/melpa" nil nil)])

(add-hook 'org-mode 'flower-mode)

(global-set-key (kbd "C-c f f") 'flower-list-tasks)
(global-set-key (kbd "C-c f t") 'flower-show-task-info)
```

Activate `Flower` with:

* <kbd>C-c f f</kbd> to view or update the task list for the current query.
* <kbd>C-c f t</kbd> to view information on a specific task.

### For the patient

1. [Task trackers](https://github.com/FlowerAutomation/flower/wiki/1.1.-Task-trackers)
2. [Authentication](https://github.com/FlowerAutomation/flower/wiki/1.2.-Authentication)
3. [Repositories](https://github.com/FlowerAutomation/flower/wiki/1.3.-Repositories)
4. [Messaging](https://github.com/FlowerAutomation/flower/wiki/1.4.-Messaging)

### Videos and articles

1. Article: [Xakep - Useful Functional Approach. Grabbing Mail, Task Trackers and Repositories with Clojure (in Russian)](https://xakep.ru/2018/08/24/clojure-flower/)
2. Video: [Team Leader Meetup - Software Development Automation Panel Discussion (in Russian)](https://youtu.be/y1EJTkuCEmk?t=1714)
3. Video: [Software Development Management Automation using Clojure (in Russian)](https://youtu.be/fZuyfjlZO0o)

## Cookbook

Check out `Flower` recipes in the [Cookbook](https://github.com/FlowerAutomation/flower/wiki/2.-Cookbook):

1. [Emacs](https://github.com/FlowerAutomation/flower/wiki/2.1.-Emacs)
2. [Scenarios](https://github.com/FlowerAutomation/flower/wiki/2.2.-Scenarios)
3. More to be done...

## License

Copyright © 2017-2020 JSC Positive Technologies.

Copyright © 2021-2022 Sergey Sobko <flower@tpg.am>

Distributed under the MIT License. See LICENSE.

All the libraries and systems are licensed and remain the property of their respective owners.
