USE clase1_semana2;
CREATE TABLE `clase1_semana2`.`clientes` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(10) NULL,
  `nombre` VARCHAR(15) NULL,
  `apellido` VARCHAR(15) NULL,
  PRIMARY KEY (`idCliente`));

ALTER TABLE `clase1_semana2`.`clientes` 
CHANGE COLUMN `cedula` `Cedula` VARCHAR(10) NULL DEFAULT NULL ,
CHANGE COLUMN `nombre` `Nombres` VARCHAR(15) NULL DEFAULT NULL ,
CHANGE COLUMN `apellido` `Apellidos` VARCHAR(15) NULL DEFAULT NULL ;

CREATE TABLE `clase1_semana2`.`esposas` (
  `idEsp` INT NOT NULL AUTO_INCREMENT,
  `Cedula` VARCHAR(45) NULL,
  `Nombres` VARCHAR(45) NULL,
  `Apellidos` VARCHAR(45) NULL,
  `idCliente` INT NULL,
  PRIMARY KEY (`idEsp`),
  INDEX `idCliente_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `clase1_semana2`.`clientes` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `clase1_semana2`.`esposas` 
DROP FOREIGN KEY `idCliente`;
ALTER TABLE `clase1_semana2`.`esposas` 
CHANGE COLUMN `idCliente` `id_Cliente` INT NULL DEFAULT NULL ;
ALTER TABLE `clase1_semana2`.`esposas` 
ADD CONSTRAINT `idCliente`
  FOREIGN KEY (`id_Cliente`)
  REFERENCES `clase1_semana2`.`clientes` (`idCliente`);

CREATE TABLE `clase1_semana2`.`direcciones` (
  `idDir` INT NOT NULL AUTO_INCREMENT,
  `calle1` VARCHAR(45) NULL,
  `calle2` VARCHAR(45) NULL,
  `idCli` INT NULL,
  PRIMARY KEY (`idDir`),
  INDEX `idCliente_idx` (`idCli` ASC) VISIBLE,
  CONSTRAINT `idCli`
    FOREIGN KEY (`idCli`)
    REFERENCES `clase1_semana2`.`clientes` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SELECT * FROM clientes;
