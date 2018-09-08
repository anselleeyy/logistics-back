use logistics;

insert into `user`(login_id, password) values ('GL846489', 'E10ADC3949BA59ABBE56E057F20F883E');

insert into `userwithgroup` values (1, 1, 'GL846489');

insert into `usergroup` values
(1, '对职员用户的增删改查\n2. ','管理组'),
(2, '接货管理：填写一份货运单合同','票据组'),
(3,'结算管理','财务组'),
(4,'对客户的投诉情况进行管理以及提货回告、到货回告、已提回告、中转回告、代收回告','客服组'),
(5,'对货运单监控和整体运营状况进行分析','监控组'),
(6,'填写货运单','客户组'),(7,'司机组','司机组');

insert into `function_`(page_name) values 
('票据管理'), ('接货管理'), ('配车管理'), ('到货管理'),
('中转管理'), ('结算管理'), ('客户服务'), ('监控分析'),
('成本核算'), ('应用管理'), ('系统管理');

insert into `functionwithgroup`(function_id, group_id) values
(1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1),
(7, 1), (8, 1), (9, 1), (10, 1), (11, 1);

insert INTO `region` values (1,'南京'),(2,'常州'),(3,'镇江'),(4,'无锡'),(5,'苏州'),(6,'上海');

