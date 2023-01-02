CREATE TABLE `test`.`event` (
  `eventId` INT NULL AUTO_INCREMENT,
  `eventLocation` VARCHAR(200) NULL,
  `eventTime` VARCHAR(45) NULL,
  `eventName` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`eventId`),
  UNIQUE INDEX `id_UNIQUE` (`eventId` ASC));
