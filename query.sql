
CREATE DATABASE CITYCORP;

USE CITYCORP;

CREATE TABLE `citycorp`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `password` VARCHAR(60) NULL,
  PRIMARY KEY (`user_id`));
  
  
  
  CREATE TABLE `citycorp`.`project` (
  `project_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NULL,
  `description` VARCHAR(200) NULL,
  `created_by` INT NULL,
  PRIMARY KEY (`project_id`),
  INDEX `created_by_idx` (`created_by` ASC),
  CONSTRAINT `created_by`
    FOREIGN KEY (`created_by`)
    REFERENCES `citycorp`.`user` (`user_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);


CREATE TABLE `citycorp`.`requirement` (
  `requirement_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(100) NULL,
  `created_by` INT NULL,
  `type` VARCHAR(45) NULL,
  `content` VARCHAR(250) NULL,
  PRIMARY KEY (`requirement_id`),
  INDEX `created_by_idx` (`created_by` ASC),
  CONSTRAINT `created_by_user`
    FOREIGN KEY (`created_by`)
    REFERENCES `citycorp`.`user` (`user_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);

INSERT INTO `citycorp`.`user` (`name`,`password`) VALUES ('admin', md5('user'));


