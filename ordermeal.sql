# Host: 127.0.0.1  (Version: 5.5.25a)
# Date: 2016-01-21 21:17:25
# Generator: MySQL-Front 5.3  (Build 2.28)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

DROP DATABASE IF EXISTS `ordermeal`;
CREATE DATABASE `ordermeal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ordermeal`;

#
# Source for table "menu"
#

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT '' COMMENT '菜名',
  `price` float(2,0) DEFAULT '0',
  `pid` int(11) DEFAULT NULL,
  `remark` text COMMENT '备注',
  PRIMARY KEY (`Id`),
  KEY `foreign` (`pid`),
  CONSTRAINT `foreign` FOREIGN KEY (`pid`) REFERENCES `menu` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8;

#
# Data for table "menu"
#

INSERT INTO `menu` VALUES (1,'酱板鸭',22,NULL,NULL),(2,'青椒皮蛋',16,NULL,NULL),(3,'凉拌葱花蛋',14,NULL,NULL),(4,'油炸花生米',14,NULL,NULL),(5,'湘味豆腐乳',16,NULL,NULL),(6,'凉拌海带丝',16,NULL,NULL),(7,'黑木耳',16,NULL,NULL),(8,'湘味萝卜条',12,NULL,NULL),(9,'拍黄瓜',14,NULL,NULL),(10,'湘味猪耳尖',28,NULL,NULL),(11,'皮蛋豆腐',14,NULL,NULL),(12,'香菜拌豆腐丝',16,NULL,NULL),(13,'酸辣厥根粉',16,NULL,NULL),(14,'凉拌卤牛肉',32,NULL,NULL),(15,'黄瓜蘸酱',18,NULL,NULL),(16,'麻辣土鸡爪',32,NULL,NULL),(17,'手剥笋',32,NULL,NULL),(18,'双色鱼头',68,NULL,NULL),(19,'剁椒鱼头',68,NULL,NULL),(20,'乡里土腊肉',58,NULL,NULL),(21,'湘味烤鱼',70,NULL,NULL),(22,'莴笋片（烤鱼拌菜）',10,NULL,NULL),(23,'藕片（烤鱼拌菜）',10,NULL,NULL),(24,'白豆腐（烤鱼拌菜）',8,NULL,NULL),(25,'金针菇（烤鱼拌菜）',10,NULL,NULL),(26,'土豆片（烤鱼拌菜）',10,NULL,NULL),(27,'红薯粉（烤鱼拌菜）',10,NULL,NULL),(28,'油麦菜（烤鱼拌菜）',8,NULL,NULL),(29,'苹果臭桂鱼',98,NULL,NULL),(30,'干锅去骨鸭掌',58,NULL,NULL),(31,'干锅黄鸭叫',58,NULL,NULL),(32,'干豆角红烧肉',58,NULL,NULL),(33,'湘味杀猪菜',56,NULL,NULL),(34,'脆椒坛香肉',58,NULL,NULL),(35,'香辣虾',59,NULL,NULL),(36,'青椒焖小河鱼',45,NULL,NULL),(37,'XXXXX',48,NULL,NULL),(38,'砂锅丸子',58,NULL,NULL),(39,'砂锅猪血',29,NULL,NULL),(40,'生态黄瓜',28,NULL,NULL),(41,'香酥排骨',78,NULL,NULL),(42,'小炒羊肚丝',48,NULL,NULL),(43,'尖椒油渣',30,NULL,NULL),(44,'烧鸡公',78,NULL,NULL),(45,'铁板牛肉',48,NULL,NULL),(46,'手抓羊排',68,NULL,NULL),(47,'青椒焖肚条',42,NULL,NULL),(48,'酸菜鱼',58,NULL,NULL),(49,'红烧草鱼',58,NULL,NULL),(50,'水煮草鱼',58,NULL,NULL),(51,'水煮胖头鱼',78,NULL,NULL),(52,'馋嘴过江鱼',62,NULL,NULL),(53,'干锅娃娃菜',26,NULL,NULL),(54,'干锅仔鸡',43,NULL,NULL),(55,'干锅莴笋腊肉',42,NULL,NULL),(56,'干锅牛蛙',52,NULL,NULL),(57,'干锅肥肠',48,NULL,NULL),(58,'干锅烟笋腊肉',48,NULL,NULL),(59,'五花肉杂菌锅仔',35,NULL,NULL),(60,'干锅茶树菇',42,NULL,NULL),(61,'干锅牛三宝',48,NULL,NULL),(62,'干锅鸡杂',45,NULL,NULL),(63,'干锅鱼杂',46,NULL,NULL),(64,'干锅腊肉香干',42,NULL,NULL),(65,'干锅千页豆腐',28,NULL,NULL),(66,'干锅土豆片',26,NULL,NULL),(67,'风味河蚌',34,NULL,NULL),(68,'酸菜藕节',28,NULL,NULL),(69,'什锦野菜',28,NULL,NULL),(70,'小炒黄牛肉',48,NULL,NULL),(71,'梅菜扣肉',45,NULL,NULL),(72,'腊味合蒸',42,NULL,NULL),(73,'红烧金猪蹄',48,NULL,NULL),(74,'小炒田螺',38,NULL,NULL),(75,'湘味小炒鸡',38,NULL,NULL),(76,'红烧茄子',28,NULL,NULL),(77,'干煸泥鳅',58,NULL,NULL),(78,'铁板鱿鱼须',42,NULL,NULL),(79,'酸辣猪蹄筋',38,NULL,NULL),(80,'铁板腰花',48,NULL,NULL),(81,'红烧鲫鱼',36,NULL,NULL),(82,'口味排骨',58,NULL,NULL),(83,'腊八豆炒荷包蛋',28,NULL,NULL),(84,'酱汁牛腩',42,NULL,NULL),(85,'酸豆角炒肉末',26,NULL,NULL),(86,'橄榄菜肉末四季豆',26,NULL,NULL),(87,'西芹百合',24,NULL,NULL),(88,'清蒸武昌鱼',48,NULL,NULL),(89,'红烧武昌鱼',42,NULL,NULL),(90,'腊肉荷兰豆',38,NULL,NULL),(91,'水煮肉片',38,NULL,NULL),(92,'水煮牛肉',48,NULL,NULL),(93,'砂锅木耳',26,NULL,NULL),(94,'湘味煎豆腐',24,NULL,NULL),(95,'铁板杏鲍菇',28,NULL,NULL),(96,'小炒肉皮',30,NULL,NULL),(97,'大盆莴笋片',28,NULL,NULL),(98,'大盆花菜',24,NULL,NULL),(99,'大盆长豆角',26,NULL,NULL),(100,'酸辣腰花',38,NULL,NULL),(101,'老干妈腰花',38,NULL,NULL),(102,'蚂蚁上树',25,NULL,NULL),(103,'紫苏煎黄瓜',22,NULL,NULL),(104,'小炒鹅肠',32,NULL,NULL),(105,'农家小炒肉',32,NULL,NULL),(106,'砂锅红薯粉丝',26,NULL,NULL),(107,'香辣牛蛙',48,NULL,NULL),(108,'铁板日本豆腐',26,NULL,NULL),(109,'湘西外婆菜',24,NULL,NULL),(110,'萝卜干腊肉',38,NULL,NULL),(111,'砂锅金针菇',28,NULL,NULL),(112,'五香拆骨肉',34,NULL,NULL),(113,'小炒脆骨',38,NULL,NULL),(114,'香菇油菜',24,NULL,NULL),(115,'韭菜炒鸡蛋',20,NULL,NULL),(116,'攸县香干',24,NULL,NULL),(117,'小炒猪肝',28,NULL,NULL),(118,'酸辣鸡胗',36,NULL,NULL),(119,'干煸四季豆',26,NULL,NULL),(120,'酸菜小笋肉沫',26,NULL,NULL),(121,'木耳溜淮山',24,NULL,NULL),(122,'芦蒿炒腊肉',38,NULL,NULL),(123,'萝卜丝牛肉',38,NULL,NULL),(124,'蒸水蛋',25,NULL,NULL),(125,'西红柿炒鸡蛋',20,NULL,NULL),(126,'虎皮尖椒',22,NULL,NULL),(127,'大盆藕条',28,NULL,NULL),(128,'上汤娃娃菜',28,NULL,NULL),(129,'清炒土豆丝（酸辣，老干妈）',18,NULL,NULL),(130,'松仁玉米',24,NULL,NULL),(131,'湘味小河虾',38,NULL,NULL),(132,'苦瓜炒鸡蛋',20,NULL,NULL),(133,'手撕包菜',18,NULL,NULL),(134,'干锅手撕包菜',20,NULL,NULL),(135,'长豆角茄子',24,NULL,NULL),(136,'空心菜（清炒，蒜蓉）',20,NULL,NULL),(137,'小白菜（清炒，蒜蓉）',20,NULL,NULL),(138,'丝瓜（清炒，蒜蓉）',24,NULL,NULL),(139,'油麦菜（清炒，蒜蓉）',20,NULL,NULL),(140,'苦瓜（清炒，蒜蓉）',20,NULL,NULL),(141,'怀山炖土鸡',78,NULL,NULL),(142,'玉米排骨汤',42,NULL,NULL),(143,'海带排骨汤',38,NULL,NULL),(144,'银丝鲫鱼汤',42,NULL,NULL),(145,'白菜豆腐汤',20,NULL,NULL),(146,'冬瓜排骨汤',30,NULL,NULL),(147,'西湖牛肉羹',26,NULL,NULL),(148,'西红柿鸡蛋汤',20,NULL,NULL),(149,'紫菜蛋花汤',20,NULL,NULL),(150,'狗肉火锅',99,NULL,NULL),(151,'鱼杂火锅',98,NULL,NULL),(152,'鸡火锅',98,NULL,NULL),(153,'牛腩火锅',99,NULL,NULL),(154,'炒河粉',16,NULL,NULL),(155,'米饭',2,NULL,NULL),(156,'香芋地瓜丸',16,NULL,NULL),(157,'金银小馒头',16,NULL,NULL),(158,'外婆菜窝窝头',26,NULL,NULL),(159,'蛋炒饭',16,NULL,NULL),(160,'扬州炒饭',16,NULL,NULL),(161,'酱油炒饭',16,NULL,NULL),(162,'南瓜饼',16,NULL,NULL);

