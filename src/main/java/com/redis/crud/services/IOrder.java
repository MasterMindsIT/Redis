package com.redis.crud.services;

import com.redis.crud.entities.Order;

import java.util.List;

public interface IOrder {
    public Order save(Order order);
    public List<Order> findAll();
    public Order FindOrderById(int id);
    public String deleteOrder(int id);
}
