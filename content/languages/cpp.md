---
title: "C++"
date: 2020-08-01T09:00:00-05:00
toc: true
image: "/content-cover-images/coffee-phone.jpg"
summary: "Notes on the C++ language for CSI2372."
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

> C++ is designed to allow you to express ideas, but if you don't have ideas or don't have any clue about how to express them, C++ doesn't offer much help. <br /> &nbsp;&mdash; Bjarne Stroustrup[^cpp]

[^cpp]: The C++ Programming Language, Bjarne Stroustrup

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

### Static Variables

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

## Command Line Arguments

To pass input to a program, one may pass command line arguments.
It is easy to print all the arguments by iterating through the
elements given in `argv`. Conveniently, the number of arguments
is passed as `argc`, allowing C++ users to use a for loop to
iterate through the input.

```cpp
#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
    cout << "Arguments passed to program:" << endl;

    // The number of elements is given as 'argc'
    for(int i=0; i<argc; i++)
    {
        // Print commas between elements
        if(i!=0) cout << ", ";

        // Print the positional argument
        cout << argv[i];
    }

    // End the list
    cout << endl;
    return 0;
}
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

<!-- CSI2372 Lecture 3 -->

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
(*b)++;       // Increment the value that b points to
cout << a;    // prints '5' to the console.
```

It's a complex poetry, but with this simple tool, we can do a lot.

## Manipulating Arrays

Probably one of the most important features of pointers is the ability to
iterate by a single (class-bit-width) in memory. We can do this because
pointers are fundamentally of the type `lvalue`. Array names are pointers,
and using this pointer is the most common way to iterate through an array.
Note that the example below uses multiple methods to access array members.

```cpp
int x[100];  // x is equivalent to &x[0]

// Fill the array with stuff
for(int i=0; i<100; i++) *(x+i) = i;

// Prints 0 .. 99
for(int i=0; i<100; i++) cout << x[i] << endl;

// Prints 0 .. 99
int i = 0;
while(i<100) cout << *(x+i++) << endl;
```

## Dynamic Memory Management

Memory can be allocated by the programmer with the _new_ and _delete_ operators.

```cpp
int *x;       // Empty pointer of type int
x = new int;  // Allocate a new chunk of storage
*x = 4;       // Place something in there
```

### New

New can be used to allocate memory for any type of primitive or object.

```cpp
// Allocate a single spot, an array,
// and a cube array of type *type*
new type;
new type[n];
new type[a][b][c];
```

### Delete

Complimentary to _new_, we can also _delete_ the objects and primitives
that are referenced by pointers with the delete keyword.

```cpp
int *x;
x = new int[100];
delete x;
```

## Pointers to Functions

It's possible to set pointers to functions. Here, assume **func** is a previously
defined function that returns a string and takes an integer as an argument.

```cpp
string (*x)(int);
x = func;
x(3);
```

In this way, you can also require pointers to functions in function arguments.

# Strings

<!-- CSI2372 Lecture 4 -->

Many C++ programs use traditional C style strings:

```cpp
char x[] = {"Hello"};
char y[] = {'H','e','l','l','o','\0'};
```

# Object Oriented Programming

C++ brings **OOP** to the C programming language.

Object oriented programming (commonly shortened to **OOP**,) involves the
encapsulation of related groups of logic and properties into entities called
objects, which are structured according to templates known as
classes, structures, unions, and enumerations.

## Special Types

Modern C++ continues to make use of C's structures, unions,
and enumerations to hold sets of related data.

### Struct

**Structures**, defined with the keyword **struct**, are simple storage
devices for related variables. Once defined, you can instantiate many
instances of a structure, and all of them will be assigned memory
to hold the set of properties that you specify.

Simple usage of the **struct** keyword:

