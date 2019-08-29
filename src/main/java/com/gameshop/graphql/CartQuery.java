package com.gameshop.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gameshop.model.Cart;
import com.gameshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

@Component
public class CartQuery implements GraphQLQueryResolver {

    @Autowired
    private CartRepository cartRepository;

    public Iterable<Cart> findAllCarts() {
        return cartRepository.findAll();
    }

    public Cart findCartByUser(String userName) {
        return cartRepository.findOne(
                Example.of(Cart.builder().userName(userName).build(),
                ExampleMatcher.matchingAll().withIgnoreCase())).orElse(null);
    }

}
