-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 28, 2016 at 03:11 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.5.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `DB_phase2`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_option`
--

CREATE TABLE `user_option` (
  `User_option_id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_option`
--

INSERT INTO `user_option` (`User_option_id`, `Name`, `Type_id`) VALUES
(1, 'SSN', 3),
(2, 'Sequrity_Question', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_option`
--
ALTER TABLE `user_option`
  ADD PRIMARY KEY (`User_option_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_option`
--
ALTER TABLE `user_option`
  MODIFY `User_option_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
