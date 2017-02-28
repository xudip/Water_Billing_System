-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 16, 2016 at 10:22 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
`aid` int(11) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `mname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `pic_path` varchar(255) NOT NULL,
  `pic_filename` varchar(255) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `gender` varchar(11) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `district` varchar(255) NOT NULL,
  `municipality` varchar(255) NOT NULL,
  `ward_no` varchar(25) NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `squestion` varchar(255) NOT NULL,
  `sanswer` varchar(255) NOT NULL,
  `privilege` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`aid`, `fname`, `mname`, `lname`, `pic_path`, `pic_filename`, `dob`, `gender`, `contact`, `district`, `municipality`, `ward_no`, `email`, `username`, `password`, `squestion`, `sanswer`, `privilege`) VALUES
(21, 'First Name', 'Middle Name', 'Last Name', '', '', 'DOB', 'null', 'Contact', 'District', 'Municipality', 'Ward No.:', 'Email', 'admin', 'xudip', 'Security Question', 'Answer', 'ADMIN'),
(23, 'First Name', 'Middle Name', 'Last Name', '', '', 'aef', 'null', 'adsf', 'District', 'Municipality', 'Ward No.:', 'Email', 'Username1', 'Password', 'Security Question', 'Answer', 'ADMIN'),
(24, 'First Name', 'Middle Name', 'Last Name', '', '', 'DOB', 'null', 'Contact', 'District', 'Municipality', 'Ward No.:', 'Email', 'Username', 'Password', 'Security Question', 'Answer', 'ADMIN'),
(27, 'First Name', 'Middle Name', 'Last Name', '', '', 'DOB', 'null', 'Contact', 'District', 'Municipality', 'Ward No.:', 'Email', 'Username12', 'Password', 'Security Question', 'Answer', 'ADMIN'),
(33, 'First Name', 'Middle Name', 'Last Name', '', '', 'DOB', 'null', 'Contact', 'District', 'Municipality', 'Ward No.:', 'Email', 'xudip', 'xudip', 'Security Question', 'Answer', 'ADMIN'),
(38, 'First Name', 'Middle Name', 'Last Name', '', '', 'DOB', 'null', 'Contact', 'District', 'Municipality', 'Ward No.:', 'Email', 'Username1qw', 'Password', 'Security Question', 'Answer', 'ADMIN'),
(39, 'j', 'j', 'j', '', '', 'j', '', 'j', 'j', 'j', 'j', 'j', 'j', 'j', 'j', 'j', 'ADMIN'),
(40, 'k', 'k', 'k', '', '', 'k', '', 'k', 'k', 'k', 'k', 'kk', 'k', 'k', 'k', 'k', 'ADMIN'),
(41, 'First Name', 'Middle Name', 'Last Name', '', '', '1 January 1990 ', 'Male', '1234567890', 'District', 'Municipality', '12', 'Email', 'admin test', 'Password', 'Security Question', 'Answer', 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `bill_component`
--

CREATE TABLE IF NOT EXISTS `bill_component` (
`id` int(20) NOT NULL,
  `rate` int(11) NOT NULL,
  `fine` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_component`
--

INSERT INTO `bill_component` (`id`, `rate`, `fine`) VALUES
(1, 20, 20);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
`cid` int(11) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `mname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) NOT NULL,
  `pic_path` varchar(255) NOT NULL,
  `pic_filename` varchar(255) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `district` varchar(255) NOT NULL,
  `municipality` varchar(255) NOT NULL,
  `ward_no` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `squestion` varchar(255) NOT NULL,
  `sanswer` varchar(255) NOT NULL,
  `privilege` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cid`, `fname`, `mname`, `lname`, `pic_path`, `pic_filename`, `dob`, `gender`, `contact`, `district`, `municipality`, `ward_no`, `email`, `username`, `password`, `squestion`, `sanswer`, `privilege`) VALUES
