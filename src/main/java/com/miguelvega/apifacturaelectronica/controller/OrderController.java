package com.miguelvega.apifacturaelectronica.controller;

import com.miguelvega.apifacturaelectronica.exception.ResourceNotFoundException;
import com.miguelvega.apifacturaelectronica.model.Order;
import com.miguelvega.apifacturaelectronica.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
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
    
    // get a single order
    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable(value="id") Long id){
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
    }

    // create a order
    @PostMapping("/orders")
    public Order createOrder(@Valid @RequestBody Order order){
        return orderRepository.save(order);
    }

    // update a user
    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable(value="id") Long id, @Valid @RequestBody Order orderDetails){
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        order.setCustomer(orderDetails.getCustomer());
        order.setOrder_code(orderDetails.getOrder_code());
        order.setAmount(orderDetails.getAmount());
        order.setDetail_order(orderDetails.getDetail_order());
        
        Order updatedOrder = orderRepository.save(order);
        return updatedOrder;
    }

    // delete a user
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
        orderRepository.delete(order);
        return ResponseEntity.ok().build();
    }

}
