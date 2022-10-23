# DROP SCHEMA sgd;
# CREATE DATABASE sgd;
# USE sgd;

# 1 Table Design

CREATE TABLE addresses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL
);

CREATE TABLE offices (
    id INT PRIMARY KEY AUTO_INCREMENT,
    workspace_capacity INT NOT NULL,
    website VARCHAR(50),
    address_id INT NOT NULL,
    CONSTRAINT fk_offices_addresses FOREIGN KEY (address_id)
        REFERENCES addresses (id)
);

CREATE TABLE employees (
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    age INT NOT NULL,
    salary DECIMAL(10 , 2 ) NOT NULL,
    job_title VARCHAR(20) NOT NULL,
    happiness_level CHAR(1) NOT NULL
);

CREATE TABLE teams (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    office_id INT NOT NULL,
    leader_id INT UNIQUE NOT NULL,
    CONSTRAINT fk_teams_offices FOREIGN KEY (office_id)
		REFERENCES offices (id),
	CONSTRAINT fk_teams_employees FOREIGN KEY (leader_id)
		REFERENCES employees (id)
);

CREATE TABLE games (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    description TEXT,
    rating FLOAT NOT NULL DEFAULT 5.5,
    budget DECIMAL(10 , 2 ) NOT NULL,
    release_date DATE,
    team_id INT NOT NULL,
    CONSTRAINT fk_games_teams FOREIGN KEY (team_id)
		REFERENCES teams (id)
);

CREATE TABLE games_categories (
    game_id INT NOT NULL,
    category_id INT NOT NULL,
    CONSTRAINT pk_games_categories PRIMARY KEY (game_id, category_id),
    CONSTRAINT fk_games_categories_games FOREIGN KEY (game_id)
        REFERENCES games (id),
    CONSTRAINT fk_games_categories_categories FOREIGN KEY (category_id)
        REFERENCES categories (id)
);

# 2 Insert

INSERT INTO `games` (`name`, `rating` , `budget`, `team_id`)
SELECT lower(reverse(substr(`name`, 2))), `id`, `leader_id` * 1000, `id`
FROM `teams`
WHERE `id` BETWEEN 1 AND 9;

# 3 Update

UPDATE `employees` AS e
        LEFT JOIN
    `teams` AS t ON e.`id` = t.`leader_id` 
SET 
    e.`salary` = e.`salary` + 1000
WHERE
    t.`leader_id` IS NOT NULL
        AND e.`age` <= 40
        AND e.`salary` < 5000;
        
# 4 Delete

DELETE g FROM `games` AS g
        LEFT JOIN
    `games_categories` AS gc ON g.`id` = gc.`game_id` 
WHERE
    gc.`category_id` IS NULL
    AND g.`release_date` IS NULL;

# 5 Employees

SELECT 
    `first_name`,
    `last_name`,
    `age`,
    `salary`,
    `happiness_level`
FROM
    `employees`
ORDER BY `salary` , `id`;

# 6 Addresses of the teams

SELECT 
    t.`name` AS `team_name`,
    a.`name` AS `address_name`,
    CHAR_LENGTH(a.`name`) AS `count_of_characters`
FROM
    `teams` AS t
        JOIN
    `offices` AS o ON t.`office_id` = o.`id`
        JOIN
    `addresses` AS a ON o.`address_id` = a.`id`
WHERE
    o.`website` IS NOT NULL
ORDER BY t.`name` , a.`name`;

# 7 Categories Info

SELECT 
    c.`name`,
    COUNT(gc.`game_id`) AS `games_count`,
    ROUND(AVG(g.`budget`), 2) AS `avg_budget`,
    MAX(g.`rating`) AS `max_rating`
FROM
    `games` AS g
        JOIN
    `games_categories` AS gc ON gc.`game_id` = g.`id`
        JOIN
    `categories` AS c ON gc.`category_id` = c.`id`
GROUP BY c.`id`
HAVING `max_rating` >= 9.5
ORDER BY `games_count` DESC , c.`name`;

# 8 Games of 2022

SELECT 
    g.`name`,
    g.`release_date`,
    CONCAT(LEFT(g.`description`, 10), '...') AS `summary`,
    CASE
        WHEN MONTH(g.`release_date`) BETWEEN 1 AND 3 THEN 'Q1'
        WHEN MONTH(g.`release_date`) BETWEEN 4 AND 6 THEN 'Q2'
        WHEN MONTH(g.`release_date`) BETWEEN 7 AND 9 THEN 'Q3'
        ELSE 'Q4'
    END AS `quarter`,
    t.`name` AS `team_name`
FROM
    `games` AS g
        JOIN
    `teams` AS t ON g.`team_id` = t.`id`
WHERE
    RIGHT(g.`name`, 1) = '2'
        AND YEAR(g.`release_date`) = 2022
        AND MONTH(g.`release_date`) % 2 = 0
ORDER BY `quarter`;

# 9 Full info for games

SELECT 
    g.`name`,
    IF(g.`budget` < 50000,
        'Normal budget',
        'Insufficient budget') AS `budget_level`,
    t.`name`,
    a.`name`
FROM
    `games` AS g
        LEFT JOIN
    `games_categories` AS gc ON gc.`game_id` = g.`id`
        JOIN
    `teams` AS t ON g.`team_id` = t.`id`
        JOIN
    `offices` AS o ON t.`office_id` = o.`id`
        JOIN
    `addresses` AS a ON o.`address_id` = a.`id`
WHERE
    g.`release_date` IS NULL
        AND gc.`category_id` IS NULL
ORDER BY g.`name`;

# 10 Find all basic information for a game

DELIMITER $$
CREATE FUNCTION udf_game_info_by_name (game_name VARCHAR (20))
RETURNS VARCHAR(255)
DETERMINISTIC
BEGIN
	DECLARE info VARCHAR (255);
	DECLARE team_name VARCHAR (40);
	DECLARE address_text VARCHAR (50);
	
	SET team_name := (SELECT t.`name`
        	FROM teams AS t 
        	JOIN games AS g 
        	ON g.team_id = t.id 
        	WHERE g.`name` = game_name);
	
  	SET address_text := (SELECT a.`name`
        	FROM addresses AS a
        	JOIN offices AS o
        	ON a.id = o.address_id
        	JOIN teams AS t
        	ON o.id = t.office_id
        	WHERE t.`name` = team_name);
    
  	SET info := concat_ws(' ', 'The', game_name, 'is developed by a', team_name, 'in an office with an address', address_text);
  	RETURN info;
END$$
DELIMITER ;

# 11 Update Budget of the Games

DELIMITER $$
CREATE PROCEDURE udp_update_budget (min_game_rating FLOAT)
BEGIN
	UPDATE games AS g
	LEFT JOIN games_categories AS c
    	ON g.id = c.game_id
    	SET g.budget = g.budget + 100000, 
		g.release_date = adddate(g.release_date, INTERVAL 1 YEAR)
	WHERE c.category_id IS NULL 
		AND g.release_date IS NOT NULL 
		AND g.rating > min_game_rating;
END$$
DELIMITER ;