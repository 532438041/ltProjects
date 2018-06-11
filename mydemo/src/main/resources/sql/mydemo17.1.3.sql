/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/1/3 16:17:52                            */
/*==============================================================*/


drop table if exists sc_log;

drop table if exists sc_menu;

drop table if exists sc_role;

drop table if exists sc_role_menu;

drop table if exists sc_user;

drop table if exists sc_user_role;

drop table if exists web_article;

drop table if exists web_article_category;

drop table if exists web_article_count;

drop table if exists web_article_log;

/*==============================================================*/
/* Table: sc_log                                                */
/*==============================================================*/
create table sc_log
(
   id                   char(32) not null,
   details              text comment '日志内容描述',
   method               varchar(500) comment '操作的方法名称、 增、 删、 改',
   log_type             char(2) comment '日志类型 00后台操作日志 10前台操作日志 01后台异常日志 11前台异常日志',
   req_Ip               varchar(255) comment '操作ip',
   ex_code              varchar(500) comment '异常编码',
   ex_detail            text comment '异常内容描述',
   params               text comment '请求参数',
   create_by            char(32) comment '日志创建者',
   create_time          datetime comment '日志创建时间',
   primary key (id)
);

alter table sc_log comment '系统日志';

/*==============================================================*/
/* Table: sc_menu                                               */
/*==============================================================*/
create table sc_menu
(
   id                   char(32) not null comment '菜单id',
   menu_name            varchar(255) comment '菜单名称',
   menu_url             varchar(255) comment '菜单链接',
   pid                  char(32) comment '上级菜单id',
   sort                 int(11) comment '排序',
   remark               varchar(255) comment '备注',
   state                char(1) comment '状态 0删除 1启用 2禁用',
   create_by            char(32) comment '创建人',
   create_time          datetime comment '创建时间',
   update_by            char(32) comment '更新人',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table sc_menu comment '后台系统菜单';

/*==============================================================*/
/* Table: sc_role                                               */
/*==============================================================*/
create table sc_role
(
   id                   char(32) not null comment '角色id',
   role_name            varchar(255) comment '角色名称',
   remark               varchar(255) comment '备注',
   state                char(1) comment '状态 0删除 1启用 2禁用',
   create_by            char(32) comment '创建人',
   create_time          datetime comment '创建时间',
   update_by            char(32) comment '更新人',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table sc_role comment '角色表';

/*==============================================================*/
/* Table: sc_role_menu                                          */
/*==============================================================*/
create table sc_role_menu
(
   id                   char(32) not null comment '角色-菜单',
   role_id              char(32) comment '角色Id',
   menu_id              char(32) comment '菜单Id',
   primary key (id)
);

alter table sc_role_menu comment 'sc_role_menu';

/*==============================================================*/
/* Table: sc_user                                               */
/*==============================================================*/
create table sc_user
(
   id                   char(32) not null comment '用户Id',
   user_name            varchar(255) comment '用户名',
   user_pwd             varchar(255) comment '登录密码',
   display_name         varchar(255) comment '显示的名称（昵称）',
   user_type            char(1) comment '用户类型 0后台 1前台 ',
   email                varchar(255) comment '邮箱',
   mobile               char(11) comment '手机号码',
   login_error_count    int(11) comment '登录错误次数',
   login_ip             varchar(255) comment '登录ip',
   last_login_time      datetime comment '最后一次登录时间',
   state                char(1) comment '状态 0删除 1启用 2禁用',
   create_by            char(32) comment '创建人',
   create_time          datetime comment '创建时间',
   update_by            char(32) comment '更新人',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table sc_user comment '用户表';

/*==============================================================*/
/* Table: sc_user_role                                          */
/*==============================================================*/
create table sc_user_role
(
   id                   char(32) not null comment '用户-角色表',
   user_id              char(32) comment '用户Id',
   role_id              char(32) comment '角色Id',
   primary key (id)
);

alter table sc_user_role comment '用户-角色关系表';

/*==============================================================*/
/* Table: web_article                                           */
/*==============================================================*/
create table web_article
(
   id                   char(32) not null comment '文章表',
   title                varchar(255) comment '文章标题',
   subtitle             varchar(255) comment '文章副标题/简介',
   content              text comment '文字内容',
   picture              varchar(255) comment '文章主题图片(存放图片路径)',
   user_id              char(32) comment '作者id',
   cate_id              char(32) comment '分类id',
   state                char(1) comment '状态 0删除 1保存 2发布 3下架',
   create_time          datetime comment '创建时间',
   publish_time         datetime comment '发布时间',
   update_time          datetime comment '最后更新时间',
   check_reason         varchar(255) comment '下架原因',
   check_by             char(32) comment '审核人',
   check_time           char(32) comment '审核时间',
   primary key (id)
);

alter table web_article comment '文章表';

/*==============================================================*/
/* Table: web_article_category                                  */
/*==============================================================*/
create table web_article_category
(
   id                   char(32) not null comment '分类id',
   cate_name            varchar(255) comment '分类名称',
   pid                  char(32) comment '父id',
   pids                 char(100) comment '父id集合 层级 “,”分割',
   cate_level           int default 0 comment '第几层级',
   sort                 int(11) comment '排序',
   remark               varchar(255) comment '备注',
   state                char(1) comment '状态 0删除 1启用 2禁用',
   create_by            char(32) comment '创建人',
   create_time          datetime comment '创建时间',
   update_by            char(32) comment '更新人',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table web_article_category comment '文章分类';

/*==============================================================*/
/* Table: web_article_count                                     */
/*==============================================================*/
create table web_article_count
(
   id                   char(32) not null comment '文章统计',
   article_id           char(32) comment '文章id',
   reading_count        int comment '阅读量',
   loving_count         int comment '点赞量',
   comment_count        int comment '评论数',
   primary key (id)
);

alter table web_article_count comment '文章统计 阅读量 点赞数 评论数';

/*==============================================================*/
/* Table: web_article_log                                       */
/*==============================================================*/
create table web_article_log
(
   id                   char(32) not null,
   article_id           char(32) comment '文章id',
   user_id              char(32) comment '操作用户id',
   log_type             char(1) comment '日志类型 1阅读 2点赞 3评论',
   log_time             datetime comment '日志记录时间',
   primary key (id)
);

alter table web_article_log comment 'web_article_log';

