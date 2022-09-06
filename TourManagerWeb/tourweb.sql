CREATE DATABASE  IF NOT EXISTS `tourweb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tourweb`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: tourweb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `bookingid` int NOT NULL AUTO_INCREMENT,
  `tourid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  `numberofadult` int DEFAULT NULL,
  `numberofchild` int DEFAULT NULL,
  `totalprice` decimal(10,0) DEFAULT NULL,
  `bookingdate` date DEFAULT NULL,
  PRIMARY KEY (`bookingid`),
  UNIQUE KEY `bookingid_UNIQUE` (`bookingid`),
  KEY `userid_idx` (`userid`),
  KEY `touriddd_idx` (`tourid`),
  CONSTRAINT `touriddd` FOREIGN KEY (`tourid`) REFERENCES `tour` (`tourid`),
  CONSTRAINT `useriddd` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,1,3,1,1,NULL,'2022-05-05'),(2,2,6,0,2,NULL,'2022-01-01'),(3,4,5,3,4,NULL,'2022-01-01'),(4,7,5,2,0,NULL,'2022-01-08'),(5,10,5,5,0,NULL,'2022-02-05'),(7,4,5,2,1,NULL,'2022-08-18'),(9,19,5,6,5,NULL,'2022-09-04');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `newsid` int NOT NULL AUTO_INCREMENT,
  `newsname` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `content` longtext COLLATE utf8_bin,
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`newsid`),
  UNIQUE KEY `newsid_UNIQUE` (`newsid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'Đà Lạt ở đâu? Có gì thú vị để trải nghiệm?','Đà Lạt 2022 là thành phố du lịch được mọi người yêu thích nhất ở Việt Nam. Cùng Hoa Dalat Travel tìm hiểu vì sao thành phố xinh đẹp này lại được mọi người quý mến như vậy.  Sau thời gian dài vắng khách vì dịch Covid-19 hiện nay Đà Lạt đã đông đúc trở lại. Tranh thủ đi đến thành phố ngàn hoa ngay nào mọi người. Đọc ngay bài viết Kinh nghiệm du lịch Đà Lạt để biết bạn cần những giấy tờ gì khi đến Đà Lạt vào dịp này.  Trong tháng 8/2022 Đà Lạt đã tràn ngập các loài hoa nở rộ đang rất đẹp để chờ bạn check-in.','https://res.cloudinary.com/dwjwe95at/image/upload/v1662009200/ntup5kpjhsybzzty3vpj.jpg'),(2,'Đà Lạt ở đâu? Có gì thú vị để trải nghiệm?','Vị trí địa lý:\r\n Thành Phố Đà Lạt cách thành phố Biên Hòa của tỉnh Đồng Nai với chiều dài khoảng 278km. Cách thủ đô Hà Nội ngàn năm văn hiến 1.481km và cách Thành phố mang tên Bác 293km, Nha Trang thành phố biển tỉnh Khánh Hòa 205km.\r\n\r\nNếu các bạn đi đường đèo mới với chiều dài hơn 100km thì chỉ mất khoảng hơn 3 giờ để tới thành phố Nha Trang xinh đẹp.\r\n\r\nĐà Lạt\r\nTrung Tâm Đà Lạt\r\n\r\nĐường đi\r\nĐà Lạt hiện nay có các chuyến bay mỗi ngày đi đến Tp. Hồ Chí Minh, Vinh, thành phố Đà Nẵng, Hà Nội và ngược lại. Tỉnh Lâm Đồng có tuyến đường bộ chính là quốc lộ 20 chạy xuyên qua tỉnh từ Đà Lạt, Bảo Lộc, Di Linh, Ma Đa Gui tới Đồng Nai.\r\n\r\nNgoài ra tỉnh Lâm Đồng còn nằm trên trục đường quốc lộ 27 gồm có các tỉnh và thành phố như Tp.Phan Rang Tháp Chàm (Ninh Thuận) – Lâm Đồng – Đắk Lắk (Buôn Ma Thuột), trục đường 28: Bình Thuận – Lâm Đồng (Di Linh) – Đắk Nông.\r\n\r\nĐà Lạt về đêm\r\nĐà Lạt về đêm\r\n\r\nTừ Tp. Hồ Chí Minh, nếu bạn đi ô tô theo quốc lộ 20 chừng 300km khoảng 8 tiếng đồng hồ là đến trung tâm Đà Lạt. Trong một vài năm tới khi các tuyến đường cao tốc hoàn thiện thì thời gian du lịch Đà Lạt sẽ được rút ngắn rất nhiều.\r\n\r\nNgoài ra bạn có thể đi đường 27 để đi từ Phan Rang ngược đèo Dran lên thành phố mộng mơ. Đây là một cung đường được dân phượt đặc biệt yêu thích.\r\n\r\n\r\n2. Nguồn gốc tên gọi Đà Lạt\r\nVào những năm cuối thế kỉ thứ 19, có một vị bác sĩ người Thuỵ Sĩ mang quốc tịch Pháp là Alexandre Yersin. Ông được lệnh của người Pháp khi đó là tìm một nơi để người Pháp nghỉ dưỡng.\r\n\r\nVà Tây Nguyên là nơi được chọn vì có khí hậu gần giống với nước Pháp. Sau đó ông đã đến Lang Biang để rồi dẫn đến việc khai sinh thành phố festival hoa hôm nay.\r\n\r\nQuảng trường thành phố Đà Lạt\r\nQuảng trường thành phố Đà Lạt\r\n\r\nThời gian tìm thấy:\r\nNgày 21/06/1893 lúc 15h30 sau hàng loạt các cuộc khám phá khu vực Đông Nam Bộ. Bác sĩ Yersin đã đi lên tới khu vực núi đỉnh Lanbiang hiện nay. Chính nhờ vào phát hiện vô cùng quan trọng của ông đã làm thay đổi lịch sử của toàn bộ khu vực này.\r\n\r\nThành Phố Đà Lạt\r\nChân dung Bác sĩ Yersin người tìm ra Đà Lạt\r\n\r\nTên gọi:\r\nTên gọi Đà Lạt ngày nay từ khi phát sinh cũng vô cùng ngẫu nhiên, có sự trùng âm trúng ý khiến nhiều người trong và nước thắc mắc bàn luận. Có người cho rằng những người Pháp là “sáng lập viên” đã chọn cho thành phố xinh đẹp này.\r\n\r\nMột câu châm ngôn đầy ý nghĩa như các thành phố Châu Âu bắng tiếng Latinh “DAT ALLIIS LAETITIUM ALLIIS TEMPERRIEM”. Năm chữ đầu ghép lại thành từ Đà Lạt có nghĩa là ” cho người này niềm vui cho người kia sự mát lành “.\r\n\r\nThế nhưng theo nhiều nhà nghiên cứu dân tộc học Việt Nam thì không phải vậy. Mà tên Đà Lạt có từ gốc là đạ Lạch phát âm theo tiếng của người Lạch. Đây là một trong 3 chi phái thuộc hệ K’ho cùng chia nhau sống tại các vùng phía Bắc tỉnh Lâm Đồng.\r\n\r\nTheo ngôn ngữ K’ho, Đa, Đạ hay Đăk cónghĩa là nước, là sông, là suối; Lạch( Lạt) là tên bộ tộc của dân tộc K’ho. Như vậy Đà Lạch là con suối của người Lạch.\r\n\r\nTrong hơn 100 năm qua thành phố sương mù này mang nhiều cách hiểu và nhiều ý nghĩa khác nhau. Nhưng ngày nay, chúng ta trả lại ý nghĩa ban đầu cho Đà Lạt. Đó là con suối người Lạch, là quê hương của người Lạch và người Lạch một thành viên trong đại gia đình các dân tộc Việt Nam.\r\n\r\nĐà Lạt\r\nĐà Lạt luôn được sương mù bao phủ\r\n\r\n3. Tham quan Đà Lạt\r\nĐà Lạt – Thiên đường sống ảo cực chất quanh năm muôn hoa đua nở khí hậu mát mẻ tràn ngập cả phố hoa. Thành phố Đà Lạt không chỉ là nơi bình yên nghỉ dưỡng tham quan nổi tiếng. Mà còn là những trải nghiệm đầy sắc màu tươi sáng và ngày càng đổi mới. Nhờ đó mà người người đã nghĩ ra được nhiều cảm hứng sáng tạo mới mẻ một số địa điểm cực chất cũng từ đó mà ra đời.\r\n\r\nKhách đến Đà Lạt vừa được thăm viếng các cảnh đẹp, lại vừa thưởng thức những món đặc sản ngon. Bao gồm nhiều loại trái cây: hồng, mận, đào, bơ; nhiều món ăn dân tộc độc đáo và các hàng lưu niệm của riêng vùng cao nguyên này. \r\n\r\nCác loài hoa đẹp\r\nVẻ đẹp của Đà Lạt còn được ngợi ca nhiều và hấp dẫn du khách. Bởi hàng trăm, ngàn loại hoa, loại phong lan độc đáo. Hoặc được sản sinh riêng trên mảnh đất này.\r\n\r\nHoặc lấy giống từ nhiều nơi như: Pháp, Anh, Hà Lan, Nhật Bản, Đài Loan, Hồng Kông, Ấn Độ, Italy,…như hoa hồng, hoa bất tử, hoa đỗ quyên, hoa xác pháo, hoa tư tưởng, hoa trà mi, mi mô da, thủy tiên trắng…\r\n\r\nThành Phố Đà Lạt\r\nChợ Đà Lạt\r\n\r\nKhách sạn Đà Lạt\r\nHotel đầu tiên ở Đà Lạt được xây dựng từ năm 1907. Đó là ngôi nhà gỗ mang tên khách sạn Hồ (Hotel du Lac). Ngày nay, đến nghỉ dưỡng du khách sẽ cảm nhận có một nét kiến trúc rất nên thơ, lộng lẫy. Mà kín đáo qua những ngôi biệt thự ẩn mình trong cây lá hoặc rực rỡ bởi được phủ lên cả một rừng hoa. Chi tiết ở đây.\r\n\r\nHiện giờ có hàng ngàn khách sạn Đà Lạt đẹp mới được xây dựng. Để phục vụ nhu cầu tham quan thành phố ngàn hoa ngày càng nhiều.\r\n\r\nBạn có thể tham khảo như:\r\n\r\nTop 20 Khách sạn 3 sao Đà Lạt nên đặt\r\nDanh sách Khách sạn 4 sao Đà Lạt không thể bỏ qua\r\nKhách sạn 5 sao Đà Lạt sang trọng nhất\r\nHomestay\r\nNgoài khách sạn hiện nay Đà Lạt còn xuất hiện cả ngàn Homestay. Với địa thế tuyệt đẹp như view đồi thông, thung lũng, rừng hoa. Có thể nói homestay Đà Lạt là những nơi nghỉ dưỡng đẹp nhất Việt Nam. Ngoài ra các biệt thự Đà Lạt cho thuê cũng làm bạn ngất ngây với phong cách sang trọng.\r\n\r\nCon người Đà Lạt\r\n Cộng đồng dân cư Đà Lạt là một sự hòa nhập hết sức độc đáo của dân tộc từ các vùng Bắc, Trung Nam. Cả tỉnh có trên 20 tộc người, đông nhất là người Việt, sau đó là M’Nông, Mạ, Cơ Ho…Người dân ở quanh vùng Đà Lạt và Di Linh trồng rau và hoa cung cấp cho các tỉnh Nam Bộ.\r\n\r\nChợ đêm Đà Lạt\r\nChợ đêm Đà Lạt\r\n\r\nĐà Lạt mang đậm trong mình bản sắc văn hóa Tây Nguyên đẹp như huyền thoại. Những người dân hiền lành sống bằng nghề làm rẫy, làm vườn, trồng cà phê, chè, chăn nuôi gia súc…\r\n\r\nVào những ngày hội, ngày vui của gia đình, du khách sẽ được xem họ múa, hát, chơi nhạc. Bằng những nhạc cụ độc đáo mà âm thanh của nó nghe như tiếng gió hú, tiếng thác chảy trên ghềnh đá. Xem chi tiết các chương trình ở đây.\r\n\r\nThiên nhiên tươi đẹp đã tạo nên những mẫu người có phong cách đáng yêu, hiền hòa, thanh lịch và mến khách.\r\n\r\n4. Bất Động Sản Đà Lạt\r\nBất cứ khách du lịch nào cũng muốn sở hữu nhà đất Đà Lạt. Do được thiên nhiên ưu ái nên chỉ trong một thời gian ngắn giá bất động sản tại thành phố ngàn hoa đã tăng chóng mặt.\r\n\r\n5. Đà Lạt Thành phố 3 không.\r\nĐây là điểm độc đáo duy nhất của Đà Lạt mà không thành phố nào của Việt Nam có được.\r\n\r\nKhông có xích lô\r\nKhông có điều hòa\r\nKhông có đèn đỏ: Vào ngày 5/10/2021 Đà Lạt đã chấm dứt điều này bằng cách dựng đèn xanh đèn đỏ đầu tiên ở đường 3 tháng 2.\r\nđèn xanh đèn đỏ Đà Lạt\r\nđèn xanh đèn đỏ đầu tiên ở Đà Lạt\r\n\r\n6. Những cái nhất của Đà Lạt.\r\nRừng lá phong duy nhất\r\n1m2 có nhiều kiểu sống ảo nhất\r\nNhiều Homestay đẹp nhất\r\nBánh tráng nướng ngon nhất\r\nVườn bí ngô khổng lồ nhất\r\nNhiều loài hoa nhất\r\nHoa Đà Lạt\r\nĐà Lạt luôn có rất nhiều loài hoa nở quanh năm\r\n\r\n 7. CẢNH ĐẸP CỦA ĐÀ LẠT\r\nDo được thiên nhiên ưu  đãi về khí hậu cũng như sự sáng tạo tuyệt vời của con người. Nên thành phố mùa xuân có các địa điểm nổi tiếng mà không một nơi nào tại Việt Nam có thể sánh được. Nếu muốn tới ngắm các thắng cảnh tuyệt đẹp này. Bạn nên đặt khách sạn trước khi tới để tránh hết phòng vào những dịp lễ tết.\r\n\r\nĐà Lạt còn nổi tiếng về hồ, về thác nước và rừng thông. Những hồ đẹp ở Đà Lạt là hồ Xuân Hương, hồ Than Thở, hồ Đa Thiện, hồ Vạn Kiếp, hồ Mê Linh.\r\n\r\n Những hồ này nằm ngay trong thành phố, tên thơ mộng như cảnh hồ thơ mộng, mỗi hồ gắn với một truyền thuyết xa xưa.\r\n\r\nThành Phố Đà Lạt\r\n    ','https://res.cloudinary.com/dwjwe95at/image/upload/v1662009868/hmzqbiaiepvthb3hvaqj.jpg');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `paymentid` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `bookingid` int DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `printdate` datetime DEFAULT NULL,
  `type` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`paymentid`),
  UNIQUE KEY `paymentid_UNIQUE` (`paymentid`),
  KEY `userid_idx` (`userid`),
  KEY `bookingid_idx` (`bookingid`),
  CONSTRAINT `bookingid` FOREIGN KEY (`bookingid`) REFERENCES `booking` (`bookingid`),
  CONSTRAINT `userid_foreign` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,3,1,'Biên lai','2022-05-05 00:00:00','Momo');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rates`
--

DROP TABLE IF EXISTS `rates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rates` (
  `rateid` int NOT NULL AUTO_INCREMENT,
  `rate` int DEFAULT NULL,
  `comment` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ratingdate` datetime DEFAULT NULL,
  `tourid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`rateid`),
  UNIQUE KEY `rateid_UNIQUE` (`rateid`),
  KEY `userid_idx` (`userid`),
  KEY `tourid_idx23` (`tourid`),
  KEY `userid_idx123` (`userid`),
  KEY `abcd` (`tourid`),
  KEY `efdg` (`userid`),
  KEY `tourid_index` (`tourid`),
  KEY `userid_indexx` (`userid`),
  KEY `tourid_index123` (`tourid`),
  KEY `userid_index123` (`userid`),
  KEY `khoangoaitour` (`tourid`),
  KEY `khoangoaiuser` (`userid`),
  KEY `khoangoaitour123` (`tourid`),
  KEY `khoangoaiuser23` (`userid`),
  KEY `dfaefqwf` (`tourid`),
  KEY `adbdsefa` (`userid`) /*!80000 INVISIBLE */,
  CONSTRAINT `aerege` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`),
  CONSTRAINT `touridaaa` FOREIGN KEY (`tourid`) REFERENCES `tour` (`tourid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rates`
--

LOCK TABLES `rates` WRITE;
/*!40000 ALTER TABLE `rates` DISABLE KEYS */;
INSERT INTO `rates` VALUES (1,5,'Tạm được','2022-05-05 12:12:12',1,5),(2,4,'Quá tuyệt','2022-02-02 08:09:00',1,5),(3,0,'San pham tam tam','2022-08-27 00:00:00',7,5),(4,0,'hay','2022-08-27 00:00:00',1,5),(5,0,'ok','2022-08-28 00:00:00',1,5),(6,0,'ok','2022-08-28 00:00:00',1,5),(7,0,'ok','2022-08-28 00:00:00',1,5),(8,0,'ok','2022-08-28 00:00:00',1,5),(9,0,'ok','2022-08-28 00:00:00',1,5),(10,0,'ok','2022-08-28 00:00:00',1,5),(11,0,'TuyeT','2022-08-28 00:00:00',1,5),(12,0,'cũng được','2022-08-28 00:00:00',2,4),(13,0,'tui rất hài lòng','2022-08-28 00:00:00',3,5),(14,0,'đẹp quá ik','2022-08-29 00:00:00',1,6);
/*!40000 ALTER TABLE `rates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratesofnews`
--

DROP TABLE IF EXISTS `ratesofnews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ratesofnews` (
  `ratesofnewsid` int NOT NULL AUTO_INCREMENT,
  `rating` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ratingdate` datetime DEFAULT NULL,
  `newsid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`ratesofnewsid`),
  UNIQUE KEY `ratesofnewsid_UNIQUE` (`ratesofnewsid`),
  KEY `newsid_idx` (`newsid`),
  KEY `useridabc_idx` (`userid`),
  CONSTRAINT `newsid` FOREIGN KEY (`newsid`) REFERENCES `news` (`newsid`),
  CONSTRAINT `useridabc` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratesofnews`
--

LOCK TABLES `ratesofnews` WRITE;
/*!40000 ALTER TABLE `ratesofnews` DISABLE KEYS */;
INSERT INTO `ratesofnews` VALUES (1,NULL,'cũng đc','2022-09-01 20:01:20',1,5);
/*!40000 ALTER TABLE `ratesofnews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour` (
  `tourid` int NOT NULL AUTO_INCREMENT,
  `tourname` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `typeid` int DEFAULT NULL,
  `priceforadult` decimal(10,0) DEFAULT NULL,
  `priceforchild` decimal(10,0) DEFAULT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `time` date DEFAULT NULL,
  `maxquantity` int DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `numberoflikes` int DEFAULT NULL,
  `description` longtext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`tourid`),
  UNIQUE KEY `tourid_UNIQUE` (`tourid`),
  KEY `typeid_idx` (`typeid`),
  CONSTRAINT `typeid` FOREIGN KEY (`typeid`) REFERENCES `tourtypes` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,'Đà lạt',1,450000,430000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1662198648/iqmeop3nywvkmmf2oplp.jpg','2023-02-05',450,NULL,NULL,'Đà lạt thành phố mộng mơ'),(2,'Vũng Tàu',3,580000,540000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1662219540/a0yzaqo9icpsoqri4pxo.jpg','2023-02-05',150,NULL,NULL,'Chuyến đi 2 ngày 1 đêm'),(3,'Tham quan Địa Đạo Củ Chi ',1,780000,750000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1660727296/dia-dao-cu-chi-6_zjbqcz.jpg','2022-05-12',150,NULL,NULL,NULL),(4,'Tham quan công viên nước tại Đà Nẵng ',3,1570000,1400000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1660727299/congviennuocdanang_hpkwsj.jpg','2023-01-19',100,NULL,NULL,NULL),(5,'Tour nửa ngày tham quan Sài Gòn',1,500000,450000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1660727292/saigon_vzwqhx.jpg','2022-10-05',45,NULL,NULL,NULL),(6,'Trải nghiệm chào SUP trên sông Sài Gòn',3,800000,560000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661094109/kl947ptficenmoqecqbv.jpg','2022-11-11',45,NULL,NULL,NULL),(7,'Trải nghiệm nếm bia Craft ở Thành phố Hồ Chí Minh',5,2000000,1500000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661094190/lzcqutlff729fln7h5k2.jpg','2022-10-05',30,NULL,NULL,NULL),(8,'Tour 2 ngày 1 đêm tại vườn Gia Nam Cát Tiên từ TPHCM',4,10000000,9000000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661094343/vuongianamcattien_hj0jmq.jpg','2022-09-15',49,NULL,NULL,NULL),(9,'Cáp treo SunWorld BaNa Hills Đà Nẵng',1,15000000,1400000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661320665/vsk4nfojutu1d1dzwbzt.jpg','2022-11-02',45,NULL,NULL,NULL),(10,'Tham quan núi Ngũ Hành Sơn ở Đà Nẵng',1,450000,120000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661320665/bb2ycl2wdghiwfuwocur.png','2022-12-11',90,NULL,NULL,NULL),(11,'Trải nghiệm Herbal Spa tại Đà Nẵng',5,800000,560000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661320681/bttv6v4qeljhrebhsrkf.png','2023-04-15',100,NULL,NULL,NULL),(12,'Gói tắm bùn tại Resort Nha Trang',5,350000,25000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661320680/glrunrbazgnqcvyiutld.jpg','2023-10-10',120,NULL,NULL,NULL),(13,'Trải nghiệm du thuyền Sea Coral ',4,1500000,1200000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661320664/z52xjzvu43mrump9cnxw.jpg','2023-12-15',45,NULL,NULL,NULL),(14,'Trải nghiệm tắm bùn tại tháp bà ở Nha Trang',5,650000,550000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661320671/kczg3t4asasyk4uzo4pg.jpg','2022-10-15',50,NULL,NULL,NULL),(15,'Trải nghiệm lặn bình khí tại hòn Mun Nha Trang',3,500000,450000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661320664/rmczlmlkmqqpnglh9wrt.jpg','2022-11-15',45,NULL,NULL,NULL),(16,'Cáp treo Sun World Fansipan Legend',1,250000,150000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661320663/pkgp0tn52qy8zjajjtoi.jpg','2023-02-12',40,NULL,NULL,NULL),(17,'Tour riêng Thác Bạc và Cầu Kính Rồng Mây ở Sapa',4,950000,850000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661320663/pkgp0tn52qy8zjajjtoi.jpg','2023-05-15',90,NULL,NULL,NULL),(18,'Vé đi thuyền thúng vào rừng Dừa Bảy Mẫu ở Hội An',3,350000,150000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661320675/dkn7dczx8gvxsum55yai.jpg','2023-10-19',49,NULL,NULL,NULL),(19,'Vé VinWonders Nam Hội An',1,1500000,1200000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661320891/oc948ninutmqpxewighj.jpg','2023-04-14',150,NULL,NULL,NULL),(20,'Khám phá Mỹ Sơn buổi sớm',1,450000,420000,NULL,'2023-07-20',40,NULL,NULL,NULL),(21,'Tour tham qua thành phố và ngoại ô Hội An',4,1500000,1450000,NULL,'2023-03-23',100,NULL,NULL,NULL),(22,'Trải nghiệm Ylang Ylang Spa ở Hội An',5,NULL,NULL,NULL,'2023-06-12',150,NULL,NULL,NULL),(23,'Tour rừng dừa bằng xe đạp và thuyền thúng ở Hội An',4,NULL,NULL,NULL,'2023-06-15',100,NULL,NULL,NULL),(25,'Chuyến đi dã ngoại tại tháp Chàm',2,450000,400000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661317763/dpxclehqeychdbyhkftz.jpg',NULL,NULL,NULL,NULL,NULL),(26,'Leo núi Bà Đen',2,350000,250000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661318757/mr3iqg4fhboaz76wnxsy.jpg','2022-05-10',NULL,NULL,NULL,NULL),(27,'Cắm trại hồ Dầu Tiếng ',2,450000,420000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661389121/x9wxzt2imppysf8daz00.jpg','2023-12-02',120,NULL,NULL,'Cắm trại tại hồ Dầu Tiếng , nướng thịt BBQ , teambuilding'),(29,'Cắm trại hồ Dầu Tiếng ',2,450000,430000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1662173300/zkqm12vplsfmjfutbqwj.jpg','2022-12-12',45,NULL,NULL,''),(30,'Chuyến đi dã ngoại tại núi Bà Đen',2,500000,450000,'https://res.cloudinary.com/dwjwe95at/image/upload/v1662198784/uslgf1eqt09kummpsyfb.jpg','2022-03-10',150,NULL,NULL,'abcd');
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourimage`
--

DROP TABLE IF EXISTS `tourimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tourimage` (
  `tourimageid` int NOT NULL AUTO_INCREMENT,
  `image` varchar(100) DEFAULT NULL,
  `tourid` int DEFAULT NULL,
  PRIMARY KEY (`tourimageid`),
  UNIQUE KEY `tourimageid_UNIQUE` (`tourimageid`),
  KEY `tourid_idxx` (`tourid`),
  CONSTRAINT `touridaaaa` FOREIGN KEY (`tourid`) REFERENCES `tour` (`tourid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourimage`
--

LOCK TABLES `tourimage` WRITE;
/*!40000 ALTER TABLE `tourimage` DISABLE KEYS */;
/*!40000 ALTER TABLE `tourimage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourtypes`
--

DROP TABLE IF EXISTS `tourtypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tourtypes` (
  `typeid` int NOT NULL AUTO_INCREMENT,
  `typename` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourtypes`
--

LOCK TABLES `tourtypes` WRITE;
/*!40000 ALTER TABLE `tourtypes` DISABLE KEYS */;
INSERT INTO `tourtypes` VALUES (1,'Tham quan ',NULL),(2,'Thể thao & hoạt động ngoài trời',NULL),(3,'Hoạt động và thể thao dưới nước',NULL),(4,'Tour và ngắm cảnh',NULL),(5,'Thư giãn ',NULL);
/*!40000 ALTER TABLE `tourtypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `avatar` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `passport` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `userid_UNIQUE` (`userid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Ad','Min','admin','123456',30,NULL,NULL,NULL,NULL,NULL,'admin'),(2,'Sta','ff','staff','78910',23,NULL,NULL,NULL,NULL,NULL,'guest'),(3,'Trần','Khải Vy','tkv','123456',21,NULL,NULL,NULL,NULL,NULL,'guest'),(4,'Tran','Vy','tranvy','$2a$10$liB2LCA0tQ9QXc5X6/jW.u8oX4mhALQuR.5RNmPD5YNd8VK8UObLW',21,NULL,NULL,NULL,NULL,NULL,'admin'),(5,'ABC','DEF','doremi','$2a$10$u3/z/ptxx4rNAPzEQfuJR.T/kr9qnbtHINiJn5pYPoshvePIqQ.tS',NULL,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661316024/q9dnxacxa69nd9dk3cfz.jpg',NULL,NULL,NULL,NULL,'guest'),(6,'tk','v','tkv510','$2a$10$zWJPbJ0Fn3.FQ2OfJOKoSuFYhyyNCR5QCjkb2QkLZlnc/hMY9nTSi',NULL,'https://res.cloudinary.com/dwjwe95at/image/upload/v1661751046/jnsiaiuc0l4pyx4q8399.jpg',NULL,NULL,NULL,NULL,'guest');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-04 14:31:46
