---
toc: true
date: 2022-03-02T10:52:56.000-07:00
image: "/content-cover-images/coffee-phone.jpg"
summary: For table querying and manipulation.
title: SQL

---
# What is SQL?

Structured Query Language (SQL) is used to retrieve and modify information in a **relational database** like MySQL, PostgreSQL, Microsoft SQL, Oracle DB, and others. Relational databases store data in large relational tables, where each row must conform to the types specified in the table columns, where cell contents must be either data, nothing, or a reference to a row in another table.

Use the [W3Schools Try-It Editor](https://www.w3schools.com/sql/trysql.asp?filename=trysql_op_or) to tinker with SQL now.

## ORMs

Object Relational Mappers (ORMs) are abstractions used by web developers to interact with relational databases.

Modern developers could live out a career without ever touching SQL due to the variety of well built ORMs that exist to translate objects built in an object-oriented language to SQL queries for insertion, retrieval, and manipulation. This is unfortunate in the same way a lack of knowledge about a CPU, machine code, assembly languages, or C is unfortunate: It means the programmer in question is operating on blind abstraction. This is obviously useful right up to the moment when performance tuning, a bug, or some other issue necessitating critical introspection of a codebase appears.

# Commands

This section contains a short usage guide for each of the common SQL commands.

## SELECT