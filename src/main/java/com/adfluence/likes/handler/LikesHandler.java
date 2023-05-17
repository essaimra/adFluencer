package com.adfluence.likes.handler;


import com.adfluence.likes.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LikesHandler{

    private final LikesRepository likesRepository;

    @Autowired
    public LikesHandler(LikesRepository likesRepository){
        this.likesRepository = likesRepository;
    }

    public Long getTotalLikesCount(){
        return likesRepository.getTotalLikesCount();
    }


}
