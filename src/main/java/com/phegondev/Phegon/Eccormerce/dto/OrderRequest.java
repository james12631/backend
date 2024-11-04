package com.phegondev.Phegon.Eccormerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.phegondev.Phegon.Eccormerce.entity.Payment;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {

    private BigDecimal totalPrice;
    private List<OrderItemRequest> items;
    private Payment paymentInfo;
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<OrderItemRequest> getItems() {
		return items;
	}
	public void setItems(List<OrderItemRequest> items) {
		this.items = items;
	}
	public Payment getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(Payment paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	@Override
	public String toString() {
		return "OrderRequest [totalPrice=" + totalPrice + ", items=" + items + ", paymentInfo=" + paymentInfo
				+ ", getTotalPrice()=" + getTotalPrice() + ", getItems()=" + getItems() + ", getPaymentInfo()="
				+ getPaymentInfo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
    
    
}
