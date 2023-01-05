package com.shopping.services.Impl;

import com.shopping.entity.shopping.Category;
import com.shopping.repository.CategoryRepository;
import com.shopping.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category getCategoriesById(Long cId) {
        return this.categoryRepository.findById(cId).get();
    }

    @Override
    public Set<Category> getCategories() {
        return new HashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public void deleteCategory(Long cId) {
        this.categoryRepository.deleteById(cId);
    }
}
