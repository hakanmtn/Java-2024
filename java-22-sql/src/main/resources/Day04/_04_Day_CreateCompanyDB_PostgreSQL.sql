
select * from my_company_db.customers;


select * from my_company_db.categories;

select * from my_company_db.products;


select * from my_company_db.orders;

select * from my_company_db.shippings;

/*
LEFT JOIN- SOLDAKI TABLO KOMPLE DAHIL, SAGDAKI TABLO SADECE KESISIMDE DAHIL
soldaki tabloyu önce yaziyoruz.
Hangisine öncelik veriyorsak

Mesela bu ikisini birlestirecegiz
select * from my_company_db.customers; sol tarafa
select * from my_company_db.orders;    sag tarafa


SELECT KOLONLARI_SEC
FROM SOLDAKI_TABLO_A A
JOIN SAGDAKI_TABLO_B B
ON  SART


varsayilan JOIN = INNER JOIN dir. Iki kümede de ortak olanlari alir. KESISIM
*/

SELECT *
FROM my_company_db.customers -- Soldaki Tablo
JOIN my_company_db.orders --Sagdaki Tablo   INNER JOIN - VARSAYILAN JOIN dir.
ON customers."CUSTOMER_ID" = orders."CUSTOMER_ID";  -- Bedingung


--
SELECT *
FROM customers C -- Soldaki Tablo
         JOIN orders O  --Sagdaki Tablo   INNER JOIN - VARSAYILAN JOIN dir.
              ON C."CUSTOMER_ID" = O."CUSTOMER_ID";

-- Tablolar icin lakap Kullanimi
SELECT cus."CUSTOMER_ID" , cus."FIRST_NAME", cus."LAST_NAME", ord."ORDER_ID", ord."CUSTOMER_ID", ord."ORDER_BRANCH"
FROM customers Cus -- Soldaki Tablo
JOIN orders Ord  --Sagdaki Tablo   INNER JOIN - VARSAYILAN JOIN dir.
ON Cus."CUSTOMER_ID" = Ord."CUSTOMER_ID";  -- Bedingung

-- Kolonlar icin lakap Kullanimi
SELECT cus."CUSTOMER_ID" c_cusid , cus."FIRST_NAME", cus."LAST_NAME", ord."CUSTOMER_ID" o_cusid, ord."ORDER_BRANCH"
FROM customers Cus -- Soldaki Tablo
         JOIN orders Ord  --Sagdaki Tablo   INNER JOIN - VARSAYILAN JOIN dir.
              ON Cus."CUSTOMER_ID" = Ord."CUSTOMER_ID";

-- Kolonlar icin lakap Kullanimi
SELECT c."CUSTOMER_ID" c_cusid , c."FIRST_NAME", c."LAST_NAME", o."CUSTOMER_ID" o_cusid, o."ORDER_BRANCH"
FROM customers c -- Soldaki Tablo
         JOIN orders o  --Sagdaki Tablo   INNER JOIN - VARSAYILAN JOIN dir.
              ON c."CUSTOMER_ID" = o."CUSTOMER_ID";

-- Kolonlar icin lakap Kullanimi ISTEDIGIMIZ SEKILDE KOLANLARIN YERLERINI AYARLAYABILIRIZ
-- AMA SAGDAKI TABLO SAGDA, SOLDAKI TABLO SOLDA KALMALI
SELECT o."CUSTOMER_ID" o_cusid, o."ORDER_BRANCH", c."CUSTOMER_ID" c_cusid , c."FIRST_NAME", c."LAST_NAME"
FROM customers c -- Soldaki Tablo
         JOIN orders o  --Sagdaki Tablo   INNER JOIN - VARSAYILAN JOIN dir.
              ON c."CUSTOMER_ID" = o."CUSTOMER_ID";

-- TUTARI 4000 DEN BÜYÜK OLAN SIPARISLERI MÜSTERI BILGILERIYLE LISTELE
SELECT c."CUSTOMER_ID" c_cusid , c."FIRST_NAME" c_fname, c."LAST_NAME" c_lname, o."CUSTOMER_ID" o_cusid, o."ORDER_BRANCH" o_branch
FROM customers c -- Soldaki Tablo

         JOIN orders o  --Sagdaki Tablo   INNER JOIN - VARSAYILAN JOIN dir.
              ON c."CUSTOMER_ID" = o."CUSTOMER_ID" and o."AMOUNT" > 4000;


-- TUTARI 4000 DEN BÜYÜK OLAN SIPARISLERI MÜSTERI BILGILERIYLE LISTELE
SELECT c."CUSTOMER_ID" c_cusid , c."FIRST_NAME" c_fname, c."LAST_NAME" c_lname, o."CUSTOMER_ID" o_cusid, o."ORDER_BRANCH" o_branch
FROM customers c -- Soldaki Tablo

         JOIN orders o  --Sagdaki Tablo   INNER JOIN - VARSAYILAN JOIN dir.
              ON c."CUSTOMER_ID" = o."CUSTOMER_ID"
