CREATE DATABASE bravo_Piper_Games;
USE bravo_Piper_Games;

CREATE TABLE teams
(
    teamID          INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    team_name       VARCHAR(30),
    first_nickname  VARCHAR(50)                    NOT NULL,
    second_nickname VARCHAR(50)                    NOT NULL,
    third_nickname  VARCHAR(50)                    NOT NULL,
    fourth_nickname VARCHAR(50),
    fifth_nickname  VARCHAR(50),
    game            VARCHAR(50)
);

INSERT INTO teams (team_name, first_nickname, second_nickname, third_nickname, fourth_nickname, fifth_nickname)
VALUES ('Sharks In Suits', 'Sloppy Nuts', 'Minion', 'Pork Chop', 'Baby Face', 'Tater Tot'),
       ('Neck Breakers', 'Q Tip', 'Cheeseball', 'Barbie', 'Sugar Cube', 'Bee'),
       ('Nuns For Runs', 'Queen', 'Hot Stuff', 'Junior', 'Dude', 'Ride or die'),
       ('Cheeses And Chips', 'Bambi', 'Soul Sister', 'Doc', 'Giggles', 'Bro'),
       ('Cougars', 'Blondie', 'Amigo', 'BFF', 'Bubba Gump', 'Smiley'),
       ('Give_Us_Booze', 'Rambo', 'Buttercup', 'Coach', 'Homegirl', 'Angel'),
       ('OneLifeOneChance', 'Chica', 'Sunshine', 'Couch Potato', 'Good Looking', 'Pumpkin'),
       ('Godsfavouriteteam', 'Dream Girl', 'McDreamy', 'Silly Billy', 'Kitty Cat', 'Prince Charming'),
       ('Miracle Workers', 'hairy', 'Chubby Cheeks', 'Goofy', 'Hotshot', 'Brown Eyes'),
       ('The Honeymoon Is Over', 'Hobbit', 'Babyface', 'Blue Eyes', 'Chunky Monkey', 'Double Trouble');

INSERT INTO teams (team_name, first_nickname, second_nickname, third_nickname, fourth_nickname, fifth_nickname, game)
VALUES ('Sharks In Suits', 'Sloppy Nuts', 'Minion', 'Pork Chop', 'Baby Face', 'Tater Tot','DOTA'),
       ('Neck Breakers', 'Q Tip', 'Cheeseball', 'Barbie', 'Sugar Cube', 'Bee','CS'),
       ('Nuns For Runs', 'Queen', 'Hot Stuff', 'Junior', 'Dude', 'Ride or die','LOL'),
       ('Cheeses And Chips', 'Bambi', 'Soul Sister', 'Doc', 'Giggles', 'Bro','VALORANT'),
       ('Cougars', 'Blondie', 'Amigo', 'BFF', 'Bubba Gump', 'Smiley','SPLATOON 2'),
       ('Give_Us_Booze', 'Rambo', 'Buttercup', 'Coach', 'Homegirl', 'Angel','FORTNITE'),
       ('OneLifeOneChance', 'Chica', 'Sunshine', 'Couch Potato', 'Good Looking', 'Pumpkin', 'FIFA 23'),
       ('Godsfavouriteteam', 'Dream Girl', 'McDreamy', 'Silly Billy', 'Kitty Cat', 'Prince Charming','WORLD OF TANKS'),
       ('Miracle Workers', 'hairy', 'Chubby Cheeks', 'Goofy', 'Hotshot', 'Brown Eyes','ROCKET LEAGUE'),
       ('The Honeymoon Is Over', 'Hobbit', 'Babyface', 'Blue Eyes', 'Chunky Monkey', 'Double Trouble','APEX');

-- Example Database over games USED FOR TESTING FOREIGN KEY

create table game (
                      gameID int primary key not null auto_increment,
                      name VARCHAR(40)
);

insert into game (name) value
    ('DOTA'),
    ('CS'),
    ('LOL'),
    ('VALORANT'),
    ('SPLATOON 2'),
    ('FORTNITE'),
    ('FIFA 23'),
    ('WORLD OF TANKS'),
    ('ROCKET LEAGUE'),
    ('APEX');