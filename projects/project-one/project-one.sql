drop type if exists utitle cascade;
drop type if exists reqstatus cascade;
drop type if exists reqtype cascade;
drop table if exists users cascade;
drop table if exists requests cascade;

-- =================================================================

-- Enum Creation
CREATE TYPE utitle AS enum ('EMPLOYEE', 'MANAGER');
create type reqstatus as enum ('ACCEPTED', 'DENIED', 'PENDING');
create type reqtype as enum ('LODGING', 'TRAVEL', 'FOOD', 'OTHER');
-- =================================================================

-- Create Tables

-- -- User Table

CREATE TABLE IF NOT EXISTS users(
user_id serial PRIMARY KEY,
username varchar(30) unique,
password varchar(100),
fname varchar(30),
lname varchar(30),
email varchar(100),
title utitle default('EMPLOYEE')
);


-- -- Request Table

create table if not exists requests(
request_id serial primary key,
ammount int,
date_sub DATE default(now()) not null,
date_res Date,
reqdesc varchar(300),
author_id int,
status varchar(10) default('PENDING'),
type varchar(10),
case_manager int,
foreign key(case_manager) references users(user_id),
foreign key(author_id) references users(user_id)
);

insert into users (username, password, email, fname, lname) values ('dschutze0', 'kQEn35JHX2', 'dschutze0@gmpg.org', 'Dora', 'Schutze');
insert into users (username, password, email, fname, lname) values ('mminty1', 'GCKUF9Amr', 'mminty1@yellowpages.com', 'Marinna', 'Minty');
insert into users (username, password, email, fname, lname) values ('dgoodswen2', 'csvUeB', 'dgoodswen2@wordpress.com', 'Daron', 'Goodswen');
insert into users (username, password, email, fname, lname) values ('mscowcraft3', 'lhzUn9AWON0', 'mscowcraft3@wikispaces.com', 'Miner', 'Scowcraft');
insert into users (username, password, email, fname, lname) values ('rgarces4', 'Es0uQadcw', 'rgarces4@amazon.co.uk', 'Rori', 'Garces');
insert into users (username, password, email, fname, lname) values ('hdyster5', 'FucYTozo', 'hdyster5@symantec.com', 'Harmonie', 'Dyster');
insert into users (username, password, email, fname, lname) values ('murpeth6', 'vfSp6nNDfdNx', 'murpeth6@plala.or.jp', 'Maison', 'Urpeth');
insert into users (username, password, email, fname, lname) values ('zparrott7', 'cBJjSVhwI0ec', 'zparrott7@nymag.com', 'Zachariah', 'Parrott');
insert into users (username, password, email, fname, lname) values ('mlassell8', 'BfN4XijraJV', 'mlassell8@upenn.edu', 'Margette', 'Lassell');
insert into users (username, password, email, fname, lname) values ('pgriggs9', 'SqUuOEKd', 'pgriggs9@huffingtonpost.com', 'Page', 'Griggs');
insert into users (username, password, email, fname, lname) values ('athodaya', '55XfXZ', 'athodaya@ezinearticles.com', 'Ashia', 'Thoday');
insert into users (username, password, email, fname, lname) values ('savrasinb', 'HO3JLk', 'savrasinb@google.pl', 'Sibelle', 'Avrasin');
insert into users (username, password, email, fname, lname) values ('sbauldreyc', '65df2vt7Yc', 'sbauldreyc@desdev.cn', 'Steffie', 'Bauldrey');
insert into users (username, password, email, fname, lname) values ('ecoffeltd', 'qt2pF2Sgy', 'ecoffeltd@discuz.net', 'Eddie', 'Coffelt');
insert into users (username, password, email, fname, lname) values ('tgilffillande', 'j3FMSuVt', 'tgilffillande@live.com', 'Tracey', 'Gilffilland');
insert into users (username, password, email, fname, lname) values ('awillisf', 'QCVlBhyxX', 'awillisf@aboutads.info', 'Augie', 'Willis');
insert into users (username, password, email, fname, lname) values ('sashborneg', 'ghuhDEAYVO', 'sashborneg@ning.com', 'Stanislaw', 'Ashborne');
insert into users (username, password, email, fname, lname) values ('gkeeph', '49HNj6jrE', 'gkeeph@reverbnation.com', 'Garth', 'Keep');
insert into users (username, password, email, fname, lname) values ('sbransoni', 'Xp1BWnr', 'sbransoni@barnesandnoble.com', 'Silvan', 'Branson');
insert into users (username, password, email, fname, lname) values ('ureutherj', 'NX194zj00n', 'ureutherj@lycos.com', 'Ulric', 'Reuther');
insert into users (username, password, email, fname, lname) values ('efedynskik', 'KPdi9hSHxp1', 'efedynskik@stumbleupon.com', 'Emmye', 'Fedynski');
insert into users (username, password, email, fname, lname) values ('gjaquissl', 'rm1OjRScZ', 'gjaquissl@discuz.net', 'Georgette', 'Jaquiss');
insert into users (username, password, email, fname, lname) values ('blindm', 'JoEe2uiZona', 'blindm@cbslocal.com', 'Bartolemo', 'Lind');
insert into users (username, password, email, fname, lname) values ('sheidenn', 'qM6A2D', 'sheidenn@geocities.jp', 'Shanan', 'Heiden');
insert into users (username, password, email, fname, lname) values ('tbitchenoo', 'jSaioREtegz1', 'tbitchenoo@zdnet.com', 'Terri-jo', 'Bitcheno');
insert into users (username, password, email, fname, lname) values ('vbrannp', 'SVT7w4', 'vbrannp@samsung.com', 'Vevay', 'Brann');
insert into users (username, password, email, fname, lname) values ('ryoskowitzq', 'zV8otEC', 'ryoskowitzq@free.fr', 'Ruthi', 'Yoskowitz');
insert into users (username, password, email, fname, lname) values ('kpaxmanr', 'mCGy0F4', 'kpaxmanr@youku.com', 'Kyle', 'Paxman');
insert into users (username, password, email, fname, lname) values ('lpinares', 'kUE4racpyFR', 'lpinares@usgs.gov', 'Luisa', 'Pinare');
insert into users (username, password, email, fname, lname) values ('hmacallant', 'zmKrziz', 'hmacallant@homestead.com', 'Hamil', 'MacAllan');
insert into users (username, password, email, fname, lname) values ('adrueryu', '79IlWt8B1hC', 'adrueryu@so-net.ne.jp', 'Alfie', 'Druery');
insert into users (username, password, email, fname, lname) values ('bfeldbrinv', 'EgsBsM4l', 'bfeldbrinv@latimes.com', 'Bartolemo', 'Feldbrin');
insert into users (username, password, email, fname, lname) values ('cmarvellw', 's2r2JW', 'cmarvellw@people.com.cn', 'Callie', 'Marvell');
insert into users (username, password, email, fname, lname) values ('aabbyx', 'o3M6poMgS', 'aabbyx@telegraph.co.uk', 'Arlana', 'Abby');
insert into users (username, password, email, fname, lname) values ('jesmondy', 'lnA0d6qPixy7', 'jesmondy@skype.com', 'June', 'Esmond');
insert into users (username, password, email, fname, lname) values ('jaskerz', 'JXuHg7C3', 'jaskerz@wikimedia.org', 'Jerrie', 'Asker');
insert into users (username, password, email, fname, lname) values ('hwiggam10', 'zAMRV6', 'hwiggam10@newyorker.com', 'Hermie', 'Wiggam');
insert into users (username, password, email, fname, lname) values ('rbaine11', 'f12OcaKMGdrp', 'rbaine11@miitbeian.gov.cn', 'Rowe', 'Baine');
insert into users (username, password, email, fname, lname) values ('kpymer12', 'wB56hC0g6wr', 'kpymer12@uiuc.edu', 'Karl', 'Pymer');
insert into users (username, password, email, fname, lname) values ('hkuhnert13', 'ubrCvGC9GA', 'hkuhnert13@harvard.edu', 'Hy', 'Kuhnert');
insert into users (username, password, email, fname, lname) values ('dmaclese14', 'F08UrFGlg', 'dmaclese14@timesonline.co.uk', 'Dorolice', 'MacLese');
insert into users (username, password, email, fname, lname) values ('jseares15', 'W6QDz9gbYMbc', 'jseares15@bbb.org', 'Joseito', 'Seares');
insert into users (username, password, email, fname, lname) values ('lpetroff16', 'goEr4LScD', 'lpetroff16@google.pl', 'Lorin', 'Petroff');
insert into users (username, password, email, fname, lname) values ('jjones17', 'eZoJmpBr', 'jjones17@google.co.jp', 'Jacob', 'Jones');
insert into users (username, password, email, fname, lname) values ('msinnatt18', 'JEJSou0L1S', 'msinnatt18@dion.ne.jp', 'Mychal', 'Sinnatt');
insert into users (username, password, email, fname, lname) values ('dcrumley19', 'Rv5lo2cJgL', 'dcrumley19@sourceforge.net', 'Dalston', 'Crumley');
insert into users (username, password, email, fname, lname) values ('afinder1a', 'F2YVRmtv', 'afinder1a@census.gov', 'Alene', 'Finder');
insert into users (username, password, email, fname, lname) values ('lwillcott1b', 'mFPdDxZk5S', 'lwillcott1b@mediafire.com', 'Lemmie', 'Willcott');
insert into users (username, password, email, fname, lname) values ('wcleeves1c', 'BaPkkZaG', 'wcleeves1c@zimbio.com', 'Winnifred', 'Cleeves');
insert into users (username, password, email, fname, lname) values ('kogbourne1d', 'Sj9Ow2ONSq', 'kogbourne1d@wordpress.org', 'Karlene', 'Ogbourne');
insert into users(username, password, email, fname, lname, title) values ('LaneM123', 'Pass1', 'lanedmcspadden@gmail.com', 'Lane', 'McSpadden', 'EMPLOYEE');
insert into users(username, password, fname, lname, title) values ('TayS123', 'Pass123', 'Taylor', 'Smith', 'MANAGER');
insert into users(username, password, fname, lname, title) values ('JohnS', 'Pass123', 'John', 'Saxton', 'MANAGER');


