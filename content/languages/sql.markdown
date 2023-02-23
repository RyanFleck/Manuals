---
title: "SQL"
date: 2021-12-28T10:21:42-07:00
toc: true
image: "/content-cover-images/coffee-phone.jpg"
summary: "Notes on SQL"
---

# Hello SQL

SQL (Structured Query Language) pronounced "Sequel" enables programs to interact with relational databases like PostgreSQL, MS-SQL, Oracle, etc.

```sql
SELECT name, company_id, height FROM People
WHERE height > 180
LEFT JOIN Companies ON People.company_id = Companies.id;
```


# Syntax Basics


# Administration

## Logging in/out

```sh
$ mysql -u <username> -p
Enter password: ****************
```


## Creating a new Database

```sql
CREATE DATATABSE <name>;
SHOW DATABASES;  -- Verify that the database was created.
```

# Side Notes

## Object Relational Mapping

Most of my SQL experience has been through ORMs, or Object Relational Mappers.
These tools make it easy to build objects in your language of choice that can be
seamlessly thrown back and forth between a database, with no need to write SQL
yourself. Unfortunately, these libraries have prevented me from learning or understanding the
full capabilities of SQL, as abstractions always do.

Common ORMs:

- Javascript -> Sequelize
- Python -> SQLAlchemy
- Rails -> Active Record
- Django -> Django ORM

However, this page is about _moving away from ORMs_, so I'll not be discussing
the usage of any of these libraries on this page.

