---
toc: true
date: 2022-12-09T16:20:00.000-07:00
image: "/content-cover-images/coffee-phone.jpg"
summary: Phoenix and Elixir.
title: Phoenix 
---


# Introduction

Luckily my current employer has excellent learning resources, so I have access to a few courses on Elixir and Phoenix. This one was last updated in December 2022 and is taught by *Stephen Grider*.

> I'm not going to lie to you, Elixir and Phoenix are both **tough**, I guarantee you they are unlike any other programming language and framework you've seen before.

Course repo: [github.com/StephenGrider/ElixirCode](https://github.com/StephenGrider/ElixirCode)

Focus #1 is to get a solid understanding of Elixir basics: how to write, test, and use the toolbox.

# Installation

Install [Elixir.](https://elixir-lang.org/install.html)

Follow this [install guide.](https://hexdocs.pm/phoenix/installation.html)

# High Level Bullets

See [Elixir School: Basics](https://elixirschool.com/en/lessons/basics/basics)

- Types work intuitively, like in other languages
- Function and operator names have two components: a name and the arity, for example: `++/2`
- Lists are implemented as linked lists, and [prepending](https://elixirschool.com/en/lessons/basics/collections#lists-0) is faster than appending
- The head and tail of a list can be grabbed with `hd` and `tl` functions
- [Maps](https://elixirschool.com/en/lessons/basics/collections#maps-6) are the key-value store, allow keys of any type, are defined with `%{}`
- Hugo [highlights](https://gohugo.io/content-management/syntax-highlighting/#list-of-chroma-highlighting-languages) Elixir syntax with `elixir`, `exs`, or `ex`## Elixir Basics

# "Mix"

**Mix** is the Elixir command line build tool. Useful commands:

- `mix new <project name>` creates a new project.

# Hello World

In Powershell, run:

```
mix new cards
cd cards
```

Modify `lib/cards.ex` if wanted:

```ex
defmodule Cards do
  def hello do
    :world
  end
end
```

Run interactive Elixir and run the method:

```
PS C:\Users\Developer\Documents\Elixir\cards> iex.bat -S mix
Interactive Elixir (1.14.0) - press Ctrl+C to exit (type h() ENTER for help)
iex(1)> Cards.hello
:world
iex(2)>
```

Congrats, you have _called a method by property in the Cards module._

Note that Elixir implements **implicit return** of the last value.