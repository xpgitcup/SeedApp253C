/*
Navicat MySQL Data Transfer

Source Server         : sample
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : seed253c

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2016-05-22 14:43:45
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user_lib_instance`
-- ----------------------------
DROP TABLE IF EXISTS `user_lib_instance`;
CREATE TABLE `user_lib_instance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `developer` varchar(255) NOT NULL,
  `lib_type_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `upload_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_g6xqg9w8cpur9qe4imqgyqwun` (`lib_type_id`),
  CONSTRAINT `FK_g6xqg9w8cpur9qe4imqgyqwun` FOREIGN KEY (`lib_type_id`) REFERENCES `user_lib_config` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_lib_instance
-- ----------------------------
INSERT INTO `user_lib_instance` VALUES ('1', '0', '测试用的用户类', '测试用的', '1', '数据相加', '2016-05-22 00:00:00');
