/*
Navicat MySQL Data Transfer

Source Server         : sample
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : seed253c

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2016-05-24 17:10:18
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `process_task`
-- ----------------------------
DROP TABLE IF EXISTS `process_task`;
CREATE TABLE `process_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `name_id` bigint(20) NOT NULL,
  `params_string` varchar(255) NOT NULL,
  `status` bit(1) NOT NULL,
  `up_task_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sewseg7ck7uhitihr0fxwd8x9` (`name_id`),
  KEY `FK_e29y16dr107g7hh7nxxyq0pvj` (`up_task_id`),
  CONSTRAINT `FK_e29y16dr107g7hh7nxxyq0pvj` FOREIGN KEY (`up_task_id`) REFERENCES `process_task` (`id`),
  CONSTRAINT `FK_sewseg7ck7uhitihr0fxwd8x9` FOREIGN KEY (`name_id`) REFERENCES `stand_task` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of process_task
-- ----------------------------
INSERT INTO `process_task` VALUES ('1', '0', '2016-05-24 00:00:00', '1', 'E:\\GrailsWorks\\SeedApplication\\SeedApp253C\\web-app\\userLibs\\user\\TestUserLib.jar', '\0', null);
