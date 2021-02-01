Use second_lab;
-- Знайдіть номер моделі, тип та ціну для всіх
-- принтерів, вартість яких менше 300 дол. Вивести: model, type, price.
-- Вихідні дані впорядкувати за спаданням за стовпцем type 
SELECT type, model, price
FROM Printer
WHERE price<300
ORDER by type DESC, model , price ;


-- Вивести назви битв, які складаються із двох слів та
-- друге слово не закінчується на літеру 'c'.
SELECT name
FROM Battles
WHERE name RLIKE'.+ .+[^c]$';

-- Для кораблів таблиці Ships вивести країни, яким
-- вони належать.
SELECT name , country, Ships.class
FROM Ships
JOIN Classes 
ON Ships.class = Classes.class;

-- Знайдіть виробників, що випускають ПК, але не
-- ноутбуки (використати ключове слово SOME). Вивести maker.
SELECT maker
FROM Product
WHERE type='PC' and maker <> SOME (SELECT maker FROM Product WHERE type='laptop');

-- За Вашингтонським міжнародним договором від
-- початку 1922 р. заборонялося будувати лінійні кораблі
-- водотоннажністю понад 35 тис. тонн. Вкажіть кораблі, що порушили
-- цей договір (враховувати лише кораблі з відомим спуском на воду,
-- тобто з таблиці Ships). Виведіть: name, launched, displacement.
SELECT name,launched,displacement
FROM Ships
JOIN Classes 
ON Ships.class = Classes.class
WHERE launched>1922 and displacement>35000 and type='bb';

-- Для таблиці PC вивести всю інформацію з
-- коментарями в кожній комірці, наприклад, 'модель: 1121', 'ціна:
-- 600,00' і т.д.
SELECT 
CONCAT("id:",code) as code ,
CONCAT("model:",model) as model,
CONCAT("speed:",speed) as speed, 
CONCAT("ram:",ram) as ram,
CONCAT("hd:",hd) as hd,
CONCAT("cd:",cd) as cd,
CONCAT("price:",price) as price
FROM PC;

-- Вкажіть битви, у яких брало участь, по крайній мірі,
-- два кораблі однієї й тієї ж країни (Вибір країни здійснювати через таб-
-- лицю Ships, а назви кораблів для таблиці Outcomes, що відсутні в таб-
-- лиці Ships, не брати до уваги). Вивести: назву битви, країну, кількість кораблів.
SELECT  battle,country, count(name)
FROM (Ships JOIN Outcomes ON Ships.name = Outcomes.ship) JOIN Classes ON Classes.class = Ships.class
GROUP BY battle
HAVING count(name) >= 2;
 
-- Для кожного виробника знайдіть середній
-- розмір екрану для ноутбуків, що ним випускається. Вивести: maker,
-- середній розмір екрану. (Підказка: використовувати підзапити в
-- якості обчислювальних стовпців)
SELECT maker, type, Product.model, AVG(Laptop.screen) AS average_screen
FROM Product 
JOIN Laptop ON Product.model = Laptop.model
GROUP BY  maker;

-- Визначити назви всіх кораблів із таблиці Ships, які
-- задовольняють, у крайньому випадку, комбінації будь-яких трьох кри-
-- теріїв наступного списку: numGuns=9, bore=16, displacement=46000,
-- type='bb', country='Japan', launched=1916, class='Revenge'. Вивести:
-- name, numGuns, bore, displacement, type, country, launched, class.
-- (Підказка: використати для перевірки умов оператор CASE)
SELECT name, numGuns, bore, displacement, type, country, launched, Ships.class
FROM Ships
JOIN Classes 
ON Ships.class = Classes.class
WHERE 
(CASE WHEN numGuns=9 THEN 1 ELSE 0 END+
CASE WHEN bore=16 THEN 1 ELSE 0 END+
CASE WHEN displacement=46000 THEN 1 ELSE 0 END+
CASE WHEN type='bb' THEN 1 ELSE 0 END+
CASE WHEN country='Japan' THEN 1 ELSE 0 END+
CASE WHEN launched=1916 THEN 1 ELSE 0 END+
CASE WHEN Classes.class='Revenge' THEN 1 ELSE 0 END)>=3;

-- Знайдіть класи, у які входить лише один корабель з
-- усієї БД (врахувати також кораблі в таблиці Outcomes, яких немає в
-- таблиці Ships). Вивести: class. (Підказка: використовувати оператор
-- UNION та операцію EXISTS)
SELECT class, count(name) 
FROM (SELECT Classes.class, name FROM Classes JOIN Ships on Classes.class = Ships.class
UNION
SELECT Classes.class, ship AS name FROM Classes JOIN Outcomes ON Classes.class = Outcomes.ship) as all_ships
GROUP BY class
HAVING count(name) = 1 ;

