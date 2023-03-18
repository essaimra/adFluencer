package com.adfluence.influencer.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class InfluencerData{

    private String name;
    private String mail;
    private String instagramPage;
    private String phone;
    private String category;
}
