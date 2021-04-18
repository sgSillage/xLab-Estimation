-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: softwareestimation
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `description`
--

DROP TABLE IF EXISTS `description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `description` (
  `id` varchar(100) NOT NULL,
  `projectName` varchar(100) DEFAULT NULL,
  `estimationMethod` varchar(100) DEFAULT NULL,
  `projectContact` varchar(100) DEFAULT NULL,
  `pojectLeader` varchar(100) DEFAULT NULL,
  `porjectDescription` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `description`
--

LOCK TABLES `description` WRITE;
/*!40000 ALTER TABLE `description` DISABLE KEYS */;
/*!40000 ALTER TABLE `description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eifdata`
--

DROP TABLE IF EXISTS `eifdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eifdata` (
  `id` varchar(100) NOT NULL,
  `fileName` varchar(100) DEFAULT NULL,
  `allDET` varchar(100) DEFAULT NULL,
  `requirementId` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eifdata`
--

LOCK TABLES `eifdata` WRITE;
/*!40000 ALTER TABLE `eifdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `eifdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eifdataser`
--

DROP TABLE IF EXISTS `eifdataser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eifdataser` (
  `id` varchar(100) NOT NULL,
  `stepId` varchar(100) DEFAULT NULL,
  `EIFName` varchar(100) DEFAULT NULL,
  `DET` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eifdataser`
--

LOCK TABLES `eifdataser` WRITE;
/*!40000 ALTER TABLE `eifdataser` DISABLE KEYS */;
/*!40000 ALTER TABLE `eifdataser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estimationfiledata`
--

DROP TABLE IF EXISTS `estimationfiledata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estimationfiledata` (
  `id` varchar(100) NOT NULL,
  `requirementId` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `FileType` varchar(100) DEFAULT NULL,
  `RET` varchar(100) DEFAULT NULL,
  `DET` varchar(100) DEFAULT NULL,
  `RETNum` varchar(100) DEFAULT NULL,
  `DETNum` varchar(100) DEFAULT NULL,
  `complexity` int DEFAULT NULL,
  `UFP` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estimationfiledata`
--

LOCK TABLES `estimationfiledata` WRITE;
/*!40000 ALTER TABLE `estimationfiledata` DISABLE KEYS */;
/*!40000 ALTER TABLE `estimationfiledata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estimationtransactiondata`
--

DROP TABLE IF EXISTS `estimationtransactiondata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estimationtransactiondata` (
  `id` varchar(100) NOT NULL,
  `requirementId` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `TransactionType` varchar(100) DEFAULT NULL,
  `File` varchar(100) DEFAULT NULL,
  `DET` varchar(100) DEFAULT NULL,
  `FileNum` varchar(100) DEFAULT NULL,
  `DETNum` varchar(100) DEFAULT NULL,
  `complexity` int DEFAULT NULL,
  `UFP` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estimationtransactiondata`
--

LOCK TABLES `estimationtransactiondata` WRITE;
/*!40000 ALTER TABLE `estimationtransactiondata` DISABLE KEYS */;
/*!40000 ALTER TABLE `estimationtransactiondata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `folder`
--

DROP TABLE IF EXISTS `folder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `folder` (
  `id` varchar(100) NOT NULL,
  `parentId` varchar(100) DEFAULT NULL,
  `transactionId` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `folder`
--

LOCK TABLES `folder` WRITE;
/*!40000 ALTER TABLE `folder` DISABLE KEYS */;
/*!40000 ALTER TABLE `folder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ilfdata`
--

DROP TABLE IF EXISTS `ilfdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ilfdata` (
  `id` varchar(100) NOT NULL,
  `fileName` varchar(100) DEFAULT NULL,
  `allDET` varchar(100) DEFAULT NULL,
  `requirementId` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ilfdata`
--

LOCK TABLES `ilfdata` WRITE;
/*!40000 ALTER TABLE `ilfdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `ilfdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ilfdataser`
--

DROP TABLE IF EXISTS `ilfdataser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ilfdataser` (
  `id` varchar(100) NOT NULL,
  `stepId` varchar(100) DEFAULT NULL,
  `ILFName` varchar(100) DEFAULT NULL,
  `DET` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ilfdataser`
--

LOCK TABLES `ilfdataser` WRITE;
/*!40000 ALTER TABLE `ilfdataser` DISABLE KEYS */;
/*!40000 ALTER TABLE `ilfdataser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requirement` (
  `id` varchar(100) NOT NULL,
  `userId` varchar(100) NOT NULL,
  `descriptionId` varchar(100) NOT NULL,
  `FolderId` varchar(100) NOT NULL,
  `VAFId` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `createTime` varchar(100) NOT NULL,
  `remark` varchar(100) NOT NULL,
  `workTime` int NOT NULL,
  `workCost` int NOT NULL,
  `UFP` int NOT NULL,
  `AFP` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement`
--

LOCK TABLES `requirement` WRITE;
/*!40000 ALTER TABLE `requirement` DISABLE KEYS */;
/*!40000 ALTER TABLE `requirement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `step`
--

DROP TABLE IF EXISTS `step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `step` (
  `id` varchar(100) NOT NULL,
  `transactionId` varchar(100) DEFAULT NULL,
  `stepName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `step`
--

LOCK TABLES `step` WRITE;
/*!40000 ALTER TABLE `step` DISABLE KEYS */;
/*!40000 ALTER TABLE `step` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` varchar(100) NOT NULL,
  `transactionName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaf`
--

DROP TABLE IF EXISTS `vaf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaf` (
  `id` varchar(100) NOT NULL,
  `developmentType` varchar(100) DEFAULT NULL,
  `developmentPlatform` varchar(100) DEFAULT NULL,
  `cost` varchar(100) DEFAULT NULL,
  `productivity` varchar(100) DEFAULT NULL,
  `SCED` varchar(100) DEFAULT NULL,
  `TIME` varchar(100) DEFAULT NULL,
  `CPLX` varchar(100) DEFAULT NULL,
  `RELY` varchar(100) DEFAULT NULL,
  `DBMS_Used` varchar(100) DEFAULT NULL,
  `languageType` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idVAF_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaf`
--

LOCK TABLES `vaf` WRITE;
/*!40000 ALTER TABLE `vaf` DISABLE KEYS */;
/*!40000 ALTER TABLE `vaf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'softwareestimation'
--

--
-- Dumping routines for database 'softwareestimation'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-12 20:11:36
