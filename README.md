# springbootdemo
how to use springboot and practice

#项目搭建 0909

#建表语句
CREATE TABLE `sys_user` (
  `sys_id` varchar(32) NOT NULL COMMENT '主键ID',
  `user_name` varchar(32) COMMENT '登录名',
  `real_name` varchar(32) COMMENT '真实姓名',
  `password` varchar(32) COMMENT '密码',
  `sex` tinyint(1) DEFAULT '0' COMMENT '性别:0:女;1男',
  `email` varchar(32) COMMENT '邮箱',
  `phone` varchar(32) COMMENT '手机',
  `user_status` tinyint(1) DEFAULT '0' COMMENT '用户状态:0可用;1不可用',
  `note` varchar(100) COMMENT '备注',
  `order_by` int(11) DEFAULT '0' COMMENT '排序',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '逻辑删除0否1是',
  `create_date` varchar(32) COMMENT '创建时间',
  PRIMARY KEY (`sys_id`)
);

# 执行该语句 登录的账号密码为 spom/spom
INSERT INTO `sys_user` VALUES ('c9a96a57f35a11eaade3e86a64631d2b', 'spom', 'spom', 'spom', 1, 'spom@163.com', '13148733577', 0, '111', 1, 0, NULL);

