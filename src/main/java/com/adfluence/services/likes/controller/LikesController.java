package com.adfluence.services.likes.controller;

import com.adfluence.exception.AException;
import com.adfluence.services.likes.handler.LikesHandler;
import com.adfluence.services.likes.request.LikeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/likes")
@RestController
public class LikesController{

    private static final Logger LOGGER = LoggerFactory.getLogger(LikesController.class);
    private final LikesHandler likesHandler;

    @Autowired
    public LikesController(LikesHandler likesHandler){
        this.likesHandler = likesHandler;
    }

    @PostMapping
    public ResponseEntity<String> addLikes(@RequestBody LikeRequest likeRequest){
        try {
            likesHandler.addLike(likeRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (AException e){
            LOGGER.error("Exception during addLikes post request");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
