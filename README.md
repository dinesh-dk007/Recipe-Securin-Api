🍽️ Recipe Data Collection & REST API

A Spring Boot REST API that parses recipe data from a JSON file, stores it in a database, and provides endpoints to manage and query recipes.

This project demonstrates:

JSON Parsing

Database Integration

REST API Development


📌 Objective

This application:

Parses recipe data from a JSON file

Stores it in a relational database

Provides REST APIs to create and retrieve recipes

🛠️ Tech Stack

Java

Spring Boot

Spring Data JPA

Hibernate

MySQL

Jackson (JSON Parsing)

Maven


🚀 API Endpoints

1️⃣ POST /recipes
✅ Purpose

Add a new recipe to the database.

✅ Validation Rules

The following fields are mandatory:

title

cuisine

prep_time

cook_time
