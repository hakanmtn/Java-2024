package org.hakanmetin.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONS")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "PERSON_TYPE") //SINGLE_TABLE
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private Long personId;

   @Column(name = "FIRST_NAME")
    private String firstName;

   @Column(name = "LAST_NAME")
    private String lastName;

   @Column(name = "ADDRESS")
    private String address;

    public Person() {
    }
    public Person(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


/*
*
* Weil @Id direkt auf dem Feld steht, verwendet Hibernate hier Field Access.
*  Die Getter und Setter sind weiterhin sinnvoll, aber Hibernate greift
* für das Mapping direkt auf die Felder zu.
* */