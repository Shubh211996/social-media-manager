🧩 Social Media Manager – Backend Application

A Spring Boot–based backend application that allows users to authenticate using social login (Facebook), link social media accounts, and publish posts via secured APIs.

🚀 Tech Stack

Java 17

Spring Boot 3

Spring Security (JWT-based Authentication)

Spring Data JPA

MySQL

Swagger / OpenAPI

Maven

📌 Features Implemented

✅ JWT-based Authentication
✅ Facebook Login (Mocked)
✅ Role-based Authorization (ADMIN / USER)
✅ Secure APIs using Spring Security
✅ Global Exception Handling
✅ Swagger UI Integration
✅ Clean layered architecture
✅ MySQL database integration

🧱 Project Structure
src/main/java/com/flintzy/social
│
├── controller
│   ├── AuthController.java
│   ├── AdminController.java
│   └── UserController.java
│
├── security
│   ├── JwtAuthenticationFilter.java
│   ├── JwtUtil.java
│   └── SecurityConfig.java
│
├── exception
│   └── GlobalExceptionHandler.java
│
├── entity
│   └── User.java
│
├── repository
│   └── UserRepository.java
│
└── SocialMediaManagerApplication.java

🔐 Authentication Flow
1️⃣ Login (Mock Facebook Login)
POST /auth/login


Request Body

{
  "email": "user@test.com"
}


Response

{
  "token": "JWT_TOKEN_HERE"
}

2️⃣ Facebook Connect (Mock)
POST /auth/facebook


Returns JWT token for Facebook-authenticated user.

3️⃣ Access Protected APIs

Add JWT token in headers:

Authorization: Bearer <YOUR_JWT_TOKEN>

🔒 Role-Based Access
Endpoint	Role Required
/admin/**	ADMIN
/user/**	USER, ADMIN
/auth/**	Public
📡 API Endpoints
🔹 Authentication
Method	Endpoint	Description
POST	/auth/login	Login user
POST	/auth/facebook	Facebook login
🔹 User APIs
Method	Endpoint	Description
GET	/user/profile	Get user profile
🔹 Admin APIs
Method	Endpoint	Description
GET	/admin/dashboard	Admin-only endpoint
📘 Swagger API Documentation

After running the application, open:

http://localhost:8080/swagger-ui/index.html


You can:

Test APIs

Authorize using JWT

View request/response schemas

🛠️ How to Run the Project
1️⃣ Clone the repository
git clone https://github.com/Shubh211996/social-media-manager.git
cd social-media-manager

2️⃣ Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/social_media_db
spring.datasource.username=root
spring.datasource.password=yourpassword

3️⃣ Run Application
mvn spring-boot:run

📂 Database

MySQL database required

Tables auto-created via JPA

Sample data created on login

🧪 Testing with Postman

Call /auth/login

Copy JWT token

Add header:

Authorization: Bearer <token>


Call secured endpoints

🧠 Assumptions

Facebook API integration is mocked for assignment scope.

JWT token is self-generated.

Role is stored in database.

👨‍💻 Author

Shubham Nehete
Backend Developer
