DROP VIEW MessagesV;
DROP TABLE Followers;
DROP TABLE Wall;
DROP TABLE Persons;

CREATE TABLE Persons (
    id INTEGER PRIMARY KEY,
    name VARCHAR(64) UNIQUE
);

CREATE TABLE Wall (
    userId INTEGER,
    timestamp BIGINT,
    message VARCHAR(140),
    PRIMARY KEY(userId, timestamp),
    FOREIGN KEY(userId) REFERENCES Persons(id)
);

CREATE TABLE Followers (
    id INTEGER,
    follows INTEGER,
    PRIMARY KEY(id, follows)
);

CREATE VIEW MessagesV AS
SELECT w.message, p.name, w.timestamp, p.id from Wall w, Persons p
WHERE w.userId=p.id;

--For testing purpose
DELETE FROM Persons;
DELETE FROM Wall;
DELETE FROM Followers;
INSERT INTO Persons VALUES(1, 'Alice');
INSERT INTO Persons VALUES(2, 'Bob');
INSERT INTO Wall VALUES(1, 100, 'messageA');
INSERT INTO Wall VALUES(2, 200, 'MessageA');
INSERT INTO Wall VALUES(1, 300, 'messageB');
--Bob follows Alice
INSERT INTO Followers VALUES(2, 1);
