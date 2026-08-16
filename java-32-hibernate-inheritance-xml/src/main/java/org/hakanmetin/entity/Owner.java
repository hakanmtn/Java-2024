package org.hakanmetin.entity;



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
