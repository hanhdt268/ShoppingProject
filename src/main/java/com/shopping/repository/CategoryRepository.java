package com.shopping.repository;

import com.shopping.entity.shopping.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
