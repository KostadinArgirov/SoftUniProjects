-- Problem 1:
CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
first_name VARCHAR(50),
last_name VARCHAR(50)
);
CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
name VARCHAR(50) NOT NULL
);
CREATE TABLE products (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
name VARCHAR(50) NOT NULL,
category_id INT NOT NULL
);

-- Problem 2:
INSERT INTO `employees` (`first_name`, `last_name`)
VALUES 
('Test', 'Test'),
('Test1', 'Test1'),
('Test2', 'Test2');

-- Problem 3:
ALTER TABLE `employees` 
ADD COLUMN `middle_name` VARCHAR(45);

-- Problem 4:
ALTER TABLE `products`
ADD CONSTRAINT fk_products_categories
FOREIGN KEY `products`(`category_id`)
REFERENCES `categories`(`id`);

-- Problem 5:
ALTER TABLE `employees`
CHANGE COLUMN `middle_name` `middle_name` VARCHAR(100);