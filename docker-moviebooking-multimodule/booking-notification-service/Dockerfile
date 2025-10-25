FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8088
COPY /target/notify-service.jar notify-service.jar
ENTRYPOINT [ "java","-jar","notify-service.jar" ]