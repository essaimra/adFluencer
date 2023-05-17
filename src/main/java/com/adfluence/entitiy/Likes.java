package com.adfluence.entitiy;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name = "LIKES")
public class Likes{

    @Id
    @Column(name = "LIKES_ID")
    private String likesId;

    @Column(name = "CUSTOMER_ID")
    private String customerId;


    @Column(name = "INFLUENCER_ID")
    private String influencerId;
}
