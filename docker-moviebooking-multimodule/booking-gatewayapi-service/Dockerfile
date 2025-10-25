FROM eclipse-temurin:21-jdk-alpine
EXPOSE 9000
COPY /target/gateway-api.jar gateway-api.jar
ENTRYPOINT [ "java","-jar","gateway-api.jar" ]