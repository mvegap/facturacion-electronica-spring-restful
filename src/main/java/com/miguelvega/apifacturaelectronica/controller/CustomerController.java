package com.miguelvega.apifacturaelectronica.controller;

import com.miguelvega.apifacturaelectronica.exception.ResourceNotFoundException;
import com.miguelvega.apifacturaelectronica.model.Customer;
import com.miguelvega.apifacturaelectronica.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
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
    
    // get a single customer
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") Long id){
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
    }


    // create a order
    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    // update a customer
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable(value="id") Long id, @Valid @RequestBody Customer customerDetails){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer", "id", id));
        customer.setCountry_code(customerDetails.getCountry_code());
        customer.setDocument_type_code(customerDetails.getDocument_type_code());
        customer.setIdentity_card(customerDetails.getIdentity_card());
        customer.setFirstname(customerDetails.getFirstname());
        customer.setMiddlename(customerDetails.getMiddlename());
        customer.setLastname(customerDetails.getLastname());
        customer.setSurname(customerDetails.getSurname());
        customer.setEmail(customerDetails.getEmail());
        customer.setGender_code(customerDetails.getGender_code());
        customer.setPhone(customerDetails.getPhone());
        customer.setAddress(customerDetails.getAddress());
        
        Customer updatedCustomer = customerRepository.save(customer);
        return updatedCustomer;
    }

    // delete a customer
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long customerId){
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        customerRepository.delete(customer);
        return ResponseEntity.ok().build();
    }


}
