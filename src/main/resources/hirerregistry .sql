-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 06 Oca 2019, 20:51:22
-- Sunucu sürümü: 10.1.34-MariaDB
-- PHP Sürümü: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `hirerregistry`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `addresses`
--

CREATE TABLE `addresses` (
  `address_id` int(11) NOT NULL,
  `address` text CHARACTER SET utf8 NOT NULL,
  `district_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `addresses`
--

INSERT INTO `addresses` (`address_id`, `address`, `district_id`) VALUES
(2, 'AYDINLI', 4),
(3, 'POSTANE', 4),
(4, 'KAYNARCA', 5);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `annocomment`
--

CREATE TABLE `annocomment` (
  `ancom_id` int(11) NOT NULL,
  `announcement_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment` text CHARACTER SET utf8 NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `annocomment`
--

INSERT INTO `annocomment` (`ancom_id`, `announcement_id`, `user_id`, `comment`, `date`) VALUES
(1, 1, 4, 'Güzel bir daire.', '2018-12-06'),
(2, 1, 5, 'Daireyi beğenmedim rutubetli.', '2018-12-05'),
(3, 2, 3, 'Konum olarak çok güzel bir yer tavsiye ederim.', '2018-12-12'),
(4, 2, 3, 'asd', '2018-12-23'),
(5, 1, 4, 'deneme yorumu', '2018-12-23'),
(6, 4, 3, 'Ev çok güzel.', '2019-01-06');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `announcements`
--

CREATE TABLE `announcements` (
  `announcement_id` int(11) NOT NULL,
  `title` text CHARACTER SET utf8 NOT NULL,
  `description` text CHARACTER SET utf8 NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `date` date NOT NULL,
  `type` text CHARACTER SET utf8 NOT NULL,
  `m2` int(11) NOT NULL,
  `room` text CHARACTER SET utf8 NOT NULL,
  `heat` text CHARACTER SET utf8 NOT NULL,
  `user_id` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `adres_id` int(11) NOT NULL,
  `phone` text CHARACTER SET utf8 NOT NULL,
  `profile_picture` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `announcements`
--

INSERT INTO `announcements` (`announcement_id`, `title`, `description`, `price`, `date`, `type`, `m2`, `room`, `heat`, `user_id`, `active`, `adres_id`, `phone`, `profile_picture`) VALUES
(1, 'Ayd?nl? merkezde kelepir daire.', 'Okula, otobüs dura??na yürüme mesafesinde.', '800', '2018-12-01', 'DA?RE', 95, '1+1', 'Kalorifer', 3, 1, 2, '05389857777', '1_thumbnail.jpg'),
(2, 'DEN?Z MANZARALI', 'Nullam mollis sem at turpis efficitur, eget hendrerit purus congue. Sed tristique sapien ac libero aliquam imperdiet. Maecenas et nibh ut lacus ultrices pulvinar lobortis quis neque. Aliquam vel semper elit, pulvinar vestibulum leo. Duis ullamcorper turpis mauris, tincidunt viverra eros interdum ac. Fusce tristique in nunc vitae vestibulum. Suspendisse sit amet diam orci. Morbi id scelerisque purus. Donec pretium libero vel neque dapibus, ac rhoncus neque accumsan.', '1250', '2018-11-30', 'DA?RE', 150, '3+1', 'KALOR?FER', 4, 1, 4, '05347415245', '2_thumbnail.jpg'),
(3, 'Her yere kolay ula??m', 'Quisque interdum elementum commodo. Duis pretium vel dui eget luctus. Morbi vel urna sit amet nunc sodales rhoncus. Ut vitae dui nec mi faucibus condimentum. Duis feugiat porta erat non gravida. Curabitur at mi gravida, lacinia elit eu, tincidunt turpis. Pellentesque ex lorem, vehicula nec nulla sed, porta commodo magna. Maecenas consequat fermentum justo, imperdiet tincidunt nunc lobortis in. Phasellus non efficitur ipsum, in placerat mauris. Praesent vel justo nisi.', '950', '2018-12-13', 'DA?RE', 95, '2+1', 'KALOR?FER', 3, 1, 2, '05389857471', '3_thumbnail.jpg'),
(4, 'Ö?renci veya Memura', 'Her yere yak?n.', '1250', '2019-01-04', 'DA?RE', 149, '2+1', 'Kalorifer', 7, 1, 4, '05314545555', '4_thumbnail.jpg');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `district`
--

CREATE TABLE `district` (
  `district_id` int(11) NOT NULL,
  `district` text CHARACTER SET utf8 NOT NULL,
  `province_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `district`
--

INSERT INTO `district` (`district_id`, `district`, `province_id`) VALUES
(1, 'MERKEZ', 81),
(2, 'AKÇAKOCA', 81),
(3, 'KAYNAŞLI', 81),
(4, 'TUZLA', 34),
(5, 'PENDİK', 34);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `province`
--

CREATE TABLE `province` (
  `province_id` int(11) NOT NULL,
  `province` text CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `province`
--

INSERT INTO `province` (`province_id`, `province`) VALUES
(34, 'İSTANBUL'),
(41, 'KOCAELİ'),
(54, 'SAKARYA'),
(81, 'DÜZCE');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `profile_picture` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`, `email`, `password`, `active`, `profile_picture`) VALUES
(2, 'Gökhan', 'ESKIN', 'gokhaneskin34@gmail.com', '$2a$10$n3M8hAQM9JqaK0FaFdqfYu77StUfkR9ULde/gX/CMZEV5Xc08.gkC', 1, 'gokhaneskin34@gmail.com_thumbnail.jpg'),
(3, 'Defne', 'ÇAKIR', 'defnecakir@gmail.com', '$2a$10$GO3/sHtBZ7oSxIL1PtYCVu.mnAKSHNgIKa2/Ynv6wS7zaBUKkRykm', 1, '3.jpg'),
(4, 'Hüseyin', 'AR', 'huseyinar@gmail.com', '$2a$10$iPGLHwrMSQXMFBTuNQbSXumdBM7QZUH6SYP65gqj4Pf8ZWDgn6jxW', 1, 'huseyinar@gmail.com_thumbnail.jpg'),
(5, 'Bahar', 'TERCAN', 'bahartercan@gmail.com', '$2a$10$4VJ3q12jUws0d8nD92wkWOkyvj48P4PgxcMvmC3d.pcluZx0mABF2', 1, NULL),
(6, 'deneme', 'deneme', 'deneme@gmail.com', '$2a$10$mrq5HwCXM6MBMG.amXJfcuEIbj5WbPY73KT2BcNSWYnewvNPu3U4q', 1, NULL),
(7, 'AL?', 'VEL?', 'aliveli@gmail.com', '$2a$10$D68BYdU7SM8F0xgYDip9C.PNSYKlhgz3wbQoZBtHj72QnaP.Nv.Ia', 1, 'aliveli@gmail.com_thumbnail.jpg'),
(8, 'melek', 'keser', 'melekkeser@gmail.com', '$2a$10$OYcsUDaasQ5G7xdta1sRD.oIQxjxdCkF68iLNvOm2XGrh5yXnRBcG', 1, NULL),
(9, 'ceyhun', 'k?l?ç', 'ceyhunkilic@gmail.com', '$2a$10$2BqK45i2wz7VtOEZF7i76eqiMzypSQ1lBAqufURdIxR38NpEZBP3m', 1, NULL),
(10, 'levent', 'acar', 'leventacar@gmail.com', '$2a$10$WFFKH6H3xCEilPHsCrT1vO00oD/vag8oOnL5SyT3l2m.dS2uG4i7.', 1, NULL);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `usercomment`
--

CREATE TABLE `usercomment` (
  `usercom_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comuser_id` int(11) NOT NULL,
  `comment` text CHARACTER SET utf8 NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `usercomment`
--

INSERT INTO `usercomment` (`usercom_id`, `user_id`, `comuser_id`, `comment`, `date`) VALUES
(1, 3, 4, 'Anlayışlı bir ev sahibi.', '2018-12-22'),
(2, 3, 5, 'Biraz tak?nt?l? biri ev sahibi ama eviyle ilgili.', '2018-12-23'),
(3, 4, 3, 'Ev sahibi çok iyi birisi güvenilir.', '2018-12-23'),
(4, 7, 3, 'Çok iyi bir ev sahibi. Te?ekkürler.', '2019-01-06');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(2, 1),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 2);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `addresses`
--
ALTER TABLE `addresses`
  ADD PRIMARY KEY (`address_id`),
  ADD KEY `FKeekaptqs3enbwkg59fphwk3ux` (`district_id`);

--
-- Tablo için indeksler `annocomment`
--
ALTER TABLE `annocomment`
  ADD PRIMARY KEY (`ancom_id`),
  ADD KEY `FKmx1p3e8q8hl0t1ox2l90ggpca` (`announcement_id`),
  ADD KEY `FKr86p3ac6thg6wvto4d4ajmb0a` (`user_id`);

--
-- Tablo için indeksler `announcements`
--
ALTER TABLE `announcements`
  ADD PRIMARY KEY (`announcement_id`),
  ADD KEY `FKexw8rmt9p2prdki4nxajx9hib` (`adres_id`),
  ADD KEY `FK13j2rm57d1vp34c23e9a0iw29` (`user_id`);

--
-- Tablo için indeksler `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`district_id`),
  ADD KEY `FK276utu38g5lgqeth6pwfm3rw2` (`province_id`);

--
-- Tablo için indeksler `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Tablo için indeksler `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`province_id`);

