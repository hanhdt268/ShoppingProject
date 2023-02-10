package com.shopping.services;

import com.shopping.entity.shopping.Manufacturer;
import com.shopping.entity.shopping.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);

    public Product updateProduct(Product product);

    public Product getProductById(Long pId);

    public List<Product> getProducts(int pageNumber, String searchKey);

    public void deleteProduct(Long pId);

    public List<Product> getProductOfCategory(Manufacturer Manufacturer);

    List<Product> getActiveProduct();

    List<Product> getActiveProductOfManu(Manufacturer c);

//    List<Product> getProductDetail(boolean isSingleProductCheckOut, Long pId);
}
