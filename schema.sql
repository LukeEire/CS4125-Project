create database myDatabase;
use myDatabase;
create table student(USERNAME varchar(30) not null,UNISTATUS varchar(10) ,
CONFIRMPASSWRD varchar(20) ,CITY varchar(30),
EMAIL varchar(30) );

--Ayoub Changes
CREATE TABLE IF NOT EXISTS users (
id int(32) PRIMARY KEY,
firstName VARCHAR(255) NOT NULL,
lastName VARCHAR(255) NOT NULL,
password VARCHAR(255),
email_address VARCHAR(320),
status VARCHAR(32),
electric TINYINT(1),
penalties int(11),
ban_status TINYINT(1),
accessibility TINYINT(1),
created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
dob DATE
);