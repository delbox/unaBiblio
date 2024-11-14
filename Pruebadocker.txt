# Etapa de ejecución
FROM openjdk:17-jdk-alpine

# Copia el archivo JAR generado en la imagen
COPY target/unaBiblio-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 (o el puerto que utilices en tu aplicación)
EXPOSE 8080

# Establece la variable de entorno PORT para que use el puerto adecuado
ENV PORT 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