```cpp
#include <iostream>
using namespace std;

int main()
{
    struct item
    {
        string name;
        int serial;
        float cost_cad;
        float weight_kg;
    };

    // Create an instance of item
    item block;

    // Set the properties of block
    block.name = "Wooden Block";
    block.serial = 1924573;
    block.cost_cad = 7.99;
    block.weight_kg = 1.0;

    // Print the block properties:
    cout << "Item: " << endl;
    cout << "Name: " << block.name << endl;
    cout << "Serial No: " << block.serial<< endl;
    cout << "Cost (CAD): " << block.cost_cad << endl;
    cout << "Weight (Kg): " << block.weight_kg << endl;
}
```

Any variable within a struct can be used just like any ordinary variable
that was instantiated outside of a struct.

You can also instantiate an array with a structure type.

### Union

**Unions** are like enumerations, and can be instantiated with a list of
variables with types. _Unlike structures,_ when a union is instantiated,
it may only populate one of the list of contained variables. This allows
the same memory location to be populated with data of varying types.

```cpp
#include <iostream>
using namespace std;

int main()
{
    union item
    {
        int serial;
        float cost_cad;
        float weight_kg;
    };

    // Create an instance of item
    item block;

    // Set the properties of block
    block.cost_cad = 7.99;
}
```

When a union is reassigned (for example, if serial was set after cost in
the example above,) the value in memory is overwritten. If cost was printed
after serial was set on the item, it would return the floating point representation
of the integer which was set _-- probably a very negative number!_

### Enum

**Enumerations** are used to store groups of constants, so rather than using
numbers to store states, easy-to-read, all-caps variables exist. Try it:

```cpp
#include <iostream>
using namespace std;

int main()
{
    enum color { red, green, blue, yellow };
    cout << red << endl; // Prints '0'
}
```

By storing states as (implicit) integers, we can increase readability
without sacrificing runtime performance. You **cannot** use the same
name between enums within the same scope in C++.

### Typedef

**Make your own type!** The **Typedef** keyword enables programmers to
visually simplify their programs (and confuse others) by reassigning
types. For instance:

```cpp
typedef long double wunderbarnumber;
wunderbarnumber x;
```

## Classes

A **class** encapsulates a set of associated variables and functions.
Let's dive right in with our first class. We **declare** a class
by stating all of its private and public methods and data.

```cpp
#include <iostream>
using namespace std;

class Man
{
private:
    string name;
    int height;
    int weight;
    bool vegetarian;
    bool drinker;
    int chest;
    int ribs;
    int iq;
public:
    Man(string name, int height, int weight);
    void walk(float latitude, float longitude, float altitude);
    void speak();
};
```

### Constructor

Let's **define** the constructor that was declared in the class definition.

All we need to do is set all of the private variables to the input
that will be given in the object instantiation call.

```cpp
Man::Man(string n, int h, int w)
{
    cout << "Instantiating a Man '"<< n << "'" << endl;
    height = h;
    weight = w;
    name = n;
}
```

### Method Definitions

Now we can provide **definitions** for the rest of the function declarations.

```cpp
void Man::speak()
{
    cout << "My name is " << name << "." << endl;
    cout << "I am " << height << "cm tall." << endl;
    cout << "I weigh " << weight << "kg." << endl;
}

void Man::walk(float latitude, float longitude, float altitude)
{
    cout << "Walking to " << latitude << ","
         << longitude << "," << altitude << endl;
}
```

### Compile and Run an Example

We can now use the **Man** class in an example.

```cpp
int main()
{
    Man j = Man("Jeremy", 182, 70);
    j.speak();
    j.walk(51.05011, -114.08529, 1086.00);
}
```

Lastly, let's run the thing and ensure that everything is working as expected
and giving the output we'd like. Save the code above as `main.cpp` and compile
with `g++`:

```
$ g++ main.cpp && ./a.out
Instantiating a Man 'Jeremy'
My name is Jeremy.
I am 182cm tall.
I weigh 70kg.
Walking to 51.0501,-114.085,1086
```

### Destructor

A class destructor is called, predictably, when an object is destroyed. Destructors have the same name as the class, but include a tilde (`~`) at
the beginning of the name. Any cleanup that needs to occur before an object
is destroyed can occur in the constructor.

