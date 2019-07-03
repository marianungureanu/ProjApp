CREATE TABLE `employeetechnology` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idemployee` int(11) NOT NULL,
  `idtechnology` int(11) NOT NULL,
  `idlevel` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idemployee_idx` (`idemployee`),
  KEY `idtechnology_idx` (`idtechnology`),
  KEY `idlevel_idx` (`idlevel`),
  CONSTRAINT `idemployee` FOREIGN KEY (`idemployee`) REFERENCES `employee` (`id`),
  CONSTRAINT `idlevel` FOREIGN KEY (`idlevel`) REFERENCES `level` (`id`),
  CONSTRAINT `idtechnology` FOREIGN KEY (`idtechnology`) REFERENCES `technology` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
