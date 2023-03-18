package com.adfluence.customer.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CustomerData{

    private String name;
    private String mail;
    private String phone;

}
