package com.rest_api.fs14backend.product;

import com.rest_api.fs14backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product createProduct(ProductRequest productRequest) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(productRequest.getName());
        productDTO.setSlug(productRequest.getSlug());
        productDTO.setImage(productRequest.getImage());
        productDTO.setBrand(productRequest.getBrand());
        productDTO.setCategory(productRequest.getCategory());
        productDTO.setDescription(productRequest.getDescription());
        productDTO.setPrice(productRequest.getPrice());
        productDTO.setCountInStock(productRequest.getCountInStock());
        productDTO.setRating(productRequest.getRating());
        productDTO.setNumReviews(productRequest.getNumReviews());

        Product product = productMapper.toProduct(productDTO);

        return productRepository.save(product);
    }

    public Product findById(UUID id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new NotFoundException("Product not found");
        }
        return product;
    }

    public Product findBySlug(String slug) {
        Object product = productRepository.findBySlug(slug).orElse(null);
        if (product == null) {
            throw new NotFoundException("Product not found");
        }
        return (Product) product;
    }

//    public Product updateById(UUID id, ProductRequest productRequest) {
//        Product existingProduct = productRepository.findById(id).orElse(null);
//        if (existingProduct == null) {
//            throw new NotFoundException("Product not found");
//        }
//        // Transform productRequest to productDTO and then mapping to product
//        Category category = categoryService.findById(productRequest.getCategoryId());
//
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setTitle(productRequest.getTitle());
//        productDTO.setPrice(productRequest.getPrice());
//        productDTO.setDescription(productRequest.getDescription());
//        productDTO.setImage(productRequest.getImage());
//
//        UUID inventoryId = existingProduct.getInventory().getId();
//        Inventory inventory = inventoryService.updateOne(inventoryId, productRequest.getQuantity());
//
//        Product product = productMapper.toProduct(productDTO);
//
//        existingProduct.setTitle(product.getTitle());
//        existingProduct.setPrice(product.getPrice());
//        existingProduct.setDescription(product.getDescription());
//        String transformImageUrl = uploadAndTransformImage(product.getImage());
//        existingProduct.setImage(transformImageUrl);
//        existingProduct.setCategory(product.getCategory());
//        existingProduct.setInventory(product.getInventory());
//
//        return productRepository.save(existingProduct);
//    }

    public void deleteById(UUID id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new NotFoundException("Product not found");
        }
        productRepository.deleteById(id);
    }
}