package org.hakanmetin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Orders {

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
        @JoinColumn(name = "CUSTOMER_ID")
    @ToString.Exclude
    private Customers customer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    @ToString.Exclude
    private int orderId;

    @Column(name = "PRODUCT_NAME" , length = 150)
    private String productName;

    @Column(name = "PRODUCT_CODE" , length = 50)
    private String productCode;

    @Column(name = "AMOUNT", precision = 10, scale = 2)
    private BigDecimal productPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CREATE", length = 40)
    private Date createDate;



}
