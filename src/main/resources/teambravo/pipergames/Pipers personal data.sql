CREATE DATABASE bravo_Piper_Games;
USE bravo_Piper_Games;

CREATE TABLE person (
personID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
first_name VARCHAR(20),
last_name VARCHAR(20),
nickname VARCHAR(50),
address VARCHAR(30) DEFAULT 'not known',
zipcode TINYINT,
city VARCHAR(15) DEFAULT 'not known',
country VARCHAR(15) DEFAULT 'not known',
e_mail VARCHAR(30) DEFAULT 'not known'
);

INSERT INTO person (first_name,last_name,nickname,address,zipcode,city,country,e_mail,player)VALUES
('Alice' ,'Andersson','Chichi', 'Mejramvägen',105, 70223,' Karlstad','Sweden','vikalj@boranora.com'),
('Vera', 'Johansson', 'Nugget','Storgatan',14, 70361,' Karlstad', 'Sweden','nurjatu@hobbymanagement.com'),
('Alma','Karlsson' ,'Teacup', 'Kassörsgatan', 8, 69272 ,'Karlstad','Sweden','grafvik@uapemail.com'),
('Selma',' Nilsson','Oldie', 'Vallnäsvägen', 3,70358, 'Karlstad','Sweden','5j60wmhy8am@gmailwe.com'),
('Elsa', 'Eriksson', 'Shortie' ,'Byalagsgatan', 4G, 70360, 'Karlstad','Sweden','benjaminw329@scatterteam.com' );





