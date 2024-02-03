CREATE TABLE IF NOT EXISTS userTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL
);

INSERT INTO userTable (firstName,lastName) VALUES ('Alex','Katz');
INSERT INTO userTable (firstName,lastName) VALUES ('Bilbo','Baggins');
INSERT INTO userTable (firstName,lastName) VALUES ('Din','Djarin');
INSERT INTO userTable (firstName,lastName) VALUES ('Elizabeth','Windsor');
INSERT INTO userTable (firstName,lastName) VALUES ('Ahsoka','Tano');
INSERT INTO userTable (firstName,lastName) VALUES ('Boba','Fett');