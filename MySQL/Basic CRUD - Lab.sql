# Exercise 1 Select Employee Information
SELECT id, first_name, last_name, job_title
FROM employees
ORDER BY id ASC;

# Exercise 2 Select Employees with Filter
SELECT id, concat(`first_name`, ' ', `last_name`) AS 'Full name', `job_title` AS 'Job title', `salary` AS 'Salary'
FROM employees
WHERE `salary` > 1000
ORDER BY id ASC;

# Exercise 3 Update Salary and Select
UPDATE employees
SET salary = salary + 100
WHERE job_title = 'Manager';

SELECT salary FROM employees;

# Exercise 4 Top Paid Employee
CREATE VIEW `v_top_paid` AS
SELECT * FROM employees
ORDER BY salary DESC
LIMIT 1;

SELECT * FROM `v_top_paid`;

# Exercise 5 Select Employees by Multiple Filters
SELECT * FROM employees
WHERE department_id = 4 AND salary  >= 1000
ORDER BY id;

# Exercise 6 Delete from Table
DELETE FROM employees
WHERE department_id IN (1, 2);

SELECT * FROM employees;