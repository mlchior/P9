FROM openjdk:17-jdk-buster

RUN apt-get update && \
    apt-get install -y mariadb-server && \
    service mysql start && \
    mysql -e "CREATE USER IF NOT EXISTS 'root'@'localhost' IDENTIFIED BY 'rootroot';" && \
    mysql -e "CREATE DATABASE patient;" && \
    mysql -e "GRANT ALL ON patient.* TO 'root'@'localhost';" && \
    mysql -e "FLUSH PRIVILEGES;"


ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
