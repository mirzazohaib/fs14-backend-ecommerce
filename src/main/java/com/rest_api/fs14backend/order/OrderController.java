package com.rest_api.fs14backend.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<Order> findAll() {
        return orderService.findAll();
    }
    @PostMapping("/")
    public Order createOne(@RequestBody Order order) {
        return orderService.createOne(order);
    }

}
