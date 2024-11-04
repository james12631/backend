package com.phegondev.Phegon.Eccormerce.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;

    @DBRef(lazy = true)
    private Category category;

    private final LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + 
               ", imageUrl=" + imageUrl + ", price=" + price + ", category=" + category + 
               ", createdAt=" + createdAt + "]";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
    
    
}
