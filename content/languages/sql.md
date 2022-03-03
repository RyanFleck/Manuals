---
toc: true
date: 2022-03-02T10:52:56.000-07:00
image: "/content-cover-images/coffee-phone.jpg"
summary: For table querying and manipulation.
title: SQL

---
# What is SQL?

Structured Query Language (SQL) is used to retrieve and modify information in a **relational database** like MySQL, PostgreSQL, Microsoft SQL, Oracle DB, and others. Relational databases store data in large relational tables, where each row must conform to the types specified in the table columns, where cell contents must be either data, nothing, or a reference to a row in another table.

## ORMs

Modern developers could live out a career without ever touching SQL due to the variety of well built object-relational-mappers that exist to translate objects built in an object-oriented language to SQL queries for insertion, retrieval, and manipulation. This is unfortunate in the same way a lack of knowledge about a CPU, machine code, assembly languages, or C is unfortunate: It means the programmer in question is operating on blind abstraction. This is obviously useful right up to the moment when performance tuning, a bug, or some other issue necessitating critical introspection of a codebase appears.