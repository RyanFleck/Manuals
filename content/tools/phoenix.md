---
toc: true
date: 2022-12-09T16:20:00.000-07:00
image: "/content-cover-images/coffee-phone.jpg"
summary: Phoenix and Elixir.
title: Phoenix
aliases:
  - "/ex/"
  - "/e/"
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

See [Elixir School: Basics](https://elixirschool.com/en/lessons/basics/basics) -- a high-level rundown of the Elixir syntax:

- Types work intuitively, like in other languages
- Code is organized into groups of pure functions called modules
- Function and operator names have two components: a name and the arity, for example: `++/2`
- Lists are implemented as linked lists, and [prepending](https://elixirschool.com/en/lessons/basics/collections#lists-0) is faster than appending
- The head and tail of a list can be grabbed with `hd` and `tl` functions
- [Maps](https://elixirschool.com/en/lessons/basics/collections#maps-6) are the key-value store, allow keys of any type, are defined with `%{}`
- Hugo [highlights](https://gohugo.io/content-management/syntax-highlighting/#list-of-chroma-highlighting-languages) Elixir syntax with `elixir`, `exs`, or `ex`
- For-loops are called comprehensions (`for val <- vals do`)
- Pipe operator enables clean function chaining (`|>`)

**What's good about Elixir?**

- Clear, minimal, and intuitive syntax, especially compared to Erlang
- Ludicrously batteries-included language, more on that below
- Implicit returns means cleaner and less code
- Pattern matching is strict and powerful and forces good habits
- The pipe operator clarifies long chains of functions
- Testing is built in and very easy to use
- Tests can be automatically pulled from the documentation

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

# "Mix"

**Mix** is the Elixir command line build tool. Useful commands:

- `mix new <project name>` creates a new project.
- `mix test` runs unit tests.

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
  Checks a deck of cards for a unique card.

  ## Examples
      iex> deck = Cards.create_deck()
      iex> Cards.contains?(deck, "King of Hearts")
      true
"""
```

The above example will generate a section header and code block with syntax highlighted code examples. Six spaces or three tabs are placed before the example code. Unit tests will also automatically run on provided sample code by default.

Run `mix docs` to generate the documentation for your package.

# Basic Unit Testing

Tests are a first-class citizen in Elixir, which at this point seems to be batteries-included to a ludicrous degree. I couldn't be happier with what I am seeing so far.

When the project was created, mix automatically created a `cards_text.exs` file. Populate it with this simple test.

```ex
defmodule CardsTest do
  use ExUnit.Case
  doctest Cards

  test "the truth" do
    assert 2 + 2 == 5
  end
end
```

```
PS C:\Users\Developer\Documents\Elixir\cards> mix test


  1) test the truth (CardsTest)
     test/cards_test.exs:5
     Assertion with == failed
     code:  assert 2 + 2 == 5
     left:  4
     right: 5
     stacktrace:
       test/cards_test.exs:6: (test)


Finished in 0.03 seconds (0.00s async, 0.03s sync)
1 test, 1 failure
```

_Very nice!_

You may have noticed the line `doctest Cards` - this automatically pulls unit tests from the code examples provided in the documentation we just wrote for our functions in `cards.ex`.

For example, a **doctest** for the `contains?/2` function:

```ex
@doc """
  Checks a deck of cards for a unique card.

  ## Examples
      iex> deck = Cards.create_deck()
      iex> Cards.contains?(deck, "King of Hearts")
      true
"""
def contains?(deck, card), do: Enum.member?(deck, card)
```

A **regular** unit test asserting that the deck has 20 cards:

```ex
test "create_deck makes 20 cards" do
  deck_length = Cards.create_deck() |> length
  assert deck_length == 20
end
```

The **refute** function provides a negative assertion.

```ex
test "shuffling a deck randomizes it" do
  deck = Cards.create_deck
  refute deck == Cards.shuffle(deck)
end
```

# Sample Program: Cards

Here's the first sample/learning program we've written over the previous few sections.

**--- cards.ex**

```ex
defmodule Cards do
  @moduledoc """
    Provides methods for creating and handling a deck of cards.
  """

  @doc """
  Creates a list representing a deck of playing cards.
  """
  def create_deck do
    values = ["Ace", "King", "Two", "Three", "Four"]
    suits = ["Clubs", "Diamonds", "Hearts", "Spades"]
    for value <- values, suit <- suits, do: "#{value} of #{suit}"
  end

  def shuffle(deck), do: Enum.shuffle(deck)

  @doc """
    Checks a deck of cards for a unique card.

    ## Examples
        iex> deck = Cards.create_deck()
        iex> Cards.contains?(deck, "King of Hearts")
        true
  """
  def contains?(deck, card), do: Enum.member?(deck, card)

  def deal(deck, hand_size), do: Enum.split(deck, hand_size)

  def save(deck, filename) do
    binary = :erlang.term_to_binary(deck)
    File.write(filename, binary)
  end

  def load(filename) do
    case File.read(filename) do
      {:ok, binary} -> :erlang.binary_to_term(binary)
      {:error, reason} -> "File doesn't exist or is corrupted. (#{reason})"
    end
  end

  @doc """
    Shuffles and deals a `hand_size` of cards
      and the remainder of the deck in a second list.
  """
  def create_hand(hand_size) do
    create_deck()
    |> shuffle()
    |> deal(hand_size)
  end

  def create_hand() do
    create_hand(5)
  end
end
```

**--- cards_test.exs**

```ex
defmodule CardsTest do
  use ExUnit.Case
  doctest Cards

  test "create_deck makes 20 cards" do
    deck_length = Cards.create_deck() |> length
    assert deck_length == 20
  end

  test "shuffling a deck randomizes it" do
    deck = Cards.create_deck
    refute deck == Cards.shuffle(deck)
  end
end
```

**Run example:**

```
iex> Cards.create_hand
{["Four of Clubs", "Two of Diamonds", "Three of Clubs", "Ace of Diamonds",
  "King of Spades"],
 ["Two of Hearts", "Four of Diamonds", "Two of Spades", "King of Diamonds",
  "Ace of Hearts", "Two of Clubs", "Ace of Spades", "Three of Spades",
  "Four of Spades", "Three of Hearts", "King of Hearts", "Four of Hearts",
  "Ace of Clubs", "Three of Diamonds", "King of Clubs"]}
```

<!-- Maps -->

# Maps

Maps store key-value pairs and follow a lot of pattern matching rules.

```
iex> properties = %{ height: "4ft", weight: "700lbs", hair: "black" }
%{hair: "black", height: "4ft", weight: "700lbs"}
iex> properties.weight
"700lbs"
iex> %{ weight: fatass } = properties
%{hair: "black", height: "4ft", weight: "700lbs"}
iex> fatass
"700lbs"
```

Updating maps is a little more complex then just:

```
iex(9)> properties.height = "7ft"
** (CompileError) iex:9: cannot invoke remote function
  properties.height/0 inside a match
    (more error message below this but removing for brevity.)
```

Maps can be **updated** in two ways:

1. `Map.put(map, key, value)` creates a new map with the new value.
1. `%{ properties | height: "7ft" }` uses `head | tail` syntax.

To **add** new keys, you can also use `Map.put`.

# Keyword Lists

> A keyword list is a list that consists exclusively of two-element tuples.
> The first element of these tuples is known as the key, and it must be an atom. The second element, known as the value, can be any term. -- [elixir docs](https://hexdocs.pm/elixir/1.12/Keyword.html)

```
iex(12)> colors = [{:primary, "red"}, {:secondary, "green"}]
[primary: "red", secondary: "green"]
iex(13)> colors[:primary]
"red"
```

Keyword lists can also be defined with this syntax.

```
iex(14)> colors2 = [primary: "yellow", secondary: "magenta"]
[primary: "yellow", secondary: "magenta"]
```

Unlike Python, and like Ruby, lispy Elixir has multiple methods to complete the same task.

Interestingly, duplicate keywords are allowed:

```
iex(15)> colors3 = [primary: "yellow", secondary: "magenta", primary: "yellow"]
[primary: "yellow", secondary: "magenta", primary: "yellow"]
```

Maps do **not** allow this:

```
iex(16)> properties = %{ weight: "200lbs", hair: "black", hair: "blue"}
warning: key :hair will be overridden in map
  iex:16

%{hair: "blue", weight: "200lbs"}
```

This interesting property is useful when running database queries with Ecto:

```
iex> User.find_where([
  where: user.age > 10,
  where: user.subscribed == true
])
```

If the last argument of a function is a keyword list, the the brackets can be **removed**. Either just the square ones, or both.

```
iex> User.find_where where: user.age > 10, where: user.subscribed == true
```

...Elixir still interprets both these syntax configurations as a single key-value list passed to the function.

# Bootcamp Project II

Start a new Elixir project called **identicon**:

```
mix new identicon
cd identicon
mix test
code .
```

**Requirements:**

1. An identicon is a 250x250px image formed by a 5x5 grid of colored-in squares and mirrored about the middle of the image.
2. The image will not be random, but generated from a seed which is the username. The username should generate the same identicon each time. This means the image does not need to be stored.

The program will look something like:

```ex
generate_numbers(username)
|> pick_color
|> build_grid
|> grid_to_image
```

We can start this program with these lines. Using built-in libraries, we convert a string to an MD5 hash, then a list of 8-bit numbers.

```ex
defmodule Identicon do
  def main(input) do
    input
    |> hash_input
  end

  @doc """
  Converts an input string to a reproducible list of numbers
  ## Examples
    iex> Identicon.hash_input("ryan")
    [16, 199, 204, 199, 164, 240, 175, 240, 60, 145, 92, 72, 85, 101, 185, 218]
  """
  def hash_input(input) do
    :crypto.hash(:md5, input)
    |> :binary.bin_to_list
  end
end
```

# Structs & Pattern Matching

Structs are like maps, with two additional advantages:

1. Default values
2. Additional compile-time checks

In a new file called `lib/image.ex` create a new module:

```ex
defmodule Identicon.Image do
  defstruct hex: nil
end
```

This can be called as `%Identicon.Image{}`

```
iex(5)> %Identicon.Image{}
%Identicon.Image{hex: nil}
```

This can be initialized with an entity provided for the `hex` value, but attempting to add other values like in a map will throw errors.

Modify the `hash_input` function to return an Image struct:

```ex
def hash_input(input) do
  hex = :crypto.hash(:md5, input)
  |> :binary.bin_to_list
  %Identicon.Image{hex: hex}
end
```

```
iex(7)> Identicon.main("test")
%Identicon.Image{
  hex: [9, 143, 107, 205, 70, 33, 211, 115, 202, 222, 78, 131, 38, 39, 180, 246]
}
```

Let's pull some data out of this struct.

By **always using pattern matching** we can extract the first few values.

To pattern match you must **perfectly describe the incoming entity on the right of the '`=`' on the left.**

```ex
def pick_color(input) do
  # Pattern match to pull out the hex property.
  %Identicon.Image{ hex: hex_list } = input
  [r, g, b] = hex_list  # <== will throw a big error
    # ^^ because the entire pattern on the right is not matched.
  [r, g, b | _tail] = hex_list  # <== will work correctly
  [r, g, b]
end
```

Which can be further condensed to:

```ex
def pick_color(input) do
  %Identicon.Image{ hex: [r, g, b | _tail] } = input
  [r, g, b]
end
```

Update the `defstruct` line in `image.ex`:

```ex
defstruct hex: nil, color: nil
```

Change the final line in `pick_color` to:

```ex
%Identicon.Image{ image | color: {r, g, b}}
```

Arguments can also be pattern matched.

```ex
def pick_color(%Identicon.Image{hex: [r, g, b | _tail]} = image) do
  %Identicon.Image{image | color: {r, g, b}}
end
```

_Every method argument can be pattern matched._

```
iex(16)> Identicon.main("test")
%Identicon.Image{
  hex: [9, 143, 107, 205, 70, 33, 211, 115,
    202, 222, 78, 131, 38, 39, 180, 246],
  color: {9, 143, 107}
}
```

# Nested Lists

Here's a brief introduction to how to create and handle "grids" of data.

Remember, we're passing this `hex` property which stores a list of numbers to a function that must convert it into a 5x5 grid of numbers mirrored about the y axis. Something like:

```
1 2 3 2 1
4 5 6 5 4
etc...
```

Code first:

```ex
def mirror_row([a, b, c]), do: [a, b, c, b, a]

def build_grid(%Identicon.Image{hex: hex} = image) do
  grid =
    hex
    |> Enum.chunk_every(3)
    |> Enum.filter(fn e -> length(e) == 3 end)
    |> Enum.map(&mirror_row/1)
    # ^^ ick, I don't like syntax that at all, why?
    |> List.flatten()
    |> Enum.with_index()

  %Identicon.Image{image | grid: grid}
end
```

Let's walk through that transformation line by line.

```
[209, 107, 225, 173, 190, 129, 143, 34, 222, 175, 46, 227, 48, 79, 233, 179]
```

1. Break this list into sublists of length 3.

```ex
|> Enum.chunk_every(3)
```

```
[
  [209, 107, 225],
  [173, 190, 129],
  [143, 34, 222],
  [175, 46, 227],
  [48, 79, 233],
  [179]
]
```

2. Remove lists that are not of length 3.

```ex
|> Enum.filter(fn e -> length(e) == 3 end)
```

```
[
  [209, 107, 225],
  [173, 190, 129],
  [143, 34, 222],
  [175, 46, 227],
  [48, 79, 233]
]
```

3. Apply the `mirror_row` function to each sublist by passing the function by reference to `Enum.map`.

```ex
|> Enum.map(&mirror_row/1)
```

```
[
  [209, 107, 225, 107, 209],
  [173, 190, 129, 190, 173],
  [143, 34, 222, 34, 143],
  [175, 46, 227, 46, 175],
  [48, 79, 233, 79, 48]
]
```

4. Collapse the sublists back into the parent list.

```ex
|> List.flatten()
```

```
[209, 107, 225, 107, 209, 173, 190, 129,
 190, 173, 143, 34, 222, 34, 143, 175,
  46, 227, 46, 175, 48, 79, 233, 79, 48]
```

5. Convert each element to a tuple with the element value and its indice.

```ex
|> Enum.with_index()
```

```
[
  {209, 0}, {107, 1}, {225, 2}, {107, 3}, {209, 4},
  {173, 5}, {190, 6}, {129, 7}, {190, 8}, {173, 9},
  {143, 10}, {34, 11}, {222, 12}, {34, 13}, {143, 14},
  {175, 15}, {46, 16}, {227, 17}, {46, 18}, {175, 19},
  {48, 20}, {79, 21}, {233, 22}, {79, 23}, {48, 24}
]
```

...finally the function returns a new Image struct with the new grid value included.

We could just as easily do some of these steps outside as an overall transformation process on the Image building pipeline, like adding this function as another piped function at the end of main:

```ex
def filter_odd_squares(%Identicon.Image{grid: grid} = image) do
  filtered_grid =
    Enum.filter(grid, fn {a, _b} ->
      rem(a, 2) == 0
    end)

  %Identicon.Image{image | grid: filtered_grid}
end
```

Or as a bit of a claustrophobic one-liner:

```ex
def filter_odd_squares(%Identicon.Image{grid: g} = image) do
  %Identicon.Image{image | grid: Enum.filter(g, fn {a, _b} -> rem(a, 2) == 0 end)}
end
```

# More List Processing

Let's take the list of "pixels to color" from the previous section and turn it into an actionable set of co-ordinates to paint on a 250x250 pixel grid by providing the top-left and bottom-right points of each 50x50 square.

```ex
def build_pixel_map(%Identicon.Image{grid: grid} = image) do
  pixel_map =
    Enum.map(grid, fn {_value, index} ->
      horizontal = rem(index, 5) * 50
      vertical = div(index, 5) * 50
      top_left = {horizontal, vertical}
      bottom_right = {horizontal + 50, vertical + 50}
      {top_left, bottom_right}
    end)

  %Identicon.Image{image | pixel_map: pixel_map}
end
```

This will add the following data structure to our Image struct:

```
[
  {{0, 0}, {50, 50}},
  {{100, 0}, {150, 50}},
  {{200, 0}, {250, 50}},
  {{50, 50}, {100, 100}},
  {{100, 50}, {150, 100}},
  {{150, 50}, {200, 100}},
  {{50, 100}, {100, 150}},
  {{100, 100}, {150, 150}},
  {{150, 100}, {200, 150}},
  {{50, 150}, {100, 200}},
  {{100, 150}, {150, 200}},
  {{150, 150}, {200, 200}}
]
```

# The EGD Image Drawing Library

Documentation can be found at
[erlang.org/docs/18/man/egd](https://www.erlang.org/docs/18/man/egd.html)

First, we must 'download and install the library' in two steps:

```ex
{:egd, github: "erlang/egd"}  # 1. add this to your deps
```

2. Run `mix deps.get` to download the new dependency. The latest compatible version should be automatically fetched.

By adding the following two functions to our image processing pipeline, we write the generated coordinates to an image file!

```ex
def draw_image(%Identicon.Image{color: color, pixel_map: pixel_map}) do
  image = :egd.create(250, 250)
  fill = :egd.color(color)

  Enum.each(pixel_map, fn {start, stop} ->
    :egd.filledRectangle(image, start, stop, fill)
  end)

  :egd.render(image)
end

def save_image(image, filename) do
  File.write("#{filename}.png", image)
end
```

Here are four examples of generated Identicons:

![](/identicons.png)

The next section lists the full sample code.

# Sample Program: Identicons

**--- identicon.ex**

```ex
defmodule Identicon do
  def main(input) do
    input
    |> hash_input
    |> pick_color
    |> build_grid
    |> filter_odd_squares
    |> build_pixel_map
    |> draw_image
    |> save_image(input)
  end

  def save_image(image, filename) do
    File.write("#{filename}.png", image)
  end

  def draw_image(%Identicon.Image{color: color, pixel_map: pixel_map}) do
    image = :egd.create(250, 250)
    fill = :egd.color(color)

    Enum.each(pixel_map, fn {start, stop} ->
      :egd.filledRectangle(image, start, stop, fill)
    end)

    :egd.render(image)
  end

  def build_pixel_map(%Identicon.Image{grid: grid} = image) do
    pixel_map =
      Enum.map(grid, fn {_value, index} ->
        horizontal = rem(index, 5) * 50
        vertical = div(index, 5) * 50
        top_left = {horizontal, vertical}
        bottom_right = {horizontal + 50, vertical + 50}
        {top_left, bottom_right}
      end)

    %Identicon.Image{image | pixel_map: pixel_map}
  end

  def hash_input(input) do
    hex =
      :crypto.hash(:md5, input)
      |> :binary.bin_to_list()

    %Identicon.Image{hex: hex}
  end

  def pick_color(%Identicon.Image{hex: [r, g, b | _tail]} = image) do
    %Identicon.Image{image | color: {r, g, b}}
  end

  def build_grid(%Identicon.Image{hex: hex} = image) do
    grid =
      hex
      |> Enum.chunk_every(3)
      |> Enum.filter(fn e -> length(e) == 3 end)
      |> Enum.map(&mirror_row/1)
      # ^^ ick, I don't like syntax that at all, why?
      |> List.flatten()
      |> Enum.with_index()

    %Identicon.Image{image | grid: grid}
  end

  def filter_odd_squares(%Identicon.Image{grid: g} = image) do
    %Identicon.Image{
      image
      | grid:
          Enum.filter(g, fn {a, _b} ->
            rem(a, 2) == 0
          end)
    }
  end

  def mirror_row([a, b, c]), do: [a, b, c, b, a]
end
```

**--- image.ex**

```ex
defmodule Identicon.Image do
  defstruct hex: nil, color: nil, grid: nil, pixel_map: nil
end
```

# Phoenix

Phoenix is a web application framework. Like Python's _Django_ or Ruby's _Rails_, Elixir has found _Phoenix_ to be the premier tool for web development. Elixir has some distinct advantages over these other languages.

**There are weird things about Phoenix that you need to understand in order to understand the framework.** These things are marked with the symbol **(MAGIC)**.

**There are other weird things about Phoenix that you need to understand that make the framework clearer and easier to modify.** These things are marked with the symbol **(ANTI-MAGIC)**.

# Phoenix 1.2: Installation

The instructor suggests using **Phoenix 1.2**
Ensure you are checking the docs for this specific version on the Phoenix [hexdocs.pm/phoenix/1.2.5/](https://hexdocs.pm/phoenix/1.2.5/Phoenix.html)

Phoenix 1.2 is **old** (2017!) so we'll need to prep a time machine. See [this article I wrote](https://ryanfleck.ca/2022/phoenix-125-on-windows/)
and
[this forum post](https://elixirforum.com/t/setting-up-an-elixir-environment-for-phoenix-1-2-development)
to see how I figured this out.
The instructions here are for Windows 10.

0. Install Erlang 20.3
1. Install Elixir 1.5.3
2. Install NodeJS 8.11.3
3. Install Phoenix
4. Use Docker to spin up a Postgres 9 container

```sh
choco install erlang --version=20.3
choco install elixir --version=1.5.3
nvm install 8.11.3
nvm use 8.11.3
npm i -g brunch@2  # forcing brunch 2 fixes build errors

# This is all one line, reload your shell first
mix archive.install
  https://github.com/phoenixframework/archives/raw/master/phoenix_new.ez
```

Spin up a Postgres 9 container in Docker.

```
docker run --name phoenix-125-db -p 5432:5432
  -e POSTGRES_PASSWORD=<pwd> -d postgres:9
```

Finally, run `ecto create` and enjoy your new Phoenix project.

# Bootcamp Project III Creation Logs

**You should probably skip this section.**

If you've followed the setup steps above, you should be able to run `phoenix.new` without issues. I've included this as reference in case I run into a problem in the future and it's due to some deprecated library that was warned about here.

```
PS C:\Users\Developer\Documents\Elixir\discuss> elixir -v
Erlang/OTP 20 [erts-9.3] [64-bit] [smp:8:8] [ds:8:8:10] [async-threads:10]

Elixir 1.5.3

PS C:\Users\Developer\Documents\Elixir> mix phoenix.new discuss
* creating discuss/config/config.exs
* creating discuss/config/dev.exs
* creating discuss/config/prod.exs
  ... lots more files ...
* creating discuss/web/views/layout_view.ex
* creating discuss/web/views/page_view.ex

Fetch and install dependencies? [Yn] Y
* running mix deps.get
* running npm install && node node_modules/brunch/bin/brunch build

We are all set! Run your Phoenix application:

    $ cd discuss
    $ mix phoenix.server

You can also run your app inside IEx (Interactive Elixir) as:

    $ iex -S mix phoenix.server

Before moving on, configure your database in config/dev.exs and run:

    $ mix ecto.create
```

Open **mix.exs** and remove `:gettext` from the compilers list.

If your database is up and running, initialize the db.

```
PS C:\Users\Developer\Documents\Elixir> mix ecto.create
** (Mix) The task "ecto.create" could not be found
PS C:\Users\Developer\Documents\Elixir> cd discuss
PS C:\Users\Developer\Documents\Elixir\discuss> code .
PS C:\Users\Developer\Documents\Elixir\discuss> mix ecto.create
==> file_system
Compiling 7 files (.ex)
Generated file_system app
==> connection
Compiling 1 file (.ex)
Generated connection app
==> gettext
warning: the dependency :gettext requires Elixir "~> 1.11"
  but you are running on v1.5.3
Compiling 1 file (.yrl)
Compiling 1 file (.erl)
Compiling 21 files (.ex)
warning: function Kernel.ParallelCompiler.async/1 is
 undefined or private
  lib/gettext/compiler.ex:430

Generated gettext app
===> Compiling ranch
===> Compiling poolboy
==> decimal
Compiling 4 files (.ex)
Generated decimal app
warning: String.strip/1 is deprecated, use String.trim/1
  c:/Users/Developer/Documents/Elixir/discuss/deps/poison/mix.exs:4

==> poison
Compiling 4 files (.ex)
warning: Integer.to_char_list/2 is deprecated, use Integer.to_charlist/2
  lib/poison/encoder.ex:161

warning: HashDict.size/1 is deprecated, use maps and the Map module instead
  lib/poison/encoder.ex:283

Generated poison app
==> db_connection
Compiling 23 files (.ex)
Generated db_connection app
Compiling 13 files (.ex)
Generated phoenix_pubsub app
===> Compiling cowlib
src/cow_multipart.erl:392: Warning: call to
  crypto:rand_bytes/1 will fail, since it was removed
    in 20.0; use crypto:strong_rand_bytes/1

===> Compiling cowboy
==> mime
Compiling 2 files (.ex)
Generated mime app
==> plug
Compiling 44 files (.ex)
warning: Atom.to_char_list/1 is deprecated, use Atom.to_charlist/1
  lib/plug/builder.ex:186

warning: Kernel.to_char_list/1 is deprecated, use Kernel.to_charlist/1
  lib/plug/adapters/cowboy.ex:220

warning: Kernel.to_char_list/1 is deprecated, use Kernel.to_charlist/1
  lib/plug/adapters/cowboy.ex:238

warning: String.rstrip/1 is deprecated, use String.trim_trailing/1
  lib/plug/templates/debugger.html.eex:635

Generated plug app
==> phoenix_html
Compiling 8 files (.ex)
Generated phoenix_html app
==> phoenix
Compiling 60 files (.ex)
warning: String.lstrip/2 is deprecated, use
  String.trim_leading/2 with a binary as second argument
  lib/phoenix/template.ex:376

warning: String.strip/1 is deprecated, use String.trim/1
  lib/phoenix/code_reloader.ex:169

warning: String.rjust/2 is deprecated, use String.pad_leading/2
  lib/phoenix/router/console_formatter.ex:34

warning: String.ljust/2 is deprecated, use String.pad_trailing/2
  lib/phoenix/router/console_formatter.ex:35

warning: String.ljust/2 is deprecated, use String.pad_trailing/2
  lib/phoenix/router/console_formatter.ex:36

warning: String.strip/1 is deprecated, use String.trim/1
  lib/phoenix/router/helpers.ex:269

Generated phoenix app
==> phoenix_live_reload
Compiling 4 files (.ex)
Generated phoenix_live_reload app
==> postgrex
Compiling 62 files (.ex)
Generated postgrex app
==> ecto
Compiling 70 files (.ex)
Generated ecto app
==> phoenix_ecto
Compiling 6 files (.ex)
Generated phoenix_ecto app
==> discuss
Compiling 12 files (.ex)
Generated discuss app
The database for Discuss.Repo has been created
```

Given all this completed without error, start your local server and gaze upon a Phoenix 1.2 project template!

```
PS C:\Users\Developer\Documents\Elixir\discuss> mix phoenix.server
[info] Running Discuss.Endpoint with Cowboy using http://localhost:4000
16:56:32 - info: compiled 6 files into 2 files, copied 3 in 1.1 sec
[info] GET /
[debug] Processing by Discuss.PageController.index/2
  Parameters: %{}
  Pipelines: [:browser]
[info] Sent 200 in 47ms
```

...now we can start learning Phoenix in earnest.

This training material is very engaging; hopefully Phoenix 1.2 is similar enough to the current 1.5 that the lessons will carry over.

# Phoenix 1.2: EEX Templates and MVC

Unlike modern SPA + API configurations, Phoenix is monolithic.
Unlike older server-side templates, Phoenix does not send a brand new HTML page to the user each time a large action is taken.
Phoenix is a hybrid that combines the best of SPAs and the best of SSR.

This section deals with the `web/templates` folder.

The **layout** subfolder holds `app.html.eex` which contains the base for all HTML pages within the application.

At this point it might be smart to install the [Phoenix Framework](https://marketplace.visualstudio.com/items?itemName=phoenixframework.phoenix) VSCode extension and follow the instructions to add emmet support for eex files.

EEX templates work like HTML for the most part, but have plenty of special extra syntax to work with the backend.

**MVC typically works like this:**

0. **Model**: shape of the raw data in the database
1. **View**: organizes and displays the model data
2. **Controller**: manages the other two and state data

Phoenix 1.2 starts off with an empty models folder, a couple views, one template, and one controller. Oh, right, these additional components are also needed:

0. **Templates**: used by views to render pages
1. **Routers**: directs users to indicated pages

Our Phoenix app starts with one router. Lines 16-20 read:

```ex
scope "/", Discuss do
  pipe_through :browser # Use the default browser stack

  get "/", PageController, :index
end
```

**What does this do?** The router will take an incoming request, look through the rules, and pick the matching path. Here, when someone makes a **get** request to the root (`/`) it will find the module called **PageController** and run the `:index` function on it. That controller looks like this:

```ex
defmodule Discuss.PageController do
  use Discuss.Web, :controller

  def index(conn, _params) do
    render conn, "index.html"
  end
end
```

The request lifecycle at a high level (request data is passed down through these like a function chain) is something like:

- **Router** handles an incoming request
- **Controller** grabs model data from the database
- **View** renders a template and sends a response

**(MAGIC)** **Views and Templates are related by name.** A view named 'PageView' will rely on a subfolder in the templates folder called 'page'.
Every file in the corresponding folder will be added as functions to the view when Phoenix boots. Models and Controllers are also related by name.

In Django, this all has to be done manually and is boilerplate work. The invisible magic here saves time, but is important to note.

**Follow the naming conventions.**

# Phoenix 1.2 & IEX Interactive Shell

Phoenix can be opened in IEX for live debugging and running of functions currently in the works. Phoenix already live reloads, so the shell is moreso useful for debugging than general development.

```
PS C:\Users\Developer\Documents\Elixir\discuss> iex.bat -S mix phoenix.server
[info] Running Discuss.Endpoint with Cowboy using http://localhost:4000
Interactive Elixir (1.5.3) - press Ctrl+C to exit (type h() ENTER for help)

iex(1)> 19:34:00 - info: compiled 6 files into 2 files, copied 3 in 972 ms
iex(1)> [info] GET /
iex(1)> [debug] Processing by Discuss.PageController.index/2
  Parameters: %{}
  Pipelines: [:browser]
iex(1)> [info] Sent 200 in 47ms

iex(2)> Discuss.PageView.render("index.html")
{:safe,
 [[["" | "<div>\n  <h2>"] | "Welcome to Kektronics Supernova"] |
  "</h2>\n</div>\n"]}
```

# Phoenix 1.2: Model Essentials

Phoenix has a typical model and migration system. You can generate migration files from the command line:

```
> mix ecto.gen.migration add_topics
* creating priv/repo/migrations
* creating priv/repo/migrations/20221213030625_add_topics.exs
```

Migrations are datestamped on the filename so they run in the correct order when a database is being updated.

Opening this new migration file reveals almost nothing:

```ex
defmodule Discuss.Repo.Migrations.AddTopics do
  use Ecto.Migration

  def change do

  end
end
```

Add this in `change`:

```ex
    create table(:topics) do
      add :title, :string
    end
```

...and that'll make a simple table of topics with an id and a column called `:title` of type `:string`. Now we can run the migration to create the tables in the connected database:

```
> mix ecto.migrate
[info] == Running Discuss.Repo.Migrations.AddTopics.change/0 forward
[info] create table topics
[info] == Migrated in 0.0s
```

If you'd like to confirm this worked, login to your postgres instance and run:

```sql
select * from topics;
```

# Phoenix 1.2: A Complete MVC Page

Let's show a form to a user and save some data to our database.

We need to:

1. Add a route in our router file to direct the user to the new page.
2. Add a controller method to handle this request.
3. Make a new template to show the form to the user.
4. Create a topic model that can hold all the data in the form.
5. Make a new controller and view to manage things related to 'topics'.

## Add Route

Add this to your `Discuss.Router` under the line for the index:

```ex
get "/topics/new", TopicController, :new
```

...like before, this format dictates that when a user goes to the path indicated, Phoenix will give the request to the `new` function on the `TopicController`.

Here are some conventional routes and their corresponding controller functions:

- `:new` - `GET /topics/new`
- `:create` - `POST /topics`
- `:index` - `GET /topics`
- `:delete` - `DELETE /topics/12`
- `:edit` - `GET /topics/12/edit`
- `:update` - `PUT /topics/12`

...since this isn't an API, some of these may seem a bit unusual to PWA + API builders, as it is a mix of pages and API actions -- though all of the GET requests will return pages for the above conventions.

At this point the instructor has stressed that **Phoenix will work well for you if you follow these conventions.**

## Add Controller

Create a new file called `web/controllers/topic_controller.ex`

**Always use the singular form of the noun when naming things.**

```ex
defmodule Discuss.TopicController do
  use Discuss.Web, :controller   # <== What's this?

  def new() do

  end
end
```

These keywords are used to pull additional functionality into modules.

- `import` -- copy all the functions to the current module
- `alias` -- make a shortcut to a module, functions become available as if they were within the module, but are not available to call by using the module
- `use` -- like import, but with fancy setup, it's complicated

[=> elixir-lang.org: alias, require, and import](https://elixir-lang.org/getting-started/alias-require-and-import.html)

If we check `page_controller.ex` we can see:

```ex
defmodule Discuss.PageController do
  use Discuss.Web, :controller

  def index(conn, _params) do
    render conn, "index.html"
  end
end
```

If we check `web.ex` we can see:

```ex
def controller do
  quote do
    use Phoenix.Controller

    alias Discuss.Repo
    import Ecto
    import Ecto.Query

    import Discuss.Router.Helpers
    import Discuss.Gettext
  end
end
```

Looks like we need to steal the `use` definition from the other controller so we can also give our module the properties and functions of a controller.

...what's `quote do`?

**Aw shit -- we just got our first taste of metaprogramming.**

> Quote and Unquote: This guide aims to introduce the meta-programming techniques available in Elixir. The ability to represent an Elixir program by its own data structures is at the heart of meta-programming.  
> -- **[elixir-lang.org](https://elixir-lang.org/getting-started/meta/quote-and-unquote.html)**

...so I guess **use** must apply the quoted operations. Slick.

Add `conn` and `params` to our new function in our Topic controller:

```ex
defmodule Discuss.TopicController do
  use Discuss.Web, :controller

  def new(conn, _params) do
    IO.puts "+++++"
    IO.inspect conn  # pretty print the data structure
  end
end
```

By logging the `conn` parameter we can see a `Plug.Conn` struct that is passed to us at this point in the Phoenix function pipeline. Some bits are shortened/redacted but I've left it mostly intact.

(**(ANTI-MAGIC)** The exposure of the definitions for model, view, controller, router, and channel in `web.ex` means it is easy to write shared behavior for all your functions. Hiding these definitions within the framework would have prevented that.)

This `Conn` struct is the center of Phoenix.

```
%Plug.Conn{adapter: {Plug.Adapters.Cowboy.Conn, :...}, assigns: %{},
 before_send: [#Function<0.7415431/1 in Plug.CSRFProtection.call/2>,
  #Function<4.18464706/1 in Phoenix.Controller.fetch_flash/2>,
  #Function<0.112984571/1 in Plug.Session.before_send/2>,
  #Function<1.120023888/1 in Plug.Logger.call/2>,
  #Function<0.34983904/1 in Phoenix.LiveReloader.before_send_inject_reloader/2>],
 body_params: %{},
 cookies: %{
   "_hello_key" => " ( hidden ) ",
   "csrftoken" => " ( hidden ) ",
   "messages" => "  ( hidden ) "},
 halted: false, host: "localhost", method: "GET", owner: #PID<0.598.0>,
 params: %{}, path_info: ["topics", "new"], path_params: %{},
 peer: {{127, 0, 0, 1}, 63690}, port: 4000,
 private: %{Discuss.Router => {[], %{}}, :phoenix_action => :new,
   :phoenix_controller => Discuss.TopicController,
   :phoenix_endpoint => Discuss.Endpoint, :phoenix_flash => %{},
   :phoenix_format => "html", :phoenix_layout => {Discuss.LayoutView, :app},
   :phoenix_pipelines => [:browser],
   :phoenix_route => #Function<1.51542571/1 in Discuss.Router.match_route/4>,
   :phoenix_router => Discuss.Router, :phoenix_view => Discuss.TopicView,
   :plug_session => %{}, :plug_session_fetch => :done}, query_params: %{},
 query_string: "", remote_ip: {127, 0, 0, 1},
 req_cookies: %{
   "_hello_key" => " ( hidden ) ",
   "csrftoken" => " ( hidden ) ",
   "messages" => "  ( hidden ) "},
 req_headers: [{"host", "localhost:4000"}, {"connection", "keep-alive"},
  {"cache-control", "max-age=0"}, {"upgrade-insecure-requests", "1"},
  {"user-agent",
   "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36"},
  {"accept",
   "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8"},
  {"sec-gpc", "1"}, {"sec-fetch-site", "same-origin"},
  {"sec-fetch-mode", "navigate"}, {"sec-fetch-user", "?1"},
  {"sec-fetch-dest", "document"},
  {"referer", "http://localhost:4000/topics/new"},
  {"accept-encoding", "gzip, deflate, br"},
  {"accept-language", "en-US,en;q=0.9"},
 request_path: "/topics/new", resp_body: nil, resp_cookies: %{},
 resp_headers: [{"cache-control", "max-age=0, private, must-revalidate"},
  {"x-request-id", "ddks9ld8b768m8mbfqjgnnp6grtv8eq7"},
  {"x-frame-options", "SAMEORIGIN"}, {"x-xss-protection", "1; mode=block"},
  {"x-content-type-options", "nosniff"}], scheme: :http, script_name: [],
 secret_key_base: " ( hidden ) ",
 state: :unset, status: nil}
```

The `params` arg looks like this:

```
[debug] Processing by Discuss.TopicController.new/2
  Parameters: %{}
  Pipelines: [:browser]
%{}
```

## Add Model

Here we'll add a model with a changeset and validations.

Create `models/topic.ex` with:

1. The model **schema**.
2. A **changeset** function.

```ex
defmodule Discuss.Topic do
  use Discuss.Web, :model

  # Step 1
  schema "topics" do
    field :title, :string
  end

  # Step 2
  def changeset(struct, params \\ %{}) do
    struct
    |> cast(params, [:title])
    |> validate_required([:title])
  end

end
```

The instructor says `changeset` structure is one of the
most challenging parts of Phoenix to understand and work with.

Rather than store a complete and mutated copy of an object being modified, Phoenix produces changesets.

**Important:** `//` is how you provide default arguments in Elixir. Above, an empty map is provided. Otherwise it will default to `nil`.

Update the `TopicController` to read:

```ex
defmodule Discuss.TopicController do
  use Discuss.Web, :controller
  alias Discuss.Topic

  def new(_conn, _params) do
    changeset = Topic.changeset(%Topic{}, %{})
    render conn, "new.html"  # (not created yet)
  end
end
```

## Add View & Template

1. Create `/web/views/topic_view.ex` and add:

```ex
defmodule Discuss.TopicView do
  use Discuss.Web, :view
end
```

2. Make a new directory `/web/templates/topic`
3. In this directory make `new.html.eex`

We can use Elixir code to make the form for us.

```ex
<%= form_for @changeset, topic_path(@conn, :create), fn f -> %>
<% end %>
```

...crap, what?

This is actually this elixir, with template syntax:

```ex
form_for(@changeset, topic_path(@conn, :create), fn f -> "" end)
```

The function `topic_path` will be explained later.

**Important:** Things prefixed here with `@` refer to variables passed to the template by the render function. Some variables are passed automatically.

Change the render line and add a bit more to the heex template:

```ex
    render conn, "new.html", changeset: changeset
```

````ex
<h3>New Topic</h3>
<%= form_for @changeset, topic_path(@conn, :create), fn f -> %>
    <div class="form-group">
        <%= text_input f, :title, placeholder: "Title", class: "form-control" %>
    </div>
    <%= submit "Save Topic", class: "btn btn-primary" %>
<% end %>```ex
<%= form_for @changeset, topic_path(@conn, :create), fn f -> %>

<% end %>
````

Next, copy this line to your router:

```ex
post "/topics", TopicController, :create
```

If you run `mix phoenix.routes` you'll see:

```
> mix phoenix.routes
 page_path  GET   /            Discuss.PageController :index
topic_path  GET   /topics/new  Discuss.TopicController :new
topic_path  POST  /topics      Discuss.TopicController :create
```

Note the term `topic_path` here. This path helper takes the first and last elements on this line to reduce errors when sending forms around.

Finally, let's start to finish the `create` method:

```ex
def create(conn, %{"topic" => topic}) do
  changeset = Topic.changeset(%Topic{}, topic)
  case Repo.insert(changeset) do
    {:ok, post} -> IO.inspect(post)
    {:error, err_changeset} -> IO.inspect(err_changeset)
  end
end
```

...this still throws an error, but we can see a record is inserted by logging the success and error messages:

```
[info] POST /topics
[debug] Processing by Discuss.TopicController.create/2
  Parameters: %{"_csrf_token" => " ( hidden ) ",
    "_utf8" => "Γ£ô",
    "topic" => %{"title" => "Test 2"}}
  Pipelines: [:browser]
[debug] QUERY OK db=0.0ms
INSERT INTO "topics" ("title") VALUES ($1) RETURNING "id" ["Test 2"]
%Discuss.Topic{__meta__: #Ecto.Schema.Metadata<:loaded, "topics">, id: 1,
 title: "Test 2"}
[info] Sent 500 in 109ms
```

We still want to redirect users to the topic list on success, or show validation errors and remain on the page in that case.

To render errors, add this to the EEX:

```ex
<%= error_tag f, :title %>
```

And update the controller:

```ex
def create(conn, %{"topic" => topic}) do
  changeset = Topic.changeset(%Topic{}, topic)
  case Repo.insert(changeset) do
    # X
    {:ok, post} -> IO.inspect(post)
    # Return the changeset with errors if they exist
    {:error, err_changeset} -> render conn, "new.html", changeset: err_changeset
  end
end
```

...the tutorial stops here and we are supposed to fill the success case in the next part of the tutorial, after we build the list view.

## Add Home/List Template & View

It's breaking RESTful conventions a bit, but we're going to route users who come to the site to the list of topics. Update your router:

```
get "/", TopicController, :index
```

...at this point you could delete the controller, view, and templates for _Page_.

[Ecto 2.0.5 Documentation](https://hexdocs.pm/ecto/2.0.5/Ecto.html)

Tutorial guy wants us to use [Repo.all](https://hexdocs.pm/ecto/2.0.5/Ecto.Repo.html#c:all/2) which cannot be a good long term solution but will be fine to prove a point.

```ex
def index(conn, _params) do
  # Render a list of all the topics in the database.
  # If unaliased, Discuss.Repo.all(Discuss.Topic)
  render conn, "index.html", topics: Repo.all(Topic)
end
```

Add a new template: `/templates/topic/index.html.eex`

```html
<h2>Topics</h2>
<ul class="collection">
  <!-- Let's iterate through the *topics* list -->
  <%= for topic <- @topics do %>
  <li class="collection-item"><%= topic.title %></li>
  <% end %>
</ul>
```

...works good!

**Let's finish our `/topics/new` page.**

## Link the Pages

Redirect to index after topic creation:

```ex
def create(conn, %{"topic" => topic}) do
  changeset = Topic.changeset(%Topic{}, topic)
  case Repo.insert(changeset) do
    {:ok, post} ->
      conn
      |> put_flash(:info, "Topic Created")
      |> redirect(to: topic_path(conn, :index))
    {:error, err_changeset} ->
      render conn, "new.html", changeset: err_changeset
  end
end
```

The `put_flash` function allows us to show one-time messages to our user, like "topic created". Now the user will be redirected to the home page with a flash message after they submit a new topic.

(He adds some new stuff to `app.html.eex`)

```html
<!-- Compiled and minified CSS -->
<link
  rel="stylesheet"
  href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"
/>
<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<!-- Compiled and minified JavaScript -->
<link
  rel="stylesheet"
  href="https://fonts.googleapis.com/icon?family=Material+Icons"
/>
```

At the bottom of `topic/index.html.eex` place this button with an elixir link/path reference:

```ex
<div class="fixed-action-btn">
    <%= link to: topic_path(@conn, :new),
      class: "btn-floating btn-large waves-effect waves-light red" do %>
        <i class="material-icons">add</i>
    <% end %>
</div>

```

...sweet, we're **all wired up!**

## Router Wildcards & Edit Page

What to do if we want to edit or update our records?

```ex
# Typically (For example: (conn, :edit, 12))
topic_path(connn, :action, id)

# In router
get "/topics/:id/edit", TopicController, :edit
#            :id -> this is a wildcard matcher
#                   and will show up in params

# In Topic Controller
# (Reminder that params keys are strings)
def edit(conn, %{"id" => topic_id}) do
  # Load an existing/complete 'changeset' from the database.
  topic = Repo.get(Topic, topic_id)
  changeset = Topic.changeset(topic)
  # Send it out, bound to a new template we'll make now
  render conn, "edit.html", changeset: changeset, topic: topic
end
```

...and write that template:

```ex
<h3>Edit Topic</h3>
<%= form_for @changeset, topic_path(@conn, :update, @topic), fn f -> %>
    <div class="form-group">
        <%= text_input f, :title, placeholder: "Title", class: "form-control" %>
        <p style="color: red">
        <%= error_tag f, :title %>
        </p>
    </div>
    <%= submit "Save Topic", class: "btn btn-primary" %>
<% end %>
```

...and write the controller for the update action:

```ex
def update(conn, %{"topic" => topic, "id" => id}) do
  # We fetch the original record from the repository first? Ok.
  old_topic = Repo.get(Topic, id)
  changeset = Topic.changeset(old_topic, topic)
  # Push the update to the database:
  case Repo.update(changeset) do
    {:ok, _topic} ->
      conn
      |> put_flash(:info, "Topic Updated")
      |> redirect(to: topic_path(conn, :index))
    {:error, err_changeset} ->
      render conn, "edit.html",
        changeset: err_changeset, topic: old_topic
  end
end
```

**This doesn't handle an id not found error.** Fine for now.

To add an edit button to your index type:

```html
<div class="right">
  <%= link "Edit", to: topic_path(@conn, :edit, topic) %>
</div> 
```

Since we have followed RESTful conventions, we can actually use the `resources` tool to generate **all our routes** rather than adding a delete function at this point in the game:

```ex
scope "/", Discuss do
  pipe_through :browser # Use the default browser stack

  # get "/", TopicController, :index
  # get "/topics/new", TopicController, :new
  # post "/topics", TopicController, :create
  # get "/topics/:id/edit", TopicController, :edit
  # put "/topics/:id", TopicController, :update
  resources "/", TopicController
end
```
```
mix phoenix.routes
Compiling 8 files (.ex)
topic_path  GET     /          Discuss.TopicController :index
topic_path  GET     /:id/edit  Discuss.TopicController :edit
topic_path  GET     /new       Discuss.TopicController :new
topic_path  GET     /:id       Discuss.TopicController :show
topic_path  POST    /          Discuss.TopicController :create
topic_path  PATCH   /:id       Discuss.TopicController :update
            PUT     /:id       Discuss.TopicController :update
topic_path  DELETE  /:id       Discuss.TopicController :delete
```

...because we're using route helpers, we don't need to go back through our application to change all the paths for different actions. 

**Do note that we haven't implemented `:show` or `:delete` yet.**

## Delete Button

```ex
def delete(conn, %{"id" => topic_id}) do
  Repo.get!(Topic, topic_id) |> Repo.delete!
end
```

The `topic_path` helper always sends a GET request so you must add an additional argument in your list view to ensure it sends a DELETE request.

```html
<div class="right">
  <%= link "Edit", to: topic_path(@conn, :edit, topic) %>
  <%= link "Delete", to: topic_path(@conn, :delete, topic), method: :delete %>
</div> 
```

Adding that delete method specification means Phoenix will insert a full form at this point in the code to submit the DELETE request to the backend.

## Completed MVC Page 

**--- web/controllers/topic_controller.ex**

```ex
defmodule Discuss.TopicController do
  use Discuss.Web, :controller
  alias Discuss.Topic

  def index(conn, _params) do
    # Render a list of all the topics in the database.
    # If unaliased, Discuss.Repo.all(Discuss.Topic)
    render conn, "index.html", topics: Repo.all(Topic)
  end

  def new(conn, _params) do
    changeset = Topic.changeset(%Topic{}, %{})
    render conn, "new.html", changeset: changeset
  end

  def create(conn, %{"topic" => topic}) do
    changeset = Topic.changeset(%Topic{}, topic)
    case Repo.insert(changeset) do
      {:ok, _post} ->
        conn
        |> put_flash(:info, "Topic Created")
        |> redirect(to: topic_path(conn, :index))
      {:error, err_changeset} -> render conn, "new.html", changeset: err_changeset
    end
  end

  def edit(conn, %{"id" => topic_id}) do
    # Load an existing/complete 'changeset' from the database.
    topic = Repo.get!(Topic, topic_id)
    changeset = Topic.changeset(topic)
    # Send it out, bound to a new template we'll make now
    render conn, "edit.html", changeset: changeset, topic: topic
  end

  def update(conn, %{"topic" => topic, "id" => id}) do
    # We fetch the original record from the repository first? Ok.
    old_topic = Repo.get!(Topic, id)
    changeset = Topic.changeset(old_topic, topic)
    # Push the update to the database:
    case Repo.update(changeset) do
      {:ok, _topic} ->
        conn
        |> put_flash(:info, "Topic Updated")
        |> redirect(to: topic_path(conn, :index))
      {:error, err_changeset} ->
        render conn, "edit.html",
          changeset: err_changeset, topic: old_topic
    end
  end

  def delete(conn, %{"id" => topic_id}) do
    Repo.get!(Topic, topic_id) |> Repo.delete!
    conn
    |> put_flash(:info, "Topic Deleted")
    |> redirect(to: topic_path(conn, :index))
  end
end
```
**--- web/models/topic.ex**

```ex
defmodule Discuss.Topic do
  use Discuss.Web, :model

  schema "topics" do
    field :title, :string
  end

  def changeset(struct, params \\ %{}) do
    struct
    |> cast(params, [:title])
    |> validate_required([:title])
  end
end
```

**--- priv/repo/migrations/20221213030625_add_topics.exs**

```ex
defmodule Discuss.Repo.Migrations.AddTopics do
  use Ecto.Migration

  def change do
    create table(:topics) do
      add :title, :string
    end
  end
end
```
**--- web/views/topic_view.ex**

```ex
defmodule Discuss.TopicView do
  use Discuss.Web, :view
end
```

**--- web/templates/index.html.eex**

```html
<h2>Topics</h2>

<ul class="collection">

    <!-- Let's iterate through the *topics* list -->
    <%= for topic <- @topics do %>
        <li class="collection-item">
            <%= topic.title %>
            <div class="right">
                <%= link "Edit", to: topic_path(@conn, :edit, topic) %>
                <%= link "Delete", 
                  to: topic_path(@conn, :delete, topic), 
                  method: :delete %>
            </div> 
        </li>
    <% end %>

</ul>

<div class="fixed-action-btn">
    <%= link to: topic_path(@conn, :new), 
        class: "btn-floating btn-large waves-effect waves-light red" do %>
        <i class="material-icons">add</i> 
    <% end %>
</div>
```

**--- web/templates/edit.html.eex**

```html
<h3>Edit Topic</h3>
<%= form_for @changeset, topic_path(@conn, :update, @topic), fn f -> %>
    <div class="form-group">
        <%= text_input f, :title, placeholder: "Title", class: "form-control" %>
        <p style="color: red">
        <%= error_tag f, :title %>
        </p>
    </div>
    <%= submit "Save Topic", class: "btn btn-primary" %>
<% end %>
```

**--- web/templates/new.html.eex**

```html
<h3>New Topic</h3>
<%= form_for @changeset, topic_path(@conn, :create), fn f -> %>
    <div class="form-group">
        <%= text_input f, :title, placeholder: "Title", class: "form-control" %>
        <p style="color: red">
        <%= error_tag f, :title %>
        </p>
    </div>
    <%= submit "Save Topic", class: "btn btn-primary" %>
<% end %>
```

**--- web/router.ex**

```ex
defmodule Discuss.Router do
  use Discuss.Web, :router

  pipeline :browser do
    plug :accepts, ["html"]
    plug :fetch_session
    plug :fetch_flash
    plug :protect_from_forgery
    plug :put_secure_browser_headers
  end

  pipeline :api do
    plug :accepts, ["json"]
  end

  scope "/", Discuss do
    pipe_through :browser # Use the default browser stack

    # get "/", TopicController, :index
    # get "/topics/new", TopicController, :new
    # post "/topics", TopicController, :create
    # get "/topics/:id/edit", TopicController, :edit
    # put "/topics/:id", TopicController, :update
    resources "/", TopicController
  end

  # Other scopes may use custom stacks.
  # scope "/api", Discuss do
  #   pipe_through :api
  # end
end
```



**END**
