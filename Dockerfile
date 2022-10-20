FROM amazoncorretto:11-alpine-jdk

ARG JAR_FILE=build/libs/sgq-quality-transparence-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8082