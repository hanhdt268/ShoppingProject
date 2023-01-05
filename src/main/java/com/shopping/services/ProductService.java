package com.shopping.services;

import com.shopping.entity.shopping.Category;
import com.shopping.entity.shopping.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    public Product addProduct(Product product);

    public Product updateProduct(Product product);

    public Product getProductById(Long pId);

    public Set<Product> getProducts();

    public void deleteProduct(Long pId);

    public List<Product> getProductOfCategory(Category category);
}
