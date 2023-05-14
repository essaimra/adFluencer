package com.adfluence.influencer.handler;


import com.adfluence.entitiy.Influencer;
import com.adfluence.influencer.request.InfluencerData;
import com.adfluence.repository.InfluencerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class InfluencerHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(InfluencerHandler.class);
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
                .phone(data.getPhone())
                .rating(0)
                .build();

        LOGGER.info("going to save influencer {}", influencer);

        influencerRepository.save(influencer);
    }


    public Influencer getInfluencerByPhone(String phone){
        LOGGER.info("going to fetch influencer by phone {}", phone);

        return influencerRepository.findByPhone(phone);
    }

    public List<Influencer> getInfluencerByName(String name){

        LOGGER.info("going to fetch influencer by name {}", name);

        return influencerRepository.findByName(name);
    }
}
