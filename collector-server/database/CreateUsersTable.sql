CREATE TABLE users
(
	username VARCHAR(16) NOT NULL PRIMARY KEY,
	password VARCHAR(255) NOT NULL,
	email VARCHAR(100) NOT NULL,
	picture VARCHAR(255) DEFAULT 'i.imgur.com/N6XWLsy.png',
	register_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	country varchar(35),
);
