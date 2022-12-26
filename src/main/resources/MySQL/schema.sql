-- --------------------------------------------------------------------------------------------------------------------

CREATE DATABASE IF NOT EXISTS bravo_Piper_Games;
USE bravo_Piper_Games;

-- --------------------------------------------------------------------------------------------------------------------
-- PLAYER START
CREATE TABLE IF NOT EXISTS player
(
    playerID   INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20),
    last_name  VARCHAR(20),
    nickname   VARCHAR(50),
    address    VARCHAR(30) DEFAULT 'not known',
    zipcode    INT,
    city       VARCHAR(15) DEFAULT 'not known',
    country    VARCHAR(15) DEFAULT 'not known',
    e_mail     VARCHAR(30) DEFAULT 'not known'
);

-- PLAYER END
-- --------------------------------------------------------------------------------------------------------------------
-- STAFF START

CREATE TABLE IF NOT EXISTS staff
(
    staffID  INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    playerID INT,
    FOREIGN KEY (playerID) REFERENCES player (playerID) ON DELETE SET NULL
);

-- STAFF END
-- --------------------------------------------------------------------------------------------------------------------
-- GAME START

CREATE TABLE IF NOT EXISTS game
(
    gameID    INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    game_name VARCHAR(30),
    playerID  INT,
    FOREIGN KEY (playerID) REFERENCES player (playerID) ON DELETE SET NULL

);

-- GAME END
-- --------------------------------------------------------------------------------------------------------------------
-- TEAM START

CREATE TABLE IF NOT EXISTS team
(
    teamID          INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    team_name       VARCHAR(30),
    first_nickname  VARCHAR(50)                    NOT NULL,
    second_nickname VARCHAR(50)                    NOT NULL,
    third_nickname  VARCHAR(50)                    NOT NULL,
    fourth_nickname VARCHAR(50),
    fifth_nickname  VARCHAR(50),
    playerID        INT,
    gameID          INT,
    foreign key (gameID) REFERENCES game (gameID) ON DELETE SET NULL,
    foreign key (playerID) REFERENCES player (playerID) ON DELETE SET NULL
);

-- TEAM END
-- --------------------------------------------------------------------------------------------------------------------
-- MATCH START

CREATE TABLE IF NOT EXISTS matches
(
    matchID  INT NOT NULL AUTO_INCREMENT,
    teamA_ID INT,
    teamB_ID INT,
    score_a  INT             NOT NULL,
    score_b  INT             NOT NULL,
    done     BOOLEAN         NOT NULL,
    PRIMARY KEY (matchID),
    FOREIGN KEY (teamA_ID) REFERENCES team (teamID) ON DELETE SET NULL,
    FOREIGN KEY (teamB_ID) REFERENCES team (teamID) ON DELETE SET NULL

);

-- MATCH END

