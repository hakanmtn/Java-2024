ALTER TABLE `my_company_db`.`CUSTOMERS`
    ADD COLUMN `AGE` TINYINT(3) NULL AFTER `LAST_NAME`,
    ADD COLUMN `COUNTRY` VARCHAR(65) NULL AFTER `AGE`,
    CHANGE COLUMN `CUSTOMER_ID` `CUSTOMER_ID` INT NOT NULL AUTO_INCREMENT ;

SELECT * FROM my_company_db.CUSTOMERS;

UPDATE `my_company_db`.`CUSTOMERS` SET `AGE` = '32', `COUNTRY` = 'DE' WHERE (`CUSTOMER_ID` = '1');
UPDATE `my_company_db`.`CUSTOMERS` SET `AGE` = '31', `COUNTRY` = 'TR' WHERE (`CUSTOMER_ID` = '2');
UPDATE `my_company_db`.`CUSTOMERS` SET `AGE` = '29', `COUNTRY` = 'USA' WHERE (`CUSTOMER_ID` = '3');
UPDATE `my_company_db`.`CUSTOMERS` SET `AGE` = '28', `COUNTRY` = 'DE' WHERE (`CUSTOMER_ID` = '4');
UPDATE `my_company_db`.`CUSTOMERS` SET `AGE` = '22', `COUNTRY` = 'FR' WHERE (`CUSTOMER_ID` = '5');

SELECT FIRST_NAME, LAST_NAME FROM my_company_db.CUSTOMERS;


-- Ulkesi TR olanlar

Select * from my_company_db.CUSTOMERS
where COUNTRY = 'TR';


Select * from CUSTOMERS
where COUNTRY = 'TR' OR LAST_NAME = 'Weiss';

-- Tabloya yeni kolonlar eklendi:
ALTER TABLE `my_company_db`.`CUSTOMERS`
    ADD COLUMN `EMAIL` VARCHAR(100) NULL AFTER `COUNTRY`,
    ADD COLUMN `GENDER` VARCHAR(1) NULL AFTER `EMAIL`;

Select * from CUSTOMERS;

insert into CUSTOMERS (FIRST_NAME, LAST_NAME, AGE, COUNTRY, EMAIL, GENDER) values ('Titus', 'Roll', 83, 'CN', 'troll0@surveymonkey.com', 'M');

SELECT * FROM  CUSTOMERS
WHERE COUNTRY = 'DE';


SELECT * FROM  CUSTOMERS
WHERE COUNTRY = 'CA' AND GENDER = 'F';

-- TEKRAR ETMEYEN ÜLKELER
SELECT DISTINCT(COUNTRY) FROM CUSTOMERS;


SELECT COUNT(DISTINCT(COUNTRY)) FROM CUSTOMERS;

-- Toplam müsteri sayisi
SELECT COUNT(*) FROM CUSTOMERS;


SELECT SUM(AGE) FROM CUSTOMERS;

select avg(AGE) FROM CUSTOMERS;
select MIN(AGE) FROM CUSTOMERS;
select MAX(AGE) AS "THE GREATEST" FROM CUSTOMERS;

-- ALIAS (lakap)

SELECT c.CUSTOMER_ID , c.FIRST_NAME , c.LAST_NAME  from CUSTOMERS as c;


-- isim ve soyisim birlesik yazilacak

    SELECT concat(FIRST_NAME , ' ' , LAST_NAME) from CUSTOMERS;

-- HANGI ÜLKEDEN KAC TANE VAR

Select distinct COUNTRY, count(COUNTRY) from CUSTOMERS
group by COUNTRY;


-- Yeni bir kayit ekle :

insert into my_company_db.CUSTOMERS
    (first_name, last_name, age, country, email, gender)
values ('Cenj', 'yes' , 12 , 'TR' , 'test@hotmail.cok' , 'F');

select COUNT(*) FROM CUSTOMERS;

-- BU SEKILDE DE MÜMKÜN COKLU KAYIT

insert into my_company_db.CUSTOMERS
(first_name, last_name, age, country, email, gender)
values ('XENIJA', 'yes' , 17 , 'TR' , 'tesst@hotmail.cok' , 'F'),
('mess', 'gfa' , 76 , 'TR' , 'test@hotmail.cok' , 'F'),
('nwaa', 'yefahtes' , 13 , 'TR' , 'tesst@hotmail.cok' , 'F');



select COUNT(*) FROM CUSTOMERS;


-- ID Numarasi verilen bir kaydi sil // silmede sart mutlaka gerekli Dikkat etmek lazim. Direkt tabloyu silbilme ihti-
-- limiz var. (bütün kayitlari siler )

Delete from  CUSTOMERS
where CUSTOMERS.CUSTOMER_ID = 2 ;

select * from CUSTOMERS;


SELECT *
FROM CUSTOMERS
ORDER BY FIRST_NAME ASC; -- ASC Default  DESC tersten siralama

-- Müsterileri en küsükten en büyüge dogru sirala
SELECT *
FROM CUSTOMERS
ORDER BY AGE DESC;

-- ÜLKELERI TERSTEN SIRALA VE YASIDA BÜYÜKTEN KÜCÜGE DOGRU SIRALA
SELECT *
FROM CUSTOMERS
ORDER BY country DESC, AGE desc;

-- ULKELERIN ISIMLERINI AL VE KISI SAYISINA GÖRE SIRALA
SELECT COUNTRY, count(*) as Kisi_sayisi   -- lakapsiz da olurdu, lakin böyle daha güzel
FROM CUSTOMERS
GROUP BY COUNTRY   -- her zaman önce gruplama isini bitir !!
ORDER BY Kisi_sayisi;    -- her sey bittikten sonra en son sirala


-- ALMANYAdaki  yasi 20'den büyük müsteriler icin
SELECT COUNTRY , count(*)
FROM CUSTOMERS
WHERE AGE > 20
GROUP BY COUNTRY;
-- HAVING COUNTRY = 'DE';  -- HAVING GRUP SARTI !! SADECE GRUPLA KULLANILIR



-- ülkeleirn isimlerini al
-- kisi sayisina göre tersten sirala
-- yasi 15'denn büyük müsterileri al
-- almanyada olmayan müsteriler

SELECT COUNTRY, count(*) TOTAL
from CUSTOMERS
where age > 15
GROUP BY COUNTRY
HAVING COUNTRY != 'DE'
ORDER BY TOTAL DESC;


-- UPDATE tede bizim SART Kosmamiz lazim, yoksa tüm kayitlari günceller

UPDATE CUSTOMERS
SET FIRST_NAME = 'Hakan' , LAST_NAME = 'Metin'
WHERE CUSTOMERS.CUSTOMER_ID = 3;


select * FROM CUSTOMERS;