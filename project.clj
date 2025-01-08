(defproject org "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :source-paths ["src"]
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/tools.cli "1.0.214"]
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
                 [nrepl "1.3.0"]]
  :plugins [[dev.weavejester/lein-cljfmt "0.12.0"]]
  :profiles {:dev {:resource-paths ["content"]}}
  :repl-options {:init-ns org.core})
