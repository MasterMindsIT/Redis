package com.redis.crud.controllers;

import com.redis.crud.entities.Order;
import com.redis.crud.services.IOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController{
    private final IOrder orderService;

    public OrderController(IOrder orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order FindOrderById(@PathVariable int id) {
        return orderService.FindOrderById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        return orderService.deleteOrder(id);
    }
}
