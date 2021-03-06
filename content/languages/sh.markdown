---
layout: docs-manual
title: Bash
summary: "Glue for sticking together useful programs to do stuff."
draft: true
---

```bash
echo "Hello, BASH!"
```

## Why write Shell Scripts?

'Cause having your computer do something you do daily _on your behalf_ is fantastic.

## What is Bash Shell Scripting?

Bash is a _Unix Shell_, allowing a user to interact with an operating system by entering commands.

**Shell Scripting** is to write _Bash Scripts_ to run in the _Bash Shell_. Unfortunately, I need to look up the syntax every time I write it, so included here are primarily the fundamentals from miscallaneous sources.

## Shell Scripting Fundamentals

A _Shell Script_ is essentially a set of unix programs running sequentially, with control flow. It can be saved to any filename (though preferably one with a `.sh` extension,) and made executable with `chmod +x <filename>`. The first line in any shell script should be `#!/bin/sh`. (Do note that you can also specify zsh, bash, csh, etc.)

### Standard Output and Comments

Single line comments, the only comments, begin with an octothorpe `#`. The `echo` program is called to send standard output.

```sh
# Here, I'll print a simple string:
echo "a simple string. No semicolon needed."
```

...Aaaand, I'll get to the rest of this page eventually. I'll just leave one of my favourite quotes here:

> ...and my Dad always used to say, if you think the World should be a certain way, you have to be a part of the change you want to see in the World, or you should shut the fuck up and stop bitching about it.

> \- [Louis Rossman](https://youtu.be/pBR3Sw9X93s?t=321)
