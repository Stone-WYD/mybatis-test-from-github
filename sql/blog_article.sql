/*
 Navicat Premium Data Transfer

 Source Server         : wyd
 Source Server Type    : MySQL
 Source Server Version : 50651
 Source Host           : 192.168.30.43:3306
 Source Schema         : myblog

 Target Server Type    : MySQL
 Target Server Version : 50651
 File Encoding         : 65001

 Date: 21/06/2023 16:30:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES (1, 'mybatis-test', 'coolblog.xyz', 'mybatis test', '2018-01-13 16:29:31');

SET FOREIGN_KEY_CHECKS = 1;
