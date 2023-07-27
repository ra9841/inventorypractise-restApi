#FROM openjdk:8
#EXPOSE 8080
#ADD target/inventory-stock.restApi-project.jar inventory-stock.restApi-project.jar
#ENTRYPOINT ["java", "-jar", "/inventory-stock.restApi-project.jar"]

FROM openjdk:11-jre-slims
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests
RUN cp  /home/app/target/inventory-stock.restApi-project.war  inventory-stock.restApi-project.war

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "inventory-stock.restApi-project.war"]