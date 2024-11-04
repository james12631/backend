package com.phegondev.Phegon.Eccormerce.specification;

import com.phegondev.Phegon.Eccormerce.entity.OrderItem;
import com.phegondev.Phegon.Eccormerce.enums.OrderStatus;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;

public class OrderItemSpecification {

    /** Generate a query to filter order items by status */
    public static Query hasStatus(OrderStatus status) {
        Query query = new Query();
        if (status != null) {
            query.addCriteria(Criteria.where("status").is(status));
        }
        return query;
    }

    /** Generate a query to filter order items by date range */
    public static Query createdBetween(LocalDateTime startDate, LocalDateTime endDate) {
        Query query = new Query();
        if (startDate != null && endDate != null) {
            query.addCriteria(Criteria.where("createdAt").gte(startDate).lte(endDate));
        } else if (startDate != null) {
            query.addCriteria(Criteria.where("createdAt").gte(startDate));
        } else if (endDate != null) {
            query.addCriteria(Criteria.where("createdAt").lte(endDate));
        }
        return query;
    }

    /** Generate a query to filter order items by item id */
    public static Query hasItemId(String itemId) {
        Query query = new Query();
        if (itemId != null) {
            query.addCriteria(Criteria.where("id").is(itemId));
        }
        return query;
    }
}
