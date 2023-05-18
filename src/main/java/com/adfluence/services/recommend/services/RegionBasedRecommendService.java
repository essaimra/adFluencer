package com.adfluence.services.recommend.services;

import com.adfluence.entitiy.Influencer;
import com.adfluence.services.recommend.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RegionBasedRecommendService implements RecommendService{

    @Autowired
    public RegionBasedRecommendService(){

    }

    @Override
    public List<Influencer> recommend(Request request) {
        return null;
    }
}
