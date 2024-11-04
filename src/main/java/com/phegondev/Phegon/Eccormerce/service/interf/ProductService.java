package com.phegondev.Phegon.Eccormerce.service.interf;

import com.phegondev.Phegon.Eccormerce.dto.Response;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public interface ProductService {

    Response createProduct(Long categoryId, MultipartFile image, String name, String description, BigDecimal price);
    Response updateProduct(Long productId, Long categoryId, MultipartFile image, String name, String description, BigDecimal price);
    Response deleteProduct(Long productId);
    Response getProductById(Long productId);
    Response getAllProducts();
    Response getProductsByCategory(Long categoryId);
    Response searchProduct(String searchValue);
	Response getProductsByCategory(String categoryId);
	Response getProductById(String productId);
	Response createProduct(String categoryId, String name, String description, BigDecimal price);
	Response updateProduct(Long productId, Long categoryId, String name, String description, BigDecimal price);
	Response createProduct(Long categoryId, String name, String description, BigDecimal price);
}
