-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-03-2016 a las 20:45:01
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
  `PreparatorySignal` varchar(20) DEFAULT NULL,
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
(1, 'RS:X M', 1, '08/08/2016', '', -1, 'Päo Açucar', 'Christoph', 'SCHEDULED', 'DELTA', '', '13:00', '', -1, 'PAPA', -1, -1, -1, '', '', -1, '', '', 'PUBLISHED', '', -1, -1, 'c', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(2, 'RS:X M', 2, '08/08/2016', NULL, -1, 'Päo Açucar', 'Maria', 'POSTPONDMENT', 'N+A', NULL, '13:00', NULL, -1, 'INDIA - 30.1', -1, -1, -1, '', NULL, -1, NULL, NULL, 'RECEIVED', NULL, -1, -1, '+', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(3, 'RS:X M', 3, '08/08/2016', NULL, -1, 'Päo Açucar', 'Stogg', 'ON SEQUENCE', 'lima', NULL, '13:00', NULL, -1, 'ZULU - 30.2', -1, -1, -1, NULL, NULL, -1, NULL, NULL, 'REVIEWING', NULL, -1, -1, 'c', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(4, 'RS:X M', 4, '09/08/2016', NULL, -1, 'Escola Naval', 'Luiggi', 'SAILING', 'Ap', NULL, '13:00', NULL, -1, 'BLACK - 30.3', -1, -1, -1, NULL, NULL, -1, NULL, NULL, 'INCIDENCE', NULL, -1, -1, '-', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(5, 'RS:X M', 5, '09/08/2016', NULL, -1, 'Escola Naval', 'Sulis', 'ON TIME', 'n+a', NULL, '13:00', NULL, -1, 'OTHER', -1, -1, -1, NULL, NULL, -1, NULL, NULL, 'PUBLISHED', NULL, -1, -1, 'c', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(6, 'RS:X M', 6, '09/08/2016', NULL, -1, 'Escola Naval', 'John', 'ABANDON', 'delta', NULL, '13:00', NULL, -1, 'BLACK - 30.3', -1, -1, -1, NULL, NULL, -1, NULL, NULL, 'PUBLISHED', NULL, -1, -1, '+', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(7, 'RS:X M', 7, '11/08/2016', NULL, -1, 'Niteroi', 'Christoph', 'FINISHED', 'lima', NULL, '13:00', NULL, -1, 'ZULU - 30.2', -1, -1, -1, NULL, NULL, -1, NULL, NULL, 'INCIDENCE', NULL, -1, -1, '-', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(8, 'RS:X M', 8, '11/08/2016', NULL, -1, 'Niteroi', 'Christoph', 'POSTPONDMENT', 'DELTA', NULL, '13:00', NULL, -1, 'PAPA', -1, -1, -1, NULL, NULL, -1, NULL, NULL, 'REVIEWING', NULL, -1, -1, 'c', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(9, 'RS:X M', 9, '11/08/2016', NULL, -1, 'Niteroi', 'Christoph', 'FINISHED', 'lima', NULL, '13:00', NULL, -1, 'ZULU - 30.2', -1, -1, -1, NULL, NULL, -1, NULL, NULL, 'PUBLISHED', NULL, -1, -1, 'c', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(10, 'RS:X M', 10, '12/08/2016', NULL, -1, 'Escola Naval', 'Christoph', 'SCHEDULED', 'lima', NULL, '13:00', NULL, -1, 'INDIA - 30.1', -1, -1, -1, NULL, NULL, -1, NULL, NULL, 'PUBLISHED', NULL, -1, -1, 'c', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(11, 'RS:X M', 11, '12/08/2016', NULL, -1, 'Escola Naval', 'Christoph', 'POSTPONDMENT', 'n+a', NULL, '13:00', NULL, -1, 'BLACK - 30.3', -1, -1, -1, NULL, NULL, -1, NULL, NULL, 'REVIEWING', NULL, -1, -1, '-', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(12, 'RS:X M', 12, '12/08/2016', NULL, -1, 'Escola Naval', 'Christoph', 'FINISHED', 'DELTA', NULL, '13:00', NULL, -1, 'INDIA - 30.1', -1, -1, -1, NULL, NULL, -1, NULL, NULL, 'RECEIVED', NULL, -1, -1, '-', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(13, 'RS:X M', -1, '14/08/2016', NULL, -1, 'Päo Açucar', 'Christoph', 'ABANDON', 'lima', NULL, '13:00', NULL, -1, 'PAPA', -1, -1, -1, NULL, NULL, -1, NULL, NULL, 'RECEIVED', NULL, -1, -1, 'c', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(14, 'RS:X W', 1, '08/08/2016', NULL, -1, 'Päo Açucar', 'Christoph', 'SAILING', 'n+a', NULL, '13:00', NULL, -1, 'INDIA - 30.1', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, 'c', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(15, 'RS:X W', 2, '08/08/2016', NULL, -1, 'Päo Açucar', 'Christoph', 'ON SEQUENCE', 'DELTA', NULL, '13:00', NULL, -1, 'ZULU - 30.2', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, '+', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(16, 'RS:X W', 3, '08/08/2016', NULL, -1, 'Päo Açucar', 'Christoph', 'SEQUENCE', 'n+a', NULL, '13:00', NULL, -1, 'OTHER', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, '-', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(17, 'RS:X W', 4, '08/08/2016', NULL, -1, 'Escola Naval', 'Christoph', 'SCHEDULED', 'lima', NULL, '13:00', NULL, -1, 'OTHER', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, '+', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(18, 'RS:X W', 5, '08/08/2016', NULL, -1, 'Escola Naval', 'Christoph', 'ABANDON', 'Ap', NULL, '13:00', NULL, -1, 'OTHER', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, '-', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(19, 'RS:X W', 6, '08/08/2016', NULL, -1, 'Escola Naval', 'Christoph', 'SCHEDULED', 'DELTA', NULL, '13:00', NULL, -1, 'PAPA', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, '+', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(20, 'RS:X W', 7, '08/08/2016', NULL, -1, 'Niteroi', 'Christoph', 'POSTPONDMENT', 'DELTA', NULL, '13:00', NULL, -1, 'OTHER', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, 'c', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(21, 'RS:X W', 8, '08/08/2016', NULL, -1, 'Niteroi', 'Christoph', 'SCHEDULED', 'Ap', NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(22, 'RS:X W', 9, '08/08/2016', NULL, -1, 'Niteroi', 'Christoph', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(23, 'RS:X W', 10, '08/08/2016', NULL, -1, 'Escola Naval', 'Christoph', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(24, 'RS:X W', 11, '08/08/2016', NULL, -1, 'Escola Naval', 'Christoph', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(25, 'RS:X W', 12, '08/08/2016', NULL, -1, 'Escola Naval', 'Christoph', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(26, 'RS:X W', -1, '08/08/2016', NULL, -1, 'Päo Açucar', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(27, 'LASER STD', 1, '08/08/2016', NULL, -1, 'Escola Naval', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(28, 'LASER STD', 2, '08/08/2016', NULL, -1, 'Escola Naval', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(29, 'LASER STD', 3, '08/08/2016', NULL, -1, 'Ponte', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(30, 'LASER STD', 4, '08/08/2016', NULL, -1, 'Ponte', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(31, 'LASER STD', 5, '08/08/2016', NULL, -1, 'Copacabana', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(32, 'LASER STD', 6, '08/08/2016', NULL, -1, 'Copacabana', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(33, 'LASER STD', 7, '08/08/2016', NULL, -1, 'Copacabana', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(34, 'LASER STD', 8, '08/08/2016', NULL, -1, 'Copacabana', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(35, 'LASER STD', 9, '08/08/2016', NULL, -1, 'Päo Açucar', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(36, 'LASER STD', 10, '08/08/2016', NULL, -1, 'Päo Açucar', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(37, 'LASER STD', -1, '08/08/2016', NULL, -1, 'Päo Açucar', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(38, 'LASER RAD', 1, '08/08/2016', NULL, -1, 'Escola Naval', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(39, 'LASER RAD', 2, '08/08/2016', NULL, -1, 'Escola Naval', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(40, 'LASER RAD', 3, '08/08/2016', NULL, -1, 'Ponte', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(41, 'LASER RAD', 4, '08/08/2016', NULL, -1, 'Ponte', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(42, 'LASER RAD', 5, '08/08/2016', NULL, -1, 'Copacabana', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(43, 'LASER RAD', 6, '08/08/2016', NULL, -1, 'Copacabana', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(44, 'LASER RAD', 7, '08/08/2016', NULL, -1, 'Copacabana', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(45, 'LASER RAD', 8, '08/08/2016', NULL, -1, 'Copacabana', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(46, 'LASER RAD', 9, '08/08/2016', NULL, -1, 'Päo Açucar', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(47, 'LASER RAD', 10, '08/08/2016', NULL, -1, 'Päo Açucar', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(48, 'LASER RAD', -1, '08/08/2016', NULL, -1, 'Päo Açucar', 'Maria', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(49, 'FINN', 1, '08/08/2016', NULL, -1, 'Päo Açucar', 'Luigi', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(50, 'FINN', 2, '08/08/2016', NULL, -1, 'Päo Açucar', 'Luigi', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(51, 'FINN', 3, '08/08/2016', NULL, -1, 'Niteroi', 'Luigi', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(52, 'FINN', 4, '08/08/2016', NULL, -1, 'Niteroi', 'Luigi', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(53, 'FINN', 5, '08/08/2016', NULL, -1, 'Escola Naval', 'Luigi', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(54, 'FINN', 6, '08/08/2016', NULL, -1, 'Escola Naval', 'Luigi', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(55, 'FINN', 7, '08/08/2016', NULL, -1, 'Copacabana', 'Luigi', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(56, 'FINN', 8, '08/08/2016', NULL, -1, 'Copacabana', 'Luigi', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(57, 'FINN', 9, '08/08/2016', NULL, -1, 'Niteroi', 'Luigi', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(58, 'FINN', 10, '08/08/2016', NULL, -1, 'Niteroi', 'Luigi', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(59, 'FINN', -1, '08/08/2016', NULL, -1, 'Päo Açucar', 'Luigi', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(60, '470 M', 1, '08/08/2016', NULL, -1, 'Escola Naval', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(61, '470 M', 2, '08/08/2016', NULL, -1, 'Escola Naval', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(62, '470 M', 3, '08/08/2016', NULL, -1, 'Päo Açucar', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(63, '470 M', 4, '08/08/2016', NULL, -1, 'Päo Açucar', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(64, '470 M', 5, '08/08/2016', NULL, -1, 'Niteroi', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(65, '470 M', 6, '08/08/2016', NULL, -1, 'Niteroi', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(66, '470 M', 7, '08/08/2016', NULL, -1, 'Copacabana', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(67, '470 M', 8, '08/08/2016', NULL, -1, 'Copacabana', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(68, '470 M', 9, '08/08/2016', NULL, -1, 'Escola Naval', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(69, '470 M', 10, '08/08/2016', NULL, -1, 'Escola Naval', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(70, '470 M', -1, '08/08/2016', NULL, -1, 'Päo Açucar', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(71, '470 W', 1, '08/08/2016', NULL, -1, 'Escola Naval', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(72, '470 W', 2, '08/08/2016', NULL, -1, 'Escola Naval', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(73, '470 W', 3, '08/08/2016', NULL, -1, 'Päo Açucar', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(74, '470 W', 4, '08/08/2016', NULL, -1, 'Päo Açucar', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(75, '470 W', 5, '08/08/2016', NULL, -1, 'Niteroi', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(76, '470 W', 6, '08/08/2016', NULL, -1, 'Niteroi', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(77, '470 W', 7, '08/08/2016', NULL, -1, 'Copacabana', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(78, '470 W', 8, '08/08/2016', NULL, -1, 'Copacabana', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(79, '470 W', 9, '08/08/2016', NULL, -1, 'Escola Naval', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(80, '470 W', 10, '08/08/2016', NULL, -1, 'Escola Naval', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(81, '470 W', -1, '08/08/2016', NULL, -1, 'Päo Açucar', 'Stogg', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(82, '49er', 1, '08/08/2016', NULL, -1, 'Pao/Ponte', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(83, '49er', 2, '08/08/2016', NULL, -1, 'Pao/Ponte', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(84, '49er', 3, '08/08/2016', NULL, -1, 'Pao/Ponte', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(85, '49er', 4, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(86, '49er', 5, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(87, '49er', 6, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(88, '49er', 7, '08/08/2016', NULL, -1, 'Copacabana', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(89, '49er', 8, '08/08/2016', NULL, -1, 'Copacabana', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(90, '49er', 9, '08/08/2016', NULL, -1, 'Copacabana', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(91, '49er', 10, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(92, '49er', 11, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(93, '49er', 12, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(94, '49er', -1, '08/08/2016', NULL, -1, 'Päo Açucar', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(95, 'FX one', 1, '08/08/2016', NULL, -1, 'Pao/Ponte', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(96, 'FX one', 2, '08/08/2016', NULL, -1, 'Pao/Ponte', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(97, 'FX one', 3, '08/08/2016', NULL, -1, 'Pao/Ponte', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(98, 'FX one', 4, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(99, 'FX one', 5, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(100, 'FX one', 6, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(101, 'FX one', 7, '08/08/2016', NULL, -1, 'Niteroi', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(102, 'FX one', 8, '08/08/2016', NULL, -1, 'Niteroi', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(103, 'FX one', 9, '08/08/2016', NULL, -1, 'Niteroi', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(104, 'FX one', 10, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(105, 'FX one', 11, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(106, 'FX one', 12, '08/08/2016', NULL, -1, 'Escola Naval', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(107, 'FX one', -1, '08/08/2016', NULL, -1, 'Päo Açucar', 'Sulis', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(108, 'NCRA', 1, '08/08/2016', NULL, -1, 'Päo Açucar', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(109, 'NCRA', 2, '08/08/2016', NULL, -1, 'Päo Açucar', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(110, 'NCRA', 3, '08/08/2016', NULL, -1, 'Päo Açucar', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(111, 'NCRA', 4, '08/08/2016', NULL, -1, 'Copacabana', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(112, 'NCRA', 5, '08/08/2016', NULL, -1, 'Copacabana', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(113, 'NCRA', 6, '08/08/2016', NULL, -1, 'Copacabana', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(114, 'NCRA', 7, '08/08/2016', NULL, -1, 'Ponte', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(115, 'NCRA', 8, '08/08/2016', NULL, -1, 'Ponte', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(116, 'NCRA', 9, '08/08/2016', NULL, -1, 'Ponte', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(117, 'NCRA', 10, '08/08/2016', NULL, -1, 'Escola Naval', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(118, 'NCRA', 11, '08/08/2016', NULL, -1, 'Escola Naval', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(119, 'NCRA', 12, '08/08/2016', NULL, -1, 'Escola Naval', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(120, 'NCRA', -1, '08/08/2016', NULL, -1, 'Päo Açucar', 'John', NULL, NULL, NULL, '13:00', NULL, -1, NULL, -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, NULL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);

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
