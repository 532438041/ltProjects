

#------------------------  系统日志表 刘涛 2017.1.3 -------------------------
drop table if exists sc_log;
CREATE TABLE `sc_log` (
  `id` char(32) NOT NULL,
  `details` text COMMENT '日志内容描述',
  `method` varchar(500) DEFAULT NULL COMMENT '操作的方法名称、 增、 删、 改',
  `log_type` char(2) DEFAULT NULL COMMENT '日志类型 00后台操作日志 10前台操作日志 01后台异常日志 11前台异常日志',
  `req_ip` varchar(255) DEFAULT NULL COMMENT '操作ip',
  `ex_code` varchar(500) DEFAULT NULL COMMENT '异常编码',
  `ex_detail` text COMMENT '异常内容描述',
  `params` text COMMENT '请求参数',
  `create_by` char(32) DEFAULT NULL COMMENT '日志创建者',
  `create_time` datetime DEFAULT NULL COMMENT '日志创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志';
#-----------------------------------------------------------------------------------------
