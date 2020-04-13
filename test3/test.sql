/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.27 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `gradeid` int(5) NOT NULL AUTO_INCREMENT,
  `gradename` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`gradeid`),
  UNIQUE KEY `gradename` (`gradename`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `grade` */

insert  into `grade`(`gradeid`,`gradename`,`address`) values (1,'javaee001','上海'),(2,'javaee002','北京'),(3,'javaee003','上海');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `studentno` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `sex` char(3) NOT NULL,
  `age` int(3) NOT NULL,
  `phone` int(20) NOT NULL,
  `gradeid` int(5) DEFAULT NULL,
  PRIMARY KEY (`studentno`),
  KEY `gradeid` (`gradeid`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`gradeid`) REFERENCES `grade` (`gradeid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`studentno`,`name`,`sex`,`age`,`phone`,`gradeid`) values (1,'小王','男',25,23243243,3),(2,'张三','男',12,34353,2),(3,'书华','女',21,3243535,2),(4,'白灵','女',18,34234,2),(5,'花影','女',23,2345,2),(6,'李四','男',40,12568,3),(7,'柯南','男',34,2322342,2),(8,'小樱','女',45,23243,1),(9,'哪吒','男',12,23423434,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
