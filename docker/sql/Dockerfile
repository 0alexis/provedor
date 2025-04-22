# docker/sql/Dockerfile

# Usamos la imagen oficial de MySQL 8
FROM mysql:8.0

# Variables de entorno según tu Spring Boot
ENV MYSQL_ROOT_PASSWORD=root \
    MYSQL_DATABASE=logistica \
    MYSQL_USER=root \
    MYSQL_PASSWORD=root

# Copiamos el dump para que se ejecute al iniciar el contenedor
COPY init.sql /docker-entrypoint-initdb.d/

# Exponemos el puerto por si quieres mapearlo
EXPOSE 3306
