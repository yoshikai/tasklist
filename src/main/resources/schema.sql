CREATE TABLE IF NOT EXISTS tasklist(
    id VARCHAR(8)   PRIMARY KEY,
    task VARCHAR(8),
    deadline VARCHAR(10),
    done BOOLEAN,
);