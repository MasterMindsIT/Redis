package com.redis.crud.services.impl;

import com.redis.crud.entities.Order;
import com.redis.crud.services.IOrder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements IOrder {
    private static final String HASH_KEY = "Order";
    private final RedisTemplate template;

    public OrderServiceImpl(RedisTemplate template) {
        this.template = template;
    }

    @Override
    public Order save(Order order) {
        template.opsForHash().put(HASH_KEY, order.getId(),order);
        return order;
    }

    @Override
    public List<Order> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    @Override
    public Order FindOrderById(int id) {
        return (Order) template.opsForHash().get(HASH_KEY, id);
    }

    @Override
    public String deleteOrder(int id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "Order deleted successfully";
    }
}
