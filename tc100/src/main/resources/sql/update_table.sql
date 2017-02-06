-------------------------------- 添加同城购 同城搜表 用户名片 字段 与名片关联 -------------------------------------
ALTER TABLE `tc_message` ADD COLUMN `card_id` CHAR(32) COMMENT '用户名片id' AFTER `user_id`;
ALTER TABLE `tc_message_review` ADD COLUMN `card_id` CHAR(32) COMMENT '用户名片id' AFTER `user_id`;
ALTER TABLE `tc_active` ADD COLUMN `card_id`  CHAR(32) COMMENT '用户名片id' AFTER `user_id` ;

-------------------------------- 添加同城购操作日志类型 推送actId来源 -------------------------------------
ALTER TABLE `tc_active_log` ADD COLUMN log_type CHAR(1) 
COMMENT '操作日志类型 0 浏览 1关注 2分享 3重复 4水贴 5推送 6推广 7取消关注' AFTER `act_id`;
ALTER TABLE `tc_active_log` ADD COLUMN from_act_id CHAR(1) 
COMMENT '推送原actId' AFTER `act_id`;

-------------------------------- 添加同城购 是否自动加载首页图片字段 -------------------------------------
ALTER TABLE `tc_active` ADD COLUMN `is_init` CHAR(1) 
COMMENT '是否自动加载首页图片' AFTER `summary`;

-------------------------------- 修改同城购 状态字段备注信息 -------------------------------------
ALTER TABLE `tc_active` MODIFY COLUMN state CHAR(1) COMMENT '状态 0删除 1存在 2发布';

