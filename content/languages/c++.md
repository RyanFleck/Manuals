---
title: "C++"
date: 2020-08-01T09:00:00-05:00
toc: true
image: "/content-cover-images/coffee-phone.jpg"
summary: "Notes on the crack vaccum for CSI2372."
draft: false
---

# Hello C++

Like C, but object oriented.

Like Java, but far less intuitive.

Like a vaccum cleaner with burn, soak, espresso machine, and do taxes settings, C++ is a speedy swiss army knife with a billion functions.

```cpp
#include <iostream>

int main(){
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

```
target: dependencies
    build command
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

# The Bare Necessities

Basic C++ supports the following elementary types:
_int, float, double, long double, char,_ and _bool._ With the `#include<string>` library, the type _string_ is also available for use.
