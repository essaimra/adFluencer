package com.adfluence.repository;

import com.adfluence.entitiy.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

    Customer findByPhone(String phone);

    List<Customer> findByName(String name);

    Customer findByNameAndPhone(String name, String phone);
}
