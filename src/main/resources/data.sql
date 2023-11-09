-- Drop the database if it exists
DROP DATABASE IF EXISTS Tarea4;

-- Create the database
CREATE DATABASE Tarea4;

-- Switch to the new database
USE Tarea4;

-- Elimina las tablas si existen
DROP TABLE IF EXISTS `investigadores`;
DROP TABLE IF EXISTS `reservas`;
DROP TABLE IF EXISTS `equipos`;
DROP TABLE IF EXISTS `facultades`;

-- Crea la tabla `facultades`
CREATE TABLE `facultades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- Crea la tabla `investigadores`
CREATE TABLE `investigadores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(250) DEFAULT NULL,
  `nombre` varchar(250) DEFAULT NULL,
  `facultad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (facultad) REFERENCES facultades(id)
);

-- Crea la tabla `equipos`
CREATE TABLE `equipos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `facultad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (facultad) REFERENCES facultades(id)
);

-- Crea la tabla `reservas`
CREATE TABLE `reservas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` int(10) NOT NULL,
  `equipo` int(11) NOT NULL,
  `comienzo` varchar(11) NOT NULL,
  `fin` varchar(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (dni) REFERENCES investigadores(id),
  FOREIGN KEY (equipo) REFERENCES equipos(id)
);

-- Insert values into `facultades`
INSERT INTO `facultades` (`nombre`) VALUES
('Engineering'),
('Science'),
('Arts'),
('Business'),
('Medicine');

-- Insert values into `investigadores`
INSERT INTO `investigadores` (`dni`, `nombre`, `facultad`) VALUES
('123456789', 'John Doe', 1),
('987654321', 'Jane Smith', 2),
('555555555', 'Bob Johnson', 1),
('666666666', 'Alice Williams', 3),
('444444444', 'Charlie Brown', 2);

-- Insert values into `equipos`
INSERT INTO `equipos` (`nombre`, `facultad`) VALUES
('TeamA', 1),
('TeamB', 2),
('TeamC', 3),
('TeamD', 1),
('TeamE', 2);

-- Insert values into `reservas`
INSERT INTO `reservas` (`dni`, `equipo`, `comienzo`, `fin`) VALUES
(1, 1, '2023-11-09', '2023-11-10'),
(2, 2, '2023-11-10', '2023-11-12'),
(3, 3, '2023-11-11', '2023-11-13'),
(4, 4, '2023-11-12', '2023-11-15'),
(5, 5, '2023-11-13', '2023-11-16');


