FROM openjdk:17-alpine
WORKDIR /app
COPY build/libs/email-kb-service-*.jar /app/email-kb-service.jar
ENTRYPOINT ["java", "-jar", "email-kb-service.jar"]
