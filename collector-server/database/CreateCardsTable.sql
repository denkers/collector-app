CREATE TABLE cards
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(35),
	picture VARCHAR(100) NOT NULL,
	card_type INT,
	FOREIGN KEY (card_type) REFERENCES card_types(id) ON DELETE SET NULL 
);
