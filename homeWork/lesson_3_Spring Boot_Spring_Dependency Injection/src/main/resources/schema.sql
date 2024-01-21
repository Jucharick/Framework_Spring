CREATE TABLE IF NOT EXISTS userTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    age int NOT NULL,
    email varchar(50) NULL
);

INSERT INTO userTable (name,age,email) VALUES ('Alex', 23, 'exam1@yandex.ru');
INSERT INTO userTable (name,age,email) VALUES ('July', 23, 'exam2@yandex.ru');
INSERT INTO userTable (name,age,email) VALUES ('Bilbo', 13, 'exam3@yandex.ru');
INSERT INTO userTable (name,age,email) VALUES ('Khall', 11, 'exam4@yandex.ru');