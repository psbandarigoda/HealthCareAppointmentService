CREATE TABLE `appointment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patientId` varchar(6) DEFAULT NULL,
  `hospital` varchar(6) DEFAULT NULL,
  `doctor` varchar(12) DEFAULT NULL,
  `date` Date DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `rm_appointment` (
  `id` int NOT NULL,
  `patientId` varchar(6) DEFAULT NULL,
  `hospital` varchar(6) DEFAULT NULL,
  `doctor` varchar(12) DEFAULT NULL,
  `date` Date DEFAULT NULL,
  PRIMARY KEY (`id`)
);