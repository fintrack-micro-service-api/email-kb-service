FROM openjdk:17-alpine
COPY ./build/libs/email-kb-service-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "email-kb-service-0.0.1-SNAPSHOT.jar" ]
