# docker/sql/Dockerfile

# Usamos la imagen oficial de MySQL 8
FROM mysql:8.0

ENV MYSQL_ROOT_PASSWORD=root \
    MYSQL_DATABASE=logistica

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 9192


# docker/app/Dockerfile

# 1. Build stage
FROM gradle:8-jdk17 AS builder
WORKDIR /home/gradle/project
COPY . .
RUN gradle build -x test

# 2. Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar

# Exponer puerto
EXPOSE 9525

# Variables de entorno (puedes omitir si pasas JAVA_OPTS al docker run)
ENV SERVER_ADDRESS=0.0.0.0
ENV SERVER_PORT=9525
ENV SPRING_DATASOURCE_URL=jdbc:mysql://3.137.166.243:3306/logistica?serverTimezone=UTC
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=root

ENTRYPOINT ["java","-jar","app.jar"]

