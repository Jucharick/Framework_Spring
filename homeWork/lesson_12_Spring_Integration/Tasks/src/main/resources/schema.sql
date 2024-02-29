CREATE TABLE IF NOT EXISTS userTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName varchar(20) NOT NULL,
    lastName varchar(50) NOT NULL,
    position varchar(50) NOT NULL,
    team varchar(50) NOT NULL,
    email varchar(50) NULL
);


CREATE TABLE IF NOT EXISTS taskTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    description text NOT NULL,
    status  ENUM('assigned', 'in_progress', 'resolved', 'reopened', 'closed') NOT NULL,
    requestedBy int NULL,
    assignedBy int NULL,
    assigneeID int NULL,
    FOREIGN KEY(requestedBy) REFERENCES userTable(id) ON DELETE SET NULL,
    FOREIGN KEY(assignedBy) REFERENCES userTable(id) ON DELETE SET NULL,
    FOREIGN KEY(assigneeID) REFERENCES userTable(id) ON DELETE SET NULL
);