where "AMOUNT" > 4000;

-- Kac Müsterimiz var
SELECT count(*)
from customers;

-- Kac tane siparis var
SELECT count(*)
from orders;

--  LEFT JOIN YAPICAGIZ
-- 1. Tabloyu full dahil et. Soldaki Tabloyu full dahil et, eslesmeyenler, NULL oluyor. siparisi olmayan müsteriler
-- Bize ilk basta eslesenleri getiriyor, sonra geri kalanlar komple null olanlar
-- En az kimse ona git, sol tabela daki daten azsa sagdakinden o zaman left join
Select *
FROM my_company_db.customers
left join my_company_db.orders o on customers."CUSTOMER_ID" = o."CUSTOMER_ID";

-- RIGHT JOIN DE
Select *
FROM my_company_db.customers  --soldaki tablo
         RIGHT join my_company_db.orders o -- sagdaki tablo
             on customers."CUSTOMER_ID" = o."CUSTOMER_ID";

-- left join ile sartli. Tutari 0' dan büyük olanlar.
Select *
FROM my_company_db.customers
         left join my_company_db.orders o
             on customers."CUSTOMER_ID" = o."CUSTOMER_ID"
where "AMOUNT" > 0;

-- right join ile sartli. Tutari 0' dan büyük olanlar.
Select *
FROM my_company_db.customers
         right join my_company_db.orders o
                   on customers."CUSTOMER_ID" = o."CUSTOMER_ID";

/*
 LEFT JOIN ILE RIGHT JOIN TABLOLARIN KAYIT SAYISI ILE ILGILIDIR. SAG -SOL KAVRAMI KAYITLARA GÖRE
 KULLANILIR. IKI FARKLI KÜME GIBI DÜSÜNMEMIZ LAZIM.
*/


-- FULL JOIN ILE ->> HEPSINI ESLESTIRIYOR
/*
    FULL JOIN HANGI TABELANIN SAYISI COKSA  O KADAR VERI GETIRIR. Hepsini dahil ediyor.
*/
Select *
FROM my_company_db.customers c
         FULL OUTER JOIN my_company_db.orders o --FULL JOIN/ FULL OUTER JOIN -->  SAME
                    on c."CUSTOMER_ID" = o."CUSTOMER_ID";

-- FULL JOIN ILE ->> HEPSINI ESLESTIRIYOR

-- count
Select count(*)
FROM my_company_db.customers c
         FULL OUTER JOIN my_company_db.orders o --FULL JOIN/ FULL OUTER JOIN -->  SAME
                         on c."CUSTOMER_ID" = o."CUSTOMER_ID";
/*
    FULL JOIN HANGI TABELANIN SAYISI COKSA  O KADAR VERI GETIRIR. Hepsini dahil ediyor.
*/
Select c."CUSTOMER_ID", c."FIRST_NAME" fname, c."LAST_NAME" lname, o."CUSTOMER_ID", o."ORDER_BRANCH",o."ORDER_DATE",o."AMOUNT"
FROM my_company_db.customers c
         FULL JOIN my_company_db.orders o --FULL JOIN/ FULL OUTER JOIN -->  SAME
                         on c."CUSTOMER_ID" = o."CUSTOMER_ID";


-- left join ile sartli. A-B de eslesmeyenleri cikariyor.
/*
A KÜMESI VE B KÜMESINDEN SADECE A KÜMESINI GETIRIYOR, KESISIM VE B YI GETIRMIYOR. GELENLERDE SADECE NULL DEGERE
SAHIP OLAN VERILER. A KÜMESINDE B ILE ESLESEN ELEMANLAR DAHIL DEGILLER
aslinda kac tane gereksiz elimizde NULL var, onlari görmek istiyoruz.
SOL TABLODA -- SAG TABLODA ESLESMEYEN ELEMANLARI BULUYORUZ.


HIC ALIS-VERIS YAPMAMIS/ SIPARIS VERMEMIS MÜSTERILERI BULABILIRIZ
*/
Select *
FROM my_company_db.customers
         left join my_company_db.orders o
                   on customers."CUSTOMER_ID" = o."CUSTOMER_ID"
where o."CUSTOMER_ID" is null;

-- RIGHT JOIN SADECE B DE NULL Olanlar - SOL ILE ESLESMEYEN KAC TANE KAYIT VAR?
Select *
FROM my_company_db.customers c
         right join my_company_db.orders o
                   on c."CUSTOMER_ID" = o."CUSTOMER_ID"
where c."CUSTOMER_ID" is null;

