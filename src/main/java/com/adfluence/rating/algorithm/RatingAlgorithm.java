package com.adfluence.rating.algorithm;


import com.adfluence.entitiy.Influencer;
import com.adfluence.influencer.handler.InfluencerHandler;
import com.adfluence.likes.handler.LikesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This is the component that responsible for Rating Algorithm for Influencers
 * */
@Component
public class RatingAlgorithm implements IAlgorithm{

    private final InfluencerHandler influencerHandler;
    private final Integer pageSize;
    private final LikesHandler likesHandler;

    @Autowired
    public RatingAlgorithm(InfluencerHandler influencerHandler, LikesHandler likesHandler, @Value("${PAGE_SIZE}") Integer pageSize){
        this.influencerHandler = influencerHandler;
        this.likesHandler = likesHandler;
        this.pageSize = pageSize;
    }

    public void rate(){
        int pageNumber = 0;
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Slice<Influencer> influencerSlice = influencerHandler.getInfluencerSlice(pageRequest);

        while (influencerSlice.hasContent()){

            List<Influencer> influencers = influencerSlice.getContent();

            rateInfluencers(influencers);

            pageNumber++;
            pageRequest = PageRequest.of(pageNumber, pageSize);
            influencerSlice = influencerHandler.getInfluencerSlice(pageRequest);
        }
    }


    private void rateInfluencers(List<Influencer> influencers){

        Long totalLikesCount = likesHandler.getTotalLikesCount();

        influencers.forEach(influencer -> rateInfluencer(influencer, totalLikesCount));
    }

    private void rateInfluencer(Influencer influencer, Long totalLikesCount){

        int influencerLikesCount = influencer.getNumOfLikes();

        double rating = influencerLikesCount / totalLikesCount.doubleValue();

        influencer.setRating(rating);

        influencerHandler.updateInfluencer(influencer);
    }

}
