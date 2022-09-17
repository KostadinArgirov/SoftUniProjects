# Exercise 1 Find Book Titles
SELECT title FROM books
WHERE substring(title, 1, 3) = 'The';

# Exercise 2 Replace Titles
SELECT replace(title, 'The', '***') AS Title
FROM books
WHERE title LIKE 'The%';

# Exercise 3 Sum Cost of All Books
SELECT round(sum(cost), 2) 
AS cost
FROM books;

# Exercise 4 Days Lived
SELECT concat(`first_name`, ' ', `last_name`) AS `Full Name`,
timestampdiff(DAY, born, died) AS `Days Lived`
FROM `authors`;

# Exercise 5 Harry Potter Books
SELECT title FROM books
WHERE title LIKE '%Harry_Potter%';