package com.adfluence.influencer.handler;


import com.adfluence.entitiy.Influencer;
import com.adfluence.influencer.request.InfluencerData;
import com.adfluence.repository.InfluencerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InfluencerHandler{

    private final InfluencerRepository influencerRepository;


    @Autowired
    public InfluencerHandler(InfluencerRepository influencerRepository){
        this.influencerRepository = influencerRepository;
    }


    public void addInfluencer(InfluencerData data){

        Influencer influencer = Influencer.builder()
                .influencerId(UUID.randomUUID().toString())
                .name(data.getName())
                .category(data.getCategory())
                .instagramPage(data.getInstagramPage())
                .mail(data.getMail())
                .build();

        influencerRepository.save(influencer);
    }
}
