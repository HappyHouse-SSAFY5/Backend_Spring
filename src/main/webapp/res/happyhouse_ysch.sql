-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema happyhouse_ysch
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema happyhouse_ysch
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `happyhouse_ysch` DEFAULT CHARACTER SET utf8 ;
USE `happyhouse_ysch` ;

-- -----------------------------------------------------
-- Table `happyhouse_ysch`.`ssafy_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse_ysch`.`ssafy_member` (
  `userid` VARCHAR(10) NOT NULL,
  `username` VARCHAR(45) NULL,
  `userpwd` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `joindate` DATE NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse_ysch`.`dong`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse_ysch`.`dong` (
  `dongcode` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NULL,
  `gugun` VARCHAR(45) NULL,
  `dong` VARCHAR(45) NULL,
  PRIMARY KEY (`dongcode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse_ysch`.`interestarea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse_ysch`.`interestarea` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(10) NOT NULL,
  `dongcode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`no`),
  INDEX `interestarea_userid_fk_idx` (`userid` ASC) VISIBLE,
  INDEX `interestarea_dongcode_fk_idx` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `interestarea_userid_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse_ysch`.`ssafy_member` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `interestarea_dongcode_fk`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse_ysch`.`dong` (`dongcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse_ysch`.`houseinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse_ysch`.`houseinfo` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `dongcode` VARCHAR(45) NULL,
  `dong` VARCHAR(45) NOT NULL,
  `AptName` VARCHAR(45) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `buildYear` VARCHAR(45) NULL,
  `jibun` VARCHAR(45) NULL DEFAULT NULL,
  `lat` VARCHAR(45) NULL DEFAULT NULL,
  `lng` VARCHAR(45) NULL DEFAULT NULL,
  `img` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `houseinfo_dongcode_fk_idx` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `houseinfo_dongcode_fk`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse_ysch`.`dong` (`dongcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse_ysch`.`housedeal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse_ysch`.`housedeal` (
  `no` INT NOT NULL,
  `houseinfoid` INT NULL,
  `dong` VARCHAR(45) NOT NULL,
  `AptName` VARCHAR(45) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `dealAmount` VARCHAR(45) NOT NULL,
  `buildYear` VARCHAR(45) NULL DEFAULT NULL,
  `dealYear` VARCHAR(45) NULL DEFAULT NULL,
  `dealMonth` VARCHAR(45) NULL DEFAULT NULL,
  `dealDay` VARCHAR(45) NULL DEFAULT NULL,
  `area` VARCHAR(45) NULL DEFAULT NULL,
  `floor` VARCHAR(45) NULL DEFAULT NULL,
  `jibun` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `housedeal_houseinfo_fk_idx` (`houseinfoid` ASC) VISIBLE,
  CONSTRAINT `housedeal_houseinfo_fk`
    FOREIGN KEY (`houseinfoid`)
    REFERENCES `happyhouse_ysch`.`houseinfo` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse_ysch`.`GuestBook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse_ysch`.`GuestBook` (
  `articleNo` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(10) NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `content` VARCHAR(45) NULL,
  `regtime` DATE NULL,
  PRIMARY KEY (`articleNo`),
  INDEX `guestbook_userid_fk_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `guestbook_userid_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse_ysch`.`ssafy_member` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
