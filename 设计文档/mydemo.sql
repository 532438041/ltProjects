/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/10/11 17:10:28                          */
/*==============================================================*/


drop table if exists sc_menu;

drop table if exists sc_role;

drop table if exists sc_role_menu;

drop table if exists sc_user;

drop table if exists sc_user_role;

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
   state                tinyint(1) comment '状态 0删除 1启用 2禁用',
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
   state                tinyint(1) comment '状态 0删除 1启用 2禁用',
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
   role_id              char(32) not null comment '角色Id',
   menu_id              char(32) not null comment '菜单Id',
   primary key (role_id, menu_id)
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
   user_type            tinyint(1) comment '用户类型 0后台 1前台 ',
   email                varchar(255) comment '邮箱',
   mobile               char(11) comment '手机号码',
   login_error_count    int(11) comment '登录错误次数',
   login_ip             varchar(255) comment '登录ip',
   last_login_time      datetime comment '最后一次登录时间',
   state                tinyint(1) comment '状态 0删除 1启用 2禁用',
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
   user_id              char(32) not null comment '用户Id',
   role_id              char(32) not null comment '角色Id',
   primary key (user_id, role_id)
);

alter table sc_user_role comment '用户-角色关系表';

