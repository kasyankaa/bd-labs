CREATE DATABASE IF NOT EXISTS third_lab
CHARACTER SET utf8
COLLATE utf8_general_ci;
USE third_lab;

DROP TABLE IF EXISTS gps_tracker;
DROP TABLE IF EXISTS automat_data;
DROP TABLE IF EXISTS snack;
DROP TABLE IF EXISTS rest;
DROP TABLE IF EXISTS withdrawing_money_from_automat;
DROP TABLE IF EXISTS updating_automat_with_coins;
DROP TABLE IF EXISTS updating_automat_with_snacks;
DROP TABLE IF EXISTS worker_delivers;
DROP TABLE IF EXISTS snack_automat;
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS delivery;
DROP TABLE IF EXISTS factory;
DROP TABLE IF EXISTS region;
DROP TABLE IF EXISTS country;

-- TABLES -- 
CREATE TABLE country (
	id INT  AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(50) unique
)ENGINE = INNODB;

CREATE TABLE region (
	id INT  AUTO_INCREMENT PRIMARY KEY,
    region_name VARCHAR(50) NOT NULL unique,
    country_name VARCHAR(50) NOT NULL
)ENGINE = INNODB;

CREATE TABLE factory(
	id INT  AUTO_INCREMENT PRIMARY KEY,
    region VARCHAR(50) DEFAULT 'Sandnes' NOT NULL,
    address VARCHAR(200) NOT NULL,
	number_of_workers INT NOT NULL,
    phone_number CHAR(12) NOT NULL
)ENGINE = INNODB;

CREATE TABLE delivery(
	id INT AUTO_INCREMENT PRIMARY KEY,
    factory_id INT NOT NULL,
    car_number VARCHAR(12)
)ENGINE = INNODB;

CREATE TABLE worker_delivers(
	id INT AUTO_INCREMENT PRIMARY KEY,
	delivery_id INT NOT NULL,
	worker_id INT NOT NULL,
    address_of_factory VARCHAR(200) NOT NULL,
    address_of_automat VARCHAR(200) NOT NULL
)ENGINE = INNODB;

CREATE TABLE worker(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL,
    phone_number CHAR(12) NOT NULL
)ENGINE = INNODB;

CREATE TABLE updating_automat_with_snacks(
	id INT AUTO_INCREMENT PRIMARY KEY,
	snack_automat_id INT NOT NULL,
	worker_id INT NOT NULL,
	date_of_updating DATE NOT NULL,
    name_of_snack VARCHAR(50) NOT NULL,
    number_of_snacks INT NOT NULL
)ENGINE = INNODB;

CREATE TABLE updating_automat_with_coins(
	id INT AUTO_INCREMENT PRIMARY KEY,
	snack_automat_id INT NOT NULL,
	worker_id INT NOT NULL,
	date_of_updating DATE NOT NULL,
	sum_of_coins_in_dollars DECIMAL NOT NULL,
    number_of_coins INT NOT NULL
)ENGINE = INNODB;

CREATE TABLE withdrawing_money_from_automat(
	id INT AUTO_INCREMENT PRIMARY KEY,
	snack_automat_id INT NOT NULL,
	worker_id INT NOT NULL,
	date_of_withdrawing DATE NOT NULL,
    sum_of_money_in_dollars DECIMAL NOT NULL
)ENGINE = INNODB;

CREATE TABLE snack_automat(
	id INT AUTO_INCREMENT PRIMARY KEY,
    factory_id INT NOT NULL,
    address VARCHAR(200) NOT NULL,
    name VARCHAR(50) NOT NULL,
    max_number_of_snacks INT NOT NULL
)ENGINE = INNODB;

CREATE TABLE rest(
	id INT AUTO_INCREMENT PRIMARY KEY,
    snack_automat_id INT NOT NULL,
    time DATE NOT NULL,
    name_of_snack VARCHAR(50) NOT NULL,
    number_of_snacks_left INT NOT NULL
)ENGINE = INNODB;

