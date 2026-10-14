# JDBC MySQL SELECT Demo

## Aim
Demonstrate how to connect to a **MySQL** database using **JDBC**, execute a `SELECT` query, and display the retrieved data.

## Problem Statement
A Java program that:
1. Connects to a MySQL database named `mydatabase`
2. Executes `SELECT * FROM users`
3. Displays `id`, `username`, and `email` of each user
4. Handles `SQLException`
5. Uses **try-with-resources** for automatic resource management

## Project Structure
```
jdbc-mysql-demo/
├── output/                  # Sample output / screenshots
│   └── sample_output.txt
├── src/
│   └── JDBCSelectDemo.java
├── README.md
└── .gitignore
```

## Prerequisites
1. **MySQL Server** running on `localhost:3306`
2. Database `mydatabase` created
3. Table `users` with columns: `id` (INT), `username` (VARCHAR), `email` (VARCHAR)
4. **MySQL Connector/J** (JDBC driver) in the classpath

### Sample SQL to set up the table
```sql
CREATE DATABASE IF NOT EXISTS mydatabase;
USE mydatabase;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO users (username, email) VALUES
('johndoe', 'johndoe@example.com'),
('janedoe', 'janedoe@example.com'),
('alice',   'alice@example.com');
```

## How to Compile & Run

```bash
# Download MySQL Connector/J (mysql-connector-j-x.x.x.jar)
# Place it in a convenient location, e.g. lib/

cd src
javac JDBCSelectDemo.java

# Run (adjust the path to the connector jar)
java -cp ".:/path/to/mysql-connector-j-8.x.x.jar" JDBCSelectDemo
```

**Important:** Update the constants inside `JDBCSelectDemo.java`:
```java
private static final String JDBC_URL  = "jdbc:mysql://localhost:3306/mydatabase";
private static final String USERNAME  = "root";
private static final String PASSWORD  = "your_password";
```

## Expected Output
```
Connected to MySQL database successfully!
Retrieving records from 'users' table...

User ID: 1, Username: johndoe, Email: johndoe@example.com
User ID: 2, Username: janedoe, Email: janedoe@example.com
User ID: 3, Username: alice, Email: alice@example.com
```

## Key Concepts Used
- `DriverManager.getConnection()`
- `Statement` + `executeQuery()`
- `ResultSet` navigation with `next()` and getters
- `try-with-resources` (auto-closes Connection, Statement, ResultSet)
- Proper `SQLException` handling

## Constraints Followed
- MySQL database must be running and accessible
- JDBC driver (mysql-connector-java) must be in the classpath
- Table `users` must exist with columns `id`, `username`, `email`
- Uses try-with-resources for automatic resource management
