-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: dbquanlytoanhavp
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `baccongviec`
--

DROP TABLE IF EXISTS `baccongviec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baccongviec` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `hesobac` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baccongviec`
--

LOCK TABLES `baccongviec` WRITE;
/*!40000 ALTER TABLE `baccongviec` DISABLE KEYS */;
/*!40000 ALTER TABLE `baccongviec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietvaora`
--

DROP TABLE IF EXISTS `chitietvaora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietvaora` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `thoigianra` datetime(6) DEFAULT NULL,
  `thoigianvao` datetime(6) DEFAULT NULL,
  `nhan_vien_cong_ty_id` bigint DEFAULT NULL,
  `vi_tri_vao_ra_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf4dbhdqnu3e0g7uj3nft62apb` (`nhan_vien_cong_ty_id`),
  KEY `FKntms6wie14tilbb7xssxv3s1h` (`vi_tri_vao_ra_id`),
  CONSTRAINT `FKf4dbhdqnu3e0g7uj3nft62apb` FOREIGN KEY (`nhan_vien_cong_ty_id`) REFERENCES `nhanviencongty` (`manv`),
  CONSTRAINT `FKntms6wie14tilbb7xssxv3s1h` FOREIGN KEY (`vi_tri_vao_ra_id`) REFERENCES `vitrivaora` (`mavt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietvaora`
--

LOCK TABLES `chitietvaora` WRITE;
/*!40000 ALTER TABLE `chitietvaora` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietvaora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `congty`
--

DROP TABLE IF EXISTS `congty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `congty` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dtmatbang` double DEFAULT NULL,
  `diachi` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `linhvuchoatdong` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `masothue` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sodienthoai` bigint DEFAULT NULL,
  `sonhanvien` int DEFAULT NULL,
  `tencongty` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vondieule` bigint DEFAULT NULL,
  `tongtien` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `congty`
--

LOCK TABLES `congty` WRITE;
/*!40000 ALTER TABLE `congty` DISABLE KEYS */;
INSERT INTO `congty` VALUES (9,122,'tầng 3 khu a','Giáo dục','03202304043',1234567,2,'CTY viêt long',10040050000,5651),(11,200,'tầng 3 khu a','Giáo dục','03202304043',1234567,10,'CTY viêt long thuc chiến',10040050000,9124),(12,200,'tầng 3 khu a','Giáo dục','03202304043',1234567,3,'CTY viêt long thuc chiến',10040050000,6193),(13,100,'tầng 3 khu a','Van hoa','03202304043',1234567,20,'Cty xuaan phi11',10040050000,8124),(14,0.07,'tầng 3 khu a','Giáo dục','03202304043',1234567,3,'CTY phi2',10040050000,3015),(15,10000,'tầng 3 khu a','Giáo dục','03202304043',1234567,50,'CTY viêt long123',10040050000,109179),(16,700,'tầng 3 khu a','Giáo dục','03202304043',1234567,18,'CTY viêt long1',10040050000,17556),(17,10000,'tầng 3 khu a','Giáo dục','03202304043',1234567,20,'CTY viêt long thuc chiến',10040050000,103014);
/*!40000 ALTER TABLE `congty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `congtydichvu`
--

DROP TABLE IF EXISTS `congtydichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `congtydichvu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ngaydangkydv` datetime(6) DEFAULT NULL,
  `congty_id` bigint DEFAULT NULL,
  `dichvu_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt5pn13itw4id3q1tpslr411gp` (`congty_id`),
  KEY `FKcwykmvmsf0f1lfs8c9fb10si6` (`dichvu_id`),
  CONSTRAINT `FKcwykmvmsf0f1lfs8c9fb10si6` FOREIGN KEY (`dichvu_id`) REFERENCES `dichvu` (`madv`),
  CONSTRAINT `FKt5pn13itw4id3q1tpslr411gp` FOREIGN KEY (`congty_id`) REFERENCES `congty` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `congtydichvu`
--

LOCK TABLES `congtydichvu` WRITE;
/*!40000 ALTER TABLE `congtydichvu` DISABLE KEYS */;
INSERT INTO `congtydichvu` VALUES (38,'2020-12-14 03:15:01.587000',9,4),(39,'2020-12-14 03:15:01.610000',9,1),(40,'2020-12-14 03:15:01.628000',9,2),(43,'2020-12-14 03:22:16.915000',11,3),(44,'2020-12-14 03:22:16.944000',11,1),(45,'2020-12-14 03:22:16.962000',11,2),(46,'2020-12-14 03:22:44.809000',11,5),(47,'2020-12-14 03:24:03.928000',12,3),(48,'2020-12-14 03:24:03.956000',12,1),(49,'2020-12-14 03:24:03.978000',12,2),(50,'2020-12-14 03:24:40.477000',13,3),(51,'2020-12-14 03:24:40.496000',13,5),(52,'2020-12-14 03:24:40.517000',13,1),(53,'2020-12-14 03:24:40.535000',13,2),(54,'2020-12-14 03:51:17.359000',14,1),(55,'2020-12-14 03:51:17.392000',14,2),(56,'2020-12-14 03:52:03.333000',15,3),(57,'2020-12-14 03:52:03.349000',15,4),(58,'2020-12-14 03:52:03.364000',15,5),(59,'2020-12-14 03:52:03.385000',15,1),(60,'2020-12-14 03:52:03.404000',15,2),(61,'2020-12-14 07:16:15.295000',16,4),(62,'2020-12-14 07:16:15.346000',16,1),(63,'2020-12-14 07:16:15.390000',16,2),(64,'2020-12-14 07:33:33.271000',16,5),(65,'2020-12-14 07:33:33.278000',16,3),(66,'2020-12-14 07:34:46.337000',17,1),(67,'2020-12-14 07:34:46.367000',17,2);
/*!40000 ALTER TABLE `congtydichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dichvu`
--

DROP TABLE IF EXISTS `dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvu` (
  `madv` bigint NOT NULL AUTO_INCREMENT,
  `dongia` double DEFAULT NULL,
  `hesoluong` double DEFAULT NULL,
  `loaidv` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tendv` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`madv`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (1,10,1.4,'Vệ sinh','Vệ sinh'),(2,12,2.3,'An ninh','Bảo vệ'),(3,12,2.2,'An ninh','Trông xe'),(4,15,1.2,'Dinh dưỡng','Ăn Uống'),(5,18,1.3,'Tiện ích','Bảo trì thiết bị');