#
# Source for table "userinfo"
#

DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL DEFAULT '0' COMMENT '0是普通，1是管理员',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "userinfo"
#

INSERT INTO `userinfo` VALUES (1,'sucg','sucg',1);

#
# Source for table "orderinfo"
#

DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT '',
  `date` datetime DEFAULT '0000-00-00 00:00:00',
  `menuid` int(11) DEFAULT NULL,
  `userinfoid` int(11) DEFAULT NULL,
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '0是未提交，1为提交',
  `number` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`Id`),
  KEY `menuid` (`menuid`),
  KEY `userinfoid` (`userinfoid`),
  CONSTRAINT `orderinfo_ibfk_1` FOREIGN KEY (`menuid`) REFERENCES `menu` (`Id`),
  CONSTRAINT `orderinfo_ibfk_2` FOREIGN KEY (`userinfoid`) REFERENCES `userinfo` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

#
# Data for table "orderinfo"
#

INSERT INTO `orderinfo` VALUES (42,NULL,NULL,141,NULL,0,0),(43,NULL,NULL,135,NULL,0,0),(44,NULL,NULL,105,NULL,0,0),(45,NULL,NULL,98,NULL,0,0),(46,NULL,NULL,102,NULL,0,0),(47,NULL,NULL,129,NULL,0,0),(48,NULL,NULL,50,NULL,0,0),(49,NULL,NULL,66,NULL,0,0),(50,NULL,NULL,95,NULL,0,0),(51,NULL,NULL,87,NULL,0,0),(52,NULL,NULL,90,NULL,0,0);

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