-- FULL JOIN GIBI AMA KESISIMLERI YOK
Select c."CUSTOMER_ID", c."FIRST_NAME" fname, c."LAST_NAME" lname, o."CUSTOMER_ID", o."ORDER_BRANCH",o."ORDER_DATE",o."AMOUNT"
FROM my_company_db.customers c
         FULL JOIN my_company_db.orders o --FULL JOIN/ FULL OUTER JOIN -->  SAME
                   on c."CUSTOMER_ID" = o."CUSTOMER_ID"
WHERE c."CUSTOMER_ID" is null or o."CUSTOMER_ID" is null;

--count
Select count(*)
FROM my_company_db.customers c
         FULL JOIN my_company_db.orders o --FULL JOIN/ FULL OUTER JOIN -->  SAME
                   on c."CUSTOMER_ID" = o."CUSTOMER_ID"
WHERE c."CUSTOMER_ID" is null or o."CUSTOMER_ID" is null;


-- VIEW LER
-- Dikkat edilmesi gereken nokta burada kesinlikle sütun isimleri cakismamali, yoksa view olusmuyor, hata veriyor
-- Büyük sorgulari biz viewlerle sadelestiriyoruz.
CREATE VIEW contact AS
SELECT
    "FIRST_NAME",
    "LAST_NAME",
    "EMAIL"
FROM customers;

SELECT * FROM contact;

-- kesisen ORTAK KAYITLAR / INNER JOIN ILE VIEW
CREATE VIEW KESISEN_ORTAK_KAYITLAR AS  -- Sütunlarda cakisma olmamasina dikkat etmemiz lazim.
SELECT C."CUSTOMER_ID" c_cusid, c."FIRST_NAME", c."LAST_NAME" , o."CUSTOMER_ID" o_cusid, o."ORDER_BRANCH"
FROM my_company_db.customers C -- Soldaki Tablo
         JOIN my_company_db.orders O  --Sagdaki Tablo   INNER JOIN - VARSAYILAN JOIN dir.
              ON C."CUSTOMER_ID" = O."CUSTOMER_ID";

select * from KESISEN_ORTAK_KAYITLAR;

-- LEFT JOIN ILE
CREATE VIEW LEFT_JOIN_CUSTOMER_ORDER AS
Select C."CUSTOMER_ID" c_cusid, c."FIRST_NAME", c."LAST_NAME" , o."CUSTOMER_ID" o_cusid, o."ORDER_BRANCH"
FROM my_company_db.customers c
         left join my_company_db.orders o
                   on c."CUSTOMER_ID" = o."CUSTOMER_ID"
where o."CUSTOMER_ID" is null;

select * from LEFT_JOIN_CUSTOMER_ORDER;

-- RIGHT JOIN ILE VIEW
-- isimlendirmelerde GET VEYA VIEW ÖN KELIMESI KULLANMAK IYIDIR
CREATE VIEW GET_RIGHT_JOIN_CUSTOMER_ORDER AS
SELECT cus."CUSTOMER_ID" c_cusid, cus."FIRST_NAME", cus."LAST_NAME", ord."CUSTOMER_ID" o_cusid, ord."ORDER_BRANCH"
FROM customers cus
right join orders ord
on cus."CUSTOMER_ID" = ord."CUSTOMER_ID";

select * from GET_RIGHT_JOIN_CUSTOMER_ORDER;


-- LEFT JOIN ILE view get
CREATE VIEW GET_LEFT_JOIN_CUSTOMER_ORDER AS
Select C."CUSTOMER_ID" c_cusid, c."FIRST_NAME", c."LAST_NAME" , o."CUSTOMER_ID" o_cusid, o."ORDER_BRANCH"
FROM my_company_db.customers c
         left join my_company_db.orders o
                   on c."CUSTOMER_ID" = o."CUSTOMER_ID"
where o."CUSTOMER_ID" is null;

select * from LEFT_JOIN_CUSTOMER_ORDER;

-- INDEX HIZLI ARAMA YAPMAK ICINDIR
-- HER SEYE INDEK VERILMEZ SADCE EN COK KULLANDIGIMIZ KOLONA GÖRE, YOKSA YAVASLAR
SELECT * FROM customers;

-- örnegin müsterilerin mailini göre yapiyorsak.
-- Indexi bir dogrudan calistiriyorsun, sonra arkada calisiyor.
-- COk sik vveri girisi olan tablolarda da kulanilmaz
-- Arsivle ilgili tablolarda kullanilabilir.

CREATE INDEX IDX_CUSTOMERS_EMAIL
ON customers ("EMAIL");

SELECT * FROM customers
where "EMAIL" = 'klanegranrr@github.io'; -- cift tirnak degil, tek tirnak olmak zorunda

DROP INDEX IDX_CUSTOMERS_EMAIL;
