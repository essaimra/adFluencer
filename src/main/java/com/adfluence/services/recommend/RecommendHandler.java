package com.adfluence.services.recommend;

import com.adfluence.entitiy.Influencer;
import com.adfluence.services.customer.request.Request;
import com.adfluence.services.influencer.repository.InfluencerRepository;
import com.uber.h3core.H3Core;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

        H3Core h3 = createH3();

        h3.latLngToCellAddress(request.getRegionData().getLatitude(), request.getRegionData().getLongitude(), 0);

        List<Influencer> influencers = influencerRepository.findAll();

        LOGGER.info("influencers {}", influencers);

        LOGGER.info("h3 = {}", h3);

        return Collections.emptyList();

    }

    private H3Core createH3(){
        H3Core h3;
        try {
            h3 = H3Core.newInstance();
        }catch (IOException e){
            LOGGER.error("can't instantiate the H3 service");
            throw new RuntimeException("can't instantiate the H3 service");
        }
        return h3;
    }

}
