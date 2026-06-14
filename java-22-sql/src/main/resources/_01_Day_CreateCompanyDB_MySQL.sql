-- mycompany DATABASE
CREATE SCHEMA `my_company_db` DEFAULT CHARACTER SET utf32 COLLATE utf32_bin ;


CREATE TABLE `my_company_db`.`CUSTOMERS` (
                                             `ID` INT NOT NULL AUTO_INCREMENT,
                                             `FIRST_NAME` VARCHAR(45) NULL,
                                             `LAST_NAME` VARCHAR(45) NULL,
                                             PRIMARY KEY (`ID`));

-- PRODUCTS Tablosu
CREATE TABLE `my_company_db`.`PRODUCTS` (
                                            `ID` INT NOT NULL AUTO_INCREMENT,
                                            `PROD_NAME` VARCHAR(45) NULL,
                                            `PROD_CODE` VARCHAR(45) NULL,
                                            PRIMARY KEY (`ID`));

-- Tabloyu siler
DROP TABLE `my_company_db`.`PRODUCTS`;

-- the list of customers
SELECT * FROM my_company_db.CUSTOMERS;

-- Müsteri Tablosuna kayitlat ekliyruz.
INSERT INTO `my_company_db`.`CUSTOMERS` (`FIRST_NAME`, `LAST_NAME`) VALUES ('Natalie', 'Weiss');
INSERT INTO `my_company_db`.`CUSTOMERS` (`FIRST_NAME`, `LAST_NAME`) VALUES ('Hakan', 'Metin');
INSERT INTO `my_company_db`.`CUSTOMERS` (`FIRST_NAME`) VALUES ('Ahmet');

  