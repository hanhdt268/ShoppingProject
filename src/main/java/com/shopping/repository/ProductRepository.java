package com.shopping.repository;

import com.shopping.entity.shopping.Category;
import com.shopping.entity.shopping.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByCategory(Category category);

    public List<Product> findAll(Pageable pageable);

    public List<Product> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String searchKey1, String searchKey2, Pageable pageable
    );

    public List<Product> findByActive(Boolean b);

    public List<Product> findByCategoryAndActive(Category c, Boolean b);
}
