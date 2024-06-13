USE proyecto_integrador;

SELECT * FROM proyecto_integrador.detenidos_2016;

SHOW VARIABLES LIKE 'secure_file_priv';

SELECT count(*) FROM proyecto_integrador.detenidos_2016;
SELECT count(*) FROM proyecto_integrador.detenidos_2017;
SELECT count(*) FROM proyecto_integrador.detenidos_2018;
SELECT count(*) FROM proyecto_integrador.detenidos_2019;
SELECT count(*) FROM proyecto_integrador.detenidos_2020;
SELECT count(*) FROM proyecto_integrador.detenidos_2021;
SELECT count(*) FROM proyecto_integrador.detenidos_2022;
SELECT count(*) FROM proyecto_integrador.detenidos_2023;

drop table proyecto_integrador.detenidos_2023;

CREATE TABLE detenidos_2016 (
    ID INT,
    Zona VARCHAR(50),
    Subzona VARCHAR(50),
    Canton VARCHAR(50),
    Presunta_Subinfraccion VARCHAR(255),
    Fecha_de_Detencion DATE,
    Flagrante_Boleta VARCHAR(50),
    Sexo VARCHAR(10),
    Edad INT,
    Nacionalidad VARCHAR(50)
);

CREATE TABLE detenidos_2017 (
    ID INT PRIMARY KEY,
    Zona VARCHAR(50),
    Subzona VARCHAR(50),
    Canton VARCHAR(50),
    Presunta_Subinfraccion VARCHAR(255),
    Fecha_de_Detencion DATE,
    Flagrante_Boleta VARCHAR(50),
    Sexo VARCHAR(10),
    Edad INT,
    Nacionalidad VARCHAR(50)
);

CREATE TABLE detenidos_2018 (
    ID INT PRIMARY KEY,
    Zona VARCHAR(50),
    Subzona VARCHAR(50),
    Canton VARCHAR(50),
    Presunta_Subinfraccion VARCHAR(255),
    Fecha_de_Detencion DATE,
    Flagrante_Boleta VARCHAR(50),
    Sexo VARCHAR(10),
    Edad INT,
    Nacionalidad VARCHAR(50)
);

CREATE TABLE detenidos_2019 (
    ID INT PRIMARY KEY,
    Zona VARCHAR(50),
    Subzona VARCHAR(50),
    Canton VARCHAR(50),
    Presunta_Subinfraccion VARCHAR(255),
    Fecha_de_Detencion DATE,
    Sexo VARCHAR(15),
    Edad INT,
    Nacionalidad VARCHAR(50)
);

CREATE TABLE detenidos_2020 (
    ID INT PRIMARY KEY,
    Zona VARCHAR(50),
    Subzona VARCHAR(50),
    Canton VARCHAR(50),
    Presunta_subinfraccion VARCHAR(255),
    Fecha_de_Detencion DATE,
    Sexo VARCHAR(15),
    Edad INT,
    Nacionalidad VARCHAR(50)
);

CREATE TABLE detenidos_2021 (
    ID INT PRIMARY KEY,
    Zona VARCHAR(50),
    Subzona VARCHAR(50),
    Canton VARCHAR(50),
    presunta_subinfraccion VARCHAR(255),
    Fecha_de_Detencion DATE,
    Sexo VARCHAR(15),
    Edad INT,
    Nacionalidad VARCHAR(50)
);

CREATE TABLE detenidos_2022 (
	ID INT PRIMARY KEY,
    tipo VARCHAR(50),
    edad INT,
    sexo VARCHAR(20),
    nacionalidad VARCHAR(50),
    autoidentificacion_etnica VARCHAR(50),
    numero_detenciones INT,
    nombre_provincia VARCHAR(50),
    nombre_canton VARCHAR(50),
    nombre_parroquia VARCHAR(50),
    nombre_zona VARCHAR(50),
    nombre_subzona VARCHAR(50),
    nombre_distrito VARCHAR(50),
    codigo_distrito VARCHAR(50),
    nombre_circuito VARCHAR(50),
    codigo_circuito VARCHAR(50),
    nombre_subcircuito VARCHAR(50),
    codigo_subcircuito VARCHAR(50),
    lugar VARCHAR(50),
    presunta_infraccion VARCHAR(255),
    presunta_subinfraccion VARCHAR(255),
    fecha_detencion_aprehension DATE,
    hora_detencion_aprehension TIME,
    presunta_flagrancia VARCHAR(5)
);