CREATE TABLE snack(
	id INT AUTO_INCREMENT PRIMARY KEY,
    factory_id INT NOT NULL,
    snack_automat_id INT NOT NULL,
    name VARCHAR(50)NOT NULL,
    price_in_dollars DECIMAL NOT NULL,
    mass_in_grams INT NOT NULL,
    calories INT NOT NULL);

CREATE TABLE automat_data(
	id INT AUTO_INCREMENT PRIMARY KEY,
    snack_automat_id INT NOT NULL,
    time_of_sending_data DATETIME NOT NULL);
    
CREATE TABLE gps_tracker(
	id INT AUTO_INCREMENT PRIMARY KEY,
    snack_automat_id INT UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    latitude FLOAT NOT NULL,
    longtitude FLOAT NOT NULL);
    
-- FOREIGN KEYS--

ALTER TABLE region
	ADD CONSTRAINT FK_region_country
	FOREIGN KEY (country_name)
	REFERENCES country(country_name);

ALTER TABLE factory
	ADD CONSTRAINT FK_factory_region
	FOREIGN KEY (region)
	REFERENCES region(region_name);
    
ALTER TABLE delivery
	ADD CONSTRAINT FK_delivery_factory
	FOREIGN KEY (factory_id)
	REFERENCES factory(id);
    
ALTER TABLE worker_delivers
	ADD CONSTRAINT FK_worker_delivers_delivery
	FOREIGN KEY (delivery_id)
	REFERENCES delivery (id),
    ADD CONSTRAINT FK_worker_delivers_worker
	FOREIGN KEY (worker_id)
	REFERENCES worker(id);
    
ALTER TABLE updating_automat_with_snacks
	ADD CONSTRAINT FK_updating_automat_with_snacks_snack_automat
	FOREIGN KEY (snack_automat_id)
	REFERENCES snack_automat (id),
    ADD CONSTRAINT FK_updating_automat_with_snacks_worker
	FOREIGN KEY (worker_id)
	REFERENCES worker(id);
    
ALTER TABLE updating_automat_with_coins
	ADD CONSTRAINT FK_updating_automat_with_coins_snack_automat
	FOREIGN KEY (snack_automat_id)
	REFERENCES snack_automat (id),
    ADD CONSTRAINT FK_updating_automat_with_coins_worker
	FOREIGN KEY (worker_id)
	REFERENCES worker(id);

ALTER TABLE withdrawing_money_from_automat
	ADD CONSTRAINT FK_withdrawing_money_from_automat_snack_automat
	FOREIGN KEY (snack_automat_id)
	REFERENCES snack_automat (id),
    ADD CONSTRAINT FK_withdrawing_money_from_automat_worker
	FOREIGN KEY (worker_id)
	REFERENCES worker(id);

ALTER TABLE snack_automat
	ADD CONSTRAINT FK_snack_automat_factory
	FOREIGN KEY (factory_id)
	REFERENCES factory(id);
    
ALTER TABLE rest
	ADD CONSTRAINT FK_rest_snack_automat
	FOREIGN KEY (snack_automat_id)
	REFERENCES snack_automat(id);

ALTER TABLE snack
	ADD CONSTRAINT FK_snack_factory
	FOREIGN KEY (factory_id)
	REFERENCES factory(id),
    ADD CONSTRAINT FK_snack_snack_automat
    FOREIGN KEY(snack_automat_id)
    REFERENCES snack_automat(id);

ALTER TABLE automat_data
	ADD CONSTRAINT FK_data_snack_automat
	FOREIGN KEY (snack_automat_id)
	REFERENCES snack_automat(id);
    
ALTER TABLE gps_tracker
	ADD CONSTRAINT FK_gps_tracker_snack_automat
	FOREIGN KEY (snack_automat_id)
	REFERENCES snack_automat(id);

-- INSERTION--

