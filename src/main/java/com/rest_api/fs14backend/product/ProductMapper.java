package com.rest_api.fs14backend.product;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductDTO product){
        return new Product(
                product.getName(),
                product.getSlug(),
                product.getImage(),
                product.getBrand(),
                product.getCategory(),
                product.getDescription(),
                product.getPrice(),
                product.getCountInStock(),
                product.getRating(),
                product.getNumReviews());
    }
}