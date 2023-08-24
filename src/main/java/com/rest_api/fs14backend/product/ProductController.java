package com.rest_api.fs14backend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProduct() {
        return productService.getAll();
    }

    @PostMapping
    public Product createOne(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable UUID id) {

        return productService.findById(id);
    }

    @GetMapping("slug/{slug}")
    public Product findBySlug(@PathVariable String slug) {

        return productService.findBySlug(slug);
    }

    @PutMapping("/{id}")
//    public Product updateOne(@PathVariable UUID id, @RequestBody ProductRequest productRequest) {
//        return productService.updateById(id, productRequest);
//    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable UUID id) {
        productService.deleteById(id);
    }
}