/*
 Navicat Premium Dump SQL

 Source Server         : SG
 Source Server Type    : MySQL
 Source Server Version : 80041 (8.0.41-32)
 Source Host           : 10.0.0.13:3306
 Source Schema         : reptile

 Target Server Type    : MySQL
 Target Server Version : 80041 (8.0.41-32)
 File Encoding         : 65001

 Date: 02/05/2025 13:34:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_user_data
-- ----------------------------
DROP TABLE IF EXISTS `b_user_data`;
CREATE TABLE `b_user_data`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NOT NULL COMMENT 'ID',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '链接',
  `md5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT 'MD5值',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '性别',
  `born` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '出生日期',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '邮箱',
  `residence_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '居住时间',
  `zip_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '邮编',
  `state` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '州',
  `city` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '城市',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '地址',
  `square_foot` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '房屋面积',
  `built` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '建筑时间',
  `estimated_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '估值',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态：0：未采集；1：已采集',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UNI_URL`(`url` ASC) USING BTREE COMMENT '唯一索引-URL'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci
 COMMENT = '业务 - 用户数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for export_log
-- ----------------------------
DROP TABLE IF EXISTS `export_log`;
CREATE TABLE `export_log`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NOT NULL COMMENT 'ID',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT 'IP地址',
  `export_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
 NULL DEFAULT NULL COMMENT '导出时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci
 COMMENT = '导出记录' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
