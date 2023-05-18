package com.adfluence.entitiy;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name = "LIKES")
public class Likes{

    @Id
    @Column(name = "LIKE_ID")
    private String likeId;

    @Column(name = "CUSTOMER_ID")
    private String customerId;


    @Column(name = "INFLUENCER_ID")
    private String influencerId;
}
