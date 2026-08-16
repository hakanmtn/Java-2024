package org.hakanmetin.entity;


import jakarta.persistence.*;

@Entity
//@DiscriminatorValue("OWNER")

@Table(name = "OWNERS")
@PrimaryKeyJoinColumn(
        name = "PERSON_ID",
        referencedColumnName = "PERSON_ID"
)
//HIER nur ENTITY und @DiscriminatorValue("OWNER")  -- SINGLE_TABLE
public class Owner extends Person {


    private String title;



    public Owner() {
    }

    public Owner(String firstName, String lastName, String address, String title) {
        super(firstName, lastName, address);
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


/*
* @PrimaryKeyJoinColumn beschreibt, dass der Primärschlüssel der Unterklassentabelle
* gleichzeitig der Fremdschlüssel zur Oberklassentabelle ist.
* */