-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-02-2016 a las 18:14:48
-- Versión del servidor: 10.1.10-MariaDB
-- Versión de PHP: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `racestatus`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `racestatus`
--

CREATE TABLE `racestatus` (
  `id` int(11) NOT NULL,
  `Class` varchar(15) DEFAULT NULL,
  `Race` int(11) DEFAULT NULL,
  `ScheduledDate` date DEFAULT NULL,
  `RealDate` date DEFAULT NULL,
  `Entries` int(11) DEFAULT NULL,
  `Area` varchar(15) DEFAULT NULL,
  `Committee` varchar(15) DEFAULT NULL,
  `RaceStatus` varchar(20) DEFAULT NULL,
  `Signal` varchar(10) DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `ScheduledTime` time DEFAULT NULL,
  `StartingTime` time DEFAULT NULL,
  `BoatsStarted` int(11) DEFAULT NULL,
  `PreparatorySignal` varchar(10) DEFAULT NULL,
  `OCS/DSQ` int(11) DEFAULT NULL,
  `AP` int(11) DEFAULT NULL,
  `GR` int(11) DEFAULT NULL,
  `FinishTime` time DEFAULT NULL,
  `RaceTime` time DEFAULT NULL,
  `BoatsFinished` int(11) DEFAULT NULL,
  `LastSignal` varchar(15) DEFAULT NULL,
  `LastSignalTime` time DEFAULT NULL,
  `Results` varchar(15) DEFAULT NULL,
  `Course` varchar(15) DEFAULT NULL,
  `Distance1stLeg` int(11) DEFAULT NULL,
  `Bearing1stLeg` int(11) DEFAULT NULL,
  `LegChanges` varchar(20) DEFAULT NULL,
  `WindDir` int(11) DEFAULT NULL,
  `WindSpeed` int(11) DEFAULT NULL,
  `WindDir25` int(11) DEFAULT NULL,
  `WindSpeed25` int(11) DEFAULT NULL,
  `WindDir50` int(11) DEFAULT NULL,
  `WindSpeed50` int(11) DEFAULT NULL,
  `WindDir75` int(11) DEFAULT NULL,
  `WindSpeed75` int(11) DEFAULT NULL,
  `WindDir100` int(11) DEFAULT NULL,
  `WindSpeed100` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `racestatus`
--

INSERT INTO `racestatus` (`id`, `Class`, `Race`, `ScheduledDate`, `RealDate`, `Entries`, `Area`, `Committee`, `RaceStatus`, `Signal`, `Time`, `ScheduledTime`, `StartingTime`, `BoatsStarted`, `PreparatorySignal`, `OCS/DSQ`, `AP`, `GR`, `FinishTime`, `RaceTime`, `BoatsFinished`, `LastSignal`, `LastSignalTime`, `Results`, `Course`, `Distance1stLeg`, `Bearing1stLeg`, `LegChanges`, `WindDir`, `WindSpeed`, `WindDir25`, `WindSpeed25`, `WindDir50`, `WindSpeed50`, `WindDir75`, `WindSpeed75`, `WindDir100`, `WindSpeed100`) VALUES
(1, 'RS:X N', 1, '2016-02-17', '2016-02-11', 5, 'Pao', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'RS:X M', 8, '2016-02-05', '2016-02-11', 5, 'Aero', NULL, NULL, NULL, '08:24:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'RS:X M', 2, '2016-02-22', '2016-02-06', 5, 'Copa Cabana', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `racestatus`
--
ALTER TABLE `racestatus`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
