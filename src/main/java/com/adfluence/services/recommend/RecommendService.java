package com.adfluence.services.recommend;

import com.adfluence.services.customer.request.Request;
import com.adfluence.entitiy.Influencer;

import java.util.List;

public interface RecommendService{

    List<Influencer> recommend(Request request);

}