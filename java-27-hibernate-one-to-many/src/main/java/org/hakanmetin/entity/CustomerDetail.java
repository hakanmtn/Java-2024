package org.hakanmetin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;



@Getter
@Setter
@ToString
@AllArgsConstructor

@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerDetail {

    @Id
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

    /*
     * CUSTOMER_ID ist gleichzeitig:
     * - Primary Key von CUSTOMER_DETAILS
     * - Foreign Key zu CUSTOMERS
     */
    @MapsId //sagt Hibernate, dass CustomerDetail.customerId aus customer.customerId übernommen wird.
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID")
    @ToString.Exclude
    private Customers customer;

    private String address;
    private String phone;
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREATE")
    private Date createDate;

    public CustomerDetail() {
    }

}
