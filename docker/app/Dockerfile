FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia el JAR ya compilado desde la raíz del proyecto
COPY ../../build/libs/*.jar app.jar

EXPOSE 9525

ENV SPRING_DATASOURCE_URL=jdbc:mysql://3.137.166.243:3306/logistica?serverTimezone=UTC \
    SPRING_DATASOURCE_USERNAME=root \
    SPRING_DATASOURCE_PASSWORD=root

ENTRYPOINT ["java", "-jar", "app.jar"]