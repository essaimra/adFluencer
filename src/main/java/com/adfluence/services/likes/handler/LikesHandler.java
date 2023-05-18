package com.adfluence.services.likes.handler;


import com.adfluence.entitiy.Customer;
import com.adfluence.entitiy.Influencer;
import com.adfluence.entitiy.Likes;
import com.adfluence.exception.AException;
import com.adfluence.services.customer.repository.CustomerRepository;
import com.adfluence.services.influencer.repository.InfluencerRepository;
import com.adfluence.services.likes.repository.LikesRepository;
import com.adfluence.services.likes.request.LikeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class LikesHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(LikesHandler.class);
    private final LikesRepository likesRepository;
    private final CustomerRepository customerRepository;
    private final InfluencerRepository influencerRepository;

    @Autowired
    public LikesHandler(LikesRepository likesRepository,
                        CustomerRepository customerRepository,
                        InfluencerRepository influencerRepository){
        this.likesRepository = likesRepository;
        this.customerRepository = customerRepository;
        this.influencerRepository = influencerRepository;
    }

    public Long getTotalLikesCount(){
        return likesRepository.getTotalLikesCount();
    }


    public void addLike(LikeRequest request){

        validateDataInDataBase(request);

        Likes likes = Likes.builder()
                .likeId(UUID.randomUUID().toString())
                .customerId(request.getCustomerId())
                .influencerId(request.getInfluencerId())
                .build();

        LOGGER.info("adding likes {} to the DB", likes);
        likesRepository.save(likes);
    }

    private void validateDataInDataBase(LikeRequest request){

        Optional<Influencer> influencer = influencerRepository.findById(request.getInfluencerId());
        Optional<Customer> customer = customerRepository.findById(request.getCustomerId());

        if (!influencer.isPresent() || !customer.isPresent()){
            LOGGER.info("Influencer/customer not exist in the DB {}, {}", request.getInfluencerId(), request.getCustomerId());
            throw new AException("InfluencerId " + request.getInfluencerId() + " or the customerId " + request.getCustomerId() + " not exist in the DB");
        }

        LOGGER.info("Influencer {}, customer {} exist in the DB", request.getInfluencerId(), request.getCustomerId());
    }



}
