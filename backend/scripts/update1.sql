/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  eduard.ioo
 * Created: Jul 9, 2019
 */

ALTER TABLE `projappdb`.`subscription` 
DROP FOREIGN KEY `idemploye`;
ALTER TABLE `projappdb`.`subscription` 
CHANGE COLUMN `idemploye` `idemployee` INT(11) NOT NULL ;
ALTER TABLE `projappdb`.`subscription` 
ADD CONSTRAINT `idemploye`
  FOREIGN KEY (`idemployee`)
  REFERENCES `projappdb`.`employee` (`id`);