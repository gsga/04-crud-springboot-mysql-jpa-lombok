DROP DATABASE IF EXISTS `anime`;

CREATE DATABASE IF NOT EXISTS `anime` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

DROP USER IF EXISTS `cruduser` @`%`;

CREATE USER IF NOT EXISTS `cruduser` @`%` IDENTIFIED BY 'crudPassword';

GRANT USAGE ON *.* TO `cruduser` @`%`;

GRANT ALL PRIVILEGES ON `anime`.* TO 'cruduser ' @' % ';

USE `anime`;

DROP TABLE IF EXISTS `anime`;

CREATE TABLE IF NOT EXISTS `anime` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `anio` int NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 13;

INSERT INTO
  `anime` (`id`, `nombre`, `anio`, `fecha_creacion`)
VALUES
  (
    1,
    'Shingeky no Kyojin',
    2009,
    '2021-01-15 00:00:00'
  ),
  (2, 'Dragon Ball Z', 1989, '2021-01-15 00:00:00'),
  (
    3,
    'Naruto Shippuden',
    2007,
    '2021-01-20 05:54:02'
  ),
  (4, 'One Piece', 2020, '2021-02-01 20:40:38'),
  (5, 'Samurai X', 2000, '2021-02-01 20:44:32'),
  (6, 'Death Note', 2002, '2021-02-01 20:46:03'),
  (7, 'Naruto', 2001, '2021-02-01 20:51:13'),
  (8, 'Demon Slayer', 2018, '2021-02-01 21:04:32'),
  (9, 'Blood +', 2001, '2021-02-02 03:59:48'),
  (
    10,
    'Nanatsu no taizai',
    2016,
    '2021-02-05 20:09:32'
  ),
  (
    11,
    'Saint Seiya Mod',
    1986,
    '2021-02-05 17:50:38'
  ),
  (12, 'Yu yu hakusho', 1987, '2021-02-05 19:05:06');

DROP TABLE IF EXISTS `personaje`;

CREATE TABLE IF NOT EXISTS `personaje` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `anime_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_personaje_anime_idx` (`anime_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 4;

INSERT INTO
  `personaje` (`id`, `nombre`, `anime_id`)
VALUES
  (1, 'Goku', 2),
  (2, 'Naruto Uzumaki', 3),
  (3, 'Sasuke Uchiha', 3);

ALTER TABLE
  `personaje`
ADD
  CONSTRAINT `fk_personaje_anime` FOREIGN KEY (`anime_id`) REFERENCES `anime` (`id`);