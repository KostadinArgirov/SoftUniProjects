# CREATE DATABASE restaurant_db;
# DROP DATABASE restaurant_db;
# 1
CREATE TABLE `products` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) UNIQUE NOT NULL,
    `type` VARCHAR(30) NOT NULL,
    `price` DECIMAL(10 , 2 ) NOT NULL
);

CREATE TABLE `clients` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `birthdate` DATE NOT NULL,
    `card` VARCHAR(50),
    `review` TEXT
);

CREATE TABLE `tables` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `floor` INT NOT NULL,
    `reserved` TINYINT(1),
    `capacity` INT NOT NULL
);

CREATE TABLE `waiters` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `phone` VARCHAR(50),
    `salary` DECIMAL(10 , 2 )
);

CREATE TABLE `orders` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `table_id` INT NOT NULL,
    `waiter_id` INT NOT NULL,
    `order_time` TIME NOT NULL,
    `payed_status` TINYINT(1),
    CONSTRAINT fk_orders_table FOREIGN KEY (`table_id`)
		REFERENCES `tables` (`id`),
	CONSTRAINT fk_orders_waiter FOREIGN KEY (`waiter_id`)
		REFERENCES `waiters` (`id`)
);

CREATE TABLE `orders_clients` (
	`order_id` INT,
	`client_id` INT,
    CONSTRAINT fk_orders_clients_orders FOREIGN KEY (`order_id`)
		REFERENCES `orders` (`id`),
    CONSTRAINT fk_orders_clients_clients FOREIGN KEY (`client_id`)
		REFERENCES `clients` (`id`)
);

CREATE TABLE `orders_products` (
	`order_id` INT,
	`product_id` INT,
    CONSTRAINT fk_orders_products_orders FOREIGN KEY (`order_id`)
		REFERENCES `orders` (`id`),
	CONSTRAINT fk_orders_products_products FOREIGN KEY (`product_id`)
		REFERENCES `products` (`id`)
);

# 2

INSERT INTO `products` (`name`, `type`, `price`)
SELECT concat(`last_name` + ' ' + 'specialty'), 'Cocktail', ceil(`salary` * 0.01)
FROM `waiters`
WHERE `id` > 6;

INSERT INTO `products` (`name`, `type`, `price`) 
    SELECT CONCAT_WS(' ', w.`last_name`, 'specialty'), 'Cocktail', CEIL(w.`salary` * 0.01) FROM `waiters` AS w
    WHERE w.`id` > 6;

# 3

UPDATE `orders`
SET `table_id` = `table_id` - 1
WHERE `id` BETWEEN 12 AND 23;

# 4

DELETE w FROM `waiters` AS w
LEFT JOIN `orders` AS o
ON w.`id` = o.`waiter_id`
WHERE o.`id` IS NULL;

# 5

SELECT 
    *
FROM
    `clients`
ORDER BY `birthdate` DESC , `id` DESC;

# 6

SELECT 
    `first_name`, `last_name`, `birthdate`, `review`
FROM
    `clients`
WHERE
    YEAR(`birthdate`) BETWEEN 1978 AND 1993
        AND `card` IS NULL
ORDER BY `last_name` DESC , `id`
LIMIT 5;

# 7

SELECT 
    CONCAT(`last_name`,
            `first_name`,
            CHAR_LENGTH(`first_name`),
            'Restaurant') AS `username`,
    REVERSE(substr(`email`, 2, 12)) AS `password`
FROM
    `waiters`
WHERE
    `salary` IS NOT NULL
ORDER BY `password` DESC;

# 8

SELECT 
    p.`id`,
    p.`name`,
    count(p.`id`) AS `count`
FROM
    `products` AS p
    JOIN `orders_products` AS op ON p.`id` = op.`product_id`
    GROUP BY p.`name`
    HAVING `count` >= 5
    ORDER BY `count` DESC , p.`name`;
    
# 9

SELECT 
    o.`table_id`,
    t.`capacity`,
    COUNT(oc.`order_id`) AS `count_clients`,
    CASE
        WHEN t.`capacity` > COUNT(oc.`order_id`) THEN 'Free seats'
        WHEN t.`capacity` = COUNT(oc.`order_id`) THEN 'Full'
        ELSE 'Extra seats'
    END AS `availability`
FROM
    `tables` t
        JOIN
    `orders` o ON o.`table_id` = t.`id`
        JOIN
    `orders_clients` oc ON o.`id` = oc.`order_id`
WHERE
    t.`floor` = 1
GROUP BY o.`table_id`
ORDER BY o.`table_id` DESC;

# 10

DELIMITER $$
CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))
RETURNS DECIMAL(19, 2)
DETERMINISTIC

BEGIN
RETURN (SELECT SUM(p.`price`) AS `bill`
FROM `products` AS p
JOIN `orders_products` AS op 
ON p.`id` = op.`product_id`
JOIN `orders` AS o 
ON op.`order_id` = o.`id`
JOIN `orders_clients` AS oc
ON o.`id` = oc.`order_id`
JOIN `clients` AS c 
ON oc.`client_id` = c.`id`
WHERE concat(c.`first_name`, ' ', c.`last_name`) = `full_name`);
 

END$$
DELIMITER ;

# 11

DELIMITER $$
CREATE PROCEDURE udp_happy_hour(type VARCHAR(50))
BEGIN
UPDATE `products` p
SET p.`price` = p.`price` * 0.8
WHERE p.`price` >= 10.00 AND p.`type` = type;
END$$