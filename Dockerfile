# Etapa de construcción
<<<<<<< HEAD:unaBiblio/DockerFile
FROM openjdk:17-jdk
=======
FROM openjdk:17-jdk-alpine
>>>>>>> 89b74073c0cfcdea8fbba8a1a85e5cff5f151dcd:unaBiblio/Dockerfile

COPY target/unaBiblio-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java","-jar","/app.jar" ]

