# Client Registry System

A desktop CRUD application built with **Java Swing** for registering and managing clients. All data is stored **in-memory** with two interchangeable storage strategies: **HashMap** and **HashSet**.

## Overview

The system allows creating, reading, updating, and deleting clients through a graphical interface. A single `Client` object holds seven properties: name, CPF, telephone, address, number, city, and state. The UI displays all registered clients in a table and provides a form for data input.

## Technologies

- **Java 21** - Core language
- **Java Swing** - Desktop GUI framework (JFrame, JTable, JTextField, JOptionPane, GroupLayout)
- **Gradle 9.3.0** - Build tool with Kotlin DSL
- **Guava 33.4.6** - Google's Java utility library
- **JUnit 5** - Testing framework

## Architecture

The project follows the **DAO (Data Access Object)** pattern with a strategy-based approach for storage:

- `IClientDAO` - Interface defining CRUD operations
- `ClientMapDAO` - Implementation using `TreeMap<Long, Client>` (keyed by CPF, sorted)
- `ClientSetDAO` - Implementation using `HashSet<Client>` (unordered, linear lookup)

Both implementations are interchangeable. The UI depends only on the `IClientDAO` interface, so switching between them requires changing a single line of code.

## Project Structure

```
app/src/main/java/dev/cauegallizzi/
├── clientregistryswing/
│   ├── App.java          # Entry point
│   └── Home.java         # Main UI window (form, table, event handlers)
├── dao/
│   ├── IClientDAO.java   # DAO interface
│   ├── ClientMapDAO.java # TreeMap-based storage
│   └── ClientSetDAO.java # HashSet-based storage
└── domain/
    └── Client.java       # Client model (name, cpf, tel, address, number, city, state)
```
