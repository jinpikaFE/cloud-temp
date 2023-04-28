/*
 Navicat Premium Data Transfer

 Source Server         : Tencentsql
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : localhost:3306
 Source Schema         : xlh

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 28/04/2023 14:30:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          int(11)                                                 NOT NULL AUTO_INCREMENT,
    `create_time` timestamp(6)                                            NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `update_time` timestamp(6)                                            NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
    `username`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `email`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `phone`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `avatar`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `password`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `salt`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `IDX_78a916df40e02a9deb1c4b75ed` (`username`) USING BTREE,
    UNIQUE INDEX `IDX_e12875dfb3b1d92d7d7c5377e2` (`email`) USING BTREE,
    UNIQUE INDEX `IDX_8e1f623798118e629b46a9e629` (`phone`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, '2022-09-25 14:47:48.460597', '2022-09-25 14:47:48.460597', NULL, NULL, '14770998033', NULL, NULL, NULL);
INSERT INTO `user`
VALUES (2, '2022-09-25 14:49:40.916005', '2022-09-25 14:49:40.916005', 'admin', 'g.fufef@qq.com', '15757182982',
        'http://dummyimage.com/100x100', '5eInREwl0O81kp//y0XZUw==', 'E9yW');

SET FOREIGN_KEY_CHECKS = 1;
