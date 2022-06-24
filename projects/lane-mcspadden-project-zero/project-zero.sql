/*
SQL Script
Purpose: To create the tables used to store data for project-zero console app
Author: Lane McSpadden
Company: Revature
*/

-- Table and Type Drops
drop table if exists users cascade;
drop table if exists shopitems cascade;
drop table if exists user_items_owned;
drop type if exists utitle;
drop type if exists status;
-- ENUM creation
create type utitle as enum ('client', 'employee', 'manager');
create type status as enum ('available', 'pending', 'sold');


-- Create Tables

-- -- Users Table
create table if not exists users(
user_id serial primary key,
username varchar(30) unique,
password varchar(100),
title utitle
);

-- -- Item Table
create table if not exists shopitems(
item_id serial primary key,
item_name varchar(30),
item_desc varchar(50),
item_price int,
item_state status
);
-- -- User Items Owned
-- -- -- Purpose: A table that connects users to the items that they own
create table if not exists user_items_owned(
user_id int,
item_id int, 
balance int,
foreign key(user_id) references users(user_id),
foreign key(item_id) references shopitems(item_id),
primary key(user_id, item_id)
);

-- 
insert into users(username, password, title) values('LaneM123', 'Pass1', 'manager');
insert into shopitems(item_name, item_desc, item_price, item_state) 
values('Nintedo Wii', 'All the console fun, without all of the wires', 300, 'sold');

insert into user_items_owned(user_id, item_id, balance)
values(1,1,300);

select u.username, s.item_name, s.item_desc, o.balance
from users u
join user_items_owned o 
on o.user_id = u.user_id
join shopitems s 
on o.item_id = s.item_id;


