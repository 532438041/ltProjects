#--------------------- 文章表添加是否推荐字段 -----------
ALTER TABLE `web_article` ADD COLUMN is_recommend CHAR(1) DEFAULT '0' COMMENT '是否推荐文章';