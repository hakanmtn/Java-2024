
select * from my_company_db.customers;

-- Her ülkede kac kisi var
-- TERSTEN SIRALA VE SAYISI 30 DAN BÜYÜK OLANLAR
select "COUNTRY", COUNT(*) KISI_SAYISI
from my_company_db.customers
GROUP BY "COUNTRY"
HAVING COUNT(*) > 30   -- HAVING KISMINDA ALIAS A IZIN VERMIYOR . cünkü
-- HAVING SELECT DEN ÖNCE CALISIYOR .
-- FROM > WHERE > GROUP BY > HAVING > SELECT > ORDER BY
ORDER BY KISI_SAYISI DESC;


-- Her ülkede kac kisi var
-- TERSTEN SIRALA VE SAYISI 30 DAN COK OLAN VE YASI 25'TEN BÜYÜK OLAN
-- MÜSTERILERI GRUPLAYIP GÖSTER

select "COUNTRY", COUNT(*) KISI_SAYISI
from my_company_db.customers
WHERE "AGE" > 25
GROUP BY "COUNTRY"
HAVING COUNT(*) > 30   -- HAVING KISMINDA ALIAS A IZIN VERMIYOR . cünkü
-- HAVING SELECT DEN ÖNCE CALISIYOR .
-- FROM > WHERE > GROUP BY > HAVING > SELECT > ORDER BY
ORDER BY KISI_SAYISI DESC;

-- COKLU SART - SECILEN ÜLKELERI LISTELE
SELECT * FROM my_company_db.customers
WHERE "COUNTRY" = 'TR'  OR
      "COUNTRY" = 'DE'  OR
      "COUNTRY" = 'CA'  OR
      "COUNTRY" = 'RU' ;

-- COKLU SART - SECILEN ÜLKELERI LISTELE

SELECT * FROM my_company_db.customers
WHERE "COUNTRY" IN ('TR','DE', 'CA', 'RU');

-- COKLU SART - SECILEN ÜLKELERI LISTELEME

SELECT * FROM my_company_db.customers
WHERE "COUNTRY" NOT IN ('TR','DE', 'CA', 'RU');

-- YASI 18 DEN BÜYÜK VE 26 DAN KÜCÜK OLANLARI LISTELE
SELECT * FROM my_company_db.customers
WHERE "AGE" > 18 AND "AGE" < 26;

-- YASI 18 DEN BÜYÜK VE 26 DAN KÜCÜK OLANLARI LISTELE DAHILLER
SELECT * FROM my_company_db.customers
WHERE "AGE" >= 18 AND "AGE" <= 26;

-- YASI 18 DEN BÜYÜK VE 26 DAN KÜCÜK OLANLARI LISTELE DAHILLER
SELECT * FROM my_company_db.customers
WHERE "AGE" between 18 and 26;

-- YASI 18  VE 26 arasinda OLMAYANLARI LISTELE DAHILLER
SELECT * FROM my_company_db.customers
WHERE "AGE" NOT between 18 and 26;

-- SECILEN ISIMLERE GÖRE LISTELE
SELECT * FROM my_company_db.customers
WHERE "FIRST_NAME" = 'Hakan';

-- ADINDA A ILE BASLAYANLARI GETIR
SELECT * FROM my_company_db.customers
WHERE "FIRST_NAME" LIKE 'A%';

-- ADINDA a HARFI OLANLARI  GETIR
SELECT * FROM my_company_db.customers
WHERE "FIRST_NAME" LIKE '%a%';

-- ADINin sonunda er HARFI OLANLARI  GETIR
SELECT * FROM my_company_db.customers
WHERE "FIRST_NAME" LIKE '%er%';

-- Icinde kücük a gecenleri getir ama büyük A gecenleri getirme

SELECT * FROM my_company_db.customers
WHERE "FIRST_NAME" LIKE '%a%' and "FIRST_NAME" not like '%A%';

-- Lakap kullanimi

Select c."CUSTOMER_ID", C."FIRST_NAME" , c."LAST_NAME", "AGE" , c."COUNTRY"
    FROM my_company_db.customers AS c;

Select c."CUSTOMER_ID", C."FIRST_NAME" , c."LAST_NAME", "AGE" , c."COUNTRY"
FROM my_company_db.customers as c;

Select c."CUSTOMER_ID", C."FIRST_NAME" , c."LAST_NAME", "AGE" , c."COUNTRY"
FROM my_company_db.customers  c;

-- MAX YASI EN BÜYÜK OLAN MÜSTERI
SELECT max("AGE"), min("AGE"), sum("AGE"), count("AGE"),avg("AGE") FROM my_company_db.customers;



SELECT max("FIRST_NAME"), MIN("LAST_NAME") FROM my_company_db.customers;

-- SARTLI SORGU
SELECT *
FROM my_company_db.customers
WHERE "AGE" > 22;

-- SARTLI SORGU EN KÜCÜK KISIYI BUL VE KOLONLARIYLA BIRLIKTE GÖSTER

SELECT MIN("AGE")
    FROM my_company_db.customers;

SELECT * FROM my_company_db.customers
where "AGE" = 22;

-- 22 TARAFINI ESNEK YAPMAMIZ LAZIM

SELECT * from my_company_db.customers
where "AGE" = (
    SELECT MIN("AGE") FROM  my_company_db.customers

    );

SELECT *
FROM my_company_db.customers
ORDER BY "AGE" LIMIT 1;

-- KAC TANE MÜSTERIMIZ VAR
SELECT COUNT(*) FROM my_company_db.customers;

-- KAC TANE MÜSTERIMIZ VAR
SELECT COUNT(*) as MUSTERI_SAYISI FROM my_company_db.customers;

SELECT COUNT(*) MUSTERI_SAYISI FROM my_company_db.customers;

SELECT COUNT(*) as "MUSTERI SAYISI" FROM my_company_db.customers;

-- ÜLKESI TR OLANLARIN SAYISI
SELECT COUNT(*) as "MUSTERI SAYISI" FROM my_company_db.customers
WHERE "COUNTRY" = 'TR';

-- ÜLKESI tr OLANLARIN SAYISI
SELECT COUNT(*) as "MUSTERI SAYISI" FROM my_company_db.customers
WHERE "COUNTRY" = 'tr';
-- ÜLKESI Tr OLANLARIN SAYISI
SELECT COUNT(*) as "MUSTERI SAYISI" FROM my_company_db.customers
WHERE "COUNTRY" = 'Tr';

-- kac tane ülke var
select  count(distinct "COUNTRY") FROM my_company_db.customers; -- distinct "COUNTRY" nin önüne geliyor

-- her ülkeden kac kisi var
select "COUNTRY",  count(*) from my_company_db.customers
group by "COUNTRY";

-- her ülkeden kac kisi var - siralama en büyükten kücüge
select "COUNTRY",  count(*) from my_company_db.customers
group by "COUNTRY"
order by count(*) desc;

-- her ülkeden kac kisi var - siralama en büyükten kücüge
select "COUNTRY",  count(*) TOTAL_CUSTOMER from my_company_db.customers
group by "COUNTRY"
order by TOTAL_CUSTOMER desc;

ALTER TABLE IF EXISTS my_company_db.orders
    ADD FOREIGN KEY ("PRODUCT_ID")
        REFERENCES my_company_db.products ("PRODUCT_ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;