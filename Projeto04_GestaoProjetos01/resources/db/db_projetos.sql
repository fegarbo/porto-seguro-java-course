CREATE DATABASE  IF NOT EXISTS `db_projetos` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_projetos`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: db_projetos
-- ------------------------------------------------------
-- Server version	5.6.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `IDCLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `USUARIO` varchar(20) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `TELEFONE` varchar(20) NOT NULL,
  PRIMARY KEY (`IDCLIENTE`),
  KEY `FK1_idx` (`USUARIO`),
  CONSTRAINT `FK1` FOREIGN KEY (`USUARIO`) REFERENCES `usuarios` (`NOME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'emilio','Emilio Celso de Souza','emiliocelso@hotmail.com','3254-2200'),(2,'impacta','Impacta Tecnologia','contato@impacta.com.br','3254-8300'),(3,'jorge','Jorge da Silva','jorge@contato.com','3392-8754'),(4,'Anderson','Anderson Catellanos','andersoncast@gmail.com','11971171355');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cronogramas`
--

DROP TABLE IF EXISTS `cronogramas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cronogramas` (
  `IDCRONOGRAMA` int(11) NOT NULL AUTO_INCREMENT,
  `IDPROJETO` int(11) NOT NULL,
  `DATA` datetime NOT NULL,
  `DURACAO` int(11) NOT NULL,
  `DESCRICAO` varchar(45) NOT NULL,
  `CONCLUIDO` enum('S','N') NOT NULL,
  PRIMARY KEY (`IDCRONOGRAMA`),
  KEY `FK5_idx` (`IDPROJETO`),
  CONSTRAINT `FK5` FOREIGN KEY (`IDPROJETO`) REFERENCES `projetos` (`IDPROJETO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cronogramas`
--

LOCK TABLES `cronogramas` WRITE;
/*!40000 ALTER TABLE `cronogramas` DISABLE KEYS */;
INSERT INTO `cronogramas` VALUES (1,1,'2018-06-14 00:00:00',16,'Topico Scrum','N'),(2,1,'2018-06-15 00:00:00',12,'Arquitetura MVC','N');
/*!40000 ALTER TABLE `cronogramas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamentos`
--

DROP TABLE IF EXISTS `pagamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagamentos` (
  `IDPAGAMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `DOCUMENTO` varchar(14) NOT NULL,
  `TIPO` enum('PROJETO','HORA') NOT NULL,
  `VALOR` double NOT NULL,
  `IMPOSTO` double NOT NULL,
  PRIMARY KEY (`IDPAGAMENTO`),
  KEY `FK6_idx` (`DOCUMENTO`),
  CONSTRAINT `FK6` FOREIGN KEY (`DOCUMENTO`) REFERENCES `prestadores` (`DOCUMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamentos`
--

LOCK TABLES `pagamentos` WRITE;
/*!40000 ALTER TABLE `pagamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestadores`
--

DROP TABLE IF EXISTS `prestadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestadores` (
  `DOCUMENTO` varchar(14) NOT NULL,
  `USUARIO` varchar(20) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `TELEFONE` varchar(20) NOT NULL,
  PRIMARY KEY (`DOCUMENTO`),
  KEY `FK2_idx` (`USUARIO`),
  CONSTRAINT `FK2` FOREIGN KEY (`USUARIO`) REFERENCES `usuarios` (`NOME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestadores`
--

LOCK TABLES `prestadores` WRITE;
/*!40000 ALTER TABLE `prestadores` DISABLE KEYS */;
INSERT INTO `prestadores` VALUES ('03734487000124','jorge','Jorge Systems Ltda','jorge@systems.com','3254-8810');
/*!40000 ALTER TABLE `prestadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestadores_projetos`
--

DROP TABLE IF EXISTS `prestadores_projetos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestadores_projetos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDPROJETO` int(11) NOT NULL,
  `DOCUMENTO` varchar(14) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK7_idx` (`IDPROJETO`),
  KEY `FK8_idx` (`DOCUMENTO`),
  CONSTRAINT `FK7` FOREIGN KEY (`IDPROJETO`) REFERENCES `projetos` (`IDPROJETO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK8` FOREIGN KEY (`DOCUMENTO`) REFERENCES `prestadores` (`DOCUMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestadores_projetos`
--

LOCK TABLES `prestadores_projetos` WRITE;
/*!40000 ALTER TABLE `prestadores_projetos` DISABLE KEYS */;
INSERT INTO `prestadores_projetos` VALUES (1,1,'03734487000124');
/*!40000 ALTER TABLE `prestadores_projetos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projetos`
--

DROP TABLE IF EXISTS `projetos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projetos` (
  `IDPROJETO` int(11) NOT NULL AUTO_INCREMENT,
  `IDCLIENTE` int(11) NOT NULL,
  `DESCRICAO` varchar(45) NOT NULL,
  `DURACAO` int(11) NOT NULL,
  `VALOR` double NOT NULL,
  PRIMARY KEY (`IDPROJETO`),
  KEY `FK3_idx` (`IDCLIENTE`),
  CONSTRAINT `FK3` FOREIGN KEY (`IDCLIENTE`) REFERENCES `clientes` (`IDCLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projetos`
--

LOCK TABLES `projetos` WRITE;
/*!40000 ALTER TABLE `projetos` DISABLE KEYS */;
INSERT INTO `projetos` VALUES (1,1,'Curso personalizado de \r\nJava',100,1500),(2,2,'Desenvolvimento Android',100,5000);
/*!40000 ALTER TABLE `projetos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `NOME` varchar(20) NOT NULL,
  `SENHA` varchar(32) NOT NULL,
  `NIVEL` enum('ADM','CLIENTE','PREST') NOT NULL,
  PRIMARY KEY (`NOME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('Anderson','89ba023086e37a345839e0c6a0d272eb','CLIENTE'),('emilio','202cb962ac59075b964b07152d234b70','ADM'),('gerson','202cb962ac59075b964b07152d234b70','ADM'),('impacta','202cb962ac59075b964b07152d234b70','CLIENTE'),('jorge','202cb962ac59075b964b07152d234b70','PREST');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-15 17:56:03
