package com.adfluence.controller;


import com.adfluence.customer.handler.CustomerHandler;
import com.adfluence.customer.request.CustomerData;
import com.adfluence.influencer.handler.InfluencerHandler;
import com.adfluence.influencer.request.InfluencerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/register")
@RestController
public class RegisterController{


    private final CustomerHandler customerHandler;
    private final InfluencerHandler influencerHandler;

    @Autowired
    public RegisterController(CustomerHandler customerHandler, InfluencerHandler influencerHandler){
        this.customerHandler = customerHandler;
        this.influencerHandler = influencerHandler;
    }


    @PostMapping("/customer")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerData data){
        customerHandler.addCustomer(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/influencer")
    public ResponseEntity<String> addInfluencer(@RequestBody InfluencerData data){
        influencerHandler.addInfluencer(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
