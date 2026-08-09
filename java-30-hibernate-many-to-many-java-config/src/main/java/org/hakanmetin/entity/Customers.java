package org.hakanmetin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


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


/*
* Bizim burada yaptigimiz olay, ManyToMany de yeni bir tablo olusturmak ve bu tabloya isim olarak asagidaki
* örnekte "CUSTOMERS_ADDRESSES" verdik. Sonra bu tabloya ManyToMany iliskisi yapacagimiz tablolardan hangi
* kolonlari ekleyecegimizi giriyoruz. Birinci Tablodan bu örnekte "CUSTOMER_ID" yi ikinci
* tablodan da "ADDRESS_ID" yi aldik. (Birincisi joinColumns, ikincisi inverseJoinColumns)
*
*
* */
    // M - M
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "CUSTOMERS_ADDRESSES",
                            joinColumns = {
                                    @JoinColumn (name = "CUSTOMER_ID", nullable = false)
                            },
                            inverseJoinColumns = {
                                    @JoinColumn (name = "ADDRESS_ID", nullable = false)
                            }
        )
    private Set<Address> addresses = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Integer customer_id;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_surname;


    public Customers() {
    }

    public Customers(String first_name, String last_surname) {
        this.first_name = first_name;
        this.last_surname = last_surname;
    }


}

// Coga cokta bir tablo yapiyoruz