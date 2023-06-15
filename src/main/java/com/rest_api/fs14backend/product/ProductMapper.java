package com.rest_api.fs14backend.product;

import com.rest_api.fs14backend.category.Category;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductDTO product, Category category) {
        return new Product(product.getTitle(), product.getDescription(), product.getPrice(), product.getQuantity(), category);
    }
}