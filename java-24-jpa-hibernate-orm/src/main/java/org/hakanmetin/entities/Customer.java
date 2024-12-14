package org.hakanmetin.entities;


import jakarta.persistence.*;

//POJO  Model - Siradan bir kalip --> Entity

/*
* ENTITY VE MODEL IN FARKI
*
*Modeller tabloya eslenmez yani haritalanmaz
*Yani biz gidipte model sinifini tabloya eslemiyoruz
*
*Ama Entity nin bir tablo karsiligi vardir.
*Gidip datenbankta kendisi tablosyu olusturuyor.
* Entity model + tabloya esleme
*
* */

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    /*
    * id
    * firstName
    * lastName
    *
    *
    *
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int id;

    @Column(name = "FIRST_NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    public Customer() {
    }

    public Customer(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
