package com.rest_api.fs14backend.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> findAll(){
        return cartRepository.findAll();
    }

    public Cart createOne(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteById(UUID id) {
        cartRepository.deleteById(id);
    }
}