package com.shopping.services.Impl;

import com.shopping.entity.shopping.Manufacturer;
import com.shopping.entity.shopping.Product;
import com.shopping.repository.ProductRepository;
import com.shopping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Product> getProductOfCategory(Manufacturer Manufacturer) {
        return this.productRepository.findByManufacturer(Manufacturer);
    }

    @Override
    public List<Product> getActiveProduct() {
        return this.productRepository.findByActive(true);
    }

    @Override
    public List<Product> getActiveProductOfManu(Manufacturer c) {
        return this.productRepository.findByManufacturerAndActive(c, true);
    }

    public List<Product> getProductDetail(boolean isSingleProductCheckOut, Long pId) {
        if (isSingleProductCheckOut) {
            List<Product> list = new ArrayList<>();
            Product product = productRepository.findById(pId).get();
            list.add(product);
            return list;
        } else {
            //we are going to checkout entire cart
        }
        return new ArrayList<>();
    }
}
