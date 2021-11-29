create database myDatabase;
use myDatabase;
create table student(USERNAME varchar(30) not null,UNISTATUS varchar(10) ,
CONFIRMPASSWRD varchar(20) ,CITY varchar(30),
EMAIL varchar(30) );

--Ayoub new users DB
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
banTime DATE,
accessibility TINYINT(1),
created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
dob DATE,
reg VARCHAR(255)
);

-- Testing SQL statments
INSERT INTO users (id, firstName, LastName, password, email_address, status, electric, penalties, ban_status, accessibility, created_on, dob, reg ) VALUES (18266401, "Ayoub", "Jdair", "Password123", "Student", 1, 0, "2000-12-15", "222LH1445");

INSERT INTO users (id, firstName, LastName, password, status, electric accessibility, dob, reg ) VALUES (18266401, "Ayoub", "Jdair", "Password123", "Student", 1, 0, "2000-12-15", "222LH1445");

INSERT INTO users (id, firstName, LastName, password, status, electric, accessibility, created_on, dob, reg ) VALUES (18266401, "Ayoub", "Jdair", "Password123", "Student", 1, 0, "2000-12-15", DATE '2015-12-17', "222LH1445");

INSERT INTO `users` (`id`, `firstName`, `lastName`, `password`, `email_address`, `status`, `electric`, `penalties`, `ban_status`, `banTime`, `accessibility`, `created_on`, `dob`, `reg`) VALUES ('', '', '', MD5(''), NULL, NULL, NULL, NULL, NULL, NULL, NULL, CURRENT_TIMESTAMP, NULL, NULL);

UPDATE users SET ban_status = 1, banTime = DATE '2000-03-12' WHERE id = "18266401"

INSERT INTO users (id, firstName, LastName, password, status, electric, accessibility, dob, reg ) VALUES (18266401, "Ayoub", "Jdair", "Password123", "Student", 1, 0, "2000-12-15", "222LH1445");

SELECT * FROM users WHERE id = 18173581 AND password =  MD5('test123')

SELECT * FROM users WHERE id = 18266401 AND password = "Password123"
--Ayoub - new reservations DB
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
created_on DATE,
expiry DATE,
FOREIGN KEY (userID) REFERENCES users(id)
);

-- Testing SQL statments
INSERT INTO reservations(userID, reg, lot, electric, accessibility, created_on, expiry) VALUES (18266401, '10LH1445', 'LOT A', 1, 0, DATE '2015-12-17', DATE '2015-12-17');

--Ayoub - new transactions table
-- id | userID | ReservationID | lot | amount | created_on
CREATE TABLE IF NOT EXISTS transactions (
id int(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
userID int(32) NOT NULL,
reservationsID int(32) NOT NULL,
lot varchar(255) NOT NULL,
amount double NOT NULL,
created_on DATE,
FOREIGN KEY (userID) REFERENCES users(id),
FOREIGN KEY (reservationsID) REFERENCES reservations(id)
);

-- Testing SQL statments
INSERT INTO transactions(userID, reservationsID, lot, amount,created_on) VALUES (18266401, 1, "Lot A", 2.40,  DATE '2015-12-17');