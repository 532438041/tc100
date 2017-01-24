-------------------------------- 添加同城购 同城搜表 用户名片 字段 与名片关联 -------------------------------------
ALTER TABLE `tc_message` ADD COLUMN `card_id` CHAR(32) COMMENT '用户名片id' AFTER `user_id`;
ALTER TABLE `tc_message_review` ADD COLUMN `card_id` CHAR(32) COMMENT '用户名片id' AFTER `user_id`;
ALTER TABLE `tc_active` ADD COLUMN `card_id`  CHAR(32) COMMENT '用户名片id' AFTER `user_id` ;