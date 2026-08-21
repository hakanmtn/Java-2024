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
@Table(name = "AGENTS")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int agentId;

    @Column(name = "FIRST_NAME")
    private String agentFirstName;
    @Column(name = "LAST_NAME")
    private String agentLastName;
    @Column(name = "EMAIL")
    private String agentEmail;
    @Column(name = "PHONE")
    private String agentPhone;
    @Column(name = "RATING")
    private float rating;



    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "OFFICE_ADDRESS")
    private String officeAddress;

    // 1    -  M
    //Agent - Property
    // OneToMany Relation
    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
    Set<Property> properties = new HashSet<>();


}
