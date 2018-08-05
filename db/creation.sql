create database bank;

CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';
GRANT ALL PRIVILEGES ON bank.* TO 'user'@'localhost';

