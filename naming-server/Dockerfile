# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# For Java 11, try this
#FROM adoptopenjdk/openjdk11:alpine-jre
FROM public.ecr.aws/y0l2y8e9/adoptopenjdk/openjdk11:latest

WORKDIR /opt/app

ARG JAR_FILE=target/naming-server-0.0.1-SNAPSHOT.jar

# cp naming-server-0.0.1-SNAPSHOT /opt/app/app.jar
COPY ${JAR_FILE} app.jar


# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]