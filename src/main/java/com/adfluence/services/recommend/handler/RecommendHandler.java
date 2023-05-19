package com.adfluence.services.recommend.handler;

import com.adfluence.entitiy.Influencer;
import com.adfluence.services.recommend.request.Request;
import com.adfluence.services.influencer.repository.InfluencerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


@Component
public class RecommendHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(RecommendHandler.class);


    private final InfluencerRepository influencerRepository;

    @Autowired
    public RecommendHandler(InfluencerRepository influencerRepository){
        this.influencerRepository = influencerRepository;
    }

    public List<Influencer> handleRecommendation(Request request){

        List<Influencer> influencers = influencerRepository.findAll();

        LOGGER.info("influencers {}", influencers);

        return Collections.emptyList();

    }

}
