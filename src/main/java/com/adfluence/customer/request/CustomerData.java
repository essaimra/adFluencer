package com.adfluence.customer.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class CustomerData{

    private String name;
    private String mail;
    private String phone;

}
