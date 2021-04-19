# FROM adoptopenjdk/openjdk11:alpine-jre base image
FROM adoptopenjdk/openjdk11:alpine-jre

# Owner
LABEL maintainer="nabil.kharchoufa@external.total.com"

#Temporary working volume
VOLUME /tmp

# Refer to Maven build -> appName
ARG JAR_FILE=./layer-app/target/*.jar

# cp ./layer-app/target/*.jar to /tmp/demands.jar
COPY ${JAR_FILE} demands.jar

# run app on port 8080
EXPOSE 8080

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","/demands.jar"]
