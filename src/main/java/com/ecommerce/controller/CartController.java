package com.ecommerce.controller;

import com.ecommerce.entity.Cart;
import com.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }
}
