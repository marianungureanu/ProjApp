CREATE TABLE employee(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100)
);

INSERT INTO employee(name)
VALUES("John Doe");

INSERT INTO employee(name)
VALUES("Mary Poppins");

SELECT* FROM employee;
