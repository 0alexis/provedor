-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: logistica
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asignacion_transporte`
--

DROP TABLE IF EXISTS `asignacion_transporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignacion_transporte` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `conductor` varchar(255) DEFAULT NULL,
  `fecha_asignacion` datetime(6) DEFAULT NULL,
  `vehiculo` varchar(255) DEFAULT NULL,
  `pedido_id` bigint NOT NULL,
  `conductor_id` bigint DEFAULT NULL,
  `vehiculo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK2i4n350p6ico3qvko7ni17x2u` (`pedido_id`),
  KEY `FKkkf52fsa8xpwj6c9xvv48gach` (`conductor_id`),
  KEY `FKljvk52c3ijd6jfalihbve4726` (`vehiculo_id`),
  CONSTRAINT `FKkkf52fsa8xpwj6c9xvv48gach` FOREIGN KEY (`conductor_id`) REFERENCES `conductor` (`id`),
  CONSTRAINT `FKljvk52c3ijd6jfalihbve4726` FOREIGN KEY (`vehiculo_id`) REFERENCES `vehiculo` (`id`),
  CONSTRAINT `FKpc2uswk22t0w9r6i7436lvcar` FOREIGN KEY (`pedido_id`) REFERENCES `recepcion_pedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignacion_transporte`
--

LOCK TABLES `asignacion_transporte` WRITE;
/*!40000 ALTER TABLE `asignacion_transporte` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignacion_transporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cierre_despacho`
--

DROP TABLE IF EXISTS `cierre_despacho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cierre_despacho` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cerrado` bit(1) NOT NULL,
  `fecha_cierre` datetime(6) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `notificacion_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKlqj7polb6uxp75ig7ajssc46k` (`notificacion_id`),
  CONSTRAINT `FKcrovqys7idr6u3bx8k8mneoon` FOREIGN KEY (`notificacion_id`) REFERENCES `notificacion_entrega` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cierre_despacho`
--

LOCK TABLES `cierre_despacho` WRITE;
/*!40000 ALTER TABLE `cierre_despacho` DISABLE KEYS */;
/*!40000 ALTER TABLE `cierre_despacho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conductor`
--

DROP TABLE IF EXISTS `conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conductor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `cedula` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conductor`
--

LOCK TABLES `conductor` WRITE;
/*!40000 ALTER TABLE `conductor` DISABLE KEYS */;
/*!40000 ALTER TABLE `conductor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificacion_entrega`
--

DROP TABLE IF EXISTS `notificacion_entrega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificacion_entrega` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `entregado` bit(1) NOT NULL,
  `fecha_notificacion` datetime(6) DEFAULT NULL,
  `mensaje` varchar(255) DEFAULT NULL,
  `seguimiento_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKfndu8jjubugi9mt5kq81ts3kr` (`seguimiento_id`),
  CONSTRAINT `FKg6syje41f0mcw4bhb98fmnysv` FOREIGN KEY (`seguimiento_id`) REFERENCES `seguimiento_despacho` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion_entrega`
--

LOCK TABLES `notificacion_entrega` WRITE;
/*!40000 ALTER TABLE `notificacion_entrega` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificacion_entrega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recepcion_pedido`
--

DROP TABLE IF EXISTS `recepcion_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recepcion_pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `fecha_recepcion` datetime(6) DEFAULT NULL,
  `producto` varchar(255) DEFAULT NULL,
  `proveedor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recepcion_pedido`
--

LOCK TABLES `recepcion_pedido` WRITE;
/*!40000 ALTER TABLE `recepcion_pedido` DISABLE KEYS */;
INSERT INTO `recepcion_pedido` VALUES (1,23,'2025-03-02 07:36:20.551000','un producto a','proveedor A'),(2,100,'2025-03-30 00:15:26.092000','Cajas de insulina','Proveedor XYZ');
/*!40000 ALTER TABLE `recepcion_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguimiento_despacho`
--

DROP TABLE IF EXISTS `seguimiento_despacho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguimiento_despacho` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `ubicacion_actual` varchar(255) DEFAULT NULL,
  `asignacion_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK1alemujccmtg2grfadkn9hpio` (`asignacion_id`),
  CONSTRAINT `FK1rpyax7lda1997gf52e9vinn1` FOREIGN KEY (`asignacion_id`) REFERENCES `asignacion_transporte` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguimiento_despacho`
--

LOCK TABLES `seguimiento_despacho` WRITE;
/*!40000 ALTER TABLE `seguimiento_despacho` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguimiento_despacho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacidad` int NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-22 15:37:14
