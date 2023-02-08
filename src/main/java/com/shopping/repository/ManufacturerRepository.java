package com.shopping.repository;

import com.shopping.entity.shopping.Category;
import com.shopping.entity.shopping.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    List<Manufacturer> findByCategory(Category category);
}
