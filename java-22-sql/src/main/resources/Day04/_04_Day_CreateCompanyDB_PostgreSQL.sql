SELECT * FROM my_company_db.CUSTOMERS;

SELECT * FROM my_company_db.categories;

SELECT * FROM my_company_db.products;

SELECT * FROM my_company_db.orders;

SELECT * FROM my_company_db.shippings;

-- JOINLER
SELECT * FROM my_company_db.customers;
SELECT * FROM my_company_db.orders;
-- Join
/*

SELECT Kolonlari_Sec
FROM Soldaki_Tablo_A
JOIN Sagdaki_Tablo_B
ON Sart
*/

-- DEFAULT varsayilan JOIN  -- INNER JOIN (kesisim bölgesi)
-- SIPARIS VEREN MÜSTERILERI GÖSTERIYOR.
SELECT *
    FROM customers c  -- soldaki tablo
    JOIN orders o     -- sagdaki tablo
    ON c."CUSTOMER_ID" = o."CUSTOMER_ID";

-- aynisi
SELECT *
FROM customers c  -- soldaki tablo
        INNER JOIN orders o     -- sagdaki tablo
              ON c."CUSTOMER_ID" = o."CUSTOMER_ID";

-- SADE HALI
SELECT c."CUSTOMER_ID" , c."FIRST_NAME" , c."LAST_NAME" , o."ORDER_ID" , o."ORDER_BRANCH"
FROM customers c  -- soldaki tablo
         JOIN orders o     -- sagdaki tablo
              ON c."CUSTOMER_ID" = o."CUSTOMER_ID";


-- Tutari 4000'den büyük olan siparisleri getir. Müsteri bilgileriyle birlikte listele

 SELECT *
 FROM customers C
 JOIN orders o
 ON C."CUSTOMER_ID" = o."CUSTOMER_ID"
 where o."AMOUNT" > 4000;


-- KAC TANE SIPARIS VAR
SELECT COUNT(*)
from orders ;

-- LEFT JOIN (SOLDAKI TABLOYU OLDUGU GIBI EKLE, SIPARISI OLMAYANLAR TABLODA NULL OLARAK GÖRÜLÜYOR)
SELECT *
FROM customers c
LEFT JOIN orders o
on c."CUSTOMER_ID" = o."CUSTOMER_ID" ;

-- RIGHT JOIN (SAGDAKI TABLOYU OLDUGU GIBI EKLE, SIPARISI OLMAYANLAR TABLODA NULL OLARAK GÖRÜLÜYOR)

-- Burada karar verecgimiz olay su, hangisinin elemani azsa onun joinini yapmak mantikli.
-- Örnegin 1000 müsteri var, 4 siparis var. RIGHT JOIN burada mantikli
-- Mesela Hepsiburada gibi sitede, 1.000.000 müsteri vardir, ortalama 5 tane siparis verseler
-- 5.000.000 milyon siparis yapar. Bu senaryado LEFT JOIN kullanmak mantikli
SELECT *
FROM customers c
         RIGHT JOIN orders o
                   on c."CUSTOMER_ID" = o."CUSTOMER_ID" ;

-- LEFT JOIN SARTLI

SELECT *
FROM customers c
LEFT JOIN orders o
on c."CUSTOMER_ID" = o."CUSTOMER_ID"
WHERE "AMOUNT" > 0;

-- FULL JOIN / FULL OUTER JOIN aynidir.    FULL JOIN → LEFT JOIN + RIGHT JOIN, allerdings werden übereinstimmende Zeilen nicht doppelt,
-- sondern zusammengeführt.
SELECT *
FROM customers c
FULL OUTER JOIN orders o ON c."CUSTOMER_ID" = o."CUSTOMER_ID";

-- burada siparis vermeyen kisileri görüyoruz. B kesisimiyle birlikte dahil degil . A - (A KESISIM B )
-- sol tabloda sag ile eslesmeyen  kac tane kayit var
SELECT COUNT(*)
FROM customers c
LEFT JOIN orders o
ON c."CUSTOMER_ID" = o."CUSTOMER_ID"
WHERE o."ORDER_ID" is NULL;

-- right join ILE
-- sag tabloda sol ile eslesmeyen  kac tane kayit var
SELECT COUNT(*)
FROM customers c
         RIGHT JOIN orders o
                   ON c."CUSTOMER_ID" = o."CUSTOMER_ID"
WHERE c."CUSTOMER_ID" is NULL;


-- BU SEFERDE KESISIM DAHIL DEGIL
SELECT *
FROM customers c
FULL OUTER JOIN orders o
ON c."CUSTOMER_ID" = o."CUSTOMER_ID"
WHERE c."CUSTOMER_ID" is NULL OR o."CUSTOMER_ID" is NULL;


-- VIEW ler (Sanal tablolar)

CREATE VIEW VIEW_INNER_JOIN AS
SELECT c."CUSTOMER_ID" , c."FIRST_NAME" , c."LAST_NAME" , o."ORDER_ID" , o."ORDER_BRANCH"
FROM customers c  -- soldaki tablo
         JOIN orders o     -- sagdaki tablo
              ON c."CUSTOMER_ID" = o."CUSTOMER_ID";

SELECT * FROM VIEW_INNER_JOIN;