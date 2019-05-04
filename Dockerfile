FROM openjdk:8-jdk-alpine
RUN  mkdir -p /app/
ADD  build/libs/kboot-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]