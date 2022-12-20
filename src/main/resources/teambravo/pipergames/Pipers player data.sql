CREATE DATABASE bravo_Piper_Games;
USE bravo_Piper_Games;

CREATE TABLE player (
personID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
first_name VARCHAR(20),
last_name VARCHAR(20),
nickname VARCHAR(50),
address VARCHAR(30) DEFAULT 'not known',
zipcode TINYINT,
city VARCHAR(15) DEFAULT 'not known',
country VARCHAR(15) DEFAULT 'not known',
e_mail VARCHAR(30) DEFAULT 'not known',
players_score INT
);

INSERT INTO player (first_name,last_name,nickname,address,zipcode,city,country,e_mail,player_score)VALUES
('Lilly','Larsson','Smarty', 'Dammvägen', 16B, 70358, 'Karlstad','Sweden','benninater@azithromaxozz.com',0-10),
('Ella', 'Olsson', 'Kiddo', 'Julsta', 12, 69293 ,'Karlstad', 'Sweden','sergtrish@germemembranlar.com',0-10),
('Astrid','Svensson','Boomer', 'Malmgatan', 8, 70354 ,'Karlstad','Sweden', 'ladagrn@mymailcr.com',0-10),
('Wilma', 'Persson','Giggles', 'Karlsgatan', 28,70341, 'Karlstad','Sweden','whoamicc@elitemotions.com',0-10),
('William','Gustafsson', 'Scout', 'Längbrotorg', 9,70366, 'Karlsta','Sweden','aeriest@skillion.org',0-10),
('Liam','Abrahamsson','Smiley', 'Klostergatan', 5B, 70361, 'Karlstad,Sweden','jojojo46@imaanpharmacy.com',0-10),
('Hugo', 'Kjellberg','CutiePie', 'Venavägen', 25B, 70365, 'Karlstad','Sweden','guliavv@germemembranlar.com',0-10),
('Lucas','Vesterlund',' Sweetums', 'SödraLillåstrand', 16, 70364 ,'Karlstad','Sweden','stephen23212110@goliszek.net',0-10),
('Adam','Christensen', 'Dottie', 'Alnängsgatan', 9,70362 ,'Karlstad','Sweden','passionique@tipsehat.com',0-10) ,
('Oliver', 'Adolfsson','Munchkin', 'Kornellvägen', 38A, 70568 ,'Karlstad','Sweden','slowar414@uapemail.com',0-10),
('Matteo','Zetterberg','Mouse', 'Klockarängsvägen',6,70375 ,'Karlstad','Sweden', 'beyoutheitoo@cashbackr.com',0-10), 
('Frans','Olander','Boo', 'Ginstvägen', 13,70369, 'Karlstad','Sweden','kosarmarina@goliszek.net',0-10),
('Elias','Hagström' ,'Precious', 'HertigKarlsAllé', 87,70340, 'Karlstad','Sweden','fn4rg@weinzed.org',0-10),
('Peter','Gren','Greaal', 'markgatan', 56,70368, 'Karlstad','Sweden','belaukica@weinzed.se',0-10),
('Erik','Svan' ,'Croosco', 'Haglundavägen', 97,70350, 'Karlstad','Sweden','pvanolden@24hinbox.com',0-10);

