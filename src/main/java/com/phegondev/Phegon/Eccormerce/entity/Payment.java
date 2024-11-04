package com.phegondev.Phegon.Eccormerce.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document(collection = "payments")
public class Payment {

    @Id
    private Long id;
    private BigDecimal amount;
    private String method;
    private String status;

    @DBRef(lazy = true)
    private Order order;

    private final LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "Payment [id=" + id + ", amount=" + amount + ", method=" + method + ", status=" + status + 
               ", order=" + order + ", createdAt=" + createdAt + "]";
    }
}
