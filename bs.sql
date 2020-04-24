/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : bs

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 24/04/2020 20:02:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `articleid` int(11) NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL COMMENT '0待审核,1通过,2不通过',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, '张三', '清华老师讲课就是厉害', '2020-01-07 00:00:00', 1);
INSERT INTO `comment` VALUES (2, 1, '李四', '思路清晰,越学越麻轻松', '2020-01-07 00:00:00', 1);
INSERT INTO `comment` VALUES (3, 1, '钻石', '劳资有的是钱', '2020-01-07 00:00:00', 1);
INSERT INTO `comment` VALUES (12, 2, '彭于晏', '课程不错！', '2020-01-17 17:14:12', 1);
INSERT INTO `comment` VALUES (5, 1, '李四', '没钱没钱就是牛', '2020-01-08 14:03:50', 1);
INSERT INTO `comment` VALUES (13, 2, '彭于晏', '老师不错！', '2020-01-17 17:16:18', 1);
INSERT INTO `comment` VALUES (14, 2, '彭于晏', '阿斯顿', '2020-01-17 22:24:15', 0);
INSERT INTO `comment` VALUES (16, 2, '666', '其实我比较喜欢北大的老师！', '2020-01-22 11:32:53', 1);
INSERT INTO `comment` VALUES (18, 12, '彭于晏', '老师讲课不错的！', '2020-01-28 11:08:18', 1);
INSERT INTO `comment` VALUES (19, 2, '彭于晏', '先这样然后那样', '2020-01-28 11:20:34', 0);
INSERT INTO `comment` VALUES (20, 2, '彭于晏', '666', '2020-01-28 11:20:58', 0);
INSERT INTO `comment` VALUES (21, 10, '彭于晏', '111', '2020-01-28 12:49:56', 1);
INSERT INTO `comment` VALUES (23, 13, '欢迎你!张三丰', '我是张三疯', '2020-03-13 19:49:30', 1);
INSERT INTO `comment` VALUES (25, 1, '张三丰', '123', '2020-04-02 10:52:20', 1);

