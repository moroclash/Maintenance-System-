-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2016 at 11:30 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 7.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `maintenance1`
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
(1, '22street_cairo', 1),
(2, '22street_giza', 2);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `BILL_id` int(11) NOT NULL,
  `Date_id` int(11) NOT NULL,
  `Cost` int(11) NOT NULL,
  `Payment_method_id` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL,
  `Time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`BILL_id`, `Date_id`, `Cost`, `Payment_method_id`, `Order_id`, `Time`) VALUES
(1, 1, 5454, 1, 1, '05:16:10'),
(2, 2, 24, 2, 2, '05:17:17');

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `Branch_id` int(11) NOT NULL,
  `User_id` varchar(50) NOT NULL,
  `branch_location_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`Branch_id`, `User_id`, `branch_location_id`) VALUES
(1, '1', 1),
(2, '2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `branch_location`
--

CREATE TABLE `branch_location` (
  `Branch_location_id` int(11) NOT NULL,
  `location` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch_location`
--

INSERT INTO `branch_location` (`Branch_location_id`, `location`) VALUES
(1, '54 al3abasia'),
(2, '77 giza');

-- --------------------------------------------------------

--
-- Table structure for table `branch_phone`
--

CREATE TABLE `branch_phone` (
  `Branch_phone` int(11) NOT NULL,
  `Branch_id` int(11) NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch_phone`
--

INSERT INTO `branch_phone` (`Branch_phone`, `Branch_id`, `phone`) VALUES
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
(2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `complain’s_order`
--

CREATE TABLE `complain’s_order` (
  `Complain’s_order_id` int(11) NOT NULL,
  `Message_id` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `date`
--

CREATE TABLE `date` (
  `Date_id` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `date`
--

INSERT INTO `date` (`Date_id`, `Date`) VALUES
(1, '2016-04-11'),
(2, '2016-04-07');

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
(2, 2, 'yhghjkrtyutgrsdtfyguyikokuh');

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
-- Table structure for table `device_option`
--

CREATE TABLE `device_option` (
  `Device_option_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `device_option`
--

INSERT INTO `device_option` (`Device_option_id`, `name`, `type`) VALUES
(1, 'dell', 'computer'),
(2, 'toshipa', 'television');

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
(1, 'acer'),
(2, 'lenovo');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `Feedback_id` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL,
  `System_quality` int(11) NOT NULL,
  `Service_quality` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`Feedback_id`, `Order_id`, `System_quality`, `Service_quality`) VALUES
(1, 1, 5, 3),
(2, 2, 7, 4);

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
  `Physical_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `links`
--

INSERT INTO `links` (`Links_id`, `Function_name`, `Physical_name`) VALUES
(1, '', ''),
(2, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `log_on_content`
--

CREATE TABLE `log_on_content` (
  `Log_on_content_id` int(11) NOT NULL,
  `name` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `Log_on_content_id` int(11) NOT NULL,
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
(2, 'samsung');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `Message_id` int(11) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `Date_id` int(11) NOT NULL,
  `Time` time NOT NULL,
  `Content` varchar(50) NOT NULL,
  `Type_id` int(11) NOT NULL,
  `Parent_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`Message_id`, `sender_id`, `Date_id`, `Time`, `Content`, `Type_id`, `Parent_id`) VALUES
(1, 1, 1, '04:27:16', '', 0, 0),
(2, 1, 1, '05:30:21', 'gfhjjkjjhhgfdgfrthyjukjh', 1, 0),
(3, 2, 2, '12:36:36', '2', 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `message_type`
--

CREATE TABLE `message_type` (
  `Message_type_id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Parent_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `message_type`
--

INSERT INTO `message_type` (`Message_type_id`, `Name`, `Parent_id`) VALUES
(1, 'hhghhg', 1),
(2, 'hvhvh', 2);

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
(1, 'hgbhbj', 1),
(2, 'okiihufghyg', 2);

-- --------------------------------------------------------

--
-- Table structure for table `order_fixable`
--

CREATE TABLE `order_fixable` (
  `Order_fixable_id` int(11) NOT NULL,
  `Requist_id` int(11) NOT NULL,
  `Date_start_id` int(11) NOT NULL,
  `Technical_description` int(11) NOT NULL,
  `Service_id` int(11) NOT NULL,
  `State_id` int(11) NOT NULL,
  `recept_Date_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_fixable`
--

INSERT INTO `order_fixable` (`Order_fixable_id`, `Requist_id`, `Date_start_id`, `Technical_description`, `Service_id`, `State_id`, `recept_Date_id`) VALUES
(1, 1, 1, 1, 1, 1, 1),
(2, 2, 2, 2, 2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `order_flexible_details`
--

CREATE TABLE `order_flexible_details` (
  `Order_flexible_details_id` int(11) NOT NULL,
  `Flexible_id` int(11) NOT NULL,
  `Device_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_flexible_details`
--

INSERT INTO `order_flexible_details` (`Order_flexible_details_id`, `Flexible_id`, `Device_id`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `order_flixer`
--

CREATE TABLE `order_flixer` (
  `Order_flixer_id` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL,
  `Technical_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_flixer`
--

INSERT INTO `order_flixer` (`Order_flixer_id`, `Order_id`, `Technical_id`) VALUES
(1, 1, 1),
(2, 2, 2);

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
  `Pages_selected_option` int(11) NOT NULL,
  `Pages_option_id` int(11) NOT NULL,
  `Page_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pages_selected_option`
--

INSERT INTO `pages_selected_option` (`Pages_selected_option`, `Pages_option_id`, `Page_id`, `name`) VALUES
(1, 1, 1, 'uu'),
(2, 2, 2, 'pp');

-- --------------------------------------------------------

--
-- Table structure for table `parent_methode`
--

CREATE TABLE `parent_methode` (
  `Parent_methode_id` int(11) NOT NULL,
  `Methode` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parent_methode`
--

INSERT INTO `parent_methode` (`Parent_methode_id`, `Methode`) VALUES
(1, 'cash'),
(2, 'visa');

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
(1, 1, '0101232547'),
(2, 2, '01547548');

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
(1, 1, 1, 1),
(2, 2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `Request_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  `Date_id` int(11) NOT NULL,
  `State_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`Request_id`, `User_id`, `Date_id`, `State_id`) VALUES
(1, 1, 1, 1),
(1, 1, 1, 1);

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
(1, 'waht is your favourite sexy woman?'),
(2, 'how many times you do ?');

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
  `Sevice_type_id` int(11) NOT NULL,
  `device_option_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `select_device_option`
--

INSERT INTO `select_device_option` (`Select_device_option_id`, `Sevice_type_id`, `device_option_id`) VALUES
(1, 1, 1),
(2, 2, 2);

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
(1, 'pending'),
(2, 'done');

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
(6, 'bolean');

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
  `gender` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_address`
--

CREATE TABLE `user_address` (
  `User_address_id` int(11) NOT NULL,
  `Address_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, '1', 1),
(2, '2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_selected_option_values`
--

CREATE TABLE `user_selected_option_values` (
  `user_selected_option_values_id` int(11) NOT NULL,
  `User_option_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  `value` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_selected_option_values`
--

INSERT INTO `user_selected_option_values` (`user_selected_option_values_id`, `User_option_id`, `User_id`, `value`) VALUES
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
-- Indexes for table `branch_location`
--
ALTER TABLE `branch_location`
  ADD PRIMARY KEY (`Branch_location_id`);

--
-- Indexes for table `branch_phone`
--
ALTER TABLE `branch_phone`
  ADD PRIMARY KEY (`Branch_phone`);

--
-- Indexes for table `company_have_device`
--
ALTER TABLE `company_have_device`
  ADD PRIMARY KEY (`Company_have_device_id`);

--
-- Indexes for table `complain’s_order`
--
ALTER TABLE `complain’s_order`
  ADD PRIMARY KEY (`Complain’s_order_id`);

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
-- Indexes for table `log_on_content`
--
ALTER TABLE `log_on_content`
  ADD PRIMARY KEY (`Log_on_content_id`);

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
-- Indexes for table `order_fixable`
--
ALTER TABLE `order_fixable`
  ADD PRIMARY KEY (`Order_fixable_id`);

--
-- Indexes for table `order_flexible_details`
--
ALTER TABLE `order_flexible_details`
  ADD PRIMARY KEY (`Order_flexible_details_id`);

--
-- Indexes for table `order_flixer`
--
ALTER TABLE `order_flixer`
  ADD PRIMARY KEY (`Order_flixer_id`);

--
-- Indexes for table `pages_option`
--
ALTER TABLE `pages_option`
  ADD PRIMARY KEY (`Pages_option_id`);

--
-- Indexes for table `pages_selected_option`
--
ALTER TABLE `pages_selected_option`
  ADD PRIMARY KEY (`Pages_selected_option`);

--
-- Indexes for table `parent_methode`
--
ALTER TABLE `parent_methode`
  ADD PRIMARY KEY (`Parent_methode_id`);

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
-- Indexes for table `state`
--
ALTER TABLE `state`
  ADD PRIMARY KEY (`State_id`);

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
  MODIFY `Address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `BILL_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `Branch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `branch_location`
--
ALTER TABLE `branch_location`
  MODIFY `Branch_location_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `branch_phone`
--
ALTER TABLE `branch_phone`
  MODIFY `Branch_phone` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `company_have_device`
--
ALTER TABLE `company_have_device`
  MODIFY `Company_have_device_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `complain’s_order`
--
ALTER TABLE `complain’s_order`
  MODIFY `Complain’s_order_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `date`
--
ALTER TABLE `date`
  MODIFY `Date_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `description`
--
ALTER TABLE `description`
  MODIFY `Description_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `device_option`
--
ALTER TABLE `device_option`
  MODIFY `Device_option_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `device_type`
--
ALTER TABLE `device_type`
  MODIFY `Device_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `Feedback_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
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
-- AUTO_INCREMENT for table `log_on_content`
--
ALTER TABLE `log_on_content`
  MODIFY `Log_on_content_id` int(11) NOT NULL AUTO_INCREMENT;
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
  MODIFY `Main_factor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `Message_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `message_type`
--
ALTER TABLE `message_type`
  MODIFY `Message_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `model`
--
ALTER TABLE `model`
  MODIFY `Model_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `order_fixable`
--
ALTER TABLE `order_fixable`
  MODIFY `Order_fixable_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `order_flexible_details`
--
ALTER TABLE `order_flexible_details`
  MODIFY `Order_flexible_details_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `order_flixer`
--
ALTER TABLE `order_flixer`
  MODIFY `Order_flixer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pages_option`
--
ALTER TABLE `pages_option`
  MODIFY `Pages_option_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pages_selected_option`
--
ALTER TABLE `pages_selected_option`
  MODIFY `Pages_selected_option` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `parent_methode`
--
ALTER TABLE `parent_methode`
  MODIFY `Parent_methode_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
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
  MODIFY `Phone_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `recieved`
--
ALTER TABLE `recieved`
  MODIFY `recieved_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `security_question`
--
ALTER TABLE `security_question`
  MODIFY `Security_question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
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
-- AUTO_INCREMENT for table `state`
--
ALTER TABLE `state`
  MODIFY `State_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `Type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `type_filed_html`
--
ALTER TABLE `type_filed_html`
  MODIFY `Type_file_html_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_user`
--
ALTER TABLE `type_user`
  MODIFY `Type_user_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_address`
--
ALTER TABLE `user_address`
  MODIFY `User_address_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_option`
--
ALTER TABLE `user_option`
  MODIFY `User_option_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
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
