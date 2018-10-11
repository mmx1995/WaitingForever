CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  `updateTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `menu` (
  `id` bigint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键\r\n',
  `parentId` bigint(8) DEFAULT NULL COMMENT '父菜单ID',
  `title` varchar(6) DEFAULT NULL COMMENT '菜单标题',
  `url` varchar(100) DEFAULT NULL COMMENT '菜单链接',
  `in_use` bit(1) DEFAULT NULL COMMENT '是否可用',
  `position` varchar(10) DEFAULT NULL COMMENT '菜单使用位置',
  `updateTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像链接',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `phone_num` varchar(13) NOT NULL COMMENT '手机号',
  `sex` varchar(4) NOT NULL COMMENT '性别',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `updateTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `userName` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `user_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `address` varchar(200) NOT NULL COMMENT '地址',
  `updateTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `user_authority` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `authority_id` bigint(20) NOT NULL COMMENT '权限ID',
  KEY `FKgvxjs381k6f48d5d2yi11uh89` (`authority_id`),
  KEY `FKpqlsjpkybgos9w2svcri7j8xy` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--  数据初始化

------权限数据库表初始化---------------
INSERT INTO `waitingforever`.`authority`(`id`, `name`, `updateTime`, `createTime`) VALUES (1, 'ROLE_ADMIN', '2018-09-21 09:09:10', '2018-09-21 09:09:14');
INSERT INTO `waitingforever`.`authority`(`id`, `name`, `updateTime`, `createTime`) VALUES (2, 'BLOGER', '2018-09-21 09:09:20', '2018-09-21 09:09:18');
