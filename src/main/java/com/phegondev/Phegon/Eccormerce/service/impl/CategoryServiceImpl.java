
package com.phegondev.Phegon.Eccormerce.service.impl;

import com.phegondev.Phegon.Eccormerce.dto.CategoryDto;
import com.phegondev.Phegon.Eccormerce.dto.Response;
import com.phegondev.Phegon.Eccormerce.entity.Category;
import com.phegondev.Phegon.Eccormerce.exception.NotFoundException;
import com.phegondev.Phegon.Eccormerce.mapper.EntityDtoMapper;
import com.phegondev.Phegon.Eccormerce.repository.CategoryRepo;
import com.phegondev.Phegon.Eccormerce.service.interf.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final EntityDtoMapper entityDtoMapper;
    
    




    public CategoryServiceImpl(CategoryRepo categoryRepo, EntityDtoMapper entityDtoMapper) {
		super();
		this.categoryRepo = categoryRepo;
		this.entityDtoMapper = entityDtoMapper;
	}

	@Override
    public Response createCategory(CategoryDto categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        categoryRepo.save(category);
        return Response.builder()
                .status(200)
                .message("Category created successfully")
                .build();
    }

    @Override
    public Response updateCategory(Long categoryId, CategoryDto categoryRequest) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new NotFoundException("Category Not Found"));
        category.setName(categoryRequest.getName());
        categoryRepo.save(category);
        return Response.builder()
                .status(200)
                .message("category updated successfully")
                .build();
    }

    @Override
    public Response getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDto> categoryDtoList = categories.stream()
                .map(entityDtoMapper::mapCategoryToDtoBasic)
                .collect(Collectors.toList());

        return  Response.builder()
                .status(200)
                .categoryList(categoryDtoList)
                .build();
    }

    @Override
    public Response getCategoryById(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new NotFoundException("Category Not Found"));
        CategoryDto categoryDto = entityDtoMapper.mapCategoryToDtoBasic(category);
        return Response.builder()
                .status(200)
                .category(categoryDto)
                .build();
    }

    @Override
    public Response deleteCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new NotFoundException("Category Not Found"));
        categoryRepo.delete(category);
        return Response.builder()
                .status(200)
                .message("Category was deleted successfully")
                .build();
    }

	@Override
	public Response getCategoryById(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteCategory(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateCategory(String categoryId, CategoryDto categoryRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public CategoryRepo getCategoryRepo() {
		return categoryRepo;
	}

	public EntityDtoMapper getEntityDtoMapper() {
		return entityDtoMapper;
	}

	@Override
	public String toString() {
		return "CategoryServiceImpl [categoryRepo=" + categoryRepo + ", entityDtoMapper=" + entityDtoMapper
				+ ", getAllCategories()=" + getAllCategories() + ", getCategoryRepo()=" + getCategoryRepo()
				+ ", getEntityDtoMapper()=" + getEntityDtoMapper() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
