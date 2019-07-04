/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ovidiu.hulea
 * Created: Jul 3, 2019
 */

CREATE TABLE `applicationrolestechnologies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idApplicationRole` int(11) NOT NULL,
  `idTechnology` int(11) NOT NULL,
  `idLevelMin` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idApplicationRole_idx` (`idApplicationRole`),
  KEY `idTechnology_idx` (`idTechnology`),
  KEY `idLevelMin_idx` (`idLevelMin`),
  CONSTRAINT `idApplicationRoleTechnologies` FOREIGN KEY (`idApplicationRole`) REFERENCES `applicationroles` (`id`),
  CONSTRAINT `idLevelMin` FOREIGN KEY (`idLevelMin`) REFERENCES `level` (`id`),
  CONSTRAINT `idTechnologyRoleTechnologies` FOREIGN KEY (`idTechnology`) REFERENCES `technology` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;