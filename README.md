# authorization-server-spring-demo
Demo project for Authorization Server with Spring Boot

## authorzation-server
Standalone Spring Boot Application demonstrating OAuth2 Authorization Server implementation.

## resource-server
Standalone Spring Boot Web Application that acts as a Resource Server (allows access with JWT tokens issued by Authorization Server)

## client
Spring app with JUnit test demonstrating OAuth2 aware WebClient. See com.ivotasevski.WebClientTests
The client lets Spring handle all the tedious tasks like token retrieval, expiration etc. 

## Postman Client
Use the resources in Postman directory to get tokens and invoke requests.

