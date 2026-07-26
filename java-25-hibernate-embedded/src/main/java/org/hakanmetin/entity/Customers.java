package org.hakanmetin.entity;

import jakarta.persistence.*;
import java.util.Date;



//Entity nin bir tablo karsiligi vardir.

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

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREATE")
    private Date createDate;

    /*
    @Column(name = "ADDRESS")
    private String address;
    */
    @Embedded
    public Address address;
    public Customers() {
    }

    public Customers(String first_name, String last_surname) {
        this.first_name = first_name;
        this.last_surname = last_surname;
    }

    public Customers(String first_name, String last_surname, Date createDate) {
        this.first_name = first_name;
        this.last_surname = last_surname;
        this.createDate = createDate;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_surname() {
        return last_surname;
    }

    public void setLast_surname(String last_surname) {
        this.last_surname = last_surname;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customer_id=" + customer_id +
                ", first_name='" + first_name + '\'' +
                ", last_surname='" + last_surname + '\'' +
                '}';
    }
}
