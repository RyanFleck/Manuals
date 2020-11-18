---
title: "C++"
date: 2020-08-01T09:00:00-05:00
toc: true
image: "/content-cover-images/coffee-phone.jpg"
summary: "Notes on the C++ language for CSI2372."
draft: false
---

# Hello C++

Like C, but object oriented.

Like Java, but far less intuitive.

Like a vaccum cleaner with burn, soak, espresso machine, and do taxes settings, C++ is a speedy swiss army knife with a billion functions.

```cpp
#include <iostream>

// Like C, C++ programs have a main function
int main(){
    // Print characters to standard output
    std::cout << "Hello World!" << std::endl;
    return 0;
}
```

# Compiling and Executing

C++ is a compiled and statically-typed language.
Many possible bugs that you can write will be caught early by checks run during the compilation process.
To get started, install the c++ build tools:

```sh
$ sudo apt-get install g++ make
```

Compile the hello world program with **g++**, like this:

```sh
$ g++ hello.cpp -o hello
$ ./hello
Hello World!
```

_Congrats!_ You've just built and run your first C++ program. What a champion!

# Makefiles

Before I touch on the myriad of complex build systems in C++, please take a look at the very simplest build system, **make**. This may look overwheliming at first, but I can explain:

```make
# CSI2372 Generic Makefile

.PHONY: all

all: e1.o e2.o

e1.o: myFile1.cpp myFile1a.h myFile1b.h
	g++ -Wall -o e1.o myFile1.cpp

e2.o: myfile2.cpp SetInt.h
	g++ -Wall -o e2.o myfile2.cpp
```

Make clauses are structured like this:

```make
target: dependencies
    build-command
```

The `.PHONY` special case will run every time make is executed.

This `Makefile` is structured so `e1.o` and `e2.o` (the output for exercises
one and two for a CSI lab) will be compiled. Here are the steps:

1. The makefile is run.
1. Make checks what is required to make the `all` target.
1. Make checks what is required to make `e1.o` and `e2.o`.
1. Make checks all the files that `e1.o` and `e2.o` depend on are present, and builds them.
1. If they are already built, it makes sure none of the files they depend on have changed since the last build.

By following these steps, **make** can ensure that, whenever it is run, all the executables that rely on old code are rebuilt, and you're always running the latest compiled code.

