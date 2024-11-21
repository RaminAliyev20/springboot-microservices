Spring Boot Microservices Project
Overview
This project is a Spring Boot Microservices application for managing products and categories, using WebClient, Eureka Server, and Spring Cloud Gateway for inter-service communication.

Architecture
The project consists of the following services:

Product Service: Manages product creation, updates, and searching by category.
Category Service: Handles product categories.
Gateway Service: Serves as the API Gateway.
Eureka Server: Provides service discovery.
Technologies
Java 17
Spring Boot
Spring Cloud Gateway
Spring WebClient
Spring Data JPA
Eureka Server
Lombok
Setup Instructions
Clone the repository: git clone https://github.com/your-github-profile/SpringBootMicroservices.git cd SpringBootMicroservices

Install dependencies: mvn clean install

Run the Eureka Server: cd EurekaServer mvn spring-boot:run

Run the services:

Gateway Service: cd GatewayService mvn spring-boot:run
Category Service: cd CategoryService mvn spring-boot:run
Product Service: cd ProductService mvn spring-boot:run
Test the APIs via the Gateway:

Get products:
GET http://localhost:4040/api/products
Get categories:
GET http://localhost:4040/api/categories
Features
Product management with category associations.
API Gateway for routing requests to services.
Service discovery via Eureka Server.
Project Structure
SpringBootMicroservices
├── ProductService/
├── CategoryService/
├── GatewayService/
├── EurekaServer/
├── README.md
└── pom.xml
