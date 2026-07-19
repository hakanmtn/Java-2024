package org.hakanmetin._02_crud;


import java.sql.SQLException;


public class AppMain {

    static final String SQL_ALL_CUSTOMERS = "SELECT * FROM my_company_db.customers" ;
    static final String SQL_GREATER_THAN_25 = "SELECT * FROM my_company_db.customers" + " WHERE \"AGE\"  > 25";
    static  final String SQL_CUSTOMER_AGE_UPDATE = "UPDATE my_company_db.customers " +
            "SET " + " \"FIRST_NAME\" = 'Mason', "
            + " \"LAST_NAME\" = 'Greenwood', "
            + " \"AGE\" = 26 ,"
            + "  \"COUNTRY\"  = 'EN' "
            + " WHERE \"CUSTOMER_ID\"  = 10" ;

    static final String SQL_CUSTOMER_ADD_NEW = "INSERT INTO my_company_db.customers( " +
            " \"FIRST_NAME\", \"LAST_NAME\", \"AGE\", \"COUNTRY\", \"EMAIL\", \"GENDER\") " +
            " VALUES ('Nilson', 'Ake', 27, 'EN', 'n.ake@ake.com', 'M')" ;

    static final String SQL_CUSTOMER_DELETE = "DELETE FROM my_company_db.customers WHERE \"CUSTOMER_ID\" = 105";


    public static void main(String[] args) throws SQLException {

        MyCrud myCrud = new MyCrud();

        System.out.println("-------**READ**--------");
        // myCrud.getFromTableAll(SQL_ALL_CUSTOMERS);

        System.out.println("--------------");


       // myCrud.getFromTableGretaterThan25(SQL_GREATER_THAN_25);
        System.out.println("--------------");

        // myCrud.updateCustomerFromID(SQL_CUSTOMER_AGE_UPDATE);

        //myCrud.addNewCustomer(SQL_CUSTOMER_ADD_NEW);

        myCrud.deleteCustomerFromID(SQL_CUSTOMER_DELETE);




    }
}

/*
*NOTIZEN für CRUD Thema
*
*
*Warum braucht man CRUD?
Angenommen, du entwickelst eine Kundenverwaltung. Dann muss die Anwendung typischerweise:
einen Kunden anlegen,
einen Kunden anzeigen,
Kundendaten ändern,
einen Kunden löschen.
Das sind praktisch alle grundlegenden Aktionen, die man mit einem Datensatz ausführt.
*
*
*
*
*
*
*
*
*
*
* */


/*
*
*
*
*
* Für das Verständnis ist der Code in Ordnung.
* In einer echten Anwendung sollte aber nicht die gesamte SQL-Anweisung an die Methode übergeben werden:
*
* z.B.
* myCrud.deleteCustomerById(105);
*
*
*
* public void deleteCustomerById(int customerId) {
    String sql = """
        DELETE FROM my_company_db.customers
        WHERE "CUSTOMER_ID" = ?
        """;

    try (
        Connection connection =
                DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        PreparedStatement statement =
                connection.prepareStatement(sql)
    ) {
        statement.setInt(1, customerId);

        int affectedRows = statement.executeUpdate();

        System.out.println(affectedRows + " Kunde(n) gelöscht.");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
*
* */


/*
*
*
* Das ist aus mehreren Gründen besser:
Der Aufrufer muss kein SQL kennen.
Die Methode kann wiederverwendet werden.
Werte werden sicher über ? eingesetzt.
Verbindung und Statement werden automatisch geschlossen.
*
*
* */

/*Der wichtigste Vorteil von PreparedStatement entsteht erst durch Platzhalter:
*
*String sql = """
    DELETE FROM my_company_db.customers
    WHERE "CUSTOMER_ID" = ?
    """;
* */


/*
*
* Der CRUD-Gedanke bleibt gleich. Nur die technische Umsetzung ändert sich.
Mit JDBC schreibe ich SQL selbst:
*
* String sql = "DELETE FROM customers WHERE id = ?";
statement.setInt(1, id);
statement.executeUpdate();
*
* Mit Hibernate arbeite ich stärker mit Java-Objekten:
*
*Customer customer = entityManager.find(Customer.class, 105);
entityManager.remove(customer);
*
* Hibernate erzeugt daraus ungefähr:
*
* DELETE FROM customers WHERE customer_id = 105;
*
* CRUD gehört also nicht speziell zu Hibernate. Es ist ein allgemeines Konzept. JDBC, Hibernate,
* Spring Data JPA und andere Technologien bieten lediglich unterschiedliche Wege, CRUD umzusetzen.
*
*
*
*
* Der zentrale Gedanke lautet:
CRUD definiert die grundlegenden Aktionen, die meine Anwendung mit dauerhaft gespeicherten Objekten
* oder Datensätzen ausführen kann.
* */




