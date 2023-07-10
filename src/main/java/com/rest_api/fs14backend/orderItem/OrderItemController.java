package com.rest_api.fs14backend.orderItem;

import com.rest_api.fs14backend.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<OrderItem> getOrderItem() {
        return orderItemService.getAll();
    }

    @GetMapping("/{id}")
    public OrderItem findById(@PathVariable UUID id) {
        OrderItem orderItem = orderItemService.findById(id);
        return orderItem;
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable UUID id) {
        OrderItem orderItem = orderItemService.findById(id);
        orderItemService.deleteById(id);
    }
}