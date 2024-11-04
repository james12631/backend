package com.phegondev.Phegon.Eccormerce.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private Long id;

    private BigDecimal totalPrice;

    @DBRef(lazy = true)
    private List<OrderItem> orderItemList;

    private final LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "Order [id=" + id + ", totalPrice=" + totalPrice + ", orderItemList=" + orderItemList + ", createdAt="
                + createdAt + "]";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	

    // Additional methods related to payment can be added here
}
