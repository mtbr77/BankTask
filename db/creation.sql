create database bank;

CREATE USER 'user1'@'localhost' IDENTIFIED BY 'user1';
GRANT ALL PRIVILEGES ON bank.* TO 'user1'@'localhost';

