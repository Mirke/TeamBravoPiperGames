CREATE DATABASE bravo_Piper_Games;
USE bravo_Piper_Games;

    CREATE TABLE person (
    personID INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    nickname VARCHAR(50),
    address VARCHAR(30) DEFAULT 'not known',
    zipcode INT,
    city VARCHAR(15) DEFAULT 'not known',
    country VARCHAR(15) DEFAULT 'not known',
    e_mail VARCHAR(30) DEFAULT 'not known');

INSERT INTO person (first_name,last_name,nickname,address,zipcode,city,country,e_mail)VALUES
('Alice' ,'Andersson','Chichi', 'Mejramvägen 105', 70223,' Karlstad','Sweden','vikalj@boranora.com'),
('Vera', 'Johansson', 'Nugget','Storgatan 14', 70361,' Karlstad', 'Sweden','nurjatu@hobbymanagement.com'),
('Alma','Karlsson' ,'Teacup', 'Kassörsgatan 8', 69272 ,'Karlstad','Sweden','grafvik@uapemail.com'),
('Selma',' Nilsson','Oldie', 'Vallnäsvägen 3',70358, 'Karlstad','Sweden','5j60wmhy8am@gmailwe.com'),
('Elsa', 'Eriksson', 'Shortie' ,'Byalagsgatan 4G', 70360, 'Karlstad','Sweden','benjaminw329@scatterteam.com' ),
('Lilly','Larsson','Smarty', 'Dammvägen 16B', 70358, 'Karlstad','Sweden','benninater@azithromaxozz.com' ),
('Ella', 'Olsson', 'Kiddo', 'Julsta 12', 69293 ,'Karlstad', 'Sweden','sergtrish@germemembranlar.com'),
('Astrid','Svensson','Boomer', 'Malmgatan 8', 70354 ,'Karlstad','Sweden', 'ladagrn@mymailcr.com'),
('Wilma', 'Persson','Giggles', 'Karlsgatan 28',70341, 'Karlstad','Sweden','whoamicc@elitemotions.com'),
('William','Gustafsson', 'Scout', 'Längbrotorg 9',70366, 'Karlsta','Sweden','aeriest@skillion.org'),
('Liam','Abrahamsson','Smiley', 'Klostergatan 5B', 70361, 'Karlstad','Sweden','jojojo46@imaanpharmacy.com'),
('Hugo', 'Kjellberg','CutiePie', 'Venavägen 25B', 70365, 'Karlstad','Sweden','guliavv@germemembranlar.com'),
('Lucas','Vesterlund',' Sweetums', 'SödraLillåstrand 16', 70364 ,'Karlstad','Sweden','stephen23212110@goliszek.net'),
('Adam','Christensen', 'Dottie', 'Alnängsgatan 9',70362 ,'Karlstad','Sweden','passionique@tipsehat.com') ,
('Oliver', 'Adolfsson','Munchkin', 'Kornellvägen 38A', 70568 ,'Karlstad','Sweden','slowar414@uapemail.com'),
('Matteo','Zetterberg','Mouse', 'Klockarängsvägen 6',70375 ,'Karlstad','Sweden', 'beyoutheitoo@cashbackr.com'),
('Frans','Olander','Boo', 'Ginstvägen 13',70369, 'Karlstad','Sweden','kosarmarina@goliszek.net'),
('Elias','Hagström' ,'Precious', 'HertigKarlsAllé 87',70340, 'Karlstad','Sweden','fn4rg@weinzed.or'),
('Peter','Gren','Greaal', 'Markgatan 56',70368, 'Karlstad','Sweden','belaukica@weinzed.se'),
('Erik','Svan' ,'Croosco', 'Haglundavägen 97',70350, 'Karlstad','Sweden','pvanolden@24hinbox.com');

select * from person;