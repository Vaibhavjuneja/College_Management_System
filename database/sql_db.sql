-- MySQL dump 10.13  Distrib 5.5.8, for Win32 (x86)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	5.5.8-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `user_id` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin@ums.com','admin@12345');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alltment`
--

DROP TABLE IF EXISTS `alltment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alltment` (
  `employee_id` varchar(100) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `subject_code` varchar(50) DEFAULT NULL,
  `subject_name` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alltment`
--

LOCK TABLES `alltment` WRITE;
/*!40000 ALTER TABLE `alltment` DISABLE KEYS */;
/*!40000 ALTER TABLE `alltment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `adate` datetime DEFAULT NULL,
  `subject` varchar(200) DEFAULT NULL,
  `roll_no` varchar(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `Presence` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES ('2017-07-25 00:00:00','C','17CSE001','Akshat Goyal','P'),('2017-07-25 00:00:00','C','17CSE001','Akshat Goyal','P');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_master`
--

DROP TABLE IF EXISTS `department_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department_master` (
  `department_name` varchar(50) DEFAULT NULL,
  `department_code` char(20) DEFAULT NULL,
  `sem_fee` mediumtext,
  `no_of_seats` int(11) DEFAULT NULL,
  `vacant_seats` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_master`
--

LOCK TABLES `department_master` WRITE;
/*!40000 ALTER TABLE `department_master` DISABLE KEYS */;
INSERT INTO `department_master` VALUES ('Computer Science Engineering','CSE','60000',120,118),('Information Technology','IT','60000',120,119),('Electrical Technology','ET','60000',60,60),('Electronics Engineering','EE','60000',60,60),('Mechanical Engineering','ME','60000',120,117),('Civil Engineering','CE','60000',60000,118);
/*!40000 ALTER TABLE `department_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_data`
--

DROP TABLE IF EXISTS `employee_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_data` (
  `first_name` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `phone_no` char(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `marital_status` varchar(30) DEFAULT NULL,
  `etitle` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `salary` mediumtext,
  `user_id` varchar(50) DEFAULT NULL,
  `password` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_data`
--

LOCK TABLES `employee_data` WRITE;
/*!40000 ALTER TABLE `employee_data` DISABLE KEYS */;
INSERT INTO `employee_data` VALUES ('Suman','','Bala','Jwahar chok','fatehabad','haryana','9050962042','sumanbala@ums.com','1983-02-05 00:00:00','In A Relationship','Faculty','Computer Science Engineering','2017-07-25 00:00:00','50000','sumanbala@ums.com','05/02/1983'),('Deepak','kumar','gakhar','Model Town','Hissar','Haryana','9087654321','deepakgakhar@ums.com','1984-06-06 00:00:00','Married','Faculty','Computer Science Engineering','2017-07-26 00:00:00','40000','deepakgakhar@ums.com','deepakgakhar@123'),('Anil','','Nagpal','Model Town','Fatehabad','Haryana','9087654321','anilnagpal@ums.com','1986-03-06 00:00:00','Married','Faculty','Information Technology','2017-07-27 00:00:00','100000','anilnagpal@ums.com','06/03/1986'),('Sunita','','Grover','MC Colony','Sirsa','Haryana','9087654321','sunitagrover@ums.com','1986-02-07 00:00:00','Single','Faculty','Information Technology','2017-07-28 00:00:00','30000','sunitagrover@ums.com','07/02/1986'),('Balwinder','','Singh','DSP Road','Fatehabad','Haryana','9876543210','balwindersingh@ums.com','1986-06-07 00:00:00','In A Relationship','Accountant','Civil Engineering','2017-07-26 00:00:00','10000','balwindersingh@ums.com','07/06/1986');
/*!40000 ALTER TABLE `employee_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee_detail`
--

DROP TABLE IF EXISTS `fee_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_detail` (
  `roll_no` varchar(50) DEFAULT NULL,
  `balance` mediumtext,
  `deposited_fee` mediumtext,
  `receipt_date` datetime DEFAULT NULL,
  `receipt_no` int(11) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_detail`
--

LOCK TABLES `fee_detail` WRITE;
/*!40000 ALTER TABLE `fee_detail` DISABLE KEYS */;
INSERT INTO `fee_detail` VALUES ('17IT001','0','60000','2017-07-24 00:00:00',1,1),('17CSE001','0','60000','2017-07-24 00:00:00',2,1),('17ME001','50000','10000','2017-07-24 00:00:00',3,1),('17CE001','50000','10000','2017-07-24 00:00:00',4,1),('17CSE002','40000','20000','2017-07-24 00:00:00',5,1),('17ME002','41000','19000','2017-07-25 00:00:00',6,1),('17ME003','50000','10000','2017-07-28 00:00:00',7,1);
/*!40000 ALTER TABLE `fee_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regeneration`
--

DROP TABLE IF EXISTS `regeneration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regeneration` (
  `roll_no` varchar(20) DEFAULT NULL,
  `Re_Gen_Date` datetime DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `sem_fee` mediumtext,
  `session` varchar(20) DEFAULT NULL,
  `stream` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regeneration`
--

LOCK TABLES `regeneration` WRITE;
/*!40000 ALTER TABLE `regeneration` DISABLE KEYS */;
INSERT INTO `regeneration` VALUES ('17CSE001','2017-07-25 00:00:00',2,'60000','-1','Computer Science Engineering');
/*!40000 ALTER TABLE `regeneration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `set_security`
--

DROP TABLE IF EXISTS `set_security`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `set_security` (
  `user_id` varchar(50) DEFAULT NULL,
  `answer1` varchar(50) DEFAULT NULL,
  `answer2` varchar(50) DEFAULT NULL,
  `answer3` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `set_security`
--

LOCK TABLES `set_security` WRITE;
/*!40000 ALTER TABLE `set_security` DISABLE KEYS */;
INSERT INTO `set_security` VALUES ('balwindersingh@ums.com','ludhiana','123456789012','berakoni'),('admin@ums.com','bathinda','012345678912','mdhighschool'),('deepakgakhar@ums.com','BHIRDANA','123456789012','dontknow'),('anilnagpal@ums.com','fatehabad','098765432112','dav'),('sunitagrover@ums.com','bhirdana','123456789012','asdfgh');
/*!40000 ALTER TABLE `set_security` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_data`
--

DROP TABLE IF EXISTS `student_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_data` (
  `first_name` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `father_name` varchar(50) DEFAULT NULL,
  `mother_name` varchar(50) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `gender` char(10) DEFAULT NULL,
  `address_street` varchar(50) DEFAULT NULL,
  `address_city` varchar(50) DEFAULT NULL,
  `address_state` varchar(50) DEFAULT NULL,
  `pin_code` char(10) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `category` char(10) DEFAULT NULL,
  `10th_marks` char(10) DEFAULT NULL,
  `12th_marks` char(10) DEFAULT NULL,
  `previous_school` varchar(50) DEFAULT NULL,
  `admission_number` int(11) DEFAULT NULL,
  `admission_date` datetime DEFAULT NULL,
  `stream` varchar(50) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `roll_no` varchar(20) DEFAULT NULL,
  `per_sem_fee` int(11) DEFAULT NULL,
  `semester` varchar(50) DEFAULT NULL,
  `session` varchar(20) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_data`
--

LOCK TABLES `student_data` WRITE;
/*!40000 ALTER TABLE `student_data` DISABLE KEYS */;
INSERT INTO `student_data` VALUES ('Rohit','Kumar','Bansal','Vijay Bansal','Savita Bansal','1997-09-24 00:00:00','Male','Near PNB Bank','Bhuna','Haryana','125050','9087654321','General','100','75','D.A.V School',1,'2017-07-24 00:00:00','Information Technology','17IT001','24/09/1997','17IT001',60000,'1','2017-2018',''),('Akshat','Kumar','Goyal','Ram kumar','Sita Devi','1998-02-06 00:00:00','Male','MC COlony','Fatehabad','Haryana','125050','9087654321','General','100','89','D.A.V School',2,'2017-07-24 00:00:00','Computer Science Engineering','17CSE001','06/02/1998','17CSE001',60000,'1','2017-2018',''),('Vaibhav','','Juneja','Pawan Juneja','Anju Juneja','1998-10-11 00:00:00','Male','Bhirdana','Fatehabad','Haryan','125050','9087654321','General','100','80','Pioneer Convent School',3,'2017-07-24 00:00:00','Mechanical Engineering','17ME001','11/10/1998','17ME001',60000,'1','2017-2018',''),('Shubham','Kumar','Monga','Ved Monga','Rani Monga','1999-01-28 00:00:00','Male','MC Colony','Fatehabad','Haryana','125050','9416225376','OBC','100','81','Daffodils Public School',4,'2017-07-24 00:00:00','Civil Engineering','17CE001','28/01/1999','17CE001',60000,'1','2017-2018',''),('Mohit','','Sethi','Rohit Sethi','Mata Devi','1998-08-07 00:00:00','Male','Kaint','Panipat','Haryana','123456','9813538484','General','100','100','Dont Know',5,'2017-07-24 00:00:00','Computer Science Engineering','17CSE002','07/08/1998','17CSE002',60000,'1','2017-2018','C:programmingprojectmohit.jpg'),('Rohit','Kumar','Sethi','Vijay Sethi','Bimla devi','2001-03-05 00:00:00','Male','kent','panipat','haryana','123456','9087654321','SC','100','10','poneer school',6,'2017-07-25 00:00:00','Mechanical Engineering','17ME002','05/03/2001','17ME002',60000,'1','2017-2018',''),('Raju','kumar','juneja','ram kumar','seeta devi','1986-03-03 00:00:00','Male','kdhdohoh','guigui','ygyfyg','123456','9876543210','SC','100','100','seniour',7,'2017-07-28 00:00:00','Mechanical Engineering','17ME003','03/03/1986','17ME003',60000,'1','2017-2018','mohit.jpg');
/*!40000 ALTER TABLE `student_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_record`
--

DROP TABLE IF EXISTS `student_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_record` (
  `faculti_id` varchar(100) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `subject_name` varchar(100) DEFAULT NULL,
  `roll_no` varchar(20) DEFAULT NULL,
  `sessional_1_40` double DEFAULT NULL,
  `sessional_2_40` double DEFAULT NULL,
  `internal_20` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_record`
--

LOCK TABLES `student_record` WRITE;
/*!40000 ALTER TABLE `student_record` DISABLE KEYS */;
INSERT INTO `student_record` VALUES ('deepakgakhar@ums.com',2,'C','17CSE001',30,40,10);
/*!40000 ALTER TABLE `student_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_allotment`
--

DROP TABLE IF EXISTS `subject_allotment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_allotment` (
  `faculty_id` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `subject_name` varchar(200) DEFAULT NULL,
  `subject_code` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_allotment`
--

LOCK TABLES `subject_allotment` WRITE;
/*!40000 ALTER TABLE `subject_allotment` DISABLE KEYS */;
INSERT INTO `subject_allotment` VALUES ('sumanbala@ums.com','Computer Science Engineering',1,'Mathematics 1','CSE103'),('sumanbala@ums.com','Computer Science Engineering',1,'Basics Of Et','CSE105'),('deepakgakhar@ums.com','Computer Science Engineering',2,'C','CSE201'),('deepakgakhar@ums.com','Computer Science Engineering',2,'DBMS','CSE205'),('anilnagpal@ums.com','Information Technology',1,' Computer Fundamentals','IT106'),('anilnagpal@ums.com','Information Technology',2,'C','IT201'),('anilnagpal@ums.com','Information Technology',2,'C++','IT202'),('anilnagpal@ums.com','Information Technology',2,'Java','IT203'),('anilnagpal@ums.com','Computer Science Engineering',2,'C','CSE201'),('anilnagpal@ums.com','Computer Science Engineering',2,'C++','CSE202'),('anilnagpal@ums.com','Computer Science Engineering',2,'Java','CSE203'),('sunitagrover@ums.com','Civil Engineering',1,'Manufacturing Process','CE105'),('sunitagrover@ums.com','Civil Engineering',1,'Biotechnology','CE106'),('sunitagrover@ums.com','Mechanical Engineering',2,' Thermodynamics','ME205'),('sunitagrover@ums.com','Mechanical Engineering',2,' Machine Engineering','ME206'),('sumanbala@ums.com','Computer Science Engineering',2,'Java','CSE203'),('sumanbala@ums.com','Computer Science Engineering',2,'DBMS','CSE205');
/*!40000 ALTER TABLE `subject_allotment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_master`
--

DROP TABLE IF EXISTS `subject_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_master` (
  `department_code` varchar(20) DEFAULT NULL,
  `semester` varchar(10) DEFAULT NULL,
  `subject_code` varchar(20) DEFAULT NULL,
  `subject_name` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_master`
--

LOCK TABLES `subject_master` WRITE;
/*!40000 ALTER TABLE `subject_master` DISABLE KEYS */;
INSERT INTO `subject_master` VALUES ('CSE','1st','CSE101','Physics '),('CSE','1st','CSE102','Chemistry'),('CSE','1st','CSE103','Mathematics 1'),('CSE','1st','CSE104','Manufacturing Process'),('CSE','1st','CSE105','Basics Of Et'),('CSE','1st','CSE106','Computer Fundamentals'),('CSE','2nd','CSE201','C'),('CSE','2nd','CSE202','C++'),('CSE','2nd','CSE203','Java'),('CSE','2nd','CSE204','DB'),('CSE','2nd','CSE205','DBMS'),('CSE','2nd','CSE206','null'),('IT','1st','IT101','Physics'),('IT','1st','IT102','Chemistry'),('IT','1st','IT103','Mathematics'),('IT','1st','IT104','Manufacturing Process'),('IT','1st','IT105','Basics Of Et'),('IT','1st','IT106',' Computer Fundamentals'),('IT','2nd','IT201','C'),('IT','2nd','IT202','C++'),('IT','2nd','IT203','Java'),('IT','2nd','IT204','DB'),('IT','2nd','IT205','DBMS'),('IT','2nd','IT206','Mathematics 2'),('ET','1st','ET101','Physics'),('ET','1st','ET102','Chemistry'),('ET','1st','ET103','Mathematics'),('ET','1st','ET104','Manufacturing Process'),('ET','1st','ET105',' Basics Of Mech'),('ET','1st','ET106','Mathematics 1'),('ET','2nd','ET201','ET Fundamentals'),('ET','2nd','ET202',' Mathematics 2'),('ET','2nd','ET203',' Physics 2'),('ET','2nd','ET204','Chemistry 2'),('ET','2nd','ET205',' Electricity  Funda'),('ET','2nd','ET206',' Tower System'),('EE','1st','EE101',' Physics 1'),('EE','1st','EE102','Chemistry 1'),('EE','1st','EE103','Mathematics 1'),('EE','1st','EE104',' Manufacturing Process'),('EE','1st','EE105',' Basics of EE'),('EE','1st','EE106',' Fundamentals'),('EE','2nd','EE201','Basics Of Tower'),('EE','2nd','EE202',' DBMS'),('EE','2nd','EE203','DB'),('EE','2nd','EE204',' Mathematics 2'),('EE','2nd','EE205',' Modern Physics'),('EE','2nd','EE206','Modern Electronics'),('ME','1st','ME101','Physics'),('ME','1st','ME102','Chemistry'),('ME','1st','ME103','Mathematics'),('ME','1st','ME104','Manufacturing Process'),('ME','1st','ME105','Fundamentals'),('ME','1st','ME106',' C '),('ME','2nd','ME201','Physics 2'),('ME','2nd','ME202','Mathematics 2'),('ME','2nd','ME203','Chemistry 2'),('ME','2nd','ME204',' Fundamentals'),('ME','2nd','ME205',' Thermodynamics'),('ME','2nd','ME206',' Machine Engineering'),('CE','1st','CE101','Physics '),('CE','1st','CE102','Chemistry'),('CE','1st','CE103','Mathematics'),('CE','1st','CE104','C'),('CE','1st','CE105','Manufacturing Process'),('CE','1st','CE106','Biotechnology'),('CE','2nd','CE201','Cement Structure'),('CE','2nd','CE202','Building Block'),('CE','2nd','CE203',' Mathematics 2'),('CE','2nd','CE204',' Physics 2'),('CE','2nd','CE205',' Fundamentals Of Civil'),('CE','2nd','CE206',' Building 2');
/*!40000 ALTER TABLE `subject_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-28 17:53:33
