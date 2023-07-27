FROM openjdk:8
EXPOSE 8080
ADD target/inventory-stock.restApi-project.jar inventory-stock.restApi-project.jar
ENTRYPOINT ["java", "-jar", "/inventory-stock.restApi-project.jar"]