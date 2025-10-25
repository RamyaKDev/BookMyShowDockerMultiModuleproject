FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8081
COPY /target/movie-catalog.jar movie-catalog.jar
ENTRYPOINT [ "java","-jar","movie-catalog.jar" ]