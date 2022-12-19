CREATE DATABASE bravo_Piper_Games;
USE bravo_Piper_Games;

CREATE TABLE staff(
 staff_id INT PRIMARY KEY AUTO_INCREMENT,
 first_name VARCHAR(20) NOT NULL,
 last_name VARCHAR(20) NOT NULL,
 staff_nickname VARCHAR(30) NOT NULL, 
 address VARCHAR(40) DEFAULT 'Unknown',
 zipcode TINYINT DEFAULT '0', 
 city VARCHAR (20) DEFAULT 'Unknown', 
 country VARCHAR (20) DEFAULT 'Unknown',
 email VARCHAR(40) 
);
 
INSERT INTO staff (first_name, last_name, staff_nickname, address, city, country, email) VALUES
('Carla', 'Walton', 'Smarty', 'Storgatan 3', 'Stockholm', 'Sweden', 'CarlaWalton@gmail.com'),
('Ron', 'LaFlamme', 'Flamme', 'Kungsgatan 5', 'Stockholm', 'Sweden', 'RonLaFlamme@gmail.com'),
('Nelson', 'Bighetti', 'BigHead', 'Kungsholmsstrand 9', 'Stockholm', 'Sweden', 'Bighetti.Nelson@gmail.com'),
('Monica', 'Hall', 'Bee', 'Angelgatan 32', 'Stockholm', 'Sweden', 'Monica.B.Hall@gmail.com'),
('Erlich', 'Bachman', 'Ace', 'Badhusgatan 4', 'Stockholm', 'Sweden', 'Bachman.Erlich@gmail.com');
 
 
SELECT * FROM staff;
DESCRIBE staff;

#visa, lägga till, ändra och ta bort personal (Pied piper anställda som ska kunna hantera applikationen)