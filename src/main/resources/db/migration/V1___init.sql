CREATE TABLE `plot` (
  `id` int(11) NOT null AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `latitude` varchar(100) NOT NULL,
  `total_size` varchar(100) NOT NULL,
  `crop_type` varchar(100) NOT NULL,
  `cultivated_area` varchar(100) NOT NULL,
  `longitude` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `plot_un` (`crop_type`,`latitude`,`longitude`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `sensors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_no` varchar(100) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `device_unique_identifier` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sensors_un` (`device_unique_identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `slots` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plot_id` int(11) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `recurring` tinyint(1) DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  `sensor_id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `slots_un` (`plot_id`,`start_time`),
  KEY `slots_FK_1` (`sensor_id`),
  CONSTRAINT `slots_FK` FOREIGN KEY (`plot_id`) REFERENCES `plot` (`id`) ON DELETE CASCADE,
  CONSTRAINT `slots_FK_1` FOREIGN KEY (`sensor_id`) REFERENCES `sensors` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `slot_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `slot_id` int(11) NOT NULL,
  `status` varchar(100) NOT NULL,
  `time` time NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `slot_status_FK` (`slot_id`),
  CONSTRAINT `slot_status_FK` FOREIGN KEY (`slot_id`) REFERENCES `slots` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




CREATE TABLE `alerts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `slot_id` int(11) NOT NULL,
  `alert_time` datetime DEFAULT current_timestamp(),
   `message` varchar(100) DEFAULT NULL,
  `retry_calls` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `alerts_FK` (`slot_id`),
  CONSTRAINT `alerts_FK` FOREIGN KEY (`slot_id`) REFERENCES `slots` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;