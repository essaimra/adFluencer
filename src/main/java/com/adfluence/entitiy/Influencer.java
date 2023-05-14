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
@Table(name = "INFLUENCER")
public class Influencer{

    @Id
    @Column(name = "INFLUENCER_ID")
    private String influencerId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "INSTAGRAM_PAGE")
    private String instagramPage;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "RATING")
    private int rating;


}
