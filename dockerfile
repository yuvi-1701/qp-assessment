FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app

COPY target/grocery-app.jar /app/grocery-app.jar


CMD ["java", "-jar", "/app/grocery-app.jar"]

