FROM openjdk:8
MAINTAINER Hungwen Tseng
LABEL description="Java 8"
EXPOSE 8888

COPY target/louyi-admin.jar  /louyi.jar

ENTRYPOINT ["java", "-jar", "/louyi.jar"]

