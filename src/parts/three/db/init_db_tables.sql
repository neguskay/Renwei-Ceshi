
-- Create the DB schema
CREATE SCHEMA `renwei_ceshi_db` ;

-- Create the two tables with some key
-- Train Journey Table
CREATE TABLE `renwei_ceshi_db`.`train_journey` (
  `journey_id` INT NOT NULL,
  `train_id` INT NOT NULL,
  `delay_id` INT NULL,
  `start_station` VARCHAR(45) NULL,
  `destination_station` VARCHAR(45) NULL,
  `driver_name` VARCHAR(45) NULL,
  `journey_status` VARCHAR(45) NULL,
  PRIMARY KEY (`journey_id`));

-- Train Delay Table
CREATE TABLE `renwei_ceshi_db`.`train_delay` (
  `delay_id` INT NOT NULL,
  `train_id` INT NOT NULL,
  `journey_id` INT NOT NULL,
  `delay_station` VARCHAR(45) NOT NULL,
  `scheduled_departure_time` INT NOT NULL,
  `actual_departure_time` INT NOT NULL,
  `delay_time` INT NOT NULL,
  PRIMARY KEY (`delay_id`));

