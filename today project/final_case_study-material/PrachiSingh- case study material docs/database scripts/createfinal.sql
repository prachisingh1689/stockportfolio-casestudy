Drop database if exists StockPortfolioDB;

Create database if not exists StockPortfolioDB ;

use StockPortfolioDB;

CREATE TABLE  if not exists `user_master` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `dob` varchar(10) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `alt_email` varchar(40) unique NOT NULL,
  `mobile_no` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
); 

CREATE TABLE if not exists `stock_master` (
  `stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `symbol` varchar(10) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`stock_id`)
); 



CREATE TABLE `user_stock_master` (
  `user_stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `stock_id` int(11) NOT NULL,
  `purchase` Timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `deflection` float(8,2) DEFAULT NULL,
  `price` float DEFAULT NULL,
   PRIMARY KEY (`user_stock_id`),
   KEY `FKB7F56B9F42644EC9` (`user_id`),
   KEY `FKB7F56B9FE62B2EF` (`stock_id`),
  CONSTRAINT `FKB7F56B9F42644EC9` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`),
  CONSTRAINT `FKB7F56B9FE62B2EF` FOREIGN KEY (`stock_id`) REFERENCES `stock_master` (`stock_id`),
  CONSTRAINT `name1` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`),
  CONSTRAINT `name2` FOREIGN KEY (`stock_id`) REFERENCES `stock_master` (`stock_id`)
);



CREATE TABLE if not exists `xml_stock_master` (
  `xml_stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_id` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `time` Timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`xml_stock_id`),
  KEY `FKC5D4E2D3E62B2EF` (`stock_id`),
  CONSTRAINT `FKC5D4E2D3E62B2EF` FOREIGN KEY (`stock_id`) REFERENCES `stock_master` (`stock_id`),
  CONSTRAINT `xml_stock_master_ibfk_1` FOREIGN KEY (`stock_id`) REFERENCES `stock_master` (`stock_id`)
);