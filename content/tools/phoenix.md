---
toc: true
date: 2022-12-09T16:20:00.000-07:00
image: "/content-cover-images/coffee-phone.jpg"
summary: Phoenix and Elixir.
title: Phoenix
---

# Introduction

I've decided to go all in on Phoenix/Elixir for my next few projects.

**Elixir** is syntactic sugar for Erlang. 
Elixir actually transpiles to Erlang and runs on Erlang's [BEAM](https://www.erlang.org/blog/a-brief-beam-primer/) VM.
BEAM stands for _**B**ogdan's **E**rlang **A**bstract **M**achine_, or more recently, _**B**jörn's **E**rlang **A**bstract **M**achine_, after the maintainers.
The BEAM itself is akin to Java's JVM.

> Erlang is a programming language used to build massively scalable soft real-time systems with requirements on high availability. Some of its uses are in telecoms, banking, e-commerce, computer telephony and instant messaging. Erlang's runtime system has built-in support for concurrency, distribution and fault tolerance. -- [erlang.org](https://erlang.org)

**Phoenix** is a web framework that utilizes Elixir and the BEAM to give developers an extremely performant, reliable, stable, and fun to work with web development experience.

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

Convention is to use a **question mark** on a method that returns a true or false value.

**Full module up to this point** along with run example:

```ex
defmodule Cards do
  def create_deck do
    ["Ace", "King", "Two", "Three", "Four"]
  end

  def shuffle(deck) do
    Enum.shuffle(deck)
  end

  def contains?(deck, card) do
    Enum.member?(deck, card)
  end
end
```

```
iex(18)> deck3 = Cards.create_deck |> Cards.shuffle
["King", "Three", "Four", "Two", "Ace"]
iex(19)> Cards.contains?(deck3, "King")
true
iex(20)> Cards.contains?(deck3, "Queen")
false
```

# Comprehensions

Reusing the Card module from the previous section, we'll take a look at using list comprehensions to return transformed sets of data.

```ex
def create_deck do
  suits = ["Clubs", "Diamonds", "Hearts", "Spades"]
  for suit <- suits do
    suit
  end  # this actually returns a new array with suits strings.
end
```

```
iex(26)> Cards.create_deck
["Clubs", "Diamonds", "Hearts", "Spades"]
```

...and it's not just returning the value of the suits variable.

The wrong way:

```ex
for value <- values do
  for suit <- suits do
  "#{value} of #{suit}"
  end
end
```

```
iex(29)> Cards.create_deck
[
  ["Ace of Clubs", "Ace of Diamonds", "Ace of Hearts", "Ace of Spades"],
  ["King of Clubs", "King of Diamonds", "King of Hearts", "King of Spades"],
  ["Two of Clubs", "Two of Diamonds", "Two of Hearts", "Two of Spades"],
  ["Three of Clubs", "Three of Diamonds", "Three of Hearts", "Three of Spades"],
  ["Four of Clubs", "Four of Diamonds", "Four of Hearts", "Four of Spades"]
]
```

Though, this does demonstrate how comprehensions are returned very well, in a nested fashion if run in a nested manner.

We could use `List.flatten` to resolve this. Still the wrong way.

```ex
for value <- values do
  for suit <- suits do
  "#{value} of #{suit}"
  end
end
|> List.flatten
```

or another wrong way

```ex
cards = for value <- values do
  for suit <- suits do
  "#{value} of #{suit}"
  end
end

List.flatten(cards)
```

The best solution is to add **multiple generators** to the comprehension:

```ex
for value <- values, suit <- suits do
  "#{value} of #{suit}"
end
```

or

```ex
for value <- values, suit <- suits, do: "#{value} of #{suit}"
```

Our full (condensed) Cards module now looks like this:

```ex
defmodule Cards do
  def create_deck do
    values = ["Ace", "King", "Two", "Three", "Four"]
    suits = ["Clubs", "Diamonds", "Hearts", "Spades"]
    for value <- values, suit <- suits, do: "#{value} of #{suit}"
  end

  def shuffle(deck), do: Enum.shuffle(deck)
  def contains?(deck, card), do: Enum.member?(deck, card)
end
```

# Pattern Matching

**Pattern matching is Elixir's replacement for variable assignment.**
 
 Pattern matching is used **anytime you use the equals sign.**

```ex
def deal(deck, hand_size), do: Enum.split(deck, hand_size)
```

```
iex(43)> Cards.deal(Cards.create_deck, 5)
{["Ace of Clubs", "Ace of Diamonds", "Ace of Hearts", "Ace of Spades",
  "King of Clubs"],
 ["King of Diamonds", "King of Hearts", "King of Spades", "Two of Clubs",
  "Two of Diamonds", "Two of Hearts", "Two of Spades", "Three of Clubs",
  "Three of Diamonds", "Three of Hearts", "Three of Spades", "Four of Clubs",
  "Four of Diamonds", "Four of Hearts", "Four of Spades"]}
```

