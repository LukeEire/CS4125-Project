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
dob DATE,
reg VARCHAR(255)
);

--Ayoub - new reservations class
-- // Preliminary List of booking requirements (for reservations table): 
-- // lmk if you wanna talk about adding or removing any attributes
-- // - USER ID
-- // - Reservation ID
-- // - Lot?
-- // - Electric?
-- // - Accessability?
-- // - Expiry (Date entered for user to check out of parking space)
CREATE TABLE IF NOT EXISTS reservations (
id int(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
userID int(32) NOT NULL,
reg VARCHAR(255) NOT NULL,
lot varchar(255) NOT NULL,
electric TINYINT(1),
accessibility TINYINT(1),
created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
expiry DATE,
FOREIGN KEY (userID) REFERENCES users(id)
);