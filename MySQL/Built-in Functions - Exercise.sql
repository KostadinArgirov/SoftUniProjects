# Exercise 1 Find Names of All Employees by First Name
SELECT 
    first_name, last_name
FROM
    employees
WHERE
    first_name REGEXP '^Sa'
ORDER BY employee_id;

# Exercise 2 Find Names of All Employees by Last Name
SELECT 
    first_name, last_name
FROM
    employees
WHERE
lower(last_name) LIKE '%ei%'
ORDER BY employee_id;

# Exercise 3 Find First Names of All Employess
SELECT 
    first_name
FROM
    employees
WHERE
    department_id IN (3 , 10)
        AND YEAR(hire_date) BETWEEN 1995 AND 2005
ORDER BY employee_id;

# Exercise 4 Find All Employees Except Engineers
SELECT 
    first_name, last_name
FROM
    employees
WHERE
    NOT LOCATE('engineer', job_title)
ORDER BY employee_id;

# Exercise 5 Find Towns with Name Length
SELECT 
    name
FROM
    towns
WHERE
    CHAR_LENGTH(name) IN (5 , 6)
ORDER BY name;

# Exercise 6 Find Towns Starting With
SELECT 
    `town_id`, `name`
FROM
    `towns`
WHERE
    `name` REGEXP '^[MmKkBbEe]'
ORDER BY `name`;

# Exercise 7 Find Towns Not Starting With
SELECT 
    `town_id`, `name`
FROM
    `towns`
WHERE
    `name` NOT REGEXP '^[RRBbDd]'
ORDER BY `name`;

# Exercise 8 Create View Employees Hired After
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name` FROM `employees`
WHERE year(`hire_date`) > 2000;

SELECT * FROM `v_employees_hired_after_2000`;

# Exercise 9 Length of Last Name
SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    CHAR_LENGTH(`last_name`) = 5;
    
    # Exercise 10 Countries Holding 'A'
SELECT 
    `country_name`, `iso_code`
FROM
    `countries`
WHERE
    CHAR_LENGTH(`country_name`) - CHAR_LENGTH(REPLACE(LOWER(`country_name`), 'a', '')) >= 3
ORDER BY `iso_code`;

# Exercise 11 Mix of Peak and River Names
SELECT 
    p.peak_name,
    r.river_name,
    LOWER(CONCAT(LEFT(p.peak_name,
                        CHAR_LENGTH(p.peak_name) - 1),
                    r.river_name)) AS mix
FROM
    peaks AS p,
    rivers AS r
WHERE
    LOWER(RIGHT(p.peak_name, 1)) = LOWER(LEFT(r.river_name, 1))
ORDER BY mix;

# Exercise 12 Games From 2011 and 2012 Year
SELECT 
    `name`, DATE_FORMAT(`start`, '%Y-%m-%d')
FROM
    `games`
WHERE
    YEAR(`start`) IN (2011 , 2012)
ORDER BY `start` , `name`
LIMIT 50;

# Exercise 13 User Email Providers
SELECT 
    user_name,
    substring(email, locate("@", email) + 1) AS `email provider`
FROM
    users
ORDER BY `email provider` , user_name;

# Exercise 14 Get Users with IP Address Like Pattern
SELECT 
    `user_name`, `ip_address`
FROM
    `users`
WHERE
    ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

# Exercise 15 Show All Games with Duration
SELECT 
    `name` AS 'game',
    CASE
        WHEN HOUR(`start`) < 12 THEN 'Morning'
        WHEN HOUR(`start`) >= 18 THEN 'Evening'
        ELSE 'Afternoon'
    END AS 'Part of the Day',
    CASE
        WHEN `duration` <= 3 THEN 'Extra Short'
        WHEN `duration` BETWEEN 3 AND 6 THEN 'Short'
        WHEN `duration` BETWEEN 7 AND 10 THEN 'Long'
        ELSE 'Extra Long'
    END AS 'Duration'
FROM
    `games`;
    
    # Exercise 16 Orders Table
SELECT 
    `product_name`,
    `order_date`,
    ADDDATE(`order_date`, INTERVAL 3 DAY) AS `pay_due`,
    ADDDATE(`order_date`, INTERVAL 1 MONTH) AS `deliver_due`
FROM
    `orders`;
    