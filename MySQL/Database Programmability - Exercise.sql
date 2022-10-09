# Exercise 1 Employees with Salary Above 35000 
CREATE PROCEDURE usp_get_employees_salary_above_35000() 
BEGIN
	SELECT first_name, last_name
	FROM employees
    WHERE salary > 35000
    ORDER BY first_name, last_name;
END

# Exercise 2 Employees with Salary Above Number
CREATE PROCEDURE usp_get_employees_salary_above(salary_above DECIMAL (11, 4)) 
BEGIN
	SELECT first_name, last_name
	FROM employees
    WHERE salary >= salary_above
    ORDER BY first_name, last_name;
END

# Exercise 3 Town Names Starting With
CREATE PROCEDURE usp_get_towns_starting_with(started_with VARCHAR (50)) 
BEGIN
    SELECT `name`
	FROM towns
    WHERE lower(`name`) LIKE lower(concat(started_with, '%'))
    ORDER BY `name`;
END

# Exercise 4 Employees from Town 
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR (50)) 
BEGIN
    SELECT first_name, last_name
	FROM employees 
    JOIN addresses USING (address_id)
    JOIN towns AS t USING (town_id)
    WHERE t.`name` LIKE town_name
    ORDER BY first_name, last_name;
END

# Exercise 5 Salary Level Function 
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
RETURNS VARCHAR(8)
DETERMINISTIC
BEGIN
	DECLARE salary_level VARCHAR(8);
    IF salary < 30000 THEN SET salary_level := 'Low';
    ELSEIF salary <= 50000 THEN SET salary_level := 'Average';
	ELSE SET salary_level := 'High';
    END IF;
    RETURN salary_level;
END

# Exercise 6 Employees by Salary Level 
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
RETURNS VARCHAR(8)
DETERMINISTIC
BEGIN
	DECLARE salary_level VARCHAR(8);
    IF salary < 30000 THEN SET salary_level := 'Low';
    ELSEIF salary <= 50000 THEN SET salary_level := 'Average';
	ELSE SET salary_level := 'High';
    END IF;
    RETURN salary_level;
END;

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(8)) 
BEGIN
	SELECT first_name, last_name
	FROM employees
    WHERE ufn_get_salary_level(salary) LIKE salary_level
    ORDER BY first_name DESC, last_name DESC;
END;

# Exercise 7 Define Function
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS INTEGER
DETERMINISTIC
BEGIN
	RETURN REGEXP_LIKE(lower(word), CONCAT('^[', lower(set_of_letters), ']+$'));
END

# Exercise 8 Find Full Name
CREATE PROCEDURE usp_get_holders_full_name () 
BEGIN
	SELECT concat_ws(' ', first_name, last_name) AS full_name
	FROM account_holders
    ORDER BY full_name;
END

# Exercise 9 People with Balance Higher Than
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(balance DECIMAL(12, 4)) 
BEGIN
	SELECT first_name, last_name
	FROM account_holders AS h
    LEFT JOIN accounts AS a
    ON h.id = a.account_holder_id
	GROUP BY first_name, last_name
    HAVING sum(a.balance) > balance;
END

# Exercise 10 Future Value Function
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19, 4), yearly_interest DOUBLE, yers INT)
RETURNS DECIMAL(19, 4)
DETERMINISTIC
BEGIN
	DECLARE future_sum DECIMAL(19, 4);
    SET future_sum := sum * pow(1 + yearly_interest, yers);
    RETURN future_sum;
END

# Exercise 11 Calculating Interest
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19, 4), yearly_interest DECIMAL(19, 4), yers INT)
RETURNS DECIMAL(19, 4)
DETERMINISTIC
BEGIN
	DECLARE future_sum DECIMAL(19, 4);
    SET future_sum := sum * pow(1 + yearly_interest, yers);
    RETURN future_sum;
END;

CREATE PROCEDURE usp_calculate_future_value_for_account(id INT, interest DECIMAL(19, 4)) 
BEGIN
	SELECT a.id, first_name, last_name, a.balance AS current_balance, ufn_calculate_future_value(a.balance, interest, 5) AS balance_in_5_years
	FROM account_holders AS h
    LEFT JOIN accounts AS a
    ON h.id = a.account_holder_id
    WHERE a.id = id;
END;

# Exercise 12 Deposit Money
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
	START TRANSACTION;
		IF (money_amount <= 0) THEN
    ROLLBACK;
		ELSE
			UPDATE accounts
            SET balance = balance + money_amount
            WHERE id = account_id;
			COMMIT;
        END IF;	
END

# Exercise 13 Withdraw Money
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
	START TRANSACTION;
		IF (money_amount <= 0 OR (SELECT balance FROM accounts WHERE id = account_id) < money_amount) THEN
    ROLLBACK;
		ELSE
			UPDATE accounts
            SET balance = balance - money_amount
            WHERE id = account_id;
        END IF;	
END

# Exercise 14 Money Transfer
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT , amount DECIMAL(19, 4))
BEGIN
	START TRANSACTION;
		IF (amount <= 0 
				OR (SELECT balance FROM accounts WHERE id = from_account_id) < amount
                OR (SELECT count(id) FROM accounts WHERE id = from_account_id) <> 1
                OR (SELECT count(id) FROM accounts WHERE id = to_account_id) <> 1
                OR from_account_id = to_account_id) THEN
    ROLLBACK;
		ELSE
			UPDATE accounts
            SET balance = balance - amount
            WHERE id = from_account_id;
		
			UPDATE accounts
            SET balance = balance + amount
            WHERE id = to_account_id;
            COMMIT;
        END IF;	
END

# Exercise 15 Log Accounts Trigger
CREATE TABLE `logs`(
log_id INT PRIMARY KEY AUTO_INCREMENT, 
account_id INT NOT NULL,
old_sum DECIMAL(19, 4) NOT NULL,
new_sum DECIMAL(19, 4) NOT NULL);

CREATE TRIGGER tr_change_balance
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO `logs`(account_id, old_sum, new_sum) 
	VALUES (OLD.id, OLD.balance, NEW.balance);
END;

# Exercise 16 Emails Trigger
CREATE TABLE `logs`(
log_id INT PRIMARY KEY AUTO_INCREMENT, 
account_id INT NOT NULL,
old_sum DECIMAL(19, 4) NOT NULL,
new_sum DECIMAL(19, 4) NOT NULL);

CREATE TRIGGER tr_change_balance
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO `logs`(account_id, old_sum, new_sum) 
	VALUES (OLD.id, OLD.balance, NEW.balance);
END;

CREATE TABLE notification_emails(
id INT PRIMARY KEY AUTO_INCREMENT, 
recipient INT NOT NULL,
`subject` TEXT,
body TEXT);

CREATE TRIGGER tr_email_on_change_balance
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails(recipient, `subject`, body)
	VALUES (NEW.account_id, concat_ws(' ', 'Balance change for account:', NEW.account_id), concat_ws(' ', 'On', NOW(), 'your balance was changed from', NEW.old_sum, 'to', NEW.new_sum, '.'));
END;