
-- Ejercicio 1
SELECT * 
FROM employees 
WHERE employee_id > 10 
ORDER BY last_name;

-- Ejercicio 2
SELECT last_name, first_name, salary 
FROM employees 
WHERE last_name = 'Whalen';

-- Ejercicio 3
SELECT employee_id, last_name AS "Apellido", first_name AS "Nombre" 
FROM employees 
ORDER BY employee_id DESC;

-- Ejercicio 4
SELECT 
  CONCAT(last_name, ', ', first_name) AS "Apellido y Nombre", 
  hire_date 
FROM employees 
WHERE department_id IN (100, 120) 
ORDER BY salary;

-- Ejercicio 5
SELECT * 
FROM employees 
WHERE last_name LIKE 'A%';

-- Ejercicio 6
SELECT DISTINCT last_name 
FROM employees;

-- Ejercicio 7
SELECT * 
FROM departments 
WHERE department_name = 'IT';

-- Ejercicio 8
SELECT employee_id, last_name, first_name 
FROM employees 
WHERE salary <> 2500;

-- Ejercicio 9
SELECT department_name 
FROM departments 
WHERE department_id BETWEEN 40 AND 100;

-- Ejercicio 10
SELECT * 
FROM employees 
WHERE department_id IS NULL;

-- Ejercicio 11
SELECT employee_id, last_name, first_name 
FROM employees 
WHERE employee_id IN (100, 101);

-- Ejercicio adicional 1
SELECT last_name, salary 
FROM employees 
WHERE salary NOT BETWEEN 5000 AND 12000;

-- Ejercicio adicional 2
SELECT last_name, job_id, hire_date 
FROM employees 
WHERE hire_date BETWEEN '20-02-1998' AND '01-05-1998' 
ORDER BY hire_date ASC;

-- Ejercicio adicional 3
SELECT last_name, job_id 
FROM employees 
WHERE manager_id IS NULL;

-- Ejercicio adicional 4
SELECT last_name 
FROM employees 
WHERE last_name LIKE '%a%' AND last_name LIKE '%e%';
