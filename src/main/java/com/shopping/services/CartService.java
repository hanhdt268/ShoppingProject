package com.shopping.services;

import com.shopping.entity.shopping.Cart;

import java.util.List;

public interface CartService {

    public Cart addToCart(Long pId);

    public List<Cart> getCartDetails();
}
