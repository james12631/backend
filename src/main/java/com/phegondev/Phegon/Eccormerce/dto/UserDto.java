package com.phegondev.Phegon.Eccormerce.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String password;
    private String role;
    private List<OrderItemDto> orderItemList;
    private AddressDto address;
	public Long getId() {
		return id;
	}

	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<OrderItemDto> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItemDto> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", email=" + email + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", role=" + role + ", orderItemList=" + orderItemList + ", address="
				+ address + ", getId()=" + getId() + ", getEmail()=" + getEmail() + ", getName()=" + getName()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getPassword()=" + getPassword() + ", getRole()="
				+ getRole() + ", getOrderItemList()=" + getOrderItemList() + ", getAddress()=" + getAddress()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
    
    
}
