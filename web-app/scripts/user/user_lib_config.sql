/*
Navicat MySQL Data Transfer

Source Server         : sample
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : seed253c

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2016-05-22 14:24:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user_lib_config`
-- ----------------------------
DROP TABLE IF EXISTS `user_lib_config`;
CREATE TABLE `user_lib_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_lib_config
-- ----------------------------
INSERT INTO `user_lib_config` VALUES ('1', '0', '测试类', '测试类', 'user');
