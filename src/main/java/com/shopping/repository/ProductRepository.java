package com.shopping.repository;

import com.shopping.entity.shopping.Category;
import com.shopping.entity.shopping.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
