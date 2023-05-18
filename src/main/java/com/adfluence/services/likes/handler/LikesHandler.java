package com.adfluence.services.likes.handler;


import com.adfluence.entitiy.Likes;
import com.adfluence.services.likes.repository.LikesRepository;
import com.adfluence.services.likes.request.LikeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LikesHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(LikesHandler.class);
    private final LikesRepository likesRepository;

    @Autowired
    public LikesHandler(LikesRepository likesRepository){
        this.likesRepository = likesRepository;
    }

    public Long getTotalLikesCount(){
        return likesRepository.getTotalLikesCount();
    }


    public void addLike(LikeRequest request){

        Likes likes = Likes.builder()
                .likeId(UUID.randomUUID().toString())
                .customerId(request.getCustomerId())
                .influencerId(request.getInfluencerId())
                .build();

        LOGGER.info("adding likes {} to the DB", likes);
        likesRepository.save(likes);
    }

}
