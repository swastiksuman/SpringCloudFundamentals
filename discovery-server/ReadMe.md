# Eureka Server (Discovery Server)

Eureka Server is an application that holds the information about all client-service applications. Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address.

Netflix OSS + Spring + Spring Boot = Spring Cloud Netflix

#Components of Service Discovery
*Service registers location
*Client looks up service location
*Discovery server sends back location
*Client requests service location
*Service sends response

# Properties
| Property                           | Description                                     | Default |   |   |
|------------------------------------|-------------------------------------------------|---------|---|---|
| eureka.client.register-with-eureka | If the app should be registered in eureka       | true    |   |   |
| eureka.client.fetch-registry       | If app should fetch eureka registry information | true    |   |   |
| spring.application.name            | name of the boot app                            |         |   |   |
