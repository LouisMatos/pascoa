FROM openjdk:8-jdk-alpine as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

WORKDIR /app/target

ENTRYPOINT java -jar pascoa-microservice-api.jar

#FROM openjdk:8-jdk-alpine
#RUN mkdir app
#ARG JAR_FILE
#ADD /target/${JAR_FILE} /app/pascoa-microservice-api.jar
#WORKDIR /app
#ENTRYPOINT java -jar pascoa-microservice-api.jar

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#COPY target/pascoa-microservice-api-*.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]
# docker run -p 8080:8080 testeluismatos/pascoa-microservice-api:0.0.1-SNAPSHOT