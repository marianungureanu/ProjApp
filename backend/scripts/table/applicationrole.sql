/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  iulia.rinea
 * Created: Jul 3, 2019
 */

CREATE TABLE `applicationrole` (
  `id` int(11) NOT NULL,
  `idrole` int(11) NOT NULL,
  `idapp` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idrole_idx` (`idrole`),
  KEY `idapp_idx` (`idapp`),
  CONSTRAINT `idapp` FOREIGN KEY (`idapp`) REFERENCES `application` (`id`),
  CONSTRAINT `idrole` FOREIGN KEY (`idrole`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
