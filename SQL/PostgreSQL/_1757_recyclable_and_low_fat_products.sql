CREATE TABLE IF NOT EXISTS Products
(
    product_id INT PRIMARY KEY,
    low_fats   BOOLEAN,
    recyclable BOOLEAN
);

INSERT INTO Products (product_id, low_fats, recyclable)
VALUES (0, TRUE, FALSE),
       (1, TRUE, TRUE),
       (2, FALSE, TRUE),
       (3, TRUE, TRUE),
       (4, FALSE, FALSE);

SELECT product_id
FROM Products
WHERE low_fats = TRUE
  AND recyclable = TRUE;
