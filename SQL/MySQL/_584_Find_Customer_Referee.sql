-- 584. Find Customer Referee

-- Table: Customer
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | name        | varchar |
-- | referee_id  | int     |
-- +-------------+---------+
-- In SQL, id is the primary key column for this table.
-- Each row of this table indicates the id of a customer, their name, and the id of the customer who referred them.
--
--
-- Find the names of the customer that are not referred by the customer with id = 2.
--
-- Return the result table in any order.
--
-- The result format is in the following example.

-- Example 1:
-- Input:
-- Customer table:
-- +----+------+------------+
-- | id | name | referee_id |
-- +----+------+------------+
-- | 1  | Will | null       |
-- | 2  | Jane | null       |
-- | 3  | Alex | 2          |
-- | 4  | Bill | null       |
-- | 5  | Zack | 1          |
-- | 6  | Mark | 2          |
-- +----+------+------------+
-- Output:
-- +------+
-- | name |
-- +------+
-- | Will |
-- | Jane |
-- | Bill |
-- | Zack |
-- +------+

DROP SCHEMA IF EXISTS db_584_find_customer_referee;
CREATE SCHEMA db_584_find_customer_referee;
USE db_584_find_customer_referee;

CREATE TABLE IF NOT EXISTS Customer
(
    id         INT,
    name       VARCHAR(100),
    referee_id INT,

    PRIMARY KEY (id)
);

INSERT INTO Customer (id, name, referee_id)
VALUES (1, 'Will', NULL),
       (2, 'Jane', NULL),
       (3, 'Alex', 2),
       (4, 'Bill', NULL),
       (5, 'Zack', 1),
       (6, 'Mark', 2);

SELECT name
FROM Customer
WHERE referee_id != 2
   OR referee_id IS NULL;

