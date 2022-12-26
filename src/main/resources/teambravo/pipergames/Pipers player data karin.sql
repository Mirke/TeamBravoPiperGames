CREATE DATABASE bravo_Piper_Games;
USE bravo_Piper_Games;

DROP DATABASE bravo_Piper_Games;
DROP TABLE player;

CREATE TABLE player (
playerID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
first_name VARCHAR(20),
last_name VARCHAR(20),
nickname VARCHAR(50),
game VARCHAR (30)
);

INSERT INTO player (first_name, last_name, nickname, game) VALUES
('Lilly', 'Larsson', 'Smarty', 'DOTA'),
('Ella', 'Olsson', 'Kiddo', 'APEX'),
('Astrid', 'Svensson', 'Boomer', 'OVERWATCH'),
('Wilma', 'Persson', 'Giggles', 'FORTNITE'),
('William', 'Gustafsson', 'Scout', 'WORLD OF TANKS'),
('Liam', 'Abrahamsson', 'Smiley', 'DOTA'),
('Hugo', 'Kjellberg', 'CutiePie', 'APEX'),
('Lucas', 'Vesterlund', 'Sweetums', 'OVERWATCH'),
('Adam', 'Christensen', 'Dottie', 'FORTNITE'),
('Oliver', 'Adolfsson', 'Munchkin', 'WORLD OF TANKS'),
('Matteo', 'Zetterberg', 'Mouse', 'DOTA'),
('Frans', 'Olander', 'Boo', 'APEX'),
('Elias', 'Hagstrand', 'Precious', 'OVERWATCH'),
('Peter', 'Gren', 'Greaal', 'FORTNITE'),
('Erik', 'Svan', 'Croosco', 'WORLD OF TANKS'),
('Martin', 'Nyborg', 'Sloppy Nuts', 'DOTA'),
('Jonas', 'Smed', 'Q Tip', 'APEX'),
('Angelica', 'Nyström', 'Queen', 'OVERWATCH'),
('Ellen', 'Richardsson', 'Bambi', 'FORTNITE'),
('Ricard', 'Wijk', 'Blondie', 'WORLD OF TANKS'),
('Marcus', 'Lindberg', 'Rambo', 'DOTA'),
('Pontus', 'Lindgren', 'Chica', 'APEX'),
('Kevin', 'Asp', 'Dream Girl', 'OVERWATCH'),
('Nina', 'Ek', 'hairy', 'FORTNITE'),
('Robin', 'Forslund', 'Hobbit', 'WORLD OF TANKS'),
('Kristoffer', 'Hägglund', 'Minion', 'DOTA'),
('Christine', 'Stensbro', 'Cheeseball', 'APEX'),
('Zara', 'Nilsson', 'Hot Stuff', 'OVERWATCH'),
('Maja', 'Berg', 'Soul Sister', 'FORTNITE'),
('Lennart', 'Dahl', 'Amigo', 'WORLD OF TANKS'),
('Gustav', 'Jernberg', 'Buttercup', 'DOTA'),
('Alfred', 'Berg', 'Sunshine', 'APEX'),
('Mikael', 'Svensson', 'McDreamy', 'OVERWATCH'),
('Robert', 'Nygren', 'Chubby Cheeks', 'FORTNITE'),
('Alexandra', 'Murare', 'Sugar Cube', 'WORLD OF TANKS'),
('Tomas', 'Hägg', 'Pork Chop', 'DOTA'),
('Alva', 'Tallmur', 'Barbie', 'APEX'),
('Isak', 'Östman', 'Junior', 'OVERWATCH'),
('Teodor', 'Roos', 'Doc', 'FORTNITE'),
('Ronny', 'Ngenge', 'BFF', 'WORLD OF TANKS'),
('Sebastian', 'Kvist', 'Coach', 'DOTA'),
('John', 'Silver', 'Couch Potato', 'APEX'),
('Felix', 'Andersson', 'Silly Billy', 'OVERWATCH'),
('David', 'Lund', 'Goofy', 'FORTNITE'),
('Noel', 'Persson', 'Blue Eyes', 'WORLD OF TANKS'),
('Henrik', 'Kvist', 'Baby Face', 'DOTA'),
('Niklas', 'Granlöf', 'Sugar Cube', 'APEX'),
('Petra', 'Hede', 'Dude', 'OVERWATCH'),
('Greta', 'Svan', 'Giggles', 'FORTNITE'),
('Viktor', 'Asplund', 'Bubba Gump', 'WORLD OF TANKS'),
('Victoria', 'Torpare', 'Homegirl', 'DOTA'),
('Tova', 'Smed', 'Good Looking', 'APEX'),
('Sixten', 'Bonde', 'Kitty Cat', 'OVERWATCH'),
('Rebecka', 'Ullman', 'Hotshot', 'FORTNITE'),
('Kevin', 'Frost', 'Chunky Monkey', 'WORLD OF TANKS'),
('Karl', 'Axmar', 'Tater Tot', 'DOTA'),
('Lukas', 'Ljung', 'Bee', 'APEX'),
('Tommy', 'Sutare', 'Ride or die', 'OVERWATCH'),
('Johannes', 'Gedda', 'Bro', 'FORTNITE'),
('Peter', 'Nilsson', 'Smiley', 'WORLD OF TANKS'),
('Pia', 'Storm', 'Angel', 'DOTA'),
('Tor', 'Forss', 'Pumpkin', 'APEX'),
('Fredrik', 'Gruvmalm', 'Prince Charming', 'OVERWATCH'),
('Hans', 'Jakobsson', 'Brown Eyes', 'FORTNITE'),
('Nils', 'Sandberg', 'Double Trouble', 'WORLD OF TANKS');