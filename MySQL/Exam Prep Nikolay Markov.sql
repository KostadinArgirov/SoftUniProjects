-- 1.	Table Design
CREATE TABLE countries (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL
);

CREATE TABLE towns (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `country_id` INT NOT NULL,
    CONSTRAINT fk_towns_countries
    FOREIGN KEY (country_id)
	REFERENCES countries(id)
);

CREATE TABLE stadiums (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `capacity` INT NOT NULL,
    `town_id` INT NOT NULL,
    CONSTRAINT fk_stadiums_towns 
    FOREIGN KEY (town_id)
	REFERENCES towns (id)
);

CREATE TABLE teams (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `established` DATE NOT NULL,
    `fan_base` BIGINT(20) NOT NULL DEFAULT(0),
    `stadium_id` INT NOT NULL,
    CONSTRAINT fk_teams_stadiums
	FOREIGN KEY (stadium_id) 
    REFERENCES stadiums(id)
);


CREATE TABLE skills_data (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `dribbling` INT DEFAULT(0),
    `pace` INT DEFAULT(0),
    `passing` INT DEFAULT(0),
    `shooting` INT DEFAULT(0),
    `speed` INT DEFAULT(0),
    `strength` INT DEFAULT(0)
);

CREATE TABLE coaches (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(10) NOT NULL,
    `last_name` VARCHAR(20) NOT NULL,
    `salary` DECIMAL(10, 2) DEFAULT(0),
    `coach_level` INT DEFAULT(0)
);


CREATE TABLE players (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(10) NOT NULL,
    `last_name` VARCHAR(20) NOT NULL,
    `age` INT NOT NULL DEFAULT(0),
    `position` CHAR(1) NOT NULL,
    `salary` DECIMAL(10, 2) DEFAULT(0),
    `hire_date` DATETIME,
    `skills_data_id` INT,
    `team_id` INT,
    CONSTRAINT fk_players_teams 
    FOREIGN KEY (team_id) 
    REFERENCES teams(id),
    CONSTRAINT fk_players_skillsData
	FOREIGN KEY (skills_data_id)
	REFERENCES skills_data(id)
);

CREATE TABLE players_coaches (
    `player_id` INT,
    `coach_id` INT,
    CONSTRAINT fk_players_coaches
    FOREIGN KEY (player_id)
    REFERENCES players(id),
    CONSTRAINT fk_coaches_players 
    FOREIGN KEY (coach_id) 
    REFERENCES coaches(id)
);

-- 2. Insert 
INSERT INTO coaches(first_name, last_name, salary, coach_level) (
    SELECT p.first_name,
    p.last_name, 
    (p.salary * 2) as salary,
    CONCAT(CHAR_LENGTH(p.first_name)) as coach_level
    FROM players AS p
    WHERE p.age >= 45
);

-- 3. Update
UPDATE coaches AS c 
SET 
    c.coach_level = c.coach_level + 1
WHERE
    c.id IN (SELECT 
            coach_id
        FROM
            players_coaches)
        AND first_name LIKE 'A%';
		
-- 4. Delete
DELETE FROM players 
WHERE
    age >= 45;
	
-- 5. Players 
SELECT 
    p.first_name, p.age, p.salary
FROM
    players as p
ORDER BY p.salary DESC;


-- 6. Young offense players without contract
SELECT 
    p.id,
    CONCAT_WS(' ', p.first_name, p.last_name) AS full_name,
    p.age,
    p.position,
    p.hire_date
FROM
    players p
        JOIN
    skills_data sd ON p.skills_data_id = sd.id
WHERE
    p.position = 'A' AND p.hire_date IS NULL
        AND sd.strength > 50
        AND p.age < 23
ORDER BY salary , age;

-- 7. Detail info for all teams
SELECT 
    t.name AS team_name,
    t.established,
    t.fan_base,
    COUNT(p.first_name) AS `players_count`
FROM
    teams AS t
        LEFT JOIN
    players AS p ON t.id = p.team_id
GROUP BY t.id
ORDER BY `players_count` DESC,  t.fan_base DESC;

-- 8. The fastest player by towns
SELECT 
    MAX(sd.speed) AS max_speed,
    tw.name AS town_name
FROM
    skills_data AS sd
        RIGHT JOIN
    players AS p ON p.skills_data_id = sd.id
        RIGHT JOIN
    teams AS t ON t.id = p.team_id
        JOIN
    stadiums AS s ON s.id = t.stadium_id
        RIGHT JOIN
    towns AS tw ON tw.id = s.town_id
WHERE
    t.name != 'Devify'
GROUP BY tw.id
ORDER BY max_speed DESC , town_name ASC;

-- 09. Total salaries and players by country
SELECT 
    c.name AS name,
    COUNT(p.id) AS total_count_of_players,
    SUM(p.salary) AS total_sum_of_salaries
FROM
    countries AS c
        LEFT JOIN
    towns AS t ON c.id = t.country_id
        LEFT JOIN
    stadiums AS s ON t.id = s.town_id
        LEFT JOIN
    teams AS tm ON s.id = tm.stadium_id
        LEFT JOIN
    players AS p ON tm.id = p.team_id
GROUP BY c.id
ORDER BY COUNT(p.id) DESC , c.name;

-- 10. Find all players that play on stadium
DELIMITER $$
CREATE  FUNCTION `udf_stadium_players_count`(stadium_name VARCHAR(30)) RETURNS int deterministic
   
BEGIN

RETURN (select count(p.id) from players as p
RIGHT join teams as t
on t.id = p.team_id
RIGHT join stadiums as s
on s.id = t.stadium_id
where s.name = stadium_name
group by s.id );
END $$
DELIMITER ;


SELECT udf_stadium_players_count('Jaxworks');

-- 11. Find good playmaker by team
DELIMITER $$
CREATE PROCEDURE `udp_find_playmaker` (min_dribble_points INT, team_name VARCHAR(45))

BEGIN

SELECT 
    CONCAT(p.first_name, ' ', p.last_name) AS full_name,
    p.age,
    p.salary,
    sk.dribbling,
    sk.speed,
    tm.name
FROM
    players AS p
        JOIN
    skills_data AS sk ON p.skills_data_id = sk.id
        JOIN
    teams AS tm ON p.team_id = tm.id
        JOIN
    stadiums AS st ON tm.stadium_id = st.id
        JOIN
    towns AS t ON st.town_id = t.id
WHERE
    sk.dribbling > min_dribble_points
        AND tm.name = team_name
        AND sk.speed > (SELECT 
            AVG(speed)
        FROM
            skills_data)
ORDER BY sk.speed DESC
LIMIT 1;

END $$

DELIMITER ;

CALL udp_find_playmaker (20, 'Skyble');