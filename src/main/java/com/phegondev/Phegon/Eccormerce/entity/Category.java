package com.phegondev.Phegon.Eccormerce.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "categories")
public class Category {

    @Id
    private Long id;

    private String name;

    @DBRef(lazy = true)
    private List<Product> productList;

    private final LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", productList=" + productList + ", createdAt=" + createdAt + "]";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
    
    
}
