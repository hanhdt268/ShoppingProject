package com.shopping.services;

import com.shopping.entity.shopping.Category;
import com.shopping.entity.shopping.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);

    public Product updateProduct(Product product);

    public Product getProductById(Long pId);

    public List<Product> getProducts(int pageNumber, String searchKey);

    public void deleteProduct(Long pId);

    public List<Product> getProductOfCategory(Category category, int pageNumber, String searchKey);

    List<Product> getActiveProduct(int pageNumber, String searchKey);

    List<Product> getActiveProductOfCategory(Category c, int pageNumber, String searchKey);

//    List<Product> getProductDetail(boolean isSingleProductCheckOut, Long pId);
}
