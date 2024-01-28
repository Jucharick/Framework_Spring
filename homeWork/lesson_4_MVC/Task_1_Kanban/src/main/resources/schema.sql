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



CREATE TABLE IF NOT EXISTS taskTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    description text NOT NULL,
    status  ENUM('assigned', 'in_progress', 'resolved', 'reopened', 'closed') NOT NULL,
    requestedBy int NOT NULL,
    assignedBy int NOT NULL,
    assigneeID int NOT NULL,
    FOREIGN KEY(requestedBy) REFERENCES userTable(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(assignedBy) REFERENCES userTable(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(assigneeID) REFERENCES userTable(id) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO taskTable (title,description,status,requestedBy,assignedBy,assigneeID) VALUES ('Provision','Расчет оценочных резервов для офшорных зон', 'assigned', 5, 4, 6);
INSERT INTO taskTable (title,description,status,requestedBy,assignedBy,assigneeID) VALUES ('Deals','Добавление поля для сделочной информации', 'resolved', 3, 4, 1);
INSERT INTO taskTable (title,description,status,requestedBy,assignedBy,assigneeID) VALUES ('Accounting','Добавление поля для архивных счетов' , 'in_progress', 3, 4, 1);

