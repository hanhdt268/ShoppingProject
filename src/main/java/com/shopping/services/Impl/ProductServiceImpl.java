package com.shopping.services.Impl;

import com.shopping.entity.shopping.Category;
import com.shopping.entity.shopping.Product;
import com.shopping.repository.ProductRepository;
import com.shopping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product getProductById(Long pId) {
        return this.productRepository.findById(pId).get();
    }

    @Override
    public Set<Product> getProducts() {
        return new HashSet<>(this.productRepository.findAll());
    }

    @Override
    public void deleteProduct(Long pId) {
        this.productRepository.deleteById(pId);
    }

    @Override
    public List<Product> getProductOfCategory(Category category) {
        return this.productRepository.findByCategory(category);
    }
}