INSERT INTO country(country_name) VALUES
('Ukraine'),
('Poland'),
('Germany'),
('France'),
('Italy'),
('China'),
('Japan'),
('USA'),
('Canada'),
('Spain');
INSERT INTO region(region_name, country_name) VALUES
('Lviv','Ukraine'),
('Krakow','Poland'),
('Berlin','Germany'),
('Kyiv','Ukraine'),
('Rome','Italy'),
('Pekin','China'),
('Tokyo','Japan'),
('Portland','USA'),
('Toronto','Canada'),
('Madrid','Spain');
INSERT INTO factory( region, address, number_of_workers, phone_number) VALUES 
('Krakow','Truskawka 21', 34, 878726),
('Krakow','Dzierben 178', 38, 456735),
('Lviv','Gorodotska 234', 30, 101101),
('Kyiv','Shevchenkivska 32', 24, 12221),
('Tokyo','Dzen 453', 12, 2333424),
('Pekin','Sweet Rain 14', 23, 5535677),
('Pekin','Ren Ain 45', 50, 0090039),
('Portland','Blue Air 78', 46, 982916),
('Toronto','Berden 93', 60, 001002003),
('Berlin','Schenen 166', 42, 889880);
INSERT INTO delivery(factory_id, car_number) VALUES 
(5,'H123PC'),
(2,'LM987O'),
(2,'RE2356TY'),
(3,'EU678T'),
(6,'B0000BN'),
(1,'QW9994RT'),
(8,'HU1298UH'),
(7,'WE1256TR'),
(7,'OJ7890GH'),
(9,'QW1234RT');
INSERT INTO worker(name, surname, phone_number) VALUES
 ('Tah','Koen',567892),
 ('Roger','Mal',9088712),
 ('Juan','Silen',4546780),
 ('Taras','Chaikov',098765621),
 ('Haie','Loj',99018802),
 ('Goren','Kwwo',789755),
 ('Gun','Gan',22039020),
 ('Alex','Noen',0981713),
 ('Han','Anders',36378253),
 ('Meh','Keh',889290);
INSERT INTO worker_delivers(delivery_id, worker_id, address_of_factory, address_of_automat) VALUES 
(1, 1, 'Dzen 453','Kwai 34'),
(6, 3, 'Truskawka 21','Klowa 45'),
(4, 4, 'Gorodotska 234','Zamarstynivska 220'),
(6, 3, 'Truskawka 21','Glen 156'),
(8, 2, 'Blue Air 78','Blenden 11'),
(2, 8, 'Dzierben 178','Kremen 66'),
(3, 9, 'Dzierben 178','Lowen 129'),
(5, 10, 'Sweet Rain 14','Tkhan 202'),
(9, 7, 'Ren Ain 45','Dwej 89'),
(4, 4, 'Gorodotska 234','Mazepa 11');
INSERT INTO snack_automat( factory_id, address, name, max_number_of_snacks) VALUES
 (1, 'Klowa 45','FEBO',250),
 (2, 'Glehen 90','FEMO',300),
 (3, 'Franko 88','Grab n Go',175),
 (3, 'Sagaidachny 190','Fast Snacks',200),
 (4, 'Zavodska 122','BEBU',220),
 (5, 'Hjang 312','HJu',150),
 (5, 'Djang 123','Kio',180),
 (6, 'Sweet Caroline 122','KOo',190),
 (8, 'Franklin 120','Green',210),
 (10, 'Nazen 52','Kwarz',250);
