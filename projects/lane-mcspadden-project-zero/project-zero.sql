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
drop table if exists item_offers cascade;
drop table if exists payment_history cascade;
drop type if exists utitle;
drop type if exists status;
drop type if exists accrej;
-- ENUM creation
create type utitle as enum ('CLIENT', 'EMPLOYEE', 'MANAGER');
create type status as enum ('AVAILABLE', 'PENDING', 'SOLD');
create type accrej as enum ('ACCEPT', 'REJECT', 'PENDING');

-- Create Tables

-- -- Users Table
create table if not exists users(
id serial primary key,
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
foreign key(user_id) references users(id),
foreign key(item_id) references shopitems(item_id),
primary key(user_id, item_id)
);

-- -- Current Offers
create table if not exists item_offers(
offer_id serial,
user_id int,
item_id int, 
offer int,
status accrej,
foreign key(user_id) references users(id),
foreign key(item_id) references shopitems(item_id),
primary key(offer_id, user_id, item_id)
);

-- -- Payment History
create table if not exists payment_history (
user_id int,
item_id int,
pay_date Date,
balance_remaining int,
payAmount int,
emp_authed int,
foreign key(user_id) references users(id),
foreign key(item_id) references shopitems(item_id),
foreign key(emp_authed) references users(id),
primary key(user_id, item_id, balance_remaining)
);
-- 
insert into users(username, password, title) values('LaneM123', 'Pass1', 'CLIENT');
insert into users(username, password, title) values('LaneM1223', 'Pass1', 'CLIENT');
insert into users(username, password, title) values('JaneR123', 'Pass1', 'EMPLOYEE');
insert into shopitems(item_name, item_desc, item_price, item_state) 
values('Pikachu', 'Pokemon', 500, 'AVAILABLE');
insert into shopitems(item_name, item_desc, item_price, item_state) 
values('Koro Sensei', 'Assassination Classroom', 300, 'SOLD');
insert into shopitems(item_name, item_desc, item_price, item_state) 
values('Nezuko', 'Demon Slayer', 300, 'SOLD');
insert into user_items_owned(user_id, item_id, balance)
values(1,3,300);
insert into user_items_owned(user_id, item_id, balance)
values(2,2,200);

select u.username, s.item_name, s.item_desc, o.balance
from users u
join user_items_owned o 
on o.user_id = u.id
join shopitems s 
on o.item_id = s.item_id;

