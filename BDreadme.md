# O banco de dados do projeto
## A estrutura do banco

O banco de dados do projeto é composto por 3 tabelas principais, sendo elas: <br>
tb_agenda - composto pelas rows:<br>
id (chave primaria)<br>
data<br>
hora<br>
descricao<br>
nome_cli<br>

tb_clientes - composto pelas rows:<br>
id (chave primaria)<br>
nome<br>
endereco<br>
telefone<br>
email<br>
cpf_cnpj<br>

tb_usuarios - composto pelas rows:<br>
id (chave primaria)<br>
nome<br>
email - de tipo UNIQUE para evitar dupra entrada <br>
nome_usuario de tipo UNIQUE para evitar dupra entrada<br>
senha<br>

as tabelas guardam valores de tipos especificos nas suas rows o banco de dados é composto apenas por isso. <br>

# Instruções de conexão e execução do banco

<br>

## Conexão

O sistema possui uma classe central chamada ConexaoDAO, responsável por estabelecer a comunicação com o banco de dados MySQL. Essa classe utiliza o driver mysql-connector-9.0.0 para criar a conexão e o mecanismo Try-Catch para tratar possíveis erros. As demais classes, como ClienteDAO, AgendaDAO e UsuarioDAO, utilizam essa conexão como base para executar suas operações. Elas enviam comandos SQL para o banco através do PreparedStatement e recebem os resultados em um ResultSet.

## SQL Scripts

CREATE DATABASE  IF NOT EXISTS `projfinal` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */; <br>
USE `projfinal`; <br>
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64) <br>
-- <br>
-- Host: 127.0.0.1    Database: projfinal<br>
-- ------------------------------------------------------<br>
-- Server version	8.0.39<br>
<br>
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;<br>
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;<br>
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;<br>
/*!50503 SET NAMES utf8 */;<br>
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;<br>
/*!40103 SET TIME_ZONE='+00:00' */;<br>
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;<br>
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;<br>
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;<br>
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;<br>
<br>
--<br>
-- Table structure for table `tb_agenda`<br>
--<br>
<br>
DROP TABLE IF EXISTS `tb_agenda`;<br>
/*!40101 SET @saved_cs_client     = @@character_set_client */;<br>
/*!50503 SET character_set_client = utf8mb4 */;<br>
CREATE TABLE `tb_agenda` (<br>
  `id` int NOT NULL AUTO_INCREMENT,<br>
  `data` date DEFAULT NULL,<br>
  `hora` time DEFAULT NULL,<br>
  `descricao` varchar(300) DEFAULT NULL,<br>
  `nome_cli` varchar(45) DEFAULT NULL,<br>
  PRIMARY KEY (`id`)<br>
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;<br>
/*!40101 SET character_set_client = @saved_cs_client */;<br>
<br>
--<br>
-- Dumping data for table `tb_agenda`<br>
--<br>
<br>
LOCK TABLES `tb_agenda` WRITE;<br>
/*!40000 ALTER TABLE `tb_agenda` DISABLE KEYS */;<br>
/*!40000 ALTER TABLE `tb_agenda` ENABLE KEYS */;<br>
UNLOCK TABLES;<br>
<br>
--<br>
-- Table structure for table `tb_clientes`<br>
--<br>
<br>
DROP TABLE IF EXISTS `tb_clientes`;<br>
/*!40101 SET @saved_cs_client     = @@character_set_client */;<br>
/*!50503 SET character_set_client = utf8mb4 */;<br>
CREATE TABLE `tb_clientes` (<br>
  `id` int NOT NULL AUTO_INCREMENT,<br>
  `nome` varchar(100) DEFAULT NULL,<br>
  `endereco` varchar(100) DEFAULT NULL,<br>
  `telefone` varchar(100) DEFAULT NULL,<br>
  `email` varchar(100) DEFAULT NULL,<br>
  `cpf_cnpj` varchar(50) DEFAULT NULL,<br>
  PRIMARY KEY (`id`)<br>
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;<br>
/*!40101 SET character_set_client = @saved_cs_client */;<br>
<br>
--<br>
-- Dumping data for table `tb_clientes`<br>
--<br>
<br>
LOCK TABLES `tb_clientes` WRITE;<br>
/*!40000 ALTER TABLE `tb_clientes` DISABLE KEYS */;<br>
/*!40000 ALTER TABLE `tb_clientes` ENABLE KEYS */;<br>
UNLOCK TABLES;<br>
<br>
--<br>
-- Table structure for table `tb_usuarios`<br>
--<br>
<br>
DROP TABLE IF EXISTS `tb_usuarios`;<br>
/*!40101 SET @saved_cs_client     = @@character_set_client */;<br>
/*!50503 SET character_set_client = utf8mb4 */;<br>
CREATE TABLE `tb_usuarios` (<br>
  `id` int NOT NULL AUTO_INCREMENT,<br>
  `nome` varchar(100) DEFAULT NULL,<br>
  `email` varchar(100) DEFAULT NULL,<br>
  `nome_usuario` varchar(100) DEFAULT NULL,<br>
  `senha` varchar(100) DEFAULT NULL,<br>
  PRIMARY KEY (`id`),<br>
  UNIQUE KEY `email_UNIQUE` (`email`),<br>
  UNIQUE KEY `nome_usuario_UNIQUE` (`nome_usuario`)<br>
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;<br>
/*!40101 SET character_set_client = @saved_cs_client */;<br>
<br>
--<br>
-- Dumping data for table `tb_usuarios`<br>
--<br>
<br>
LOCK TABLES `tb_usuarios` WRITE;<br>
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;<br>
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;<br>
UNLOCK TABLES;<br>
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;<br>
<br>
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;<br>
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;<br>
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;<br>
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;<br>
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;<br>
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;<br>
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;<br>
