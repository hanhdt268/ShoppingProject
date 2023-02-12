package com.shopping.services.Impl;

import com.shopping.configuration.JwtAuthenticationFilter;
import com.shopping.entity.User;
import com.shopping.entity.shopping.Cart;
import com.shopping.entity.shopping.Product;
import com.shopping.repository.CartRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.repository.UserRepository;
import com.shopping.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Cart addToCart(Long pId) {
        Product product = productRepository.findById(pId).get();

        String username = JwtAuthenticationFilter.USER_CURRENT;
        User user = null;
        if (username != null) {
            user = userRepository.findByUsername(username);
        }

        List<Cart> cartList = cartRepository.findByUser(user);
        List<Cart> filterList = cartList.stream().filter(x -> x.getProduct().getpId() == pId).collect(Collectors.toList());

        if (filterList.size() > 0) {
            return null;
        }

        if (product != null && user != null) {
            Cart cart = new Cart(product, user);
            return cartRepository.save(cart);
        }
        return null;
    }

    @Override
    public List<Cart> getCartDetails() {
        String username = JwtAuthenticationFilter.USER_CURRENT;
        User user = userRepository.findByUsername(username);
        return cartRepository.findByUser(user);
    }
}
