
-- Create the DB schema
CREATE SCHEMA `renwei_ceshi_db` ;

-- Create the two tables with some key
-- Train Journey Table
CREATE TABLE `renwei_ceshi_db`.`train_driver_details` (
  `journey_index_id` INT NOT NULL AUTO_INCREMENT FIRST,
  `train_id` VARCHAR(45) NOT NULL,
  `start_station` VARCHAR(45) NULL,
  `destination_station` VARCHAR(45) NULL,
  `driver_name` VARCHAR(45) NULL,
  `journey_status` VARCHAR(45) NULL,
  PRIMARY KEY (`journey_index_id`));

-- Train Delay Table
CREATE TABLE `renwei_ceshi_db`.`train_delay_details` (
  `delay_index_id` INT NOT NULL AUTO_INCREMENT FIRST,
  `train_id` VARCHAR(45) NOT NULL,
  `station` VARCHAR(45) NULL,
  `departure_time` VARCHAR(45)  NULL,
  `lateness` VARCHAR(45)  NULL,
  PRIMARY KEY (`delay_index_id`));

