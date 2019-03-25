/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : reptiledatabase

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-03-25 19:24:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bosscitymapped
-- ----------------------------
DROP TABLE IF EXISTS `bosscitymapped`;
CREATE TABLE `bosscitymapped` (
  `city_name` varchar(255) NOT NULL,
  `city_path` varchar(255) NOT NULL,
  `city_ka` varchar(255) DEFAULT NULL,
  `updatetime` datetime NOT NULL,
  `other` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bosscitymapped
-- ----------------------------
INSERT INTO `bosscitymapped` VALUES ('北京', '/c101010100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('上海', '/c101020100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('天津', '/c101030100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('重庆', '/c101040100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('大兴安岭', '/c101051300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('双鸭山', '/c101051200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('鹤岗', '/c101051100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('鸡西', '/c101051000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('七台河', '/c101050900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('大庆', '/c101050800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('伊春', '/c101050700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('黑河', '/c101050600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('绥化', '/c101050500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('佳木斯', '/c101050400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('牡丹江', '/c101050300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('齐齐哈尔', '/c101050200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('哈尔滨', '/c101050100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('延边', '/c101060900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('白山', '/c101060800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('松原', '/c101060700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('辽源', '/c101060600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('白城', '/c101060500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('通化', '/c101060400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('四平', '/c101060300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('吉林', '/c101060200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('长春', '/c101060100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('葫芦岛', '/c101071400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('盘锦', '/c101071300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('朝阳', '/c101071200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('铁岭', '/c101071100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('辽阳', '/c101071000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('阜新', '/c101070900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('营口', '/c101070800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('锦州', '/c101070700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('丹东', '/c101070600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('本溪', '/c101070500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('抚顺', '/c101070400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('鞍山', '/c101070300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('大连', '/c101070200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('沈阳', '/c101070100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('阿拉善', '/c101081200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('兴安盟', '/c101081100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('锡林郭勒', '/c101081000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('乌兰察布', '/c101080900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('巴彦淖尔', '/c101080800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('呼伦贝尔', '/c101080700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('鄂尔多斯', '/c101080600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('赤峰', '/c101080500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('通辽', '/c101080400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('乌海', '/c101080300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('包头', '/c101080200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('呼和浩特', '/c101080100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('秦皇岛', '/c101091100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('邯郸', '/c101091000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('邢台', '/c101090900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('衡水', '/c101090800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('沧州', '/c101090700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('廊坊', '/c101090600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('唐山', '/c101090500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('承德', '/c101090400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('张家口', '/c101090300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('保定', '/c101090200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('石家庄', '/c101090100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('吕梁', '/c101101100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('忻州', '/c101101000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('朔州', '/c101100900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('运城', '/c101100800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('临汾', '/c101100700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('晋城', '/c101100600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('长治', '/c101100500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('晋中', '/c101100400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('阳泉', '/c101100300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('大同', '/c101100200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('太原', '/c101100100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('铜川', '/c101111000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('宝鸡', '/c101110900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('汉中', '/c101110800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('安康', '/c101110700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('商洛', '/c101110600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('渭南', '/c101110500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('榆林', '/c101110400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('延安', '/c101110300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('咸阳', '/c101110200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('西安', '/c101110100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('聊城', '/c101121700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('莱芜', '/c101121600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('日照', '/c101121500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('枣庄', '/c101121400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('威海', '/c101121300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('东营', '/c101121200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('滨州', '/c101121100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('菏泽', '/c101121000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('临沂', '/c101120900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('泰安', '/c101120800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('济宁', '/c101120700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('潍坊', '/c101120600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('烟台', '/c101120500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('德州', '/c101120400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('淄博', '/c101120300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('青岛', '/c101120200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('济南', '/c101120100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('双河市', '/c101132400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('昆玉市', '/c101132300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('可克达拉市', '/c101132200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('北屯市', '/c101132100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('铁门关', '/c101132000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('五家渠', '/c101131900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('图木舒克', '/c101131800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('阿拉尔', '/c101131700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('石河子', '/c101131600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('阿勒泰', '/c101131500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('塔城', '/c101131400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('和田', '/c101131300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('喀什', '/c101131200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('克孜勒苏柯尔克孜', '/c101131100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('阿克苏', '/c101131000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('哈密', '/c101130900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('吐鲁番', '/c101130800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('伊犁', '/c101130600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('博尔塔拉', '/c101130500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('巴音郭楞', '/c101130400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('昌吉', '/c101130300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('克拉玛依', '/c101130200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('乌鲁木齐', '/c101130100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('海西', '/c101150800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('玉树', '/c101150700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('果洛', '/c101150600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('海南', '/c101150500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('黄南', '/c101150400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('海北', '/c101150300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('海东', '/c101150200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('西宁', '/c101150100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('甘南', '/c101161400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('临夏', '/c101161300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('嘉峪关', '/c101161200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('陇南', '/c101161100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('白银', '/c101161000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('天水', '/c101160900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('酒泉', '/c101160800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('张掖', '/c101160700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('金昌', '/c101160600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('武威', '/c101160500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('庆阳', '/c101160400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('平凉', '/c101160300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('定西', '/c101160200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('兰州', '/c101160100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('中卫', '/c101170500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('固原', '/c101170400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('吴忠', '/c101170300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('石嘴山', '/c101170200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('银川', '/c101170100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('济源', '/c101181800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('三门峡', '/c101181700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('驻马店', '/c101181600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('漯河', '/c101181500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('周口', '/c101181400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('濮阳', '/c101181300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('鹤壁', '/c101181200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('焦作', '/c101181100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('商丘', '/c101181000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('洛阳', '/c101180900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('开封', '/c101180800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('南阳', '/c101180700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('信阳', '/c101180600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('平顶山', '/c101180500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('许昌', '/c101180400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('新乡', '/c101180300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('安阳', '/c101180200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('郑州', '/c101180100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('宿迁', '/c101191300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('泰州', '/c101191200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('常州', '/c101191100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('连云港', '/c101191000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('淮安', '/c101190900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('徐州', '/c101190800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('盐城', '/c101190700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('扬州', '/c101190600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('南通', '/c101190500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('苏州', '/c101190400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('镇江', '/c101190300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('无锡', '/c101190200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('南京', '/c101190100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('神农架', '/c101201700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('天门', '/c101201600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('潜江', '/c101201500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('仙桃', '/c101201400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('恩施', '/c101201300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('荆门', '/c101201200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('随州', '/c101201100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('十堰', '/c101201000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('宜昌', '/c101200900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('荆州', '/c101200800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('咸宁', '/c101200700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('黄石', '/c101200600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('黄冈', '/c101200500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('孝感', '/c101200400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('鄂州', '/c101200300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('襄阳', '/c101200200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('武汉', '/c101200100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('舟山', '/c101211100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('衢州', '/c101211000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('金华', '/c101210900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('丽水', '/c101210800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('温州', '/c101210700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('台州', '/c101210600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('绍兴', '/c101210500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('宁波', '/c101210400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('嘉兴', '/c101210300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('湖州', '/c101210200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('杭州', '/c101210100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('黄山', '/c101221600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('池州', '/c101221500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('六安', '/c101221400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('宣城', '/c101221300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('铜陵', '/c101221200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('淮北', '/c101221100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('滁州', '/c101221000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('亳州', '/c101220900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('阜阳', '/c101220800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('宿州', '/c101220700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('安庆', '/c101220600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('马鞍山', '/c101220500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('淮南', '/c101220400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('芜湖', '/c101220300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('蚌埠', '/c101220200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('合肥', '/c101220100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('南平', '/c101230900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('三明', '/c101230800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('龙岩', '/c101230700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('漳州', '/c101230600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('泉州', '/c101230500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('莆田', '/c101230400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('宁德', '/c101230300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('厦门', '/c101230200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('福州', '/c101230100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('鹰潭', '/c101241100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('新余', '/c101241000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('萍乡', '/c101240900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('景德镇', '/c101240800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('赣州', '/c101240700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('吉安', '/c101240600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('宜春', '/c101240500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('抚州', '/c101240400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('上饶', '/c101240300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('九江', '/c101240200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('南昌', '/c101240100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('湘西', '/c101251400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('永州', '/c101251300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('怀化', '/c101251200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('张家界', '/c101251100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('岳阳', '/c101251000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('邵阳', '/c101250900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('娄底', '/c101250800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('益阳', '/c101250700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('常德', '/c101250600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('郴州', '/c101250500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('衡阳', '/c101250400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('株洲', '/c101250300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('湘潭', '/c101250200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('长沙', '/c101250100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('黔西南', '/c101260900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('黔南', '/c101260800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('黔东南', '/c101260700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('六盘水', '/c101260600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('毕节', '/c101260500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('铜仁', '/c101260400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('安顺', '/c101260300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('遵义', '/c101260200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('贵阳', '/c101260100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('甘孜', '/c101272100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('凉山', '/c101272000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('阿坝', '/c101271900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('广元', '/c101271800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('德阳', '/c101271700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('雅安', '/c101271600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('眉山', '/c101271500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('乐山', '/c101271400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('资阳', '/c101271300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('内江', '/c101271200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('宜宾', '/c101271100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('泸州', '/c101271000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('巴中', '/c101270900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('广安', '/c101270800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('遂宁', '/c101270700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('达州', '/c101270600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('南充', '/c101270500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('绵阳', '/c101270400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('自贡', '/c101270300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('攀枝花', '/c101270200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('成都', '/c101270100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('东沙群岛', '/c101282200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('汕尾', '/c101282100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('茂名', '/c101282000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('揭阳', '/c101281900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('阳江', '/c101281800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('中山', '/c101281700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('东莞', '/c101281600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('潮州', '/c101281500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('云浮', '/c101281400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('清远', '/c101281300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('河源', '/c101281200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('江门', '/c101281100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('湛江', '/c101281000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('肇庆', '/c101280900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('佛山', '/c101280800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('珠海', '/c101280700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('深圳', '/c101280600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('汕头', '/c101280500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('梅州', '/c101280400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('惠州', '/c101280300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('韶关', '/c101280200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('广州', '/c101280100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('楚雄', '/c101291700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('大理', '/c101291600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('迪庆', '/c101291500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('怒江', '/c101291400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('德宏', '/c101291300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('红河', '/c101291200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('文山', '/c101291100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('西双版纳', '/c101291000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('丽江', '/c101290900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('临沧', '/c101290800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('昭通', '/c101290700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('普洱', '/c101290500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('玉溪', '/c101290400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('保山', '/c101290300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('曲靖', '/c101290200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('昆明', '/c101290100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('防城港', '/c101301400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('北海', '/c101301300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('河池', '/c101301200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('钦州', '/c101301100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('百色', '/c101301000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('玉林', '/c101300900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('贵港', '/c101300800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('贺州', '/c101300700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('梧州', '/c101300600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('桂林', '/c101300500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('来宾', '/c101300400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('柳州', '/c101300300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('崇左', '/c101300200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('南宁', '/c101300100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('琼中', '/c101311900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('保亭', '/c101311800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('陵水', '/c101311700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('乐东', '/c101311600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('昌江', '/c101311500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('白沙', '/c101311400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('临高', '/c101311300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('澄迈', '/c101311200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('屯昌', '/c101311100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('定安', '/c101311000/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('东方', '/c101310900/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('万宁', '/c101310800/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('文昌', '/c101310700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('琼海', '/c101310600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('五指山', '/c101310500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('儋州', '/c101310400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('三沙', '/c101310300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('三亚', '/c101310200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('海口', '/c101310100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('台湾', '/c101341100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('阿里', '/c101140700/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('那曲', '/c101140600/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('山南', '/c101140500/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('林芝', '/c101140400/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('昌都', '/c101140300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('日喀则', '/c101140200/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('拉萨', '/c101140100/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('香港', '/c101320300/', null, '2019-02-07 11:23:38', '');
INSERT INTO `bosscitymapped` VALUES ('澳门', '/c101330100/', null, '2019-02-07 11:23:38', '');

-- ----------------------------
-- Table structure for bossmapped
-- ----------------------------
DROP TABLE IF EXISTS `bossmapped`;
CREATE TABLE `bossmapped` (
  `exp_info` varchar(255) DEFAULT NULL,
  `page_exp` varchar(100) DEFAULT NULL,
  `boss_exp` varchar(255) DEFAULT NULL,
  `exp_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bossmapped
-- ----------------------------
INSERT INTO `bossmapped` VALUES ('不限经验', 'exp-all', 'sel-exp-0', null);
INSERT INTO `bossmapped` VALUES ('应届生', 'exp-0', 'sel-exp-102', 'e_102');
INSERT INTO `bossmapped` VALUES ('1年以内', 'exp-1', 'sel-exp-103', 'e_103');
INSERT INTO `bossmapped` VALUES ('1-3年', 'exp-1-3', 'sel-exp-104', 'e_104');
INSERT INTO `bossmapped` VALUES ('3-5年', 'exp-3-5', 'sel-exp-105', 'e_105');
INSERT INTO `bossmapped` VALUES ('5-10年', 'exp-5-10', 'sel-exp-106', 'e_106');
INSERT INTO `bossmapped` VALUES ('10年以上', 'exp-10', 'sel-exp-107', 'e_107');
INSERT INTO `bossmapped` VALUES ('不限学历', 'degree-all', null, null);
INSERT INTO `bossmapped` VALUES ('初中及以下', 'degree-0', 'sel-degree-209', 'd_209');
INSERT INTO `bossmapped` VALUES ('中专/中技', 'degree-1', 'sel-degree-208', 'd_208');
INSERT INTO `bossmapped` VALUES ('高中', 'degree-2', 'sel-degree-206', 'd_206');
INSERT INTO `bossmapped` VALUES ('大专', 'degree-3', 'sel-degree-202', 'd_202');
INSERT INTO `bossmapped` VALUES ('本科', 'degree-4', 'sel-degree-203', 'd_203');
INSERT INTO `bossmapped` VALUES ('硕士', 'degree-5', 'sel-degree-204', 'd_204');
INSERT INTO `bossmapped` VALUES ('博士', 'degree-6', 'sel-degree-205', 'd_205');
INSERT INTO `bossmapped` VALUES ('不限薪资', 'salary-all', '', null);
INSERT INTO `bossmapped` VALUES ('3k以下', 'salary-0', 'sel-salary-1', 'y_1');
INSERT INTO `bossmapped` VALUES ('3-5k', 'salary-1', 'sel-salary-2', 'y_2');
INSERT INTO `bossmapped` VALUES ('5-10k', 'salary-2', 'sel-salary-3', 'y_3');
INSERT INTO `bossmapped` VALUES ('10-15k', 'salary-3', 'sel-salary-4', 'y_4');
INSERT INTO `bossmapped` VALUES ('15-20k', 'salary-4', 'sel-salary-5', 'y_5');
INSERT INTO `bossmapped` VALUES ('20-30k', 'salary-5', 'sel-salary-6', 'y_6');
INSERT INTO `bossmapped` VALUES ('30-50k', 'salary-6', 'sel-salary-7', 'y_7');
INSERT INTO `bossmapped` VALUES ('50k以上', 'salary-7', 'sel-salary-8', 'y_8');
INSERT INTO `bossmapped` VALUES ('不限融资', 'stage-all', null, null);
INSERT INTO `bossmapped` VALUES ('未融资', 'stage-0', 'sel-stage-801', 't_801');
INSERT INTO `bossmapped` VALUES ('天使轮', 'stage-1', 'sel-stage-802', 't_802');
INSERT INTO `bossmapped` VALUES ('A轮', 'stage-2', 'sel-stage-803', 't_803');
INSERT INTO `bossmapped` VALUES ('B轮', 'stage-3', 'sel-stage-804', 't_804');
INSERT INTO `bossmapped` VALUES ('C轮', 'stage-4', 'sel-stage-805', 't_805');
INSERT INTO `bossmapped` VALUES ('D轮及以上', 'stage-5', 'sel-stage-806', 't_806');
INSERT INTO `bossmapped` VALUES ('已上市', 'stage-6', 'sel-stage-807', 't_807');
INSERT INTO `bossmapped` VALUES ('不需要融资', 'stage-7', 'sel-stage-808', 't_808');
INSERT INTO `bossmapped` VALUES ('不限人数', 'scale-all', null, null);
INSERT INTO `bossmapped` VALUES ('0-20人', 'scale-0', 'sel-scale-301', 's_301');
INSERT INTO `bossmapped` VALUES ('20-99人', 'scale-1', 'sel-scale-302', 's_302');
INSERT INTO `bossmapped` VALUES ('100-499人', 'scale-2', 'sel-scale-303', 's_303');
INSERT INTO `bossmapped` VALUES ('500-999人', 'scale-3', 'sel-scale-304', 's_304');
INSERT INTO `bossmapped` VALUES ('1000-9999人', 'scale-4', 'sel-scale-305', 's_305');
INSERT INTO `bossmapped` VALUES ('10000人以上', 'scale-5', 'sel-scale-306', 's_306');

-- ----------------------------
-- Table structure for citymapped
-- ----------------------------
DROP TABLE IF EXISTS `citymapped`;
CREATE TABLE `citymapped` (
  `city_name` varchar(100) DEFAULT NULL,
  `page_city` varchar(255) DEFAULT NULL,
  `other1` varchar(255) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of citymapped
-- ----------------------------
INSERT INTO `citymapped` VALUES ('全国', 'quanguo', null, '');
INSERT INTO `citymapped` VALUES ('北京', 'beijing', null, '');
INSERT INTO `citymapped` VALUES ('上海', 'shanghai', null, '');
INSERT INTO `citymapped` VALUES ('广州', 'guangzhou', null, '');
INSERT INTO `citymapped` VALUES ('深圳', 'shenzhen', null, '');
INSERT INTO `citymapped` VALUES ('杭州', 'hangzhou', null, '');
INSERT INTO `citymapped` VALUES ('天津', 'tianjin', null, '');
INSERT INTO `citymapped` VALUES ('西安', 'xian', null, '');
INSERT INTO `citymapped` VALUES ('苏州', 'suzhou', null, '');
INSERT INTO `citymapped` VALUES ('武汉', 'wuhan', null, '');
INSERT INTO `citymapped` VALUES ('厦门', 'xiamen', null, '');
INSERT INTO `citymapped` VALUES ('长沙', 'changsha', null, '');
INSERT INTO `citymapped` VALUES ('成都', 'chengdu', null, '');
INSERT INTO `citymapped` VALUES ('郑州', 'zhengzhou', null, '');
INSERT INTO `citymapped` VALUES ('重庆', 'chongqing', null, '');

-- ----------------------------
-- Table structure for degreemapped
-- ----------------------------
DROP TABLE IF EXISTS `degreemapped`;
CREATE TABLE `degreemapped` (
  `page_degree` varchar(100) DEFAULT NULL,
  `boss_degree` varchar(100) DEFAULT NULL,
  `lagou` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of degreemapped
-- ----------------------------
INSERT INTO `degreemapped` VALUES ('degree-all', 'sel-degree-0', null);
INSERT INTO `degreemapped` VALUES ('degree-0', 'sel-degree-209', null);
INSERT INTO `degreemapped` VALUES ('degree-1', 'sel-degree-208', null);
INSERT INTO `degreemapped` VALUES ('sel-degree-206', 'sel-degree-206', null);
INSERT INTO `degreemapped` VALUES (null, null, null);
INSERT INTO `degreemapped` VALUES (null, null, null);
INSERT INTO `degreemapped` VALUES (null, null, null);
INSERT INTO `degreemapped` VALUES (null, null, null);
INSERT INTO `degreemapped` VALUES (null, null, null);
INSERT INTO `degreemapped` VALUES (null, null, null);
INSERT INTO `degreemapped` VALUES (null, null, null);

-- ----------------------------
-- Table structure for hotcity
-- ----------------------------
DROP TABLE IF EXISTS `hotcity`;
CREATE TABLE `hotcity` (
  `hc_id` varchar(200) NOT NULL,
  `hc_name` varchar(100) DEFAULT NULL,
  `other1` varchar(255) DEFAULT NULL,
  `other2` varchar(255) DEFAULT NULL,
  `other3` varchar(255) DEFAULT NULL,
  `other4` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotcity
-- ----------------------------
INSERT INTO `hotcity` VALUES ('100010000', '全国', '/c100010000/', 'sel-city-100010000', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101010100', '北京', '/c101010100/', 'sel-city-101010100', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101020100', '上海', '/c101020100/', 'sel-city-101020100', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101280100', '广州', '/c101280100/', 'sel-city-101280100', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101280600', '深圳', '/c101280600/', 'sel-city-101280600', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101210100', '杭州', '/c101210100/', 'sel-city-101210100', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101030100', '天津', '/c101030100/', 'sel-city-101030100', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101110100', '西安', '/c101110100/', 'sel-city-101110100', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101190400', '苏州', '/c101190400/', 'sel-city-101190400', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101200100', '武汉', '/c101200100/', 'sel-city-101200100', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101230200', '厦门', '/c101230200/', 'sel-city-101230200', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101250100', '长沙', '/c101250100/', 'sel-city-101250100', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101270100', '成都', '/c101270100/', 'sel-city-101270100', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101180100', '郑州', '/c101180100/', 'sel-city-101180100', '2019-03-15 15:11:11', '');
INSERT INTO `hotcity` VALUES ('101040100', '重庆', '/c101040100/', 'sel-city-101040100', '2019-03-15 15:11:11', '');

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
