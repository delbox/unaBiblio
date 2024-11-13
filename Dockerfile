# Etapa de construcción
FROM openjdk:17-jdk-alpine

COPY target/unaBiblio-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java","-jar","/app.jar" ]

