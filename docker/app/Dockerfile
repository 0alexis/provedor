# Etapa de compilación
FROM gradle:8-jdk17 AS builder
WORKDIR /home/gradle/project
COPY . .
RUN gradle build -x test

# Etapa de ejecución
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar

EXPOSE 9525

ENV SPRING_DATASOURCE_URL=jdbc:mysql://3.137.166.243:3306/logistica?serverTimezone=UTC \
    SPRING_DATASOURCE_USERNAME=root \
    SPRING_DATASOURCE_PASSWORD=root

ENTRYPOINT ["java","-jar","app.jar"]
