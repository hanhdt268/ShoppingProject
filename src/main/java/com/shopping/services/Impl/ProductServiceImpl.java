package com.shopping.services.Impl;

import com.shopping.configuration.JwtAuthenticationFilter;
import com.shopping.entity.User;
import com.shopping.entity.shopping.Cart;
import com.shopping.entity.shopping.Category;
import com.shopping.entity.shopping.Product;
import com.shopping.repository.CartRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.repository.UserRepository;
import com.shopping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

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
    public List<Product> getProducts(int pageNumber, String searchKey) {
//        Pageable pageable = PageRequest.of(0, 1);
        Pageable pageable = PageRequest.of(pageNumber, 3);

        if (searchKey.equals("")) {
            return (List<Product>) this.productRepository.findAll(pageable);
        } else {
            return (List<Product>) this.productRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
                    searchKey, searchKey, pageable
            );
        }
    }

    @Override
    public void deleteProduct(Long pId) {
        this.productRepository.deleteById(pId);
    }

    @Override
    public List<Product> getProductOfCategory(Category category, int pageNumber, String searchKey) {
        Pageable pageable = PageRequest.of(pageNumber, 3);

//        return this.productRepository.findByCategory(category, pageable);
        if (searchKey.equals("")) {
            return (List<Product>) this.productRepository.findByCategory(category, pageable);
        } else {
            return (List<Product>) this.productRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
                    searchKey, searchKey, pageable
            );
        }
//        return this.productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getActiveProduct(int pageNumber, String searchKey) {
        Pageable pageable = PageRequest.of(pageNumber, 3);

        if (searchKey.equals("")) {
//            return (List<Product>) this.productRepository.findAll(pageable);
            return this.productRepository.findByActive(true, pageable);

        } else {
            return (List<Product>) this.productRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
                    searchKey, searchKey, pageable
            );
        }
    }

    @Override
    public List<Product> getActiveProductOfCategory(Category c, int pageNumber, String searchKey) {
//        return this.productRepository.findByCategoryAndActive(c, true);
        Pageable pageable = PageRequest.of(pageNumber, 3);

//        return this.productRepository.findByCategory(category, pageable);
        if (searchKey.equals("")) {
            return (List<Product>) this.productRepository.findByCategoryAndActive(c, true, pageable);
        } else {
            return (List<Product>) this.productRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
                    searchKey, searchKey, pageable
            );
        }
    }

    public List<Product> getProductDetail(boolean isSingleProductCheckOut, Long pId) {
        if (isSingleProductCheckOut && pId != 0) {
            //we are going to buy a single product
            List<Product> list = new ArrayList<>();
            Product product = productRepository.findById(pId).get();
            list.add(product);
            return list;
        } else {
            //we are going to checkout entire cart
            String username = JwtAuthenticationFilter.USER_CURRENT;
            User user = userRepository.findByUsername(username);
            List<Cart> carts = cartRepository.findByUser(user);
            return carts.stream().map(Cart::getProduct).collect((Collectors.toList()));
        }
    }
}
