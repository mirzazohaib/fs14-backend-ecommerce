package com.rest_api.fs14backend.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public List<Cart> findAll() {
        return cartService.findAll();
    }

    @PostMapping("/")
    public Cart createOne(@RequestBody Cart cart) {
        return cartService.createOne(cart);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable UUID id) {
        cartService.deleteById(id);
    }
}
