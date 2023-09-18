
-- СТВОРЕННЯ БАЗИ ДАНИХ
-- Можливість створення БД з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Тут, БД створюємо через візуальний інструмент, наприклад,
-- MySQL Workbench.
CREATE DATABASE demo_db;

-- СТВОРЕННЯ ТАБЛИЦ ---
-- Можливість створення таблиць БД, з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Попередньо, необхідно спроектувати таблиці та їх зв'язки,
-- на основі сутностей реального світу.
-- Тут, таблиці БД створюємо через візуальний інструмент, наприклад,
-- MySQL Workbench.

-- Таблиця посад персоналу.
-- Робимо перелік необхідних посад в окремій таблиці.
-- У різних працівників може бути одна посада.
-- Можна легко редагувати значення (за потреби).
CREATE TABLE IF NOT EXISTS positions
( id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

-- Внесення даних до таблиці посад
INSERT INTO positions (name) VALUES (?);

-- Вибірка посад
SELECT * FROM positions;

-- Таблиця працівників
CREATE TABLE IF NOT EXISTS employees
( id INTEGER NOT NULL AUTO_INCREMENT,
  last_name VARCHAR(128) NOT NULL,
  first_name VARCHAR(128) NOT NULL,
  birth_date DATE NOT NULL,
  position_id INTEGER NOT NULL,
  phone VARCHAR(32) NOT NULL,
  salary DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (position_id) REFERENCES positions(id)
);

-- Внесення даних до таблиці працівників
INSERT INTO employees (last_name, first_name, birth_date, position_id, phone, salary)
VALUES (?, ?, ?, ?, ?, ?);

-- Вибірка працівників
SELECT * FROM employees e
INNER JOIN positions p ON e.position_id = p.id;

