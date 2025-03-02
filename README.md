# Proyecto Backend - API de Despacho de Proveedores

Este es el backend para la aplicación de gestión de despachos de proveedores, construida con **Spring Boot**. Este proyecto maneja el proceso logístico de despachos, incluyendo la recepción de pedidos, seguimiento de despachos, notificaciones de entrega, cierres de despachos y asignaciones de transporte. Además, utiliza Swagger UI para la documentación interactiva de la API.

## Tecnologías Utilizadas
- **Spring Boot**: Framework Java para aplicaciones backend.
![Spring Boot Logo](https://spring.io/img/og-spring.png)

- **Spring Data JPA**: ORM para interactuar con la base de datos.
- **MySQL**: Base de datos para almacenar la información.
- **Swagger (Springdoc)**: Para la documentación interactiva de la API.
- **Lombok**: Para reducir código repetitivo.
- **Gradle**: Sistema de compilación.

## Requisitos

Antes de ejecutar este proyecto, asegúrate de tener lo siguiente instalado:

- **Java 17**: Puedes descargarlo desde [adoptium.net](https://adoptium.net/).

- **MySQL 8.0.33**: Base de datos para almacenar la información.
- **Gradle**: Sistema de compilación (puedes usar el wrapper incluido en el proyecto).
- **Git**: Para clonar el repositorio.

## Instalación

### 1. Clonar el repositorio

Primero, clona el repositorio desde GitHub en tu máquina local:

```bash
git clone https://github.com/0alexis/provedor.git
 ```

### 2. Configurar la base de datos
```bash
Crea una base de datos en MySQL:

CREATE DATABASE logistica;
 ```


### 3. Compilar las dependencias
```bash
Ejecuta el siguiente comando para descargar las dependencias y compilar el proyecto usando Gradle:

./gradlew build
 ```
 

### 4. Ejecutar el servidor de desarrollo
```bash
Una vez configurado todo, puedes iniciar la aplicación de Spring Boot:

./gradlew bootRun
 ```


# Uso
### Explorar la API con Swagger UI
```bash
http://localhost:8080/swagger-ui/index.html
 ```


 # API de Despacho

Este documento describe los endpoints principales de la API de Despacho.

## 📦 Recepción de Pedidos

- **Obtener todas las recepciones de pedidos**  
  `GET /api/despacho/recepcion`

- **Crear una nueva recepción de pedido**  
  `POST /api/despacho/recepcion`

## 🚚 Seguimiento de Despacho

- **Obtener todos los seguimientos**  
  `GET /api/despacho/seguimiento`

- **Obtener un seguimiento por ID**  
  `GET /api/despacho/seguimiento/{id}`

- **Crear un nuevo seguimiento**  
  `POST /api/despacho/seguimiento`

## 📢 Notificación de Entrega

- **Obtener todas las notificaciones**  
  `GET /api/despacho/notificacion`

- **Obtener una notificación por ID**  
  `GET /api/despacho/notificacion/{id}`

- **Crear una nueva notificación**  
  `POST /api/despacho/notificacion`

- **Confirmar una notificación**  
  `PUT /api/despacho/notificacion/{id}/confirmar`

## ✅ Cierre de Despacho

- **Obtener todos los cierres**  
  `GET /api/despacho/cierre`

- **Obtener un cierre por ID**  
  `GET /api/despacho/cierre/{id}`

- **Crear un nuevo cierre**  
  `POST /api/despacho/cierre`

## 🚛 Asignación de Transporte

- **Obtener todas las asignaciones**  
  `GET /api/despacho/asignacion`

- **Crear una nueva asignación**  
  `POST /api/despacho/asignacion`



Licencia
MIT License

Copyright (c) 2025 NexityCode

Se otorga permiso, de forma gratuita, a cualquier persona que obtenga una copia del software y los archivos de documentación asociados, para usar el Software sin restricciones, incluyendo, sin limitación, los derechos a usar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar y/o vender copias del Software, y a permitir a las personas a quienes se les proporcione el Software hacerlo, bajo las siguientes condiciones:

El aviso de copyright y este aviso de permiso deben incluirse en todas las copias o partes sustanciales del Software.
