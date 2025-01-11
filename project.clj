(defproject org "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://manuals.ryanfleck.ca/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :source-paths ["src" "dev" "content"]
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [org.clojure/tools.cli "1.1.230"]
                 [org.clojure/tools.logging "1.2.4"]
                 [mount "0.1.16"]
                 [cprop "0.1.19"]
                 ;; [bnbeckwith.com/orgmode "0.7.5"]
                 [clojurewerkz/quartzite "2.2.0"]
                 [org.immutant/immutant "2.1.10"]
                 [overtone/at-at "1.3.58"]
                 [clojure.java-time "1.4.2"]
                 [environ "1.2.0"]
                 [clj-http "3.13.0"]
                 [org.clojure/data.json "2.5.0"]
                 [cider/cider-nrepl "0.51.1"]
                 [nrepl "1.3.1"]
                 [markdown-clj "1.11.3"]
                 [org.clojure/core.cache "1.1.234"]
                 [org.clojure/core.memoize "1.1.266"]
                 [org.clojure/core.async "1.6.681"]
                 [clj-soup/clojure-soup "0.1.3"]
                 [hiccup "2.0.0-RC3"]
                 [clojure.java-time "1.4.2"]
                 [org.clj-commons/hickory "0.7.5"]]
  :plugins [[dev.weavejester/lein-cljfmt "0.12.0"]
            [nrepl/lein-nrepl "0.3.2"]]
  :repl-options {:greeting "Ready to hack in clj.org!"
                 :init (do (require 'org.core) (org.core/helper))
                 :init-ns org.core})
