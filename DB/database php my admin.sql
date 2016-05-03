-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 03, 2016 at 08:48 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.5.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `DP_phase2`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `Address_id` int(11) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Parent_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`Address_id`, `Address`, `Parent_id`) VALUES
(1, 'Egypt', 0),
(3, 'Cairo', 1),
(4, 'Giza', 1),
(5, 'Empapa', 4),
(6, 'Wraak', 4),
(7, 'Zmalek', 3),
(8, 'Msdk', 7),
(9, '66', 8),
(10, 'stFore', 5),
(16, '108', 10),
(17, 'ELSook', 6),
(18, '22', 17),
(19, 'Sa3ed', 5),
(20, '12', 19),
(21, 'ELMaadi', 3),
(22, 'soria', 21),
(23, '121', 22),
(24, 'sodaan', 7),
(25, '21', 24);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `BILL_id` int(11) NOT NULL,
  `Date_id` int(11) NOT NULL,
  `Cost` double NOT NULL,
  `Payment_method_id` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL,
  `Time` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`BILL_id`, `Date_id`, `Cost`, `Payment_method_id`, `Order_id`, `Time`) VALUES
(1, 1, 5454, 1, 1, '05:16:10'),
(2, 2, 24, 2, 2, '05:17:17'),
(3, 3, 15648, 1, 5, '05:16:10'),
(4, 4, 4848, 2, 3, '05:17:17'),
(5, 6, 4848, 1, 2, '2:37:48'),
(6, 7, 49845, 1, 8, '12:38:47'),
(7, 9, 1646, 2, 2, '15:48:12');

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `Branch_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  `Address_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`Branch_id`, `User_id`, `Address_id`) VALUES
(1, 18, 20),
(3, 2, 16);

-- --------------------------------------------------------

--
-- Table structure for table `branch_phone`
--

CREATE TABLE `branch_phone` (
  `Branch_phone_id` int(11) NOT NULL,
  `Branch_id` int(11) NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch_phone`
--

INSERT INTO `branch_phone` (`Branch_phone_id`, `Branch_id`, `phone`) VALUES
(1, 1, 10187458),
(2, 2, 12548798);

-- --------------------------------------------------------

--
-- Table structure for table `company_have_device`
--

CREATE TABLE `company_have_device` (
  `Company_have_device_id` int(11) NOT NULL,
  `Main_factor_id` int(11) NOT NULL,
  `Device_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company_have_device`
--

INSERT INTO `company_have_device` (`Company_have_device_id`, `Main_factor_id`, `Device_type_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 3),
(5, 5, 3),
(6, 6, 3),
(7, 7, 3),
(8, 8, 3),
(9, 9, 3),
(10, 10, 3),
(11, 11, 3),
(12, 2, 1),
(13, 5, 1),
(14, 6, 1),
(15, 9, 1),
(16, 10, 1),
(17, 11, 1),
(18, 6, 2),
(19, 10, 2),
(20, 5, 4);

-- --------------------------------------------------------

--
-- Table structure for table `complains_order`
--

