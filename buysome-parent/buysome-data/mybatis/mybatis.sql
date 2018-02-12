/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2018-02-12 22:52:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `cellphone` varchar(20) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `weixin` varchar(50) DEFAULT NULL,
  `weibo` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL COMMENT '[0超级管机员1管理员2用户]',
  `shopid` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '[0停用1启用]',
  `isdelete` int(1) DEFAULT '0' COMMENT '[0未删除1已删除]',
  `addtime` datetime DEFAULT NULL,
  `auth` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('5', 'admin', '15612134041', null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', '0', '123', '1', '0', '2018-02-12 15:39:20', null);
INSERT INTO `admin` VALUES ('6', null, null, null, null, null, null, null, null, null, '1', null, null);
INSERT INTO `admin` VALUES ('7', 'zfw', null, null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '1', '0', '2018-02-12 21:31:27', null);
INSERT INTO `admin` VALUES ('8', null, null, null, null, null, null, null, null, null, '1', null, null);
INSERT INTO `admin` VALUES ('9', 'hao', null, null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', '2', null, '1', '0', '2018-02-12 22:03:36', null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '[0停用1启用]',
  `isdelete` int(1) DEFAULT '0' COMMENT '[0未删除1已删除]',
  `addtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '商品分类', '1', '0', '2018-02-12 15:38:05');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `goodscover` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `categoryid` int(11) DEFAULT NULL,
  `shopid` int(11) DEFAULT NULL,
  `hasgoods` int(1) DEFAULT '1' COMMENT '[0无货1有货]',
  `status` int(11) DEFAULT '1' COMMENT '[0停用1启用]',
  `isdelete` int(1) DEFAULT '0' COMMENT '[0未删除1已删除]',
  `addtime` datetime DEFAULT NULL,
  `picnum` int(20) DEFAULT '9' COMMENT '最大图片数[9]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '商品名称1', '123', '123', '123', '123', '1', '1', '0', '2018-02-12 15:38:23', '9');

-- ----------------------------
-- Table structure for goods_pic
-- ----------------------------
DROP TABLE IF EXISTS `goods_pic`;
CREATE TABLE `goods_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) DEFAULT NULL,
  `picpath` varchar(255) DEFAULT NULL,
  `picurl` varchar(255) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_pic
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `cellphone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `shopcover` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `adminid` int(11) DEFAULT NULL,
  `lon` varchar(50) DEFAULT NULL COMMENT '[经度]',
  `lat` varchar(50) DEFAULT NULL COMMENT '[纬度]',
  `location` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '[0停用1启用]',
  `isdelete` int(1) DEFAULT '0' COMMENT '[0未删除1已删除]',
  `addtime` datetime DEFAULT NULL,
  `goodsnum` int(20) DEFAULT '10' COMMENT '商铺最大商品数[10]',
  `picnum` int(11) DEFAULT '9' COMMENT '店铺最多图片[9]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '店铺名称1', '123', '123', '1', '123', '123', '123', '1', '0', '2018-02-12 14:48:45', '10', '9');

-- ----------------------------
-- Table structure for shop_pic
-- ----------------------------
DROP TABLE IF EXISTS `shop_pic`;
CREATE TABLE `shop_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopid` int(11) DEFAULT NULL,
  `picpath` varchar(255) DEFAULT NULL,
  `picurl` varchar(255) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_pic
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '郝筱薰', '123');
