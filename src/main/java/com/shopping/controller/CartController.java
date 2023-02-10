package com.shopping.controller;


import com.shopping.entity.shopping.Cart;
import com.shopping.services.Impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/addToCart")
@RestController
@CrossOrigin("*")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;


    @GetMapping("/{pId}")
    public Cart addToCart(@PathVariable("pId") Long pId) {
        return cartService.addToCart(pId);
    }

    @GetMapping("/")
    public List<Cart> getCartDetails() {
        return cartService.getCartDetails();
    }
}
