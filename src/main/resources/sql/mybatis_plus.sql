/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : mybatis_plus

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 13/10/2020 20:15:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_aaa
-- ----------------------------
DROP TABLE IF EXISTS `sys_aaa`;
CREATE TABLE `sys_aaa`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `varchar1` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `int1` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `bigint1` bigint(1) NULL DEFAULT NULL COMMENT '邮箱',
  `datatime1` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '年龄',
  `timestamp1` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '地址',
  `decimal` decimal(6, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `birth` datetime(0) NULL DEFAULT NULL COMMENT '年龄',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 125 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'Jone', 18, 'test1@baomidou.com', NULL, NULL);
INSERT INTO `sys_user` VALUES (2, 'Jack', 20, 'test2@baomidou.com', NULL, NULL);
INSERT INTO `sys_user` VALUES (3, 'Tom', 28, 'test3@baomidou.com', NULL, NULL);
INSERT INTO `sys_user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', NULL, NULL);
INSERT INTO `sys_user` VALUES (5, 'Billie', 24, 'test5@baomidou.com', NULL, NULL);
INSERT INTO `sys_user` VALUES (111, '小明明', NULL, NULL, '2020-06-15 01:37:21', '浦东');
INSERT INTO `sys_user` VALUES (113, '小明明', NULL, NULL, '2020-06-15 01:44:39', '浦东');
INSERT INTO `sys_user` VALUES (114, '小明明', NULL, NULL, '2020-06-15 01:51:35', '浦东');
INSERT INTO `sys_user` VALUES (116, '小明明', NULL, NULL, '2020-06-15 01:57:25', '浦东');
INSERT INTO `sys_user` VALUES (117, '小明明', NULL, NULL, '2020-06-15 03:18:13', '浦东');
INSERT INTO `sys_user` VALUES (118, '小明明', NULL, NULL, '2020-06-15 03:18:59', '浦东');
INSERT INTO `sys_user` VALUES (119, '小明明', NULL, NULL, '2020-06-15 03:19:02', '浦东');
INSERT INTO `sys_user` VALUES (120, '小明明', NULL, NULL, '2020-06-15 03:19:02', '浦东');
INSERT INTO `sys_user` VALUES (121, '小明明', NULL, NULL, '2020-06-15 03:19:02', '浦东');
INSERT INTO `sys_user` VALUES (122, '小明明', NULL, NULL, '2020-06-15 03:19:02', '浦东');
INSERT INTO `sys_user` VALUES (123, 'Aa', NULL, NULL, '2020-06-15 05:54:57', 'BB');
INSERT INTO `sys_user` VALUES (124, 'Aa', NULL, NULL, '2020-09-16 07:51:40', 'BB');

-- ----------------------------
-- Table structure for xxx_bbb
-- ----------------------------
DROP TABLE IF EXISTS `xxx_bbb`;
CREATE TABLE `xxx_bbb`  (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `birth` datetime(0) NULL DEFAULT NULL COMMENT '年龄',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 124 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xxx_bbb
-- ----------------------------
INSERT INTO `xxx_bbb` VALUES (1, 'Jone', 18, 'test1@baomidou.com', NULL, NULL);
INSERT INTO `xxx_bbb` VALUES (2, 'Jack', 20, 'test2@baomidou.com', NULL, NULL);
INSERT INTO `xxx_bbb` VALUES (3, 'Tom', 28, 'test3@baomidou.com', NULL, NULL);
INSERT INTO `xxx_bbb` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', NULL, NULL);
INSERT INTO `xxx_bbb` VALUES (5, 'Billie', 24, 'test5@baomidou.com', NULL, NULL);
INSERT INTO `xxx_bbb` VALUES (111, '小明明', NULL, NULL, '2020-06-15 01:37:21', '浦东');
INSERT INTO `xxx_bbb` VALUES (113, '小明明', NULL, NULL, '2020-06-15 01:44:39', '浦东');
INSERT INTO `xxx_bbb` VALUES (114, '小明明', NULL, NULL, '2020-06-15 01:51:35', '浦东');
INSERT INTO `xxx_bbb` VALUES (116, '小明明', NULL, NULL, '2020-06-15 01:57:25', '浦东');
INSERT INTO `xxx_bbb` VALUES (117, '小明明', NULL, NULL, '2020-06-15 03:18:13', '浦东');
INSERT INTO `xxx_bbb` VALUES (118, '小明明', NULL, NULL, '2020-06-15 03:18:59', '浦东');
INSERT INTO `xxx_bbb` VALUES (119, '小明明', NULL, NULL, '2020-06-15 03:19:02', '浦东');
INSERT INTO `xxx_bbb` VALUES (120, '小明明', NULL, NULL, '2020-06-15 03:19:02', '浦东');
INSERT INTO `xxx_bbb` VALUES (121, '小明明', NULL, NULL, '2020-06-15 03:19:02', '浦东');
INSERT INTO `xxx_bbb` VALUES (122, '小明明', NULL, NULL, '2020-06-15 03:19:02', '浦东');
INSERT INTO `xxx_bbb` VALUES (123, 'Aa', NULL, NULL, '2020-06-15 05:54:57', 'BB');

SET FOREIGN_KEY_CHECKS = 1;
