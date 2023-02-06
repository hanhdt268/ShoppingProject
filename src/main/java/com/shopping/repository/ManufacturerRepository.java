package com.shopping.repository;

import com.shopping.entity.shopping.Category;
import com.shopping.entity.shopping.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    List<Manufacturer> findByCategory(Category category);
}
