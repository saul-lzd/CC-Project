

create table users (user_id INT primary key, name VARCHAR (45), password VARCHAR(100))
-- Create table users (id int primary key, name varchar(30));
/*
CREATE TABLE user (
  'user_id' INT NOT NULL AUTO_INCREMENT,
  'name' VARCHAR(45) NULL,
  'password' VARCHAR(60) NULL,
  PRIMARY KEY ('user_id'));
  */
  
  
  CREATE TABLE 'project' (
  'project_id' INT NOT NULL AUTO_INCREMENT,
  'name' VARCHAR(60) NULL,
  'description' VARCHAR(200) NULL,
  'created_by' INT NULL,
  PRIMARY KEY ('project_id'),
  INDEX 'created_by_idx' ('created_by' ASC),
  CONSTRAINT 'created_by'
    FOREIGN KEY ('created_by')
    REFERENCES 'user' ('user_id')
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);


CREATE TABLE 'requirement' (
  'requirement_id' INT NOT NULL AUTO_INCREMENT,
  'name' VARCHAR(45) NULL,
  'description' VARCHAR(100) NULL,
  'created_by' INT NULL,
  'type' VARCHAR(45) NULL,
  'content' VARCHAR(250) NULL,
  PRIMARY KEY ('requirement_id'),
  INDEX 'created_by_idx' ('created_by' ASC),
  CONSTRAINT 'created_by_user'
    FOREIGN KEY ('created_by')
    REFERENCES 'user' ('user_id')
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);

INSERT INTO 'user' ('name','password') VALUES ('admin', md5('user'));


