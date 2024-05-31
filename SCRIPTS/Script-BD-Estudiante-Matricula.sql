-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema esquema_estudiantes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema esquema_estudiantes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `esquema_estudiantes` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema clase1_semana2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema clase1_semana2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clase1_semana2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `esquema_estudiantes` ;

-- -----------------------------------------------------
-- Table `esquema_estudiantes`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `esquema_estudiantes`.`Estudiante` (
  `idEstudiante` INT NOT NULL AUTO_INCREMENT,
  `Cedula` VARCHAR(45) NOT NULL,
  `Nombres` VARCHAR(45) NOT NULL,
  `Apellidos` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstudiante`),
  UNIQUE INDEX `Cedula_UNIQUE` (`Cedula` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `esquema_estudiantes`.`Matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `esquema_estudiantes`.`Matricula` (
  `idMat` INT NOT NULL AUTO_INCREMENT,
  `Carrera` VARCHAR(45) NULL,
  `Ciclo` INT NULL,
  `Anio` VARCHAR(45) NULL DEFAULT '2024',
  `Estudiante_idEstudiante` INT NOT NULL,
  PRIMARY KEY (`idMat`),
  INDEX `fk_Matricula_Estudiante_idx` (`Estudiante_idEstudiante` ASC) VISIBLE,
  CONSTRAINT `fk_Matricula_Estudiante`
    FOREIGN KEY (`Estudiante_idEstudiante`)
    REFERENCES `esquema_estudiantes`.`Estudiante` (`idEstudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `clase1_semana2` ;

-- -----------------------------------------------------
-- Table `clase1_semana2`.`esposas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clase1_semana2`.`esposas` (
  `idEsp` INT NOT NULL AUTO_INCREMENT,
  `Cedula` VARCHAR(45) NULL DEFAULT NULL,
  `Nombres` VARCHAR(45) NULL DEFAULT NULL,
  `Apellidos` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idEsp`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clase1_semana2`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clase1_semana2`.`clientes` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `Cedula` VARCHAR(10) NULL DEFAULT NULL,
  `Nombres` VARCHAR(15) NULL DEFAULT NULL,
  `Apellidos` VARCHAR(15) NULL DEFAULT NULL,
  `esposas_idEsp` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_clientes_esposas1_idx` (`esposas_idEsp` ASC) VISIBLE,
  CONSTRAINT `fk_clientes_esposas1`
    FOREIGN KEY (`esposas_idEsp`)
    REFERENCES `clase1_semana2`.`esposas` (`idEsp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `clase1_semana2`.`direcciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clase1_semana2`.`direcciones` (
  `idDir` INT NOT NULL AUTO_INCREMENT,
  `calle1` VARCHAR(45) NULL DEFAULT NULL,
  `calle2` VARCHAR(45) NULL DEFAULT NULL,
  `idCli` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idDir`),
  INDEX `idCliente_idx` (`idCli` ASC) VISIBLE,
  CONSTRAINT `idCli`
    FOREIGN KEY (`idCli`)
    REFERENCES `clase1_semana2`.`clientes` (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
