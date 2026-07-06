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


