
USE `hw`;
-- MySQL dump 10.13  Distrib 5.5.16, for osx10.5 (i386)
--
-- Host: localhost    Database: hw
-- ------------------------------------------------------
-- Server version	5.5.24

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
-- Table structure for table `scbs_unidadeespecialidade`
--

DROP TABLE IF EXISTS `scbs_unidadeespecialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_unidadeespecialidade` (
  `CODIGOUNIDADESAUDE` varchar(50) NOT NULL,
  `CODIGOESPECIALIDADE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGOUNIDADESAUDE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_unidadeespecialidade`
--

LOCK TABLES `scbs_unidadeespecialidade` WRITE;
/*!40000 ALTER TABLE `scbs_unidadeespecialidade` DISABLE KEYS */;
INSERT INTO `scbs_unidadeespecialidade` VALUES ('1','1'),('2','2');
/*!40000 ALTER TABLE `scbs_unidadeespecialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scbs_tipodoencasintoma`
--

DROP TABLE IF EXISTS `scbs_tipodoencasintoma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_tipodoencasintoma` (
  `CODIGOTIPODOENCA` varchar(50) NOT NULL,
  `CODIGOSINTOMA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGOTIPODOENCA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_tipodoencasintoma`
--

LOCK TABLES `scbs_tipodoencasintoma` WRITE;
/*!40000 ALTER TABLE `scbs_tipodoencasintoma` DISABLE KEYS */;
INSERT INTO `scbs_tipodoencasintoma` VALUES ('1','1'),('2','2');
/*!40000 ALTER TABLE `scbs_tipodoencasintoma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scbs_queixa`
--

DROP TABLE IF EXISTS `scbs_queixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_queixa` (
  `CODIGO` varchar(50) NOT NULL,
  `TIPOQUEIXA` varchar(45) DEFAULT NULL,
  `SOLICITANTE` varchar(45) DEFAULT NULL,
  `DESCRICAO` varchar(45) DEFAULT NULL,
  `OBSERVACAO` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `FUNCIONARIO` varchar(45) DEFAULT NULL,
  `SITUACAO` varchar(45) DEFAULT NULL,
  `dataPARECER` varchar(45) DEFAULT NULL,
  `dataQUEIXA` varchar(45) DEFAULT NULL,
  `ENDERECOSOLICITANTE` varchar(45) DEFAULT NULL,
  `ts` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_queixa`
--

LOCK TABLES `scbs_queixa` WRITE;
/*!40000 ALTER TABLE `scbs_queixa` DISABLE KEYS */;
INSERT INTO `scbs_queixa` VALUES ('1','1','Andre','New Complaint','New Observations','andre@mail.com','NULL','1','NULL','02/08/2012','3','0'),('2','2','Sample','New','new','Tes','NULL','1','NULL','02/08/2012','5','0');
/*!40000 ALTER TABLE `scbs_queixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scbs_queixaanimal`
--

DROP TABLE IF EXISTS `scbs_queixaanimal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_queixaanimal` (
  `CODIGO` varchar(50) NOT NULL,
  `QTDEANIMAIS` varchar(45) DEFAULT NULL,
  `DATAINCOMODO` varchar(45) DEFAULT NULL,
  `ANIMAL` varchar(45) DEFAULT NULL,
  `ENDERECOLOCALOCORRENCIA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_queixaanimal`
--

LOCK TABLES `scbs_queixaanimal` WRITE;
/*!40000 ALTER TABLE `scbs_queixaanimal` DISABLE KEYS */;
INSERT INTO `scbs_queixaanimal` VALUES ('2','1','12/5/2012','Animal','6');
/*!40000 ALTER TABLE `scbs_queixaanimal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scbs_funcionario`
--

DROP TABLE IF EXISTS `scbs_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_funcionario` (
  `LOGIN` varchar(50) NOT NULL,
  `NOME` varchar(45) DEFAULT NULL,
  `SENHA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`LOGIN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_funcionario`
--

LOCK TABLES `scbs_funcionario` WRITE;
/*!40000 ALTER TABLE `scbs_funcionario` DISABLE KEYS */;
INSERT INTO `scbs_funcionario` VALUES ('andregustavoo@gmail.com','andre','andre'),('default','default','default'),('diego','diego','diego'),('everton','everton','everton'),('fred','fred','fred');
/*!40000 ALTER TABLE `scbs_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scbs_sintoma`
--

DROP TABLE IF EXISTS `scbs_sintoma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_sintoma` (
  `CODIGO` varchar(50) NOT NULL,
  `DESCRICAO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_sintoma`
--

LOCK TABLES `scbs_sintoma` WRITE;
/*!40000 ALTER TABLE `scbs_sintoma` DISABLE KEYS */;
INSERT INTO `scbs_sintoma` VALUES ('1','tosse'),('2','febre'),('4','Novo Sintoma');
/*!40000 ALTER TABLE `scbs_sintoma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scbs_queixadiversa`
--

DROP TABLE IF EXISTS `scbs_queixadiversa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_queixadiversa` (
  `CODIGO` varchar(50) NOT NULL,
  `IDADE` varchar(45) DEFAULT NULL,
  `OCUPACAO` varchar(45) DEFAULT NULL,
  `INSTRUCAO` varchar(45) DEFAULT NULL,
  `ENDERECOOCORRENCIA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_queixadiversa`
--

LOCK TABLES `scbs_queixadiversa` WRITE;
/*!40000 ALTER TABLE `scbs_queixadiversa` DISABLE KEYS */;
/*!40000 ALTER TABLE `scbs_queixadiversa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scbs_especialidade`
--

DROP TABLE IF EXISTS `scbs_especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_especialidade` (
  `CODIGO` varchar(50) NOT NULL,
  `DESCRICAO` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_especialidade`
--

LOCK TABLES `scbs_especialidade` WRITE;
/*!40000 ALTER TABLE `scbs_especialidade` DISABLE KEYS */;
INSERT INTO `scbs_especialidade` VALUES ('1','cardiologia'),('2','oftalmologia');
/*!40000 ALTER TABLE `scbs_especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scbs_tipodoenca`
--

DROP TABLE IF EXISTS `scbs_tipodoenca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_tipodoenca` (
  `CODIGO` varchar(50) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `DESCRICAO` varchar(45) DEFAULT NULL,
  `manifestacao` varchar(45) DEFAULT NULL,
  `duracao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_tipodoenca`
--

LOCK TABLES `scbs_tipodoenca` WRITE;
/*!40000 ALTER TABLE `scbs_tipodoenca` DISABLE KEYS */;
INSERT INTO `scbs_tipodoenca` VALUES ('1','gripe','gripe comum','tosse e gripe','3'),('2','dengue','tipo 1','dores no corpo e febre','7');
/*!40000 ALTER TABLE `scbs_tipodoenca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scbs_queixaalimentar`
--

DROP TABLE IF EXISTS `scbs_queixaalimentar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_queixaalimentar` (
  `CODIGO` varchar(50) NOT NULL,
  `QTDECOMENSAIS` varchar(45) DEFAULT NULL,
  `QTDEDOENTES` varchar(45) DEFAULT NULL,
  `QTDEINTERNACOES` varchar(45) DEFAULT NULL,
  `QTDEOBITOS` varchar(45) DEFAULT NULL,
  `LOCALATENDIMENTO` varchar(45) DEFAULT NULL,
  `REFEICAOSUSPEITA` varchar(45) DEFAULT NULL,
  `ENDERECODOENTE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_queixaalimentar`
--

LOCK TABLES `scbs_queixaalimentar` WRITE;
/*!40000 ALTER TABLE `scbs_queixaalimentar` DISABLE KEYS */;
INSERT INTO `scbs_queixaalimentar` VALUES ('1','10','4','3','0','HW','Meat','4');
/*!40000 ALTER TABLE `scbs_queixaalimentar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scbs_endereco`
--

DROP TABLE IF EXISTS `scbs_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_endereco` (
  `codigo` varchar(50) NOT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `Complemento` varchar(45) DEFAULT NULL,
  `Cep` varchar(45) DEFAULT NULL,
  `Uf` varchar(45) DEFAULT NULL,
  `Fone` varchar(45) DEFAULT NULL,
  `Cidade` varchar(45) DEFAULT NULL,
  `Bairro` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_endereco`
--

LOCK TABLES `scbs_endereco` WRITE;
/*!40000 ALTER TABLE `scbs_endereco` DISABLE KEYS */;
INSERT INTO `scbs_endereco` VALUES ('1','contorno do campus','nao tem','59090680','RN','8888-8888','Natal','Capim Macio'),('2','rio branco','apto 300','59090600','RN','7777-7777','Natal','Cidade Alta'),('3','testq','Test','900','RN','8788','Te','Tes'),('4','Teste','Test','8999','RN','Tet','Natal','Et'),('5','teste','sample','Tes','Tes','Tes','Tes','test'),('6','Av. news room','Complete','90999','89','4555','Natal','New York');
/*!40000 ALTER TABLE `scbs_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scbs_unidadesaude`
--

DROP TABLE IF EXISTS `scbs_unidadesaude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scbs_unidadesaude` (
  `CODIGO` varchar(50) NOT NULL,
  `DESCRICAO` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scbs_unidadesaude`
--

LOCK TABLES `scbs_unidadesaude` WRITE;
/*!40000 ALTER TABLE `scbs_unidadesaude` DISABLE KEYS */;
INSERT INTO `scbs_unidadesaude` VALUES ('1','ponta negra'),('2','cidade alta');
/*!40000 ALTER TABLE `scbs_unidadesaude` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-09-07  9:30:20
