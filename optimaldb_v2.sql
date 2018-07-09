-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 04, 2018 at 01:59 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `optimaldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `category_items`
--

CREATE TABLE `category_items` (
  `category_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_quantity` int(11) NOT NULL,
  `added_by` int(11) NOT NULL,
  `added_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` int(11) NOT NULL,
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `removed` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `cleaning_category`
--

CREATE TABLE `cleaning_category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(30) NOT NULL,
  `added_by` int(11) NOT NULL,
  `added_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` int(11) NOT NULL,
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `removed` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cleaning_category`
--

INSERT INTO `cleaning_category` (`category_id`, `category_name`, `added_by`, `added_date`, `updated_by`, `updated_date`, `removed`) VALUES
(1, 'General Cleaning', 1, '2018-07-03 19:16:02', 1, '2018-07-04 10:32:50', 0),
(2, 'Carpet Cleaning', 1, '2018-07-04 10:41:39', 1, '2018-07-04 10:41:39', 0),
(3, 'Upholstery Cleaning', 1, '2018-07-04 11:56:27', 1, '2018-07-04 11:56:27', 0);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `item_id` int(11) NOT NULL,
  `item_name` varchar(30) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '0',
  `metric` varchar(15) NOT NULL,
  `type` int(11) NOT NULL,
  `added_by` int(11) NOT NULL,
  `added_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` int(11) NOT NULL,
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `removed` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_id`, `item_name`, `quantity`, `metric`, `type`, `added_by`, `added_date`, `updated_by`, `updated_date`, `removed`) VALUES
(1, 'Rainbow Hydro Machine', 5, 'units', 1, 1, '2018-07-04 11:19:28', 1, '2018-07-04 11:19:28', 0),
(2, 'Steam Vacuum', 4, 'units', 1, 1, '2018-07-04 11:20:20', 1, '2018-07-04 11:20:20', 0),
(3, 'Ladder', 4, 'pcs', 2, 1, '2018-07-04 11:21:09', 1, '2018-07-04 11:21:09', 0),
(4, 'Squeegee', 10, 'pcs', 2, 1, '2018-07-04 11:23:14', 1, '2018-07-04 11:23:14', 0),
(5, '3-Meter Pole and Pads', 5, 'sets', 2, 1, '2018-07-04 11:23:14', 1, '2018-07-04 11:24:55', 0),
(6, 'Micro-Fiber Cloth', 20, 'pcs', 2, 1, '2018-07-04 11:31:00', 1, '2018-07-04 11:31:00', 0),
(7, '3-Meter Micro-Fiber Cloth', 10, 'pcs', 2, 1, '2018-07-04 11:31:51', 1, '2018-07-04 11:31:51', 0),
(8, 'Round Rags', 30, 'pcs', 2, 1, '2018-07-04 11:32:34', 1, '2018-07-04 11:32:34', 0),
(9, 'Towel Rug', 10, 'pcs', 2, 1, '2018-07-04 11:54:41', 1, '2018-07-04 11:54:41', 0),
(10, 'Mop and Pail', 15, 'sets', 2, 1, '2018-07-04 11:54:41', 1, '2018-07-04 11:54:41', 0);

-- --------------------------------------------------------

--
-- Table structure for table `item_type`
--

