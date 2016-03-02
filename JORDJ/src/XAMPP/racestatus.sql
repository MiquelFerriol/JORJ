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
(1, 'RS:X M', 1, '02/03/2016', '02/02/2016', 185, 'Päo Açucar', 'Christoph', 'SCHEDULED', 'DELTA', '12:00', '12:00', '', 5, 'PAPA', 5, 2, 2, '13:00:00', '', 2, '2', '12:00', '2', '2', 2, 2, 'c', 2, 2, 2, 2, 2, 2, 2, 2, 2, 270),
(2, 'RS:X W', 5, NULL, NULL, 453, 'Escola Naval', 'Maria', 'POSTPONDMENT', 'N+A', NULL, NULL, NULL, -1, 'INDIA - 30.1', -1, -1, -1, '', NULL, -1, NULL, NULL, NULL, NULL, -1, -1, '+', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(3, 'LASER STD', 2, '', NULL, 896, 'Ponte', 'Stogg', 'ON SEQUENCE', 'lima', NULL, NULL, NULL, -1, 'ZULU - 30.2', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, 'c', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(4, 'LASER RAD', 6, NULL, NULL, 654, 'Copacabana', 'Luiggi', 'SAILING', 'Ap', NULL, NULL, NULL, -1, 'BLACK - 30.3', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, '-', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(5, '470 M', 9, NULL, NULL, 378, 'Niteroi', 'Sulis', 'ON TIME', 'n+a', NULL, NULL, NULL, -1, 'OTHER', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, 'c', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(6, '470 W', 15, NULL, NULL, 455, 'Pai', 'John', 'ABANDON', 'delta', NULL, NULL, NULL, -1, 'BLACK - 30.3', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, '+', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
(7, 'FINN', 2, NULL, NULL, 989, 'Aeroport', 'Christoph', 'FINISHED', 'lima', NULL, NULL, NULL, -1, 'ZULU - 30.2', -1, -1, -1, NULL, NULL, -1, NULL, NULL, NULL, NULL, -1, -1, '-', -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);

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
