/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  iulia.rinea
 * Created: Jul 3, 2019

 */

CREATE TABLE `application` (

  `id` int(11) NOT NULL,

  `name` varchar(45) DEFAULT NULL,

  `descr` varchar(45) DEFAULT NULL,

  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