Two lists have been returned within a **tuple**, represented with curly braces. Each position in a returned tuple will have a predictable output.

These can be captured with a line like:

```ex
{ hand, rest_of_deck } = Cards.deal(Cards.create_deck, 5)
```

Let's run that in the interactive console to hammer the point home:

```
iex(44)> { hand, rest_of_deck } = Cards.deal(Cards.create_deck, 5)
iex(45)> hand
["Ace of Clubs", "Ace of Diamonds", "Ace of Hearts", "Ace of Spades",
 "King of Clubs"]
iex(46)> rest_of_deck
["King of Diamonds", "King of Hearts", "King of Spades", "Two of Clubs",
 "Two of Diamonds", "Two of Hearts", "Two of Spades", "Three of Clubs",
 "Three of Diamonds", "Three of Hearts", "Three of Spades", "Four of Clubs",
 "Four of Diamonds", "Four of Hearts", "Four of Spades"]
 ```

This also works with lists:

```
iex(47)> arr1 = [ "blergh", 123, :can ]
["blergh", 123, :can]
iex(48)> [ a ] = arr1
** (MatchError) no match of right hand side value: ["blergh", 123, :can]
    (stdlib 4.0.1) erl_eval.erl:496: :erl_eval.expr/6
    iex:48: (file)
iex(48)> [ a, b, c ] = arr1
["blergh", 123, :can]
iex(49)> a
"blergh"
iex(50)> b
123
iex(51)> c
:can
```

Interestingly, if we put a hard-coded value on the left hand side, Elixir will require the right hand side to have the same value in the right-hand spot. 

```
iex(60)> ["red", color] = ["red", "blue"]
["red", "blue"]
iex(61)> ["redx", color] = ["red", "blue"] 
** (MatchError) no match of right hand side value: ["red", "blue"]
    (stdlib 4.0.1) erl_eval.erl:496: :erl_eval.expr/6
    iex:61: (file)
```


# Saving to the Filesystem

```ex
def save(deck, filename) do
  binary = :erlang.term_to_binary(deck)
  File.write(filename, binary)
end
```

To load the file, we can do essentially the opposite.

```ex
def load(filename) do
  { _ok, binary } = File.read(filename)
  :erlang.binary_to_term(binary)
end
```

...and it's the easiest pickle/unpickle I've ever seen. But we should handle the error cases potentially presented in `_ok` with some **pattern matching** in the next section.

# Case Statements

The load function could be cleaned up like so
to handle all error cases. `:error` and `:ok` are atoms (a primitive)
that are commonly used to handle control flow in Elixir programs.

```ex
def load(filename) do
  {status, binary} = File.read(filename)
  case status do
    :ok -> :erlang.binary_to_term(binary)
    :error -> "File doesn't exist or is corrupted."
  end
end
```

This can be further condensed to:

```ex
def load(filename) do
  case File.read(filename) do
    {:ok, binary} -> :erlang.binary_to_term(binary)
    {:error, reason} -> "File doesn't exist or is corrupted. (#{reason})"
  end
end
```

This only makes sense if you remember that Elixir pattern matching both compares and assigns remaining elements. If `:ok` cannot be matched to the returned result from `File.read`, the next case is checked.

Warnings about unused variables can be dismissed by placing an underscore before the variable.

```ex
{:error, _reason} -> "File doesn't exist or is corrupted."
```

Removing reason entirely will cause the pattern matching to fail with this error:

```
iex(65)> Cards.load("test")
** (CaseClauseError) no case clause matching: {:error, :eisdir}
    (cards 0.1.0) lib/cards.ex:20: Cards.load/1
    iex:65: (file)
```

# Pipe Operator

The pipe operator (`|>`) automatically passes the result of a function as the first argument to the next function. Perfecto!

So something like this:

```ex
def create_hand(hand_size) do
  deck = create_deck()
  shuffled = shuffle(deck)
  deal(shuffled, hand_size)
end
```

Can be rewritten to:

```ex
def create_hand(hand_size) do
  create_deck()
  |> shuffle()
  |> deal(hand_size)
end
```

Gotta love it.

# Documentation

Using [ex_doc](https://github.com/elixir-lang/ex_doc) allows developers to export a clean pile of documentation, pulling comments and details from the source code. To install the ex_doc package, add a tuple to your project's `mix.exs` file with the following content:

```ex
{:ex_doc, "~> 0.29.1"}
```

...and run `mix deps.get` to install the package.


**Module Documentation** gives an overview of the entire module and defines a purpose for the child functions.

```ex
@moduledoc """
  Provides methods for creating and handling a deck of cards.
"""
```

**Function Documentation** documents the purpose of individual functions.

```ex
@doc """
  Shuffles and deals a `hand_size` of cards 
    and the remainder of the deck in a second list.
"""
```

Run `mix docs` to generate the documentation for your package.