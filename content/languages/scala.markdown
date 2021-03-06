---
layout: docs-manual
title: Scala
summary: "Magic that your boss *will* let you use."
draft: true
toc: true
---

```scala
object Main extends App {
    println("Hello, Scala!")
}
```

# Why use Scala?

What? Object-oriented _and_ functional? Neato. _Xalgorithms_ work is currently done on a base of scalable technologies: Kafka, Akka, Spark, Kubernetes, etc. To contribute to the core rule interpreter, I've learned a little Scala and written a few functions and unit tests.

> Scala is a modern multi-paradigm programming language designed to express common programming patterns in a concise, elegant, and type-safe way. It smoothly integrates features of object-oriented and functional languages.

Personally I've seen and heard of Scala being used for better and for worse in the industry. As Scala is flexible, it opens the door for situations like the one described here:

> Soon we had three kinds of Scala written at Twitter: Scala written by people who wished it was Ruby, Scala written by people who wished it was Java, and Scala written by people who wished it was Haskell. Let a thousand flowers bloom.[^evrl]

[^evrl]: Quote from [Peter Seibel](http://www.gigamonkeys.com/flowers/), Cees de Groot, [Scala Part II](http://evrl.com/programming/scala/2017/04/04/scala-part-ii.html), <http://evrl.com>

# Setup

My first few tests were compiled and run with `scalac`, but I've been dabbling more with IDEs as of late. I am certainly a JetBrains fan, so **IntelliJ Idea** was my first pick... And a bit of a mess to set up.

When I open an IDE, I want it to know that _I will be ignoring the project files it creates._ Any good IDE should be able to look at generic build files from maven, webpack, SBT, and say "Oh, hey, cool, I'll use the tool you specify to build this project and provide context." IntelliJ needed a little massaging to get to this point, but hey, IDE agnosticism is important.

To avoid the pain I went through, let me start by saying _install these in order._

1. [**SBT**, the Scala Build Tool.](https://www.scala-sbt.org/download.html)
1. [The Scala Binaries. (Scroll down.)](https://www.scala-lang.org/download/)
1. [**IntelliJ**, our IDE.](https://www.jetbrains.com/idea/)

After installing the Scala and IdeaVIM modules, you should be up and running with an `.idea/*` line in your `.gitignore`.

![IntelliJ IDEA]({{ site.url }}/assets/IntelliJ.png)

<br />

# Scala Basics

## Syntax

Case sensitive **Class Names** are written in CamelCase `LikeThis`, **Method Names** are written in lesser-camelcase `likeThis`, programs end with `.scala`, and require an entry point expressed as `def main(args: Array[ String ]){}`. Identifiers must start with a letter or underscore and are case-sensitive.

Comments are expressed identically as they appear in _Java_. That is, single-line with `//` and multiline with `/* *xyz */`.

_Interestingly_, statements can be terminated with either a semicolon or newline. The semicolon is totally optional, unless multiple statements are expressed on the same line (it will be optional on the last statement.)

```scala
val s = "String"; println(s)
```

**Packages** are declared on the first non-comment line, like Java:

```scala
package com.testprog.stuff //Package declaration
import scala.xml._ //The contents of scala.xml
import scala.collection.mutable.HashMap //A single class/object
import scala.collection.mutable.{HashMap, TreeMap, TreeSet}
```

## Apply Dynamic

_Oh, this is new..._ Apply, select, update - dynamic if type checking fails?

> A marker trait that enables dynamic invocations.

<br />

# ScalaJS

<https://www.scala-js.org/>
