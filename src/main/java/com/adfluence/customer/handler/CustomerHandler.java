package com.adfluence.customer.handler;


import com.adfluence.customer.request.CustomerData;
import com.adfluence.entitiy.Customer;
import com.adfluence.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CustomerHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerHandler.class);
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

        LOGGER.info("going to save customer {}", customer);
        customerRepository.save(customer);
    }


    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerByPhone(String phone){
        return customerRepository.findByPhone(phone);
    }

    public List<Customer> getCustomersByName(String name){
        return customerRepository.findByName(name);
    }

}
