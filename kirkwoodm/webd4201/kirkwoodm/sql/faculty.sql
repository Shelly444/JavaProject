CREATE TABLE faculty (
id int REFERENCES Users(id),
schoolCode varchar(5),
schoolDescription varchar(255),
office varchar(10),
extension int,
PRIMARY KEY (id)
);
INSERT INTO faculty
VALUES (
100234567,
'DCOM',
'Stupid class',
'H-122',
1234),
(100227777,
'DBAS',
'Databases',
'H-126',
1235),
(100222555,
'WEBD',
'Web Development',
'A-217',
1236);