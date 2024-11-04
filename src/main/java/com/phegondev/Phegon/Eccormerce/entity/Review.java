package com.phegondev.Phegon.Eccormerce.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "reviews")
public class Review {

    @Id
    private Long id;
    private String content;
    private int rating; // assuming it is in 1 to 10

    @DBRef(lazy = true)
    private Product product;

    @DBRef(lazy = true)
    private User user;

    private final LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "Review [id=" + id + ", content=" + content + ", rating=" + rating + 
               ", product=" + product + ", user=" + user + ", createdAt=" + createdAt + "]";
    }
}
