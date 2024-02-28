---
toc: true
draft: true
date: 2024-02-23T17:40:53-07:00
image: "/content-cover-images/coffee-phone.jpg"
summary: "Enterprise scale wizardry."
title: "Clojure"
---

# High-Level Notes

# Luminus

## New Project

Upon creating and generating a new Luminus project and running it once
in the REPL, here's the tree of directories and files that is
generated:

```
$ tree -a guestbook/

guestbook/
├── Capstanfile
├── .clj-kondo
│   └── .cache
│       └── v1
│           ├── clj
│           │   └── (lots of stuff)
│           ├── cljc
│           │   └── (lots of stuff)
│           ├── cljs
│           │   └── (lots of stuff)
│           └── lock
├── dev-config.edn
├── Dockerfile
├── env
│   ├── dev
│   │   ├── clj
│   │   │   ├── guestbook
│   │   │   │   ├── dev_middleware.clj
│   │   │   │   └── env.clj
│   │   │   └── user.clj
│   │   └── resources
│   │       ├── config.edn
│   │       └── logback.xml
│   ├── prod
│   │   ├── clj
│   │   │   └── guestbook
│   │   │       └── env.clj
│   │   └── resources
│   │       ├── config.edn
│   │       └── logback.xml
│   └── test
│       └── resources
│           ├── config.edn
│           └── logback.xml
├── .gitignore
├── guestbook_dev.db.mv.db
├── guestbook_test.db.mv.db
├── guestbook_test.db.trace.db
├── .lein-failures
├── .lein-repl-history
├── log
│   └── guestbook.log
├── .lsp
│   └── .cache
│       └── db.transit.json
├── .nrepl-port
├── Procfile
├── project.clj
├── README.md
├── resources
│   ├── docs
│   │   └── docs.md
│   ├── html
│   │   ├── about.html
│   │   ├── base.html
│   │   ├── error.html
│   │   └── home.html
│   ├── migrations
│   │   ├── 20240223181041-add-users-table.down.sql
│   │   └── 20240223181041-add-users-table.up.sql
│   ├── public
│   │   ├── css
│   │   │   └── screen.css
│   │   ├── favicon.ico
│   │   ├── img
│   │   │   └── warning_clojure.png
│   │   └── js
│   └── sql
│       └── queries.sql
├── src
│   └── clj
│       └── guestbook
│           ├── config.clj
│           ├── core.clj
│           ├── db
│           │   └── core.clj
│           ├── handler.clj
│           ├── layout.clj
│           ├── middleware
│           │   └── formats.clj
│           ├── middleware.clj
│           ├── nrepl.clj
│           └── routes
│               └── home.clj
├── target
│   ├── base+system+user+provided+dev+test+test
│   │   ├── classes
│   │   │   └── META-INF
│   │   │       └── maven
│   │   │           └── guestbook
│   │   │               └── guestbook
│   │   │                   └── pom.properties
│   │   └── stale
│   │       └── leiningen.core.classpath.extract-native-dependencies
│   ├── classes
│   │   └── META-INF
│   │       └── maven
│   │           └── guestbook
│   │               └── guestbook
│   │                   └── pom.properties
│   ├── repl-port
│   ├── stale
│   │   └── leiningen.core.classpath.extract-native-dependencies
│   └── test+test
│       └── stale
│           └── leiningen.core.classpath.extract-native-dependencies
├── test
│   └── clj
│       └── guestbook
│           ├── db
│           │   └── core_test.clj
│           └── handler_test.clj
├── test-config.edn
└── .vscode
    └── settings.json

57 directories, 667 files
```

# Emacs

Emacs is my editor of choice. My personal configuration is based off
of the sensible defaults provided in the [Clojure for the Brave and
True](https://www.braveclojure.com/) textbook.

## Setup

## Command Cheat Sheet

## Cider

```md
;; Connected to nREPL server - nrepl://localhost:36099
;; CIDER 1.13.0-snapshot (package: 20231127.825), nREPL 1.0.0
;; Clojure 1.11.1, Java 17.0.9
;;     Docs: (doc function-name)
;;           (find-doc part-of-name)
;;   Source: (source function-name)
;;  Javadoc: (javadoc java-object-or-class)
;;     Exit: <C-c C-q>
;;  Results: Stored in vars *1, *2, *3, an exception in *e;
;; ======================================================================
;; If you’re new to CIDER it is highly recommended to go through its
;; user manual first. Type <M-x cider-view-manual> to view it.
;; In case you’re seeing any warnings you should consult the manual’s
;; "Troubleshooting" section.
;;
;; Here are a few tips to get you started:
;;
;; * Press <C-h m> to see a list of the keybindings available (this
;;   will work in every Emacs buffer)
;; * Press <,> to quickly invoke some REPL command
;; * Press <C-c C-z> to switch between the REPL and a Clojure file
;; * Press <M-.> to jump to the source of something (e.g. a var, a
;;   Java method)
;; * Press <C-c C-d C-d> to view the documentation for something (e.g.
;;   a var, a Java method)
;; * Print CIDER’s refcard and keep it close to your keyboard.
;;
;; CIDER is super customizable - try <M-x customize-group cider> to
;; get a feel for this. If you’re thirsty for knowledge you should try
;; <M-x cider-drink-a-sip>.
;;
;; If you think you’ve encountered a bug (or have some suggestions for
;; improvements) use <M-x cider-report-bug> to report it.
;;
;; Above all else - don’t panic! In case of an emergency - procure
;; some (hard) cider and enjoy it responsibly!
;;
;; You can remove this message with the <M-x cider-repl-clear-help-banner> command.
;; You can disable it from appearing on start by setting
;; ‘cider-repl-display-help-banner’ to nil.
;; ======================================================================
```



# Resources

**Websites:**

1. [Clojure for the Brave and True](https://www.braveclojure.com/)

**Books:**

(Remember to **buy** books to *support good authors*.)

1. [Dmitri Sotnikov, Scot Brown: **Web Development with Clojure: Build
   Large, Maintainable Web Applications Interactively**, 3e, 2021,
   ISBN: 168050682X,
   9781680506822](https://libgen.is/book/index.php?md5=77F8623AAE8E49C9EE936E406FE7B1DF)
1. [Renzo Borgatti: **Clojure, The Essential Reference**, 0e, 2021,
   ISBN: 9781617293580, 6664843499, 1447772004,
   161729358X](https://libgen.is/book/index.php?md5=FD806788B6664843499C2AAF3309E5CB)
1. [Kleppmann, Martin: **Designing data-intensive applications: the
   big ideas behind reliable, scalable, and maintainable systems**,
   1e2p, ISBN: 9781449373320,
   1449373321](https://libgen.is/book/index.php?md5=41D80961BA66DA6A1294AA9624CEA15D)

