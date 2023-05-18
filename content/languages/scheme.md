---
layout: docs-manual
title: Scheme
summary: "I am hacker man! I read HTDP!"
toc: true
---

# Installation on Windows

I know, not UNIX, but it's what I have in front of me. Let's install Racket and iracket for use with Jupyter.

1. Use the [Windows installer](https://racket-lang.org/)
2. Add `C:\Program Files\Racket` to the system path
3. Run `raco pkg install iracket`

# Learning Material

I've got a physical copy of **HTDP 2001**. A copy of this book is accessible [online](https://htdp.org/2003-09-26/Book/curriculum-Z-H-1.html#node_toc_start) along with the [answer key](https://htdp.org/2003-09-26/Solutions/contents.html).

# Notes on MIT's "How To Design Programs" (HTDP) 1e

Chapter summaries and important notes from my own learning.

## I Processing Simple Forms of Data

### 1 Students, Teachers, and Computers

> Some programs are as small as essays. Others are like sets of encyclopedias. Writing good essays and books requires careful planning, and writing good programs does, too. Small or large, a good program cannot be created by tinkering around. It must be carefully designed.

### 2 Numbers, Expressions, Simple Programs

- 2.1 Numbers and Arithmetic
- 2.2 Variables and Programs
- 2.3 Word Problems
- 2.4 Errors
- 2.5 Designing Programs

Scheme uses parentheses `( )` or round brackets to organize programs. A set of parentheses encloses an **expression**.

_Parenthesized expressions._

```scm
(operator input... )
```

Expressions can take in a number of variables:

```scm
(define (area-of-disk r)
  (* 3.14 r r))

(define (area-of-ring outer-r inner-r)
  (- (area-of-disk outer-r) (area-of-disk inner-r)))
```

If it's not in parentheses it's an _atom._

```scm
; Exercise 2.2.1.   Define the program Fahrenheit->Celsius,
; which consumes a temperature measured in Fahrenheit and
; produces the Celsius equivalent. Use a chemistry or
; physics book to look up the conversion formula.

(define (fahrenheit->celsius x)
  (* (- x 32) (/ 5 9)))

(convert-gui fahrenheit->celsius)
```

Scheme allows you to represent fractions directly as well:

```scm
(define (fahrenheit->celsius x)
  (* (- x 32) 5/9 ))
```

...though I'm not a huge fan of that.

Inexact numbers are represented with an `#i` in front.

Here's a word problem and my solution:

> Company XYZ & Co. pays all its employees $12 per hour. A typical employee works between 20 and 65 hours per week. Develop a program that determines the wage of an employee from the number of hours of work.

```scm
(define (wage h)
  (* 12 h))

(define (tax gross-pay)
  (* 0.15 gross-pay))

(define (subtract-taxes net-pay)
  (- net-pay (tax net-pay)))

(define (net-pay h)
  (subtract-taxes (wage h)))
```

My solution is slightly more efficient than [the solution](https://htdp.org/2003-09-26/Solutions/taxed-wage.html) as it does not recompute the gross pay by including the `subtract-taxes` function.

**Designing programs** is something that must be done intentionally and with care. SICP provides a **Design Recipe** which can be followed to yield reliably useful programs.

> We need to determine what's relevant in the problem statement and what we can ignore. We need to understand what the program consumes, what it produces, and how it relates inputs to outputs. We must know, or find out, whether Scheme provides certain basic operations for the data that our program is to process. If not, we might have to develop auxiliary programs that implement these operations. Finally, once we have a program, we must check whether it actually performs the intended computation.

Here is [Figure 3](https://htdp.org/2003-09-26/Book/curriculum-Z-H-5.html#node_sec_2.5), the example recipe:

```scm
;; Contract: area-of-ring : number number  ->  number

;; Purpose: to compute the area of a ring whose radius is
;; outer and whose hole has a radius of inner

;; Example: (area-of-ring 5 3) should produce 50.24

;; Definition: [refines the header]
(define (area-of-ring outer inner)
  (- (area-of-disk outer)
     (area-of-disk inner)))

;; Tests:
(area-of-ring 5 3)
;; expected value
50.24
```

A summary of these phases is provided in [Figure 4](https://htdp.org/2003-09-26/Book/curriculum-Z-H-5.html#node_fig_Temp_22) in this section of the textbook, but I'll summarize here quickly:

- The **Contract** names the function and specifies the class of the input and output data
- The **Purpose** explains the name
- The **Example** lists a sample use case
- The **Definition** is a scheme expression
- Finally, **Tests** ensure output is correct

(Funny, Elixir has real good support for inline tests with  the `doctest` feature. Makes me miss Elixir.)

### 3 Programs are Function Plus Variable Definitions

- 3.1 Composing Functions
- 3.2 Variable Definitions
- 3.3 Finger Exercises on Composing Functions

### 4 Conditional Expressions and Functions

- 4.1 Booleans and Relations
- 4.2 Functions that Test Conditions
- 4.3 Conditionals and Conditional Functions
- 4.4 Designing Conditional Functions

### 5 Symbolic Information

- 5.1 Finger Exercises with Symbols

### 6 Compound Data, Part 1: Structures

- 6.1 Structures
- 6.2 Extended Exercise: Drawing Simple Pictures
- 6.3 Structure Definitions
- 6.4 Data Definitions
- 6.5 Designing Functions for Compound Data
- 6.6 Extended Exercise: Moving Circles and Rectangles
- 6.7 Extended Exercise: Hangman

### 7 The Varieties of Data

- 7.1 Mixing and Distinguishing Data
- 7.2 Designing Functions for Mixed Data
- 7.3 Composing Functions, Revisited
- 7.4 Extended Exercise: Moving Shapes
- 7.5 Input Errors

### 8 Intermezzo 1: Syntax and Semantics

- 8.1 The Scheme Vocabulary
- 8.2 The Scheme Grammar
- 8.3 The Meaning of Scheme
- 8.4 Errors
- 8.5 Boolean Expressions
- 8.6 Variable Definitions
- 8.7 Structure Definitions

## II Processing Arbitrarily Large Data

### 9 Compound Data, Part 2: Lists

9.1 Lists
9.2 Data Definitions for Lists of Arbitrary Length
9.3 Processing Lists of Arbitrary Length
9.4 Designing Functions for Self-Referential Data Definitions
9.5 More on Processing Simple Lists

### 10 More on Processing Lists

- 10.1 Functions that Produce Lists
- 10.2 Lists that Contain Structures
- 10.3 Extended Exercise: Moving Pictures

### 11 Natural Numbers

- 11.1 Defining Natural Numbers
- 11.2 Processing Natural Numbers of Arbitrary Size
- 11.3 Extended Exercise: Creating Lists, Testing Functions
- 11.4 Alternative Data Definitions for Natural Numbers
- 11.5 More on the Nature of Natural Numbers

### 12 Composing Functions, Revisited Again

- 12.1 Designing Complex Programs
- 12.2 Recursive Auxiliary Functions
- 12.3 Generalizing Problems, Generalizing Functions
- 12.4 Extended Exercise: Rearranging Words

### 13 Intermezzo 2: List Abbreviations

## III More on Processing Arbitrarily Large Data

### 14 More Self-referential Data Definitions

- 14.1 Structures in Structures
- 14.2 Extended Exercise: Binary Search Trees
- 14.3 Lists in Lists
- 14.4 Extended Exercise: Evaluating Scheme

### 15 Mutually Referential Data Definitions

- 15.1 Lists of Structures, Lists in Structures
- 15.2 Designing Functions for Mutually Referential Definitions
- 15.3 Extended Exercise: More on Web Pages

### 16 Development through Iterative Refinement

- 16.1 Data Analysis
- 16.2 Defining Data Classes and Refining Them
- 16.3 Refining Functions and Programs

### 17 Processing Two Complex Pieces of Data

- 17.1 Processing Two Lists Simultaneously: Case 1
- 17.2 Processing Two Lists Simultaneously: Case 2
- 17.3 Processing Two Lists Simultaneously: Case 3
- 17.4 Function Simplification
- 17.5 Designing Functions that Consume Two Complex Inputs
- 17.6 Exercises on Processing Two Complex Inputs
- 17.7 Extended Exercise: Evaluating Scheme, Part 2
- 17.8 Equality and Testing

### 18 Intermezzo 3: Local Definitions and Lexical Scope

- 18.1 Organizing Programs with local
- 18.2 Lexical Scope and Block Structure

## IV Abstracting Designs

### 19 Similarities in Definitions

- 19.1 Similarities in Functions
- 19.2 Similarities in Data Definitions

### 20 Functions are Values

- 20.1 Syntax and Semantics
- 20.2 Contracts for Abstract and Polymorphic Functions

### 21 Designing Abstractions from Examples

- 21.1 Abstracting from Examples
- 21.2 Finger Exercises with Abstract List Functions
- 21.3 Abstraction and a Single Point of Control
- 21.4 Extended Exercise: Moving Pictures, Again
- 21.5 Note: Designing Abstractions from Templates

### 22 Designing Abstractions with First-Class Functions

- 22.1 Functions that Produce Functions
- 22.2 Designing Abstractions with Functions-as-Values
- 22.3 A First Look at Graphical User Interfaces

### 23 Mathematical Examples

- 23.1 Sequences and Series
- 23.2 Arithmetic Sequences and Series
- 23.3 Geometric Sequences and Series
- 23.4 The Area Under a Function
- 23.5 The Slope of a Function

### 24 Intermezzo 4: Defining Functions on the Fly

## V Generative Recursion

### 25 A New Form of Recursion

- 25.1 Modeling a Ball on a Table
- 25.2 Sorting Quickly

### 26 Designing Algorithms

- 26.1 Termination
- 26.2 Structural versus Generative Recursion
- 26.3 Making Choices

### 27 Variations on a Theme

- 27.1 Fractals
- 27.2 From Files to Lines, from Lists to Lists of Lists
- 27.3 Binary Search
- 27.4 Newton's Method
- 27.5 Extended Exercise: Gaussian Elimination

### 28 Algorithms that Backtrack

- 28.1 Traversing Graphs
- 28.2 Extended Exercise: Checking (on) Queens

### 29 Intermezzo 5: The Cost of Computing and Vectors

- 29.1 Concrete Time, Abstract Time
- 29.2 The Definition of ``on the Order of''
- 29.3 A First Look at Vectors

## VI Accumulating Knowledge

### 30 The Loss of Knowledge

- 30.1 A Problem with Structural Processing
- 30.2 A Problem with Generative Recursion

### 31 Designing Accumulator-Style Functions

- 31.1 Recognizing the Need for an Accumulator
- 31.2 Accumulator-Style Functions
- 31.3 Transforming Functions into Accumulator-Style

### 32 More Uses of Accumulation

- 32.1 Extended Exercise: Accumulators on Trees
- 32.2 Extended Exercise: Missionaries and Cannibals
- 32.3 Extended Exercise: Board Solitaire

### 33 Intermezzo 6: The Nature of Inexact Numbers

- 33.1 Fixed-size Number Arithmetic
- 33.2 Overflow
- 33.3 Underflow
- 33.4 DrScheme's Numbers

## VII Changing the State of Variables

### 34 Memory for Functions

### 35 Assignment to Variables

- 35.1 Simple Assignments at Work
- 35.2 Sequencing Expression Evaluations
- 35.3 Assignments and Functions
- 35.4 A First Useful Example

### 36 Designing Functions with Memory

- 36.1 The Need for Memory
- 36.2 Memory and State Variables
- 36.3 Functions that Initialize Memory
- 36.4 Functions that Change Memory

### 37 Examples of Memory Usage

- 37.1 Initializing State
- 37.2 State Changes from User Interactions
- 37.3 State Changes from Recursion
- 37.4 Finger Exercises on State Changes
- 37.5 Extended Exercise: Exploring Places

### 38 Intermezzo 7: The Final Syntax and Semantics

- 38.1 The Vocabulary of Advanced Scheme
- 38.2 The Grammar of Advanced Scheme
- 38.3 The Meaning of Advanced Scheme
- 38.4 Errors in Advanced Scheme

## VIII Changing Compound Values

### 39 Encapsulation

- 39.1 Abstracting with State Variables
- 39.2 Practice with Encapsulation

### 40 Mutable Structures

- 40.1 Structures from Functions
- 40.2 Mutable Functional Structures
- 40.3 Mutable Structures
- 40.4 Mutable Vectors
- 40.5 Changing Variables, Changing Structures

### 41 Designing Functions that Change Structures

- 41.1 Why Mutate Structures
- 41.2 Structural Design Recipes and Mutation, Part 1
- 41.3 Structural Design Recipes and Mutation, Part 2
- 41.4 Extended Exercise: Moving Pictures, a Last Time

### 42 Equality

- 42.1 Extensional Equality
- 42.2 Intensional Equality

### 43 Changing Structures, Vectors, and Objects

- 43.1 More Practice with Vectors
- 43.2 Collections of Structures with Cycles
- 43.3 Backtracking with State

**FIN.**
