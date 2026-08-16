package org.hakanmetin.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
//@DiscriminatorValue("EMPLOYEE")

@Table(name = "EMPLOYEES")
@PrimaryKeyJoinColumn(
        name = "PERSON_ID",
        referencedColumnName = "PERSON_ID"
)
//HIER nur ENTITY und @DiscriminatorValue("EMPLOYEE")  -- SINGLE_TABLE
public class Employee extends Person {


    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "SALARY")
    private int salary;
    @Column(name = "JOIN_DATE")
    private Date joinDate;
    @Column(name = "DEPARTMENT")
    private int department;


    public Employee() {
    }

    public Employee(String firstName, String lastName, String address,  String phone, String email, int salary, Date joinDate, int department) {
        super(firstName, lastName, address);

        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.joinDate = joinDate;
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
