-- Crear la tabla para productos
CREATE TABLE IF NOT EXISTS producto (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(255) NOT NULL,
    stock_disponible INT NOT NULL
    );