FROM openjdk:17-jdk-buster

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","/app.jar"]
