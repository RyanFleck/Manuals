---
toc: true
date: 2022-12-09T16:20:00.000-07:00
image: "/content-cover-images/coffee-phone.jpg"
summary: Phoenix and Elixir.
title: Phoenix 
---


# Introduction

I've decided to go all in on Phoenix/Elixir for my next few projects.

Luckily my current employer has excellent learning resources, so I have access to a few courses on Elixir and Phoenix. Focus #1 is to get a solid understanding of Elixir basics: how to write, test, and use the toolbox.

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

In [Powershell](https://elixirforum.com/t/iex-in-windows-powershell/14622), run:

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

Run `recompile` in interactive Elixir to, er, recompile.

Strings and Lists are simple and recognizable from Python. 

```ex
["Ace", "Two", "Three"]
"String"
```

Use **double quotes**.

# Thinking in Elixir

Elixir is **functional**. An OO approach to a card deck might look like this:

```
class Card
  string suit 
  string value 

class Deck
  Card[] cards
  f shuffle()
  f deal() -> Card
  f save() -> Card[]
  f load(Card[])
```

An OO approach would dictate that the deck contents are stored in an instance of Deck, and can be manipulated with the class functions.

The functional approach would look like this:

```
module Cards
  f create_deck() -> String[]
  f shuffle(String[]) -> String[]
  f save(String[]) -> Path
  f load(Path) -> String[]
```

There are no classes or instances of classes. The module is a collection of pure functions (methods) and have no internal state.

# Methods

```ex
def shuffle(deck) do
  # ...
end
```

Function and operator names have two components: a name and the arity, for example: `++/2`. The compiler will be angered if you attempt to run a function with the incorrect arity.
```
iex(4)> Cards.shuffle()
** (UndefinedFunctionError) 
  function Cards.shuffle/0 is undefined or private.
  Did you mean:

      * shuffle/1
```

We can utilize a method in the standard library - go to the [Elixir Docs](https://elixir-lang.org/docs) and searching for shuffle, you'll find the [Enum](https://hexdocs.pm/elixir/1.0.5/Enum.html) module.

```ex
def shuffle(deck) do
  Enum.shuffle(deck)
end
```

Ezpz. No import is required as Enum is in the standard library.

```
iex(4)> recompile
Compiling 1 file (.ex)
:ok
iex(5)> deck = Cards.create_deck  
["Ace", "Two", "Three"]
iex(6)> deck
["Ace", "Two", "Three"]
iex(7)> Cards.shuffle(deck)
["Two", "Three", "Ace"]
```