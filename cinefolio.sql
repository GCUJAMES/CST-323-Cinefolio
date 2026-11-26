-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cinefolio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cinefolio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cinefolio` DEFAULT CHARACTER SET utf8 ;
USE `cinefolio` ;

-- -----------------------------------------------------
-- Table `cinefolio`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinefolio`.`movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(150) NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `release_year` INT NOT NULL,
  `director` VARCHAR(100) NULL,
  `rating` DECIMAL(3,1) NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'Plan to Watch',
  `review` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
