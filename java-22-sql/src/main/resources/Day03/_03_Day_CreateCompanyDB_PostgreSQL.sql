SELECT * FROM my_company_db.CUSTOMERS;

-- Her ülkede kac kisi var. Sirala ve yasi 50'dan büyük olanlari ve sayisi 30'dan fazla olanlari al

Select "COUNTRY", COUNT(*)
FROM customers
WHERE "AGE" > 50
GROUP BY "COUNTRY"
HAVING count(*) > 30
ORDER BY count(*) DESC ;

-- COKLU SART - SECILEN ÜLKELERI LISTELE

SELECT * FROM customers
 -- WHERE "COUNTRY" = 'TR'OR "COUNTRY" = 'DE' OR "COUNTRY" = 'CA';
 WHERE "COUNTRY" IN ('TR', 'DE' , 'CA');

-- YASI 18'DEN BÜYÜK 26 'DAM KÜCÜK OLANLAR
SELECT * FROM customers
WHERE "AGE" > 18 AND "AGE" < 26;

-- % den sonra ne olursa getiriyor
SELECT * FROM customers
where "FIRST_NAME" like 'Ah%';


-- sonunda er olanlar
SELECT * FROM customers
where "FIRST_NAME" like '%er';


-- MAx yasi en büyük ve en MIN en kücük olan müsteri

SELECT MAX("AGE") , MIN("AGE") from customers;

-- Yasi 22'den büyük olanlar
SELECT * FROM customers
where "AGE" > 22;

-- en kücük kisinin yasini bul ve kolonlariyla birlikte göster // esneklik sagliyor ic ice

SELECT * FROM customers
where "AGE" = (select min("AGE") from customers) and "COUNTRY" = 'CZ';

-- baska bir versiyonu
select * from customers
order by "AGE" LIMIT 1 ;

-- kac tane farkli ülke var

SELECT count(distinct "COUNTRY") FROM CUSTOMERS;

-- HER ÜLKEDEN KAC KISI VAR
SELECT "COUNTRY" , count(*) from customers
group by "COUNTRY";

-- HER ÜLKEDEN KAC KISI VAR büyükten kücüge dogru sirala
SELECT "COUNTRY" , count(*) from customers
group by "COUNTRY"
order by count(*) desc;


-- icinde e gecenleri getir ama h gecenleri getirme
SELECT * from customers
where "FIRST_NAME" like '%e%' AND "FIRST_NAME" NOT like '%h%';

--