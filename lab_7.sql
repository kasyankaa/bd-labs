create database if not exists directory_db;
use directory_db;

drop table if exists user;
drop table if exists book;
drop table if exists user_marked_book;
drop table if exists password;
drop table if exists reference;
drop table if exists directory_tree;
				
create table user (
    id int not null auto_increment PRIMARY KEY,
    login varchar(45) not null,
	surname varchar(45) not null,
    name varchar(45) not null,
	middle_name varchar(45) not null,
    birth_date date not null,
	birth_place varchar(45) not null,
    home_place varchar(45) not null,
    remark varchar(45) not null,
	rate double not null,
    password_id  int unique not null
);

create table book (
    id int not null auto_increment PRIMARY KEY,
	name varchar(45) not null,
    authors varchar(45) not null,
    udk_index int not null,
    rate double not null,
    directory_tree_id int not null
);

create table user_marked_book (
	id int auto_increment PRIMARY KEY,
    book_id  int not null,
    user_id int not null
);

create table password (
    id int not null auto_increment PRIMARY KEY,
    password varchar(100) not null
);

create table reference (
    id int not null auto_increment PRIMARY KEY,
    email_address varchar(100) not null,
    book_id int not null
);

create table directory_tree (
    id int not null auto_increment PRIMARY KEY,
    rubric varchar(45) not null,
    directory_tree_id int not null
);