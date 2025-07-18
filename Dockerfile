FROM openjdk:17-slim

WORKDIR /employee-service

COPY target/*.jar employee-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "employee-service.jar"]
