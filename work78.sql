/*
SQLyog Community v9.0 
MySQL - 5.5.19 : Database - work78
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`work78` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `work78`;

/*Table structure for table `bookmark` */

DROP TABLE IF EXISTS `bookmark`;

CREATE TABLE `bookmark` (
  `id` varchar(36) NOT NULL,
  `content` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bookmark` */

insert  into `bookmark`(`id`,`content`) values ('sdfasdf','qq');

/*Table structure for table `bookmark_company` */

DROP TABLE IF EXISTS `bookmark_company`;

CREATE TABLE `bookmark_company` (
  `id` varchar(36) NOT NULL,
  `company_id` varchar(36) NOT NULL,
  `bookmark_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bookmark_company_company1` (`company_id`),
  KEY `fk_bookmark_company_bookmark1` (`bookmark_id`),
  CONSTRAINT `fk_bookmark_company_bookmark1` FOREIGN KEY (`bookmark_id`) REFERENCES `bookmark` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bookmark_company_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bookmark_company` */

insert  into `bookmark_company`(`id`,`company_id`,`bookmark_id`) values ('dgfdhgg','asdfasdfasdf','sdfasdf');

/*Table structure for table `bookmark_contact` */

DROP TABLE IF EXISTS `bookmark_contact`;

CREATE TABLE `bookmark_contact` (
  `id` varchar(36) NOT NULL,
  `contact_id` varchar(36) NOT NULL,
  `bookmark_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bookmark_contact_contact1` (`contact_id`),
  KEY `fk_bookmark_contact_bookmark1` (`bookmark_id`),
  CONSTRAINT `fk_bookmark_contact_bookmark1` FOREIGN KEY (`bookmark_id`) REFERENCES `bookmark` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bookmark_contact_contact1` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bookmark_contact` */

insert  into `bookmark_contact`(`id`,`contact_id`,`bookmark_id`) values ('gsdfhdghfg','asdfasdfa','sdfasdf');

/*Table structure for table `chance` */

DROP TABLE IF EXISTS `chance`;

CREATE TABLE `chance` (
  `id` varchar(36) NOT NULL,
  `name` varchar(45) NOT NULL,
  `info` text,
  `money` double DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  `createtime` varchar(20) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `contact_id` varchar(36) DEFAULT NULL,
  `chance_type` varchar(36) NOT NULL,
  `company_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_chance` (`user_id`),
  KEY `FK_contact` (`contact_id`),
  KEY `FK_chance_type` (`chance_type`),
  KEY `FK_company` (`company_id`),
  CONSTRAINT `FK_chance` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_chance_type` FOREIGN KEY (`chance_type`) REFERENCES `chance_type` (`id`),
  CONSTRAINT `FK_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `FK_contact` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `chance` */

insert  into `chance`(`id`,`name`,`info`,`money`,`status`,`createtime`,`user_id`,`contact_id`,`chance_type`,`company_id`) values ('fa4f2d4f37f4b5eb0137f4b7ce480000','java','android8',200,'成功','2012-06-16 17:55:15','qqqqq',NULL,'asdfasdfasdf',NULL),('fa4f2d4f37f4be110137f4bfe3400000','apple','iso',100,'跟踪','2012-06-16 18:04:05','qqqqq',NULL,'asdfasdfasdf',NULL),('fa4f2d4f37f50d010137f50f953a0000','window phone','microsoft',1000,'跟踪','2012-06-16 19:31:08','qqqqq',NULL,'asdfasdfasdf',NULL),('fa4f2d4f380a4ef801380a50f6c20001','pppppppp','ooooooooo',1000,'跟踪','2012-06-20 22:34:34','qqqqq',NULL,'asdfasdfasdf','asdfasdfasdf'),('fa4f2d4f3814b786013814b7eb400000','hqc','',0,'跟踪','2012-06-22','qqqqq',NULL,'asdfasdfasdf',NULL),('fasdfasdf','moneymmmmmm','就阿斯顿发撒旦发生地方打算放过山东高速梵蒂冈',5000,'跟踪','2012-2-6','wwwwww','asdfasdfa','asdfasdfasdf','asdfasdfasdf');

/*Table structure for table `chance_comment` */

DROP TABLE IF EXISTS `chance_comment`;

CREATE TABLE `chance_comment` (
  `id` varchar(36) NOT NULL,
  `content` text NOT NULL,
  `createtime` varchar(45) NOT NULL,
  `chance_event_id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_chance_comment_chance_event1` (`chance_event_id`),
  KEY `FK_chance_comment` (`user_id`),
  CONSTRAINT `FK_chance_comment` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_chance_comment_chance_event1` FOREIGN KEY (`chance_event_id`) REFERENCES `chance_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `chance_comment` */

insert  into `chance_comment`(`id`,`content`,`createtime`,`chance_event_id`,`user_id`) values ('402880f037fa0e3f0137fa11b1520002','android','2012-06-17 10:51:32','402880f037f984530137f984b0e30000','qqqqq'),('402880f037fa0e3f0137fa15a1030005','javaandroid','2012-06-17 10:55:50','402880f037fa0e3f0137fa15378b0004','qqqqq'),('fa4f2d4f380cce7501380ce1f9470000','请求亲亲亲亲亲亲亲亲','2012-06-21 10:32:12','402880f037fa0e3f0137fa15378b0004','qqqqq'),('fa4f2d4f380cce7501380cfd54250002','qqqqqqqqqq','2012-06-21 11:02:05','fa4f2d4f37fa99250137fa9b9fbf0000','qqqqq');

/*Table structure for table `chance_event` */

DROP TABLE IF EXISTS `chance_event`;

CREATE TABLE `chance_event` (
  `id` varchar(36) NOT NULL,
  `info` text NOT NULL,
  `createtime` varchar(20) NOT NULL,
  `chance_id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_chance_event_chance1` (`chance_id`),
  KEY `FK_chance_event` (`user_id`),
  CONSTRAINT `FK_chance_event` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_chance_event_chance1` FOREIGN KEY (`chance_id`) REFERENCES `chance` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `chance_event` */

insert  into `chance_event`(`id`,`info`,`createtime`,`chance_id`,`user_id`) values ('402880f037f984530137f984b0e30000','fasdfasdfasdfasdfasdf','2012-06-17 08:17:31','fa4f2d4f37f4b5eb0137f4b7ce480000','qqqqq'),('402880f037fa0e3f0137fa15378b0004','hello','2012-06-17 10:55:23','fa4f2d4f37f4b5eb0137f4b7ce480000','qqqqq'),('dfasdfasdgfsdghf','周帅鹏','2012-21-4','fa4f2d4f37f4b5eb0137f4b7ce480000','wwwwww'),('fa4f2d4f37fa99250137fa9b9fbf0000','wwwwwwwww','2012-06-17 21:22:12','fa4f2d4f37f4b5eb0137f4b7ce480000','qqqqq'),('fa4f2d4f37faa8da0137faa9ae320000','just a test!','2012-06-17 21:37:33','fasdfasdf','wwwwww');

/*Table structure for table `chance_extra` */

DROP TABLE IF EXISTS `chance_extra`;

CREATE TABLE `chance_extra` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `chance_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_chance_extra_user1` (`user_id`),
  KEY `fk_chance_extra_chance1` (`chance_id`),
  CONSTRAINT `fk_chance_extra_chance1` FOREIGN KEY (`chance_id`) REFERENCES `chance` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_chance_extra_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `chance_extra` */

insert  into `chance_extra`(`id`,`user_id`,`chance_id`) values ('dsgdsafgsdfg','qqqqq','fasdfasdf'),('fa4f2d4f3814b786013814b7ec0b0002','wwwwww','fa4f2d4f3814b786013814b7eb400000');

/*Table structure for table `chance_type` */

DROP TABLE IF EXISTS `chance_type`;

CREATE TABLE `chance_type` (
  `id` varchar(36) NOT NULL,
  `name` varchar(10) NOT NULL,
  `color` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `chance_type` */

insert  into `chance_type`(`id`,`name`,`color`) values ('asdfasdfasdf','机会Aa','#fff467'),('fa4f2d4f37fe7b230137fe7c8f170000','    机会Cc','    #f00'),('fa4f2d4f38087a4f01380883956a0004','   机会B','   #004a80'),('fa4f2d4f381431830138143325520001',' 机会大大的',' #6ccff7');

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `im` varchar(45) DEFAULT NULL,
  `website` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `weibo` varchar(45) DEFAULT NULL,
  `bg_info` text,
  `user_id` varchar(36) NOT NULL,
  `createtime` varchar(45) NOT NULL,
  `avatar` varchar(45) NOT NULL DEFAULT 'company.png',
  PRIMARY KEY (`id`),
  KEY `fk_company_user1` (`user_id`),
  CONSTRAINT `fk_company_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `company` */

insert  into `company`(`id`,`name`,`phone`,`email`,`im`,`website`,`address`,`weibo`,`bg_info`,`user_id`,`createtime`,`avatar`) values ('agfdsgh\\hdfgh','apple','120',NULL,NULL,NULL,NULL,NULL,NULL,'wwwwww','2012-2-9','company.png'),('asdfasdfasdf','google','110','gmail.com','google+','www.google.com','US','twitter','NASA OK','qqqqq','2010-2-4','company.png'),('fa4f2d4f3814c3b9013814c4ed350000','baidu','','','','','','','','qqqqq','2012-06-22','company.png');

/*Table structure for table `company_comment` */

DROP TABLE IF EXISTS `company_comment`;

CREATE TABLE `company_comment` (
  `id` varchar(36) NOT NULL,
  `content` text NOT NULL,
  `company_event_id` varchar(36) NOT NULL,
  `createtime` varchar(45) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_comment_company_event1` (`company_event_id`),
  KEY `FK_company_comment` (`user_id`),
  CONSTRAINT `FK_company_comment` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_company_comment_company_event1` FOREIGN KEY (`company_event_id`) REFERENCES `company_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `company_comment` */

insert  into `company_comment`(`id`,`content`,`company_event_id`,`createtime`,`user_id`) values ('fa4f2d4f3817267401381727b2430000','hello','fa4f2d4f380a028101380a0b787a0002','2012-06-23','qqqqq');

/*Table structure for table `company_event` */

DROP TABLE IF EXISTS `company_event`;

CREATE TABLE `company_event` (
  `id` varchar(36) NOT NULL,
  `info` text NOT NULL,
  `company_id` varchar(36) NOT NULL,
  `createtime` varchar(45) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_event_company1` (`company_id`),
  KEY `FK_company_event` (`user_id`),
  CONSTRAINT `FK_company_event` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_company_event_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `company_event` */

insert  into `company_event`(`id`,`info`,`company_id`,`createtime`,`user_id`) values ('fa4f2d4f380a028101380a0b787a0002','qqqqqqqqqqqqqqqqwwwwwww','asdfasdfasdf','2012-06-20 21:18:40','qqqqq');

/*Table structure for table `company_extra` */

DROP TABLE IF EXISTS `company_extra`;

CREATE TABLE `company_extra` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `company_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_extra_user1` (`user_id`),
  KEY `fk_company_extra_company1` (`company_id`),
  CONSTRAINT `fk_company_extra_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_company_extra_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `company_extra` */

insert  into `company_extra`(`id`,`user_id`,`company_id`) values ('dfhdfjffh','qqqqq','agfdsgh\\hdfgh'),('fa4f2d4f3814c3b9013814c4edf00002','wwwwww','fa4f2d4f3814c3b9013814c4ed350000');

/*Table structure for table `contact` */

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) NOT NULL,
  `post` varchar(20) DEFAULT NULL,
  `companyname` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `im` varchar(45) DEFAULT NULL,
  `website` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `weibo` varchar(45) DEFAULT NULL,
  `bg_info` text,
  `user_id` varchar(36) NOT NULL,
  `company_id` varchar(36) DEFAULT NULL,
  `createtime` varchar(45) NOT NULL,
  `avatar` varchar(45) NOT NULL DEFAULT 'contact.png',
  PRIMARY KEY (`id`),
  KEY `fk_contact_user1` (`user_id`),
  KEY `fk_contact_company1` (`company_id`),
  CONSTRAINT `FK_companyasdf` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `fk_contact_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contact` */

insert  into `contact`(`id`,`name`,`post`,`companyname`,`phone`,`email`,`im`,`website`,`address`,`weibo`,`bg_info`,`user_id`,`company_id`,`createtime`,`avatar`) values ('asdfasdfa','jobs','CEO','apple','123','twitter','apple+','apple','UK','','','qqqqq','asdfasdfasdf','','contact.png'),('fa4f2d4f38085d1c0138085d5fad0000','rose','coo','android','','','','','','','','qqqqq',NULL,'2012-06-20 13:28:53','contact.png'),('fa4f2d4f380a721c01380a73109e0000','tomsen','abc','wwww','','','','','','','','qqqqq','asdfasdfasdf','2012-06-20 23:11:49','contact.png'),('fa4f2d4f3814629901381464023b0003','bush','COO','','','','','','','','','wwwwww','asdfasdfasdf','2012-06-22','contact.png'),('fa4f2d4f3814c3b9013814c58a4f0003','jerry','','','','','','','','','','wwwwww',NULL,'2012-06-22','contact.png');

/*Table structure for table `contact_comment` */

DROP TABLE IF EXISTS `contact_comment`;

CREATE TABLE `contact_comment` (
  `id` varchar(36) NOT NULL,
  `content` text NOT NULL,
  `contact_event_id` varchar(36) NOT NULL,
  `createtime` varchar(45) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contact_comment_contact_event1` (`contact_event_id`),
  KEY `FK_contact_comment` (`user_id`),
  CONSTRAINT `FK_contact_comment` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_contact_comment_contact_event1` FOREIGN KEY (`contact_event_id`) REFERENCES `contact_event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contact_comment` */

insert  into `contact_comment`(`id`,`content`,`contact_event_id`,`createtime`,`user_id`) values ('402880f03809259a0138092723e60003','afasdf','fa4f2d4f3807c51b013807d9e8e40006','2012-06-20 09:09:16','qqqqq'),('fa4f2d4f3807c51b013807c5559f0000','qqqqqqqqqqqqqqq','fa4f2d4f3804004b01380400ce2c0000','2012-06-20 10:42:49','qqqqq');

/*Table structure for table `contact_event` */

DROP TABLE IF EXISTS `contact_event`;

CREATE TABLE `contact_event` (
  `id` varchar(36) NOT NULL,
  `info` text NOT NULL,
  `contact_id` varchar(36) NOT NULL,
  `createtime` varchar(45) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contact_event_contact1` (`contact_id`),
  KEY `FK_contact_event` (`user_id`),
  CONSTRAINT `FK_contact_event` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_contact_event_contact1` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contact_event` */

insert  into `contact_event`(`id`,`info`,`contact_id`,`createtime`,`user_id`) values ('fa4f2d4f3804004b01380400ce2c0000','yyyyyyyyyyyyyyyyyy','asdfasdfa','2012-06-19 17:09:17','qqqqq'),('fa4f2d4f3807c51b013807d9e8e40006','yttrr','asdfasdfa','2012-06-20 11:05:17','qqqqq'),('fa4f2d4f38087a4f0138087b37a20002','wwwwwwwwwwwww','fa4f2d4f38085d1c0138085d5fad0000','2012-06-20 14:01:29','qqqqq'),('fa4f2d4f3813ed83013813ee10620000','qqqqqqqqqq','asdfasdfa','2012-06-22 19:22:45','qqqqq');

/*Table structure for table `contact_extra` */

DROP TABLE IF EXISTS `contact_extra`;

CREATE TABLE `contact_extra` (
  `id` varchar(36) NOT NULL,
  `contact_id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contact_extra_contact1` (`contact_id`),
  KEY `fk_contact_extra_user1` (`user_id`),
  CONSTRAINT `fk_contact_extra_contact1` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contact_extra_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contact_extra` */

insert  into `contact_extra`(`id`,`contact_id`,`user_id`) values ('ewretryrytte','fa4f2d4f3814629901381464023b0003','qqqqq'),('fa4f2d4f3814c3b9013814c58a7e0005','fa4f2d4f3814c3b9013814c58a4f0003','qqqqq');

/*Table structure for table `group` */

DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
  `id` varchar(36) NOT NULL,
  `colleagueid` varchar(36) NOT NULL,
  `groupname` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_collgue_user2` (`colleagueid`),
  KEY `fk_colleague_user1` (`user_id`),
  CONSTRAINT `fk_colleague_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_collgue_user2` FOREIGN KEY (`colleagueid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `group` */

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` varchar(36) NOT NULL,
  `info` text NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `createtime` varchar(45) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_message_user1` (`user_id`),
  CONSTRAINT `fk_message_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `message` */

insert  into `message`(`id`,`info`,`user_id`,`createtime`,`type`) values ('fa4f2d4f3814629901381464027a0004','tom1为公司google添加了联系人bush','qqqqq','2012-06-22','公司联系人'),('fa4f2d4f38146299013814646ee00006','tom1在公司google上发现了商机huawei','qqqqq','2012-06-22','公司机会'),('fa4f2d4f381462990138146483330007','tom1更改机会huawei的状态为失败','qqqqq','2012-06-22','机会'),('fa4f2d4f3814688a01381468e42c0000','tom修改了个人信息','qqqqq','2012-06-22','个人信息'),('fa4f2d4f3814688a013814691e270001','tom更新了联系人bush','qqqqq','2012-06-22','联系人'),('fa4f2d4f3814a5fc013814abe57e0001','tom添加了机会fgdsg','qqqqq','2012-06-22','机会'),('fa4f2d4f3814b4c4013814b544b90001','tom添加了机会jzz','qqqqq','2012-06-22','机会'),('fa4f2d4f3814b786013814b7ebbd0001','tom添加了机会hqc','qqqqq','2012-06-22','机会'),('fa4f2d4f3814c3b9013814c4ed920001','tom添加了公司baidu','qqqqq','2012-06-22','公司'),('fa4f2d4f3814c3b9013814c58a6f0004','hank添加了联系人jerry','wwwwww','2012-06-22','联系人'),('fa4f2d4f3817241301381724c7ec0001','tom添加了任务jee','qqqqq','2012-06-23','任务'),('fa4f2d4f381724130138172541b00003','tom修改任务java的状态为已完成','qqqqq','2012-06-23','任务'),('fa4f2d4f381724130138172584660004','tom修改任务jee的状态为已完成','qqqqq','2012-06-23','任务'),('fa4f2d4f3817267401381727b2910001','tom为公司事件qqqqqqqqqqqqqqqqwwww...添加了评论','qqqqq','2012-06-23','公司事件评论'),('fa4f2d4f381c2a4101381c2ac29e0000','tom删除了新的任务类型面试','qqqqq','2012-06-24','任务类型'),('fa4f2d4f381c327201381c32a54b0001','tom添加了新的任务类型面试','qqqqq','2012-06-24','任务类型');

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) NOT NULL,
  `deadline` varchar(20) DEFAULT NULL,
  `status` varchar(10) NOT NULL DEFAULT '未完成',
  `createtime` varchar(20) NOT NULL,
  `starttime` varchar(20) DEFAULT NULL,
  `user_id` varchar(36) NOT NULL,
  `task_type_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_task` (`user_id`),
  KEY `FK_task_type` (`task_type_id`),
  CONSTRAINT `FK_task` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_task_type` FOREIGN KEY (`task_type_id`) REFERENCES `task_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `task` */

insert  into `task`(`id`,`name`,`deadline`,`status`,`createtime`,`starttime`,`user_id`,`task_type_id`) values ('eeeee','买坦克','2012-5-6','已完成','2012-6-9','2410-5-9','wwwwww','qqq'),('fa4f2d4f37f35f4a0137f35fbfca0000','eeeeee','2012-06-19','未完成','2012-06-16 11:39:27','2012-06-16','qqqqq','www'),('fa4f2d4f37f362040137f36294c40000','asdfasdfas','2012-8-30','未完成','2012-06-16 11:42:33','2012-7-7','wwwwww','qqq'),('fa4f2d4f3804194a01380421ade40000','android','2012-8-30','已完成','2012-06-19 17:45:12','2012-7-7','qqqqq','www'),('fa4f2d4f3804194a01380421eec60001','java','2012-2-12','未完成','2012-06-19 17:45:29','2012-2-5','qqqqq','qqq'),('fa4f2d4f3817241301381724c7500000','jee','2012-06-25','未完成','2012-06-23','2012-06-24','qqqqq','qqq');

/*Table structure for table `task_extra` */

DROP TABLE IF EXISTS `task_extra`;

CREATE TABLE `task_extra` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `task_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_table1_user1` (`user_id`),
  KEY `fk_task_extra_task1` (`task_id`),
  CONSTRAINT `fk_table1_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_extra_task1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `task_extra` */

insert  into `task_extra`(`id`,`user_id`,`task_id`) values ('fa4f2d4f3817241301381724c7fc0002','wwwwww','fa4f2d4f3817241301381724c7500000');

/*Table structure for table `task_type` */

DROP TABLE IF EXISTS `task_type`;

CREATE TABLE `task_type` (
  `id` varchar(36) NOT NULL,
  `name` varchar(10) NOT NULL,
  `color` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `task_type` */

insert  into `task_type`(`id`,`name`,`color`) values ('fa4f2d4f381c327201381c32a4ce0000','面试','#443206'),('qqq','邮件','#ff7400'),('www','电话','#124523');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `avatar` varchar(45) NOT NULL DEFAULT 'a.png',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`email`,`avatar`) values ('qqqqq','tom','0','126.com','a.png'),('wwwwww','hank','0','163.com','apple.png');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
