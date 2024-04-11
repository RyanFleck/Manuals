---
toc: true
date: 2024-02-23T17:40:53-07:00
image: "/content-cover-images/coffee-phone.jpg"
summary: "Enterprise scale wizardry."
title: "Clojure"
---

# Philosophy

1. [How startups can move fast with Clojure (by Bradford Cross)](https://www.youtube.com/watch?v=MZy-SNswH2E)

Startups should focus on:
- Bottom-up programming - focusing on fine grained abstractions and composability
- Avoiding frameworks and saas tools
- Focus on individual programmer productivity

**Thought:** Rebuilding things from scratch sucks and Clojure potentially enables better code reuse.

# High-Level Notes

# Rich Hickey Talk Notes

## core.async Channels

Full talk: [infoq.com/presentations/clojure-core-async/](https://www.infoq.com/presentations/clojure-core-async/)

- **Problems and Premise**
  - Function chains make poor machines
  - Reasonable programs are organized around processes and queues
    (conveyance must become first-class.)
  - Java.util.concurrent queues have lots of problems and costs
  - You should be able to add machines to make things scale
  - Sometimes logic relies on shared state
    - Objects don't fix this, they just put the shared state and
      functions in one place
    - Async/Await, Promises, Futures are all handoffs or call/returns
    
- **Solutions**
  - Communicating Sequential Processes (CSP) (Hoare 1978) are the
    model for Clojure
  - Constructs:
    - **chan**nels are queue-like, multi-reader/writer, unbuffered or
      fixed buffers
      - Functions to put, take, close, etc.
    - **thread** gives you a real thread with real blocking
    - **go** is a logical software thread that can be parked during
      blocking calls
    - 
  - *Friends don't let friends put logic in handlers.*
  - Basically **use channels to route your data through functions.**
  
## Inside core.async Channels

Full talk: [youtu.be/hMEX6lfBeRM](https://youtu.be/hMEX6lfBeRM)

## Simple Made Easy

Full talk: [youtube.com/watch?v=SxdOUGdseq4](https://www.youtube.com/watch?v=SxdOUGdseq4)  
12 Minute Version: [youtube.com/watch?v=F87PtAoJNtg](https://www.youtube.com/watch?v=F87PtAoJNtg)

# Luminus

## New Project

Upon creating and generating a new Luminus project and running it once
in the REPL, here is **part** of the tree of directories and files that is
generated:

```
guestbook/
│  
├── project.clj
│  
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
├── test
│   └── clj
│       └── guestbook
│           ├── db
│           │   └── core_test.clj
│           └── handler_test.clj
│  
└── test-config.edn
```

# Emacs

Emacs is my editor of choice. It has unbeatable support for LISPs.

## Setup

My personal configuration is based off of the sensible defaults provided in the 
[Clojure for the Brave and True](https://www.braveclojure.com/) textbook.


## Command Cheat Sheet

| Command            | Action                                             |
|--------------------|----------------------------------------------------|
| M-x cider          | Prompts for more options                           |
| M-x cider-jack-in  | Jacks in to current Clojure (clj) project          |
| C-c C-z            | Jump cursor to REPL                                |
| C-u C-c C-z        | Jump cursor to REPL *and switch to file namespace* |
| C-c C-d a          | cider-apropos to remember var names                |
| C-x 5 2            | Pop out buffer into new window                     |
| C-c C-k            | Evaluate buffer                                    |
| C-c C-e            | Evaluate preceding form                            |
| C-c C-c *or* C-M-x | Evaluate current top-level form                    |
| C-c C-v r          | Evaluate highlighted region                        |
| C-c C-b            | Interrupt evaluation                               |
| M-.                | cider-find-var: Warp to definition under cursor    |
| C-c C-d d          | Look up documentation for current form             |
| C-c C-m            | macroexpand-1: Macroexpand the form at point       |
| C-c M-z            | Eval current buffer and switch to relevant REPL    |
| C-c M-n r          | Reload all files on classpath                      |
| M-,                | Return to your pre-jump location                   |
| M-TAB              | Complete the symbol at point                       |
| C-c C-q            | Quit CIDER                                         |


**Sources:**

1. [Cider Docs: Basic Workflow](https://docs.cider.mx/cider/usage/cider_mode.html#basic-workflow)


## Cider

CIDER is an interactive programming environment for Clojure.

> Traditional programming languages and development environments often
use a Edit, Compile, Run Cycle. In this environment, the programmer
modifies the code, compiles it, and then runs it to see if it does
what she wants. The program is then terminated, and the programmer
goes back to editing the program further. This cycle is repeated over
and over until the program behavior conforms to what the programmer
desires.  Using CIDER’s interactive programming environment, a
programmer works in a very dynamic and incremental manner. Instead of
repeatedly editing, compiling, and restarting an application, the
programmer starts the application once and then adds and updates
individual Clojure definitions as the program continues to run.[^1]

It looks like this when run:

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

[^1]: [CIDER: Interactive Programming](https://docs.cider.mx/cider/usage/interactive_programming.html)
