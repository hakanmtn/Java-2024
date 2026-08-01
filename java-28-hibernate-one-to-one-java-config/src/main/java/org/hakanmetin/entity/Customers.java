package org.hakanmetin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/*
*Das ist eine bidirektionale One-to-One-Beziehung:
* Mit @MapsId handelt es sich genauer um eine One-to-One-Beziehung mit gemeinsamem Primärschlüssel:
*
*Jeder Kunde kann damit höchstens ein CustomerDetail haben,
* und jedes CustomerDetail gehört genau zu einem Kunden.
*
*
 */


//Entity nin bir tablo karsiligi vardir.


@Getter @Setter @ToString
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Integer customer_id;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_surname;

    /*
     * "customer" ist der Java-Feldname in CustomerDetail.
     * mappedBy verweist nicht auf den Datenbank-Spaltennamen.
     *
     *
     * Bei einer bidirektionalen Beziehung muss mappedBy
     * exakt den Java-Attributnamen der besitzenden Seite enthalten.
     * Die Jakarta-Persistence-Spezifikation verlangt,
     * dass mappedBy auf das Beziehungsattribut der besitzenden Seite verweist
     *
     */


    @OneToOne(mappedBy ="customer",
              fetch = FetchType.LAZY,
              cascade = CascadeType.ALL,
              orphanRemoval = true)
    @ToString.Exclude
    private CustomerDetail customerDetail;

    public Customers() {
    }

    public Customers(String first_name, String last_surname) {
        this.first_name = first_name;
        this.last_surname = last_surname;
    }

    /*
     * Hilfsmethode, damit beide Seiten der Beziehung
     * automatisch gesetzt werden.
     */
    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
        if (customerDetail != null) {
            customerDetail.setCustomer(this);
        }
    }


}
