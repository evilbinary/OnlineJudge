create database oj;
use oj;
create table user(
  id int not null auto_increment,
  name char(20) default '',
  email char(30) default '',
  registeDate date not null,
  remarks char(50) default '',
  primary key(id)
  );
create table admin(
  id int  not null auto_increment,
  name char(20) default '',
  privilege int default 1,
  registeDate date not null,
  remarks char(50) default '',
  primary key(id)
);
create table group(
  id int not null auto_increment,
  cretateDate date not null,
  owner int not null,
  primary key(id)
);
create table submitStatistic(
  id int not null,
  submitCount int default 0,
  passCount int default 0,
);
create table problem(
  id int auto_increment,
  content varchar() default '',
  createDate date not null,
  owner int not null,
);
create table testData(
  id  int not null auto_increment,
  input char(50) not null,
  output char(50) not null
);
create table problemLimit(
  pid int not null,
  timeLimit long default 0,
  memoryLimit long default 0,
  submitDateLimit date
);
create table submitState(
  id int not null auto_increment,
  cid int not null,
  codeType char(10) default 'java',
  submitdate date not null,
  codeLength int default 0
);
create table problemAnswer(
  testId int  not null,
  problemID int not null,
);
create table acceptCode(
  pid int not null ,
  uid int not null,
  code varchar(5000) not null,
  codeType char(10) default 'java',
  passDate date not null
);

create table erroCode(
  pid int not null,
  uid int not null,
  code varchar(5000) not null,
  codeType char(10) default 'java',
  jugeDate date not null
);
create table loginInfo(
  uid int not null,
  ipaddress char(20) not null,
  loginTime date not null
);