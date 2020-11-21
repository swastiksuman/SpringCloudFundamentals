FROM openjdk:12-alpine
LABEL maintainer="swastiksuman@gmail.com"
VOLUME /tmp
RUN apk update && apk add bash
EXPOSE 8761
EXPOSE 8080
EXPOSE 8081
ARG JAR_FILE1=discovery-server/target/discovery-server-0.0.1-SNAPSHOT.jar
ARG JAR_FILE2=client-first/target/client-first-0.0.1-SNAPSHOT.jar
ARG JAR_FILE3=service-first/target/service-first-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE1} discovery-server.jar
ADD ${JAR_FILE2} client-first.jar
ADD ${JAR_FILE3} service-first.jar
CMD java -jar ${APP_NAME}.jar
