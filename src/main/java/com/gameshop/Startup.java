package com.gameshop;

import com.gameshop.model.Cart;
import com.gameshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Startup implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
    }

    @Autowired
    CartRepository cartRepository;

    @Override
    public void run(String... args) throws Exception {
        cartRepository.save(
                Cart.builder()
                        .userName("test")
                        .build()
        );

        cartRepository.save(
                Cart.builder()
                        .userName("test-2")
                        .build()
        );
    }

}