(2, 'xudip', '', 'gora', '', ' ', '1993-02-28', 'male', '9211221', 'bkt', 'bkt', '12', 'gorasudip@gmail.com', 'xudip', 'xudip', 'who made this?', 'xudip', 'CUSTOMER'),
(3, 'KJ', 'KJ', 'KJ', '', '', '1234-12-12', 'male', '1234543456', 'KJH', 'JH', '2', 'ASFD@gmail.com', 'a', 'a', 'sa', 'as', 'CUSTOMER'),
(26, 'xudip', '', 'gora', '', ' ', '1993-02-28', 'male', '9211221', 'bkt', 'bkt', '12', 'gorasudip@gmail.com', 'xudi3p1', 'xudip', 'who made this?', 'xudip3', 'CUSTOMER'),
(27, 'xudip', '', 'gora', '', ' ', '1993-02-28', 'male', '9211221', 'bkt', 'bkt', '12', 'gorasudip@gmail.com', 'xudip41', 'xudip', 'who made this?', 'xudip4', 'CUSTOMER'),
(28, 'xudip', '', 'gora', '', ' ', '1993-02-28', 'male', '9211221', 'bkt', 'bkt', '12', 'gorasudip@gmail.com', 'xudip51', 'xudip', 'who made this?', 'xudip5', 'CUSTOMER'),
(29, 'First Name', 'Middle Name', 'Last Name', '', '', '1 January 1990 ', 'Male', '1234567890', 'District', 'Municipality', '12', 'Email', 'test', 'Password', 'Security Question', 'Answer', 'CUSTOMER');

-- --------------------------------------------------------

--
-- Table structure for table `faqs`
--

