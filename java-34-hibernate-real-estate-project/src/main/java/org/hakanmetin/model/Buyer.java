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
@Table(name = "BUYERS")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyerId;

    @Column(name = "FIRST_NAME")
    private String buyerFirstName;
    @Column(name = "LAST_NAME")
    private String buyerLastName;
    @Column(name = "EMAIL")
    private String buyerEmail;
    @Column(name = "PHONE")
    private String buyerPhone;
    @Column(name = "RATING")
    private float rating;

    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;

    // M    -  M
    //Buyer - Property
    // OneToMany Relation
    @ManyToMany(mappedBy = "buyers", fetch = FetchType.LAZY)
    Set<Property> properties = new HashSet<>();



}
