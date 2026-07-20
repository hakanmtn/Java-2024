package org.hakanmetin.entity;

import jakarta.persistence.*;

//POJO Model (Plain Old Java Object) ist ein einfaches Java-Objekt

//Entity nin bir tablo karsiligi vardir.

@Entity
@Table(name = "CUSTOMERS")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    private String first_name;
    private String last_surname;

    public Customers() {
    }

    public Customers(int customer_id, String first_name, String last_surname) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_surname = last_surname;
    }
    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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

    @Override
    public String toString() {
        return "Customers{" +
                "customer_id=" + customer_id +
                ", first_name='" + first_name + '\'' +
                ", last_surname='" + last_surname + '\'' +
                '}';
    }
}
