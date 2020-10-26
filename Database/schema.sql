CREATE TABLE IF NOT EXISTS thought_bubble (

    id int NOT NULL AUTO_INCREMENT,
    thought varchar(255),
    PRIMARY KEY(id)
    
);

CREATE TABLE IF NOT EXISTS thought_child (

    thought_id int NOT NULL,
    child_id int NOT NULL,
    CONSTRAINT thought_child PRIMARY KEY(thought_id, child_id),
    FOREIGN KEY(thought_id) REFERENCES thought_bubble(id),
    FOREIGN KEY(child_id) REFERENCES thought_bubble(id)
    
);

    CONSTRAINT administered_discipline PRIMARY KEY(discipline_ID, admin_ID),
    FOREIGN KEY(discipline_ID) REFERENCES Disciplines(discipline_ID),
    FOREIGN KEY(admin_ID) REFERENCES Users(user_ID)