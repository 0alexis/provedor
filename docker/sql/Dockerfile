# docker/sql/Dockerfile

# Usamos la imagen oficial de MySQL 8
FROM mysql:8.0

ENV MYSQL_ROOT_PASSWORD=root \
    MYSQL_DATABASE=logistica

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 3306

