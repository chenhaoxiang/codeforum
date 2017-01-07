/*
SQLyog Ultimate v8.32 
MySQL - 5.7.14 : Database - codeforum
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`codeforum` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `codeforum`;

/*Table structure for table `infotable` */

DROP TABLE IF EXISTS `infotable`;

CREATE TABLE `infotable` (
  `id` varchar(32) NOT NULL COMMENT '唯一帖子标识码',
  `title` varchar(100) NOT NULL COMMENT '帖子标题',
  `readnum` bigint(20) NOT NULL COMMENT '阅读量',
  `TIME` bigint(20) NOT NULL COMMENT '发帖时间',
  `message` varchar(4000) NOT NULL COMMENT '帖子正文',
  `userid` varchar(32) NOT NULL COMMENT '用户id-发表人',
  PRIMARY KEY (`id`),
  KEY `info_userId` (`userid`),
  CONSTRAINT `info_userId` FOREIGN KEY (`userid`) REFERENCES `usertable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `infotable` */

insert  into `infotable`(`id`,`title`,`readnum`,`TIME`,`message`,`userid`) values ('1','第一篇帖子啊',641,1483441822725,'经查，夏兴华身为党的高级领导干部，纪律意识淡薄，违反中央八项规定精神，借出差之机旅游，违规打高尔夫球并由他人支付费用；违反组织纪律，不按规定报告个人有关事项，在组织函询时不如实说明问题；违反廉洁纪律，收受礼金，由下属单位和他人支付应当由个人支付的费用，明显低于市场价购买住房，谋取私利。依据《中国共产党纪律处分条例》的有关规定，经中央纪委常委会议审议并报中共中央批准，决定给予夏兴华开除党籍处分，按主任科员确定退休待遇。','1'),('2','第二篇帖子开始',481,1483441939800,'卢淳杰身为党员领导干部，理想信念丧失，严重违反党的纪律，且在党的十八大后仍不收敛、不收手，性质恶劣、情节严重。依据《中国共产党纪律处分条例》等有关规定，经省纪委常委会议审议并报省委批准，决定给予卢淳杰开除党籍处分;经省监察厅报省政府批准，决定给予其开除公职处分;收缴其违纪所得;将其涉嫌犯罪问题、线索及所涉款物移送司法机关依法处理。(广东省纪委)','1'),('3','2016年正风反腐新成就盘点:用好监督执纪“四种形态',464,1483441988658,'中央纪委数据显示，2016年已办结的77件中管干部违纪案件中，按第二和第三种形态处理的案件57件，占74%，比2015年增长90%;按第四种形态处理的案件20件，占26%，比2015年减少56.5%。“一升一降”，反映出按照“四种形态”要求，案件处理出现结构性变化。\r\n1月至11月，中央纪委处置反映中管干部问题线索中，谈话函询1305件次，比2015年同期增长96.5%。全国纪检监察机关谈话函询11.1万件次，比2015年同期增长205.8%。\r\n把纪律挺在前面，也让一些有问题的干部放下包袱。仅2016年上半年全国就有2.9万名干部主动向纪检监察机关交代问题，是2015年全年的5倍多。\r\n执纪理念不断转变:防微杜渐，把违反纪律作为审查重点\r\n从纪检监察机关工作的实际看，当前党员干部违反政治纪律的情形较为突出。有的领导干部理想信念动摇、阳奉阴违，做“两面人”;有的严重违反政治纪律，搞结党营私、团团伙伙、拉帮结派、谋取权位等政治阴谋活动;有的不相信组织，反而相信“小圈子”，相信社会上的“能人”，甚至“不信马列信鬼神”，请风水先生、江湖术士出谋划策，对抗组织审查。','2'),('4','探访四川彭山张献忠江口沉银遗址 彩钢打围安保严密',5647,1483442041415,'尽管是元旦假期，考古现场出入处均有保安值守，严防人员进入考古现场。据观察，江口沉银遗址岷江岸边的公路边张贴有多张施工通告，在挂有“江口崖墓”的入口处写有提示“考古工地预约参观”。','3'),('5','康师傅不卖方便面了”：为什么台湾人很开心？',34631,1483442131004,'甚至连富士康母公司鸿海集团也曾发布公告，将顶新集团旗下相关产品全面预防性下架，全面抵制顶新集团旗下的康师傅以及德克士炸鸡等产品。顶新魏家四兄弟中的老二魏应交曾说“我做的产品可以双手奉给我父母吃”，但魏家厨房用的却是进口橄榄油。2017年1月1日，一条“台湾康师傅解散”的消息，吓坏了不少大陆小伙伴，从小吃到大的方便面就这么没了？\r\nNO!NO!NO!彼康师傅，非此康师傅，大陆康师傅经营一切正常！\r\n据了解，台湾顶新国际集团旗下的知名品牌有：康师傅、德克士、味全、全家FamilyMart等。\r\n而这次出事的是“台湾康师傅”，为“康师傅控股”子公司，经营范围仅限台湾地区。\r\n因此，大陆业务营运不受影响！这也意味着：在大陆，你还能吃到康师傅方便面！','1'),('6','第六篇',466,1483442161739,'狄路平','2'),('7269674eab244559b194ce6c400914ad','哈哈，来试试发表文章+++',3,1483790885828,'嘿嘿，听说正文需要15个字啊，15字啊，15字。\n不知道有米有15个字了，应该差不多了吧。','1');

/*Table structure for table `replytable` */

DROP TABLE IF EXISTS `replytable`;

CREATE TABLE `replytable` (
  `id` varchar(32) NOT NULL COMMENT '唯一回复标识码',
  `TIME` bigint(18) NOT NULL COMMENT '回复时间',
  `message` varchar(4000) NOT NULL COMMENT '回复正文',
  `infoid` varchar(32) NOT NULL COMMENT '所属帖子id',
  `ip` varchar(32) NOT NULL COMMENT '回复者发表时ip',
  `userid` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `replyId_infoId` (`infoid`),
  KEY `FK_replytable` (`userid`),
  CONSTRAINT `FK_replytable` FOREIGN KEY (`userid`) REFERENCES `usertable` (`id`),
  CONSTRAINT `replyId_infoId` FOREIGN KEY (`infoid`) REFERENCES `infotable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `replytable` */

insert  into `replytable`(`id`,`TIME`,`message`,`infoid`,`ip`,`userid`) values ('2e5056e24c05453f9389e5b1b0cdf3e8',1483793366333,'哈哈','1','127.0.0.1','3'),('3ca0cd408e6d48edae3bf1b901cee025',1483793351389,'必须赞啊','1','127.0.0.1','3'),('54ef3d78cdd347e98a4a26ddb27e156e',1483793347094,'赞','1','127.0.0.1','3'),('6803ca2a17204fb5b2f364ab39dc4bf0',1483777815355,'赞','5','127.0.0.1','3'),('8678b3d1b3be4afd9aff879adfa57839',1483793359712,'评论','1','127.0.0.1','3'),('8a5dff65e4eb497485ca9e56d855fb23',1483793355936,'来一个','1','127.0.0.1','3'),('9b0701fb86df4e97ba591dcd590fc6d0',1483793382198,'加1','1','127.0.0.1','3'),('a92e37ead25843cda26eec0c9f32b31b',1483793341584,'好文章','1','127.0.0.1','3'),('ab51e3630cc24dcd85aa310abf93c6e6',1483777850682,'哈哈，好文章啊','5','127.0.0.1','3');

/*Table structure for table `usertable` */

DROP TABLE IF EXISTS `usertable`;

CREATE TABLE `usertable` (
  `id` varchar(32) NOT NULL COMMENT '用户唯一标识码',
  `NAME` varchar(32) NOT NULL COMMENT '昵称',
  `sex` varchar(32) NOT NULL COMMENT '性别',
  `age` varchar(32) NOT NULL COMMENT '年龄',
  `profession` varchar(32) NOT NULL COMMENT '职业',
  `love` varchar(32) NOT NULL COMMENT '爱好',
  `PASSWORD` varchar(32) NOT NULL COMMENT '密码',
  `ip` varchar(32) NOT NULL COMMENT '当前登录的IP',
  `integral` bigint(20) NOT NULL COMMENT '积分--注册时默认为10，发帖一次+10，回复一次+2',
  `TYPE` char(1) NOT NULL COMMENT '用户类型-默认注册时为1：1-普通用户，0-管理员',
  `solt` varchar(32) NOT NULL COMMENT '盐',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usertable` */

insert  into `usertable`(`id`,`NAME`,`sex`,`age`,`profession`,`love`,`PASSWORD`,`ip`,`integral`,`TYPE`,`solt`) values ('1','chx','1','23','学生','编程','8591bfa530427dec20b1992c63322830','127.0.0.1',10100,'1','chx'),('2','a','0','24','老师','教学','21b0304492b4e80831d66abd78514f29','127.0.0.1',500,'0','a'),('3','admin','1','43','管理','飞行','ceb4f32325eda6142bd65215f4c0f371','127.0.0.1',700,'1','admin'),('e83948f98baa44159dd2f22c09608964','陈浩翔','1','32','学生','打球','8e14ec746aa12235397236144c6f6d44','127.0.0.1',10,'0','a74e2ac5be5b4e979b0867518092b195');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
