/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.26-log : Database - tc100
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tc100` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tc100`;

/*Table structure for table `tc_active` */

DROP TABLE IF EXISTS `tc_active`;

CREATE TABLE `tc_active` (
  `id` char(32) NOT NULL COMMENT '同城购',
  `act_name` varchar(50) DEFAULT NULL COMMENT '模板名称',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `card_id` char(32) DEFAULT NULL COMMENT '用户名片id',
  `cate_id` char(32) DEFAULT NULL COMMENT '分类id',
  `act_type` char(10) DEFAULT NULL COMMENT '位置代码',
  `main_pic` varchar(100) DEFAULT NULL COMMENT '同城购主图',
  `summary` varchar(2000) DEFAULT NULL COMMENT '简介',
  `is_init` char(1) DEFAULT NULL COMMENT '是否自动加载首页图片',
  `detail_summary` varchar(2000) DEFAULT NULL COMMENT '详情页简介',
  `detail_content` text COMMENT '详情页内容',
  `state` char(1) DEFAULT NULL COMMENT '状态 0删除 1存在 2发布',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `view_count` int(11) DEFAULT NULL COMMENT '浏览次数',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '剩余金额',
  `region` varchar(1000) DEFAULT NULL COMMENT '提供服务的区域',
  `addName` varchar(1000) DEFAULT NULL COMMENT '消息发布时用户的定位',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城购';

/*Data for the table `tc_active` */

insert  into `tc_active`(`id`,`act_name`,`user_id`,`card_id`,`cate_id`,`act_type`,`main_pic`,`summary`,`is_init`,`detail_summary`,`detail_content`,`state`,`start_time`,`end_time`,`view_count`,`amount`,`region`,`addName`,`create_by`,`create_time`,`update_by`,`update_time`) values ('02ee18f3de0145968efd696a966dced5','','1','1','','E2','','是短发飞','1','','','2','2017-02-09 08:00:00','2017-02-18 08:00:00',NULL,NULL,'撒打发斯蒂芬','太原','','2017-02-17 10:55:41','','2017-02-17 10:55:50'),('039fd0f0784a4c2597acd2eeac49b905','','1',NULL,NULL,'A1',NULL,'','1','12','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:59:19',NULL,'2017-02-10 01:59:19'),('0c3c70d5fef642e1aeca2b925e6797b1','','1',NULL,NULL,'B2',NULL,'12','1','123','','2',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-07 00:43:13',NULL,'2017-02-07 00:43:21'),('0c47922b102c4d93a9d4235d7bad6417','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:53:24',NULL,'2017-02-10 01:53:24'),('1','2','1','1','1','A1','/tcimg/1.jpg','1',NULL,'1',NULL,'2','2017-02-03 11:27:53','2017-02-23 11:28:02',1,NULL,'1','太原',NULL,NULL,NULL,NULL),('1016fe7c440e4bd9a7e95e5b20dbaa76','','1',NULL,NULL,'D1',NULL,'','1','1','','1',NULL,NULL,NULL,NULL,'2','太原',NULL,'2017-02-08 16:33:48',NULL,'2017-02-08 16:33:48'),('150dfb3834054963852081b50020ad49','','1',NULL,NULL,'D1',NULL,'','1','欠我钱','awd','1',NULL,NULL,NULL,NULL,'1','太原',NULL,'2017-02-08 15:16:56',NULL,'2017-02-08 15:16:56'),('157c89c78f4c46d3b646f209ad393fbc','','1',NULL,NULL,'A1',NULL,'','1','12','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:59:18',NULL,'2017-02-10 01:59:18'),('15a6cafbeecf4fbd893aa6d4bf058006','','1',NULL,NULL,'D2','','awd','1','awd','awd','1',NULL,NULL,NULL,NULL,'3','太原',NULL,'2017-02-12 22:12:57',NULL,'2017-02-12 22:12:57'),('1b659062547a46c9af58df0859c34e76','','1',NULL,NULL,'A1',NULL,'','1','1','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-08 10:00:11',NULL,'2017-02-08 10:00:11'),('1cd186fd7abf462cb932d5d1618ce50b','','1',NULL,NULL,'A1',NULL,'','1','12','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 21:13:22',NULL,'2017-02-10 21:13:22'),('1cd1d64b67da438bb8c537d1e347766f','','1',NULL,NULL,'A1',NULL,'','1','12','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-08 10:01:24',NULL,'2017-02-08 10:01:24'),('1e8b6e3afb4844c58368eb827566e11f','','1',NULL,NULL,'A1',NULL,'','1','123123123123','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-05 22:44:43',NULL,'2017-02-05 22:44:43'),('2','2','1','1','1','A1','/tcimg/1.jpg','1',NULL,'1',NULL,'2','2017-02-03 11:27:53','2017-02-23 11:28:02',1,'1.00',NULL,'',NULL,NULL,NULL,NULL),('20c9aaaa2f5e4199a0ca641ace70d725','','1',NULL,NULL,'C2',NULL,'请问','1','我的','','1',NULL,NULL,NULL,NULL,'2','太原',NULL,'2017-02-08 15:37:00',NULL,'2017-02-08 15:37:00'),('22a93c45d5c44d2a8390a61ffa6d9b85','','1',NULL,NULL,'A1',NULL,'','0','123','','1',NULL,NULL,NULL,NULL,'1','太原',NULL,'2017-02-07 16:27:48',NULL,'2017-02-07 16:27:48'),('22efcc5f6dd14cc3bc874da554536c2f','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,'2','太原',NULL,'2017-02-10 01:53:24',NULL,'2017-02-10 01:53:24'),('23c4a4486660495684f468456c1ac3b8','','1',NULL,NULL,'A1',NULL,'','0','123','','1',NULL,NULL,NULL,NULL,'3','太原',NULL,'2017-02-06 00:28:02',NULL,'2017-02-06 00:28:02'),('265d29f213b34a1090317c3e34a20ca8','','1',NULL,NULL,'A1',NULL,'','1','1','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 09:29:45',NULL,'2017-02-06 09:29:45'),('26cae567536148ebad13fed01fafed74','','1',NULL,NULL,'A1',NULL,'',NULL,'1','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-05 22:18:05',NULL,'2017-02-05 22:18:05'),('2a392693d1994411b2104d8d633bdaf0','','1',NULL,NULL,'D1',NULL,'','1','12','','1',NULL,NULL,NULL,NULL,'2','太原',NULL,'2017-02-08 16:29:53',NULL,'2017-02-08 16:29:53'),('2eecfb4b65044cbe9c2a8c1039be096f','','1','1','','B2','','1231231','1','','','2','2017-02-01 08:00:00','2017-02-24 08:00:00',1,NULL,'1','太原','','2017-02-13 17:00:50','','2017-02-13 17:01:00'),('3','2','1','1','1','A1','/tcimg/1.jpg','1',NULL,'1',NULL,'2','2017-02-03 11:27:53','2017-02-23 11:28:02',1,NULL,NULL,'',NULL,NULL,NULL,NULL),('325c580e90a2448782d12087bf0050f7','','1',NULL,NULL,'C2','','12','1','123','123','1',NULL,NULL,NULL,NULL,'1','太原',NULL,'2017-02-12 22:01:47',NULL,'2017-02-12 22:01:47'),('333','D1','1','1','1','D1',NULL,'333',NULL,NULL,NULL,'2','2017-02-15 17:09:45','2017-02-28 17:09:49',NULL,NULL,'小店','太原',NULL,NULL,NULL,NULL),('369c1796f83a41a59deb9de71e8d84af','',NULL,NULL,NULL,'A1',NULL,'','0','12313123123123123','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 00:06:33',NULL,'2017-02-06 00:06:33'),('3e82b2084a5b419caff5c63080e81d64','','1',NULL,NULL,'A1',NULL,'','1','123213','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:52:44',NULL,'2017-02-10 01:52:44'),('3eaea79085e84e47b562ec057a767fb5','','1',NULL,NULL,'A1',NULL,'','0','123','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 00:25:44',NULL,'2017-02-06 00:25:44'),('3f0631f77cf74d9cab397f2a7443da2a','','1','1','','B2','','123','1','','','2','2017-02-01 08:00:00','2017-02-17 08:00:00',1,NULL,NULL,'太原','','2017-02-13 16:59:48','','2017-02-13 17:00:00'),('3f5c0d28d8444929b790502883cf30a7','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:52:53',NULL,'2017-02-10 01:52:53'),('41b9670726b449b28c3a19f2f9332bab','',NULL,NULL,NULL,'A1',NULL,'','0','213123123123','','2',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 00:11:37',NULL,'2017-02-06 00:12:03'),('434353b930d44e34b252af8731216420','','1',NULL,NULL,'A1',NULL,'','1','12','','2',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 09:58:20',NULL,'2017-02-06 09:58:29'),('444','D2','1','1','1','D2',NULL,'日日日',NULL,NULL,NULL,'2','2017-02-15 17:09:45','2017-02-28 17:09:49',NULL,NULL,'迎泽','太原2',NULL,'2017-02-06 17:11:34',NULL,NULL),('48e2ba200d9a457eac0f5008fc72e702','','1','1','','A1','/tcimg/1/6c09c39022bf45b1a8009549ee3ddcab.jpg','','1','123','123123123','2','2017-02-01 08:00:00','2017-02-23 08:00:00',1,NULL,NULL,'',NULL,'2017-02-12 21:56:51',NULL,'2017-02-12 21:59:11'),('4d6a0d2f22ad41bead4c59386152da58','','1',NULL,NULL,'D2',NULL,'12','1','123','','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-08 15:18:00',NULL,'2017-02-08 15:18:00'),('4e841110ef4c4fa6938fec20aa037c4a','','1',NULL,NULL,'D1',NULL,'','1','12313','123','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-08 16:26:04',NULL,'2017-02-08 16:26:04'),('598bc88a9bc345aba014a6ea968c224b','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:53:31',NULL,'2017-02-10 01:53:31'),('5bd726352c6a4845b83a172c456a496c','','1',NULL,NULL,'A1',NULL,'','1','1','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-08 10:00:51',NULL,'2017-02-08 10:00:51'),('5cdb11184642480680c34ccbe5f52dde','','1',NULL,NULL,'D1',NULL,'','1','12313','123','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-08 16:26:35',NULL,'2017-02-08 16:26:35'),('5d755a3d50fd428e8d5814b673006c16','','1',NULL,NULL,'A1',NULL,'','0','1231231312312312','','2',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 00:16:18',NULL,'2017-02-06 00:17:10'),('5dc51f733f814614b854fbf4b1fb7ef9','','1',NULL,NULL,'A1',NULL,'','1','12','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:55:29',NULL,'2017-02-10 01:55:29'),('60054d555e484a2788fba4a84ed2ccf6','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:52:51',NULL,'2017-02-10 01:52:51'),('61dc36df084b4a6e9e30acbdef7eb408','','1',NULL,NULL,'A1',NULL,'','1','12312','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-05 23:33:42',NULL,'2017-02-05 23:33:42'),('69228d5af42840f38c1cba3714b53632','','1','','','B2','','1212','1','21','','1',NULL,NULL,NULL,NULL,NULL,'太原','','2017-02-13 16:30:15','','2017-02-13 16:30:15'),('693244c68c4247f3b7d7e5e016cf0eb8','','1','1','','B2','','sdfasdf','1','','','2',NULL,NULL,NULL,NULL,'sdfasfasdfasdf',NULL,'','2017-02-16 17:21:21','','2017-02-16 17:21:38'),('71f32421c7be4bcc85bd7faf2ba13443','','1',NULL,NULL,'A1',NULL,'','1','123','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 02:01:21',NULL,'2017-02-10 02:01:21'),('725d197cf03c476db4e8fd1fbac57a85','','1',NULL,NULL,'A1',NULL,'','1','12','','2',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 09:58:54',NULL,'2017-02-06 09:59:14'),('752d4f38cfe549df9dbbd9cd4469c971','','1','1','','E1','','','1','','','2','2017-02-17 08:00:00','2017-02-24 08:00:00',NULL,NULL,'E1','太原','','2017-02-17 10:58:53','','2017-02-17 10:59:13'),('775c5d199584488e87f5249f0e2a1014','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:53:48',NULL,'2017-02-10 01:53:48'),('7be7f8af428642bf88af1f6bc98a57f8','','1',NULL,NULL,'A1',NULL,'','1','1','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-08 09:46:38',NULL,'2017-02-08 09:46:38'),('7cfa703c9d024e349ee6cca3705dc8db','','1',NULL,NULL,'B2',NULL,'1','1','1','','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-07 00:38:26',NULL,'2017-02-07 00:38:26'),('7d47723e1ea44b2fb03dac393ae40f8e','','1','1','fbfl1','A1',NULL,'','1','123','','2','2017-02-06 08:00:00','2017-02-16 08:00:00',NULL,NULL,NULL,'',NULL,'2017-02-10 02:47:49',NULL,'2017-02-10 02:48:16'),('7dfd9f2e9dd64319a6fac33b09967679','','1',NULL,NULL,'A1',NULL,'','0','123','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 00:24:33',NULL,'2017-02-06 00:24:33'),('7e2df34c05844c93a1a10812f9c0c12f','','1',NULL,NULL,'A1',NULL,'','1','11','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:54:29',NULL,'2017-02-10 01:54:29'),('7e81bab2bc734073a49512cf3307716c','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:52:54',NULL,'2017-02-10 01:52:54'),('839c16e098154de58193c60468fd3570','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:52:55',NULL,'2017-02-10 01:52:55'),('879cb04d40c7490686705cabd06dbc4d','','1',NULL,NULL,'A1',NULL,'','1','12','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:54:41',NULL,'2017-02-10 01:54:41'),('87ccaf154cb84ff7aac6a2139f485c24','','1','','','B2','','dasfa','1','sdffasfd','adsfafd','1',NULL,NULL,NULL,NULL,NULL,NULL,'','2017-02-16 17:20:19','','2017-02-16 17:20:19'),('8b983bf32e734b05ba20cc94c9a676c8','','1','1','fbfl2','A1',NULL,'','1','21','','2','2017-02-06 08:00:00','2017-02-23 08:00:00',1,NULL,NULL,'',NULL,'2017-02-10 02:48:34',NULL,'2017-02-10 02:48:43'),('8c83682d4ded4d68973644c6ffd3fda5','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:53:22',NULL,'2017-02-10 01:53:22'),('8e1c2490a6d544f39edc6f1cc6d3d776','','1',NULL,NULL,'A1',NULL,'','1','12','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:55:06',NULL,'2017-02-10 01:55:06'),('8ef7a9a0979940cca1a915b8adffb329','','1','1','fbfl1','A1',NULL,'','1','a','','2','2017-02-15 08:00:00','2017-02-23 08:00:00',NULL,NULL,NULL,'',NULL,'2017-02-08 10:14:10',NULL,'2017-02-08 10:14:26'),('8f1c9a87f4c74ca799be6b753c483de7','','1',NULL,NULL,'A1',NULL,'','0','12','','2',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 00:22:24',NULL,'2017-02-06 00:22:39'),('921235c41759469f92697ce10ba5c771','','1',NULL,NULL,'A1',NULL,'','0','324','23132','2',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 00:18:59',NULL,'2017-02-06 00:19:54'),('9f10f73afe4049318a0168a45548626a','',NULL,NULL,NULL,'A1',NULL,'','0','1231313131312312','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 00:07:30',NULL,'2017-02-06 00:07:30'),('9f376d9038594cc6bcaed61ea54ed89a','','1',NULL,NULL,'A1',NULL,'','1','1','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-08 09:47:37',NULL,'2017-02-08 09:47:37'),('a039b22b74714f54a0a4a68f5016d0d1','','1',NULL,NULL,'D1',NULL,'','1','123','','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-08 16:36:24',NULL,'2017-02-08 16:36:24'),('a10e3526ba5a48ca9d2c3ce7c085d65b','','1',NULL,NULL,'D1',NULL,'','1','全额去','','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-08 16:28:31',NULL,'2017-02-08 16:28:31'),('a6d7c69dc94e4413aa5d3d0025250e87','','1',NULL,NULL,'A1',NULL,'','1','12','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:59:10',NULL,'2017-02-10 01:59:10'),('a9bc73188a1341ad8e3ca077630827eb','','1',NULL,NULL,'A1',NULL,'','1','2','','2',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 09:32:40',NULL,'2017-02-06 09:41:32'),('af3e18b0ebae40119d5d3a2842d95e35','','1',NULL,NULL,'A1',NULL,'','1','1','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-08 09:46:55',NULL,'2017-02-08 09:46:55'),('b060845e34374f1bb7746c3141a4514b','','1',NULL,NULL,'A1',NULL,'','1','2','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 09:31:11',NULL,'2017-02-06 09:31:11'),('b2e87f6a396747ad9fae821df33d68e5','','1','1','','B2',NULL,'极差','1','几次\r\n','','2','2017-02-08 08:00:00','2017-02-08 08:00:00',1,NULL,NULL,'太原',NULL,'2017-02-10 02:52:07',NULL,'2017-02-10 02:52:31'),('b454a07b670f4993a8ebb6e66bd6c4ba','','1',NULL,NULL,'D1',NULL,'','1','欠我钱','awd','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-08 15:16:35',NULL,'2017-02-08 15:16:35'),('b4c7d95255f84dd1a3e61c96d0e7f42a','','1',NULL,NULL,'B2',NULL,'1','1','1','','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-07 00:39:01',NULL,'2017-02-07 00:39:01'),('b7cfa16d8405430892349b367ee79954','E1+2','1','1','','E1','','','1','','','2','2017-02-16 08:00:00','2017-02-24 08:00:00',NULL,NULL,'是打发斯蒂芬','太原','','2017-02-17 10:52:11','','2017-02-17 10:52:22'),('bb57fd74ad6a45c1b08af8d460347aaa','',NULL,NULL,NULL,'A1',NULL,'','0','213123123','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 00:09:38',NULL,'2017-02-06 00:09:38'),('bd9a0d5990024ca285eaef29dbbda601','','1',NULL,NULL,'C2','','123','1','123','','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-12 22:14:15',NULL,'2017-02-12 22:14:15'),('be012ba75d2945fea8badf423b238058','','1','1','','C2',NULL,'adw','1','daw','','2','2017-02-16 10:49:10','2017-02-23 10:48:35',NULL,NULL,'小店','太原',NULL,'2017-02-08 16:38:12',NULL,'2017-02-08 16:39:34'),('be5e171d49fc433f906359703eb6e220','','1',NULL,NULL,'A1',NULL,'','1','123213','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:52:48',NULL,'2017-02-10 01:52:48'),('c1c7ec0bcff046079cea2cdcb42bdde9','','1',NULL,NULL,'A1',NULL,'','1','12','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 09:18:06',NULL,'2017-02-06 09:18:06'),('c2b8cb4304fc4ae4983310fa4de2518b','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:53:03',NULL,'2017-02-10 01:53:03'),('c2cc4b5a3a334685a91740d11cbd452c','','1',NULL,NULL,'D1',NULL,'','1','群威群胆','大','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-08 16:16:21',NULL,'2017-02-08 16:16:21'),('c665c35d090b4983a8439555b3dce8a9','','1',NULL,NULL,'C1','/tcimg/1/ba4b51e214d5481d9eef1d3ef9e1b298.jpg','','1','123','12312312313','2','2017-02-08 22:00:32','2017-02-24 22:00:35',NULL,NULL,'尖草坪','太原',NULL,'2017-02-12 21:57:51',NULL,'2017-02-12 21:57:51'),('c7c6b027c7af4c32a06b34aaf13d1754','','1','1','','D2','','123','1','123','123','2','2017-02-01 08:00:00','2017-02-21 08:00:00',NULL,NULL,'万柏林','太原',NULL,'2017-02-12 22:21:26',NULL,'2017-02-12 22:26:01'),('ca035e6186ea4872af79eed050d40223','','1',NULL,NULL,'A1',NULL,'','1','1','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-08 09:58:44',NULL,'2017-02-08 09:58:44'),('cfe0335a740f44319ae7438cc50c7da3','','1','','','B2','','1231231','1','123','123123','1',NULL,NULL,NULL,NULL,NULL,'太原','','2017-02-13 17:00:36','','2017-02-13 17:00:36'),('d119072c1c57472baf52f300562a60c7','','1',NULL,NULL,'A1',NULL,'','0','12312312313123','','2',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 00:18:07',NULL,'2017-02-06 00:18:26'),('d775fdaf20ce43778063de613f4ee25e','','1',NULL,NULL,'A1',NULL,'','0','123','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 00:25:00',NULL,'2017-02-06 00:25:00'),('d7dfca64a3ab44c380da806d76c175dd','','1','1','','','','','','','','2','2017-02-01 08:00:00','2017-02-24 08:00:00',NULL,NULL,NULL,'','','2017-02-13 16:29:11','','2017-02-13 16:30:35'),('d800b94a2e8a4f12be4aace969f4155a','','1',NULL,NULL,'A1',NULL,'','1','12','','2',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-08 10:10:46',NULL,'2017-02-08 10:11:02'),('dd46140122574637865675d6260faebb','','1',NULL,NULL,'A1',NULL,'','1','123','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:59:47',NULL,'2017-02-10 01:59:47'),('e07ba90ad6664858a71a01e13464e26a','','1',NULL,NULL,'C1',NULL,'','1','1231','','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-08 14:42:07',NULL,'2017-02-08 14:42:07'),('e100f67491f24b19bbbdb2ffa0d404a7','','1',NULL,NULL,'C2',NULL,'12','1','12','','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-07 00:46:48',NULL,'2017-02-07 00:46:48'),('e5a7f1cbc32149c79128cd7fafda051f','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:53:24',NULL,'2017-02-10 01:53:24'),('e96df53b4df64d67bc0f12c263ad73ec','','1',NULL,NULL,'C2',NULL,'12','1','123','','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-07 00:45:15',NULL,'2017-02-07 00:45:15'),('ef152f9ec3994f02b739d47cf0f25845','','1',NULL,NULL,'A1',NULL,'','1','123213','123','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 01:52:51',NULL,'2017-02-10 01:52:51'),('f172af71307e4b5cbce7dc5ac9ee61a3','','1',NULL,NULL,'A1',NULL,'','1','123','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 09:18:42',NULL,'2017-02-06 09:18:42'),('f453b62c53c2489380402babc5833634','','1',NULL,NULL,'C1','/tcimg/1/ba4b51e214d5481d9eef1d3ef9e1b298.jpg','','1','123','12312312313','2','2017-02-07 22:00:24','2017-02-23 22:00:29',NULL,NULL,'杏花岭','太原',NULL,'2017-02-12 21:58:38',NULL,'2017-02-12 21:58:38'),('f46982975de142369dbd091d0ca2ee89','','1',NULL,NULL,'B2',NULL,'123','1','123123','123','2','2017-02-06 00:44:23','2017-02-10 00:44:27',NULL,NULL,NULL,'太原',NULL,'2017-02-07 00:43:34',NULL,'2017-02-07 00:43:48'),('f4c0ea70cf244394a74d5d82fdc20773','','1',NULL,NULL,'A1',NULL,'','1','1','','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-08 09:47:27',NULL,'2017-02-08 09:47:27'),('f7b5f9373c984215bced9b7019d2ce7f','','1',NULL,NULL,'A1',NULL,'','0','1','','2',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-06 21:04:22',NULL,'2017-02-06 21:04:29'),('fa7c176ddb5f442c811a4750f68fca99','','1',NULL,NULL,'A1',NULL,'','1','12','12','1',NULL,NULL,NULL,NULL,NULL,'',NULL,'2017-02-10 02:43:04',NULL,'2017-02-10 02:43:04'),('fbea82bf5baa4651a042699edb8b48da','','1','1','','','','','','','','2','2017-02-02 08:00:00','2017-02-16 08:00:00',NULL,NULL,NULL,'','','2017-02-13 16:32:09','','2017-02-13 16:32:25'),('fd5405f1cbab496dba9dc487d22bf93a','','1',NULL,NULL,'D1',NULL,'','1','全额去','','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-08 16:28:18',NULL,'2017-02-08 16:28:18'),('fde837778f434bb4928255a02fd15d6a','','1','1','','','','','','','','2','2017-02-01 08:00:00','2017-02-24 08:00:00',NULL,NULL,NULL,'','','2017-02-13 16:37:47','','2017-02-13 16:38:34'),('fe50896b5d2042148bab2344ffd6839a','','1',NULL,NULL,'B2',NULL,'1','1','1','','1',NULL,NULL,NULL,NULL,NULL,'太原',NULL,'2017-02-07 00:38:45',NULL,'2017-02-07 00:38:45');

/*Table structure for table `tc_active_fee` */

DROP TABLE IF EXISTS `tc_active_fee`;

CREATE TABLE `tc_active_fee` (
  `id` char(32) NOT NULL COMMENT '发布资费',
  `act_type` char(10) DEFAULT NULL COMMENT '位置代码',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '资费',
  `unit` char(10) DEFAULT NULL COMMENT '资费单位 day按天 month按月 year按年 free试用免费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发布资费';

/*Data for the table `tc_active_fee` */

insert  into `tc_active_fee`(`id`,`act_type`,`amount`,`unit`) values ('1','A1','1.00','day'),('2','A2','2.00','year'),('26cf14859dbd4b6fa4ae722e822f041b','B1','19.00','day');

/*Table structure for table `tc_active_item` */

DROP TABLE IF EXISTS `tc_active_item`;

CREATE TABLE `tc_active_item` (
  `id` char(32) NOT NULL COMMENT '同城购商品详情',
  `item_pic` varchar(100) DEFAULT NULL COMMENT '商品图片',
  `list_price` decimal(10,2) DEFAULT NULL COMMENT '原价',
  `list_unit` char(10) DEFAULT NULL COMMENT '单位',
  `spe_price` decimal(10,2) DEFAULT NULL COMMENT '特价',
  `spe_unit` char(10) DEFAULT NULL COMMENT '单位',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `act_id` char(32) DEFAULT NULL COMMENT '模板id',
  `item_name` char(100) DEFAULT NULL COMMENT '品名',
  `cate_id` char(32) DEFAULT NULL COMMENT '商品关联分类id',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城购商品详情';

/*Data for the table `tc_active_item` */

insert  into `tc_active_item`(`id`,`item_pic`,`list_price`,`list_unit`,`spe_price`,`spe_unit`,`start_time`,`end_time`,`remark`,`act_id`,`item_name`,`cate_id`,`create_by`,`create_time`,`update_by`,`update_time`) values ('1','/tcimg/1.jpg','1.00','1','1.00','1',NULL,NULL,NULL,'2',NULL,'1',NULL,'2017-02-08 16:28:42',NULL,NULL),('2','/tcimg/1.jpg','1.00','1','1.00','1',NULL,NULL,NULL,'2',NULL,'1',NULL,'2017-02-08 16:28:42',NULL,NULL),('3','/tcimg/1.jpg','1.00','1','1.00','1',NULL,NULL,NULL,'2',NULL,'2',NULL,'2017-02-08 16:28:42',NULL,NULL),('3e1a4d1c36ee4e95b9cfd261e772602f',NULL,'123.00','123','123.00','123','2017-02-01 08:00:00','2017-02-08 08:00:00','123123123123123','fd5405f1cbab496dba9dc487d22bf93a','123','f1b6d32723b14130bd9aac3a3944c3d5',NULL,'2017-02-08 16:28:42',NULL,'2017-02-08 16:28:42'),('4','/tcimg/1.jpg','1.00','1','1.00','1',NULL,NULL,NULL,'2',NULL,'2',NULL,'2017-02-08 16:28:42',NULL,NULL),('5','/tcimg/1.jpg','1.00','1','1.00','1',NULL,NULL,NULL,'2',NULL,'2',NULL,'2017-02-08 16:28:42',NULL,NULL),('631549fca77d49e8b86a71cce9253222',NULL,NULL,'',NULL,'',NULL,NULL,'','2a392693d1994411b2104d8d633bdaf0','','57460cce0db84e4c97590f9bb632b399',NULL,'2017-02-08 16:31:23',NULL,'2017-02-08 16:31:23'),('80774276ea514699a088209921c8b313',NULL,'123.00','123','123.00','123','2017-10-08 08:00:00','2017-02-07 08:00:00','123','be012ba75d2945fea8badf423b238058','123','ea03d9c4d64c4358a3f38d423fb6f244',NULL,'2017-02-08 16:38:39',NULL,'2017-02-08 16:38:39'),('8afebd8bc7ca4d998c6c1de6ee1c89a8','/tcimg/1/7fbaf56cd7334c2bbfa3fb9c438e188c.jpg','123.00','123','123.00','123','2017-02-01 08:00:00','2017-02-17 08:00:00','','c665c35d090b4983a8439555b3dce8a9','123','cce3065b3726449eae66f30b2317cd53',NULL,'2017-02-12 21:58:22',NULL,'2017-02-12 21:58:22'),('b9d3f4791dbb4faba1374216e1f7dfed',NULL,'123.00','123','123.00','123','2017-10-08 08:00:00','2017-02-07 08:00:00','123','be012ba75d2945fea8badf423b238058','123','ea03d9c4d64c4358a3f38d423fb6f244',NULL,'2017-02-08 16:39:19',NULL,'2017-02-08 16:39:19'),('cc6d1b7e365649839c22119b4c91d9a2',NULL,'123.00','123','123.00','123','2017-02-01 08:00:00','2017-02-08 08:00:00','123123123123123','fd5405f1cbab496dba9dc487d22bf93a','123','f1b6d32723b14130bd9aac3a3944c3d5',NULL,'2017-02-08 16:28:58',NULL,'2017-02-08 16:28:58'),('dd5b5d4efafb4fa2a5d68e794acbdded','','123.00','1','123.00','1','2017-02-07 08:00:00','2017-02-17 08:00:00','','c7c6b027c7af4c32a06b34aaf13d1754','123','f9c6d7d186644bf7a31da01164ea7db6',NULL,'2017-02-12 22:25:47',NULL,'2017-02-12 22:25:47'),('e2e791d2e2434654bed325bf8872af8c','/tcimg/1/e1fe19d5c5de403cbf72a543f9a11d35.jpg','123.00','',NULL,'','2017-02-01 08:00:00','2017-02-17 08:00:00','','f453b62c53c2489380402babc5833634','12312312','8554bebbf550495d9b77bea969e0e60a',NULL,'2017-02-12 21:58:55',NULL,'2017-02-12 21:58:55');

/*Table structure for table `tc_active_log` */

DROP TABLE IF EXISTS `tc_active_log`;

CREATE TABLE `tc_active_log` (
  `id` char(32) NOT NULL COMMENT '同城购操作日志',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `content` varchar(500) DEFAULT NULL COMMENT '操作内容',
  `act_id` char(32) DEFAULT NULL COMMENT '活动id',
  `from_act_id` char(1) DEFAULT NULL COMMENT '推送原actId',
  `log_type` char(1) DEFAULT NULL COMMENT '操作日志类型 0 浏览 1关注 2分享 3重复 4水贴 5推送 6推广',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城购操作日志';

/*Data for the table `tc_active_log` */

insert  into `tc_active_log`(`id`,`user_id`,`content`,`act_id`,`from_act_id`,`log_type`,`create_by`,`create_time`,`update_by`,`update_time`) values ('0d72a51bf69b4c3d9fbebd92ab561102','1','关注','2',NULL,'1',NULL,'2017-02-07 16:39:07',NULL,NULL),('20f08dcebd37439aa329fc094a994e2b','1','浏览','1',NULL,'0',NULL,'2017-02-16 17:24:25',NULL,NULL),('2c30cf04b0a7443e8eef578f4a474b93','1','重复','2',NULL,'3',NULL,'2017-02-07 16:41:13',NULL,NULL),('3a9f8fa591b94d9294eaed369f1655b5','null','浏览','true',NULL,'0',NULL,'2017-02-08 15:36:18',NULL,NULL),('58f0a6cebda446b58d364d63ace94f46','1','浏览','48e2ba200d9a457eac0f5008fc72e702',NULL,'0',NULL,'2017-02-12 22:48:38',NULL,NULL),('82fb391293a542028a1758f43335b8e4','1','浏览','8b983bf32e734b05ba20cc94c9a676c8',NULL,'0',NULL,'2017-02-13 10:41:16',NULL,NULL),('8b32c290695f4501a7998e9f1ef0c26d','1','分享','2',NULL,'2',NULL,'2017-02-07 16:40:25',NULL,NULL),('91591b1f7f674cdfb9d86edd8c884923','1','水贴','2',NULL,'4',NULL,'2017-02-07 16:41:18',NULL,NULL),('9f32eedd69a94a7cba4ad3c2af54a161','1','浏览','2',NULL,'0',NULL,'2017-02-07 16:38:34',NULL,NULL),('bb56621213554ff2a4f0508124cd83f7','1','关注','b2e87f6a396747ad9fae821df33d68e5',NULL,'1',NULL,'2017-02-10 02:52:49',NULL,NULL),('ea5853cadf8a4be58cbec99f27156618','1','浏览','2eecfb4b65044cbe9c2a8c1039be096f',NULL,'0',NULL,'2017-02-13 17:01:41',NULL,NULL),('eee7e587cdd942bfb7872b4a68a030fe','1','浏览','3f0631f77cf74d9cab397f2a7443da2a',NULL,'0',NULL,'2017-02-13 17:01:46',NULL,NULL),('f26f19ac1ad341a481ef722e11989e1b','1','浏览','3',NULL,'0',NULL,'2017-02-07 16:38:47',NULL,NULL),('f3f52d9f51054afbb6d8f1df67a9ec41','1','浏览','b2e87f6a396747ad9fae821df33d68e5',NULL,'0',NULL,'2017-02-10 02:52:43',NULL,NULL);

/*Table structure for table `tc_category` */

DROP TABLE IF EXISTS `tc_category`;

CREATE TABLE `tc_category` (
  `id` char(32) NOT NULL COMMENT '分类id',
  `cate_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `pid` char(32) DEFAULT NULL COMMENT '父id',
  `pids` char(100) DEFAULT NULL COMMENT '父id集合 层级 “,”分割',
  `cate_level` int(11) DEFAULT '0' COMMENT '第几层级',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `state` char(1) DEFAULT NULL COMMENT '状态 0删除 1启用 2禁用',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章分类';

/*Data for the table `tc_category` */

insert  into `tc_category`(`id`,`cate_name`,`pid`,`pids`,`cate_level`,`sort`,`remark`,`state`,`create_by`,`create_time`,`update_by`,`update_time`) values ('2799c7efdbf14a358a0fe8a4974c3e7c','婴孕','0','0',1,2,'婴孕','1','1','2017-01-21 23:54:24','1','2017-01-21 23:54:24'),('50b5bdce2be6474fa6af8c45c0100d40','房产','0','0',1,4,'房产','1','1','2017-01-21 23:54:39','1','2017-01-21 23:54:39'),('68f46b5471284a6493a804ec01a13fce','12','0','0',1,5,'123','0',NULL,'2017-02-15 16:21:53',NULL,'2017-02-15 16:21:58'),('e2646bdb82084f9ba45bdd1caee3d5c2','车辆','0','0',1,3,'车辆','1','1','2017-01-21 23:54:33','1','2017-01-21 23:54:33'),('e491125b2f8941f186c1d01d32c86800','超市','0','0',1,1,'超市','1','1','2017-01-21 23:53:55','1','2017-01-21 23:53:55'),('fbfl1','服装','1','1',2,1,NULL,'1','1',NULL,NULL,NULL),('fbfl2','金银','1','1',2,2,NULL,'1','1',NULL,NULL,NULL);

/*Table structure for table `tc_item_cate` */

DROP TABLE IF EXISTS `tc_item_cate`;

CREATE TABLE `tc_item_cate` (
  `id` char(32) NOT NULL COMMENT '同城购商品关联分类',
  `cate_name` varchar(100) DEFAULT NULL COMMENT '分类名称',
  `act_id` char(32) DEFAULT NULL COMMENT '模板id',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城购商品关联分类';

/*Data for the table `tc_item_cate` */

insert  into `tc_item_cate`(`id`,`cate_name`,`act_id`,`create_by`,`create_time`,`update_by`,`update_time`) values ('07abb70a15ae466aa3eb771e58b30a9d',NULL,'4e841110ef4c4fa6938fec20aa037c4a',NULL,'2017-02-08 16:26:44',NULL,'2017-02-08 16:26:44'),('1','分类1','2',NULL,NULL,NULL,NULL),('18632b5943864c87aa2a8ce44b3ff71f',NULL,'4e841110ef4c4fa6938fec20aa037c4a',NULL,'2017-02-08 16:26:37',NULL,'2017-02-08 16:26:37'),('2','分类2','2',NULL,NULL,NULL,NULL),('2be55264dff241db8b230ddfb4cb369a','åç±»','325c580e90a2448782d12087bf0050f7',NULL,'2017-02-12 22:08:51',NULL,'2017-02-12 22:08:51'),('47cce2f29732496fb4cf32af0f712b5a',NULL,'4e841110ef4c4fa6938fec20aa037c4a',NULL,'2017-02-08 16:26:13',NULL,'2017-02-08 16:26:13'),('57460cce0db84e4c97590f9bb632b399',NULL,'2a392693d1994411b2104d8d633bdaf0',NULL,'2017-02-08 16:29:59',NULL,'2017-02-08 16:29:59'),('63f9abc6653d4a669544a2691730f009',NULL,'fd5405f1cbab496dba9dc487d22bf93a',NULL,'2017-02-08 16:28:33',NULL,'2017-02-08 16:28:33'),('7e4e3707d4a84840b770ce73bb88822b',NULL,NULL,NULL,'2017-02-08 16:34:26',NULL,'2017-02-08 16:34:26'),('8554bebbf550495d9b77bea969e0e60a','å ','f453b62c53c2489380402babc5833634',NULL,'2017-02-12 21:58:44',NULL,'2017-02-12 21:58:44'),('8fb3bbfc657048aa9934f773eafb7156',NULL,NULL,NULL,'2017-02-12 22:13:04',NULL,'2017-02-12 22:13:04'),('912cfa1bfd6343a19499ad751aadb023',NULL,'2a392693d1994411b2104d8d633bdaf0',NULL,'2017-02-08 16:33:07',NULL,'2017-02-08 16:32:56'),('96ad94e4751d4327b330f58efd5d5577','åç±»2222222222','c7c6b027c7af4c32a06b34aaf13d1754',NULL,'2017-02-12 22:21:31',NULL,'2017-02-12 22:21:31'),('ab85a3e1c90442f089a1bbd805903b15',NULL,'c2cc4b5a3a334685a91740d11cbd452c',NULL,'2017-02-08 16:16:33',NULL,'2017-02-08 16:16:33'),('cce3065b3726449eae66f30b2317cd53','åç±»1','c665c35d090b4983a8439555b3dce8a9',NULL,'2017-02-12 21:57:59',NULL,'2017-02-12 21:57:59'),('d242553d64284f9ea6c577ffb7c0e611','åç±»','325c580e90a2448782d12087bf0050f7',NULL,'2017-02-12 22:02:02',NULL,'2017-02-12 22:02:02'),('ea03d9c4d64c4358a3f38d423fb6f244','dwawad','be012ba75d2945fea8badf423b238058',NULL,'2017-02-08 16:38:27',NULL,'2017-02-08 16:38:27'),('f1b6d32723b14130bd9aac3a3944c3d5',NULL,'fd5405f1cbab496dba9dc487d22bf93a',NULL,'2017-02-08 16:28:21',NULL,'2017-02-08 16:28:21'),('f9c6d7d186644bf7a31da01164ea7db6','分类2222222222','c7c6b027c7af4c32a06b34aaf13d1754',NULL,'2017-02-12 22:25:23',NULL,'2017-02-12 22:25:23');

/*Table structure for table `tc_log` */

DROP TABLE IF EXISTS `tc_log`;

CREATE TABLE `tc_log` (
  `id` char(32) NOT NULL,
  `details` text COMMENT '日志内容描述',
  `method` varchar(500) DEFAULT NULL COMMENT '操作的方法名称、 增、 删、 改',
  `log_type` char(2) DEFAULT NULL COMMENT '日志类型',
  `req_ip` varchar(255) DEFAULT NULL COMMENT '操作ip',
  `ex_code` varchar(500) DEFAULT NULL COMMENT '异常编码',
  `ex_detail` text COMMENT '异常内容描述',
  `params` text COMMENT '请求参数',
  `create_by` char(32) DEFAULT NULL COMMENT '日志创建者',
  `create_time` datetime DEFAULT NULL COMMENT '日志创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志';

/*Data for the table `tc_log` */

insert  into `tc_log`(`id`,`details`,`method`,`log_type`,`req_ip`,`ex_code`,`ex_detail`,`params`,`create_by`,`create_time`) values ('0dc0dc2061c34bf8be89dcb08dece63b','后台用户登录','com.java.controller.LoginController.AdminLogin().select','01','127.0.0.1','java.lang.NullPointerException',NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','','2017-02-15 16:07:06'),('10064103e3bc413a844220f3e22b72ec','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"admin\",\"userPwd\":\"111111\"}};','2','2017-02-17 10:59:42'),('1100f820cdd04e6c9f573a3d3af5a719','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','','2017-02-15 16:07:14'),('1531d6eae57744249d2fd67f00011ab2','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','2','2017-02-15 16:16:50'),('161d6d6a33f5457d8124fc9db9846eac','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','0:0:0:0:0:0:0:1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"22\",\"userPwd\":\"111111\"}};','','2017-02-16 11:03:50'),('20a7361f696646979df50f9550e333ee','后台用户登录','com.java.controller.LoginController.AdminLogin().select','01','127.0.0.1','java.lang.NullPointerException',NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','','2017-02-15 16:07:14'),('21b0f7088fa34598a5488ffa03c09b02','后台用户退出','com.java.controller.LoginController.adminLogout().select','00','127.0.0.1',NULL,NULL,'\"2\";\"丶小破孩灬\";','2','2017-02-15 16:16:45'),('233d35d0e02b4bc1b4fedfbec73d0d15','删除模块','com.java.controller.MenuController.deleteMenu().delete','00','127.0.0.1',NULL,NULL,'\"0924989c3044445aa131517f352a1010\";\"2\";','2','2017-02-17 10:58:31'),('25045610988646b8b8711b4445513d85','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','0:0:0:0:0:0:0:1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','','2017-02-16 11:03:53'),('2c727921bffb4c6cb75164c1b28ef351','后台用户登录','com.java.controller.LoginController.AdminLogin().select','01','127.0.0.1','java.lang.NullPointerException',NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','','2017-02-15 16:08:44'),('370a3e0e7a00486182cef26303c1de62','删除模块','com.java.controller.MenuController.deleteMenu().delete','00','127.0.0.1',NULL,NULL,'\"e7a285db815549be91b4048d703b7775\";\"2\";','2','2017-02-17 10:54:45'),('378bce9cb50c4172b359b98be877288b','添加、编辑模块','com.java.controller.MenuController.saveMenu().add/update','00','0:0:0:0:0:0:0:1',NULL,NULL,'{\"param\":{\"createBy\":\"2\",\"createTime\":1487223585139,\"id\":\"dc0229f0ccef44f9a7c653fb602e40b1\",\"menuName\":\"帖子奖惩\",\"menuUrl\":\"operateFeeList\",\"pid\":\"f777156c1939456f94d13a7c230ad8b7\",\"sort\":7,\"state\":\"1\",\"updateBy\":\"2\",\"updateTime\":1487223585139}};\"2\";','2','2017-02-16 13:39:45'),('3b65e3be522d40caa57d14cd94f3283f','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','2','2017-02-15 16:16:38'),('4ad75d9070d845ee918540046dddc07c','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','0:0:0:0:0:0:0:1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','','2017-02-16 15:49:43'),('588c6001564d405abba5cb2de538e9bd','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','0:0:0:0:0:0:0:1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','2','2017-02-16 15:41:30'),('5930f8f0a1b24829beec50e22a6c11c1','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','','2017-02-15 16:08:44'),('6048edc90e204cd8a24b6ef28fa66e8c','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','2','2017-02-15 16:11:39'),('727e0ba0a0f74ca49c052b8cf9674565','后台用户退出','com.java.controller.LoginController.adminLogout().select','00','127.0.0.1',NULL,NULL,'\"2\";\"丶小破孩灬\";','2','2017-02-17 10:59:36'),('7379a776bc424ed5acb12c906855f5b2','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"111\",\"userPwd\":\"111111\"}};','','2017-02-15 16:08:39'),('762f6d8776c243c7b7cb7b90f108ba57','添加、编辑模块','com.java.controller.MenuController.saveMenu().add/update','00','0:0:0:0:0:0:0:1',NULL,NULL,'{\"param\":{\"createBy\":\"2\",\"createTime\":1487223528817,\"id\":\"dd0e2afec92045f894f667c620eb46ac\",\"menuName\":\"发布资费\",\"menuUrl\":\"activeFeeList\",\"pid\":\"f777156c1939456f94d13a7c230ad8b7\",\"sort\":6,\"state\":\"1\",\"updateBy\":\"2\",\"updateTime\":1487223528817}};\"2\";','2','2017-02-16 13:38:49'),('774c9802cb314e98956f8b4881d48e31','添加、编辑模块','com.java.controller.MenuController.saveMenu().add/update','00','0:0:0:0:0:0:0:1',NULL,NULL,'{\"param\":{\"createBy\":\"2\",\"createTime\":1487214612037,\"id\":\"9ab8fed0ce054c72a60e719703b18b3f\",\"menuName\":\"系统参数\",\"menuUrl\":\"5\",\"pid\":\"f777156c1939456f94d13a7c230ad8b7\",\"sort\":5,\"state\":\"1\",\"updateBy\":\"2\",\"updateTime\":1487214612036}};\"2\";','2','2017-02-16 11:10:12'),('7e4b4bda38bf43c592da001d1bb425fd','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','','2017-02-15 16:10:13'),('8a03979802e94139a406113be0bbab6f','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"111\",\"userPwd\":\"111111\"}};','','2017-02-15 16:04:16'),('8f0ed1ee18a7436f8174298300035d36','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','','2017-02-15 16:07:05'),('929b57ae5acb4fc4be3b609998b20437','添加、编辑模块','com.java.controller.MenuController.saveMenu().add/update','00','0:0:0:0:0:0:0:1',NULL,NULL,'{\"param\":{\"id\":\"9ab8fed0ce054c72a60e719703b18b3f\",\"menuName\":\"系统参数\",\"menuUrl\":\"sysParamList\",\"updateBy\":\"2\",\"updateTime\":1487214627085}};\"2\";','2','2017-02-16 11:10:27'),('a469a3ab3f0e49bdb0ed73091cad48c1','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','2','2017-02-16 13:30:28'),('add7004749454fbba0baa03a5731e877','后台用户退出','com.java.controller.LoginController.adminLogout().select','00','0:0:0:0:0:0:0:1',NULL,NULL,'\"2\";\"丶小破孩灬\";','2','2017-02-16 15:41:24'),('b9982302d7ea4313ab13730ccb943524','后台用户退出','com.java.controller.LoginController.adminLogout().select','00','127.0.0.1',NULL,NULL,'\"2\";\"丶小破孩灬\";','2','2017-02-15 16:16:33'),('bb84654a9dee428cacc4f6e7a36891b7','后台用户退出','com.java.controller.LoginController.adminLogout().select','00','127.0.0.1',NULL,NULL,'\"2\";\"丶小破孩灬\";','2','2017-02-15 16:46:48'),('d8259ce12a4245f5a8234d4ba86bcbc6','删除模块','com.java.controller.MenuController.deleteMenu().delete','00','127.0.0.1',NULL,NULL,'\"3ccd7c33e51448e3adf5d0a712ab2690\";\"2\";','2','2017-02-17 10:54:38'),('e3871dacf52647ef8f69fd0518193ac7','后台用户登录','com.java.controller.LoginController.AdminLogin().select','00','127.0.0.1',NULL,NULL,'{\"param\":{\"displayName\":\"\",\"id\":\"\",\"userName\":\"222\",\"userPwd\":\"111111\"}};','2','2017-02-15 16:11:17');

/*Table structure for table `tc_menu` */

DROP TABLE IF EXISTS `tc_menu`;

CREATE TABLE `tc_menu` (
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

/*Data for the table `tc_menu` */

insert  into `tc_menu`(`id`,`menu_name`,`menu_url`,`pid`,`sort`,`remark`,`state`,`create_by`,`create_time`,`update_by`,`update_time`) values ('0924989c3044445aa131517f352a1010','系统日志','logList','f777156c1939456f94d13a7c230ad8b7',4,NULL,'0','1','2017-01-04 15:46:55','2','2017-02-17 10:58:31'),('9ab8fed0ce054c72a60e719703b18b3f','系统参数','sysParamList','f777156c1939456f94d13a7c230ad8b7',5,NULL,'1','2','2017-02-16 11:10:12','2','2017-02-16 11:10:27'),('d7ecd96d0b65483fbda05b332778f459','分类管理','cateList','f777156c1939456f94d13a7c230ad8b7',1,NULL,'1','1','2017-01-05 16:34:41','1','2017-01-05 17:38:25'),('dc0229f0ccef44f9a7c653fb602e40b1','帖子奖惩','operateFeeList','f777156c1939456f94d13a7c230ad8b7',7,NULL,'1','2','2017-02-16 13:39:45','2','2017-02-16 13:39:45'),('dd0e2afec92045f894f667c620eb46ac','发布资费','activeFeeList','f777156c1939456f94d13a7c230ad8b7',6,NULL,'1','2','2017-02-16 13:38:49','2','2017-02-16 13:38:49'),('f777156c1939456f94d13a7c230ad8b2','用户列表','userList','f777156c1939456f94d13a7c230ad8b7',1,NULL,'1',NULL,NULL,'1','2017-01-03 13:19:53'),('f777156c1939456f94d13a7c230ad8b3','模块列表','menuList','f777156c1939456f94d13a7c230ad8b7',2,'模块列表','1',NULL,NULL,NULL,NULL),('f777156c1939456f94d13a7c230ad8b4','角色列表','roleList','f777156c1939456f94d13a7c230ad8b7',3,NULL,'0',NULL,NULL,'1','2017-01-03 13:14:05'),('f777156c1939456f94d13a7c230ad8b7','系统管理','system','0',1,'用户管理','1',NULL,NULL,NULL,NULL);

/*Table structure for table `tc_message` */

DROP TABLE IF EXISTS `tc_message`;

CREATE TABLE `tc_message` (
  `id` char(32) NOT NULL COMMENT '同城购',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `card_id` char(32) DEFAULT NULL COMMENT '用户名片id',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `remark` varchar(2000) DEFAULT NULL COMMENT '内容',
  `region` varchar(1000) DEFAULT NULL COMMENT '提供服务的区域',
  `addName` varchar(1000) DEFAULT NULL COMMENT '消息发布时用户的定位',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城搜';

/*Data for the table `tc_message` */

insert  into `tc_message`(`id`,`user_id`,`card_id`,`title`,`remark`,`region`,`addName`,`create_by`,`create_time`,`update_by`,`update_time`) values ('1','1',NULL,'1','1','1','太原','1','2017-01-22 20:38:07','1','2017-01-22 20:38:10'),('2','1',NULL,'2','2','2','','2','2017-01-25 20:38:15','2','2017-01-25 20:38:19');

/*Table structure for table `tc_message_review` */

DROP TABLE IF EXISTS `tc_message_review`;

CREATE TABLE `tc_message_review` (
  `id` char(32) NOT NULL COMMENT '同城购',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `card_id` char(32) DEFAULT NULL COMMENT '用户名片id',
  `msg_id` varchar(100) DEFAULT NULL COMMENT '同城搜id',
  `remark` varchar(2000) DEFAULT NULL COMMENT '内容',
  `msg_pic` varchar(100) DEFAULT NULL COMMENT '回复图片',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城搜回复';

/*Data for the table `tc_message_review` */

insert  into `tc_message_review`(`id`,`user_id`,`card_id`,`msg_id`,`remark`,`msg_pic`,`create_by`,`create_time`,`update_by`,`update_time`) values ('1','1',NULL,'1','1',NULL,NULL,NULL,NULL,NULL),('2','2',NULL,'1','2','2',NULL,NULL,NULL,NULL),('3','1',NULL,'1','2','3',NULL,NULL,NULL,NULL),('4','1',NULL,'2','2','2',NULL,NULL,NULL,NULL);

/*Table structure for table `tc_operate_fee` */

DROP TABLE IF EXISTS `tc_operate_fee`;

CREATE TABLE `tc_operate_fee` (
  `id` char(32) NOT NULL COMMENT '帖子奖惩',
  `log_type` char(10) DEFAULT NULL COMMENT '操作类型 2分享 3重复 4水贴',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '奖惩',
  `remark` varchar(500) DEFAULT NULL COMMENT '封顶备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子奖惩';

/*Data for the table `tc_operate_fee` */

insert  into `tc_operate_fee`(`id`,`log_type`,`amount`,`remark`) values ('7a263c7ac5f64c069454e35f6c127665','4','24.00','sdfasdf'),('94ce9309c8aa4d239a1ec344390982d7','2','2.00','ddd'),('e0c6bbfb9e9f4d3f935d427304c7b862','3','-3.00','sdfsdfsadf');

/*Table structure for table `tc_pay_log` */

DROP TABLE IF EXISTS `tc_pay_log`;

CREATE TABLE `tc_pay_log` (
  `id` char(32) NOT NULL COMMENT '同城购缴费记录',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息 推广或者广告缴费',
  `act_id` char(32) DEFAULT NULL COMMENT '模板id',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '缴费金额',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城购缴费记录';

/*Data for the table `tc_pay_log` */

/*Table structure for table `tc_role` */

DROP TABLE IF EXISTS `tc_role`;

CREATE TABLE `tc_role` (
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

/*Data for the table `tc_role` */

insert  into `tc_role`(`id`,`role_name`,`remark`,`state`,`create_by`,`create_time`,`update_by`,`update_time`) values ('1','system','超级管理员','1',NULL,NULL,NULL,NULL),('2','admin','系统管理员','1',NULL,NULL,NULL,NULL);

/*Table structure for table `tc_role_menu` */

DROP TABLE IF EXISTS `tc_role_menu`;

CREATE TABLE `tc_role_menu` (
  `id` char(32) NOT NULL COMMENT '角色-菜单关系表',
  `role_id` char(32) DEFAULT NULL COMMENT '角色Id',
  `menu_id` char(32) DEFAULT NULL COMMENT '菜单Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sc_role_menu';

/*Data for the table `tc_role_menu` */

insert  into `tc_role_menu`(`id`,`role_id`,`menu_id`) values ('1','1','1'),('2','1','2'),('3','1','3'),('4','1','4'),('5','1','5'),('6','1','6');

/*Table structure for table `tc_sys_param` */

DROP TABLE IF EXISTS `tc_sys_param`;

CREATE TABLE `tc_sys_param` (
  `id` char(32) NOT NULL COMMENT '系统参数',
  `p_name` varchar(50) DEFAULT NULL COMMENT '参数名称',
  `p_key` varchar(50) DEFAULT NULL COMMENT '参数标识',
  `p_value` varchar(2000) DEFAULT NULL COMMENT '参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数';

/*Data for the table `tc_sys_param` */

insert  into `tc_sys_param`(`id`,`p_name`,`p_key`,`p_value`) values ('0d66c520c142468c9372e35e312db65e','首页同城购列表显示数量','index_tcg_num','6'),('ae9c471e16384e1aa29fc0ddaed52f79','首页轮播图显数量','index_top_num','5'),('fdbd80dcb40a4fa8a11fe16fd4f6c6f4','首页同城搜列表显示数量','index_tcs_num','6');

/*Table structure for table `tc_user` */

DROP TABLE IF EXISTS `tc_user`;

CREATE TABLE `tc_user` (
  `id` char(32) NOT NULL COMMENT '用户Id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `display_name` varchar(255) DEFAULT NULL COMMENT '显示的名称（昵称）',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型 0商家 活动方 1一般 ',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `mobile` char(11) DEFAULT NULL COMMENT '手机号码',
  `login_error_count` int(11) DEFAULT NULL COMMENT '登录错误次数',
  `login_ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `state` char(1) DEFAULT NULL COMMENT '状态 0删除 1启用 2禁用 3禁止发布',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `tc_user` */

insert  into `tc_user`(`id`,`user_name`,`user_pwd`,`display_name`,`user_type`,`email`,`mobile`,`login_error_count`,`login_ip`,`last_login_time`,`state`,`create_by`,`create_time`,`update_by`,`update_time`) values ('1','111','7fa8282ad93047a4d6fe6111c93b308a','丶小破孩灬','1',NULL,NULL,NULL,NULL,NULL,'1',NULL,'2017-02-16 15:54:37',NULL,NULL),('2','admin','dcfa058bb7993b59dc8a1ee8594a4114','系统管理员','0',NULL,NULL,NULL,NULL,NULL,'1',NULL,'2017-02-02 15:54:47',NULL,NULL);

/*Table structure for table `tc_user_card` */

DROP TABLE IF EXISTS `tc_user_card`;

CREATE TABLE `tc_user_card` (
  `id` char(32) NOT NULL COMMENT '用户名片',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `pic_url` char(255) DEFAULT NULL COMMENT '头像',
  `card_name` varchar(500) DEFAULT NULL COMMENT '名称或店铺名',
  `address` varchar(1000) DEFAULT NULL COMMENT '地址',
  `telphone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `route` varchar(500) DEFAULT NULL COMMENT '路线',
  `region` varchar(2000) DEFAULT NULL COMMENT '经营范围',
  `state` char(1) DEFAULT NULL COMMENT '状态 0删除 1启用 2当前使用',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我的名片';

/*Data for the table `tc_user_card` */

insert  into `tc_user_card`(`id`,`user_id`,`pic_url`,`card_name`,`address`,`telphone`,`route`,`region`,`state`,`create_by`,`create_time`,`update_by`,`update_time`) values ('0f7d007e50c04f1295c7aec23886a3e7','1','../img/touxiang.png','123','123','123','123','123123123','1',NULL,'2017-02-11 12:51:47',NULL,'2017-02-11 12:51:47'),('1','1','1','丶小破孩灬','1',NULL,NULL,NULL,'2',NULL,NULL,NULL,NULL),('11be6adc414c4538bc41c64446fa994b','1','blob:file%3A///c546eb04-9399-478e-ace8-4999610dcb5a','ccccccc','','','','','1',NULL,'2017-02-12 21:38:34',NULL,'2017-02-12 21:38:34'),('2','1','1','刘涛','2',NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL),('212c93bf03964f5894dd0bc8cf4bd003','1','../img/touxiang.png','测试1','测试1','','','','1',NULL,'2017-02-12 21:13:24',NULL,'2017-02-12 21:13:24'),('263e89a9bfc8415682f4ca190b6629de','1','../img/touxiang.png','121','31212','123','123','123','1',NULL,'2017-02-11 12:48:26',NULL,'2017-02-11 12:48:26'),('36ee5dcf89bd446ab5b9ed42d47e4ecb','1','/tcimg/1/dbf80f344e8549f3a069b49f81db9b94.jpg','aaaaaa','','','','','0',NULL,'2017-02-12 21:43:20',NULL,'2017-02-12 21:43:20'),('4dc79e0151974709996e2a523777d9ff','1','../img/touxiang.png','123123','123','','','','1',NULL,'2017-02-12 21:26:51',NULL,'2017-02-12 21:26:51'),('6bbe70e528844a1e9f8430cf8270851e','1','../img/touxiang.png','1123','12312','123','123','123','1',NULL,'2017-02-11 12:44:28',NULL,'2017-02-11 12:44:28'),('760633b3f1dc4f32b05049450001a9f7','1','../img/touxiang.png','1','123','123','123','123','1',NULL,'2017-02-11 12:44:51',NULL,'2017-02-11 12:44:51'),('8afbaf5a5580405bbec528bd4a1c0a40','1','../img/touxiang.png','测试','ascasc','asdadaw','awdawdwa','awdwa','1',NULL,'2017-02-12 21:11:10',NULL,'2017-02-12 21:11:10'),('a2316e02ae7246dbb757760799a3f211','1','../img/touxiang.png','12','312','','','','1',NULL,'2017-02-11 12:53:55',NULL,'2017-02-11 12:53:55'),('b94d3fb313a348669e6947e12eaf2723','1','../img/touxiang.png','12','123','123','123','123','1',NULL,'2017-02-12 21:10:54',NULL,'2017-02-12 21:10:54'),('cc9b1ba5a81041e59027a5171309f92a','1','../img/touxiang.png','123','123','123','123123','12312312','1',NULL,'2017-02-11 12:53:23',NULL,'2017-02-11 12:53:23');

/*Table structure for table `tc_user_fav` */

DROP TABLE IF EXISTS `tc_user_fav`;

CREATE TABLE `tc_user_fav` (
  `id` char(32) NOT NULL COMMENT '我的关注',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `act_id` char(32) DEFAULT NULL COMMENT '活动id',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我的关注';

/*Data for the table `tc_user_fav` */

insert  into `tc_user_fav`(`id`,`user_id`,`act_id`,`create_by`,`create_time`,`update_by`,`update_time`) values ('1','1','1',NULL,NULL,NULL,NULL),('107f55dfe4fe43f79e2708178e70d0ef','1','2',NULL,'2017-02-07 16:39:07',NULL,NULL),('178a1c67a810495ab0d5745295fe89ff','1','2',NULL,'2017-02-07 16:18:13',NULL,NULL),('2','1','2',NULL,NULL,NULL,NULL),('3','1','3',NULL,NULL,NULL,NULL),('41c8ef10d8994ce9b1d4f90ec7e3ac07','1','b2e87f6a396747ad9fae821df33d68e5',NULL,'2017-02-10 02:52:49',NULL,NULL),('7f25f5f509434b32960addc4b576f031','2','2',NULL,'2017-02-07 16:20:33',NULL,NULL),('a2e2c053775842cb8899f769b643d3cf','2','2',NULL,'2017-02-07 16:22:40',NULL,NULL),('a71c0b199515411ca7c0fc0da3dd7077','1','2',NULL,'2017-02-07 16:25:59',NULL,NULL);

/*Table structure for table `tc_user_msg` */

DROP TABLE IF EXISTS `tc_user_msg`;

CREATE TABLE `tc_user_msg` (
  `id` char(32) NOT NULL COMMENT '我的消息',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `msg_type` char(1) DEFAULT NULL COMMENT '消息类型 0系统消息 1活动消息 2推广消息',
  `content` varchar(2000) DEFAULT NULL COMMENT '消息内容',
  `state` char(1) DEFAULT NULL COMMENT '状态 0删除 1未读 2已读',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我的消息';

/*Data for the table `tc_user_msg` */

/*Table structure for table `tc_user_role` */

DROP TABLE IF EXISTS `tc_user_role`;

CREATE TABLE `tc_user_role` (
  `id` char(32) NOT NULL COMMENT '用户-角色关系表',
  `user_id` char(32) DEFAULT NULL COMMENT '用户Id',
  `role_id` char(32) DEFAULT NULL COMMENT '角色Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色关系表';

/*Data for the table `tc_user_role` */

insert  into `tc_user_role`(`id`,`user_id`,`role_id`) values ('1','2','1'),('2','2','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
