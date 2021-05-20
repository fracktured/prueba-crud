-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 16-05-2021 a las 22:08:55
-- Versión del servidor: 10.4.10-MariaDB
-- Versión de PHP: 7.4.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vmtcounty`
--

USE vmtcounty;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vmt_county`
--

DROP TABLE IF EXISTS `vmt_county`;
CREATE TABLE IF NOT EXISTS `vmt_county` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `county_fips` int(11) NOT NULL,
  `county_name` varchar(30) NOT NULL,
  `state_name` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `county_vmt` int(11) NOT NULL,
  `baseline_jan_vmt` int(11) NOT NULL,
  `percent_change_from_jan` decimal(5,2) NOT NULL,
  `mean7_county_vmt` decimal(10,2) NOT NULL,
  `mean7_percent_change_from_jan` decimal(5,2) NOT NULL,
  `date_at_low` date NOT NULL,
  `mean7_county_vmt_at_low` decimal(10,2) NOT NULL,
  `percent_change_from_low` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vmt_county`
--

INSERT INTO `vmt_county` (`id`, `county_fips`, `county_name`, `state_name`, `date`, `county_vmt`, `baseline_jan_vmt`, `percent_change_from_jan`, `mean7_county_vmt`, `mean7_percent_change_from_jan`, `date_at_low`, `mean7_county_vmt_at_low`, `percent_change_from_low`) VALUES
(1, 1001, 'Autauga', 'Alabama', '20200508', 3550000, 3571446, '-0.6', '2790000', '-21.88', '20200412', '1542857.14', '80.83'),
(2, 1001, 'Autauga', 'Alabama', '20200507', 2970000, 3571446, '-16.84', '2724285.71', '-23.72', '20200412', '1542857.14', '76.57'),
(3, 1001, 'Autauga', 'Alabama', '20200506', 2680000, 3571446, '-24.96', '2644285.71', '-25.96', '20200412', '1542857.14', '71.39'),
(4, 1001, 'Autauga', 'Alabama', '20200505', 2720000, 3571446, '-23.84', '2561428.57', '-28.28', '20200412', '1542857.14', '66.02'),
(5, 1001, 'Autauga', 'Alabama', '20200504', 2390000, 3571446, '-33.08', '2515714.29', '-29.56', '20200412', '1542857.14', '63.06'),
(6, 1001, 'Autauga', 'Alabama', '20200503', 2430000, 3571446, '-31.96', '2490000', '-30.28', '20200412', '1542857.14', '61.39'),
(7, 1001, 'Autauga', 'Alabama', '20200502', 2790000, 3571446, '-21.88', '2384285.71', '-33.24', '20200412', '1542857.14', '54.54'),
(8, 1001, 'Autauga', 'Alabama', '20200501', 3090000, 3571446, '-13.48', '2264285.71', '-36.6', '20200412', '1542857.14', '46.76'),
(9, 1001, 'Autauga', 'Alabama', '20200430', 2410000, 3571446, '-32.52', '2170000', '-39.24', '20200412', '1542857.14', '40.65'),
(10, 1001, 'Autauga', 'Alabama', '20200429', 2100000, 3571446, '-41.2', '2082857.14', '-41.68', '20200412', '1542857.14', '35');



COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
