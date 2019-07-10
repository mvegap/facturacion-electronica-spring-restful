package com.miguelvega.apifacturaelectronica.controller;

import com.miguelvega.apifacturaelectronica.model.Order;
import com.miguelvega.apifacturaelectronica.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    // get all orders
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    // create a order
    @PostMapping("/orders")
    public Order createOrder(@Valid @RequestBody Order order){
        return orderRepository.save(order);
    }

    // update a user

    // delete a user

}
