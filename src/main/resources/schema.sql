DROP TABLE counters;
DROP TABLE sessions;

create table sessions
(
    id  INT NOT NULL,
    ordinal INT,
    sessionId varchar(255),
    username varchar(255),
    authenticated bool,
    fraud boolean,
    emulator bool,
    primary key (id)
);

create table counters
(
    id  INT NOT NULL,
    threats INT,
    total INT,
    authenticated INT,
    scored INT,
    primary key (id)
);
