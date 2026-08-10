package com.ecommerce.service;

import com.ecommerce.entity.Cart;
import com.ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public Cart createCart(Cart cart){
        return cartRepository.save(cart);
    }

}
