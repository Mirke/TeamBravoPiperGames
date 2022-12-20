CREATE DATABASE bravo_Piper_Games;
USE bravo_Piper_Games;

CREATE TABLE team(
teamID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
team_name VARCHAR (30),
first_nickname VARCHAR(50) NOT NULL,
second_nickname VARCHAR(50) NOT NULL,
third_nickname VARCHAR(50) NOT NULL,
fourth_nickname VARCHAR(50),
fifth_nickname VARCHAR(50)
);

INSERT INTO team (team_name,first_nickname,second_nickname,third_nickname,fourth_nickname,fifth_nickname)VALUES
('Sharks In Suits','Sloppy Nuts','Minion','Pork Chop','Baby Face','Tater Tot'),
('Neck Breakers','Q Tip','Cheeseball','Barbie','Sugar Cube','Bee'),
('Nuns For Runs','Queen','Hot Stuff','Junior','Dude','Ride or die'),
('Cheeses And Chips','Bambi','Soul Sister','Doc','Giggles','Bro'),
('Cougars','Blondie','Amigo','BFF','Bubba Gump','Smiley','Sugar Cube'),
('Give_Us_Booze','Rambo','Buttercup','Coach','Homegirl','Angel'),
('OneLifeOneChance','Chica','Sunshine','Couch Potato','Good Looking','Pumpkin'),
('Godsfavouriteteam','Dream Girl','McDreamy','Silly Billy','Kitty Cat','Prince Charming'),
('Miracle Workers','hairy','Chubby Cheeks','Goofy','Hotshot','Brown Eyes'),
('The Honeymoon Is Over','Hobbit','Babyface','Blue Eyes','Chunky Monkey','Double Trouble');


