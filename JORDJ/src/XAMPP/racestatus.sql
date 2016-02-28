-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-02-2016 a las 00:03:59
-- Versión del servidor: 10.1.10-MariaDB
-- Versión de PHP: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `olimp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `racestatus`
--

CREATE TABLE `racestatus` (
  `id` int(11) NOT NULL,
  `Class` varchar(15) DEFAULT NULL,
  `Race` int(11) DEFAULT '-1',
  `ScheduledDate` varchar(40) DEFAULT NULL,
  `RealDate` varchar(40) DEFAULT NULL,
  `Entries` int(11) DEFAULT '-1',
  `Area` varchar(15) DEFAULT NULL,
  `Committee` varchar(15) DEFAULT NULL,
  `RaceStatus` varchar(20) DEFAULT NULL,
  `Signall` varchar(20) DEFAULT NULL,
  `Time` varchar(15) DEFAULT NULL,
  `ScheduledTime` varchar(15) DEFAULT NULL,
  `StartingTime` varchar(15) DEFAULT NULL,
  `BoatsStarted` int(11) DEFAULT '-1',
  `PreparatorySignal` varchar(10) DEFAULT NULL,
  `OCS_DSQ` int(11) DEFAULT '-1',
  `AP` int(11) DEFAULT '-1',
  `GR` int(11) DEFAULT '-1',
  `FinishTime` varchar(15) DEFAULT NULL,
  `RaceTime` varchar(15) DEFAULT NULL,
  `BoatsFinished` int(11) DEFAULT '-1',
  `LastSignal` varchar(15) DEFAULT NULL,
  `LastSignalTime` varchar(15) DEFAULT NULL,
  `Results` varchar(15) DEFAULT NULL,
  `Course` varchar(15) DEFAULT NULL,
  `Distance1stLeg` int(11) DEFAULT '-1',
  `Bearing1stLeg` int(11) DEFAULT '-1',
  `LegChanges` varchar(20) DEFAULT NULL,
  `WindDir` int(11) DEFAULT '-1',
  `WindSpeed` int(11) DEFAULT '-1',
  `WindDir25` int(11) DEFAULT '-1',
  `WindSpeed25` int(11) DEFAULT '-1',
  `WindDir50` int(11) DEFAULT '-1',
  `WindSpeed50` int(11) DEFAULT '-1',
  `WindDir75` int(11) DEFAULT '-1',
  `WindSpeed75` int(11) DEFAULT '-1',
  `WindDir100` int(11) DEFAULT '-1',
  `WindSpeed100` int(11) DEFAULT '-1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `racestatus`
--

INSERT INTO `racestatus` (`id`, `Class`, `Race`, `ScheduledDate`, `RealDate`, `Entries`, `Area`, `Committee`, `RaceStatus`, `Signall`, `Time`, `ScheduledTime`, `StartingTime`, `BoatsStarted`, `PreparatorySignal`, `OCS_DSQ`, `AP`, `GR`, `FinishTime`, `RaceTime`, `BoatsFinished`, `LastSignal`, `LastSignalTime`, `Results`, `Course`, `Distance1stLeg`, `Bearing1stLeg`, `LegChanges`, `WindDir`, `WindSpeed`, `WindDir25`, `WindSpeed25`, `WindDir50`, `WindSpeed50`, `WindDir75`, `WindSpeed75`, `WindDir100`, `WindSpeed100`) VALUES
(1, 'hello', 1, '02/03/2016', '02/02/2016', 5, 'SaoPaulo', 'Pene', 'OK', 'hola', '12:00', '12:00', '12:00:43', 5, '888', 5, 2, 2, '12:18:55', '00:19:55', 2, '2', '12:00', '2', '2', 2, 2, '2', 2, 2, 2, 2, 2, 2, 2, 2, 2, 270),
(2, 'its me', 5, NULL, NULL, -1, NULL, NULL, NULL, 'asjdfhl', NULL, NULL, NULL, -1, NULL, -1, -1, -1, '', NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(3, 'miquel marica', 2, '', NULL, -1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);

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
