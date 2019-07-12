USE projappdb;

DROP TABLE IF EXISTS `subscription`;
DROP TABLE IF EXISTS `applicationroletechnology`;
DROP TABLE IF EXISTS `applicationrolestechnologies`;
DROP TABLE IF EXISTS `employeetechnology`;
DROP TABLE IF EXISTS `applicationrole`;
DROP TABLE IF EXISTS `application`;
DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `level`;
DROP TABLE IF EXISTS `technology`;
DROP TABLE IF EXISTS `role`;

CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `descr` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `technology` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `applicationrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idrole` int(11) NOT NULL,
  `idapp` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idrole_idx` (`idrole`),
  KEY `idapp_idx` (`idapp`),
  CONSTRAINT `ar_idapp` FOREIGN KEY (`idapp`) REFERENCES `application` (`id`),
  CONSTRAINT `ar_idrole` FOREIGN KEY (`idrole`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `applicationrolestechnologies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idapplicationrole` int(11) NOT NULL,
  `idtechnology` int(11) NOT NULL,
  `idlevelmin` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idapplicationrole_idx` (`idapplicationrole`),
  KEY `idtechnology_idx` (`idtechnology`),
  KEY `idlevel_idx` (`idlevelmin`),
  CONSTRAINT `art_idapplicationrole` FOREIGN KEY (`idapplicationrole`) REFERENCES `applicationrole` (`id`),
  CONSTRAINT `art_idlevel` FOREIGN KEY (`idlevelmin`) REFERENCES `level` (`id`),
  CONSTRAINT `art_idtechnology` FOREIGN KEY (`idtechnology`) REFERENCES `technology` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `employeetechnology` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idemployee` int(11) NOT NULL,
  `idtechnology` int(11) NOT NULL,
  `idlevel` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idemployee_idx` (`idemployee`),
  KEY `idtechnology_idx` (`idtechnology`),
  KEY `idlevel_idx` (`idlevel`),
  CONSTRAINT `et_idemployee` FOREIGN KEY (`idemployee`) REFERENCES `employee` (`id`),
  CONSTRAINT `et_idlevel` FOREIGN KEY (`idlevel`) REFERENCES `level` (`id`),
  CONSTRAINT `et_idtechnology` FOREIGN KEY (`idtechnology`) REFERENCES `technology` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `subscription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) DEFAULT NULL,
  `idemployee` int(11) NOT NULL,
  `idapprole` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idemployee_idx` (`idemployee`),
  KEY `idapprole_idx` (`idapprole`),
  CONSTRAINT `subs_idapprole` FOREIGN KEY (`idapprole`) REFERENCES `applicationrole` (`id`),
  CONSTRAINT `subs_idemployee` FOREIGN KEY (`idemployee`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `technology` (`name`) VALUES ("JavaSE"), ("JavaEE"), ("C#"), (".NET"), ("ASM"), ("Spring");
INSERT INTO `employee`(`name`) VALUES ("John Doe"), ("Mary Poppins");
INSERT INTO `level` (`name`) VALUES ("Level 1"), ("Level 2"), ("Level 3"), ("Level 4"), ("Level 5"), ("Level 6");
insert into `role`(`name`) values ('manager'), ('team leader'), ('baby developer'), ('senior developer');

INSERT IGNORE INTO `application` (`id`, `name`, `descr`) VALUES
	(1, 'Engineering Application', 'This application does that and that and also that. It is used to leverage engineering calculations.'),
	(2, 'Banking', 'This application allows banking users to do their online banking actions.'),
	(3, 'Scientific Research', 'This application help researchers to publish their findings and that and that.');

INSERT IGNORE INTO `applicationrole` (`id`, `idrole`, `idapp`) VALUES
	(1, 1, 1),
	(2, 4, 1),
	(3, 3, 2),
	(4, 4, 2),
	(5, 2, 2),
	(6, 4, 3),
	(7, 3, 3);

INSERT IGNORE INTO `applicationrolestechnologies` (`id`, `idapplicationrole`, `idtechnology`, `idlevelmin`) VALUES
	(1, 1, 1, 2),
	(2, 1, 2, 3),
	(3, 2, 3, 1),
	(4, 3, 4, 1),
	(5, 4, 4, 2),
	(6, 5, 5, 5),
	(7, 6, 4, 6),
	(8, 7, 6, 2);
    
INSERT INTO `subscription` (`id`, `status`, `idemployee`, `idapprole`) VALUES ('4', 'new', '1', '1');
INSERT INTO `subscription` (`id`, `status`, `idemployee`, `idapprole`) VALUES ('5', 'new', '2', '4');
INSERT INTO `subscription` (`id`, `status`, `idemployee`, `idapprole`) VALUES ('6', 'new', '2', '1');