CREATE TABLE detenidos_2023 (
	ID INT PRIMARY KEY,
	codigo_iccs FLOAT,
    tipo VARCHAR(50),
    estado_civil VARCHAR(50),
    estatus_migratorio VARCHAR(50),
    edad INT,
    sexo VARCHAR(20),
    genero VARCHAR(50),
    nacionalidad VARCHAR(50),
    autoidentificacion_etnica VARCHAR(50),
    numero_detenciones INT,
    nivel_de_instruccion VARCHAR(50),
    condicion VARCHAR(50),
    movilizacion VARCHAR(50),
    tipo_arma VARCHAR(50),
    arma VARCHAR(50),
    fecha_detencion_aprehension DATE,
    hora_detencion_aprehension TIME,
    lugar VARCHAR(50),
    tipo_lugar VARCHAR(50),
    codigo_distrito VARCHAR(50),
    codigo_circuito VARCHAR(50),
    codigo_subcircuito VARCHAR(50),
    nombre_zona VARCHAR(50),
    nombre_subzona VARCHAR(50),
    nombre_distrito VARCHAR(50),
    nombre_circuito VARCHAR(50),
    nombre_subcircuito VARCHAR(50),
    codigo_provincia INT,
    codigo_canton INT,
    codigo_parroquia INT,
    nombre_provincia VARCHAR(50),
    nombre_canton VARCHAR(50),
    nombre_parroquia VARCHAR(50),
    presunta_flagrancia VARCHAR(5),
    presunta_infraccion VARCHAR(100),
    presunta_subinfraccion VARCHAR(100),
    presunta_modalidad VARCHAR(50)
);



LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/COPIA - BD_2016.csv'
INTO TABLE detenidos_2016
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(ID, Zona, Subzona, Canton, Presunta_Subinfraccion, @Fecha_de_Detencion, Flagrante_Boleta, Sexo, Edad, Nacionalidad)
SET Fecha_de_Detencion = STR_TO_DATE(@Fecha_de_Detencion, '%d-%m-%y');


LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/COPIA - BD_2017.csv'
INTO TABLE detenidos_2017
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(ID, Zona, Subzona, Canton, Presunta_Subinfraccion, @Fecha_de_Detencion, Flagrante_Boleta, Sexo, Edad, Nacionalidad)
SET Fecha_de_Detencion = STR_TO_DATE(@Fecha_de_Detencion, '%d-%m-%y');


LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/COPIA - BD_2018.csv'
INTO TABLE detenidos_2018
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(ID, Zona, Subzona, Canton, Presunta_Subinfraccion, @Fecha_de_Detencion, Flagrante_Boleta, Sexo, Edad, Nacionalidad)
SET Fecha_de_Detencion = STR_TO_DATE(@Fecha_de_Detencion, '%d-%m-%y');


LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/COPIA - BD_2019.csv'
INTO TABLE detenidos_2019
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(ID, Zona, Subzona, Canton, Presunta_Subinfraccion, @Fecha_de_Detencion, Sexo, Edad, Nacionalidad)
SET Fecha_de_Detencion = STR_TO_DATE(@Fecha_de_Detención, '%d-%m-%y');


LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/COPIA - BD_2020.csv'
INTO TABLE detenidos_2020
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(ID, Zona, Subzona, Canton, Presunta_subinfraccion, @Fecha_de_Detencion, Sexo, Edad, Nacionalidad)
SET Fecha_de_Detencion = STR_TO_DATE(@Fecha_de_Detencion, '%d-%m-%y');


LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/COPIA - BD_2021.csv'
INTO TABLE detenidos_2021
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(ID, Zona, Subzona, Canton, presunta_subinfraccion, @Fecha_de_Detencion, Sexo, Edad, Nacionalidad)
SET Fecha_de_Detencion = STR_TO_DATE(@Fecha_de_Detencion, '%d-%m-%y');

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/COPIA - BD_2022.csv'
INTO TABLE detenidos_2022
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(ID, tipo, edad, sexo, nacionalidad, autoidentificacion_etnica, numero_detenciones, nombre_provincia, nombre_canton, nombre_parroquia, nombre_zona, nombre_subzona, nombre_distrito, codigo_distrito, nombre_circuito, codigo_circuito, nombre_subcircuito, codigo_subcircuito, lugar, presunta_infraccion, presunta_subinfraccion, @fecha_detencion_aprehension, hora_detencion_aprehension, presunta_flagrancia)
SET fecha_detencion_aprehension = STR_TO_DATE(@fecha_detencion_aprehension, '%d-%m-%y');

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/COPIA - BD_2023.csv'
INTO TABLE detenidos_2023
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID, codigo_iccs, tipo, estado_civil, estatus_migratorio, edad, sexo, genero, nacionalidad, autoidentificacion_etnica, numero_detenciones, nivel_de_instruccion, condicion, movilizacion, tipo_arma, arma, @fecha_detencion, @hora_detencion, lugar, tipo_lugar, codigo_distrito, codigo_circuito, codigo_subcircuito, nombre_zona, nombre_subzona, nombre_distrito, nombre_circuito, nombre_subcircuito, codigo_provincia, codigo_canton, codigo_parroquia, nombre_provincia, nombre_canton, nombre_parroquia, presunta_flagrancia, presunta_infraccion, presunta_subinfraccion, presunta_modalidad)
SET fecha_detencion_aprehension = STR_TO_DATE(@fecha_detencion, '%d-%m-%y'),
    hora_detencion_aprehension = STR_TO_DATE(@hora_detencion, '%H:%i');




