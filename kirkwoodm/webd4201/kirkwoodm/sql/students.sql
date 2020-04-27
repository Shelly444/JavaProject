CREATE TABLE students (
id int REFERENCES users(id),
programCode varchar(5),
programDescription varchar(255),
year int,
PRIMARY KEY (id)
);
INSERT INTO students
VALUES (
100589028,
'CPA',
'Computer Programmer Analyst',
2),
(100222222,
'CPGM',
'Computer Programmer',
1),
(100222234,
'CPA',
'Computer Programmer Analyst',
3);
