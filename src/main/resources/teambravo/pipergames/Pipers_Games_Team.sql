-- Run the whole code for getting the Database to work. - Mikael

CREATE DATABASE bravo_Piper_Games;
USE bravo_Piper_Games;

CREATE TABLE game
(
    gameID    INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    game_name VARCHAR(30)

);

INSERT INTO game(game_name)
VALUES ('DOTA'),
       ('APEX'),
       ('OVERWATCH'),
       ('FORTNITE'),
       ('WORLD OF TANKS'),
       ('FIFA 23'),
       ('ROCKET LEAGUE'),
       ('COUNTER STRIKE'),
       ('LEAGUE OF LEGENDS'),
       ('SPLATOON 2');

CREATE TABLE teams
(
    teamID          INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    team_name       VARCHAR(30),
    first_nickname  VARCHAR(50)                    NOT NULL,
    second_nickname VARCHAR(50)                    NOT NULL,
    third_nickname  VARCHAR(50)                    NOT NULL,
    fourth_nickname VARCHAR(50),
    fifth_nickname  VARCHAR(50),
    gameID          INT,
    foreign key (gameID) REFERENCES game (gameID)
);

INSERT INTO teams (team_name, first_nickname, second_nickname, third_nickname, fourth_nickname, fifth_nickname, gameID)
VALUES ('Sharks In Suits', 'Sloppy Nuts', 'Minion', 'Pork Chop', 'Baby Face', 'Tater Tot', '1'),
       ('Neck Breakers', 'Q Tip', 'Cheeseball', 'Barbie', 'Sugar Cube', 'Bee', '1'),
       ('Nuns For Runs', 'Queen', 'Hot Stuff', 'Junior', 'Dude', 'Ride or die', '2'),
       ('Cheeses And Chips', 'Bambi', 'Soul Sister', 'Doc', 'Giggles', 'Bro', '2'),
       ('Cougars', 'Blondie', 'Amigo', 'BFF', 'Bubba Gump', 'Smiley', '3'),
       ('Give_Us_Booze', 'Rambo', 'Buttercup', 'Coach', 'Homegirl', 'Angel', '3'),
       ('OneLifeOneChance', 'Chica', 'Sunshine', 'Couch Potato', 'Good Looking', 'Pumpkin', '4'),
       ('Godsfavouriteteam', 'Dream Girl', 'McDreamy', 'Silly Billy', 'Kitty Cat', 'Prince Charming', '4'),
       ('Miracle Workers', 'hairy', 'Chubby Cheeks', 'Goofy', 'Hotshot', 'Brown Eyes', '5'),
       ('The Honeymoon Is Over', 'Hobbit', 'Babyface', 'Blue Eyes', 'Chunky Monkey', 'Double Trouble', '5');