INSERT INTO updating_automat_with_snacks(snack_automat_id, worker_id, date_of_updating, name_of_snack, number_of_snacks) VALUES
(1, 1 , "2020-10-01", 'Mars', 6),
(1, 2 , "2020-11-01", 'Roshen', 15),
(1, 3, "2020-10-04", 'Snickers', 5),
(2, 1 , "2020-10-07", 'Nut', 6),
(3, 1 , "2020-10-08", 'Lion', 8),
(4, 1 , "2020-10-09", 'Lays', 89),
(6, 3 , "2020-10-09", 'Chupa Chups', 16),
(8, 5 , "2020-10-09", 'Fitness', 10),
(2, 1 , "2020-10-03", 'Milka', 7),
(3, 9 , "2020-10-04", 'M&M', 25);
INSERT INTO updating_automat_with_coins(snack_automat_id, worker_id , date_of_updating, sum_of_coins_in_dollars, number_of_coins) VALUES 
(1, 1 , "2020-10-01", 45, 600),
(1, 2 , "2020-11-01", 12, 150),
(1, 3, "2020-10-04", 45, 500),
(2, 1 , "2020-10-07", 23, 60),
(3, 1 , "2020-10-08", 45, 80),
(4, 1 , "2020-10-09", 34, 89),
(6, 3 , "2020-10-09", 23, 160),
(8, 5 , "2020-10-09", 14, 100),
(2, 1 , "2020-10-03", 45, 70),
(3, 9 , "2020-10-04", 16, 45);
INSERT INTO withdrawing_money_from_automat(snack_automat_id, worker_id, date_of_withdrawing, sum_of_money_in_dollars) VALUES
(1, 1 , "2020-10-01", 450),
(1, 2 , "2020-11-01", 234),
(1, 3, "2020-10-04", 23),
(2, 1 , "2020-10-07", 90),
(3, 1 , "2020-10-08", 12),
(4, 1 , "2020-10-09", 45),
(6, 3 , "2020-10-09", 134),
(8, 5 , "2020-10-09", 34),
(2, 1 , "2020-10-03", 124),
(3, 9 , "2020-10-04", 34);
INSERT INTO rest(snack_automat_id, time, name_of_snack, number_of_snacks_left) VALUES
(1,"2020-10-01",'Mars',43),
(1,"2020-11-01", 'Milka',80),
(1,"2020-10-04", 'Lays',47),
(2,"2020-10-07", 'Roshen',5),
(3,"2020-10-08", 'Nut',67),
(4,"2020-10-09",'Chupa Chups',7),
(6,"2020-10-09", 'Lion',89),
(8,"2020-10-09", 'Fitness',8),
(2,"2020-10-03", 'Milka',9),
(3,"2020-10-04", 'Lays',10);
INSERT INTO snack(factory_id, snack_automat_id, name, price_in_dollars, mass_in_grams, calories) VALUES 
(1,1,'Lays',3,300,167),
(1,2,'Milka',23,200,200),
(1,3,'Lion',33,150,150),
(2,1,'Nut',13,152,300),
(5,2,'Roshen',5,55,123),
(4,3,'Lays',7,400,145),
(9,1,'Fitness',8,125,100),
(9,6,'Milka',9,300,56),
(1,7,'Mars',8,300,90),
(1,8,'Snickers',6,367,156);
INSERT INTO automat_data(snack_automat_id, time_of_sending_data) VALUES
 (3,"2020-10-01 19:00:00"),
 (4,"2020-10-01 19:00:00"),
 (5,"2020-10-01 19:00:00"),
 (2,"2020-10-01 19:00:00"),
 (1,"2020-10-01 19:00:00"),
 (8,"2020-10-01 19:00:00"),
 (9,"2020-10-01 19:00:00"),
 (10,"2020-10-01 19:00:00"),
 (1,"2020-10-02 19:00:00"),
 (3,"2020-10-04 19:00:00");
INSERT INTO gps_tracker(snack_automat_id, name, latitude, longtitude) VALUES
(5,'H123PC',52.520008,52.520009),
(4,'LM987O',52.720008,50.520008),
(2,'RE2356TY',51.520008,30.520008),
(3,'EU678T',44.520008,11.520008),
(6,'B0000BN',10.35647,45.36472),
(1,'QW9994RT',34.35464,82.65463),
(8,'HU1298UH',89.35645,34.520008),
(7,'WE1256TR',55.46734,34.520008),
(10,'OJ7890GH',55.46734,45.520008),
(9,'QW1234RT',65.46657,11.783848);

-- INDEXES -- 

CREATE INDEX cash
ON withdrawing_money_from_automat (sum_of_money_in_dollars);
CREATE INDEX place_of_automat
ON gps_tracker (latitude,longtitude);




