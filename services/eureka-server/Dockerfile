FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY build/libs/eureka-server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8762
ENTRYPOINT ["java", "-jar", "app.jar"]
