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

/*Table structure for table `sc_menu` */

DROP TABLE IF EXISTS `sc_menu`;

CREATE TABLE `sc_menu` (
  `id` char(32) NOT NULL COMMENT '菜单id',
  `menu_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单链接',
  `pid` char(32) DEFAULT NULL COMMENT '上级菜单id',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `state` char(1) DEFAULT NULL COMMENT '状态 0删除 1启用 2禁用',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台系统菜单';

/*Data for the table `sc_menu` */

insert  into `sc_menu`(`id`,`menu_name`,`menu_url`,`pid`,`sort`,`remark`,`state`,`create_by`,`create_time`,`update_by`,`update_time`) values ('1','系统管理','system','0',1,'用户管理','1',NULL,NULL,NULL,NULL),('2','用户列表','userList','1',1,'用户列表','1',NULL,NULL,NULL,NULL),('3','模块列表','menuList','1',2,'模块列表','1',NULL,NULL,NULL,NULL),('4','角色列表','roleList','1',3,'角色列表','1',NULL,NULL,NULL,NULL),('5','系统1','system1','0',2,'系统1 ','1',NULL,NULL,NULL,NULL),('6','系统11','system2','5',1,'系统11','1',NULL,NULL,NULL,NULL);

/*Table structure for table `sc_role` */

DROP TABLE IF EXISTS `sc_role`;

CREATE TABLE `sc_role` (
  `id` char(32) NOT NULL COMMENT '角色id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `state` char(1) DEFAULT NULL COMMENT '状态 0删除 1启用 2禁用',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sc_role` */

insert  into `sc_role`(`id`,`role_name`,`remark`,`state`,`create_by`,`create_time`,`update_by`,`update_time`) values ('1','system','超级管理员','1',NULL,NULL,NULL,NULL),('2','admin','系统管理员','1',NULL,NULL,NULL,NULL);

/*Table structure for table `sc_role_menu` */

DROP TABLE IF EXISTS `sc_role_menu`;

CREATE TABLE `sc_role_menu` (
  `id` char(32) NOT NULL COMMENT '角色-菜单关系表',
  `role_id` char(32) DEFAULT NULL COMMENT '角色Id',
  `menu_id` char(32) DEFAULT NULL COMMENT '菜单Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sc_role_menu';

/*Data for the table `sc_role_menu` */

insert  into `sc_role_menu`(`id`,`role_id`,`menu_id`) values ('1','1','1'),('2','1','2'),('3','1','3'),('4','1','4'),('5','1','5'),('6','1','6');

/*Table structure for table `sc_user` */

DROP TABLE IF EXISTS `sc_user`;

CREATE TABLE `sc_user` (
  `id` char(32) NOT NULL COMMENT '用户Id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `display_name` varchar(255) DEFAULT NULL COMMENT '显示的名称（昵称）',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型 0后台 1前台 ',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `mobile` char(11) DEFAULT NULL COMMENT '手机号码',
  `login_error_count` int(11) DEFAULT NULL COMMENT '登录错误次数',
  `login_ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `state` char(1) DEFAULT NULL COMMENT '状态 0删除 1启用 2禁用',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sc_user` */

insert  into `sc_user`(`id`,`user_name`,`user_pwd`,`display_name`,`user_type`,`email`,`mobile`,`login_error_count`,`login_ip`,`last_login_time`,`state`,`create_by`,`create_time`,`update_by`,`update_time`) values ('1','111','111111','丶小破孩灬','0',NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL);

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

/*Table structure for table `sc_user_role` */

DROP TABLE IF EXISTS `sc_user_role`;

CREATE TABLE `sc_user_role` (
  `id` char(32) NOT NULL COMMENT '用户-角色关系表',
  `user_id` char(32) DEFAULT NULL COMMENT '用户Id',
  `role_id` char(32) DEFAULT NULL COMMENT '角色Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色关系表';

/*Data for the table `sc_user_role` */

insert  into `sc_user_role`(`id`,`user_id`,`role_id`) values ('1','1','1'),('2','1','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
