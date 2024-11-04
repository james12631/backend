package com.phegondev.Phegon.Eccormerce.entity;

import com.phegondev.Phegon.Eccormerce.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    
    @Id
    private Long id;

    @jakarta.validation.constraints.NotBlank(message = "Name is required")
    private String name;

    @jakarta.validation.constraints.Email(message = "Email should be valid")
    @jakarta.validation.constraints.NotBlank(message = "Email is required")
    private String email;

    @jakarta.validation.constraints.NotBlank(message = "Password number is required")
    private String password;

    @jakarta.validation.constraints.NotBlank(message = "Phone number is required")
    private String phoneNumber;

    private UserRole role;

    @DBRef(lazy = true)
    private List<OrderItem> orderItemList;

    @DBRef(lazy = true)
    private Address address;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber="
                + phoneNumber + ", role=" + role + ", orderItemList=" + orderItemList + ", address=" + address
                + ", createdAt=" + createdAt + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}






}
