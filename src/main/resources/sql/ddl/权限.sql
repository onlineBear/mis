/*
drop database mis
go
create database mis
go
*/

use mis
go

/*
if object_id('sys_user', 'U') is not null
  drop table sys_user
go
*/

create table sys_user
(
  id numeric(19) not null,

  no nvarchar(20) not null,			    -- 用户编码, 唯一
  name nvarchar(40) not null,           -- 用户名
  password nvarchar(40) not null,       -- 密码
  email nvarchar(60) not null,          -- 邮箱
  mobile nvarchar(11) not null,         -- 手机号
  profile_photo nvarchar(100) not null,     -- 头像url
  personal_statement nvarchar(100) not null,		-- 个性介绍

  last_update_time datetime not null,

  constraint pk_sys_user primary key(id)
)
go

create unique index uk_sys_user
  on sys_user(no)
go


/*
if object_id('sys_menu', 'U') is not null
  drop table sys_menu
go
*/

create table sys_menu
(
  id numeric(19) not null,

  parent_menu_id numeric(19) null,    -- 父级菜单id

  no nvarchar(20) not null,               -- 菜单编码
  name nvarchar(20) not null,
  icon nvarchar(100) not null,        -- 图像
  is_content bit not null,                -- 是否目录
  level tinyint not null,                 -- 层级 1为根
  description nvarchar(100) not null,     -- 描述
  is_display bit not null,                -- 是否显示

  last_update_time datetime not null,

  constraint pk_sys_menu primary key(id)
)
go

create unique index uk_sys_menu
  on sys_menu(no)
go

/*
if object_id('sys_role', 'U') is not null
  drop table sys_role
go
*/

create table sys_role
(
  id numeric(19) not null,

  no nvarchar(20) not null,
  name nvarchar(20) not null,
  description nvarchar(100) not null,

  last_update_time datetime not null,

  constraint pk_sys_role primary key(id)
)
go

create unique index uk_sys_role
  on sys_role(no)
go

/*
if object_id('sys_power', 'U') is not null
  drop table sys_power
go
*/

create table sys_power
(
  id numeric(19) not null,

  menuId numeric(19) null,

  url nvarchar(100) not null,
  name nvarchar(20) not null,
  description nvarchar(100) not null,
  is_display bit not null,                -- 是否显示

  last_update_time datetime not null,

  constraint pk_sys_power primary key(id)
)
go

create unique index uk_sys_power
  on sys_power(url)
go

/*
if object_id('sys_user_role', 'U') is not null
  drop table sys_user_role
go
*/

create table sys_user_role
(
  id numeric(19) not null,

  userId numeric(19) not null,
  roleId numeric(19) not null,

  last_update_time datetime not null,

  constraint pk_sys_user_role primary key(id)
)
go

create unique index uk_sys_user_role
  on sys_user_role(userId, roleId)
go

/*
if object_id('sys_role_power', 'U') is not null
  drop table sys_role_power
go
*/

create table sys_role_power
(
  id numeric(19) not null,

  roleId numeric(19) not null,
  powerId numeric(19) not null,

  last_update_time datetime not null,

  constraint pk_sys_role_power primary key(id)
)
go

create unique index uk_sys_role_power
  on sys_role_power(roleId, powerId)
go

/*
if object_id('sys_role_menu', 'U') is not null
  drop table sys_role_menu
go
*/

create table sys_role_menu
(
  id numeric(19) not null,

  roleId numeric(19) not null,
  menuId numeric(19) not null,

  last_update_time datetime not null,

  constraint pk_sys_role_menu primary key(id)
)
go

create unique index uk_sys_role_menu
  on sys_role_menu(roleId, menuId)
go

/*
if object_id('log_login', 'U') is not null
	drop table log_login
go
*/

create table log_login
(
  id numeric(20) not null,

  user_id numeric(20) not null,

  login_time datetime not null,
  ip nvarchar(20) not null,
  browser nvarchar(20) not null,
  operating_system nvarchar(20) not null,
  logout_time datetime null,
  token nvarchar(40) not null,
  is_success bit not null,

  last_update_time datetime not null,

  constraint pk_log_login primary key(id)
)
go
