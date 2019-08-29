package com.gameshop.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gameshop.model.Cart;
import com.gameshop.model.Item;
import com.gameshop.repository.CartRepository;
import com.gameshop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class CartMutation implements GraphQLMutationResolver {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;


    public Cart addItemToCart(String cartId, BigDecimal value, String type) {
        Cart cart = cartRepository.findById(cartId).orElse(Cart.builder().id(cartId).userName("test").build());

        cart.setItens(Arrays.asList(
                itemRepository.save(Item.builder().value(value).type(type).build())
        ));

        return cartRepository.save(cart);
    }

}