Destructors do not take arguments.

```cpp
Man::~Man()
{
    cout << "AAAUGH! My brothers will avenge me!" << endl;
}
```

By combining a constructor and destructor, we can dynamically allocate
memory when an object is created based on current requirements,
and ensure that the memory is freed when the object is destroyed.

```cpp
#include <iostream>
using namespace std;

class Frigate
{
private:
    // Let's track the remaining ammunition
    // for a dynamic number of guns on board
    int * gunAmmoStores;
public:
    Frigate(int numGuns);
    ~Frigate();
};

Frigate::Frigate(int numGuns)
{
    // Allocate the gun ammo tracker array
    gunAmmoStores = new int[numGuns];
    // Load 10 bullets into each cannon
    for(int i=0; i<numGuns; i++) gunAmmoStores[i] = 10;
}

Frigate::~Frigate()
{
    // De-allocate memory
    delete gunAmmoStores;
}

int main()
{
    Frigate x = Frigate(21);
}
```

### Static Members

Ha ha.

A **static** declaration enables the sharing of data between object of the same class.

```cpp
class Frigate
{
private:
    // All frigates use and can modify this
    static int shipsInFleet;
    // All frigates can use this number
    static const int maxSpeed = 30;
public:
    Frigate(int numGuns);
};
```

## Objects

<!-- CSI2372 Lecture 5 -->
<!-- CSI2372 Lecture 6 -->
<!-- CSI2372 Lecture 7 -->
<!-- CSI2372 Lecture 8 -->
<!-- CSI2372 Lecture 9 -->
<!-- CSI2372 Lecture 10 -->
<!-- CSI2372 Lecture 11 -->
<!-- CSI2372 Lecture 12 -->
<!-- CSI2372 Lecture 13 -->
<!-- CSI2372 Lecture 14 -->
<!-- CSI2372 Lecture 15 -->
<!-- CSI2372 Lecture 16 -->
<!-- CSI2372 Lecture 17 -->
<!-- CSI2372 Lecture 18 -->

<!-- Sections to add: Vectors, Sceope -->

# Vectors

Vectors are dynamic arrays.

```cpp
#include <iostream>
#include <vector>
using namespace std;

int main()
{
    // Define as: vector<type> name
    vector<int> v;

    // Push a few elements
    v.push_back(3);
    v.push_back(9);
    v.push_back(2);
    v.push_back(8);
    v.push_back(12);

    // Insert something after '3'
    v.insert(v.begin() + 1, 5);

    // Remove the last element
    v.erase(v.begin() + v.size()-1);

    cout << "Vector: ";
    for(unsigned int i=0; i < v.size(); i++)
    {
        if(i!=0) cout << ", ";
        // alternatively, cout << v[i];
        cout << v.at(i);
    }
    cout << endl;

    // Wipe everything from the vector
    v.clear();

    if(v.empty())
    {
        cout << "The vector was cleared!";
    }
}
```

```sh
# Run the program:
$ g++ main.cpp && ./a.out
Vector: 3, 5, 9, 2, 8
The vector was cleared!

```

# A Note on Programming

Never forget that you are responsible for weaving the dreams of humanity
into panes of cold logic, run by rocks which we
tricked to think with lightning.

More importantly, never forget that computers are not us.
They have no inherent humanity.
Computers reflect the coldest, most logical and calculating part
of ourselves. We must be cautious not to lose ourselves
and forsake our souls
by gazing too affectionately at the reflection on this black mirror.

> We are the music makers, <br />
> And we are the dreamers of dreams, <br />
> Wandering by lone sea-breakers, <br />
> And sitting by desolate streams; <br />
> World-losers and world-forsakers, <br />
> On whom the pale moon gleams: <br />
> Yet we are the movers and shakers <br />
> Of the world for ever, it seems.[^1] <br />

[^1]: From [Ode](https://www.poetryfoundation.org/poets/arthur-oshaughnessy) by Arthur O'Shaughnessy
