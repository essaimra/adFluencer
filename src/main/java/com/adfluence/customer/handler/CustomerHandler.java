package com.adfluence.customer.handler;


import com.adfluence.customer.request.CustomerData;
import com.adfluence.entitiy.Customer;
import com.adfluence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerHandler{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerHandler(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


    public void addCustomer(CustomerData data){

        Customer customer = Customer
                .builder()
                .customerId(UUID.randomUUID().toString())
                .name(data.getName())
                .mail(data.getMail())
                .phone(data.getPhone())
                .build();

        customerRepository.save(customer);
    }

}
