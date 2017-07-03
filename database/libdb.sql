CREATE DATABASE  IF NOT EXISTS `libdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `libdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: libdb
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `borrowhistory`
--

DROP TABLE IF EXISTS `borrowhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrowhistory` (
  `borrowId` int(11) NOT NULL AUTO_INCREMENT,
  `catalogId` int(11) NOT NULL,
  `statusId` int(11) NOT NULL,
  `accountId` int(11) DEFAULT NULL,
  `dateBorrowed` datetime NOT NULL,
  `dateExpectReturn` datetime NOT NULL,
  `dateReturn` datetime DEFAULT NULL,
  PRIMARY KEY (`borrowId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowhistory`
--

LOCK TABLES `borrowhistory` WRITE;
/*!40000 ALTER TABLE `borrowhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrowhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog`
--

DROP TABLE IF EXISTS `catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalog` (
  `catalogId` int(11) NOT NULL AUTO_INCREMENT,
  `statusId` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  `currentborrowId` int(11) DEFAULT NULL,
  `location` varchar(50) NOT NULL,
  `author` varchar(150) NOT NULL,
  `publisher` varchar(150) NOT NULL,
  `year` int(11) NOT NULL,
  `tags` varchar(500) NOT NULL,
  PRIMARY KEY (`catalogId`),
  KEY `statusId_idx` (`statusId`),
  KEY `typeId_idx` (`typeId`),
  KEY `borrowId_idx` (`currentborrowId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog`
--

LOCK TABLES `catalog` WRITE;
/*!40000 ALTER TABLE `catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalogtype`
--

DROP TABLE IF EXISTS `catalogtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalogtype` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogtype`
--

LOCK TABLES `catalogtype` WRITE;
/*!40000 ALTER TABLE `catalogtype` DISABLE KEYS */;
INSERT INTO `catalogtype` VALUES (1,'Book'),(2,'Magazine'),(3,'Thesis');
/*!40000 ALTER TABLE `catalogtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetingroom`
--

DROP TABLE IF EXISTS `meetingroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meetingroom` (
  `roomId` int(11) NOT NULL AUTO_INCREMENT,
  `statusId` int(11) NOT NULL,
  `roomTypeId` int(11) NOT NULL,
  `reserveId` int(11) DEFAULT NULL,
  `startTimeslot` time(3) NOT NULL,
  `endTimeslot` time(3) NOT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetingroom`
--

LOCK TABLES `meetingroom` WRITE;
/*!40000 ALTER TABLE `meetingroom` DISABLE KEYS */;
INSERT INTO `meetingroom` VALUES (2,1,1,NULL,'07:00:00.000','07:30:00.000'),(3,1,1,NULL,'07:30:00.000','08:00:00.000'),(4,1,1,NULL,'08:00:00.000','08:30:00.000'),(5,1,1,NULL,'08:30:00.000','09:30:00.000'),(6,1,1,NULL,'09:30:00.000','10:00:00.000'),(7,1,1,NULL,'10:00:00.000','10:30:00.000'),(8,1,1,NULL,'10:30:00.000','11:00:00.000'),(9,1,1,NULL,'11:00:00.000','11:30:00.000'),(10,1,1,NULL,'11:30:00.000','12:00:00.000'),(11,1,1,NULL,'12:00:00.000','12:30:00.000'),(12,1,1,NULL,'12:30:00.000','13:00:00.000'),(13,1,1,NULL,'13:00:00.000','13:30:00.000'),(14,1,1,NULL,'13:30:00.000','14:00:00.000'),(15,1,1,NULL,'14:00:00.000','14:30:00.000'),(16,1,1,NULL,'14:30:00.000','15:00:00.000'),(17,1,1,NULL,'15:00:00.000','15:30:00.000'),(18,1,1,NULL,'15:30:00.000','16:00:00.000'),(19,1,1,NULL,'16:00:00.000','16:30:00.000'),(20,1,1,NULL,'16:30:00.000','17:00:00.000'),(21,1,1,NULL,'17:00:00.000','17:30:00.000'),(22,1,1,NULL,'17:30:00.000','18:00:00.000'),(23,1,1,NULL,'18:00:00.000','18:30:00.000'),(24,1,1,NULL,'18:30:00.000','19:00:00.000'),(25,1,1,NULL,'19:00:00.000','19:30:00.000'),(26,1,1,NULL,'19:30:00.000','20:00:00.000'),(27,1,2,NULL,'07:00:00.000','07:30:00.000'),(28,1,2,NULL,'07:30:00.000','08:00:00.000'),(29,1,2,NULL,'08:00:00.000','08:30:00.000'),(30,1,2,NULL,'08:30:00.000','09:00:00.000'),(31,1,2,NULL,'09:00:00.000','09:30:00.000'),(32,1,2,NULL,'09:30:00.000','10:00:00.000'),(33,1,2,NULL,'10:00:00.000','10:30:00.000'),(34,1,2,NULL,'10:30:00.000','11:00:00.000'),(35,1,2,NULL,'11:00:00.000','11:30:00.000'),(36,1,2,NULL,'11:30:00.000','12:00:00.000'),(37,1,2,NULL,'12:00:00.000','12:30:00.000'),(38,1,2,NULL,'12:30:00.000','13:00:00.000'),(39,1,2,NULL,'13:00:00.000','13:30:00.000'),(40,1,2,NULL,'13:30:00.000','14:00:00.000'),(41,1,2,NULL,'14:00:00.000','14:30:00.000'),(42,1,2,NULL,'14:30:00.000','15:00:00.000'),(43,1,2,NULL,'15:00:00.000','15:30:00.000'),(44,1,2,NULL,'15:30:00.000','16:00:00.000'),(45,1,2,NULL,'16:30:00.000','17:00:00.000'),(46,1,2,NULL,'17:00:00.000','17:30:00.000'),(47,1,2,NULL,'17:30:00.000','18:00:00.000'),(48,1,2,NULL,'18:00:00.000','18:30:00.000'),(49,1,2,NULL,'18:30:00.000','19:00:00.000'),(50,1,2,NULL,'19:00:00.000','19:30:00.000'),(51,1,2,NULL,'19:30:00.000','20:00:00.000'),(52,1,2,NULL,'16:00:00.000','16:30:00.000'),(53,1,3,NULL,'07:00:00.000','07:30:00.000'),(54,1,3,NULL,'07:30:00.000','08:00:00.000'),(55,1,3,NULL,'08:00:00.000','08:30:00.000'),(56,1,3,NULL,'08:30:00.000','09:00:00.000'),(57,1,3,NULL,'09:00:00.000','09:30:00.000'),(58,1,3,NULL,'09:30:00.000','10:00:00.000'),(59,1,3,NULL,'10:00:00.000','10:30:00.000'),(60,1,3,NULL,'10:30:00.000','11:00:00.000'),(61,1,3,NULL,'11:00:00.000','11:30:00.000'),(62,1,3,NULL,'11:30:00.000','12:00:00.000'),(63,1,3,NULL,'12:00:00.000','12:30:00.000'),(64,1,3,NULL,'12:30:00.000','13:00:00.000'),(65,1,3,NULL,'13:00:00.000','13:30:00.000'),(66,1,3,NULL,'13:30:00.000','14:00:00.000'),(67,1,3,NULL,'14:00:00.000','14:30:00.000'),(68,1,3,NULL,'14:30:00.000','15:00:00.000'),(69,1,3,NULL,'15:00:00.000','15:30:00.000'),(70,1,3,NULL,'15:30:00.000','16:00:00.000'),(71,1,3,NULL,'16:00:00.000','16:30:00.000'),(72,1,3,NULL,'16:30:00.000','17:00:00.000'),(73,1,3,NULL,'17:00:00.000','17:30:00.000'),(74,1,3,NULL,'17:30:00.000','18:00:00.000'),(75,1,3,NULL,'18:00:00.000','18:30:00.000'),(76,1,3,NULL,'18:30:00.000','19:00:00.000'),(77,1,3,NULL,'19:00:00.000','19:30:00.000'),(78,1,3,NULL,'19:30:00.000','20:00:00.000'),(79,1,4,NULL,'07:00:00.000','07:30:00.000'),(80,1,4,NULL,'07:30:00.000','08:00:00.000'),(81,1,4,NULL,'08:00:00.000','08:30:00.000'),(82,1,4,NULL,'08:30:00.000','09:00:00.000'),(83,1,4,NULL,'09:00:00.000','09:30:00.000'),(84,1,4,NULL,'09:30:00.000','10:00:00.000'),(85,1,4,NULL,'10:00:00.000','10:30:00.000'),(86,1,4,NULL,'10:30:00.000','11:00:00.000'),(87,1,4,NULL,'11:00:00.000','11:30:00.000'),(88,1,4,NULL,'11:30:00.000','12:00:00.000'),(89,1,4,NULL,'12:00:00.000','12:30:00.000'),(90,1,4,NULL,'12:30:00.000','13:00:00.000'),(91,1,4,NULL,'13:00:00.000','13:30:00.000'),(92,1,4,NULL,'13:30:00.000','14:00:00.000'),(93,1,4,NULL,'14:00:00.000','14:30:00.000'),(94,1,4,NULL,'14:30:00.000','15:00:00.000'),(95,1,4,NULL,'15:00:00.000','15:30:00.000'),(96,1,4,NULL,'15:30:00.000','16:00:00.000'),(97,1,4,NULL,'16:00:00.000','16:30:00.000'),(98,1,4,NULL,'16:30:00.000','17:00:00.000'),(99,1,4,NULL,'17:00:00.000','17:30:00.000'),(100,1,4,NULL,'17:30:00.000','18:00:00.000'),(101,1,4,NULL,'18:00:00.000','18:30:00.000'),(102,1,4,NULL,'18:30:00.000','19:00:00.000'),(103,1,4,NULL,'19:00:00.000','19:30:00.000'),(104,1,4,NULL,'19:30:00.000','20:00:00.000'),(105,1,5,NULL,'07:00:00.000','07:30:00.000'),(106,1,5,NULL,'07:30:00.000','08:00:00.000'),(107,1,5,NULL,'08:00:00.000','08:30:00.000'),(108,1,5,NULL,'08:30:00.000','09:00:00.000'),(109,1,5,NULL,'09:00:00.000','09:30:00.000'),(110,1,5,NULL,'09:30:00.000','10:00:00.000'),(111,1,5,NULL,'10:00:00.000','10:30:00.000'),(112,1,5,NULL,'10:30:00.000','11:00:00.000'),(113,1,5,NULL,'11:00:00.000','11:30:00.000'),(114,1,5,NULL,'11:30:00.000','12:00:00.000'),(115,1,5,NULL,'12:00:00.000','12:30:00.000'),(116,1,5,NULL,'12:30:00.000','13:00:00.000'),(117,1,5,NULL,'13:00:00.000','13:30:00.000'),(118,1,5,NULL,'13:30:00.000','14:00:00.000'),(119,1,5,NULL,'14:00:00.000','14:30:00.000'),(120,1,5,NULL,'14:30:00.000','15:00:00.000'),(121,1,5,NULL,'15:00:00.000','15:30:00.000'),(122,1,5,NULL,'15:30:00.000','16:00:00.000'),(123,1,5,NULL,'16:00:00.000','16:30:00.000'),(124,1,5,NULL,'16:30:00.000','17:00:00.000'),(125,1,5,NULL,'17:00:00.000','17:30:00.000'),(126,1,5,NULL,'17:30:00.000','18:00:00.000'),(127,1,5,NULL,'18:00:00.000','18:30:00.000'),(128,1,5,NULL,'18:30:00.000','19:00:00.000'),(129,1,5,NULL,'19:00:00.000','19:30:00.000'),(130,1,5,NULL,'19:30:00.000','20:00:00.000');
/*!40000 ALTER TABLE `meetingroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetingroomtype`
--

DROP TABLE IF EXISTS `meetingroomtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meetingroomtype` (
  `roomTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `room` varchar(45) NOT NULL,
  PRIMARY KEY (`roomTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetingroomtype`
--

LOCK TABLES `meetingroomtype` WRITE;
/*!40000 ALTER TABLE `meetingroomtype` DISABLE KEYS */;
INSERT INTO `meetingroomtype` VALUES (1,'Michaelangelo'),(2,'Leonardo'),(3,'Donatello'),(4,'Raphael'),(5,'Boticelli');
/*!40000 ALTER TABLE `meetingroomtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservehistory`
--

DROP TABLE IF EXISTS `reservehistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservehistory` (
  `reserveId` int(11) NOT NULL AUTO_INCREMENT,
  `roomId` int(11) NOT NULL,
  `accountId` int(11) NOT NULL,
  `dateReserved` datetime NOT NULL,
  PRIMARY KEY (`reserveId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservehistory`
--

LOCK TABLES `reservehistory` WRITE;
/*!40000 ALTER TABLE `reservehistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservehistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `reviewId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `catalogId` int(11) NOT NULL,
  `review` varchar(500) NOT NULL,
  `dateReviewed` datetime NOT NULL,
  PRIMARY KEY (`reviewId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretquestions`
--

DROP TABLE IF EXISTS `secretquestions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secretquestions` (
  `SQId` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(200) NOT NULL,
  PRIMARY KEY (`SQId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretquestions`
--

LOCK TABLES `secretquestions` WRITE;
/*!40000 ALTER TABLE `secretquestions` DISABLE KEYS */;
/*!40000 ALTER TABLE `secretquestions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statustype`
--

DROP TABLE IF EXISTS `statustype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statustype` (
  `statusid` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`statusid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statustype`
--

LOCK TABLES `statustype` WRITE;
/*!40000 ALTER TABLE `statustype` DISABLE KEYS */;
INSERT INTO `statustype` VALUES (0,'Out'),(1,'Available'),(2,'Reserved'),(3,'On Hand'),(4,'Returned');
/*!40000 ALTER TABLE `statustype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccount`
--

DROP TABLE IF EXISTS `useraccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccount` (
  `accountId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `emailAddress` varchar(150) NOT NULL,
  `SQId` int(11) NOT NULL,
  `SQAnswer` varchar(250) NOT NULL,
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccount`
--

LOCK TABLES `useraccount` WRITE;
/*!40000 ALTER TABLE `useraccount` DISABLE KEYS */;
/*!40000 ALTER TABLE `useraccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userprofile`
--

DROP TABLE IF EXISTS `userprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userprofile` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `middlename` varchar(100) NOT NULL,
  `idNumber` varchar(10) NOT NULL,
  `birthdate` int(11) NOT NULL,
  `birthmonth` int(11) NOT NULL,
  `birthyear` int(11) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userprofile`
--

LOCK TABLES `userprofile` WRITE;
/*!40000 ALTER TABLE `userprofile` DISABLE KEYS */;
/*!40000 ALTER TABLE `userprofile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroles`
--

DROP TABLE IF EXISTS `userroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userroles` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroles`
--

LOCK TABLES `userroles` WRITE;
/*!40000 ALTER TABLE `userroles` DISABLE KEYS */;
INSERT INTO `userroles` VALUES (1,'Student'),(2,'Library Manager'),(3,'Library Staff'),(4,'Administrator');
/*!40000 ALTER TABLE `userroles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-03 17:45:15
