# Exercise 1 Managers
SELECT 
    employee_id,
    CONCAT_WS(' ', e.first_name, e.last_name) AS 'full_name',
    d.department_id,
    d.`name`
FROM
    employees AS e
        RIGHT JOIN
    departments AS d ON d.manager_id = e.employee_id
ORDER BY e.employee_id
LIMIT 5;

# Exercise 2 Towns and Addresses
SELECT 
    t.town_id, t.`name`, a.address_text
FROM
    towns AS t
        INNER JOIN
    addresses AS a ON t.town_id = a.town_id
WHERE
    t.`name` IN ('San Francisco' , 'Sofia', 'Carnation')
ORDER BY t.town_id , a.address_id;

# Exercise 3 Employees Without Managers
SELECT 
    employee_id, first_name, last_name, department_id, salary
FROM
    employees
WHERE
    manager_id IS NULL;
    
# Exercise 4 High Salary
SELECT 
    COUNT(employee_id)
FROM
    employees
WHERE
    salary > (SELECT 
            AVG(salary)
        FROM
            employees);