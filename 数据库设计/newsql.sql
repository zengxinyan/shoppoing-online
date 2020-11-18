/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.21-log : Database - springboot_demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springboot_demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springboot_demo`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_2` (`user_id`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

insert  into `cart`(`id`,`user_id`,`quantity`,`total`) values (14,16,0,'0.00'),(15,17,3,'8857.00');

/*Table structure for table `cart_goods` */

DROP TABLE IF EXISTS `cart_goods`;

CREATE TABLE `cart_goods` (
  `cart_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`cart_id`,`goods_id`),
  KEY `FK_Relationship_7` (`goods_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cart_goods` */

insert  into `cart_goods`(`cart_id`,`goods_id`,`quantity`) values (15,1,2),(15,23,1);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`name`,`description`) values (1,'手机/数码','妳微笑浏览，手机里的浪漫。'),(2,'男装','选套西装去塞纳河畔品尝她的美。'),(3,'女装','都市丽人，他只喜欢阅读你微醺时的眼神。'),(4,'珠宝/美妆','做一个让人心疼的可爱男/女人。'),(5,'美食/生鲜','鸡蛋糕跟你嘴角果酱我都想要尝。'),(6,'运动/鞋靴','长大后就能跑得比别人快飞得比别人高。'),(7,'历史/人文书籍','翻阅古巴比伦王颁布的汉谟拉比法典。'),(8,'汽车/用品','不会有人要挑战秋名山车神吧？');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `no` decimal(20,0) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `disprice` decimal(10,2) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `onsale` int(11) DEFAULT NULL,
  `sold` int(11) DEFAULT NULL,
  `isHot` tinyint(1) DEFAULT NULL,
  `isDiscount` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_11` (`category_id`),
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`category_id`,`no`,`name`,`price`,`disprice`,`description`,`image`,`onsale`,`sold`,`isHot`,`isDiscount`) values (1,1,'10001','华为P40 5G','4299.00','4299.00','国货之光！自主研发芯片！','img/1/p40.png',56,643,1,0),(2,1,'10002','荣耀V20','2099.00','2100.00','4800万AI超清摄影','img/1/v20.png',31,422,0,1),(3,1,'10003','荣耀8X','1199.00','1299.00','千元屏霸/屏占比达91%','img/1/8x.png',244,456,0,1),(4,1,'10004','Redmi K30','1899.00','1999.00','120Hz流速屏 骁龙730G','img/1/k30.png',642,454,0,1),(5,1,'10005','OPPO R17','2499.00','2899.00','雾光金上市 最高12期免息','img/1/r17.png',543,933,0,1),(6,1,'10006','iPhone 8P','3699.00','3799.00','苹果过去10年的最强总结','img/1/8p.png',865,833,0,1),(7,1,'10007','iPhone XR','3899.00','3899.00','价格越低边框越窄','img/1/xr.png',57,932,0,0),(8,1,'10008','魅族16X','1598.00','1598.00','一流视听效果','img/1/16x.png',756,827,0,0),(10,2,'20001','puma外套','189.00','189.00','皮肤衣户外超薄防晒','img/2/2_1.png',75,825,0,0),(11,2,'20002','复古外套','218.00','225.00','危机青年M51复古军事风','img/2/2_2.png',534,912,0,1),(12,2,'20003','男道T恤 ','128.00','135.00','夏季新款日系简约印花','img/2/2_3.png',12,112,0,1),(13,2,'20004','PULL&BEAR短袖','89.00','89.00','多色米老鼠插图 ','img/2/2_4.png',54,513,1,0),(14,2,'20005','优衣库T恤  ','99.00','101.00','withpokemon印花T恤','img/2/2_5.png',92,245,1,1),(15,2,'20006','massimodutti男装','199.00','219.00','线下同款滚边接缝领口','img/2/2_6.png',27,124,0,1),(16,2,'20007','HM短裤','98.00','98.00','2020新款宽松直筒潮流','img/2/2_7.png',18,1455,1,0),(17,2,'20008','LEZORA五分裤','159.00','159.00','日本宅款面料休闲五分裤','img/2/2_8.png',64,117,0,0),(18,2,'20009','ZARA休闲裤','198.00','198.00','夏季薄款府绸束脚慢跑休闲','img/2/2_9.png',865,1236,1,0),(19,2,'20010','迪卡侬运动裤','149.00','159.00','男士春夏大健身跑步紧身瑜伽训练','img/2/2_10.png',25,321,1,1),(20,3,'30001','无印良品T恤','159.00','189.00','网络限定印度棉天竺编织','img/3/3_1.png',543,865,0,1),(21,3,'30002','PULL&BEAR短袖 ','89.00','89.00','印花夏季新款可爱休闲','img/3/3_2.png',765,616,1,0),(22,3,'30003','MissSixty短袖','319.00','330.00','夏季纯棉钉珠宽松圆袖','img/3/3_3.png',63,116,1,1),(23,3,'30004','PeaceBird短袖 ','259.00','259.00','米奇联名款绿色亲肤','img/3/3_4.png',65,629,1,0),(24,3,'30005','Dazzle短袖 ','498.00','510.00','夏季新款LOGO字母纯棉 ','img/3/3_5.png',246,726,1,1),(25,3,'30006','嘉汇短裤','59.00','59.00','牛仔宽松黑色高腰显瘦破洞阔腿','img/3/3_6.png',765,432,1,0),(26,3,'30007','Zara短裤','199.00','199.00','新装女款高腰短裤','img/3/3_7.png',964,222,1,0),(27,3,'30008','VeroModa连体裤','248.00','259.00','2020夏季新款镂空一字领休闲','img/3/3_8.png',255,888,0,1),(28,3,'30009','FivePlus短裤','290.00','345.00','新款女夏装高腰牛仔休闲','img/3/3_9.png',432,777,0,1),(29,3,'30010','Burberry短裤','288.00','452.00','20ss经典格纹松紧腰宽松休闲','img/3/3_10.png',854,774,0,1),(30,4,'40001','周大福吊坠','569.00','599.00','海星足金吊坠甄选','img/4/4_1.png',707,883,0,1),(31,4,'40002','周大福珠宝','688.00','688.00','车花路路通转运珠铂金吊坠','img/4/4_2.png',645,448,1,0),(32,4,'40003','屈臣氏化妆棉','50.00','50.00','软柔亲肤棉絮不残留','img/4/4_3.png',726,554,1,0),(33,4,'40004','品佳人面膜','129.00','129.00','正品补水保湿提亮肤色小灯泡','img/4/4_4.png',946,724,1,0),(34,4,'40005','IRY祛痘套装','289.00','300.00','控油祛粉刺痘痘淡化护肤套装','img/4/4_5.png',40,568,1,1),(35,4,'40006','百雀羚护肤','169.00','169.00','肌初赋活套装补水紧致抗衰老','img/4/4_6.png',52,822,0,0),(36,4,'40007','丸美套装 ','118.00','120.00','正品白色之恋补水美白淡斑','img/4/4_7.png',70,833,1,1),(37,4,'40008','HHA系列 ','267.00','300.00','护肤套装蜂浆卸妆洁面补水','img/4/4_8.png',60,338,1,1),(38,4,'40009','瑷尔博士套装','160.00','160.00','益生菌水乳熬夜修补','img/4/4_9.png',599,555,1,0),(39,4,'40010','爱莉精华','240.00','255.00','祛痘去淡化痘印修护精华','img/4/4_10.png',771,335,0,1),(41,5,'50001','澳洲带牛排','108.00','108.00','整块牛排，至尊享受','img/5/5_1.png',249,531,0,0),(42,5,'50002','澳洲谷饲牛仔骨','118.00','118.00','澳洲牛肉，世界顶级 ','img/5/5_2.png',1457,654,0,0),(43,5,'50003','带骨羊排肉','88.00','100.00','带骨大羊排，谁烤谁知道','img/5/5_3.png',111,2368,1,1),(44,5,'50004','肥美大虾','129.00','200.00','鲜嫩多汁，满嘴享受','img/5/5_4.png',231,693,1,1),(45,5,'50005','三文鱼','116.00','116.00','香甜可口，初恋般的味道','img/5/5_5.png',328,1245,1,0),(46,5,'50006','西伯利亚大扇贝','209.00','300.00','冷峻的美人，扇贝中的女王','img/5/5_6.png',379,1315,0,1),(47,5,'50007','小龙坎火锅底料','28.00','28.00','平淡生活中的一点激情','img/5/5_7.png',421,5131,1,0),(48,5,'50008','性感带鲍鱼','56.00','56.00','怎么吃都好吃','img/5/5_8.png',970,124,1,0),(49,5,'50009','阳澄湖大闸蟹','78.00','98.00','满满的蟹黄，暖暖的爱意','img/5/5_9.png',809,2437,1,1),(50,5,'50010','整只生鸡','37.00','39.00','完整的它，幸福大家','img/5/5_10.png',987,251,1,1),(51,6,'60001','newbalance运动鞋','299.00','400.00','很NB的鞋','img/6/6_1.png',658,212,0,1),(52,6,'60002','vans高帮','415.00','520.00','帅就VANS咯','img/6/6_2.png',589,1111,0,1),(53,6,'60003','nike_air_max','699.00','699.00','专为运动而生','img/6/6_3.png',598,2257,0,0),(54,6,'60004','aj','1299.00','1299.00','男人的浪漫','img/6/6_4.png',583,2689,1,0),(55,6,'60005','adidas','999.00','999.00','谁穿了都说好','img/6/6_5.png',259,424,0,0),(56,6,'60006','三叶草','899.00','899.00','贝壳头，永远滴神！','img/6/6_6.png',629,420,1,0),(57,6,'60007','特步','178.00','200.00','爱跑步，爱特步','img/6/6_7.png',527,5439,1,1),(58,6,'60008','安踏','167.00','392.00','踏出你的第一步','img/6/6_8.png',825,54,1,1),(59,6,'60009','李宁','219.00','219.00','国货之光！','img/6/6_9.png',541,764,0,0),(60,6,'60010','阿迪王','888.00','888.00','一切皆可改变','img/6/6_10.png',81,789,0,0),(61,7,'70001','失落的文明','56.00','56.00','欧洲史人文自然百科全书','img/7/7_1.png',784,994,0,0),(62,7,'70002','中国国家地理','25.00','39.00','一本书带你游览全中国','img/7/7_2.png',874,996,0,1),(63,7,'70003','论语','29.00','67.00','有朋自远方来，不亦说乎？','img/7/7_3.png',192,455,0,1),(64,7,'70004','汉朝那些事','109.00','109.00','中国史汉朝历史书','img/7/7_4.png',191,6542,1,0),(65,7,'70005','三国演义','49.00','49.00','东汉末年分三国~','img/7/7_5.png',4211,547,1,0),(66,7,'70006','西游记','49.00','49.00','开花','img/7/7_6.png',267,467,1,0),(67,7,'70007','红楼梦','49.00','58.00','白骨如山忘姓氏，无非公子与红妆。','img/7/7_7.png',222,266,1,1),(68,7,'70008','水浒传','49.00','49.00','105个男人和3个女人的故事','img/7/7_8.png',683,976,0,0),(69,7,'70009','全球通史','68.00','100.00','带你知晓天下事','img/7/7_9.png',324,666,1,1),(70,7,'70010','人类简史','69.00','69.00','跨越时间与空间的人类史','img/7/7_10.png',266,906,1,0),(71,8,'80001','真皮座椅','210.00','268.00','不会有人不喜欢真皮座椅吧','img/8/8_1.png',399,63,0,1),(73,8,'80002','车刷','19.00','19.00','谁家的车又不会脏呢','img/8/8_2.png',477,1235,1,0),(74,8,'80003','护颈靠枕','27.00','37.00','细微的呵护，最真的爱','img/8/8_3.png',544,7654,1,1),(75,8,'80004','方向盘套','12.00','12.00','暖暖的，很贴心','img/8/8_4.png',368,7923,0,0),(76,8,'80005','后视镜吊坠','13.00','18.00','简单的祝福，浓浓的爱','img/8/8_5.png',128,4377,1,1),(77,8,'80006','临时停车电话号码牌','31.00','45.00','avengers assemble!','img/8/8_6.png',328,6423,0,1),(78,8,'80007','玻璃水','65.00','65.00','洗净你前进的道路','img/8/8_7.png',2222,2666,1,0),(79,8,'80008','蝙蝠侠车贴','9.00','16.00','贴上它你也能拥有钞能力','img/8/8_8.png',268,9754,1,1),(80,8,'80009','雨刮器','15.00','22.00','没有不下的雨，只有摇坏的雨刮器','img/8/8_9.png',774,555,1,1);

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(1000) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `message` */

insert  into `message`(`id`,`msg`,`date`) values (1,'华为 p405G手机降价啦！','2020-06-14'),(2,'新上架优衣库T恤！','2020-06-02'),(3,'全场商品包邮！！！','2020-06-20');

/*Table structure for table `ordered` */

DROP TABLE IF EXISTS `ordered`;

CREATE TABLE `ordered` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `receive_id` int(11) DEFAULT NULL,
  `no` decimal(20,0) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `orderDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_3` (`user_id`),
  KEY `FK_Relationship_9` (`receive_id`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`receive_id`) REFERENCES `receive` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=273 DEFAULT CHARSET=utf8;

/*Data for the table `ordered` */

insert  into `ordered`(`id`,`user_id`,`receive_id`,`no`,`total`,`status`,`orderDate`) values (268,17,NULL,NULL,'259.00','待付款','2020-06-26 21:47:36'),(269,16,NULL,NULL,'17070.00','待付款','2020-06-28 13:44:05'),(270,16,86,NULL,'89.00','待付款','2020-06-28 13:46:03'),(271,16,87,NULL,'130.00','待付款','2020-06-28 14:18:34'),(272,16,86,NULL,'17070.00','待付款','2020-06-28 14:24:36');

/*Table structure for table `ordered_goods` */

DROP TABLE IF EXISTS `ordered_goods`;

CREATE TABLE `ordered_goods` (
  `ordered_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`ordered_id`,`goods_id`),
  KEY `FK_Relationship_5` (`goods_id`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`ordered_id`) REFERENCES `ordered` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ordered_goods` */

insert  into `ordered_goods`(`ordered_id`,`goods_id`,`quantity`) values (268,23,1),(269,30,2),(270,21,1),(271,78,2),(272,30,4);

/*Table structure for table `receive` */

DROP TABLE IF EXISTS `receive`;

CREATE TABLE `receive` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `ordered_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_10` (`ordered_id`),
  KEY `FK_Relationship_8` (`user_id`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`ordered_id`) REFERENCES `ordered` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

/*Data for the table `receive` */

insert  into `receive`(`id`,`user_id`,`ordered_id`,`name`,`phone`,`address`) values (86,16,NULL,'曾鑫沿','112','四川成都'),(87,16,NULL,'曾鑫沿','111','双流大学');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_id` int(11) DEFAULT NULL,
  `loginname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `image` varchar(100) DEFAULT 'img/zxy.jpg',
  `secret` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_1` (`cart_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`cart_id`,`loginname`,`password`,`name`,`sex`,`birthday`,`email`,`phone`,`image`,`secret`,`answer`) values (16,14,'zxy','1','zxy','男','1998-01-01','1243332','11234','img/zxy.jpg',NULL,NULL),(17,15,'zzz','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
