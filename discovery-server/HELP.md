# Eureka Server (Discovery Server)

Eureka Server is an application that holds the information about all client-service applications. Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address.

# Properties
| Property                           | Description                                     | Default |   |   |
|------------------------------------|-------------------------------------------------|---------|---|---|
| eureka.client.register-with-eureka | If the app should be registered in eureka       | true    |   |   |
| eureka.client.fetch-registry       | If app should fetch eureka registry information | true    |   |   |
| spring.application.name            | name of the boot app                            |         |   |   |
