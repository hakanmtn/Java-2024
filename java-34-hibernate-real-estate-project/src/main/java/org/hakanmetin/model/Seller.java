package org.hakanmetin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SELLERS")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sellerId;

    @Column(name = "FIRST_NAME")
    private String sellerFirstName;
    @Column(name = "LAST_NAME")
    private String sellerLastName;
    @Column(name = "EMAIL")
    private String sellerEmail;
    @Column(name = "PHONE")
    private String sellerPhone;


    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;

    /*
    // 1    -  M
    //Seller - Property
    // OneToMany Relation
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    private Set<Property> properties = new HashSet<>();
    */

    // 1     -     1
    // Seller  - Property
    // One To One
    @OneToOne(mappedBy = "seller",
    cascade = CascadeType.ALL)
    private Property property;


}
