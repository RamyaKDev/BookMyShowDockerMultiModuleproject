FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8888
COPY /target/config-server.jar config-server.jar
ENTRYPOINT [ "java","-jar","config-server.jar" ]