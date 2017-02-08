CREATE TABLE `tc_item_cate` (
  `id` char(32) NOT NULL COMMENT '同城购商品关联分类',
  `cate_name` varchar(100) DEFAULT NULL COMMENT '分类名称',
  `act_id` char(32) DEFAULT NULL COMMENT '模板id',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同城购商品关联分类'