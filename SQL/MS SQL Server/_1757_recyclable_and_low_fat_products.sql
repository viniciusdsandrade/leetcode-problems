USE master;

IF EXISTS (SELECT name
           FROM sys.databases
           WHERE name = N'db_1757')
    DROP DATABASE db_1757;


CREATE DATABASE db_1757;
USE db_1757;

CREATE TABLE Products
(
    product_id INT PRIMARY KEY,
    low_fats   CHAR(1),
    recyclable CHAR(1)
);
GO

INSERT INTO Products (product_id, low_fats, recyclable)
VALUES (0, 'Y', 'N'),
       (1, 'Y', 'Y'),
       (2, 'N', 'Y'),
       (3, 'Y', 'Y'),
       (4, 'N', 'N');


SELECT product_id
FROM Products
WHERE low_fats = 'Y'
  AND recyclable = 'Y';

