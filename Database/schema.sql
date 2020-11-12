CREATE TABLE IF NOT EXISTS thought (

    id int NOT NULL AUTO_INCREMENT,
    description varchar(255),
    PRIMARY KEY(id)
    
);

CREATE TABLE IF NOT EXISTS thought_child (

    thought_id int NOT NULL,
    child_id int NOT NULL,
    CONSTRAINT thought_child PRIMARY KEY(thought_id, child_id),
    FOREIGN KEY(thought_id) REFERENCES thought(id),
    FOREIGN KEY(child_id) REFERENCES thought(id)
    
);