--
-- Tablo için indeksler `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `usercomment`
--
ALTER TABLE `usercomment`
  ADD PRIMARY KEY (`usercom_id`),
  ADD KEY `FKet6uup1htkatmwtvkyqsbkvtj` (`comuser_id`),
  ADD KEY `FK5xa5yhswbk0uutxbo6hos3c78` (`user_id`);

--
-- Tablo için indeksler `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `user_role_key` (`role_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `addresses`
--
ALTER TABLE `addresses`
  MODIFY `address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `annocomment`
--
ALTER TABLE `annocomment`
  MODIFY `ancom_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `announcements`
--
ALTER TABLE `announcements`
  MODIFY `announcement_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `district`
--
ALTER TABLE `district`
  MODIFY `district_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Tablo için AUTO_INCREMENT değeri `usercomment`
--
ALTER TABLE `usercomment`
  MODIFY `usercom_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `addresses`
--
ALTER TABLE `addresses`
  ADD CONSTRAINT `FKeekaptqs3enbwkg59fphwk3ux` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`),
  ADD CONSTRAINT `addresses_ibfk_1` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`);

--
-- Tablo kısıtlamaları `annocomment`
--
ALTER TABLE `annocomment`
  ADD CONSTRAINT `FKmx1p3e8q8hl0t1ox2l90ggpca` FOREIGN KEY (`announcement_id`) REFERENCES `announcements` (`announcement_id`),
  ADD CONSTRAINT `FKr86p3ac6thg6wvto4d4ajmb0a` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `annocomment_ibfk_1` FOREIGN KEY (`announcement_id`) REFERENCES `announcements` (`announcement_id`),
  ADD CONSTRAINT `annocomment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Tablo kısıtlamaları `announcements`
--
ALTER TABLE `announcements`
  ADD CONSTRAINT `FK13j2rm57d1vp34c23e9a0iw29` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKexw8rmt9p2prdki4nxajx9hib` FOREIGN KEY (`adres_id`) REFERENCES `addresses` (`address_id`);

--
-- Tablo kısıtlamaları `district`
--
ALTER TABLE `district`
  ADD CONSTRAINT `FK276utu38g5lgqeth6pwfm3rw2` FOREIGN KEY (`province_id`) REFERENCES `province` (`province_id`),
  ADD CONSTRAINT `district_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `province` (`province_id`);

--
-- Tablo kısıtlamaları `usercomment`
--
ALTER TABLE `usercomment`
  ADD CONSTRAINT `FK5xa5yhswbk0uutxbo6hos3c78` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKet6uup1htkatmwtvkyqsbkvtj` FOREIGN KEY (`comuser_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `usercomment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `usercomment_ibfk_2` FOREIGN KEY (`comuser_id`) REFERENCES `user` (`id`);

--
-- Tablo kısıtlamaları `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `role_userrole` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `user_userrole` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
