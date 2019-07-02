CREATE DATABASE if not exists projappdb;

CREATE USER 'projapp'@'localhost' IDENTIFIED BY 'projappPass';
GRANT ALL PRIVILEGES ON projappdb.* TO 'projapp'@'localhost';

FLUSH PRIVILEGES;
