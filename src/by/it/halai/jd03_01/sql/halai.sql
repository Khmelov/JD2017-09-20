-- -----------------------------------------------------
-- Table `halai`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `halai`.`ads` ;
DROP TABLE IF EXISTS `halai`.`users` ;
DROP TABLE IF EXISTS `halai`.`roles` ;

CREATE TABLE IF NOT EXISTS `halai`.`roles`(
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(100) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `halai`.`users`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `halai`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(100) NULL,
  `Password` VARCHAR(100) NULL,
  `Email` VARCHAR(100) NULL,
  `FK_roles` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_FK_Rolesx` (`FK_roles` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`FK_roles`)
    REFERENCES `halai`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `halai`.`ads`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `halai`.`ads` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200) NULL,
  `Genre` VARCHAR(200) NULL,
  `Number_Of_Players` INT NULL,
  `Price` DOUBLE NULL,
  `Description` VARCHAR(5000) NULL,
  `FK_Users` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ads_users1_idx` (`FK_Users` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`FK_Users`)
    REFERENCES `halai`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
