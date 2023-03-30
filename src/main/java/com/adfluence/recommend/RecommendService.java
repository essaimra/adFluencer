package com.adfluence.recommend;

import com.adfluence.customer.request.Request;
import com.adfluence.entitiy.Influencer;

import java.util.List;

public interface RecommendService{

    List<Influencer> recommend(Request request);

}
