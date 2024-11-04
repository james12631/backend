package com.phegondev.Phegon.Eccormerce.entity;

import com.phegondev.Phegon.Eccormerce.enums.OrderStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document(collection = "order_items")
public class OrderItem {

    @Id
    private Long id;

    private int quantity;
    private BigDecimal price;
    private OrderStatus status;

    @DBRef(lazy = true)
    private User user;

    @DBRef(lazy = true)
    private Product product;

    @DBRef(lazy = true)
    private Order order;

    private final LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "OrderItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", status=" + status + 
               ", user=" + user + ", product=" + product + ", order=" + order + ", createdAt=" + createdAt + "]";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
    
}
