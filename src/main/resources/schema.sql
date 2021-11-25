DROP TABLE counters;
DROP TABLE sessions;

create table sessions
(
    id  INT NOT NULL,
    ordinal INT,
    sessionId INT,
    username varchar(255),
    authenticated bool,
    fraud boolean,

    emulator bool,
    primary key (id)
);

INSERT INTO sessions (id ,ordinal, sessionId, username, authenticated ,fraud ,emulator)
VALUES (1,0, 12121212, 'Mark Otto', false,true,false);
INSERT INTO sessions VALUES (2,1, 34343434, 'Jacob Throton', true,true,false);
INSERT INTO sessions VALUES (3,2, 21212121, 'Israel Isaeli', false,false,true);
INSERT INTO sessions VALUES (4,3, 89898989, 'Ariel Arieli', true,false,true);



create table counters
(
    id  INT NOT NULL,
    threats INT,
    total INT,
    authenticated INT,
    scored INT,
    primary key (id)
);

INSERT INTO counters (id, threats, total, authenticated, scored)
values (1, 150, 224 ,22,5 )