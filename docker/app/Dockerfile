# 1. Build stage
FROM gradle:8-jdk17 AS builder

WORKDIR /home/gradle/project

COPY . .

RUN gradle build -x test \
    && rm -rf /home/gradle/project/.gradle /home/gradle/project/build/*-plain.jar

# 2. Run stage
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar

EXPOSE 9525

ENV SERVER_ADDRESS=0.0.0.0
ENV SERVER_PORT=9525

ENTRYPOINT ["java", "-jar", "app.jar"]

# 1. Build stage
#FROM gradle:8-jdk17 AS builder
#
#WORKDIR /home/gradle/project
#
#COPY . .
#
#RUN gradle build -x test \
#    && rm -rf /home/gradle/project/.gradle /home/gradle/project/build/*-plain.jar
#
## 2. Run stage
#FROM eclipse-temurin:17-jre-jammy
#
#WORKDIR /app
#
#COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar
#
#EXPOSE 9525
#
#ENV SERVER_ADDRESS=0.0.0.0
#ENV SERVER_PORT=9525
#
#ENTRYPOINT ["java", "-jar", "app.jar"]

#FROM eclipse-temurin:17-jre-jammy
#WORKDIR /app
#
## Copia el JAR ya compilado desde build/libs/
#COPY build/libs/*.jar app.jar
#
#EXPOSE 9525
#
#ENV SPRING_DATASOURCE_URL=jdbc:mysql://3.137.166.243:3306/logistica?serverTimezone=UTC \
#    SPRING_DATASOURCE_USERNAME=root \
#    SPRING_DATASOURCE_PASSWORD=root
#
#ENTRYPOINT ["java", "-jar", "app.jar"]