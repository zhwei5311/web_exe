/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 15/03/2020 21:16:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double NULL DEFAULT NULL,
  `pnum` int(11) NULL DEFAULT NULL,
  `category` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1001', 'java编程思想', 98, 100, '计算机');
INSERT INTO `books` VALUES ('1002', '西游记', 10, 20, '文学');
INSERT INTO `books` VALUES ('1003', '九阴真经', 20, 30, '武侠');
INSERT INTO `books` VALUES ('1004', '365夜睡前好故事', 19.8, 50, '少儿');
INSERT INTO `books` VALUES ('1005', '撒哈拉的故事', 16.6, 80, '文学');
INSERT INTO `books` VALUES ('1006', '三只小猪', 9.8, 50, '少儿');
INSERT INTO `books` VALUES ('1007', '中华上下五千年', 28, 100, '少儿123');
INSERT INTO `books` VALUES ('1008', '金瓶梅', 9.8, 50, '文学');
INSERT INTO `books` VALUES ('1009', '平凡的世界', 55, 80, '文学');
INSERT INTO `books` VALUES ('1010', '心灵鸡汤', 15, 100, '文学');
INSERT INTO `books` VALUES ('1011', '百年孤独', 62, 10, '文学');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` int(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '111111', 0);

SET FOREIGN_KEY_CHECKS = 1;
