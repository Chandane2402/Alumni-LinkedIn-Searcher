# Alumni LinkedIn Profile Searcher

## 📌 Project Overview
This is a Spring Boot application that allows users to search for LinkedIn profiles of alumni from a specified educational institution using the **PhantomBuster API**. The retrieved alumni data is stored in a **PostgreSQL database** and can be accessed via RESTful APIs.

## 🚀 Features
- Search for alumni profiles using **University Name**, **Designation**, and **Passout Year** (optional).
- Fetch data from **LinkedIn** using **PhantomBuster API**.
- Store alumni details in a **PostgreSQL database**.
- Expose RESTful APIs for searching and retrieving stored alumni profiles.
- Implement **exception handling** and **data validation**.
- **JUnit tests** for testing service layers.

## 🛠️ Technologies Used
- **Spring Boot** (Java)
- **PostgreSQL** (Database)
- **PhantomBuster API** (LinkedIn scraping)
- **Spring Data JPA**
- **Spring Web** (REST API)
- **Lombok** (For boilerplate code reduction)
- **JUnit & Mockito** (For unit testing)
- **Git & GitHub** (Version control)

## 📌 API Endpoints
### 1️⃣ Search Alumni Profiles
**Endpoint:**
```http
POST /api/alumni/search
```
**Request Body:**
```json
{
  "university": "NAME_OF_THE_UNIVERSITY",
  "designation": "CURRENT_DESIGNATION",
  "passoutYear": "OPTIONAL_PASSOUT_YEAR"
}
```
**Response Example:**
```json
{
  "status": "success",
  "data": [
    {
      "name": "John Doe",
      "currentRole": "Software Engineer",
      "university": "University of XYZ",
      "location": "New York, NY",
      "linkedinHeadline": "Passionate Software Engineer at XYZ Corp",
      "passoutYear": 2020
    }
  ]
}
```

### 2️⃣ Get Saved Alumni Profiles
**Endpoint:**
```http
GET /api/alumni/all
```
**Response Example:**
```json
{
  "status": "success",
  "data": [
    {
      "name": "Jane Smith",
      "currentRole": "Data Scientist",
      "university": "University of XYZ",
      "location": "San Francisco, CA",
      "linkedinHeadline": "Data Scientist | AI Enthusiast",
      "passoutYear": 2019
    }
  ]
}
```

## 📌 Setup Instructions
### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/alumni-search.git
cd alumni-search
```

### 2️⃣ Configure Database (PostgreSQL)
- Update `application.properties` with your database credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/alumni_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3️⃣ Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

### 4️⃣ Test the APIs in **Postman**
- Use **Postman** or **cURL** to test the endpoints.

## ✅ Project Structure
```
📂 src/main/java/com/alumni
 ┣ 📂 controller        # REST Controllers
 ┣ 📂 dto              # Request & Response DTOs
 ┣ 📂 model            # Entity Classes
 ┣ 📂 repository       # JPA Repositories
 ┣ 📂 service          # Business Logic Layer
 ┣ 📂 exception        # Global Exception Handling
 ┣ 📜 AlumniSearchApplication.java  # Main Class
```

## 📝 Contribution
Feel free to raise an issue or submit a PR if you have any improvements.

## 📄 License
This project is licensed under the **MIT License**.

---
Made with ❤️ by **Chandan** 🚀

