package com.adfluence.controller;


import com.adfluence.customer.handler.CustomerHandler;
import com.adfluence.entitiy.Customer;
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

    @Autowired
    public EntityFetcherController(CustomerHandler customerHandler){
        this.customerHandler = customerHandler;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        LOGGER.info("going to fetch the customers");
        return customerHandler.getCustomers();
    }


    @GetMapping("/{phone}")
    public Customer getCustomer(@PathVariable("phone") String phone){
        LOGGER.info("going to fetch the customer with phone {}", phone);
        return customerHandler.getCustomerByPhone(phone);
    }
}
