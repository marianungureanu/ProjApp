USE projappdb;

DROP TABLE IF EXISTS `subscription`;
DROP TABLE IF EXISTS `applicationroletechnology`;
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
  `id` int(11) NOT NULL,
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
  `id` int(11) NOT NULL,
  `idrole` int(11) NOT NULL,
  `idapp` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idrole_idx` (`idrole`),
  KEY `idapp_idx` (`idapp`),
  CONSTRAINT `ar_idapp` FOREIGN KEY (`idapp`) REFERENCES `application` (`id`),
  CONSTRAINT `ar_idrole` FOREIGN KEY (`idrole`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `applicationroletechnology` (
  `id` int(11) NOT NULL,
  `idapplicationrole` int(11) NOT NULL,
  `idtechnology` int(11) NOT NULL,
  `idlevel` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idapplicationrole_idx` (`idapplicationrole`),
  KEY `idtechnology_idx` (`idtechnology`),
  KEY `idlevel_idx` (`idlevel`),
  CONSTRAINT `art_idapplicationrole` FOREIGN KEY (`idapplicationrole`) REFERENCES `applicationrole` (`id`),
  CONSTRAINT `art_idlevel` FOREIGN KEY (`idlevel`) REFERENCES `level` (`id`),
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
  `id` int(11) NOT NULL,
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