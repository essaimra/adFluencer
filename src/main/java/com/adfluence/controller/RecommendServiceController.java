package com.adfluence.controller;


import com.adfluence.entitiy.Influencer;
import com.adfluence.services.recommend.request.Request;
import com.adfluence.services.recommend.handler.RecommendHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/recommend")
@RestController
public class RecommendServiceController{


    private final RecommendHandler recommendHandler;

    @Autowired
    public RecommendServiceController(RecommendHandler recommendHandler){
        this.recommendHandler = recommendHandler;
    }


    @GetMapping
    public ResponseEntity<List<Influencer>> getRecommendedPerson(@RequestBody Request request){
        List<Influencer> influencers = recommendHandler.handleRecommendation(request);
        return new ResponseEntity<>(influencers, HttpStatus.OK);
    }

}
