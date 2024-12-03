-- VERITABANI DB OLUSTURULDU
CREATE SCHEMA my_company_db
    AUTHORIZATION postgres;

-- MUSTERILER TABLOSU OLUSTURULDU
CREATE TABLE my_company_db.customers
(
    "ID" serial NOT NULL,
    "FIRST_NAME" character varying(60),
    "LAST_NAME" character varying(60),
    PRIMARY KEY ("ID")
);

ALTER TABLE IF EXISTS my_company_db.customers
    OWNER to postgres;

-- PRODUCT TABLOSU OLUSTURULDU
CREATE TABLE my_company_db.products
(
    "ID" smallserial NOT NULL,
    "PROD_NAME" character varying(200),
    "PROD_CODE" character varying(45),
    PRIMARY KEY ("ID")
);

ALTER TABLE IF EXISTS my_company_db.products
    OWNER to postgres;

-- Müsteri tablosuna kayitlar eklendi
INSERT INTO my_company_db.CUSTOMERS ("FIRST_NAME", "LAST_NAME") VALUES ('Hakan', 'Metin');
INSERT INTO my_company_db.CUSTOMERS ("FIRST_NAME", "LAST_NAME") VALUES ('Natalie', 'Weiss');
INSERT INTO my_company_db.CUSTOMERS ("FIRST_NAME", "LAST_NAME") VALUES ('Martin', 'Lol');


-- MUSTERILERI LISTELE GÖSTER
SELECT * FROM my_company_db.customers;

-- Sadece 1 Kayit
INSERT INTO my_company_db.CUSTOMERS
(
    "FIRST_NAME","LAST_NAME")
VALUES('Axel', 'Hausmann');

-- Sadece 1 Kayit
INSERT INTO my_company_db.CUSTOMERS
("FIRST_NAME","LAST_NAME")
VALUES('Leonardo', 'Kimmy');

-- MUSTERILERI LISTELE GÖSTER
SELECT * FROM my_company_db.CUSTOMERS;


-- TABLOYA 2 TANE YENI KOLON EKLEDIK VE 3 KOLON ÜZERINDE DEGISIKLIK YAPILDI
ALTER TABLE IF EXISTS my_company_db.customers
    RENAME "ID" TO "CUSTOMER_ID";

ALTER TABLE my_company_db.customers
    ALTER COLUMN "FIRST_NAME" TYPE character varying(70) COLLATE pg_catalog."default";

ALTER TABLE my_company_db.customers
    ALTER COLUMN "LAST_NAME" TYPE character varying(75) COLLATE pg_catalog."default";

ALTER TABLE IF EXISTS my_company_db.customers
    ADD COLUMN "AGE" smallint;

ALTER TABLE IF EXISTS my_company_db.customers
    ADD COLUMN "COUNTRY" character varying(65);


-- TABLODA YENI EKLENEN KOLONLARA DEGER GIRILDI
UPDATE my_company_db.CUSTOMERS SET "AGE" = '29', "COUNTRY" = 'TR' WHERE ("CUSTOMER_ID" = '1');
UPDATE my_company_db.CUSTOMERS SET "AGE" = '32', "COUNTRY" = 'DE' WHERE ("CUSTOMER_ID" = '2');
UPDATE my_company_db.CUSTOMERS SET "AGE" = '23', "COUNTRY" = 'BR' WHERE ("CUSTOMER_ID" = '3');
UPDATE my_company_db.CUSTOMERS SET "AGE" = '35', "COUNTRY" = 'USA' WHERE ("CUSTOMER_ID" = '4');
UPDATE my_company_db.CUSTOMERS SET "AGE" = '38', "COUNTRY" = 'BR' WHERE ("CUSTOMER_ID" = '5');

-- MUSTERILERI LISTELE GÖSTER
SELECT * FROM my_company_db.CUSTOMERS;


-- FIRST_NAME AND LAST_NAME
SELECT "CUSTOMER_ID","FIRST_NAME", "LAST_NAME" FROM my_company_db.CUSTOMERS;