CREATE TABLE developer_Skill (
developer_ID int NOT NULL,
skill_ID int NOT NULL,
CONSTRAINT d_ID FOREIGN KEY (developer_ID) REFERENCES developers (id),
CONSTRAINT s_ID FOREIGN KEY (skill_ID) REFERENCES skills (id)
);