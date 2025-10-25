FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8084
COPY /target/booking-service.jar booking-service.jar
ENTRYPOINT [ "java","-jar","booking-service.jar" ]