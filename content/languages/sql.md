---
toc: true
date: 2022-03-02T10:52:56.000-07:00
image: "/content-cover-images/coffee-phone.jpg"
summary: For table querying and manipulation.
title: SQL

---
# What is SQL?

Structured Query Language (SQL) is used to retrieve and modify information in a **relational database management system** like MySQL, PostgreSQL, [SQLite](https://sqlite.org/codeofethics.html), Microsoft SQL, Oracle, and others. Relational databases store data in large relational tables, where each row must conform to the types specified in the table columns, where cell contents must be either data, nothing, or a reference to a row in another table.

Use the [W3Schools Try-It Editor](https://www.w3schools.com/sql/trysql.asp?filename=trysql_op_or) to tinker with SQL now.

## ORMs

Object Relational Mappers (ORMs) are abstractions used by web developers to interact with relational databases.

Modern developers could live out a career without ever touching SQL due to the variety of well built ORMs that exist to translate objects built in an object-oriented language to SQL queries for insertion, retrieval, and manipulation. This is unfortunate in the same way a lack of knowledge about a CPU, machine code, assembly languages, or C is unfortunate: It means the programmer in question is operating on blind abstraction. This is obviously useful right up to the moment when performance tuning, a bug, or some other issue necessitating critical introspection of a codebase appears.

## Differences Between SQL Flavors

All of the aforementioned DBMS (Database Management System) flavors like MySQL and PostgreSQL use similar dialects of a common SQL standard. Statements are often similar or identical, but each flavor has slight differences in syntax.

Flavors differentiate themselves with the features they offer the business and developer, including:

* Special storage functions or data attributes
* Query speed or general performance
* Security
* Resiliency

## Note on Syntax

* SQL keywords are **not case sensitive**
* Every statement must end with a semicolon
* Table names don't seem to be case sensitive

# Administration

It's easy to install PostgreSQL on alpine linux with this set of commands. This will install the database system, add it as a default program to run, and open the firewall to allow external access to the database.

```bash
sudo su
apk update
apk add postgresql
service start postgresql
rc-update add postgresql default
ufw allow postgresql/tcp
```

You can then find the configuration files by writing:

```bash
psql -U postgres -c 'SHOW config_file'
#  /etc/postgresql/postgresql.conf

psql -U postgres -c 'SHOW data_directory'
#  /var/lib/postgresql/13/data
```

Enable remote connections with these actions:

```bash
echo "host all all 0.0.0.0/0 md5" >> /var/lib/postgresql/13/data/pg_hba.conf

echo "listen_addresses='*'" >> /var/lib/postgresql/13/data/postgresql.conf
```

Locking this down once you find you can connect is a good idea.

Check [this](https://luppeng.wordpress.com/2020/02/28/install-and-start-postgresql-on-alpine-linux/) and [that](https://www.loggly.com/use-cases/postgresql-logs-logging-setup-and-troubleshooting/) for further setup guidance.

For running commands use [DbGate](https://dbgate.org/)

# Commands

This section contains a short usage guide for each of the common SQL commands, with one or two composition examples.

## SELECT

Retreives data from a table.

```sql
SELECT <columns or * for all> FROM <table>;
```

```sql
SELECT * FROM products;
```

## UPDATE

```sql
UPDATE <table> SET <column>=<value>, <column2>=<value> WHERE <condition>;
```

## DELETE

```sql
DELETE FROM <table> WHERE <condition>;
```

## CREATE DATABASE

```sql
CREATE DATABASE <database name>;
```

## DROP DATABASE

_**DON'T F@#%!NG DO THIS!**_

```sql
SHOW DATABASES; -- List all existing databases
DROP DATABASE <name>;
```

## CREATE TABLE

```sql
CREATE TABLE <name> (
  column_name type,
  column_name type,
  column_name type,
  column_name type
);
```

## ALTER TABLE

```sql
ALTER TABLE <table> ADD <column name> <type>;
```

## INSERT INTO

## DROP TABLE

## CREATE INDEX

## DROP INDEX

# SQLite Code of Ethics

This is just awesome. Included because people should think ethically about the things they create, especially fintech software.

> "I could have edited the list down to just those aspects that seem relevant to coding, but that would put me in the position of editing and redacting Benedict of Nursia, as if I were wiser than he. And I considered that. But in the end, I thought it better to include the whole thing without change (other than translation into English). In the preface, I tried to make clear that the introspective aspects could be safely glossed over."   
> \- **Richard Hipp**

## 1. History

This document was originally called a "Code of Conduct" and was created for the purpose of filling in a box on "supplier registration" forms submitted to the SQLite developers by some clients. However, we subsequently learned that "Code of Conduct" has a very specific and almost sacred meaning to some readers, a meaning to which this document does not conform [\[1\]](https://web.archive.org/web/20220122061306/https://www.theregister.co.uk/2018/10/22/sqlite_code_of_conduct/)[\[2\]](https://web.archive.org/web/20220122061306/https://pjmedia.com/news-and-politics/paula-bolyard/2018/10/24/tech-community-outraged-after-sqlite-founder-adopts-christian-code-of-conduct-n61746)[\[3\]](https://web.archive.org/web/20220122061306/https://www.youtube.com/watch?v=S48VzyCwwtk). Therefore this document was renamed to "Code of Ethics", as we are encouraged to do by rule 71 in particular and also rules 2, 8, 9, 18, 19, 30, 66, and in the spirit of all the rest.

This document continues to be used for its original purpose - providing a reference to fill in the "code of conduct" box on supplier registration forms.

## 2. Purpose

The founder of SQLite, and all of the current developers at the time when this document was composed, have pledged to govern their interactions with each other, with their clients, and with the larger SQLite user community in accordance with the "instruments of good works" from chapter 4 of [The Rule of St. Benedict](https://web.archive.org/web/20220122061306/https://en.wikipedia.org/wiki/Rule_of_Saint_Benedict) (hereafter: "The Rule"). This code of ethics has proven its mettle in thousands of diverse communities for over 1,500 years, and has served as a baseline for many civil law codes since the time of Charlemagne.

### 2.1. Scope of Application

No one is required to follow The Rule, to know The Rule, or even to think that The Rule is a good idea. The Founder of SQLite believes that anyone who follows The Rule will live a happier and more productive life, but individuals are free to dispute or ignore that advice if they wish.

The founder of SQLite and all current developers have pledged to follow the spirit of The Rule to the best of their ability. They view The Rule as their promise to all SQLite users of how the developers are expected to behave. This is a one-way promise, or covenant. In other words, the developers are saying: "We will treat you this way regardless of how you treat us."

## 3. The Rule

 1. First of all, love the Lord God with your whole heart, your whole soul, and your whole strength.
 2. Then, love your neighbor as yourself.
 3. Do not murder.
 4. Do not commit adultery.
 5. Do not steal.
 6. Do not covet.
 7. Do not bear false witness.
 8. Honor all people.
 9. Do not do to another what you would not have done to yourself.
10. Deny oneself in order to follow Christ.
11. Chastise the body.
12. Do not become attached to pleasures.
13. Love fasting.
14. Relieve the poor.
15. Clothe the naked.
16. Visit the sick.
17. Bury the dead.
18. Be a help in times of trouble.
19. Console the sorrowing.
20. Be a stranger to the world's ways.
21. Prefer nothing more than the love of Christ.
22. Do not give way to anger.
23. Do not nurse a grudge.
24. Do not entertain deceit in your heart.
25. Do not give a false peace.
26. Do not forsake charity.
27. Do not swear, for fear of perjuring yourself.
28. Utter only truth from heart and mouth.
29. Do not return evil for evil.
30. Do no wrong to anyone, and bear patiently wrongs done to yourself.
31. Love your enemies.
32. Do not curse those who curse you, but rather bless them.
33. Bear persecution for justice's sake.
34. Be not proud.
35. Be not addicted to wine.
36. Be not a great eater.
37. Be not drowsy.
38. Be not lazy.
39. Be not a grumbler.
40. Be not a detractor.
41. Put your hope in God.
42. Attribute to God, and not to self, whatever good you see in yourself.
43. Recognize always that evil is your own doing, and to impute it to yourself.
44. Fear the Day of Judgment.
45. Be in dread of hell.
46. Desire eternal life with all the passion of the spirit.
47. Keep death daily before your eyes.
48. Keep constant guard over the actions of your life.
49. Know for certain that God sees you everywhere.
50. When wrongful thoughts come into your heart, dash them against Christ immediately.
51. Disclose wrongful thoughts to your spiritual mentor.
52. Guard your tongue against evil and depraved speech.
53. Do not love much talking.
54. Speak no useless words or words that move to laughter.
55. Do not love much or boisterous laughter.
56. Listen willingly to holy reading.
57. Devote yourself frequently to prayer.
58. Daily in your prayers, with tears and sighs, confess your past sins to God, and amend them for the future.
59. Fulfill not the desires of the flesh; hate your own will.
60. Obey in all things the commands of those whom God has placed in authority over you even though they (which God forbid) should act otherwise, mindful of the Lord's precept, "Do what they say, but not what they do."
61. Do not wish to be called holy before one is holy; but first to be holy, that you may be truly so called.
62. Fulfill God's commandments daily in your deeds.
63. Love chastity.
64. Hate no one.
65. Be not jealous, nor harbor envy.
66. Do not love quarreling.
67. Shun arrogance.
68. Respect your seniors.
69. Love your juniors.
70. Pray for your enemies in the love of Christ.
71. Make peace with your adversary before the sun sets.
72. Never despair of God's mercy.