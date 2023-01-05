package com.shopping.services;

import com.shopping.entity.shopping.Category;

import java.util.Set;

public interface CategoryService {

    public Category addCategory(Category category);

    public Category updateCategory(Category category);

    public Category getCategoriesById(Long cId);

    public Set<Category> getCategories();

    public void deleteCategory(Long cId);


}
