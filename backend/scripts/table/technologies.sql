/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  florin.handrea
 * Created: Jul 3, 2019
 */

CREATE TABLE IF NOT EXISTS `Tehnologies` (
  `ID` INT AUTO_INCREMENT,
  `Name` VARCHAR(120) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;