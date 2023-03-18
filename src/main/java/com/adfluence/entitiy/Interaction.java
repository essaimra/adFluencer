package com.adfluence.entitiy;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "INTERACTION")
public class Interaction{


    @Id
    @Column(name = "ID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "INFLUENCER_ID")
    private Influencer influencer;

    @Column(name = "INTERACTION_DATE")
    private Date InteractionDate;

}
