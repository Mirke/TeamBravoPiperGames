CREATE DATABASE bravo_Piper_Games;
USE bravo_Piper_Games;

CREATE TABLE person (
personID INT,
first_name VARCHAR(20),
last_name VARCHAR(20),
nickname VARCHAR(50),
address VARCHAR(30) DEFAULT 'not known',
zipcode TINYINT,
city VARCHAR(15) DEFAULT 'not known',
country VARCHAR(15) DEFAULT 'not known',
e_mail VARCHAR(30) DEFAULT 'not known',
player BOOLEAN DEFAULT true);

INSERT INTO person (first_name,last_name,nickname,address,zipcode,city,country,e_mail,player)VALUES
('Alice' ,'Andersson','Chichi', 'Mejramvägen',105, 70223,' Karlstad','Sweden','vikalj@boranora.com',true),
('Vera', 'Johansson', 'Nugget','Storgatan',14, 70361,' Karlstad', 'Sweden','nurjatu@hobbymanagement.com',true),
('Alma','Karlsson' ,'Teacup', 'Kassörsgatan', 8, 69272 ,'Karlstad','Sweden','grafvik@uapemail.com',true),
('Selma',' Nilsson','Oldie', 'Vallnäsvägen', 3,70358, 'Karlstad','Sweden','5j60wmhy8am@gmailwe.com',true),
('Elsa', 'Eriksson', 'Shortie' ,'Byalagsgatan', 4G, 70360, 'Karlstad','Sweden','benjaminw329@scatterteam.com',true ),
('Lilly','Larsson','Smarty', 'Dammvägen', 16B, 70358, 'Karlstad','Sweden','benninater@azithromaxozz.com',true ),
('Ella', 'Olsson', 'Kiddo', 'Julsta', 12, 69293 ,'Karlstad', 'Sweden','sergtrish@germemembranlar.com',true),
('Astrid','Svensson','Boomer', 'Malmgatan', 8, 70354 ,'Karlstad','Sweden', 'ladagrn@mymailcr.com',true),
('Wilma', 'Persson','Giggles', 'Karlsgatan', 28,70341, 'Karlstad','Sweden','whoamicc@elitemotions.com',true),
('William','Gustafsson', 'Scout', 'Längbrotorg', 9,70366, 'Karlsta','Sweden','aeriest@skillion.org',true),
('Liam','Abrahamsson','Smiley', 'Klostergatan', 5B, 70361, 'Karlstad,Sweden','jojojo46@imaanpharmacy.com',true),
('Hugo', 'Kjellberg','CutiePie', 'Venavägen', 25B, 70365, 'Karlstad','Sweden','guliavv@germemembranlar.com',true),
('Lucas','Vesterlund',' Sweetums', 'SödraLillåstrand', 16, 70364 ,'Karlstad','Sweden','stephen23212110@goliszek.net',true),
('Adam','Christensen', 'Dottie', 'Alnängsgatan', 9,70362 ,'Karlstad','Sweden','passionique@tipsehat.com',true) ,
('Oliver', 'Adolfsson','Munchkin', 'Kornellvägen', 38A, 70568 ,'Karlstad','Sweden','slowar414@uapemail.com',true),
('Matteo','Zetterberg','Mouse', 'Klockarängsvägen',6,70375 ,'Karlstad','Sweden', 'beyoutheitoo@cashbackr.com',true), 
('Frans','Olander','Boo', 'Ginstvägen', 13,70369, 'Karlstad','Sweden','kosarmarina@goliszek.net',true),
('Elias','Hagström' ,'Precious', 'HertigKarlsAllé', 87,70340, 'Karlstad','Sweden','fn4rg@weinzed.or',true),
('Peter','Gren','Greaal', 'markgatan', 56,70368, 'Karlstad','Sweden','belaukica@weinzed.se',true),
('Erik','Svan' ,'Croosco', 'Haglundavägen', 97,70350, 'Karlstad','Sweden','pvanolden@24hinbox.com',true);
