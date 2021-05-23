FROM ubuntu:latest

RUN apt-get -y update

ENV NODE_VERSION=12.6.0
RUN apt-get install curl -y
RUN curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.34.0/install.sh | bash
ENV NVM_DIR=/root/.nvm
RUN . "$NVM_DIR/nvm.sh" && nvm install ${NODE_VERSION}
RUN . "$NVM_DIR/nvm.sh" && nvm use v${NODE_VERSION}
RUN . "$NVM_DIR/nvm.sh" && nvm alias default v${NODE_VERSION}
ENV PATH="/root/.nvm/versions/node/v${NODE_VERSION}/bin/:${PATH}"
RUN node --version
RUN npm --version

# JAVA INSTALL
RUN apt-get -y install openjdk-11-jre-headless

# RABBITMQ INSTALL
RUN echo "deb http://www.rabbitmq.com/debian/ testing main"  | tee  /etc/apt/sources.list.d/rabbitmq.list > /dev/null
RUN apt-get install wget -y
RUN wget https://www.rabbitmq.com/rabbitmq-signing-key-public.asc
RUN apt-get install gnupg -y
RUN apt-key add rabbitmq-signing-key-public.asc
RUN apt-get install rabbitmq-server -y
RUN service rabbitmq-server start
RUN rabbitmq-plugins enable rabbitmq_management
RUN service rabbitmq-server stop

EXPOSE 8761
EXPOSE 8080
EXPOSE 8081
EXPOSE 15672
EXPOSE 5672

ARG JAR_FILE1=discovery-server/target/discovery-server-0.0.1-SNAPSHOT.jar
ARG JAR_FILE2=client-first/target/client-first-0.0.1-SNAPSHOT.jar
ARG JAR_FILE3=service-first/target/service-first-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE1} discovery-server.jar
ADD ${JAR_FILE2} client-first.jar
ADD ${JAR_FILE3} service-first.jar
ADD front-end /
CMD java -jar discovery-server.jar 
CMD java -jar service-first.jar

