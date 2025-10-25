FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8083
COPY /target/show-service.jar show-service.jar
ENTRYPOINT [ "java","-jar","show-service.jar" ]