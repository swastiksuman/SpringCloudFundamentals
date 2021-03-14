# Spring Cloud Fundamentals

## Components
* Discovery Server
* Service
* Client

## Scale Service
To run 2 instances of Service First application, override the configuration in Boot Dashboard
```
server.port=8081
service.instance.name=service-2
spring.application.name=service-first
````

```
server.port=8082
service.instance.name=service-1
spring.application.name=service-first
```
