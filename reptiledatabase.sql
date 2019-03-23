/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : reptiledatabase

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-03-23 17:38:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_agent
-- ----------------------------
DROP TABLE IF EXISTS `user_agent`;
CREATE TABLE `user_agent` (
  `agentid` varchar(255) DEFAULT NULL,
  `agentkey` varchar(100) DEFAULT NULL,
  `agent` varchar(500) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_agent
-- ----------------------------
INSERT INTO `user_agent` VALUES ('01', 'Opera', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 OPR/26.0.1656.60\r\n', 'Opera');
INSERT INTO `user_agent` VALUES ('02', 'Opera', 'Opera/8.0 (Windows NT 5.1; U; en)', 'Opera');
INSERT INTO `user_agent` VALUES ('03', 'Opera', 'Mozilla/5.0 (Windows NT 5.1; U; en; rv:1.8.1) Gecko/20061208 Firefox/2.0.0 Opera 9.50', 'Opera');
INSERT INTO `user_agent` VALUES ('04', 'Opera', 'Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; en) Opera 9.50', 'Opera');
INSERT INTO `user_agent` VALUES ('05', 'Firefox', 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0', 'Firefox');
INSERT INTO `user_agent` VALUES ('06', 'Safari', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2', 'Safari');
INSERT INTO `user_agent` VALUES ('07', 'Firefox', 'Mozilla/5.0 (X11; U; Linux x86_64; zh-CN; rv:1.9.2.10) Gecko/20100922 Ubuntu/10.10 (maverick) Firefox/3.6.10', 'Firefox');
INSERT INTO `user_agent` VALUES ('08', 'Chrome', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2172.15 Safari/522.21', 'Chrome');
INSERT INTO `user_agent` VALUES ('09', '360', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36', '360');
INSERT INTO `user_agent` VALUES ('10', 'Chrome', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1258.31 Safari/522.23', 'Chrome');
INSERT INTO `user_agent` VALUES ('11', 'Chrome', 'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.133 Safari/535.21', 'Chrome');
INSERT INTO `user_agent` VALUES ('12', '360', 'Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko', '360');
INSERT INTO `user_agent` VALUES ('13', 'taobao', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.11 TaoBrowser/2.0 Safari/536.11', 'taobao');
INSERT INTO `user_agent` VALUES ('14', 'liebao', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.71 Safari/537.1 LBBROWSER', 'liebao');
INSERT INTO `user_agent` VALUES ('15', 'liebao', 'Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; LBBROWSER) ', 'liebao');
INSERT INTO `user_agent` VALUES ('16', 'liebao', 'Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 732; .NET4.0C; .NET4.0E; LBBROWSER)', 'liebao');
INSERT INTO `user_agent` VALUES ('17', 'QQ', 'Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; QQBrowser/7.0.3698.400)', 'QQ');
INSERT INTO `user_agent` VALUES ('18', 'QQ', 'Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 732; .NET4.0C; .NET4.0E)', 'QQ');
INSERT INTO `user_agent` VALUES ('19', 'sougou', 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SV1; QQDownload 732; .NET4.0C; .NET4.0E; SE 2.X MetaSr 1.0)', 'sougou');
INSERT INTO `user_agent` VALUES ('20', 'maxthon', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Maxthon/4.4.3.4000 Chrome/30.0.1599.101 Safari/537.36', 'maxthon');
INSERT INTO `user_agent` VALUES ('21', 'UC', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 UBrowser/4.0.3214.0 Safari/528.11', 'UC浏览器');
INSERT INTO `user_agent` VALUES ('22', 'Safari', 'Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50', 'safari 5.1 – MAC ');
INSERT INTO `user_agent` VALUES ('23', 'Safari', 'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50', 'safari 5.1 – Windows ');
INSERT INTO `user_agent` VALUES ('24', 'IE', 'Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;', 'IE 9.0');
INSERT INTO `user_agent` VALUES ('25', 'IE', 'Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)', 'IE 8.0');
INSERT INTO `user_agent` VALUES ('26', 'IE', 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)', 'IE 7.0');
INSERT INTO `user_agent` VALUES ('27', 'IE', 'Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)', 'IE 6.0');
INSERT INTO `user_agent` VALUES ('28', 'Firefox', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:2.0.1) Gecko/20100101 Firefox/4.0.1', 'Firefox 4.0.1 – MAC');
INSERT INTO `user_agent` VALUES ('29', 'Firefox', 'Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1', 'Firefox 4.0.1 – Windows');
INSERT INTO `user_agent` VALUES ('30', 'Opera', 'Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; en) Presto/2.8.131 Version/11.11', 'Opera 11.11 – MAC');
INSERT INTO `user_agent` VALUES ('31', 'Opera', 'Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11', 'Opera 11.11 – Windows');
INSERT INTO `user_agent` VALUES ('32', 'Chrome', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11', 'Chrome 17.0 – MAC');
INSERT INTO `user_agent` VALUES ('33', '傲游', 'User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon 2.0)', '傲游（Maxthon）');
INSERT INTO `user_agent` VALUES ('34', '腾讯', 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; TencentTraveler 4.0)', '腾讯TT');
INSERT INTO `user_agent` VALUES ('35', '世界之窗', 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)', '世界之窗（The World） 2.x ');
INSERT INTO `user_agent` VALUES ('36', '世界之窗', 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; The World)', '世界之窗（The World） 3.x ');
INSERT INTO `user_agent` VALUES ('37', '360', 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)', '360浏览器 ');
INSERT INTO `user_agent` VALUES ('38', 'Avant', 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Avant Browser)', 'Avant');
INSERT INTO `user_agent` VALUES ('39', 'Firefox', 'Mozilla/5.0 (Windows; U; Windows NT 5.2) Gecko/2008070208 Firefox/3.0.1', 'Firefox');
INSERT INTO `user_agent` VALUES ('40', 'Firefox', 'Mozilla/5.0 (Windows; U; Windows NT 5.1) Gecko/20070309 Firefox/2.0.0.3', 'Firefox');
INSERT INTO `user_agent` VALUES ('41', 'Firefox', 'Mozilla/5.0 (Windows; U; Windows NT 5.1) Gecko/20070803 Firefox/1.5.0.12', 'Firefox');
INSERT INTO `user_agent` VALUES ('42', 'Opera', 'Mozilla/5.0 (Macintosh; PPC Mac OS X; U; en) Opera 8.0', 'Opera');
INSERT INTO `user_agent` VALUES ('43', 'Opera', 'Opera/8.0 (Macintosh; PPC Mac OS X; U; en)', 'Opera');
INSERT INTO `user_agent` VALUES ('44', 'Navigator', 'Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.12) Gecko/20080219 Firefox/2.0.0.12 Navigator/9.0.0.6', 'Navigator 浏览器');
INSERT INTO `user_agent` VALUES ('45', 'Firefox', 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.2', 'Firefox');
INSERT INTO `user_agent` VALUES ('46', 'Firefox', 'Mozilla/5.0 (X11; U; Linux x86_64; zh-CN; rv:1.9.2.10) Gecko/20100922 Ubuntu/10.10 (maverick) Firefox/3.6.10\r\n', 'Firefox');
INSERT INTO `user_agent` VALUES ('47', 'Chrome', 'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.133 Safari/534.16\r\n', 'Chrome');
INSERT INTO `user_agent` VALUES ('48', 'Chrome', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11\r\n', 'Chrome');
INSERT INTO `user_agent` VALUES ('49', 'UC', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 UBrowser/4.0.3214.0 Safari/537.36\r\n', 'UC');
