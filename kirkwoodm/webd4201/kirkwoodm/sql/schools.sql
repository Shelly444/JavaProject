DROP TABLE IF EXISTS Schools;
CREATE TABLE Schools (
	SchoolCode varchar(2) PRIMARY KEY NOT NULL,
	SchoolDescription varchar(50)
);

INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV', 'Centre for Food');
INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH', 'School of Hlth & Comm Services');
INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX', 'School of Bus, IT & Management');
INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM', 'School of Media, Art & Design');
INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ', 'Sch of Science & Engineer Tech');
INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN', 'SchSkill Trd, Appr &Renew Tech');
INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SB', 'School of Business');
INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK', 'School of Justice & Emerg Serv');
INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SO', 'School College Work Initiative');
INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY', 'Sch Interdisciplinary Studies');