-- ----------------------------
-- Table structure for comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `comment_reply`;
CREATE TABLE `comment_reply`  (
  `comment_id` int(11) NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `replyname` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `prase_count` int(11) NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment_reply
-- ----------------------------
INSERT INTO `comment_reply` VALUES (1, '张三', '李四', '最会吹水的就是你了。', 100, '2020-01-06 22:32:38');
INSERT INTO `comment_reply` VALUES (2, '李四', '王五', '思路清晰有什么用,还是对代码一窍不通。', 1, '2020-01-06 22:33:27');
INSERT INTO `comment_reply` VALUES (1, '张三', '李六', '吹牛啤，厉害厉害', 1, '2020-01-06 23:40:29');
INSERT INTO `comment_reply` VALUES (1, '李四', '张三', '6666睡觉去吧', 1, '2020-01-06 23:41:33');
INSERT INTO `comment_reply` VALUES (3, '钻石', '李四', '劳资也有的是钱', 10, '2020-01-08 14:34:24');
INSERT INTO `comment_reply` VALUES (1, '张三', '李四', '床前明月光，疑是地上霜。', 10, '2020-01-08 14:44:24');
INSERT INTO `comment_reply` VALUES (1, '张三', '李四', '6666', 10, '2020-01-08 16:04:02');
INSERT INTO `comment_reply` VALUES (1, '张三', '李四', '我就爱睡觉怎么地', 10, '2020-01-08 16:05:39');
INSERT INTO `comment_reply` VALUES (1, '张三', '李四', '666666个p', 10, '2020-01-09 18:33:36');
INSERT INTO `comment_reply` VALUES (12, '彭于晏', '李蛋', '我也觉得不错!', 10, '2020-01-17 22:31:16');
INSERT INTO `comment_reply` VALUES (12, '李蛋', '彭于晏', '清华老师厉害嘛！', 10, '2020-01-22 11:31:41');
INSERT INTO `comment_reply` VALUES (12, '李蛋', '彭于晏', '嗯额', 10, '2020-01-17 23:02:02');
INSERT INTO `comment_reply` VALUES (12, '李蛋', '666', '我推荐吴孟达老师！', 10, '2020-01-22 11:33:41');
INSERT INTO `comment_reply` VALUES (1, '李四', '彭于晏', '666', 10, '2020-01-22 16:51:47');
INSERT INTO `comment_reply` VALUES (2, '彭于晏', '彭于晏', '1', 10, '2020-01-28 11:02:06');
INSERT INTO `comment_reply` VALUES (1, '码农', '彭于晏', '666', 10, '2020-01-28 11:03:02');
INSERT INTO `comment_reply` VALUES (18, '彭于晏', '彭于晏', '666', 10, '2020-01-28 11:09:35');
INSERT INTO `comment_reply` VALUES (5, '彭于晏', '彭于晏', '66', 10, '2020-01-28 22:12:17');
INSERT INTO `comment_reply` VALUES (1, '码农', '彭于晏', '666', 10, '2020-01-28 22:26:53');
INSERT INTO `comment_reply` VALUES (1, '张三', '857', '857857', 10, '2020-02-29 18:53:40');
INSERT INTO `comment_reply` VALUES (1, '张三', '857', 'may i see you again', 10, '2020-02-29 18:56:23');
INSERT INTO `comment_reply` VALUES (3, '钻石', '张三丰', '666', 10, '2020-04-02 10:52:45');
INSERT INTO `comment_reply` VALUES (3, '李四', '张三丰', '77', 10, '2020-04-02 10:52:51');
INSERT INTO `comment_reply` VALUES (1, '857', '张三丰', '847', 10, '2020-04-13 17:14:41');

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iid` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `href` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES (1, 1, '微服务', 'lesson?a=微服务');
INSERT INTO `content` VALUES (2, 1, '区块链', 'lesson?a=区块链');
INSERT INTO `content` VALUES (3, 1, '以太坊', 'lesson?a=以太坊');
INSERT INTO `content` VALUES (4, 1, '机器学习', 'lesson?a=机器学习');
INSERT INTO `content` VALUES (5, 1, '深度学习', 'lesson?a=深度学习');
INSERT INTO `content` VALUES (6, 1, '计算机视觉', 'lesson?a=计算机视觉');
INSERT INTO `content` VALUES (7, 1, '自然语言处理', 'lesson?a=自然语言处理');
INSERT INTO `content` VALUES (8, 1, '数据分析&挖掘', 'lesson?a=数据分析&挖掘');
INSERT INTO `content` VALUES (9, 2, 'HTML/CSS', 'lesson?a=HTML/CSS');
INSERT INTO `content` VALUES (10, 2, 'JavaScript', 'lesson?a=javascript');
INSERT INTO `content` VALUES (11, 2, 'Vue.js', 'lesson?a=vue.js');
INSERT INTO `content` VALUES (12, 2, 'React.JS', 'lesson?a=react.js');
INSERT INTO `content` VALUES (13, 2, 'Angular', 'lesson?a=angular');
INSERT INTO `content` VALUES (14, 2, 'Node.js', 'lesson?a=node.js');
INSERT INTO `content` VALUES (15, 2, 'JQuery', 'lesson?a=jquery');
INSERT INTO `content` VALUES (16, 2, 'Bootstrap', 'lesson?a=bootstrap');
INSERT INTO `content` VALUES (17, 2, 'Sass/Less', 'lesson?a=sass/less');
INSERT INTO `content` VALUES (18, 2, 'WebApp', 'lesson?a=webapp');
INSERT INTO `content` VALUES (19, 2, '小程序', 'lesson?a=小程序');
INSERT INTO `content` VALUES (20, 2, '前端工具', 'lesson?a=qdgj');
INSERT INTO `content` VALUES (21, 2, 'CSS', 'lesson?a=css');
INSERT INTO `content` VALUES (22, 2, 'Html5', 'lesson?a=html5');
INSERT INTO `content` VALUES (23, 2, 'CSS3', 'lesson?a=css3');
INSERT INTO `content` VALUES (24, 3, 'Java', 'lesson?a=java');
INSERT INTO `content` VALUES (25, 3, 'SpringBoot', 'lesson?a=springboot');
INSERT INTO `content` VALUES (26, 3, 'Spring Cloud', 'lesson?a=springcloud');
INSERT INTO `content` VALUES (27, 3, 'Python', 'lesson?a=python');
INSERT INTO `content` VALUES (28, 3, '爬虫', 'lesson?a=pc');
INSERT INTO `content` VALUES (29, 3, 'Django', 'lesson?a=django');
INSERT INTO `content` VALUES (30, 3, 'Tornado', 'lesson?a=tornado');
INSERT INTO `content` VALUES (31, 3, 'Go', 'lesson?a=go');
INSERT INTO `content` VALUES (32, 3, 'PHP', 'lesson?a=php');
INSERT INTO `content` VALUES (33, 3, 'C', 'lesson?a=c');
INSERT INTO `content` VALUES (34, 3, 'C++', 'lesson?a=c++');
INSERT INTO `content` VALUES (35, 3, 'C#', 'lesson?a=c#');
INSERT INTO `content` VALUES (36, 3, 'Ruby', 'lesson?a=ruby');
INSERT INTO `content` VALUES (37, 4, 'Android', 'lesson?a=android');
INSERT INTO `content` VALUES (38, 4, 'IOS', 'lesson?a=ios');
INSERT INTO `content` VALUES (39, 4, 'React', 'lesson?a=react');
INSERT INTO `content` VALUES (40, 4, 'native', 'lesson?a=native');
INSERT INTO `content` VALUES (41, 4, 'WEEX', 'lesson?a=weex');
INSERT INTO `content` VALUES (42, 5, '计算机基础', 'lesson?a=jjjjc');
INSERT INTO `content` VALUES (43, 5, '算法与数据结构', 'lesson?a=sfsj');
INSERT INTO `content` VALUES (44, 5, '数学', 'lesson?a=math');
INSERT INTO `content` VALUES (45, 6, '大数据', 'lesson?a=dsj');
INSERT INTO `content` VALUES (46, 6, 'Hadoop', 'lesson?a=hadoop');
INSERT INTO `content` VALUES (47, 6, 'Spark', 'lesson?a=spark');
INSERT INTO `content` VALUES (48, 6, 'Hbase', 'lesson?a=hbase');
INSERT INTO `content` VALUES (49, 6, 'Storm', 'lesson?a=storm');
INSERT INTO `content` VALUES (50, 6, '云计算', 'lesson?a=yjs');
INSERT INTO `content` VALUES (51, 6, 'AWS', 'lesson?a=aws');
INSERT INTO `content` VALUES (52, 6, 'Docker', 'lesson?a=docker');
INSERT INTO `content` VALUES (53, 6, 'Kubernetes', 'lesson?a=kubernetes');
INSERT INTO `content` VALUES (54, 7, '运维', 'lesson?a=yw');
INSERT INTO `content` VALUES (55, 7, '自动化运维', 'lesson?a=zdhyw');
INSERT INTO `content` VALUES (56, 7, '运维工具', 'lesson?a=ywgj');
INSERT INTO `content` VALUES (57, 7, '中间件', 'lesson?a=zjj');
INSERT INTO `content` VALUES (58, 7, '测试', 'lesson?a=cs');
INSERT INTO `content` VALUES (59, 7, '功能测试', 'lesson?a=gncs');
INSERT INTO `content` VALUES (60, 7, '性能测试', 'lesson?a=xncs');
INSERT INTO `content` VALUES (61, 7, '自动化测试', 'lesson?a=zdhcs');
INSERT INTO `content` VALUES (62, 7, '接口测试', 'lesson?a=jkcs');
INSERT INTO `content` VALUES (63, 7, '安全测试', 'lesson?a=aqcs');
INSERT INTO `content` VALUES (64, 8, 'MySQL', 'lesson?a=mysql');
INSERT INTO `content` VALUES (65, 8, 'Redis', 'lesson?a=redis');
INSERT INTO `content` VALUES (66, 8, 'MongoDB', 'lesson?a=mongodb');
INSERT INTO `content` VALUES (67, 8, 'Oracle', 'lesson?a=oracle');
INSERT INTO `content` VALUES (68, 8, 'SQL Server', 'lesson?a=sqlserve');
INSERT INTO `content` VALUES (69, 8, 'NoSql', 'lesson?a=nosql');
INSERT INTO `content` VALUES (70, 9, '模型制作', 'lesson?a=mxzz');
INSERT INTO `content` VALUES (71, 9, '动效动画', 'lesson?a=dxdh');
INSERT INTO `content` VALUES (72, 9, '设计基础', 'lesson?a=sjjc');
INSERT INTO `content` VALUES (73, 9, '设计工具', 'lesson?a=sjgj');
INSERT INTO `content` VALUES (74, 9, 'APPUI设计', 'lesson?a=appui');
INSERT INTO `content` VALUES (75, 9, '产品交互', 'lesson?a=cpjh');
INSERT INTO `content` VALUES (76, 10, ' Unity 3D', 'lesson?a=unity3d');
INSERT INTO `content` VALUES (77, 10, 'Cocos2d-x', 'lesson?a=cocos2d-x');

-- ----------------------------
-- Table structure for header1
-- ----------------------------
DROP TABLE IF EXISTS `header1`;
CREATE TABLE `header1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of header1
-- ----------------------------
INSERT INTO `header1` VALUES (1, '前沿技术', 'a');
INSERT INTO `header1` VALUES (2, '前端开发', 'b');
INSERT INTO `header1` VALUES (3, '后端开发', 'c');
INSERT INTO `header1` VALUES (4, '移动开发', 'd');
INSERT INTO `header1` VALUES (5, '计算机基础', 'e');
INSERT INTO `header1` VALUES (6, '云计算&大数据', 'e');
INSERT INTO `header1` VALUES (7, '运维&测试', 'f');
INSERT INTO `header1` VALUES (8, '数据库', 'f');
INSERT INTO `header1` VALUES (9, 'UI设计&多媒体', 'g');
INSERT INTO `header1` VALUES (10, '游戏', 'g');

-- ----------------------------
-- Table structure for learncontent
-- ----------------------------
DROP TABLE IF EXISTS `learncontent`;
CREATE TABLE `learncontent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iid` int(11) NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `bz` int(11) NULL DEFAULT NULL,
  `kc` int(11) NULL DEFAULT NULL,
  `sc` int(11) NOT NULL,
  `src` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `author` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of learncontent
-- ----------------------------
INSERT INTO `learncontent` VALUES (1, 1, '微信小程序从0基础到精通1         ', '一站式掌握小程序生态，打造站内零基础精通小程序的最佳路径                ', 5, 4, 99088, 'kc1.jpg', '李蛋');
INSERT INTO `learncontent` VALUES (2, 1, 'Node.js零基础从入门到玩转', '本路线从Node.js基础到热门框架应用，从理解到实战一位。', 4, 5, 36234, 'kc2.jpg', '李蛋');
INSERT INTO `learncontent` VALUES (3, 1, '前端面试求职跳槽通关路线', '路线伴随Web前端工程师一路成长，彻底搞懂不同阶段的面试重点，高效拿下offer。', 5, 7, 15444, 'kc3.jpg', '彭于晏');
INSERT INTO `learncontent` VALUES (4, 1, 'Vue.js 从入门到精通', '路线专为想学Vue却无从下手的人群设计，以实际项目为例，逐层深入，学透Vue。', 3, 5, 18240, 'kc4.jpg', '彭于晏');
INSERT INTO `learncontent` VALUES (5, 1, 'React.js 框架从入门到精通', '路线从零起步玩转React.js开发，从基础夯实到企业级项目实战，直到源码全覆盖。', 4, 6, 81647, 'kc5.jpg', '彭于晏');
INSERT INTO `learncontent` VALUES (6, 1, 'Angular.js 框架从零到全栈开发', '从Angular.js 基础入手，学习全栈技能，上手全栈项目，路线清晰，不走弯路。', 3, 3, 11975, 'kc6.jpg', '余文乐');
INSERT INTO `learncontent` VALUES (7, 2, '从零开始，实现Python Flask入门到高阶', '路线专为零Flask基础的学员定制，助你熟练掌握Flask 核心开发。', 4, 6, 81648, 'kc16.jpg', '余文乐');
INSERT INTO `learncontent` VALUES (8, 2, 'Android工程师高薪面试突破路线', '路线汇集Android高级工程师面试的关键技能，还原面试角，助力面试顺利通关。', 3, 3, 11977, 'kc12.jpg', '余文乐');
INSERT INTO `learncontent` VALUES (9, 2, 'Java从初级到高级的进阶面试线路图', '路线吃透面试学问，伴随身为Java工程师的你一路成长，高效充分准备面试拿offer。', 5, 6, 99085, 'kc9.jpg', '陈冠希');
INSERT INTO `learncontent` VALUES (10, 2, 'SpringCloud全面进阶之路', '运用SpringCloud完成企业级项目微服务改造，不断提升，掌握几大特色模块和主流技术组合', 4, 5, 36239, 'kc10.jpg', '陈冠希');
INSERT INTO `learncontent` VALUES (11, 2, 'Go语言从入门到达人之路', '零基础入门Go语言，在掌握基础语法后向并发提升，并用Go去构建微服务上手区块链项目。', 5, 7, 38336, 'kc15.jpg', '陈冠希');
INSERT INTO `learncontent` VALUES (12, 2, 'Java从网络编程到高并发学习路线', '网络编程、并发编程、高并发、消息队列等问题是Java工程师绕不开的痛点', 3, 5, 18391, 'kc11.jpg', '刘德华');
INSERT INTO `learncontent` VALUES (13, 3, 'Android基础知识  ', '并发编程、高并发、消息队列等问题是Java工程师绕不开的痛点  ', 4, 6, 0, 'kc1.jpg', '刘德华');

-- ----------------------------
-- Table structure for learnrouter
-- ----------------------------
DROP TABLE IF EXISTS `learnrouter`;
CREATE TABLE `learnrouter`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of learnrouter
-- ----------------------------
INSERT INTO `learnrouter` VALUES (1, '前端');
INSERT INTO `learnrouter` VALUES (2, '后台');
INSERT INTO `learnrouter` VALUES (3, '移动端');
INSERT INTO `learnrouter` VALUES (4, '计算机基础');
INSERT INTO `learnrouter` VALUES (5, '大数据');
INSERT INTO `learnrouter` VALUES (6, '测试');
INSERT INTO `learnrouter` VALUES (7, '人工智能');

-- ----------------------------
-- Table structure for learnrouter1
-- ----------------------------
DROP TABLE IF EXISTS `learnrouter1`;
CREATE TABLE `learnrouter1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iid` int(11) NULL DEFAULT NULL,
  `searchid` int(11) NULL DEFAULT NULL,
  `bz` int(11) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of learnrouter1
-- ----------------------------
INSERT INTO `learnrouter1` VALUES (1, 1, 1, 1, '小程序入门', '想快速入门小程序开发就需要从必备的API和核心开发等基础知识入手，建立整个小程序的知识体系。');
INSERT INTO `learnrouter1` VALUES (2, 1, 2, 2, '小程序进阶', '深入学习小程序组件化开发思想，将进一步提高你对小程序的应用能力，有能力应对多种应用场景，进而进军商业级开发');
INSERT INTO `learnrouter1` VALUES (3, 1, 3, 3, '微信小程序云开发', '组件化开发小程序前端部分，云开发小程序后端部分，配套一个后台管理系统，一个人也能实现全栈开发。');
INSERT INTO `learnrouter1` VALUES (4, 1, 4, 4, '小程序框架开发', '熟悉Vue或React的你想更快的上手小程序？本阶段通过当前主流的小程序框架，用最低的成本快速上手小程序多端项目。');
INSERT INTO `learnrouter1` VALUES (6, 2, 13, 1, '测试', '测试');
INSERT INTO `learnrouter1` VALUES (16, 2, 12, 2, '1', '1');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iid` int(11) NOT NULL,
  `permission` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 1, '管理用户');
INSERT INTO `permission` VALUES (2, 1, '权限管理');
INSERT INTO `permission` VALUES (3, 1, '管理课程');
INSERT INTO `permission` VALUES (4, 1, '管理线路');
INSERT INTO `permission` VALUES (5, 2, '管理课程');
INSERT INTO `permission` VALUES (6, 1, '管理评价');
INSERT INTO `permission` VALUES (7, 3, '个人信息');
INSERT INTO `permission` VALUES (8, 3, '课程评价');
INSERT INTO `permission` VALUES (9, 3, '课程搜索');
INSERT INTO `permission` VALUES (10, 3, '观看视频');
INSERT INTO `permission` VALUES (11, 3, '课程线路');
INSERT INTO `permission` VALUES (12, 3, '社区问答');
INSERT INTO `permission` VALUES (13, 2, '课程学习');
INSERT INTO `permission` VALUES (14, 2, '管理评价');
INSERT INTO `permission` VALUES (15, 1, '管理社区');

-- ----------------------------
-- Table structure for search
-- ----------------------------
DROP TABLE IF EXISTS `search`;
CREATE TABLE `search`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `author` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `level` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `sc` int(11) NULL DEFAULT NULL,
  `src` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of search
-- ----------------------------
INSERT INTO `search` VALUES (1, 'Vue核心技术Vue Vue-Router Vuex SSR实战精讲           ', '应用开发，Vue Webpack工作流搭建，Vue Vue-Router Vuex项目架构和Vue服务端渲染深度集成                                          ', '李蛋        ', '初级', 2311, 'learn1.png', '1');
INSERT INTO `search` VALUES (2, 'Python前后端分离开发Vue+Django REST framework实战', '采用当前流行的前后端分离式开发技术，涉及RESTFul API基础知识和Vue项目结构分析，解决了技术开发单一的痛点', '李蛋', '中级', 1833, 'learn2.png', '2');
INSERT INTO `search` VALUES (3, 'Vue Element+Node.js开发企业通用管理后台系统', '综合应用 Vue 和 Node 技术，基于 Element-UI 组件库搭建“小慕读书“的管理后台，通过', '彭于晏', '高级', 538, 'learn3.png', '3');
INSERT INTO `search` VALUES (4, 'Vue2.5开发去哪儿网App 从零基础入门到实战项目', '更好的掌握Vue各个基础知识点。', '彭于晏', '中级', 7164, 'learn4.png', '4');
INSERT INTO `search` VALUES (5, 'Docker+Kubernetes(k8s)微服务容器化实践', '了解它的架构，知道它的运作原理，知道如何安装、使用及如何部署微服务', '彭于晏', '高级', 1570, 'learn5.png', '5');
INSERT INTO `search` VALUES (6, '从天气项目入门Spring Cloud微服务治理', '并从1到0实现微服务的拆分，最后引入Spring Cloud 技术来实现对这些微服务的治理', '李蛋', '中级', 463, 'learn6.png', '6');
INSERT INTO `search` VALUES (7, 'SpringCloud Finchley三版本(M2+RELEASE+SR2)微服务实战', '微服务架构已是当下最热门的话题，许多公司都在从传统架构系统向微服务转化。', '余文乐', '高级', 4744, 'learn7.png', '7');
INSERT INTO `search` VALUES (8, '区块链入门与去中心化应用实战', '本课程将详细为你讲解区块链核心概念与原理，让你快速入门区块链技术；然后基于Python3实现区块链', '余文乐', '初级 ', 1016, 'learn8.png', '1');
INSERT INTO `search` VALUES (9, 'SpringBoot从入门到精通  ', '本路线旨在帮助想快速掌握SpringBoot应用的工程师，全方位多角度带你升级。  ', '彭于晏  ', '  初级', 0, 'learn9.png', '2');
INSERT INTO `search` VALUES (10, '区块链游戏 ForeverBird 开发实战', '从零打造真实上线区块链项目', '余文乐', '中级', 17307, 'learn10.png', '3');
INSERT INTO `search` VALUES (12, '区块链技术核心概念与原理讲解', '区块链已火遍全球，行业人才急缺，岗位炙手可热，学习正当时，本次特邀登链科技首席技术官(Tiny熊），为你讲解区块链技术核心概念与原理', '余文乐', '入门 ', 52310, 'learn11.png', '4');
INSERT INTO `search` VALUES (13, 'Python3入门机器学习 经典算法与应用 轻松入行人工智能', '算法与编程两翼齐飞，由浅入深，一步步的进入机器学习的世界.', '陈冠希', '中级', 3496, 'learn12.png', '5');
INSERT INTO `search` VALUES (14, '掌握Spark机器学习库 大数据开发技能更进一步', '本课程主要讲解Spark机器学习库，侧重实践的讲解，同时也以浅显易懂的方式介绍机器学习算法的内在原理.', '陈冠希', '中级', 401, 'learn1.png', '6');
INSERT INTO `search` VALUES (15, 'JavaScript玩转机器学习 打造你人生中的第一个AI项目', 'JavaScript 作为实现语言，以Tensorflow.js作为主要框架，通过十几个经典案例、覆盖神经网络和机器学习的理论知识', '陈冠希', '初级', 129, 'learn2.png', '7');
INSERT INTO `search` VALUES (16, '深度学习之神经网络(CNN/RNN/GAN)算法原理+实战', 'Tensorflow进行编程的能力，提升深度学习算法能力与项目开发经验。', '陈冠希', '中级 ', 1640, 'learn3.png', '1');
INSERT INTO `search` VALUES (17, '深度学习之目标检测常用算法原理+实践精讲', '熟悉算法工程师在工作中会接触到的数据打包、网络训练、测试等问题,一步步带大家了解和完成目标检测实战案例，尽快进入深度学习领域', '刘德华', '高级 ', 455, 'learn4.png', '2');
INSERT INTO `search` VALUES (18, 'iOS手机深度学习', '了解深度学习的应用场景，以及常用的一些函数，并通过简单案例初步尝试手机深度学习。', '刘德华', '高级 ', 5608, 'learn5.png', '3');
INSERT INTO `search` VALUES (19, '自然语言处理（NLP）入门与实践', '随着人工智能的快速发展，自然语言处理应用愈加广泛。', '刘德华', '初级', 10072, 'learn6.png', '4');
INSERT INTO `search` VALUES (20, '初识HTML/CSS', '本课程从最基本的概念开始讲起，步步深入，带领大家学习HTML、CSS样式基础知识，了解各种常用标签的意义以及基本用法', '刘德华', '入门', 1093739, 'learn7.png', '5');

-- ----------------------------
-- Table structure for searchcontent
-- ----------------------------
DROP TABLE IF EXISTS `searchcontent`;
CREATE TABLE `searchcontent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iid` int(11) NOT NULL,
  `zj` int(11) NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of searchcontent
-- ----------------------------
INSERT INTO `searchcontent` VALUES (1, 1, 1, '垂直菜单的制作');
INSERT INTO `searchcontent` VALUES (2, 1, 2, '水平菜单的制作');
INSERT INTO `searchcontent` VALUES (3, 1, 3, '圆角菜单的制作');
INSERT INTO `searchcontent` VALUES (4, 1, 4, '伸缩菜单的制作——改变高度');
INSERT INTO `searchcontent` VALUES (5, 1, 5, '伸缩菜单的制作——水平方向');
INSERT INTO `searchcontent` VALUES (6, 1, 6, '总结');
INSERT INTO `searchcontent` VALUES (7, 1, 7, '挑战');
INSERT INTO `searchcontent` VALUES (22, 9, 3, '666');
INSERT INTO `searchcontent` VALUES (21, 9, 2, '电商业务玩转SpringBoot');
INSERT INTO `searchcontent` VALUES (20, 9, 1, '快速入门SpringBoot改造SSM项目');
INSERT INTO `searchcontent` VALUES (23, 2, 1, 'Vue  Django REST framework前后端分离的全栈开发');
INSERT INTO `searchcontent` VALUES (24, 2, 2, 'Django REST framework的功能实现与核心源码分析');
INSERT INTO `searchcontent` VALUES (25, 2, 3, 'Sentry完成线上系统的错误日志的监控和告警');
INSERT INTO `searchcontent` VALUES (26, 2, 4, '第三方登录和第三方支付宝的支付集成');
INSERT INTO `searchcontent` VALUES (27, 2, 5, '本地调试远程服务器代码技巧');
INSERT INTO `searchcontent` VALUES (28, 3, 1, '准备阶段');
INSERT INTO `searchcontent` VALUES (29, 3, 2, '开发阶段');
INSERT INTO `searchcontent` VALUES (30, 3, 3, '上线阶段');
INSERT INTO `searchcontent` VALUES (31, 1, 8, 'test');
INSERT INTO `searchcontent` VALUES (47, 4, 1, '789');
INSERT INTO `searchcontent` VALUES (33, 12, 1, 'Java基础知识');
INSERT INTO `searchcontent` VALUES (37, 10, 1, '测试1');
INSERT INTO `searchcontent` VALUES (45, 10, 3, '666');
INSERT INTO `searchcontent` VALUES (42, 10, 2, '测试4');
INSERT INTO `searchcontent` VALUES (43, 12, 2, '123');
INSERT INTO `searchcontent` VALUES (48, 5, 1, '阿德');
INSERT INTO `searchcontent` VALUES (49, 5, 2, '123');
INSERT INTO `searchcontent` VALUES (50, 8, 1, '66');
INSERT INTO `searchcontent` VALUES (51, 13, 1, 'haha');

-- ----------------------------
-- Table structure for searchcontent1
-- ----------------------------
DROP TABLE IF EXISTS `searchcontent1`;
CREATE TABLE `searchcontent1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iid` int(11) NULL DEFAULT NULL,
  `zj` int(11) NULL DEFAULT NULL,
  `zjj` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `url` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 77 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of searchcontent1
-- ----------------------------
INSERT INTO `searchcontent1` VALUES (1, 1, 1, '1-1', '垂直菜单的制作', 'freecourse?id=1&zj=1-1&title=垂直菜单的制作');
INSERT INTO `searchcontent1` VALUES (2, 1, 1, '1-2', '练习题', 'freecourse?id=1&zj=1-2&title=练习题');
INSERT INTO `searchcontent1` VALUES (3, 1, 1, '1-3', '编程练习', 'freecourse?id=1&zj=1-3&title=编程练习');
INSERT INTO `searchcontent1` VALUES (4, 1, 2, '2-1', '水平菜单的制作', 'freecourse?id=1&zj=2-1&title=水平菜单的制作');
INSERT INTO `searchcontent1` VALUES (5, 1, 2, '2-2', '练习题', 'freecourse?id=1&zj=2-2&title=练习题');
INSERT INTO `searchcontent1` VALUES (6, 1, 2, '2-3', '编程练习', 'freecourse?id=1&zj=2-3&title=编程练习');
INSERT INTO `searchcontent1` VALUES (7, 1, 3, '3-1', '圆角菜单的制作', 'freecourse?id=1&zj=3-1&title=圆角菜单的制作');
INSERT INTO `searchcontent1` VALUES (8, 1, 3, '3-2', '练习题', 'freecourse?id=1&zj=3-2&title=练习题');
INSERT INTO `searchcontent1` VALUES (9, 1, 3, '3-3', '编程题', 'freecourse?id=1&zj=3-3&title=编程题');
INSERT INTO `searchcontent1` VALUES (10, 1, 4, '4-1', '伸缩菜单的制作——改变高度', 'freecourse?id=1&zj=4-1&title=伸缩菜单的制作——改变高度');
INSERT INTO `searchcontent1` VALUES (11, 1, 4, '4-2', '编程练习', 'freecourse?id=1&zj=4-2&title=编程练习');
INSERT INTO `searchcontent1` VALUES (12, 1, 5, '5-1', '伸缩菜单的制作——水平方向', 'freecourse?id=1&zj=5-1&title=伸缩菜单的制作——水平方向');
INSERT INTO `searchcontent1` VALUES (13, 1, 5, '5-2', '编程练习', 'freecourse?id=1&zj=5-2&title=编程练习');
INSERT INTO `searchcontent1` VALUES (14, 1, 6, '6-1', '总结', 'freecourse?id=1&zj=6-1&title=总结');
INSERT INTO `searchcontent1` VALUES (15, 1, 6, '6-2', '编程挑战', 'freecourse?id=1&zj=6-2&title=编程挑战');
INSERT INTO `searchcontent1` VALUES (16, 1, 7, '7-1', '挑战题目', 'freecourse?id=1&zj=7-1&title=挑战题目');
INSERT INTO `searchcontent1` VALUES (20, 1, 1, '1-4', '666', 'freecourse?id=1&zj=1-4&title=666');
INSERT INTO `searchcontent1` VALUES (22, 9, 1, '1-1', '入门', 'freecourse?id=9&zj=1-1&title=入门');
INSERT INTO `searchcontent1` VALUES (23, 9, 2, '2-1', '入门', 'freecourse?id=9&zj=2-1&title=入门');
INSERT INTO `searchcontent1` VALUES (26, 9, 1, '1-2', '练习', 'freecourse?id=9&zj=1-2&title=练习');
INSERT INTO `searchcontent1` VALUES (25, 9, 3, '3-1', 'HelloWorld', 'freecourse?id=9&zj=3-1&title=HelloWorld');
INSERT INTO `searchcontent1` VALUES (29, 9, 1, '1-3', '编程', 'freecourse?id=9&zj=1-3&title=编程');
INSERT INTO `searchcontent1` VALUES (31, 2, 1, '1-1', '视频详细讲解', 'freecourse?id=2&zj=1-1&title=视频详细讲解');
INSERT INTO `searchcontent1` VALUES (32, 2, 2, '2-1', '视频详细讲解', 'freecourse?id=2&zj=2-1&title=视频详细讲解');
INSERT INTO `searchcontent1` VALUES (33, 2, 3, '3-1', '视频详细讲解', 'freecourse?id=2&zj=3-1&title=视频详细讲解');
INSERT INTO `searchcontent1` VALUES (34, 2, 4, '4-1', '视频详细讲解', 'freecourse?id=2&zj=4-1&title=视频详细讲解');
INSERT INTO `searchcontent1` VALUES (35, 2, 5, '5-1', '视频详细讲解', 'freecourse?id=2&zj=5-1&title=视频详细讲解');
INSERT INTO `searchcontent1` VALUES (36, 3, 1, '1-1', '准备工作', 'freecourse?id=3&zj=1-1&title=准备工作');
INSERT INTO `searchcontent1` VALUES (37, 3, 2, '2-1', '实现功能', 'freecourse?id=3&zj=2-1&title=实现功能');
INSERT INTO `searchcontent1` VALUES (38, 3, 3, '3-1', '项目发布', 'freecourse?id=3&zj=3-1&title=项目发布');
INSERT INTO `searchcontent1` VALUES (39, 3, 2, '2-2', '涉及技术点包括', 'freecourse?id=3&zj=2-2&title=涉及技术点包括');
INSERT INTO `searchcontent1` VALUES (73, 1, 1, '1-5', '42', 'freecourse?id=1&zj=1-5&title=42');
INSERT INTO `searchcontent1` VALUES (41, 1, 8, '8-1', '666', 'freecourse?id=1&zj=8-1&title=666');
INSERT INTO `searchcontent1` VALUES (43, 12, 1, '1-1', '测试1', 'freecourse?id=12&zj=1-1&title=测试1');
INSERT INTO `searchcontent1` VALUES (49, 10, 1, '1-1', '请编辑', 'freecourse?id=10&zj=3-1&title=请编辑');
INSERT INTO `searchcontent1` VALUES (57, 10, 2, '2-2', 'test4-2', 'freecourse?id=10&zj=3-2&title=test4-2');
INSERT INTO `searchcontent1` VALUES (58, 12, 2, '2-1', '大话西游', 'freecourse?id=12&zj=2-1&title=大话西游');
INSERT INTO `searchcontent1` VALUES (54, 10, 2, '2-1', '请编辑', 'freecourse?id=10&zj=5-1&title=请编辑');
INSERT INTO `searchcontent1` VALUES (60, 10, 3, '3-1', '请编辑', 'freecourse?id=10&zj=4-1&title=请编辑');
INSERT INTO `searchcontent1` VALUES (62, 4, 1, '1-1', '456', 'freecourse?id=4&zj=1-1&title=456');
INSERT INTO `searchcontent1` VALUES (66, 4, 1, '1-2', '789', 'freecourse?id=4&zj=1-2&title=789');
INSERT INTO `searchcontent1` VALUES (64, 5, 1, '1-1', '请编辑', 'freecourse?id=5&zj=1-1&title=请编辑');
INSERT INTO `searchcontent1` VALUES (65, 5, 1, '1-2', '123', 'freecourse?id=5&zj=1-2&title=123');
INSERT INTO `searchcontent1` VALUES (67, 4, 1, '1-3', '857', 'freecourse?id=4&zj=1-3&title=857');
INSERT INTO `searchcontent1` VALUES (68, 5, 1, '1-3', '123', 'freecourse?id=5&zj=1-3&title=123');
INSERT INTO `searchcontent1` VALUES (69, 5, 2, '2-1', '请编辑', 'freecourse?id=5&zj=2-1&title=请编辑');
INSERT INTO `searchcontent1` VALUES (70, 8, 1, '1-1', '请编辑', 'freecourse?id=8&zj=1-1&title=请编辑');
INSERT INTO `searchcontent1` VALUES (71, 13, 1, '1-1', '5个66666', 'freecourse?id=13&zj=1-1&title=5个66666');
INSERT INTO `searchcontent1` VALUES (72, 13, 1, '1-2', '7777777', 'freecourse?id=13&zj=1-2&title=7777777');
INSERT INTO `searchcontent1` VALUES (74, 1, 1, '1-6', '45', 'freecourse?id=1&zj=1-6&title=45');
INSERT INTO `searchcontent1` VALUES (75, 10, 1, '1-2', '678', 'freecourse?id=10&zj=1-2&title=678');
INSERT INTO `searchcontent1` VALUES (76, 10, 1, '1-3', '857', 'freecourse?id=10&zj=1-3&title=857');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `identity` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '彭于晏', '10', 'aa11b3f32b3f0904d5cfbbcee9b468ea', '2', '756565008', '13686881301', '广东');
INSERT INTO `user` VALUES (3, '李蛋', '11', '05120161c7d41a996ebe17e12d464806', '2', '756565007', '13686881302', '广东');
INSERT INTO `user` VALUES (4, '余文乐', '12', '7989cb03f93c8a9440470e9509aeec7e', '2', '756565006', '13686881303', '广东');
INSERT INTO `user` VALUES (1, '张三丰', 'admin', 'c796771702917f23ed77f0f4e9e04de9', '1', '756565005', '13686881305', '广东');
INSERT INTO `user` VALUES (38, '吴彦祖', '16', 'c2a59d41f5d68df8d46675cf41abb04a', '2', '756565008', '13686881301', '12356');
INSERT INTO `user` VALUES (7, '钻石老五', '666', '2d00a55f69eb748b5afa966632b2fadc', '3', '666666', '13666666666', '北京三屯里');
INSERT INTO `user` VALUES (8, '小明', '555', 'dc68f02a3a8bf38e03c8c94c12e35fd8', '3', '2', '2', '2');
INSERT INTO `user` VALUES (42, '857', '857', '60fdb1c2b3f890406542430b331cf9ff', '3', '857857857', '13686881302', '华南理工大学');
INSERT INTO `user` VALUES (5, '陈冠希', '13', '9892c6ccf0adf954516cf2ff71bc7590', '2', '13', '13', '13');
INSERT INTO `user` VALUES (6, '刘德华', '14', 'c7017febd438dbda011967a4b28fbfad', '2', '14', '14', '14');
INSERT INTO `user` VALUES (9, '渣渣辉', '444', '79422b5e1a237478330199ab19e3531f', '3', '666', '666', '666');
INSERT INTO `user` VALUES (10, '古天乐', '15', '5758c60a514c9a173edfbed095fbdc81', '2', '16', '16', '16');
INSERT INTO `user` VALUES (46, '123', '123', 'ec51b39f5f0863ec4db2181d3f75a72a', '3', '123', '123', '123');
INSERT INTO `user` VALUES (50, NULL, '886', 'fe2b58e9e0c8ed68f3e8150d5bcef275', '3', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for userkc
-- ----------------------------
DROP TABLE IF EXISTS `userkc`;
CREATE TABLE `userkc`  (
  `id` int(11) NOT NULL,
  `kc` int(11) NOT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of userkc
-- ----------------------------
INSERT INTO `userkc` VALUES (11, 3);
INSERT INTO `userkc` VALUES (11, 2);
INSERT INTO `userkc` VALUES (11, 13);
INSERT INTO `userkc` VALUES (11, 12);
INSERT INTO `userkc` VALUES (23, 1);
INSERT INTO `userkc` VALUES (11, 1);
INSERT INTO `userkc` VALUES (7, 1);
INSERT INTO `userkc` VALUES (1, 1);

-- ----------------------------
-- Table structure for userrouter
-- ----------------------------
DROP TABLE IF EXISTS `userrouter`;
CREATE TABLE `userrouter`  (
  `id` int(11) NOT NULL,
  `learnrouter` int(11) NOT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of userrouter
-- ----------------------------
INSERT INTO `userrouter` VALUES (11, 3);
INSERT INTO `userrouter` VALUES (11, 2);
INSERT INTO `userrouter` VALUES (11, 4);
INSERT INTO `userrouter` VALUES (11, 1);
INSERT INTO `userrouter` VALUES (11, 1);
INSERT INTO `userrouter` VALUES (23, 8);
INSERT INTO `userrouter` VALUES (7, 2);
INSERT INTO `userrouter` VALUES (1, 1);
INSERT INTO `userrouter` VALUES (1, 4);

-- ----------------------------
-- Table structure for usertype
-- ----------------------------
DROP TABLE IF EXISTS `usertype`;
CREATE TABLE `usertype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usertype
-- ----------------------------
INSERT INTO `usertype` VALUES (1, '管理员');
INSERT INTO `usertype` VALUES (2, '教师');
INSERT INTO `usertype` VALUES (3, '学生');

-- ----------------------------
-- Table structure for wenda
-- ----------------------------
DROP TABLE IF EXISTS `wenda`;
CREATE TABLE `wenda`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `author` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wenda
-- ----------------------------
INSERT INTO `wenda` VALUES (1, '问个愚蠢的问题，培训公司的可怕之处在哪？', '前不久我去一家公司面试，面试管说会让项目经理带一段时间（这段时间也有薪资），等转正后再在工资上扣一定的费用。我就想问为什么有的人一听说是培训撒腿就跑，这样的待遇对我们实习生来说应该不亏啊？', '李蛋', '2020-01-21 00:00:00');
INSERT INTO `wenda` VALUES (2, '用Java编写简单的文本文档倒排索引', '编写一个简单程序建立文本文档的倒排索引，每个倒排表包含文档文件名，自己编了好几次都没能实现？求助\r\n', '彭于晏', '2020-01-21 20:56:54');
INSERT INTO `wenda` VALUES (3, '我的第一个maven例子JSP编译报错，服务器正常启动成功，运行JSP时报错', '报错', '李蛋', '2020-01-21 20:57:38');
INSERT INTO `wenda` VALUES (4, '什么时候才能不问一些弱智问题呢', '希望慕课网增加个措施,太多弱智问题,没有实际问题,导致真正的大神都走了,伸嘴党一堆堆的,不动动脑子,然后回答也是,你们帮他们写代码能帮到他们什么?到头来还是不会写\r\n', '钻石老五', '2020-01-21 20:58:28');
INSERT INTO `wenda` VALUES (5, 'JAVA怎样实现数组不输出数据为0的元素？', '比如：int[] arr={0,1,0,2,0,5}，怎样实现在输出的时候不显示0，输出结果为1,2,5', '钻石老五', '2020-01-26 14:28:41');
INSERT INTO `wenda` VALUES (6, '这是什么情况？', '错误问题- - 。。。', '钻石老五', '2020-01-26 14:29:19');
INSERT INTO `wenda` VALUES (8, '嘻嘻嘻', '嘻嘻嘻', '张三丰', '2020-04-01 11:48:35');

-- ----------------------------
-- Table structure for wenda_comment
-- ----------------------------
DROP TABLE IF EXISTS `wenda_comment`;
CREATE TABLE `wenda_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iid` int(11) NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wenda_comment
-- ----------------------------
INSERT INTO `wenda_comment` VALUES (1, 1, '码农', '因为他们只说的从你工资里扣，并没有告诉你，培训完就让你自己再去找工作的事，反正找不找的工作是你的事，每个月还是会来找你要钱，一个月一两千，一般要还一两年\r\n');
INSERT INTO `wenda_comment` VALUES (2, 1, '彭于晏', '嗯嗯');
INSERT INTO `wenda_comment` VALUES (3, 2, '彭于晏', '老师课讲的不错哟！');
INSERT INTO `wenda_comment` VALUES (4, 2, '彭于晏', '呵呵！');
INSERT INTO `wenda_comment` VALUES (5, 4, '彭于晏', '哈哈');
INSERT INTO `wenda_comment` VALUES (9, 1, '张三丰', '不错不错！');
INSERT INTO `wenda_comment` VALUES (11, 1, '张三丰', '132');
INSERT INTO `wenda_comment` VALUES (12, 1, '张三丰', '857857');

-- ----------------------------
-- Table structure for wenda_reply
-- ----------------------------
DROP TABLE IF EXISTS `wenda_reply`;
CREATE TABLE `wenda_reply`  (
  `id` int(11) NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `replyname` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wenda_reply
-- ----------------------------
INSERT INTO `wenda_reply` VALUES (1, '码农', '彭于晏', '1', '2020-01-21 00:00:00');
INSERT INTO `wenda_reply` VALUES (1, '彭于晏', '码农', '3', '2020-01-21 22:41:17');
INSERT INTO `wenda_reply` VALUES (1, '码农', '彭于晏', '555', '2020-01-28 22:28:04');
INSERT INTO `wenda_reply` VALUES (3, '彭于晏', '彭于晏', 'HHHH', '2020-02-02 18:11:35');
INSERT INTO `wenda_reply` VALUES (1, '彭于晏', '张三丰', '没错没错!', '2020-02-20 16:51:22');
INSERT INTO `wenda_reply` VALUES (2, '彭于晏', '码农', '2', '2020-01-21 00:00:00');
INSERT INTO `wenda_reply` VALUES (1, '彭于晏', '张三丰', '666', '2020-02-20 16:54:26');
INSERT INTO `wenda_reply` VALUES (1, '码农', '张三丰', '是的没错！', '2020-02-20 16:58:49');
INSERT INTO `wenda_reply` VALUES (1, '码农', '张三丰', '是吧！', '2020-02-20 17:23:53');
INSERT INTO `wenda_reply` VALUES (2, '码农', '张三丰', '嗯额', '2020-02-20 17:24:25');
INSERT INTO `wenda_reply` VALUES (2, '彭于晏', '张三丰', '对的', '2020-02-20 17:24:38');
INSERT INTO `wenda_reply` VALUES (9, '张三丰', '张三丰', '自评', '2020-02-20 17:24:54');
INSERT INTO `wenda_reply` VALUES (1, '码农', '张三丰', '456', '2020-04-02 11:20:30');
INSERT INTO `wenda_reply` VALUES (1, '彭于晏', '张三丰', '123', '2020-04-02 11:20:39');

SET FOREIGN_KEY_CHECKS = 1;
