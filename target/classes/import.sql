CREATE TABLE `story` (
  `storyId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动生成',
  `storyTitle` varchar(50) NOT NULL COMMENT '标题',
  `storySummary` varchar(200) DEFAULT NULL COMMENT '摘要',
  `storyContent` longtext NOT NULL,
  `topic` varchar(20) NOT NULL COMMENT '话题类别',
  `label` varchar(100) NOT NULL COMMENT '标签',
  `authorId` int(11) NOT NULL COMMENT '作者Id',
  `updateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`storyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
