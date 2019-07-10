package com.miguelvega.apifacturaelectronica.controller;

import com.miguelvega.apifacturaelectronica.model.Customer;
import com.miguelvega.apifacturaelectronica.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    // get all customers
    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }


    // create a order
    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    // update a customer


    // delete a customer


}
