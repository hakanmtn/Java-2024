package org.hakanmetin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROPERTIES")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "PROPERTY_NAME")
    private String propertyName;
    @Column(name = "PROPERTY_TYPE")
    private String propertyType;
    @Column(name = "PROPERTY_TITLE")
    private String propertyTitle;
    @Column(name = "PROPERTY_DESCRIPTION")
    private String propertyDescription;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "PRICE")
    private BigDecimal price;

    /*
    private int bedroom;
    private int bathroom;
    private float area;
    */

    // M       -  1
    //Property - Agent
    // ManyToOne Relation
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    // M       -  M
    //Property - Buyer
    // ManyToMany Relation
    @ManyToMany
    @JoinTable(name = "PROPERTIES_BUYERS",
        joinColumns = @JoinColumn(name = "PROPERTY_ID"),
            inverseJoinColumns = @JoinColumn(name = "BUYER_ID"))
    private Set<Buyer> buyers = new HashSet<>();


    /*
    // M       -  1
    //Property - Seller
    // ManyToOne Relation
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

     */
    // 1     -     1
    // Property  - Seller
    // One To One
    @OneToOne
    @JoinColumn
    private Seller seller;
}



