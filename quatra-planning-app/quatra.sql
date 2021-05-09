-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2021 at 04:06 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

# Privileges for `qintellij`@`%`

GRANT ALL PRIVILEGES ON *.* TO `qintellij`@`%` WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON `quatra`.* TO `qintellij`@`%`;


# Privileges for `quser`@`%`

GRANT ALL PRIVILEGES ON *.* TO `quser`@`%` IDENTIFIED BY PASSWORD '*A082F65DE2EB417F93D9AF203239C726A1547309' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON `quatra`.* TO `quser`@`%`;

--
-- Database: `quatra`
--

-- --------------------------------------------------------

--
-- Table structure for table `afspraken`
--

CREATE TABLE `afspraken` (
  `ID` bigint(20) NOT NULL,
  `GEWENSTE_DATUM` date DEFAULT NULL,
  `TOESTAND` int(11) DEFAULT NULL,
  `KLANT_ID` bigint(20) DEFAULT NULL,
  `PLANNING_ID` bigint(20) DEFAULT NULL,
  `PROBLEEM_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chauffeur`
--

CREATE TABLE `chauffeur` (
  `ID` bigint(20) NOT NULL,
  `ACHTERNAAM` varchar(255) DEFAULT NULL,
  `NAAM` varchar(255) DEFAULT NULL,
  `RIJBEWIJS` varchar(255) DEFAULT NULL,
  `TELEFOONNUMMER` varchar(255) DEFAULT NULL,
  `VOORNAAM` varchar(255) DEFAULT NULL,
  `VRACHTWAGEN_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `klanten`
--

CREATE TABLE `klanten` (
  `ID` bigint(20) NOT NULL,
  `ADRES` varchar(255) DEFAULT NULL,
  `BEDRIJFS_NAAM` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NAAM` varchar(255) DEFAULT NULL,
  `TELEFOONNUMMER` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `planner`
--

CREATE TABLE `planner` (
  `ID` bigint(20) NOT NULL,
  `ACHTERNAAM` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NAAM` varchar(255) DEFAULT NULL,
  `TELEFOONNUMMER` varchar(255) DEFAULT NULL,
  `VOORNAAM` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `plannings`
--

CREATE TABLE `plannings` (
  `ID` bigint(20) NOT NULL,
  `DATUM` date NOT NULL,
  `TOESTAND` int(11) DEFAULT NULL,
  `CHAUFFEUR_ID` bigint(20) DEFAULT NULL,
  `PLANNER_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `probleem`
--

CREATE TABLE `probleem` (
  `ID` bigint(20) NOT NULL,
  `OPLOSSING` varchar(255) DEFAULT NULL,
  `PROBLEEMSTELLING` varchar(255) DEFAULT NULL,
  `TOESTAND` varchar(255) DEFAULT NULL,
  `PROBLEEMOPLOSSER_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `probleemoplosser`
--

CREATE TABLE `probleemoplosser` (
  `ID` bigint(20) NOT NULL,
  `ACHTERNAAM` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `TELEFOONNUMMER` varchar(255) DEFAULT NULL,
  `VOORNAAM` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `producten`
--

CREATE TABLE `producten` (
  `ID` bigint(20) NOT NULL,
  `GEWICHT` double DEFAULT NULL,
  `NAAM` varchar(255) DEFAULT NULL,
  `PRIJS` double DEFAULT NULL,
  `STOCK` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `productkeuze`
--

CREATE TABLE `productkeuze` (
  `ID` bigint(20) NOT NULL,
  `AANTAL` int(11) DEFAULT NULL,
  `GEWICHT` double DEFAULT NULL,
  `IS_ANDER_PRODUCT` tinyint(1) DEFAULT NULL,
  `AFSPRAAK_ID` bigint(20) DEFAULT NULL,
  `PRODUCT_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` bigint(20) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `uurrooster`
--

CREATE TABLE `uurrooster` (
  `ID` bigint(20) NOT NULL,
  `AANWEZIG` tinyint(1) DEFAULT NULL,
  `BEGINUUR` time DEFAULT NULL,
  `DATUM` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `EINDUUR` time DEFAULT NULL,
  `CHAUFFEUR_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `vrachtwagen`
--

CREATE TABLE `vrachtwagen` (
  `ID` bigint(20) NOT NULL,
  `LAADVERMOGEN` int(11) DEFAULT NULL,
  `NUMMERPLAAT` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `afspraken`
--
ALTER TABLE `afspraken`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK8SYTSXPW7VFPSUWK7YCJE9CQX` (`PROBLEEM_ID`),
  ADD KEY `FKQ25A8JNBVD70LP0HM8XPDYR5H` (`KLANT_ID`),
  ADD KEY `FKQXD5HG0LPB3NAUX9FLLW14CHA` (`PLANNING_ID`);

--
-- Indexes for table `chauffeur`
--
ALTER TABLE `chauffeur`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKEYNSL2CWNCJ5L29FRS9IP3K46` (`VRACHTWAGEN_ID`);

--
-- Indexes for table `klanten`
--
ALTER TABLE `klanten`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `planner`
--
ALTER TABLE `planner`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `plannings`
--
ALTER TABLE `plannings`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK16CT0BYXRTE4Y07PIPHNC6OJ6` (`USER_ID`),
  ADD KEY `FKMCW6BE00AEO3TLULXTO2L83E` (`CHAUFFEUR_ID`),
  ADD KEY `FKNUCKHFPLO9QJ5T3L6CBF06FH8` (`PLANNER_ID`);

--
-- Indexes for table `probleem`
--
ALTER TABLE `probleem`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKL0HEC5UF7GQ3GS1BEC3CCRTKH` (`PROBLEEMOPLOSSER_ID`);

--
-- Indexes for table `probleemoplosser`
--
ALTER TABLE `probleemoplosser`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `producten`
--
ALTER TABLE `producten`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `productkeuze`
--
ALTER TABLE `productkeuze`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK1OC9K372DQ2XPJQWGIX74UPX5` (`AFSPRAAK_ID`),
  ADD KEY `FK38XGMT4PYJPNVR8N1J7P03MPY` (`PRODUCT_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `uurrooster`
--
ALTER TABLE `uurrooster`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK743STMJIOA41RB1QJ3CEUKDWV` (`CHAUFFEUR_ID`);

--
-- Indexes for table `vrachtwagen`
--
ALTER TABLE `vrachtwagen`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `afspraken`
--
ALTER TABLE `afspraken`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `chauffeur`
--
ALTER TABLE `chauffeur`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `klanten`
--
ALTER TABLE `klanten`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `planner`
--
ALTER TABLE `planner`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `plannings`
--
ALTER TABLE `plannings`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `probleem`
--
ALTER TABLE `probleem`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `probleemoplosser`
--
ALTER TABLE `probleemoplosser`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `producten`
--
ALTER TABLE `producten`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `productkeuze`
--
ALTER TABLE `productkeuze`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `uurrooster`
--
ALTER TABLE `uurrooster`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vrachtwagen`
--
ALTER TABLE `vrachtwagen`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `afspraken`
--
ALTER TABLE `afspraken`
  ADD CONSTRAINT `FK8SYTSXPW7VFPSUWK7YCJE9CQX` FOREIGN KEY (`PROBLEEM_ID`) REFERENCES `probleem` (`ID`),
  ADD CONSTRAINT `FKQ25A8JNBVD70LP0HM8XPDYR5H` FOREIGN KEY (`KLANT_ID`) REFERENCES `klanten` (`ID`),
  ADD CONSTRAINT `FKQXD5HG0LPB3NAUX9FLLW14CHA` FOREIGN KEY (`PLANNING_ID`) REFERENCES `plannings` (`ID`);

--
-- Constraints for table `chauffeur`
--
ALTER TABLE `chauffeur`
  ADD CONSTRAINT `FKEYNSL2CWNCJ5L29FRS9IP3K46` FOREIGN KEY (`VRACHTWAGEN_ID`) REFERENCES `vrachtwagen` (`ID`);

--
-- Constraints for table `plannings`
--
ALTER TABLE `plannings`
  ADD CONSTRAINT `FK16CT0BYXRTE4Y07PIPHNC6OJ6` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`),
  ADD CONSTRAINT `FKMCW6BE00AEO3TLULXTO2L83E` FOREIGN KEY (`CHAUFFEUR_ID`) REFERENCES `chauffeur` (`ID`),
  ADD CONSTRAINT `FKNUCKHFPLO9QJ5T3L6CBF06FH8` FOREIGN KEY (`PLANNER_ID`) REFERENCES `planner` (`ID`);

--
-- Constraints for table `probleem`
--
ALTER TABLE `probleem`
  ADD CONSTRAINT `FKL0HEC5UF7GQ3GS1BEC3CCRTKH` FOREIGN KEY (`PROBLEEMOPLOSSER_ID`) REFERENCES `probleemoplosser` (`ID`);

--
-- Constraints for table `productkeuze`
--
ALTER TABLE `productkeuze`
  ADD CONSTRAINT `FK1OC9K372DQ2XPJQWGIX74UPX5` FOREIGN KEY (`AFSPRAAK_ID`) REFERENCES `afspraken` (`ID`),
  ADD CONSTRAINT `FK38XGMT4PYJPNVR8N1J7P03MPY` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `producten` (`ID`);

--
-- Constraints for table `uurrooster`
--
ALTER TABLE `uurrooster`
  ADD CONSTRAINT `FK743STMJIOA41RB1QJ3CEUKDWV` FOREIGN KEY (`CHAUFFEUR_ID`) REFERENCES `chauffeur` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;