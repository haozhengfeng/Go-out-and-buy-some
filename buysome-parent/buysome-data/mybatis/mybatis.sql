/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-02-24 22:53:44
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('5', 'admin', '15612134041', null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', '0', '1', '1', '0', '2018-02-12 15:39:20', null);
INSERT INTO `admin` VALUES ('6', null, null, null, null, null, null, null, null, null, '1', null, null);
INSERT INTO `admin` VALUES ('7', 'zfw', null, null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '1', '1', '2018-02-12 21:31:27', null);
INSERT INTO `admin` VALUES ('8', null, null, null, null, null, null, null, null, null, '1', null, null);
INSERT INTO `admin` VALUES ('9', 'hao', null, null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', '2', null, '1', '0', '2018-02-12 22:03:36', null);
INSERT INTO `admin` VALUES ('10', 'weiwei', null, null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '1', '0', '2018-02-12 23:01:51', null);
INSERT INTO `admin` VALUES ('11', 'zyj', null, null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '1', '0', '2018-02-13 10:27:07', null);
INSERT INTO `admin` VALUES ('12', 'mlc', null, null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '0', '0', '2018-02-13 10:27:16', null);
INSERT INTO `admin` VALUES ('13', 'fengshuai', null, null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, '0', '0', '2018-02-14 09:32:08', null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '[0停用1启用]',
  `isdelete` int(1) DEFAULT '0' COMMENT '[0未删除1已删除]',
  `addtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('2', '1001', '生活', '1', '0', '2018-02-13 23:16:53');
INSERT INTO `category` VALUES ('3', '1002', '游玩', '1', '0', '2018-02-14 14:29:26');
INSERT INTO `category` VALUES ('4', '1003', '汽车', '0', '0', '2018-02-14 14:29:50');
INSERT INTO `category` VALUES ('5', '1003', '保健', '0', '0', '2018-02-14 14:30:26');
INSERT INTO `category` VALUES ('6', '1004', '珠宝', '0', '0', '2018-02-14 14:31:32');
INSERT INTO `category` VALUES ('7', '1005', '居家', '0', '0', '2018-02-14 14:32:59');
INSERT INTO `category` VALUES ('8', '1006', '家具', '0', '0', '2018-02-14 14:33:08');
INSERT INTO `category` VALUES ('9', '1007', '母婴', '0', '0', '2018-02-14 14:33:47');
INSERT INTO `category` VALUES ('10', '1008', '服饰', '0', '0', '2018-02-14 14:34:51');
INSERT INTO `category` VALUES ('11', '1009', '食品', '0', '0', '2018-02-14 14:35:11');
INSERT INTO `category` VALUES ('12', '1010', '家电', '0', '0', '2018-02-14 14:36:38');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `goodscover` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `categorycode` int(11) DEFAULT NULL,
  `shopid` int(11) DEFAULT NULL,
  `hasgoods` int(1) DEFAULT '1' COMMENT '[0无货1有货]',
  `status` int(11) DEFAULT '1' COMMENT '[0停用1启用]',
  `isdelete` int(1) DEFAULT '0' COMMENT '[0未删除1已删除]',
  `addtime` datetime DEFAULT NULL,
  `picnum` int(20) DEFAULT '9' COMMENT '最大图片数[9]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '商品名称1', '123', '123', '123', '123', '1', '1', '1', '2018-02-12 15:38:23', '9');
INSERT INTO `goods` VALUES ('2', '高级水杯', '1518535045848.jpg', '非常高级的水杯', '1000', '1', '1', '1', '0', '2018-02-13 23:17:23', '9');
INSERT INTO `goods` VALUES ('3', '红崖谷+红崖谷玻璃吊门票', '1519217028841.jpg', '套票门市价398元\r\n提前一天188元\r\n景区14点后停止检票，15:00后吊桥停止售票\r\n订票需要提供姓名+电话+身份证号！！', '1002', '1', '1', '1', '0', '2018-02-21 20:43:43', '9');
INSERT INTO `goods` VALUES ('4', '宝宝树', '1519287792376.jpg', '宝宝树店主招募', '1007', '1', '1', '1', '0', '2018-02-22 16:23:10', '9');
INSERT INTO `goods` VALUES ('5', '保护环境，从我做起', '1519442551622.jpg', '学校：石家庄市第二十二中学\r\n作者：郝早盼\r\n作品名：保护环境，从我做起\r\n拍摄时间：2018.02.22\r\n作品简介：\r\n   保护环境，人人有责！这是我们作为公民，应做到的义务。守护生态环境，建设美丽家园，应是我们前进的目标。\r\n   弯弯腰，捡起一片纸；伸伸手，拾起一根烟头；走走路，垃圾放进箱。这些都是生活中微不足道的小事，也正是因为这些小事…我们的家园才会发生翻天覆地的变化！\r\n   让我们行动起来！为了我们的家园而奋斗！', '1001', '1', '1', '0', '0', '2018-02-24 11:22:23', '9');
INSERT INTO `goods` VALUES ('6', '北国商城魔幻艺术互动', '1519483148829.jpg', '新春特惠，限量1000张，延期至3月5日\r\n北国商城\r\n风靡百万人的魔幻艺术互动展（光影艺术+名人蜡像）现已开幕！集视觉、艺术、互动娱乐于一身兼顾成人与儿童，只要进去玩，连拽都拽不出来。\r\n成人票24.9元\r\n儿童票9.9元\r\n亲子2+1套票49.9元', '1001', '1', '1', '1', '0', '2018-02-24 22:36:49', '9');

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_pic
-- ----------------------------
INSERT INTO `goods_pic` VALUES ('1', '2', '1518868474028.jpg', 'http://pic.haozf.org/goods/1518868474028.jpg', '2018-02-17 19:54:34');
INSERT INTO `goods_pic` VALUES ('3', '2', '1518869593573.jpg', 'http://pic.haozf.org/goods/1518869593573.jpg', '2018-02-17 20:13:11');
INSERT INTO `goods_pic` VALUES ('4', '2', '1518869718235.jpg', 'http://pic.haozf.org/goods/1518869718235.jpg', '2018-02-17 20:15:16');
INSERT INTO `goods_pic` VALUES ('5', '3', '1519217028190.jpg', 'http://pic.haozf.org/goods/1519217028190.jpg', '2018-02-21 20:43:44');
INSERT INTO `goods_pic` VALUES ('6', '4', '1519287796648.jpg', 'http://pic.haozf.org/goods/1519287796648.jpg', '2018-02-22 16:23:10');
INSERT INTO `goods_pic` VALUES ('7', '4', '1519287800267.jpg', 'http://pic.haozf.org/goods/1519287800267.jpg', '2018-02-22 16:23:10');
INSERT INTO `goods_pic` VALUES ('8', '4', '1519287796856.jpg', 'http://pic.haozf.org/goods/1519287796856.jpg', '2018-02-22 16:23:11');
INSERT INTO `goods_pic` VALUES ('9', '5', '1519442544135.jpg', 'http://pic.haozf.org/goods/1519442544135.jpg', '2018-02-24 11:22:24');
INSERT INTO `goods_pic` VALUES ('10', '5', '1519442551087.jpg', 'http://pic.haozf.org/goods/1519442551087.jpg', '2018-02-24 11:22:24');
INSERT INTO `goods_pic` VALUES ('11', '5', '1519442544885.jpg', 'http://pic.haozf.org/goods/1519442544885.jpg', '2018-02-24 11:22:24');
INSERT INTO `goods_pic` VALUES ('12', '5', '1519442553932.jpg', 'http://pic.haozf.org/goods/1519442553932.jpg', '2018-02-24 11:22:24');
INSERT INTO `goods_pic` VALUES ('13', '5', '1519442551964.jpg', 'http://pic.haozf.org/goods/1519442551964.jpg', '2018-02-24 11:22:24');
INSERT INTO `goods_pic` VALUES ('14', '6', '1519483715974.jpg', 'http://pic.haozf.org/goods/1519483715974.jpg', '2018-02-24 22:48:36');

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
  `qrcode` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '灯火阑珊', '1519483387003.jpg', '1519261081386.jpg', '官方精品推荐', '5', '123', '123', '石家庄锦城小区', '1', '0', '2018-02-12 14:48:45', '10', '9');

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
