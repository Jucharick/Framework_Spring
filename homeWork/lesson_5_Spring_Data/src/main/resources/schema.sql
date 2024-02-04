
CREATE TABLE IF NOT EXISTS tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    description text NOT NULL,
    status varchar(50) NOT NULL,
    requested_by int NULL,
    assigned_by int NULL,
    assigneeID int NULL
);


