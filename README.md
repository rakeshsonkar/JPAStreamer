# SQL Equivalents

This repository contains a set of typical database queries that can be expressed using JPAStreamer. For users familiar with SQL, this guide provides insights into translating SQL queries into Streams. The examples featured here are based on the MySQL "sakila" example database, which simulates a classic movie rental store. In JPAStreamer, an object corresponding to a row in the database is conventionally referred to as an "Entity".

The table below outlines how SQL operators map to the Java Stream API:

| SQL      | Java Stream       |
|----------|-------------------|
| FROM     | stream()          |
| SELECT   | map(Projection.select()) |
| WHERE    | filter() (before collecting) |
| ORDER BY | sorted()          |
| OFFSET   | skip()            |
| LIMIT    | limit()           |
| COUNT    | count()           |
| GROUP BY | collect(groupingBY()) |
| HAVING   | filter() (after collecting) |
| DISTINCT | distinct()        |
| UNION    | concat(s0, s1).distinct() |
| JOIN     | flatmap()         |

Feel free to explore the code examples provided in this repository to gain a deeper understanding of how to utilize JPAStreamer effectively.
