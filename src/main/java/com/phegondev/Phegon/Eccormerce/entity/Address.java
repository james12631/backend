package com.phegondev.Phegon.Eccormerce.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

@Data
@Document(collection = "addresses")
public class Address {

    @Id
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    @DBRef(lazy = true)
    private User user;

    private final LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "Address [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", zipCode="
                + zipCode + ", country=" + country + ", user=" + user + ", createdAt=" + createdAt + "]";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
    
    
}
