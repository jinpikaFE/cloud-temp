/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : localhost:3306
 Source Schema         : mall_tiny

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 20/12/2022 11:33:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `username`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `password`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `icon`        varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
    `email`       varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
    `nick_name`   varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
    `note`        varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    `create_time` datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `status`      int(1)                                                  NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
    `deleted`     int(1)                                                  NULL DEFAULT 0,
    `update_time` datetime                                                NULL DEFAULT NULL COMMENT '更新时间',
    `login_time`  datetime                                                NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 37
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin`
VALUES (16, 'jinxin', '$2a$10$f3XB.wRa9dqP0BPiphQOyetMvuIFlRbyii7D/BCkk.gcX37bGD382', 'http://dummyimage.com/100x100',
        'p.pgljyroc@qq.com', '程静', 'nisi reprehenderit dolor', '2022-12-14 16:03:04', 1, 0, '2022-12-20 11:18:57',
        '2022-12-20 11:18:57');
INSERT INTO `ums_admin`
VALUES (35, 'admin', '$2a$10$sPrQckSwgdDcsiwasy1AE.6gXTeKcc9qLT.sBNaZ81R6lxYRWbJE2',
        'http://jinpika-1308276765.cos.ap-shanghai.myqcloud.com/bootdemo-file/20221220/src=http___desk-fd.zol-img.com.cn_t_s960x600c5_g2_M00_00_0B_ChMlWl6yKqyILFoCACn-5rom2uIAAO4DgEODxAAKf7-298.jpg&refer=http___desk-fd.zol-img.com.png',
        'admin@qq.com', '管理员', NULL, '2022-12-20 10:24:45', 1, 0, '2022-12-20 10:24:45', NULL);
INSERT INTO `ums_admin`
VALUES (36, 'qx', '$2a$10$M3J/mxV6KJsiU92beHQB6ufEgcQGxPP3YF6lpuIVe4nVVpXr4TxCC',
        'http://jinpika-1308276765.cos.ap-shanghai.myqcloud.com/bootdemo-file/20221220/yellowbk.png', 'jinxin@qq.com',
        '无资源有菜单', NULL, '2022-12-20 11:06:59', 1, 0, '2022-12-20 11:26:40', '2022-12-20 11:26:40');

-- ----------------------------
-- Table structure for ums_admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_login_log`;
CREATE TABLE `ums_admin_login_log`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `admin_id`    bigint(20)                                              NULL DEFAULT NULL,
    `create_time` datetime                                                NULL DEFAULT NULL,
    `ip`          varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `address`     varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `user_agent`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器登录类型',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 311
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户登录日志表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_admin_login_log
-- ----------------------------
INSERT INTO `ums_admin_login_log`
VALUES (285, 3, '2020-08-24 14:05:21', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (286, 10, '2020-08-24 14:05:39', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (287, 11, '2022-12-14 16:05:02', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (288, 11, '2022-12-14 16:05:46', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (289, 11, '2022-12-14 16:06:31', '0:0:0:0:0:0:0:1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (290, 28, '2022-12-15 11:36:35', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (291, 29, '2022-12-15 14:35:29', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (292, 29, '2022-12-15 14:46:25', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (293, 16, '2022-12-15 14:48:09', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (294, 16, '2022-12-15 14:49:50', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (295, 28, '2022-12-15 15:03:51', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (296, 16, '2022-12-15 15:47:19', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (297, 16, '2022-12-15 15:47:21', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (298, 16, '2022-12-15 15:47:22', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (299, 16, '2022-12-15 15:47:23', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (300, 16, '2022-12-15 15:47:24', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (301, 16, '2022-12-15 16:04:37', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (302, 16, '2022-12-20 09:50:30', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (303, 16, '2022-12-20 10:42:21', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (304, 36, '2022-12-20 11:07:22', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (305, 16, '2022-12-20 11:08:19', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (306, 36, '2022-12-20 11:09:58', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (307, 16, '2022-12-20 11:11:30', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (308, 36, '2022-12-20 11:12:09', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (309, 16, '2022-12-20 11:18:57', '127.0.0.1', NULL, NULL);
INSERT INTO `ums_admin_login_log`
VALUES (310, 36, '2022-12-20 11:26:40', '127.0.0.1', NULL, NULL);

-- ----------------------------
-- Table structure for ums_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_role_relation`;
CREATE TABLE `ums_admin_role_relation`
(
    `id`       bigint(20) NOT NULL AUTO_INCREMENT,
    `admin_id` bigint(20) NULL DEFAULT NULL,
    `role_id`  bigint(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 77
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户和角色关系表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_admin_role_relation
-- ----------------------------
INSERT INTO `ums_admin_role_relation`
VALUES (26, 3, 5);
INSERT INTO `ums_admin_role_relation`
VALUES (27, 6, 1);
INSERT INTO `ums_admin_role_relation`
VALUES (28, 7, 2);
INSERT INTO `ums_admin_role_relation`
VALUES (29, 1, 5);
INSERT INTO `ums_admin_role_relation`
VALUES (30, 4, 5);
INSERT INTO `ums_admin_role_relation`
VALUES (31, 8, 5);
INSERT INTO `ums_admin_role_relation`
VALUES (34, 12, 6);
INSERT INTO `ums_admin_role_relation`
VALUES (38, 13, 5);
INSERT INTO `ums_admin_role_relation`
VALUES (39, 10, 8);
INSERT INTO `ums_admin_role_relation`
VALUES (40, 32, 2);
INSERT INTO `ums_admin_role_relation`
VALUES (41, 32, 5);
INSERT INTO `ums_admin_role_relation`
VALUES (65, 33, 2);
INSERT INTO `ums_admin_role_relation`
VALUES (66, 33, 5);
INSERT INTO `ums_admin_role_relation`
VALUES (67, 33, 8);
INSERT INTO `ums_admin_role_relation`
VALUES (71, 34, 2);
INSERT INTO `ums_admin_role_relation`
VALUES (72, 34, 5);
INSERT INTO `ums_admin_role_relation`
VALUES (73, 34, 8);
INSERT INTO `ums_admin_role_relation`
VALUES (74, 16, 5);
INSERT INTO `ums_admin_role_relation`
VALUES (75, 35, 5);
INSERT INTO `ums_admin_role_relation`
VALUES (76, 36, 11);

-- ----------------------------
-- Table structure for ums_menu
-- ----------------------------
DROP TABLE IF EXISTS `ums_menu`;
CREATE TABLE `ums_menu`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `parent_id`   bigint(20)                                              NULL DEFAULT 0 COMMENT '父级ID',
    `create_time` datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `title`       varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
    `level`       int(4)                                                  NULL DEFAULT NULL COMMENT '菜单级数',
    `sort`        int(4)                                                  NULL DEFAULT NULL COMMENT '菜单排序',
    `name`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '前端名称',
    `icon`        varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端图标',
    `is_show`     int(1)                                                  NULL DEFAULT NULL COMMENT '前端隐藏',
    `type`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 41
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台菜单表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_menu
-- ----------------------------
INSERT INTO `ums_menu`
VALUES (29, 0, '2022-12-20 09:57:55', '关于', 0, 3, 'About', 'ant-design:api-outlined', 1, '0');
INSERT INTO `ums_menu`
VALUES (30, 29, '2022-12-20 10:03:06', '关于页面', 1, 3, 'AboutPage', 'ant-design:aim-outlined', 1, '0');
INSERT INTO `ums_menu`
VALUES (31, 0, '2022-12-20 10:05:31', 'Dashboard', 0, 1, 'Dashboard', 'ant-design:appstore-filled', 1, '0');
INSERT INTO `ums_menu`
VALUES (32, 31, '2022-12-20 10:06:36', '分析页', 1, 5, 'Analysis', 'ant-design:bar-chart-outlined', 1, '0');
INSERT INTO `ums_menu`
VALUES (33, 31, '2022-12-20 10:07:05', '工作台', 1, 6, 'Workbench', 'ant-design:calendar-outlined', 1, '0');
INSERT INTO `ums_menu`
VALUES (34, 0, '2022-12-20 10:09:05', '权限管理', 0, 2, 'Auth', 'ant-design:setting-filled', 1, '0');
INSERT INTO `ums_menu`
VALUES (35, 34, '2022-12-20 10:10:15', '用户管理', 1, 10, 'User', 'ant-design:team-outlined', 1, '0');
INSERT INTO `ums_menu`
VALUES (36, 34, '2022-12-20 10:11:13', '角色管理', 1, 10, 'Role', 'ant-design:apartment-outlined', 1, '0');
INSERT INTO `ums_menu`
VALUES (37, 34, '2022-12-20 10:11:55', '菜单管理', 1, 1, 'Menu', 'ant-design:bars-outlined', 1, '0');
INSERT INTO `ums_menu`
VALUES (38, 34, '2022-12-20 10:13:27', '资源管理', 1, 1, 'Resource', 'ant-design:alert-filled', 1, '0');
INSERT INTO `ums_menu`
VALUES (39, 38, '2022-12-20 10:16:28', '资源列表', 2, 1, 'ResourceList', 'ant-design:aim-outlined', 0, '0');
INSERT INTO `ums_menu`
VALUES (40, 38, '2022-12-20 11:22:03', '资源分类', 2, 2, 'ResourceCategory', 'ant-design:appstore-outlined', 1, '0');

-- ----------------------------
-- Table structure for ums_resource
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource`;
CREATE TABLE `ums_resource`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `create_time` datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `name`        varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
    `url`         varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源URL',
    `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `category_id` bigint(20)                                              NULL DEFAULT NULL COMMENT '资源分类ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 33
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台资源表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_resource
-- ----------------------------
INSERT INTO `ums_resource`
VALUES (1, '2020-02-04 17:04:55', '商品品牌管理', '/brand/**', NULL, 1);
INSERT INTO `ums_resource`
VALUES (2, '2020-02-04 17:05:35', '商品属性分类管理', '/productAttribute/**', NULL, 1);
INSERT INTO `ums_resource`
VALUES (3, '2020-02-04 17:06:13', '商品属性管理', '/productAttribute/**', NULL, 1);
INSERT INTO `ums_resource`
VALUES (4, '2020-02-04 17:07:15', '商品分类管理', '/productCategory/**', NULL, 1);
INSERT INTO `ums_resource`
VALUES (5, '2020-02-04 17:09:16', '商品管理', '/product/**', NULL, 1);
INSERT INTO `ums_resource`
VALUES (6, '2020-02-04 17:09:53', '商品库存管理', '/sku/**', NULL, 1);
INSERT INTO `ums_resource`
VALUES (8, '2020-02-05 14:43:37', '订单管理', '/order/**', '', 2);
INSERT INTO `ums_resource`
VALUES (9, '2020-02-05 14:44:22', ' 订单退货申请管理', '/returnApply/**', '', 2);
INSERT INTO `ums_resource`
VALUES (10, '2020-02-05 14:45:08', '退货原因管理', '/returnReason/**', '', 2);
INSERT INTO `ums_resource`
VALUES (11, '2020-02-05 14:45:43', '订单设置管理', '/orderSetting/**', '', 2);
INSERT INTO `ums_resource`
VALUES (12, '2020-02-05 14:46:23', '收货地址管理', '/companyAddress/**', '', 2);
INSERT INTO `ums_resource`
VALUES (13, '2020-02-07 16:37:22', '优惠券管理', '/coupon/**', '', 3);
INSERT INTO `ums_resource`
VALUES (14, '2020-02-07 16:37:59', '优惠券领取记录管理', '/couponHistory/**', '', 3);
INSERT INTO `ums_resource`
VALUES (15, '2020-02-07 16:38:28', '限时购活动管理', '/flash/**', '', 3);
INSERT INTO `ums_resource`
VALUES (16, '2020-02-07 16:38:59', '限时购商品关系管理', '/flashProductRelation/**', '', 3);
INSERT INTO `ums_resource`
VALUES (17, '2020-02-07 16:39:22', '限时购场次管理', '/flashSession/**', '', 3);
INSERT INTO `ums_resource`
VALUES (18, '2020-02-07 16:40:07', '首页轮播广告管理', '/home/advertise/**', '', 3);
INSERT INTO `ums_resource`
VALUES (19, '2020-02-07 16:40:34', '首页品牌管理', '/home/brand/**', '', 3);
INSERT INTO `ums_resource`
VALUES (20, '2020-02-07 16:41:06', '首页新品管理', '/home/newProduct/**', '', 3);
INSERT INTO `ums_resource`
VALUES (21, '2020-02-07 16:42:16', '首页人气推荐管理', '/home/recommendProduct/**', '', 3);
INSERT INTO `ums_resource`
VALUES (22, '2020-02-07 16:42:48', '首页专题推荐管理', '/home/recommendSubject/**', '', 3);
INSERT INTO `ums_resource`
VALUES (23, '2020-02-07 16:44:56', ' 商品优选管理', '/prefrenceArea/**', '', 5);
INSERT INTO `ums_resource`
VALUES (24, '2020-02-07 16:45:39', '商品专题管理', '/subject/**', '', 5);
INSERT INTO `ums_resource`
VALUES (25, '2020-02-07 16:47:34', '后台用户管理', '/api/v1/admin/**', '', 4);
INSERT INTO `ums_resource`
VALUES (26, '2020-02-07 16:48:24', '后台用户角色管理', '/api/v1/role/**', '', 4);
INSERT INTO `ums_resource`
VALUES (27, '2020-02-07 16:48:48', '后台菜单管理', '/api/v1/menu/**', '', 4);
INSERT INTO `ums_resource`
VALUES (28, '2020-02-07 16:49:18', '后台资源分类管理', '/api/v1/resourceCategory/**', '', 4);
INSERT INTO `ums_resource`
VALUES (29, '2020-02-07 16:49:45', '后台资源管理', '/api/v1/resource/**', '', 4);
INSERT INTO `ums_resource`
VALUES (30, '2022-12-15 16:16:00', 'test2', '2/3/4', '2', 1);
INSERT INTO `ums_resource`
VALUES (32, '2022-12-20 11:09:26', '菜单树', '/api/v1/menu/treeList', NULL, 4);

-- ----------------------------
-- Table structure for ums_resource_category
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource_category`;
CREATE TABLE `ums_resource_category`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `create_time` datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `name`        varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
    `sort`        int(4)                                                  NULL DEFAULT NULL COMMENT '排序',
    `update_time` datetime                                                NULL DEFAULT NULL,
    `deleted`     int(1)                                                  NULL DEFAULT 0,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '资源分类表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_resource_category
-- ----------------------------
INSERT INTO `ums_resource_category`
VALUES (1, '2020-02-05 10:21:44', '商品模块', 0, '2022-12-20 11:08:49', 1671505728);
INSERT INTO `ums_resource_category`
VALUES (2, '2020-02-05 10:22:34', '订单模块', 0, '2022-12-20 11:08:45', 1671505725);
INSERT INTO `ums_resource_category`
VALUES (3, '2020-02-05 10:22:48', '营销模块', 0, '2022-12-20 11:08:42', 1671505721);
INSERT INTO `ums_resource_category`
VALUES (4, '2020-02-05 10:23:04', '权限模块', 0, NULL, 0);
INSERT INTO `ums_resource_category`
VALUES (5, '2020-02-07 16:34:27', '内容模块', 0, '2022-12-20 11:08:37', 1671505717);
INSERT INTO `ums_resource_category`
VALUES (6, '2020-02-07 16:35:49', '其他模块', 0, '2022-12-20 11:08:33', 1671505712);

-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
    `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `admin_count` int(11)                                                 NULL DEFAULT 0 COMMENT '后台用户数量',
    `create_time` datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `status`      int(1)                                                  NULL DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
    `sort`        int(11)                                                 NULL DEFAULT 0,
    `update_time` datetime                                                NULL DEFAULT NULL,
    `deleted`     int(1)                                                  NULL DEFAULT 0,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户角色表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO `ums_role`
VALUES (1, '商品管理员', '只能查看及操作商品', 0, '2020-02-03 16:50:37', 1, 0, '2022-12-20 10:21:22', 1671502881);
INSERT INTO `ums_role`
VALUES (2, '订单管理员', '只能查看及操作订单', 0, '2018-09-30 15:53:45', 1, 0, '2022-12-20 10:21:18', 1671502878);
INSERT INTO `ums_role`
VALUES (5, '超级管理员', '拥有所有查看和操作功能', 0, '2020-02-02 15:11:05', 1, 5, '2022-12-20 11:04:32', 0);
INSERT INTO `ums_role`
VALUES (8, '权限管理员', '用于权限模块所有操作功能', 0, '2020-08-24 10:57:35', 1, 0, '2022-12-20 10:21:12', 1671502871);
INSERT INTO `ums_role`
VALUES (9, 'test', 'test', 0, '2022-12-19 15:08:56', 0, 0, '2022-12-20 10:21:07', 1671502867);
INSERT INTO `ums_role`
VALUES (10, 'test2', 'test333', 0, '2022-12-19 15:36:41', 0, 8, '2022-12-20 10:21:02', 1671502862);
INSERT INTO `ums_role`
VALUES (11, '有权限管理无部分资源', '有菜单权限，只有用户管理资源', 0, '2022-12-20 11:05:58', 1, 1,
        '2022-12-20 11:26:28', 0);

-- ----------------------------
-- Table structure for ums_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_menu_relation`;
CREATE TABLE `ums_role_menu_relation`
(
    `id`      bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
    `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 215
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台角色菜单关系表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_role_menu_relation
-- ----------------------------
INSERT INTO `ums_role_menu_relation`
VALUES (53, 2, 7);
INSERT INTO `ums_role_menu_relation`
VALUES (54, 2, 8);
INSERT INTO `ums_role_menu_relation`
VALUES (55, 2, 9);
INSERT INTO `ums_role_menu_relation`
VALUES (56, 2, 10);
INSERT INTO `ums_role_menu_relation`
VALUES (57, 2, 11);
INSERT INTO `ums_role_menu_relation`
VALUES (96, 6, 21);
INSERT INTO `ums_role_menu_relation`
VALUES (97, 6, 22);
INSERT INTO `ums_role_menu_relation`
VALUES (98, 6, 23);
INSERT INTO `ums_role_menu_relation`
VALUES (99, 6, 24);
INSERT INTO `ums_role_menu_relation`
VALUES (100, 6, 25);
INSERT INTO `ums_role_menu_relation`
VALUES (101, 7, 21);
INSERT INTO `ums_role_menu_relation`
VALUES (102, 7, 22);
INSERT INTO `ums_role_menu_relation`
VALUES (103, 7, 23);
INSERT INTO `ums_role_menu_relation`
VALUES (104, 7, 24);
INSERT INTO `ums_role_menu_relation`
VALUES (105, 7, 25);
INSERT INTO `ums_role_menu_relation`
VALUES (106, 8, 21);
INSERT INTO `ums_role_menu_relation`
VALUES (107, 8, 22);
INSERT INTO `ums_role_menu_relation`
VALUES (108, 8, 23);
INSERT INTO `ums_role_menu_relation`
VALUES (109, 8, 24);
INSERT INTO `ums_role_menu_relation`
VALUES (110, 8, 25);
INSERT INTO `ums_role_menu_relation`
VALUES (114, 9, 13);
INSERT INTO `ums_role_menu_relation`
VALUES (115, 9, 14);
INSERT INTO `ums_role_menu_relation`
VALUES (116, 9, 16);
INSERT INTO `ums_role_menu_relation`
VALUES (117, 9, 17);
INSERT INTO `ums_role_menu_relation`
VALUES (118, 9, 18);
INSERT INTO `ums_role_menu_relation`
VALUES (119, 9, 19);
INSERT INTO `ums_role_menu_relation`
VALUES (120, 9, 20);
INSERT INTO `ums_role_menu_relation`
VALUES (121, 9, 26);
INSERT INTO `ums_role_menu_relation`
VALUES (124, 1, 3);
INSERT INTO `ums_role_menu_relation`
VALUES (125, 1, 4);
INSERT INTO `ums_role_menu_relation`
VALUES (126, 1, 5);
INSERT INTO `ums_role_menu_relation`
VALUES (127, 1, 6);
INSERT INTO `ums_role_menu_relation`
VALUES (128, 1, 26);
INSERT INTO `ums_role_menu_relation`
VALUES (129, 1, 27);
INSERT INTO `ums_role_menu_relation`
VALUES (140, 10, 26);
INSERT INTO `ums_role_menu_relation`
VALUES (141, 10, 27);
INSERT INTO `ums_role_menu_relation`
VALUES (195, 5, 30);
INSERT INTO `ums_role_menu_relation`
VALUES (196, 5, 32);
INSERT INTO `ums_role_menu_relation`
VALUES (197, 5, 33);
INSERT INTO `ums_role_menu_relation`
VALUES (198, 5, 35);
INSERT INTO `ums_role_menu_relation`
VALUES (199, 5, 36);
INSERT INTO `ums_role_menu_relation`
VALUES (200, 5, 37);
INSERT INTO `ums_role_menu_relation`
VALUES (201, 5, 39);
INSERT INTO `ums_role_menu_relation`
VALUES (210, 11, 35);
INSERT INTO `ums_role_menu_relation`
VALUES (211, 11, 36);
INSERT INTO `ums_role_menu_relation`
VALUES (212, 11, 37);
INSERT INTO `ums_role_menu_relation`
VALUES (213, 11, 39);
INSERT INTO `ums_role_menu_relation`
VALUES (214, 11, 40);

-- ----------------------------
-- Table structure for ums_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_resource_relation`;
CREATE TABLE `ums_role_resource_relation`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id`     bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
    `resource_id` bigint(20) NULL DEFAULT NULL COMMENT '资源ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 335
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台角色资源关系表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_role_resource_relation
-- ----------------------------
INSERT INTO `ums_role_resource_relation`
VALUES (103, 2, 8);
INSERT INTO `ums_role_resource_relation`
VALUES (104, 2, 9);
INSERT INTO `ums_role_resource_relation`
VALUES (105, 2, 10);
INSERT INTO `ums_role_resource_relation`
VALUES (106, 2, 11);
INSERT INTO `ums_role_resource_relation`
VALUES (107, 2, 12);
INSERT INTO `ums_role_resource_relation`
VALUES (178, 6, 25);
INSERT INTO `ums_role_resource_relation`
VALUES (179, 6, 26);
INSERT INTO `ums_role_resource_relation`
VALUES (180, 6, 27);
INSERT INTO `ums_role_resource_relation`
VALUES (181, 6, 28);
INSERT INTO `ums_role_resource_relation`
VALUES (182, 6, 29);
INSERT INTO `ums_role_resource_relation`
VALUES (205, 7, 25);
INSERT INTO `ums_role_resource_relation`
VALUES (206, 7, 26);
INSERT INTO `ums_role_resource_relation`
VALUES (207, 7, 27);
INSERT INTO `ums_role_resource_relation`
VALUES (208, 7, 28);
INSERT INTO `ums_role_resource_relation`
VALUES (209, 7, 29);
INSERT INTO `ums_role_resource_relation`
VALUES (210, 7, 31);
INSERT INTO `ums_role_resource_relation`
VALUES (211, 8, 25);
INSERT INTO `ums_role_resource_relation`
VALUES (212, 8, 26);
INSERT INTO `ums_role_resource_relation`
VALUES (213, 8, 27);
INSERT INTO `ums_role_resource_relation`
VALUES (214, 8, 28);
INSERT INTO `ums_role_resource_relation`
VALUES (215, 8, 29);
INSERT INTO `ums_role_resource_relation`
VALUES (217, 9, 1);
INSERT INTO `ums_role_resource_relation`
VALUES (218, 9, 2);
INSERT INTO `ums_role_resource_relation`
VALUES (221, 1, 1);
INSERT INTO `ums_role_resource_relation`
VALUES (222, 1, 2);
INSERT INTO `ums_role_resource_relation`
VALUES (223, 1, 3);
INSERT INTO `ums_role_resource_relation`
VALUES (224, 1, 4);
INSERT INTO `ums_role_resource_relation`
VALUES (225, 1, 5);
INSERT INTO `ums_role_resource_relation`
VALUES (226, 1, 6);
INSERT INTO `ums_role_resource_relation`
VALUES (227, 1, 23);
INSERT INTO `ums_role_resource_relation`
VALUES (228, 1, 24);
INSERT INTO `ums_role_resource_relation`
VALUES (239, 10, 4);
INSERT INTO `ums_role_resource_relation`
VALUES (240, 10, 3);
INSERT INTO `ums_role_resource_relation`
VALUES (325, 5, 25);
INSERT INTO `ums_role_resource_relation`
VALUES (326, 5, 26);
INSERT INTO `ums_role_resource_relation`
VALUES (327, 5, 27);
INSERT INTO `ums_role_resource_relation`
VALUES (328, 5, 28);
INSERT INTO `ums_role_resource_relation`
VALUES (329, 5, 29);
INSERT INTO `ums_role_resource_relation`
VALUES (333, 11, 25);
INSERT INTO `ums_role_resource_relation`
VALUES (334, 11, 32);

SET FOREIGN_KEY_CHECKS = 1;