/*!40000 ALTER TABLE `dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanviencongty`
--

DROP TABLE IF EXISTS `nhanviencongty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanviencongty` (
  `manv` bigint NOT NULL AUTO_INCREMENT,
  `cmt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngaysinh` datetime(6) DEFAULT NULL,
  `sodienthoai` bigint NOT NULL,
  `tennv` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `congty_id` bigint NOT NULL,
  PRIMARY KEY (`manv`),
  KEY `FKsnh7eorowas1xivwp8udt8rel` (`congty_id`),
  CONSTRAINT `FKsnh7eorowas1xivwp8udt8rel` FOREIGN KEY (`congty_id`) REFERENCES `congty` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanviencongty`
--

LOCK TABLES `nhanviencongty` WRITE;
/*!40000 ALTER TABLE `nhanviencongty` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhanviencongty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvientoanha`
--

DROP TABLE IF EXISTS `nhanvientoanha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvientoanha` (
  `manv` bigint NOT NULL AUTO_INCREMENT,
  `cmt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngaysinh` datetime(6) DEFAULT NULL,
  `sodienthoai` bigint NOT NULL,
  `tennv` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diachi` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `baccongviec_id` bigint NOT NULL,
  `dichvu_id` bigint NOT NULL,
  `vitricongviec_id` bigint NOT NULL,
  PRIMARY KEY (`manv`),
  KEY `FK39wwsqr7oy76gwrabi4pc6sss` (`baccongviec_id`),
  KEY `FKoedkruod0en54qlh9wsah4u1f` (`dichvu_id`),
  KEY `FKdgohhfpls30f5w40bcg3sbsea` (`vitricongviec_id`),
  CONSTRAINT `FK39wwsqr7oy76gwrabi4pc6sss` FOREIGN KEY (`baccongviec_id`) REFERENCES `baccongviec` (`id`),
  CONSTRAINT `FKdgohhfpls30f5w40bcg3sbsea` FOREIGN KEY (`vitricongviec_id`) REFERENCES `vitricongviec` (`id`),
  CONSTRAINT `FKoedkruod0en54qlh9wsah4u1f` FOREIGN KEY (`dichvu_id`) REFERENCES `dichvu` (`madv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvientoanha`
--

LOCK TABLES `nhanvientoanha` WRITE;
/*!40000 ALTER TABLE `nhanvientoanha` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhanvientoanha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `birthday` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `facebook` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `favorite` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vitricongviec`
--

DROP TABLE IF EXISTS `vitricongviec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vitricongviec` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `hesoluong` int DEFAULT NULL,
  `tenvitri` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vitricongviec`
--

LOCK TABLES `vitricongviec` WRITE;
/*!40000 ALTER TABLE `vitricongviec` DISABLE KEYS */;
/*!40000 ALTER TABLE `vitricongviec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vitrivaora`
--

DROP TABLE IF EXISTS `vitrivaora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vitrivaora` (
  `mavt` bigint NOT NULL AUTO_INCREMENT,
  `tenvt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`mavt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vitrivaora`
--

LOCK TABLES `vitrivaora` WRITE;
/*!40000 ALTER TABLE `vitrivaora` DISABLE KEYS */;
/*!40000 ALTER TABLE `vitrivaora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'dbquanlytoanhavp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-30  9:31:46
