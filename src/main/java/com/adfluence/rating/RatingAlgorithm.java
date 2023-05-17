package com.adfluence.rating;


import com.adfluence.influencer.handler.InfluencerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is the component that responsible for Rating Algorithm for Influencers
 * */
@Component
public class RatingAlgorithm implements IAlgorithm{

    private final InfluencerHandler influencerHandler;

    @Autowired
    public RatingAlgorithm(InfluencerHandler influencerHandler){
        this.influencerHandler = influencerHandler;
    }

    public void rate(){

    }

}