CREATE TABLE `item_type` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(20) NOT NULL,
  `type_details` varchar(50) NOT NULL,
  `added_by` int(11) NOT NULL,
  `added_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` int(11) NOT NULL,
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `removed` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item_type`
--

INSERT INTO `item_type` (`type_id`, `type_name`, `type_details`, `added_by`, `added_date`, `updated_by`, `updated_date`, `removed`) VALUES
(1, 'Equipment', 'Item that requires operation', 1, '2018-07-04 11:17:33', 1, '2018-07-04 11:17:33', 0),
(2, 'Material', 'Item that does not require operation', 1, '2018-07-04 11:17:33', 1, '2018-07-04 11:17:33', 0),
(3, 'Cleaning Solution', 'Item of liquid form used as a cleaning agent', 1, '2018-07-04 11:27:38', 1, '2018-07-04 11:27:38', 0);

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE `job` (
  `job_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `added_by` int(11) NOT NULL,
  `added_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` int(11) NOT NULL,
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `removed` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(50) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` int(11) DEFAULT NULL,
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `removed` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `full_name`, `added_by`, `added_date`, `updated_by`, `updated_date`, `removed`) VALUES
(1, 'ethanray123', 'a8a15b23947dffe7d28e9beba511832', 'Ethan Ray F. Mosqueda', NULL, '2018-07-02 15:57:25', 1, '2018-07-03 23:05:59', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category_items`
--
ALTER TABLE `category_items`
  ADD KEY `item_id` (`item_id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `added_by` (`added_by`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `cleaning_category`
--
ALTER TABLE `cleaning_category`
  ADD PRIMARY KEY (`category_id`),
  ADD KEY `cle_category_addedby_admin_id` (`added_by`),
  ADD KEY `cle_category_updatedby_admin_id` (`updated_by`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `type` (`type`,`added_by`,`updated_by`),
  ADD KEY `item_addedby_admin_id` (`added_by`),
  ADD KEY `item_updated_admin_id` (`updated_by`);

--
-- Indexes for table `item_type`
--
ALTER TABLE `item_type`
  ADD PRIMARY KEY (`type_id`),
  ADD KEY `added_by` (`added_by`,`updated_by`),
  ADD KEY `item_type_updatedby_admin_id` (`updated_by`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`job_id`),
  ADD KEY `job_addedby_admin_id` (`added_by`),
  ADD KEY `job_updatedby_admin_id` (`updated_by`),
  ADD KEY `job_category_id` (`category_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `added_by` (`added_by`),
  ADD KEY `updated_by` (`updated_by`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cleaning_category`
--
ALTER TABLE `cleaning_category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `item_type`
--
ALTER TABLE `item_type`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `job`
--
ALTER TABLE `job`
  MODIFY `job_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `category_items`
--
ALTER TABLE `category_items`
  ADD CONSTRAINT `cat_item_addedby_admin_id` FOREIGN KEY (`added_by`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `cat_item_category_id` FOREIGN KEY (`category_id`) REFERENCES `cleaning_category` (`category_id`),
  ADD CONSTRAINT `cat_item_item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`),
  ADD CONSTRAINT `cat_item_updatedby_admin_id` FOREIGN KEY (`updated_by`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `cleaning_category`
--
ALTER TABLE `cleaning_category`
  ADD CONSTRAINT `cle_category_addedby_admin_id` FOREIGN KEY (`added_by`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `cle_category_updatedby_admin_id` FOREIGN KEY (`updated_by`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_addedby_admin_id` FOREIGN KEY (`added_by`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `item_type_id` FOREIGN KEY (`type`) REFERENCES `item_type` (`type_id`),
  ADD CONSTRAINT `item_updated_admin_id` FOREIGN KEY (`updated_by`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `item_type`
--
ALTER TABLE `item_type`
  ADD CONSTRAINT `item_type_addedby_admin_id` FOREIGN KEY (`added_by`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `item_type_updatedby_admin_id` FOREIGN KEY (`updated_by`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `job`
--
ALTER TABLE `job`
  ADD CONSTRAINT `job_addedby_admin_id` FOREIGN KEY (`added_by`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `job_category_id` FOREIGN KEY (`category_id`) REFERENCES `cleaning_category` (`category_id`),
  ADD CONSTRAINT `job_updatedby_admin_id` FOREIGN KEY (`updated_by`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_addedby_admin_id` FOREIGN KEY (`added_by`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `user_updatedby_admin_id` FOREIGN KEY (`updated_by`) REFERENCES `user` (`user_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
