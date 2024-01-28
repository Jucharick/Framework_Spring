CREATE TABLE IF NOT EXISTS userTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName varchar(20) NOT NULL,
    lastName varchar(50) NOT NULL,
    position varchar(50) NOT NULL,
    team varchar(50) NOT NULL,
    email varchar(50) NULL
);

INSERT INTO userTable (firstName,lastName,position,team,email) VALUES ('Alex','Katz', 'junior java developer', 'FSP', 'exam1@yandex.ru');
INSERT INTO userTable (firstName,lastName,position,team,email) VALUES ('Bilbo','Baggins', 'teamlead', 'FSP', 'exam2@yandex.ru');
INSERT INTO userTable (firstName,lastName,position,team,email) VALUES ('Din','Djarin', 'junior analyst', 'FSP', 'exam3@yandex.ru');
INSERT INTO userTable (firstName,lastName,position,team,email) VALUES ('Elizabeth','Windsor', 'chief accountant', 'Ras-reporting', 'exam4@yandex.ru');
INSERT INTO userTable (firstName,lastName,position,team,email) VALUES ('Ahsoka','Tano', 'BI junior analyst', 'Ras-reporting', 'exam5@yandex.ru');
INSERT INTO userTable (firstName,lastName,position,team,email) VALUES ('Boba','Fett', 'sinior java developer', 'FSP', 'exam6@yandex.ru');