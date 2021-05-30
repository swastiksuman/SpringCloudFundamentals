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

## Running Docker
```
sudo docker build -t testimage .
sudo docker run -d -p 8761:8761 -p 8081:8081 -p 15672:15672 -p 5672:5672 -p 3000:3000 testimage
```
