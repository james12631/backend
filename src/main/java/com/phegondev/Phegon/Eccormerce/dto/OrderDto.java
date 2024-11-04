package com.phegondev.Phegon.Eccormerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private List<OrderItemDto> orderItemList;
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
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public List<OrderItemDto> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItemDto> orderItemList) {
		this.orderItemList = orderItemList;
	}
	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", totalPrice=" + totalPrice + ", createdAt=" + createdAt + ", orderItemList="
				+ orderItemList + ", getId()=" + getId() + ", getTotalPrice()=" + getTotalPrice() + ", getCreatedAt()="
				+ getCreatedAt() + ", getOrderItemList()=" + getOrderItemList() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
}
