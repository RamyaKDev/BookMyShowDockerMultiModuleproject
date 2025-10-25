FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8085
COPY /target/user-service.jar user-service.jar
ENTRYPOINT [ "java","-jar","user-service.jar" ]