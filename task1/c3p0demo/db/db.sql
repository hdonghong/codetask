/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : db

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2017-09-24 08:02:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for applicant
-- ----------------------------
DROP TABLE IF EXISTS `applicant`;
CREATE TABLE `applicant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` bigint(20) DEFAULT NULL,
  `update_at` bigint(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `entrance_time` bigint(20) DEFAULT NULL,
  `university` varchar(20) DEFAULT NULL,
  `online_id` varchar(20) DEFAULT NULL,
  `diary_link` varchar(255) DEFAULT NULL,
  `goal` varchar(255) DEFAULT NULL,
  `senior` varchar(20) DEFAULT NULL,
  `learn_from` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_id` (`id`) USING BTREE,
  KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applicant
-- ----------------------------
INSERT INTO `applicant` VALUES ('4', '1504412628000', '1504414970000', '黄蓉', '283533685', 'JAVA工程师', '1503412628000', '燕山大学', '2182', 'http://ww.jnshu.com/diary/20770', '老大最帅', 'JAVA-刘佳义', '知乎');
INSERT INTO `applicant` VALUES ('5', '1504413087000', '1504413314000', '张三', '283533685', 'JAVA工程师', '1503412628000', '燕山大学', '2182', 'http://ww.jnshu.com/diary/20770', '努力奋斗，有付出才有', 'JAVA-刘佳义', '知乎');
INSERT INTO `applicant` VALUES ('6', '1504413095000', '1504413315000', '李四', '283533685', 'JAVA工程师', '1503412628000', '燕山大学', '2182', 'http://ww.jnshu.com/diary/20770', '努力奋斗，有付出才有', 'JAVA-刘佳义', '知乎');
INSERT INTO `applicant` VALUES ('7', '1504413103000', '1504413315000', '王五', '283533685', 'JAVA工程师', '1503412628000', '燕山大学', '2182', 'http://ww.jnshu.com/diary/20770', '努力奋斗，有付出才有', 'JAVA-刘佳义', '知乎');
INSERT INTO `applicant` VALUES ('8', '1504413128000', '1504413316000', '刘柳六', '283533685', 'JAVA工程师', '1503412628000', '燕山大学', '2182', 'http://ww.jnshu.com/diary/20770', '努力奋斗，有付出才有', 'JAVA-刘佳义', '知乎');
INSERT INTO `applicant` VALUES ('9', '1504413135000', '1504413316000', '小七', '283533685', 'JAVA工程师', '1503412628000', '燕山大学', '2182', 'http://ww.jnshu.com/diary/20770', '努力奋斗，有付出才有', 'JAVA-刘佳义', '知乎');
INSERT INTO `applicant` VALUES ('10', '1504413141000', '1504417659000', '大巴', '283533685', 'JAVA工程师', '1503412628000', '燕山大学', '2182', 'http://ww.jnshu.com/diary/20770', '努力奋斗，有付出才有', 'JAVA-刘佳义', '知乎');
INSERT INTO `applicant` VALUES ('11', '1504413147000', '1504413317000', '老九', '283533685', 'JAVA工程师', '1503412628000', '燕山大学', '2182', 'http://ww.jnshu.com/diary/20770', '努力奋斗，有付出才有', 'JAVA-刘佳义', '知乎');
INSERT INTO `applicant` VALUES ('12', '1504413156000', '1504413318000', '阿十', '283533685', 'JAVA工程师', '1503412628000', '燕山大学', '2182', 'http://ww.jnshu.com/diary/20770', '努力奋斗，有付出才有', 'JAVA-刘佳义', '知乎');
INSERT INTO `applicant` VALUES ('13', '1504413167000', '1504413319000', '咋一', '283533685', 'JAVA工程师', '1503412628000', '燕山大学', '2182', 'http://ww.jnshu.com/diary/20770', '努力奋斗，有付出才有', 'JAVA-刘佳义', '知乎');
INSERT INTO `applicant` VALUES ('14', '1504413171000', '1504413336000', '测试号', '283533685', 'JAVA工程师', '1503412628000', '燕山大学', '2182', 'http://ww.jnshu.com/diary/20770', '努力奋斗，有付出才有', 'JAVA-刘佳义', '知乎');
INSERT INTO `applicant` VALUES ('20', '1504417659000', null, 'c3p0demo', '3333', null, null, null, null, null, null, null, null);
DROP TRIGGER IF EXISTS `tri_create_at`;
DELIMITER ;;
CREATE TRIGGER `tri_create_at` BEFORE INSERT ON `applicant` FOR EACH ROW BEGIN
 SET new.create_at = UNIX_TIMESTAMP(now())*1000;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tri_update_at`;
DELIMITER ;;
CREATE TRIGGER `tri_update_at` BEFORE UPDATE ON `applicant` FOR EACH ROW BEGIN
 SET new.update_at = UNIX_TIMESTAMP(now())*1000;
END
;;
DELIMITER ;