insert into requests (ammount, date_sub, reqdesc, author_id, type) values (2315, '2020-07-24 11:55:45', 'Politécnico Grancolombiano - Institución Universitaria', 7, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (8428, '2020-11-12 22:50:55', 'Grand View College', 47, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (3081, '2021-12-13 13:30:20', 'St. Petersburg State University of Civil Aviation', 18, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (523, '2022-01-20 05:42:07', 'Universitas Negeri Surabaya', 11, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (5144, '2021-06-19 00:32:13', 'Komar University of Science and Technology', 21, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (8801, '2021-01-26 09:08:23', 'Ecole Nationale Supérieure de l''Aéronautique et de l''Espace', 43, 'LODGING');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (8290, '2021-02-28 17:03:50', 'Korea National University of Physical Education', 12, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (9141, '2021-12-08 00:44:44', 'Shanghai Television University', 4, 'OTHER');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (1074, '2022-01-07 22:31:27', 'Universidad del Istmo', 15, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (5174, '2020-12-31 18:43:47', 'Goldsmiths College, University of London', 38, 'OTHER');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (4212, '2022-06-06 01:24:54', 'Massachusetts Institute of Technology', 7, 'OTHER');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (928, '2021-05-13 02:21:35', 'Deutsche Sporthochschule Köln', 3, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (5265, '2022-01-24 15:06:50', 'Universidad de la Tercera Edad', 39, 'LODGING');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (9270, '2022-03-18 19:57:17', 'Ecole Nationale Supérieure des Industries Chimiques de Nancy', 8, 'LODGING');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (3166, '2021-07-26 14:34:49', 'Chaudhary Charan Singh University', 26, 'OTHER');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (7293, '2020-11-09 01:31:06', 'Belarussian State University of Informatics and Radioelectronics', 33, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (8096, '2021-09-06 09:33:21', 'Novgorod State University', 21, 'OTHER');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (4032, '2022-06-27 18:49:52', 'City University College of Science and Technology', 45, 'LODGING');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (1163, '2021-04-15 11:16:18', 'Universidad Bolivariana de Venezuela', 6, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (8328, '2022-01-13 01:51:32', 'Oklahoma Panhandle State University', 24, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (421, '2021-11-22 01:31:47', 'Universidade Potiguar', 9, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (1465, '2020-09-30 02:04:34', 'Silesian School of Economics and Languages', 12, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (1315, '2021-11-11 15:55:40', 'University of Washington', 39, 'LODGING');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (3044, '2022-06-27 19:39:47', 'Université de Buéa', 33, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (1924, '2020-12-27 06:31:08', 'University of Nebraska - Kearney', 35, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (9206, '2022-01-06 18:16:53', 'Fachhochschule Rottenburg, Hochschule für Forstwirtschaft', 51, 'LODGING');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (8296, '2021-02-20 10:41:36', 'Universidad Amazonica de Pando', 49, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (2395, '2021-06-20 01:59:54', 'Wageningen University', 40, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (3776, '2022-04-06 19:46:22', 'University of Presov', 43, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (3833, '2022-06-15 18:33:50', 'Sadat Academy for Management Sciences', 22, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (12, '2021-03-28 22:49:37', 'Maltepe University', 13, 'OTHER');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (8393, '2021-07-13 07:51:09', 'University of New Brunswick, Saint John', 2, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (6836, '2022-01-31 08:20:34', 'Fachhochschule München', 19, 'OTHER');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (696, '2021-10-11 17:35:02', 'South University of Science and Technology of China ', 30, 'LODGING');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (7555, '2021-12-26 19:06:22', 'University of Art and Design Helsinki', 17, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (6035, '2022-01-26 08:14:33', 'Oregon Institute of Technology', 9, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (5687, '2021-02-21 03:16:43', 'Seokyeong University', 25, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (2378, '2021-01-29 17:22:37', 'University of Wisconsin - Superior', 39, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (9079, '2021-06-13 08:32:35', 'Institute of Technology and Management', 33, 'LODGING');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (3506, '2021-02-12 02:19:27', 'Université Paris Nord (Paris XIII)', 26, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (8192, '2021-03-12 04:24:26', 'Donetsk State Medical University', 14, 'OTHER');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (3059, '2021-03-02 23:20:37', 'Universidad de Córdoba', 47, 'FOOD');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (2729, '2022-02-02 17:47:37', 'Universitas Advent Indonesia', 38, 'OTHER');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (3127, '2020-10-10 19:59:43', 'Al-Islah University', 1, 'OTHER');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (5862, '2022-06-27 07:29:52', 'Dayalbagh Educational Institute', 5, 'OTHER');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (6423, '2021-12-25 02:17:01', 'China USA Business University', 22, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (1570, '2020-07-25 17:13:23', 'Concordia University, Portland', 43, 'TRAVEL');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (6522, '2021-11-23 10:59:20', 'Purdue University', 19, 'LODGING');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (8037, '2021-03-07 16:36:50', 'University of South Dakota', 36, 'LODGING');
insert into requests (ammount, date_sub, reqdesc, author_id, type) values (5739, '2020-09-29 01:45:40', 'Université Lumière de Bujumbura', 47, 'OTHER');
