/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  iulia.rinea
 * Created: Jul 3, 2019
 */

CREATE TABLE `subscription` (
  `id` int(11) NOT NULL,
  `status` varchar(45),
  `idemployee` int(11) NOT NULL,
  `idapprole` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idemployee_idx` (`idemployee`),
  KEY `idapprole_idx` (`idapprole`),
  CONSTRAINT `idemployee` FOREIGN KEY (`idemployee`) REFERENCES `employee` (`id`),
  CONSTRAINT `idapprole` FOREIGN KEY (`idapprole`) REFERENCES `applicationrole` (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