CREATE TABLE `complains_order` (
  `Complains_order_id` int(11) NOT NULL,
  `Message_id` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complains_order`
--

INSERT INTO `complains_order` (`Complains_order_id`, `Message_id`, `Order_id`) VALUES
(1, 2, 1),
(2, 11, 3),
(3, 12, 4),
(4, 13, 5),
(5, 14, 6),
(6, 15, 7);

-- --------------------------------------------------------

--
-- Table structure for table `date`
--

CREATE TABLE `date` (
  `Date_id` int(11) NOT NULL,
  `Date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `date`
--

INSERT INTO `date` (`Date_id`, `Date`) VALUES
(1, '2016-04-11'),
(2, '2016-04-07'),
(3, '2016-04-06'),
(4, '2016-05-07'),
(5, '2016-05-08'),
(6, '2016-05-09'),
(7, '2016-05-10'),
(8, '2016-05-11'),
(11, '2016-05-12'),
(12, '2016-06-11'),
(13, '2016-07-12'),
(14, '2016-08-10'),
(15, '2016-03-05');

-- --------------------------------------------------------

--
-- Table structure for table `description`
--

CREATE TABLE `description` (
  `Description_id` int(11) NOT NULL,
  `Device_id` int(11) NOT NULL,
  `Description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `description`
--

INSERT INTO `description` (`Description_id`, `Device_id`, `Description`) VALUES
(1, 1, 'hjghghhjhhghghghghhvyyv y'),
(2, 2, 'yhghjkrtyutgrsdtfyguyikokuh'),
(3, 3, 'sdfafewfewf'),
(4, 4, 'asklfnkjfqewjkfe'),
(5, 5, 'ewflweflkwenflkew'),
(6, 6, 'asdlmasdoeawifnewf'),
(7, 7, 'asdhyuvwqdhbwqjdwqhjd'),
(8, 8, 'qwdhjqwvdyqwvddw'),
(9, 9, 'wqdbqydgwgdd'),
(10, 10, 'qwdhqwdyuwqgydug'),
(11, 11, 'qwdbgddywvyuwq'),
(12, 12, 'qwdhjqwgdwdwqd');

-- --------------------------------------------------------

--
-- Table structure for table `details_bill`
--

CREATE TABLE `details_bill` (
  `Details_bill_id` int(11) NOT NULL,
  `Spare_parts_id` int(11) NOT NULL,
  `Bill_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `details_bill`
--

INSERT INTO `details_bill` (`Details_bill_id`, `Spare_parts_id`, `Bill_id`) VALUES
(1, 3, 1),
(2, 5, 2),
(3, 1, 3),
(4, 2, 4),
(5, 4, 5),
(6, 7, 6),
(7, 8, 7);

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

CREATE TABLE `device` (
  `Device_id` int(11) NOT NULL,
  `Model_Id` int(11) NOT NULL,
  `State_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `device`
--

INSERT INTO `device` (`Device_id`, `Model_Id`, `State_id`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `device_of_this_request`
--

CREATE TABLE `device_of_this_request` (
  `Device_of_this_request_id` int(11) NOT NULL,
  `Request_id` int(11) NOT NULL,
  `Device_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `device_of_this_request`
--

INSERT INTO `device_of_this_request` (`Device_of_this_request_id`, `Request_id`, `Device_id`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `device_option`
--

CREATE TABLE `device_option` (
  `Device_option_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `device_option`
--

INSERT INTO `device_option` (`Device_option_id`, `name`, `type_id`) VALUES
(1, 'dell', 0),
(2, 'toshipa', 0);

-- --------------------------------------------------------

--
-- Table structure for table `device_type`
--

CREATE TABLE `device_type` (
  `Device_type_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `device_type`
--

INSERT INTO `device_type` (`Device_type_id`, `name`) VALUES
(1, 'Computer'),
(2, 'Tv'),
(3, 'Mobile'),
(4, 'Wacher');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `Feedback_id` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL,
  `System_quality` int(11) NOT NULL,
  `Service_quality` int(11) NOT NULL,
  `Branch_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`Feedback_id`, `Order_id`, `System_quality`, `Service_quality`, `Branch_id`) VALUES
(1, 1, 5, 3, 0),
(2, 2, 7, 4, 0),
(3, 3, 8, 4, 1),
(4, 4, 9, 7, 2),
(5, 5, 9, 8, 1),
(6, 6, 7, 8, 2),
(7, 7, 8, 9, 1),
(8, 8, 8, 8, 2),
(9, 9, 9, 9, 1);

-- --------------------------------------------------------

--
-- Table structure for table `filed_html`
--

CREATE TABLE `filed_html` (
  `Filed_html_id` int(11) NOT NULL,
  `Html` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `filed_html`
--

INSERT INTO `filed_html` (`Filed_html_id`, `Html`) VALUES
(1, '<form>\r\n<input type="submit" >mohamed</input>\r\n\r\n</form>'),
(2, '<form>\r\n<input type="submit" >omar</input>\r\n\r\n</form>');

-- --------------------------------------------------------

--
-- Table structure for table `links`
--

CREATE TABLE `links` (
  `Links_id` int(11) NOT NULL,
  `Function_name` varchar(50) NOT NULL,
  `Physical_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `links`
--

INSERT INTO `links` (`Links_id`, `Function_name`, `Physical_name`) VALUES
(1, '', ''),
(2, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `log_on_option`
--

CREATE TABLE `log_on_option` (
  `Log_on_option_id` int(11) NOT NULL COMMENT ' ',
  `Name` varchar(50) NOT NULL,
  `Type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `log_on_select_option`
--

CREATE TABLE `log_on_select_option` (
  `Log_on_select_option_id` int(11) NOT NULL,
  `Links_id` int(11) NOT NULL,
  `Log_on_option_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `log_on_select_value`
--

CREATE TABLE `log_on_select_value` (
  `Log_on_select_value_id` int(11) NOT NULL,
  `Log_on_select_id` int(11) NOT NULL,
  `value` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `main_factor`
--

CREATE TABLE `main_factor` (
  `Main_factor_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `main_factor`
--

INSERT INTO `main_factor` (`Main_factor_id`, `name`) VALUES
(1, 'toshiba'),
(2, 'samsung'),
(3, 'hawaii'),
(4, 'Nokia'),
(5, 'apple'),
(6, 'LG'),
(7, 'G-tide'),
(8, 'Hisence'),
(9, 'Lenovo'),
(10, 'HP'),
(11, 'Acer');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `Message_id` int(11) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `Date_id` int(11) NOT NULL,
  `Time` varchar(30) NOT NULL,
  `Content` text NOT NULL,
  `Type_id` int(11) NOT NULL,
  `Parent_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`Message_id`, `sender_id`, `Date_id`, `Time`, `Content`, `Type_id`, `Parent_id`) VALUES
(1, 1, 1, '04:27:16', '', 0, 0),
(2, 1, 1, '05:30:21', 'gfhjjkjjhhgfdgfrthyjukjh', 1, 0),
(3, 2, 2, '12:36:36', '2', 2, 0),
(4, 1, 2, '12:25', 'msajdlaskdjlkjldkjalskdjl', 3, 2),
(5, 1, 2, '12:44', 'dasdkjlkasjdkl', 3, 2),
(11, 4, 7, '18:44:14', 'this is my complain', 1, 0),
(12, 8, 2, '12:46:17', 'this is my complain yaaaaad', 1, 0),
(13, 4, 1, '12:47:26', 'this is my complain yaaaaad msh ha2olaak :)', 1, 0),
(14, 6, 6, '14:52:27', 'bs hya mo4kla kbera', 1, 0),
(15, 4, 8, '12:45:46', 'bs brdo msh ha2olak :)', 1, 0),
(16, 6, 8, '17:15:13', 'de genealllllll ', 2, 0),
(17, 8, 7, '17:56:21', 'w de kamaaaan ', 2, 0),
(18, 2, 9, '14:48:14', 'w 2nt 3amel 2h delwa2ty', 2, 0),
(19, 9, 3, '17:17', 'da b2a notify ', 4, 0),
(20, 10, 10, '16:45', 'ya3ny type id 4', 4, 0);

-- --------------------------------------------------------

--
-- Table structure for table `message_type`
--

CREATE TABLE `message_type` (
  `Message_type_id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `message_type`
--

INSERT INTO `message_type` (`Message_type_id`, `Name`) VALUES
(1, 'Complain'),
(2, 'General'),
(3, 'comments'),
(4, 'notify');

-- --------------------------------------------------------

--
-- Table structure for table `model`
--

CREATE TABLE `model` (
  `Model_id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Comp_device_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `model`
--

INSERT INTO `model` (`Model_id`, `Name`, `Comp_device_id`) VALUES
(1, 'Z1', 1),
(2, 'SS5', 2);

-- --------------------------------------------------------

--
-- Table structure for table `offer_bill`
--

CREATE TABLE `offer_bill` (
  `Offer_bill_id` int(11) NOT NULL,
  `Offer` int(11) NOT NULL,
  `Bill_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order_fixable`
--

CREATE TABLE `order_fixable` (
  `Order_fixable_id` int(11) NOT NULL,
  `Requist_id` int(11) NOT NULL,
  `Date_start_id` int(11) NOT NULL,
  `Technical_description` text NOT NULL,
  `Service_id` int(11) NOT NULL,
  `State_id` int(11) NOT NULL,
  `recept_Date_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_fixable`
--

INSERT INTO `order_fixable` (`Order_fixable_id`, `Requist_id`, `Date_start_id`, `Technical_description`, `Service_id`, `State_id`, `recept_Date_id`) VALUES
(1, 4, 1, 'Error in Motor', 1, 1, 1),
(2, 6, 2, 'Fix fan', 2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `order_fixer`
--

CREATE TABLE `order_fixer` (
  `Technical_id` int(11) NOT NULL,
  `Device_of_this_request_id` int(11) NOT NULL,
  `order_flixer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pages_option`
--

CREATE TABLE `pages_option` (
  `Pages_option_id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Type_file_html_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pages_option`
--

INSERT INTO `pages_option` (`Pages_option_id`, `Name`, `Type_file_html_id`) VALUES
(1, 'jj', 1),
(2, 'kk', 2);

-- --------------------------------------------------------

--
-- Table structure for table `pages_selected_option`
--

CREATE TABLE `pages_selected_option` (
  `Pages_selected_option_id` int(11) NOT NULL,
  `Pages_option_id` int(11) NOT NULL,
  `Link_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pages_selected_option`
--

INSERT INTO `pages_selected_option` (`Pages_selected_option_id`, `Pages_option_id`, `Link_id`, `name`) VALUES
(1, 1, 1, 'uu'),
(2, 2, 2, 'pp');

-- --------------------------------------------------------

--
-- Table structure for table `payment_methode`
--

CREATE TABLE `payment_methode` (
  `Payment_methode_id` int(11) NOT NULL,
  `Methode` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_methode`
--

INSERT INTO `payment_methode` (`Payment_methode_id`, `Methode`) VALUES
(1, 'cash'),
(2, 'visa'),
(3, 'PayPal');

-- --------------------------------------------------------

--
-- Table structure for table `payment_option`
--

CREATE TABLE `payment_option` (
  `Payment_option_id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_option`
--

INSERT INTO `payment_option` (`Payment_option_id`, `Name`, `Type_id`) VALUES
(1, 'fullname', 1),
(2, 'address', 2);

-- --------------------------------------------------------

--
-- Table structure for table `payment_option_select`
--

CREATE TABLE `payment_option_select` (
  `Payment_option_select_id` int(11) NOT NULL,
  `Payment_method_id` int(11) NOT NULL,
  `Payment_option_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_option_select`
--

INSERT INTO `payment_option_select` (`Payment_option_select_id`, `Payment_method_id`, `Payment_option_id`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `payment_values`
--

CREATE TABLE `payment_values` (
  `Payment_values_id` int(11) NOT NULL,
  `payment_option_selected_id` int(11) NOT NULL,
  `Bill_id` int(11) NOT NULL,
  `value` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_values`
--

INSERT INTO `payment_values` (`Payment_values_id`, `payment_option_selected_id`, `Bill_id`, `value`) VALUES
(1, 1, 1, 'mohamed'),
(2, 2, 2, '0123');

-- --------------------------------------------------------

--
-- Table structure for table `phone`
--

CREATE TABLE `phone` (
  `Phone_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  `Phone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phone`
--

INSERT INTO `phone` (`Phone_id`, `User_id`, `Phone`) VALUES
(1, 1, '1111111111'),
(2, 2, '01547548'),
(4, 2, '11545454545'),
(5, 2, '4877878787');

-- --------------------------------------------------------

--
-- Table structure for table `recieved`
--

CREATE TABLE `recieved` (
  `recieved_id` int(11) NOT NULL,
  `Reciever_id` int(11) NOT NULL,
  `Message_id` int(11) NOT NULL,
  `State_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recieved`
--

INSERT INTO `recieved` (`recieved_id`, `Reciever_id`, `Message_id`, `State_id`) VALUES
(1, 1, 1, 3),
(2, 2, 2, 2),
(3, 2, -1, 5),
(4, 2, -1, 5),
(5, 2, -1, 5),
(6, 2, -1, 5),
(7, 2, -1, 5),
(8, 2, -1, 5),
(9, 2, -1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `Request_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  `Date_id` int(11) NOT NULL,
  `State_id` int(11) NOT NULL DEFAULT '5',
  `Address_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`Request_id`, `User_id`, `Date_id`, `State_id`, `Address_id`) VALUES
(1, 5, 2, 5, 25),
(2, 19, 3, 5, 23),
(3, 5, 4, 5, 16),
(4, 5, 6, 11, 18),
(5, 20, 9, 1, 9),
(21, 2, 3, 11, 16);

-- --------------------------------------------------------

--
-- Table structure for table `security_question`
--

CREATE TABLE `security_question` (
  `Security_question_id` int(11) NOT NULL,
  `Question` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `security_question`
--

INSERT INTO `security_question` (`Security_question_id`, `Question`) VALUES
(1, 'waht is your favourite hopy?'),
(2, 'how many times you do ?'),
(3, 'What is your favorite teacher ?'),
(4, 'What is your favorite pet ?'),
(5, 'what is your best food?'),
(6, 'who is your Best Friend ?');

-- --------------------------------------------------------

--
-- Table structure for table `selected_device_option_values`
--

CREATE TABLE `selected_device_option_values` (
  `Selected_device_option_values_id` int(11) NOT NULL,
  `Model_id` int(11) NOT NULL,
  `Selected_device_id` int(11) NOT NULL,
  `Value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `select_device_option`
--

CREATE TABLE `select_device_option` (
  `Select_device_option_id` int(11) NOT NULL,
  `Device_type_id` int(11) NOT NULL,
  `device_option_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `select_device_option`
--

INSERT INTO `select_device_option` (`Select_device_option_id`, `Device_type_id`, `device_option_id`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `spare_parts`
--

CREATE TABLE `spare_parts` (
  `Spare_parts_id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Cost` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spare_parts`
--

INSERT INTO `spare_parts` (`Spare_parts_id`, `Name`, `Cost`) VALUES
(1, 'Screaan', 50),
(2, 'Cover', 20),
(3, 'engine', 200),
(4, 'Motor', 1000),
(5, 'chaseh', 750),
(6, 'remote', 120),
(7, 'bnsa', 30);

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE `state` (
  `State_id` int(11) NOT NULL,
  `State` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`State_id`, `State`) VALUES
(1, 'Accepted'),
(2, 'done'),
(3, 'Wait_fix'),
(4, 'Seen'),
(5, 'Not_seen'),
(6, 'Sender_delete_massage'),
(7, 'Reciver_delete_massage'),
(8, 'Commint'),
(9, 'Cancel'),
(10, 'reterned_order'),
(11, 'Done_replied');

-- --------------------------------------------------------

--
-- Table structure for table `subscribe`
--

CREATE TABLE `subscribe` (
  `Subscribe_id` int(11) NOT NULL,
  `Branch_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subscribe`
--

INSERT INTO `subscribe` (`Subscribe_id`, `Branch_id`, `User_id`) VALUES
(1, 1, 5),
(2, 1, 19),
(3, 3, 20);

-- --------------------------------------------------------

--
-- Table structure for table `time_choosed`
--

CREATE TABLE `time_choosed` (
  `Time_choosed_id` int(11) NOT NULL,
  `Time_chooser_id` int(11) NOT NULL,
  `Branch_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `time_choosed`
--

INSERT INTO `time_choosed` (`Time_choosed_id`, `Time_chooser_id`, `Branch_id`) VALUES
(1, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `time_chooser`
--

CREATE TABLE `time_chooser` (
  `Time_chooser_id` int(11) NOT NULL,
  `Request_id` int(11) NOT NULL,
  `Times` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `time_chooser`
--

INSERT INTO `time_chooser` (`Time_chooser_id`, `Request_id`, `Times`) VALUES
(1, 5, '2016-08-9'),
(2, 5, '2016-08-10'),
(3, 5, '2016-08-10'),
(4, 4, '2016-09-09'),
(5, 4, '2016-09-10'),
(6, 4, '2016-09-15');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `Type_id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`Type_id`, `Name`) VALUES
(1, 'int'),
(2, 'float'),
(3, 'text'),
(4, 'date'),
(5, 'time'),
(6, 'bolean'),
(7, 'double');

-- --------------------------------------------------------

--
-- Table structure for table `type_filed_html`
--

CREATE TABLE `type_filed_html` (
  `Type_file_html_id` int(11) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Filed_html_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_user`
--

CREATE TABLE `type_user` (
  `Type_user_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `parent_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type_user`
--

INSERT INTO `type_user` (`Type_user_id`, `name`, `parent_id`) VALUES
(1, 'Admain', 0),
(2, 'Manager', 1),
(3, 'Service', 2),
(4, 'Tecnichal', 2),
(5, 'Customer', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `User_id` int(11) NOT NULL,
  `Fname` varchar(50) NOT NULL,
  `Lname` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `gender` int(11) NOT NULL,
  `Type_id` int(11) NOT NULL,
  `Block` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_id`, `Fname`, `Lname`, `Password`, `Email`, `gender`, `Type_id`, `Block`) VALUES
(1, 'Omar', 'Mohamed', 'moro12345', 'mmoroclash@gmail.com', 1, 1, 0),
(2, 'Emad', 'Sayed', 'emad12345', 'emadsayedd@gmail.com', 1, 2, 0),
(3, 'Rdwaan', 'mohamed', '2nas1234', 'mohamedelnagm211@gmail.com', 2, 4, 1),
(4, 'ahmed', 'ayman', 'sad18987', 'ahyman@hotmail.com', 1, 3, 0),
(5, 'mohamed', 'assem', '8sa9d1d9', 'mohasem@gmail.com', 1, 5, 0),
(18, 'soso', 'Magy', 'soso1234', 'soso@gmail.com', 2, 2, 0),
(19, 'samy', 'moha', 'asmy1234', 'asmy@gmail.com', 1, 5, 0),
(20, 'tfeda', 'tfeda', 'tfeda1234', 'tfeda@gmail.com', 2, 5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_address`
--

CREATE TABLE `user_address` (
  `User_address_id` int(11) NOT NULL,
  `Address_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_address`
--

INSERT INTO `user_address` (`User_address_id`, `Address_id`, `User_id`) VALUES
(1, 9, 1),
(2, 18, 1),
(3, 16, 2),
(4, 20, 3),
(5, 23, 4),
(8, 23, 5),
(9, 25, 20);

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
(1, 'SSN', 7),
(2, 'Sequrity_Question_id', 1),
(3, 'Salary', 6),
(4, 'Age', 1),
(5, 'Branch_id', 1),
(6, 'Answer_question', 4),
(7, 'Birth_date', 3),
(8, 'Work_hours', 1),
(9, 'Reagion_id', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_selected_option`
--

CREATE TABLE `user_selected_option` (
  `User_selected_option_id` int(11) NOT NULL,
  `User_type_id` int(11) NOT NULL,
  `User_option_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_selected_option`
--

INSERT INTO `user_selected_option` (`User_selected_option_id`, `User_type_id`, `User_option_id`) VALUES
(1, 1, 3),
(2, 1, 4),
(3, 1, 1),
(4, 2, 1),
(5, 2, 3),
(6, 2, 4),
(7, 2, 5),
(8, 2, 7),
(9, 2, 8),
(10, 3, 1),
(11, 3, 3),
(12, 3, 4),
(13, 3, 5),
(14, 3, 7),
(15, 3, 8),
(16, 4, 1),
(17, 4, 3),
(18, 4, 4),
(19, 4, 5),
(20, 4, 7),
(21, 4, 8),
(22, 4, 9),
(23, 5, 2),
(24, 5, 6);

-- --------------------------------------------------------

--
-- Table structure for table `user_selected_option_values`
--

CREATE TABLE `user_selected_option_values` (
  `user_selected_option_values_id` int(11) NOT NULL,
  `User_selected_option_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  `value` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_selected_option_values`
--

INSERT INTO `user_selected_option_values` (`user_selected_option_values_id`, `User_selected_option_id`, `User_id`, `value`) VALUES
(1, 1, 1, '2135465797'),
(2, 2, 2, '8');

-- --------------------------------------------------------

--
-- Table structure for table `user_type_links`
--

CREATE TABLE `user_type_links` (
  `User_type_links_id` int(11) NOT NULL,
  `User_type_id` int(11) NOT NULL,
  `Link_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`Address_id`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`BILL_id`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`Branch_id`);

--
-- Indexes for table `branch_phone`
--
ALTER TABLE `branch_phone`
  ADD PRIMARY KEY (`Branch_phone_id`);

--
-- Indexes for table `company_have_device`
--
ALTER TABLE `company_have_device`
  ADD PRIMARY KEY (`Company_have_device_id`);

--
-- Indexes for table `complains_order`
--
ALTER TABLE `complains_order`
  ADD PRIMARY KEY (`Complains_order_id`);

--
-- Indexes for table `date`
--
ALTER TABLE `date`
  ADD PRIMARY KEY (`Date_id`);

--
-- Indexes for table `description`
--
ALTER TABLE `description`
  ADD PRIMARY KEY (`Description_id`);

--
-- Indexes for table `details_bill`
--
ALTER TABLE `details_bill`
  ADD PRIMARY KEY (`Details_bill_id`);

--
-- Indexes for table `device`
--
ALTER TABLE `device`
  ADD PRIMARY KEY (`Device_id`);

--
-- Indexes for table `device_of_this_request`
--
ALTER TABLE `device_of_this_request`
  ADD PRIMARY KEY (`Device_of_this_request_id`);

--
-- Indexes for table `device_option`
--
ALTER TABLE `device_option`
  ADD PRIMARY KEY (`Device_option_id`);

--
-- Indexes for table `device_type`
--
ALTER TABLE `device_type`
  ADD PRIMARY KEY (`Device_type_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`Feedback_id`);

--
-- Indexes for table `filed_html`
--
ALTER TABLE `filed_html`
  ADD PRIMARY KEY (`Filed_html_id`);

--
-- Indexes for table `links`
--
ALTER TABLE `links`
  ADD PRIMARY KEY (`Links_id`);

--
-- Indexes for table `log_on_option`
--
ALTER TABLE `log_on_option`
  ADD PRIMARY KEY (`Log_on_option_id`);

--
-- Indexes for table `log_on_select_option`
--
ALTER TABLE `log_on_select_option`
  ADD PRIMARY KEY (`Log_on_select_option_id`);

--
-- Indexes for table `log_on_select_value`
--
ALTER TABLE `log_on_select_value`
  ADD PRIMARY KEY (`Log_on_select_value_id`);

--
-- Indexes for table `main_factor`
--
ALTER TABLE `main_factor`
  ADD PRIMARY KEY (`Main_factor_id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`Message_id`);

--
-- Indexes for table `message_type`
--
ALTER TABLE `message_type`
  ADD PRIMARY KEY (`Message_type_id`);

--
-- Indexes for table `model`
--
ALTER TABLE `model`
  ADD PRIMARY KEY (`Model_id`);

--
-- Indexes for table `offer_bill`
--
ALTER TABLE `offer_bill`
  ADD PRIMARY KEY (`Offer_bill_id`);

--
-- Indexes for table `order_fixable`
--
ALTER TABLE `order_fixable`
  ADD PRIMARY KEY (`Order_fixable_id`);

--
-- Indexes for table `order_fixer`
--
ALTER TABLE `order_fixer`
  ADD PRIMARY KEY (`order_flixer_id`);

--
-- Indexes for table `pages_option`
--
ALTER TABLE `pages_option`
  ADD PRIMARY KEY (`Pages_option_id`);

--
-- Indexes for table `pages_selected_option`
--
ALTER TABLE `pages_selected_option`
  ADD PRIMARY KEY (`Pages_selected_option_id`);

--
-- Indexes for table `payment_methode`
--
ALTER TABLE `payment_methode`
  ADD PRIMARY KEY (`Payment_methode_id`);

--
-- Indexes for table `payment_option`
--
ALTER TABLE `payment_option`
  ADD PRIMARY KEY (`Payment_option_id`);

--
-- Indexes for table `payment_option_select`
--
ALTER TABLE `payment_option_select`
  ADD PRIMARY KEY (`Payment_option_select_id`);

--
-- Indexes for table `payment_values`
--
ALTER TABLE `payment_values`
  ADD PRIMARY KEY (`Payment_values_id`);

--
-- Indexes for table `phone`
--
ALTER TABLE `phone`
  ADD PRIMARY KEY (`Phone_id`);

--
-- Indexes for table `recieved`
--
ALTER TABLE `recieved`
  ADD PRIMARY KEY (`recieved_id`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`Request_id`);

--
-- Indexes for table `security_question`
--
ALTER TABLE `security_question`
  ADD PRIMARY KEY (`Security_question_id`);

--
-- Indexes for table `selected_device_option_values`
--
ALTER TABLE `selected_device_option_values`
  ADD PRIMARY KEY (`Selected_device_option_values_id`);

--
-- Indexes for table `select_device_option`
--
ALTER TABLE `select_device_option`
  ADD PRIMARY KEY (`Select_device_option_id`);

--
-- Indexes for table `spare_parts`
--
ALTER TABLE `spare_parts`
  ADD PRIMARY KEY (`Spare_parts_id`);

--
-- Indexes for table `state`
--
ALTER TABLE `state`
  ADD PRIMARY KEY (`State_id`);

--
-- Indexes for table `subscribe`
--
ALTER TABLE `subscribe`
  ADD PRIMARY KEY (`Subscribe_id`);

--
-- Indexes for table `time_choosed`
--
ALTER TABLE `time_choosed`
  ADD PRIMARY KEY (`Time_choosed_id`);

--
-- Indexes for table `time_chooser`
--
ALTER TABLE `time_chooser`
  ADD PRIMARY KEY (`Time_chooser_id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`Type_id`);

--
-- Indexes for table `type_filed_html`
--
ALTER TABLE `type_filed_html`
  ADD PRIMARY KEY (`Type_file_html_id`);

--
-- Indexes for table `type_user`
--
ALTER TABLE `type_user`
  ADD PRIMARY KEY (`Type_user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`User_id`);

--
-- Indexes for table `user_address`
--
ALTER TABLE `user_address`
  ADD PRIMARY KEY (`User_address_id`);

--
-- Indexes for table `user_option`
--
ALTER TABLE `user_option`
  ADD PRIMARY KEY (`User_option_id`);

--
-- Indexes for table `user_selected_option`
--
ALTER TABLE `user_selected_option`
  ADD PRIMARY KEY (`User_selected_option_id`);

--
-- Indexes for table `user_selected_option_values`
--
ALTER TABLE `user_selected_option_values`
  ADD PRIMARY KEY (`user_selected_option_values_id`);

--
-- Indexes for table `user_type_links`
--
ALTER TABLE `user_type_links`
  ADD PRIMARY KEY (`User_type_links_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `Address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `BILL_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `Branch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `branch_phone`
--
ALTER TABLE `branch_phone`
  MODIFY `Branch_phone_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `company_have_device`
--
ALTER TABLE `company_have_device`
  MODIFY `Company_have_device_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `complains_order`
--
ALTER TABLE `complains_order`
  MODIFY `Complains_order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `date`
--
ALTER TABLE `date`
  MODIFY `Date_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `description`
--
ALTER TABLE `description`
  MODIFY `Description_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `details_bill`
--
ALTER TABLE `details_bill`
  MODIFY `Details_bill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `device`
--
ALTER TABLE `device`
  MODIFY `Device_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `device_of_this_request`
--
ALTER TABLE `device_of_this_request`
  MODIFY `Device_of_this_request_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `device_option`
--
ALTER TABLE `device_option`
  MODIFY `Device_option_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `device_type`
--
ALTER TABLE `device_type`
  MODIFY `Device_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `Feedback_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `filed_html`
--
ALTER TABLE `filed_html`
  MODIFY `Filed_html_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `links`
--
ALTER TABLE `links`
  MODIFY `Links_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `log_on_option`
--
ALTER TABLE `log_on_option`
  MODIFY `Log_on_option_id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' ';
--
-- AUTO_INCREMENT for table `log_on_select_option`
--
ALTER TABLE `log_on_select_option`
  MODIFY `Log_on_select_option_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `log_on_select_value`
--
ALTER TABLE `log_on_select_value`
  MODIFY `Log_on_select_value_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `main_factor`
--
ALTER TABLE `main_factor`
  MODIFY `Main_factor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `Message_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `message_type`
--
ALTER TABLE `message_type`
  MODIFY `Message_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `model`
--
ALTER TABLE `model`
  MODIFY `Model_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `offer_bill`
--
ALTER TABLE `offer_bill`
  MODIFY `Offer_bill_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `order_fixable`
--
ALTER TABLE `order_fixable`
  MODIFY `Order_fixable_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `order_fixer`
--
ALTER TABLE `order_fixer`
  MODIFY `order_flixer_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pages_option`
--
ALTER TABLE `pages_option`
  MODIFY `Pages_option_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pages_selected_option`
--
ALTER TABLE `pages_selected_option`
  MODIFY `Pages_selected_option_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `payment_methode`
--
ALTER TABLE `payment_methode`
  MODIFY `Payment_methode_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `payment_option`
--
ALTER TABLE `payment_option`
  MODIFY `Payment_option_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `payment_option_select`
--
ALTER TABLE `payment_option_select`
  MODIFY `Payment_option_select_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `payment_values`
--
ALTER TABLE `payment_values`
  MODIFY `Payment_values_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `phone`
--
ALTER TABLE `phone`
  MODIFY `Phone_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `recieved`
--
ALTER TABLE `recieved`
  MODIFY `recieved_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `Request_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `security_question`
--
ALTER TABLE `security_question`
  MODIFY `Security_question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `selected_device_option_values`
--
ALTER TABLE `selected_device_option_values`
  MODIFY `Selected_device_option_values_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `select_device_option`
--
ALTER TABLE `select_device_option`
  MODIFY `Select_device_option_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `spare_parts`
--
ALTER TABLE `spare_parts`
  MODIFY `Spare_parts_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `state`
--
ALTER TABLE `state`
  MODIFY `State_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `subscribe`
--
ALTER TABLE `subscribe`
  MODIFY `Subscribe_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `time_choosed`
--
ALTER TABLE `time_choosed`
  MODIFY `Time_choosed_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `time_chooser`
--
ALTER TABLE `time_chooser`
  MODIFY `Time_chooser_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `Type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `type_filed_html`
--
ALTER TABLE `type_filed_html`
  MODIFY `Type_file_html_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_user`
--
ALTER TABLE `type_user`
  MODIFY `Type_user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `user_address`
--
ALTER TABLE `user_address`
  MODIFY `User_address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user_option`
--
ALTER TABLE `user_option`
  MODIFY `User_option_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user_selected_option`
--
ALTER TABLE `user_selected_option`
  MODIFY `User_selected_option_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `user_selected_option_values`
--
ALTER TABLE `user_selected_option_values`
  MODIFY `user_selected_option_values_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user_type_links`
--
ALTER TABLE `user_type_links`
  MODIFY `User_type_links_id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
