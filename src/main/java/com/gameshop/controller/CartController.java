package com.gameshop.controller;

import com.gameshop.model.Cart;
import com.gameshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("carts")
    List<Cart> getCarts() {
        return cartRepository.findAll();
    }

}
