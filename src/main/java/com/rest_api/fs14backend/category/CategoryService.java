package com.rest_api.fs14backend.category;

import com.rest_api.fs14backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category createOne(Category category) {
    return categoryRepository.save(category);
  }

  public Category findById(UUID categoryId) {
    Category category = categoryRepository.findById(categoryId).orElse(null);
    if ( category== null){
      throw new NotFoundException("Category not found");
    }
    return category;
  }

  public void deleteById(UUID categoryId) {
    Category category = categoryRepository.findById(categoryId).orElse(null);
    if (category == null) {
      throw new NotFoundException("Category not found");
    }
    categoryRepository.deleteById(categoryId);
  }
}