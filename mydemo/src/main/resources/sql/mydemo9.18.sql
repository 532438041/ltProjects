/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.26-log : Database - mydemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mydemo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mydemo`;

/*Table structure for table `sc_user` */

DROP TABLE IF EXISTS `sc_user`;

CREATE TABLE `sc_user` (
  `id` varchar(32) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_pwd` varchar(20) DEFAULT NULL,
  `display_name` varchar(50) DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sc_user` */

insert  into `sc_user`(`id`,`user_name`,`user_pwd`,`display_name`,`create_by`,`create_time`,`update_by`,`update_time`) values ('275fb680f9ae4c1692f2ebf15f20abd9','1','1','1',NULL,'2016-09-18 16:33:02',NULL,NULL),('2a879855c47340a8b3fc393d57ec2210','888','888','888',NULL,'2016-09-18 16:32:39',NULL,NULL),('376bd6bb8ee243e182993bff99b81a7a','555','555','555',NULL,'2016-09-18 16:32:22',NULL,NULL),('5fceab59ca2e4e6eb72a8c012cfe6055','2','2','2',NULL,'2016-09-18 16:33:08',NULL,NULL),('79715dfaeefa41ed9339ea73c49c119b','222','222','222',NULL,'2016-09-18 16:32:09',NULL,NULL),('952bad106c074582842e4583197cf987','666','666','666',NULL,'2016-09-18 16:32:28',NULL,NULL),('a3fe8c3cc89e4e9296c417a322bf7915','999','999','999',NULL,'2016-09-18 16:32:44',NULL,NULL),('b6b8c3ff0d4a4ddc901ac8ffce863e2f','333','333','333',NULL,NULL,NULL,'2016-09-18 16:31:42'),('cb199d1bf89b45a992d82894d68dd78c','777','777','777',NULL,'2016-09-18 16:32:34',NULL,NULL),('d4e14be3f6e14d0fba708cec7e05d185','444','444','444',NULL,'2016-09-18 16:32:16',NULL,NULL),('f3fc90372ee846ddb4ef668e071c721c','111','111','111',NULL,'2016-09-18 16:17:38',NULL,NULL);

/*Table structure for table `sc_user_img` */

DROP TABLE IF EXISTS `sc_user_img`;

CREATE TABLE `sc_user_img` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `img_name` varchar(50) DEFAULT NULL,
  `img_url` varchar(500) DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sc_user_img` */

insert  into `sc_user_img`(`id`,`user_id`,`img_name`,`img_url`,`create_by`,`create_time`,`update_by`,`update_time`) values ('2ef627e9c7c54127a151284e53b6cb12','1','10251381214350077.jpg','/static/upload/images/1/2df378b39ad34ccf9bac2193977b7f5b.jpg','1','2016-09-18 17:42:49','1','2016-09-18 17:42:49'),('3304bc6d901d4f42a799ba10eb300933','1','4-140925145F4.jpg','/static/upload/images/1/05ee2a0e78a2499b81288edc75f395eb.jpg','1','2016-09-18 17:07:31','1','2016-09-18 17:07:31'),('394285489c7d44b9b6a6fcc77fd6ec1f','1','4-140925153206.jpg','/static/upload/images/1/d6062b6df701428298079223472812da.jpg','1','2016-09-18 17:22:00','1','2016-09-18 17:22:00'),('3e16831169024b25bcf81e92b8950f15','1','31252352_1392372267018.jpg','/static/upload/images/1/250559b0fb8d4f9e84d60760d71ffc2c.jpg','1','2016-09-18 17:37:48','1','2016-09-18 17:37:48'),('551371aa71d343c4b3040f3dfa1d6259','1','10251381214893821.jpg','/static/upload/images/1/b03e1d3c43f6415ba1679790b149c526.jpg','1','2016-09-18 17:41:27','1','2016-09-18 17:41:27'),('5bfb7df53d2c4020b5cce4fd4b8fa8d0','1','4-140925145F4.jpg','/static/upload/images/1/b9a0642db10d4a07a72bbeeb5c752141.jpg','1','2016-07-08 11:45:44','1','2016-07-08 11:45:44'),('64be1ee7f0cb4ec481fdf63010a6227c','1','10251381214893821.jpg','/static/upload/images/1/0fba9a6ba9c54bdeae47ff9f2b0fec75.jpg','1','2016-09-18 17:40:59','1','2016-09-18 17:40:59'),('6e3255c1db16458eb17682ba4691f70e','1','9.jpg','/static/upload/images/1/6722daceca8b439185a89e767f04a31d.jpg','1','2016-09-18 17:33:25','1','2016-09-18 17:33:25'),('a72b111497344731beff5506e2d0a506','1','4-140925145F4.jpg','/static/upload/images/1/db68a851a04f4dc3bdc9abad0f06615e.jpg','1','2016-06-14 11:22:18','1','2016-06-14 11:22:18'),('a9585d357ad640e8b7af74d3ed546f73','1','4-140925153206.jpg','/static/upload/images/1bee2eef380546d3b249500b35c71342.jpg','1','2016-06-14 11:05:27','1','2016-06-14 11:05:27'),('deee1145403b4f88858672389e449b42','1','37052a70-657f-402c-929f-7c98248ae6e6.jpg','/static/upload/images/1/56d8d73cb1b24e21b86672983aa9afa5.jpg','1','2016-09-18 17:42:55','1','2016-09-18 17:42:55');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
