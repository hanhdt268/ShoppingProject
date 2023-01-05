package com.shopping.repository;

import com.shopping.entity.User;
import com.shopping.entity.shopping.Oder;
import com.shopping.entity.shopping.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OderRepository extends JpaRepository<Oder, Long> {
    List<Oder> findByProduct(Product product);

    List<Oder> findByUser(User user);
}
