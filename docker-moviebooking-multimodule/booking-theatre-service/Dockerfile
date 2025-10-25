FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8082
COPY /target/theatre-service.jar theatre-service.jar
ENTRYPOINT [ "java","-jar","theatre-service.jar" ]