For further commentary on compiling with header files, see the
section [Compiling with Headers](#compiling-ii-with-headers).

# The Bare Necessities

In the following subsections, I'll cover the most basic features of the
language, which should be easy to pick up if you have previous
programming experience with another programming language, especially C or Java.

Things in C++ are named with **identifiers**, which can be a series of characters and numbers from a-z, A-Z, 0-9, and underscores. An identifier cannot start with a number.

## Static Typing and Variables

Basic C++ supports the following elementary types:
_int, float, double, long double, char,_ and _bool._ With the `#include<string>` library, the type _string_ is also available for use.

```cpp
// Simple variable declarations:
double x;
bool y;
int p;
```

Standard C++ hackery allows you to declare and initialize variables
in the following ways:

```cpp
double v = 32.123;
double v(32.123);
```

Additionally, you can declare and optionally
initialize multiple variables at the same time:

```cpp
int a=2, b=3, c, d, e=4;
```

The **const** keyword can be used to declare a variable which cannot be re-assigned:

```cpp
const int height = 182;
```

## Arrays

The C programming language makes extensive use of arrays,
and C++ continues that tradition. To initialize an array:

```cpp
// type name[size?] = {elem elem elem};
// type name[size];

int scores[10];
int scores[] = { 1, 2, 3, 4 }
int scores[10] = { 1, 2, 3, 4 }
int scores[3][3] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }
int scores[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
```

Providing both a length and values will fill the non-specified values with the default value of the array's class. For `int`, zero is provided.

## Input and Output

Print to the screen with **cout**:

```cpp
cout << "X is 3! Wow!" << endl;
```

Take input with **cin**:

```cpp
int x;
cout << "Enter your favourite integer:";
cin >> x;
// x now holds the user-entered number.
```

## Control Flow

Control flow constructs allow logic to run under certain conditions.

```cpp
if(x == 3){
    cout << "X is 3! Wow!" << endl;
}else{
    cout << "X is not 3." << endl;
}
```

A simple **for** loop that prints numbers up to a target:

```cpp
int target = 200;
for(int i=0; i<target; i++){
    cout << "i has value: " << i << endl;
}
```

A **while** loop to do the same:

```cpp
int count = 0;
while (count <= 200) {
    cout << "count has value: " << count << endl;
    count++;
}
```

A **do-while** loop to do the same:

```cpp
int count = 0;
do {
    cout << "count has value: " << count << endl;
    count++;
} while (count <= 200);
```

The **ternary if**, never nest this or your coworkers will hate you
forever and thereafter.

```cpp
string res = b ? "b is true" : "b is false";
```

## Functions

Logic can be compartmentalized into functions that can be called from other parts
of a C++ program.

C++, being a derivative of c, does not automatically hoist functions, so you must
provide the _declaration_ of a function at the top of a file, or in the header,
if you plan to call the function within a different function that is instantiated above
the original.

```cpp
// return-type name( arguments with types ){
//   function content
//   return return-type
// }

int max(int a, int b){
    return a > b ? a : b;
}
```

### Static

Within functions, **static** variables can be declared that won't be changed
from one call to the next, unless the program is reset.

```cpp
int max(int a){
    static b;
    if( a > b ) b = a;
    return b;
}
```

### Inline

A function can be placed into the body of the parent it is called in with the **inline** keyword.

```cpp
inline int max(int a){
    static b;
    if( a > b ) b = a;
    return b;
}
```

### Default Arguments

Functions can be given default arguments by using the equals sign within the
arguments in the instantiation:

```cpp
int addOne(int a = 10){
    return a + 1;
}

addOne(4);  // returns 5
addOne();   // returns 11
```

### Overloading Functions

You can provide multiple definitions for the same function name, as long as different
arguments or argument types are specified:

```cpp
int addOne(int a){
    return a + 1;
}

float addOne(float a){
    return a + 1;
}
```

## Namespaces

You can call functions from other namespaces by prepending a function name with
the namespace name, or you can **use** a namespace to make all the functions
accessible to the current program.

Without namespace:

```cpp
#include <iostream>
// ...
std::cout << "Hello World!" << std::endl;
```

With namespace:

```cpp
#include <iostream>
using namespace std;
// ...
cout << "Hello World!" << endl;
```

You've probably noticed that just the `std::` has been removed from the second program's calls to the iostream functions.

To create your own namespace use the **namespace** keyword to wrap functions,
variables, and classes:

```cpp
namespace rcf{
    int three(){
        return 3;
    }
}

// ...

rcf::three();
```

# Compiling II: With Headers

Attempting to cram a huge program into a single source file is very impractical,
and you should regard anybody who does so as either incredibly lazy or more
than a little bit masochistic. For this reason, Kernighan and Stroustrup have provided
methods for splitting your code into multiple source and header files.

Typically, a header file will include function and class declarations needed by all files in the program, and logic needed only in a given file is kept there.

As it quickly becomes impractical to compile a large set of files, C++ has a great
number of complex build systems to manage source and header files, along with required
libraries. Typing very long build commands is, to say the least, prone to error.

A [Makefile](#makefiles) is the simplest way to compile a complex program made of more than a few files.

```sh
# TODO: Provide better example:
g++ a.cpp -o a.o
```

# Pointers

If you've only ever used _Python_, _JavaScript_, _Ruby_, or _Java_,
and have never dabbled with an assembly language or C,
you're in for a treat.

**In simple terms, a pointer holds an address.**

That's it. Remember this. A pointer holds the address of a memory location.

```cpp
//  &  The address operator, an ampersand.
//  *  The pointer operator, a star.
```

Here's a basic example of how pointers work:

```cpp
int a = 3;    // a holds 3
int *b = &a;  // b points to the address of a
*b = 4;       // the address that b points to now holds 4
cout << a;    // prints '4' to the console.
```

# Sections to Add

- Vectors
- Scope

```

```
