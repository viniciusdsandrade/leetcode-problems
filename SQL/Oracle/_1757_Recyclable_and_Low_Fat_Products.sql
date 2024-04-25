-- 1757. Recyclable and Low Fat Products
--
-- Table: Products
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | product_id  | int     |
-- | low_fats    | enum    |
-- | recyclable  | enum    |
-- +-------------+---------+
--  product_id is the primary key (column with unique values) for this table.
--  low_fats is an ENUM (category) of type ('Y', 'N') where 'Y' means this product is low fat and 'N' means it is not.
--  recyclable is an ENUM (category) of types ('Y', 'N') where 'Y' means this product is recyclable and 'N' means it is not.
--
--  Write a solution to find the ids of products that are both low fat and recyclable.
--  Return the result table in any order
--  The result format is in the following example.
--
--  Example 1:
--  Input:
--  Products table:
--  +-------------+----------+------------+
--  | product_id  | low_fats | recyclable |
--  +-------------+----------+------------+
--  | 0           | Y        | N          |
--  | 1           | Y        | Y          |
--  | 2           | N        | Y          |
--  | 3           | Y        | Y          |
--  | 4           | N        | N          |
--  +-------------+----------+------------+

--  Output:
--  +-------------+
--  | product_id  |
--  +-------------+
--  | 1           |
--  | 3           |
--  +-------------+
--  Explanation: Only products 1 and 3 are both low fat and recyclable.


BEGIN
    EXECUTE IMMEDIATE 'DROP USER db_1757_recyclable_and_low_fat_products CASCADE';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -1918 THEN
            RAISE;
        END IF;
END;
/

CREATE USER db_1757_recyclable_and_low_fat_products IDENTIFIED BY your_password;
GRANT CONNECT, RESOURCE TO db_1757_recyclable_and_low_fat_products;
GRANT UNLIMITED TABLESPACE TO db_1757_recyclable_and_low_fat_products;

CREATE TABLE db_1757_recyclable_and_low_fat_products.Products
(
    product_id INT PRIMARY KEY,
    low_fats   CHAR(1) CHECK (low_fats IN ('Y', 'N')),
    recyclable CHAR(1) CHECK (recyclable IN ('Y', 'N'))
);

INSERT INTO db_1757_recyclable_and_low_fat_products.Products (product_id, low_fats, recyclable)
VALUES (0, 'Y', 'N') ,
    (1, 'Y', 'Y')
    ,
    (2, 'N', 'Y')
    ,
    (3, 'Y', 'Y')
    ,
    (4, 'N', 'N');

SELECT product_id
FROM db_1757_recyclable_and_low_fat_products.Products
WHERE low_fats = 'Y'
  AND recyclable = 'Y';

