--zadatak 1
SELECT email, phone_number FROM employees
WHERE department_id IN
(SELECT department_id FROM departments WHERE location_id IN
 (SELECT location_id FROM locations WHERE country_id IN
  (SELECT country_id FROM countries WHERE region_id IN
   (SELECT region_id FROM regions WHERE region_name = 'Europe')))) 
   EXCEPT 
   SELECT email, phone_number FROM employees WHERE phone_number IS NULL;

--zadatak2
SELECT * FROM dependents
WHERE employee_id IN
(SELECT employee_id FROM employees ORDER BY salary DESC LIMIT 1); 


--zadatak 3
SELECT countries.country_name FROM employees
INNER JOIN departments ON departments.department_id = employees.department_id
INNER JOIN locations ON locations.location_id = departments.location_id
INNER JOIN countries ON countries.country_id = locations.country_id 
GROUP BY country_name
ORDER BY SUM(employees.salary) DESC;

