package com.adfluence.services.recommend.services;

import com.adfluence.entitiy.Influencer;
import com.adfluence.services.recommend.request.Request;

import java.util.List;

public interface RecommendService{

    List<Influencer> recommend(Request request);

}
