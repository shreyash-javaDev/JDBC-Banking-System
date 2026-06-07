# JDBC-Banking-System


## Overview

A console-based Banking System developed using Java, JDBC, and MySQL. The application allows users to manage customer accounts and perform banking transactions.

## Features

* Create Customer Account
* View Account Details
* Update Customer Information
* Delete Customer Account
* Money Transfer Between Accounts
* Transaction Management using JDBC
* MySQL Database Integration

## Technologies Used

* Java
* JDBC
* MySQL
* Eclipse IDE

## Database Setup

```sql
CREATE DATABASE banking_system;

USE banking_system;

CREATE TABLE customers (
    account_no BIGINT PRIMARY KEY,
    name VARCHAR(100),
    balance DOUBLE
);
```

## How to Run

1. Install MySQL Server and MySQL Workbench.
2. Create the database and table.
3. Add MySQL Connector/J JAR to the project.
4. Update database credentials in `DBConnection.java`.
5. Run `Main.java`.

## Author

Shreyash Sable
