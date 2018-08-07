/*
Navicat MySQL Data Transfer

Source Server         : test01
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : db_springcloud

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2018-08-07 14:27:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', '信息部');
INSERT INTO `t_dept` VALUES ('2', '人力资源部');
INSERT INTO `t_dept` VALUES ('3', '财务部');
INSERT INTO `t_dept` VALUES ('4', 'Test');
INSERT INTO `t_dept` VALUES ('5', 'Test');
INSERT INTO `t_dept` VALUES ('6', 'TESTxxx');
INSERT INTO `t_dept` VALUES ('7', '商务部');
INSERT INTO `t_dept` VALUES ('9', '采购部');
