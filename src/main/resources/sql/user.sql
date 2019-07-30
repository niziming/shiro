create database shiro;
use shiro;
create table if not exists user
(
	id int(12) auto_increment comment '用户ID'
		primary key,
	username varchar(32) null comment '用户名',
	password varchar(32) null comment '密码',
	role varchar(32) null comment '用户角色'
)
comment '用户';

