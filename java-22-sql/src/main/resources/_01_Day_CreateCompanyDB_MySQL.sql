-- Veri tabani olusturuyoruz.
CREATE SCHEMA `my_company_db` DEFAULT CHARACTER SET utf32 COLLATE utf32_bin ;


-- DROP TABLE `my_company_db`.`CUSTOMERS`;
-- Müsteriler Tablosu
CREATE TABLE `my_company_db`.`CUSTOMERS` (
                                             `ID` INT NOT NULL AUTO_INCREMENT,
                                             `FIRST_NAME` VARCHAR(60) NULL,
                                             `LAST_NAME` VARCHAR(60) NULL,
                                             PRIMARY KEY (`ID`));

-- Tabloyu siler burada "products"
-- DROP TABLE `my_company_db`.`products`;

-- Ürünler Tablosu
CREATE TABLE `my_company_db`.`products` (
                                            `ID` INT NOT NULL AUTO_INCREMENT,
                                            `PROD_NAME` VARCHAR(45) NULL,
                                            `PROD_CODE` VARCHAR(45) NULL,
                                            PRIMARY KEY (`ID`));

-- tablo üzerinde degisiklik yapar
ALTER TABLE `my_company_db`.`products`
    CHANGE COLUMN `PROD_CODE` `PROD_Code` VARCHAR(45) NULL DEFAULT NULL ;

-- DROP DATABASE --> Database(Schema yi) i siler (Veritabanini)
-- DROP DATABASE `my_company_db`;

-- Müsteri tablosuna kayitlar eklendi
INSERT INTO `my_company_db`.`CUSTOMERS` (`FIRST_NAME`, `LAST_NAME`) VALUES ('Hakan', 'Metin');
INSERT INTO `my_company_db`.`CUSTOMERS` (`FIRST_NAME`, `LAST_NAME`) VALUES ('Natalie', 'Weiss');
INSERT INTO `my_company_db`.`CUSTOMERS` (`FIRST_NAME`, `LAST_NAME`) VALUES ('Martin', 'Lol');


-- MUSTERILERI LISTELE
SELECT * FROM my_company_db.CUSTOMERS;

