# Product-Management Microservice

## Overview
The Product-Management Microservice is a core backend component responsible for managing product-related data within a microservices-based system. It provides RESTful APIs that are consumed by other backend services and client applications, including a Flutter mobile frontend.

## Responsibilities
- Product creation, update, and deletion  
- Product data CRUD operations  
- Product categorization and pricing management  
- Product availability and status handling  

## Project Context
This microservice is developed as part of a distributed system following a microservices architecture.  
Other backend services, the messaging infrastructure, and frontend applications are maintained in separate repositories.

The service is designed to be independent, scalable, and easily integrated with other system components.

## Technology Stack
- Java  
- Spring Boot  
- MySQL  
- REST APIs  
- Spring Security (JWT-based authentication)

## Architecture Notes
- Stateless REST endpoints  
- Database-backed product persistence  
- JWT-based authentication for secured endpoints  
- Designed for inter-service communication within a microservices ecosystem  

## Usage
This service is intended to be run as an independent backend service and integrated with other system components via REST APIs.  
It typically works in conjunction with a User-Management or Authentication service for authorization and access control.
