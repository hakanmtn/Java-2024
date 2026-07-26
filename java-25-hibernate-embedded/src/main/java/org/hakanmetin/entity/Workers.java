package org.hakanmetin.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "WORKERS")
public class Workers {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORKER_ID")
    private Integer worker_id;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_surname;

    @FutureOrPresent
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREATE")
    private Date createDate;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @NotNull
    @Size(min = 18, max = 70)
    @Column(name = "AGE")
    private int age;

    @Embedded
    private Address address;


    public Workers() {}

    public Workers(String first_name, String last_surname, Date createDate, String email, String phone, int age) {
        this.first_name = first_name;
        this.last_surname = last_surname;
        this.createDate = createDate;
        this.email = email;
        this.phone = phone;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "worker_id=" + worker_id +
                ", first_name='" + first_name + '\'' +
                ", last_surname='" + last_surname + '\'' +
                ", createDate=" + createDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
