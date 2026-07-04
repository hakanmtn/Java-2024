ALTER TABLE IF EXISTS my_company_db.customers
    RENAME "CUSTOMER_ID" TO "CUSTOMER_ID";

ALTER TABLE IF EXISTS my_company_db.customers
    ADD COLUMN "AGE" smallint;

ALTER TABLE IF EXISTS my_company_db.customers
    ADD COLUMN "COUNTRY" character varying(50);

SELECT * FROM my_company_db.CUSTOMERS;

UPDATE my_company_db.CUSTOMERS SET "AGE" = '32', "COUNTRY" = 'DE' WHERE ("CUSTOMER_ID" = '1');
UPDATE my_company_db.CUSTOMERS SET "AGE" = '31', "COUNTRY" = 'TR' WHERE ("CUSTOMER_ID" = '2');
UPDATE my_company_db.CUSTOMERS SET "AGE" = '29', "COUNTRY" = 'USA' WHERE ("CUSTOMER_ID" = '3');
UPDATE my_company_db.CUSTOMERS SET "AGE" = '28', "COUNTRY" = 'DE' WHERE ("CUSTOMER_ID" = '4');
UPDATE my_company_db.CUSTOMERS SET "AGE" = '22', "COUNTRY" = 'FR' WHERE ("CUSTOMER_ID" = '5');

SELECT * FROM my_company_db.CUSTOMERS;