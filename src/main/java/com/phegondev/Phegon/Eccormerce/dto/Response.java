package com.phegondev.Phegon.Eccormerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phegondev.Phegon.Eccormerce.enums.UserRole;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int status;
    private String message;
    private final LocalDateTime timestamp = LocalDateTime.now();

    private String token;
    private String role;
    private String  expirationTime;
    
    
    
    
  

    private int totalPage;
    private long totalElement;

    private AddressDto address;

    private UserDto user;
    private List<UserDto> userList;

    private CategoryDto category;
    private List<CategoryDto> categoryList;

    private ProductDto product;
    private List<ProductDto> productList;

    private OrderItemDto orderItem;
    private List<OrderItemDto> orderItemList;

    private OrderDto order;
    private List<OrderDto> orderList;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public long getTotalElement() {
		return totalElement;
	}
	public void setTotalElement(long totalElement) {
		this.totalElement = totalElement;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public List<UserDto> getUserList() {
		return userList;
	}
	public void setUserList(List<UserDto> userList) {
		this.userList = userList;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	public List<CategoryDto> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CategoryDto> categoryList) {
		this.categoryList = categoryList;
	}
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	public List<ProductDto> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}
	public OrderItemDto getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItemDto orderItem) {
		this.orderItem = orderItem;
	}
	public List<OrderItemDto> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItemDto> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public OrderDto getOrder() {
		return order;
	}
	public void setOrder(OrderDto order) {
		this.order = order;
	}
	public List<OrderDto> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderDto> orderList) {
		this.orderList = orderList;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + ", timestamp=" + timestamp + ", token=" + token
				+ ", role=" + role + ", expirationTime=" + expirationTime + ", totalPage=" + totalPage
				+ ", totalElement=" + totalElement + ", address=" + address + ", user=" + user + ", userList="
				+ userList + ", category=" + category + ", categoryList=" + categoryList + ", product=" + product
				+ ", productList=" + productList + ", orderItem=" + orderItem + ", orderItemList=" + orderItemList
				+ ", order=" + order + ", orderList=" + orderList + ", getStatus()=" + getStatus() + ", getMessage()="
				+ getMessage() + ", getToken()=" + getToken() + ", getRole()=" + getRole() + ", getExpirationTime()="
				+ getExpirationTime() + ", getTotalPage()=" + getTotalPage() + ", getTotalElement()="
				+ getTotalElement() + ", getAddress()=" + getAddress() + ", getUser()=" + getUser() + ", getUserList()="
				+ getUserList() + ", getCategory()=" + getCategory() + ", getCategoryList()=" + getCategoryList()
				+ ", getProduct()=" + getProduct() + ", getProductList()=" + getProductList() + ", getOrderItem()="
				+ getOrderItem() + ", getOrderItemList()=" + getOrderItemList() + ", getOrder()=" + getOrder()
				+ ", getOrderList()=" + getOrderList() + ", getTimestamp()=" + getTimestamp() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

    
    
}
