package com.phegondev.Phegon.Eccormerce.repository;

import com.phegondev.Phegon.Eccormerce.entity.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderItemRepo extends MongoRepository<OrderItem, Long> {
    // Add any custom query methods here if needed
}
