# 🍽️Recipe Data Collection & REST API

A Spring Boot REST API that parses recipe data from a JSON file, stores it in a database, and provides endpoints to manage and query recipes.

This project demonstrates:

JSON Parsing

Database Integration

REST API Development

# 📌 Objective

This application:

Parses recipe data from a JSON file

Stores it in a relational database

Provides REST APIs to create and retrieve recipes

# 🛠️ Tech Stack

Java

Spring Boot

Spring Data JPA

Hibernate

MySQL

Jackson (JSON Parsing)

Maven


# 🚀 API Endpoints

1️⃣ POST ```/recipes```
✅ Purpose

Add a new recipe to the database.

✅ Validation Rules

The following fields are mandatory:

title

cuisine

prep_time

cook_time

✅ Business Logic

total_time = prep_time + cook_time
# 📥 Sample Request

```json
{
  "title": "Chocolate Cake",
  "cuisine": "Dessert",
  "prep_time": 20,
  "cook_time": 40,
  "description": "A rich chocolate cake...",
  "nutrients": {
    "calories": "500 kcal",
    "carbohydrateContent": "60 g",
    "proteinContent": "6 g",
    "fatContent": "25 g"
  },
  "serves": "6 servings"
}
```
# 📤 Sample Response

```json
{
  "id": 2,
  "title": "Chocolate Cake",
  "cuisine": "Dessert",
  "rating": null,
  "prep_time": 20,
  "cook_time": 40,
  "total_time": 60,
  "description": "A rich chocolate cake...",
  "nutrients": {
    "calories": "500 kcal",
    "carbohydrateContent": "60 g",
    "proteinContent": "6 g",
    "fatContent": "25 g"
  },
  "serves": "6 servings"
}
```
2️⃣ GET ```/recipes/top```
✅ Purpose

Retrieve top-rated recipes.

🔎 Query Parameter

limit (optional)

Default value = 5

✅ Logic

Sort recipes by rating in descending order

Return limited number of records

# 📥 Example Request
```GET /recipes/top?limit=2```
# 📤 Example Response
```json
{
  "data": [
    {
      "id": 1,
      "title": "Sweet Potato Pie",
      "cuisine": "Southern Recipes",
      "rating": 4.8,
      "prep_time": 15,
      "cook_time": 100,
      "total_time": 115,
      "description": "Shared from a Southern recipe...",
      "nutrients": { ... },
      "serves": "8 servings"
    }
  ]
}
```
# 📥 JSON Parsing

The application reads recipe data from a JSON file using:

Jackson ObjectMapper

Converts JSON into Entity objects

Saves parsed data into the database

# ⚙️ Application Setup

1️⃣ Clone the Repository
```
git clone <your-repository-url>
cd recipe-api
```
2️⃣ Configure Database
MySQL Example
```
spring.datasource.url=jdbc:mysql://localhost:3306/recipe_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
3️⃣ Run the Application
```
mvn clean install
mvn spring-boot:run
```
Application runs on:
```http://localhost:8080```

# 🧪 API Testing

You can test the API using:

Postman
