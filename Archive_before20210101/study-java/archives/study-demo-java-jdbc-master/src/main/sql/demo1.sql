CREATE DATABASE IF NOT EXISTS jdbc_demo_db DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

create table user(
	id integer primary key,
	name varchar(30),
    birthday date,
    money float
);

insert into user values('2','张三','1988-03-04',15900);

insert into user values('1','李四','1988-05-24',180);