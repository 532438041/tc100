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

CREATE TABLE `tc_active_fee` (
  `id` CHAR(32) NOT NULL COMMENT '发布资费',
  `act_type` CHAR(10) DEFAULT NULL COMMENT '位置代码',
  `amount` DECIMAL(10,2) DEFAULT NULL COMMENT '资费',
  `unit` CHAR(10) DEFAULT NULL COMMENT '资费单位 day按天 month按月 year按年 free试用免费',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='发布资费';

CREATE TABLE `tc_operate_fee` (
  `id` CHAR(32) NOT NULL COMMENT '帖子奖惩',
  `log_type` CHAR(10) DEFAULT NULL COMMENT '操作类型 2分享 3重复 4水贴',
  `amount` DECIMAL(10,2) DEFAULT NULL COMMENT '奖惩',
  `remark` VARCHAR(500) DEFAULT NULL COMMENT '封顶备注',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='帖子奖惩';


CREATE TABLE `tc_sys_param` (
  `id` CHAR(32) NOT NULL COMMENT '系统参数',
  `p_name` VARCHAR(50) DEFAULT NULL COMMENT '参数名称',
  `p_key` VARCHAR(50) DEFAULT NULL COMMENT '参数标识',
  `p_value` VARCHAR(2000) DEFAULT NULL COMMENT '参数值',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统参数';

