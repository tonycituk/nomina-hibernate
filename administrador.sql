-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: nomina-db-1
-- Tiempo de generación: 26-11-2021 a las 08:21:48
-- Versión del servidor: 10.6.5-MariaDB-1:10.6.5+maria~focal
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nomina_poo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `Administrador` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `nombre` varchar(55) NOT NULL,
  `salario` double NOT NULL,
  `numHorasTrabajadas` double NOT NULL,
  `porcentajeCompensacion` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

--INSERT INTO `administrador` (`id`, `nombre`, `numHorasTrabajadas`) VALUES
--(1, 'John', 80),
--(2, 'Mike', 79),
--(3, 'Polo', 60),
--(4, 'Gerard', 90),
--(5, 'Richard', 75),
--(6, 'Sandunga', 121),
--(7, 'Wiskuchi', 80);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
--ALTER TABLE `administrador`
--  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
--ALTER TABLE `administrador`
--  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO nomina_poo.Administrador (nombre,salario,numHorasTrabajadas,porcentajeCompensacion) VALUES
	 ('Rodro',87750.0,1500.0,0.3),
	 ('Jhonny',16731.0,90.0,0.3),
	 ('Teo',13572.0,78.0,0.2),
	 ('Fernan',5206.5,89.0,0.3),
	 ('Daniel',503.99999999999994,35.0,0.2);