CREATE TABLE IF NOT EXISTS `faqs` (
`id` int(11) NOT NULL,
  `sender` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `question` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faqs`
--

INSERT INTO `faqs` (`id`, `sender`, `subject`, `question`, `answer`) VALUES
(1, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(27, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(28, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(29, 'xudip', 'Question??', 'what is this application?', 'this is multiple selection'),
(35, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(36, 'xudip', 'Question??', 'what is this application?', 'SDFALJ'),
(39, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(40, 'xudip', 'Question??', 'what is this application?', 'thihsdf'),
(41, 'xudip', 'Question??', 'what is this application?', ' l;sdjf'),
(45, 'xudip', 'Question??', 'what is this application?', 'as'),
(46, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(47, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(48, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(49, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(50, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(51, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(52, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(53, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(54, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(55, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(56, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(57, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(58, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(59, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(60, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(61, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(62, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(63, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(64, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(65, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(66, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(67, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(68, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(69, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(70, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(71, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(72, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(73, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(74, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(75, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(76, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(77, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(78, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(79, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(80, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(81, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(82, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(83, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(84, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(85, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(86, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(87, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(88, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(89, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(91, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(92, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.'),
(93, 'xudip', 'Question??', 'what is this application?', 'this is the WATER BILLING MANAGEMENT SYSTEM.');

-- --------------------------------------------------------

--
-- Table structure for table `file`
--

CREATE TABLE IF NOT EXISTS `file` (
`fid` int(20) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `size` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `file`
--

INSERT INTO `file` (`fid`, `fname`, `type`, `size`) VALUES
(1, '98348-Computer_Network.docx', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document', '14883'),
(4, '4797-basic_entry.sav', 'application/octet-stream', '764'),
(6, '5114-setting.php', 'application/octet-stream', '158'),
(11, '84142-setting.php', 'application/octet-stream', '158'),
(12, '31393-Book1.xlsx', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet', '10364');

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE IF NOT EXISTS `image` (
`iid` int(11) NOT NULL,
  `iname` varchar(255) NOT NULL,
  `ipath` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `image`
--

INSERT INTO `image` (`iid`, `iname`, `ipath`) VALUES
(6, 'images9.jpg', 'ashim/uploads/'),
(7, 'images10.jpg', 'ashim/uploads/'),
(10, 'images6.jpg', 'ashim/uploads/'),
(11, 'images22.jpg', 'ashim/uploads/'),
(12, 'IMG_20150829_172510.JPG', 'ashim/uploads/'),
(13, 'IMG_2758.JPG', 'ashim/uploads/'),
(14, 'IMG_2455.JPG', 'ashim/uploads/'),
(15, 'IMG_2756.JPG', 'ashim/uploads/'),
(16, 'Screenshot_2015-04-08-17-35-52.png', 'ashim/uploads/'),
(17, 'Screenshot_2015-04-08-17-35-52.png', 'ashim/uploads/'),
(18, 'Screenshot_2015-04-16-07-56-52.png', 'ashim/uploads/');

-- --------------------------------------------------------

--
-- Table structure for table `meterreader`
--

CREATE TABLE IF NOT EXISTS `meterreader` (
`rid` int(11) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `mname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `pic_path` varchar(255) NOT NULL,
  `pic_filename` varchar(255) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `district` varchar(255) NOT NULL,
  `municipality` varchar(255) NOT NULL,
  `ward_no` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `squestion` varchar(255) NOT NULL,
  `sanswer` varchar(255) NOT NULL,
  `privilege` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meterreader`
--

INSERT INTO `meterreader` (`rid`, `fname`, `mname`, `lname`, `pic_path`, `pic_filename`, `dob`, `gender`, `contact`, `district`, `municipality`, `ward_no`, `email`, `username`, `password`, `squestion`, `sanswer`, `privilege`) VALUES
(2, 'ashim', 'br', 'kc', 'ashim/uploads/', 'images41.jpg', '1993-06-14', 'male', '9849638063', 'bagmati', 'nagarjun municiality', '3', 'arcikc@gmail.com', 'ashimkc', '12', 'how old are u?', '23', 'METERREADER'),
(5, 'sdkaskd', 'kjhkjhkj', 'kjhkh', '', '', '1993-01-12', 'male', '989899', 'kjkkh', 'khkhkh', '1', 'arcikc@gmail.com', 'lkjljljlj', 'c1181aacf646b97f0a0a782db351a405', 'jjggjhg', 'jhgjgjhg', 'METERREADER'),
(6, 'First Name', 'Middle Name', 'Last Name', '', '', '1 January 1990 ', 'Male', '1234567890', 'District', 'Municipality', '12', 'Email', 'metere reader test', 'Password', 'Security Question', 'Answer', 'METERREADER');

-- --------------------------------------------------------

--
-- Table structure for table `meterreading`
--

CREATE TABLE IF NOT EXISTS `meterreading` (
`mrid` int(10) NOT NULL,
  `cid` int(10) NOT NULL,
  `unit` int(20) NOT NULL,
  `month` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `payment` varchar(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meterreading`
--

INSERT INTO `meterreading` (`mrid`, `cid`, `unit`, `month`, `year`, `payment`) VALUES
(1, 3, 12, 'BAISAKH', 2072, 'PAID'),
(2, 2, 2, 'BAISAKH', 2072, 'PAID'),
(3, 3, 23, 'JESTHA', 2072, 'PAID');

-- --------------------------------------------------------

--
-- Stand-in structure for view `users`
--
CREATE TABLE IF NOT EXISTS `users` (
`username` varchar(255)
,`password` varchar(255)
,`privilege` varchar(255)
);
-- --------------------------------------------------------

--
-- Structure for view `users`
--
DROP TABLE IF EXISTS `users`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `users` AS select `admin`.`username` AS `username`,`admin`.`password` AS `password`,`admin`.`privilege` AS `privilege` from `admin` union select `customer`.`username` AS `username`,`customer`.`password` AS `password`,`customer`.`privilege` AS `privilege` from `customer` union select `meterreader`.`username` AS `username`,`meterreader`.`password` AS `password`,`meterreader`.`privilege` AS `privilege` from `meterreader`;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`aid`), ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `bill_component`
--
ALTER TABLE `bill_component`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
 ADD PRIMARY KEY (`cid`), ADD UNIQUE KEY `username` (`username`), ADD FULLTEXT KEY `fname` (`fname`);

--
-- Indexes for table `faqs`
--
ALTER TABLE `faqs`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `file`
--
ALTER TABLE `file`
 ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
 ADD PRIMARY KEY (`iid`);

--
-- Indexes for table `meterreader`
--
ALTER TABLE `meterreader`
 ADD PRIMARY KEY (`rid`);

--
-- Indexes for table `meterreading`
--
ALTER TABLE `meterreading`
 ADD PRIMARY KEY (`mrid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT for table `bill_component`
--
ALTER TABLE `bill_component`
MODIFY `id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `faqs`
--
ALTER TABLE `faqs`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=94;
--
-- AUTO_INCREMENT for table `file`
--
ALTER TABLE `file`
MODIFY `fid` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `image`
--
ALTER TABLE `image`
MODIFY `iid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `meterreader`
--
ALTER TABLE `meterreader`
MODIFY `rid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `meterreading`
--
ALTER TABLE `meterreading`
MODIFY `mrid` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
