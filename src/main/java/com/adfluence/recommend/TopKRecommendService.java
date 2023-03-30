package com.adfluence.recommend;

import com.adfluence.customer.request.Request;
import com.adfluence.entitiy.Influencer;
import com.adfluence.repository.InfluencerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;



@Component
public class TopKRecommendService implements RecommendService{

    private final InfluencerRepository influencerRepository;

    @Autowired
    public TopKRecommendService(InfluencerRepository influencerRepository){
        this.influencerRepository = influencerRepository;
    }

    @Override
    public List<Influencer> recommend(Request request) {

        return Collections.emptyList();
    }
}
