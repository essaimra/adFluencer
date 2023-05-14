package com.adfluence.entitiy;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer{

    @Id
    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MAIL")
    private String mail;

}
