package com.adfluence.services.influencer.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class InfluencerData{

    private String name;
    private String mail;
    private String instagramPage;
    private String phone;
    private String category;
    private String country;
    private String city;
}
