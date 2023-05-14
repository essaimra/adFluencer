package com.adfluence.controller;


import com.adfluence.customer.handler.CustomerHandler;
import com.adfluence.entitiy.Customer;
import com.adfluence.entitiy.Influencer;
import com.adfluence.influencer.handler.InfluencerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/fetcher")
@RestController
public class EntityFetcherController{

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityFetcherController.class);

    private final CustomerHandler customerHandler;
    private final InfluencerHandler influencerHandler;

    @Autowired
    public EntityFetcherController(CustomerHandler customerHandler, InfluencerHandler influencerHandler){
        this.customerHandler = customerHandler;
        this.influencerHandler = influencerHandler;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        LOGGER.info("going to fetch the customers");
        return customerHandler.getCustomers();
    }


    @GetMapping("customer/phone/{phone}")
    public Customer getCustomerByPhone(@PathVariable("phone") String phone){
        LOGGER.info("going to fetch the customer with phone {}", phone);
        return customerHandler.getCustomerByPhone(phone);
    }

    @GetMapping("customer/name/{name}")
    public List<Customer> getCustomerByName(@PathVariable("name") String name){
        LOGGER.info("going to fetch the customer with name {}", name);
        return customerHandler.getCustomersByName(name);
    }


    @GetMapping("influencer/phone/{phone}")
    public Influencer getInfluencerByPhone(@PathVariable("phone") String phone){
        LOGGER.info("going to fetch the influencer with phone {}", phone);
        return influencerHandler.getInfluencerByPhone(phone);
    }

    @GetMapping("influencer/name/{name}")
    public List<Influencer> getInfluencerByName(@PathVariable("name") String name){
        LOGGER.info("going to fetch the influencer with name {}", name);
        return influencerHandler.getInfluencerByName(name);
    }
}
