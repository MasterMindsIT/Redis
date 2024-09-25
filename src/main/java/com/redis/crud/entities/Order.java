package com.redis.crud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;

@Data @AllArgsConstructor @NoArgsConstructor @RedisHash("Order")
public class Order implements Serializable {
    @Id
    private int id;

    private String details;
    private int quantity;
    private BigDecimal price;
}
