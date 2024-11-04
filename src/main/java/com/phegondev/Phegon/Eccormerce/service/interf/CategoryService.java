package com.phegondev.Phegon.Eccormerce.service.interf;

import com.phegondev.Phegon.Eccormerce.dto.CategoryDto;
import com.phegondev.Phegon.Eccormerce.dto.Response;

public interface CategoryService {

    Response createCategory(CategoryDto categoryRequest);
    Response updateCategory(Long categoryId, CategoryDto categoryRequest);
    Response getAllCategories();
    Response getCategoryById(Long categoryId);
    Response deleteCategory(Long categoryId);
	Response getCategoryById(String categoryId);
	Response deleteCategory(String categoryId);
	Response updateCategory(String categoryId, CategoryDto categoryRequest);
}
