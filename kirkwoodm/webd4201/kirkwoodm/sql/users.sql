CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE TABLE users (
id int PRIMARY KEY,
password varchar(40),
firstName varchar(30),
lastName varchar(40),
emailAddress varchar(50),
lastAccess date,
enrolDate date,
enabled varchar(5),
type char(1)
);
INSERT INTO users VALUES (100589028, ENCODE(DIGEST('password','sha1'), 'hex'), 'Michelle', 'Kirkwood', 'Michelle.Kirkwood4@gmail.com', '2019-03-01', '2017-07-03', 'true','s'),
(100222222, ENCODE(DIGEST('password','sha1'), 'hex'), 'Robert', 'Mchillroy', 'blah@gmail.com', '2019-03-01', '2018-07-03', 'true','s'),
(100222234, ENCODE(DIGEST('password','sha1'), 'hex'), 'Jenny', 'Mchillroy', 'Jenny@gmail.com', '2019-03-01', '2016-07-03', 'true','s'),
(100234567, ENCODE(DIGEST('password','sha1'), 'hex'), 'Darren', 'Puffer', 'pufferd@gmail.com', '2019-03-01', '2012-07-03', 'true','f'),
(100227777, ENCODE(DIGEST('password','sha1'), 'hex'), 'Jimmy', 'Black', 'Jimmy@gmail.com', '2019-03-01', '2009-07-03', 'true','f'),
(100222555, ENCODE(DIGEST('password','sha1'), 'hex'), 'Cait', 'Leaman', 'Cait@gmail.com', '2019-03-01', '2010-07-03', 'true','f');
