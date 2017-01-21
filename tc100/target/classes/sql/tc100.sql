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
  `cate_id` char(32) DEFAULT NULL COMMENT '分类id',
  `act_type` char(10) DEFAULT NULL COMMENT '位置代码',
  `main_pic` varchar(100) DEFAULT NULL COMMENT '同城购主图',
  `summary` varchar(2000) DEFAULT NULL COMMENT '简介',
  `detail_summary` varchar(2000) DEFAULT NULL COMMENT '详情页简介',
  `detail_content` text COMMENT '详情页内容',
  `state` char(1) DEFAULT NULL COMMENT '状态 0删除 1存在',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `view_count` int(11) DEFAULT NULL COMMENT '浏览次数',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '剩余金额',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城购';

/*Data for the table `tc_active` */

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
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城购商品详情';

/*Data for the table `tc_active_item` */

/*Table structure for table `tc_active_log` */

DROP TABLE IF EXISTS `tc_active_log`;

CREATE TABLE `tc_active_log` (
  `id` char(32) NOT NULL COMMENT '同城购操作日志',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `content` varchar(500) DEFAULT NULL COMMENT '操作内容',
  `act_id` char(32) DEFAULT NULL COMMENT '活动id',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城购操作日志';

/*Data for the table `tc_active_log` */

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

insert  into `tc_category`(`id`,`cate_name`,`pid`,`pids`,`cate_level`,`sort`,`remark`,`state`,`create_by`,`create_time`,`update_by`,`update_time`) values ('2799c7efdbf14a358a0fe8a4974c3e7c','婴孕','0','0',1,2,'婴孕','1','1','2017-01-21 23:54:24','1','2017-01-21 23:54:24'),('50b5bdce2be6474fa6af8c45c0100d40','房产','0','0',1,4,'房产','1','1','2017-01-21 23:54:39','1','2017-01-21 23:54:39'),('e2646bdb82084f9ba45bdd1caee3d5c2','车辆','0','0',1,3,'车辆','1','1','2017-01-21 23:54:33','1','2017-01-21 23:54:33'),('e491125b2f8941f186c1d01d32c86800','超市','0','0',1,1,'超市','1','1','2017-01-21 23:53:55','1','2017-01-21 23:53:55');

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

/*Table structure for table `tc_message` */

DROP TABLE IF EXISTS `tc_message`;

CREATE TABLE `tc_message` (
  `id` char(32) NOT NULL COMMENT '同城购',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `remark` varchar(2000) DEFAULT NULL COMMENT '内容',
  `region` varchar(100) DEFAULT NULL COMMENT '提供服务的区域',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城搜';

/*Data for the table `tc_message` */

/*Table structure for table `tc_message_review` */

DROP TABLE IF EXISTS `tc_message_review`;

CREATE TABLE `tc_message_review` (
  `id` char(32) NOT NULL COMMENT '同城购',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
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

/*Table structure for table `tc_user_card` */

DROP TABLE IF EXISTS `tc_user_card`;

CREATE TABLE `tc_user_card` (
  `id` char(32) NOT NULL COMMENT '用户名片',
  `user_id` char(32) DEFAULT NULL COMMENT '用户id',
  `pic_url` char(32) DEFAULT NULL COMMENT '头像',
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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
