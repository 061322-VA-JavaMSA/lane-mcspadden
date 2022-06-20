--Salestaff
--EmployeeId | SalesPerson | SalesOffice(street, city, state, zip) 
--| Age | DoB | Customer1 | Customer 2 | Customer 3



DROP TABLE IF EXISTS customer;
CREATE TABLE IF NOT EXISTS customer(
customer_id serial UNIQUE PRIMARY key,
customer_name varchar(30)
);

drop table if exists sales_office cascade;
create table if not exists sales_office(
office_id serial unique primary key,
street VARCHAR(30),
city varchar(30),
state varchar(2),
zip int
);

DROP TABLE IF EXISTS salestaff;
CREATE TABLE IF NOT EXISTs salestaff(
staff_id serial UNIQUE PRIMARY key,
office_id int,
foreign key(office_id) references sales_office(office_id),
name varchar(30),
date_of_birth date
);

drop table if exists staff_customer;
create table if not exists staff_customer(
staff_id int,
customer_id int,
foreign key(staff_id) references salestaff(staff_id),
foreign key(customer_id) references customer(customer_id),
primary key(staff_id, customer_id)

);


