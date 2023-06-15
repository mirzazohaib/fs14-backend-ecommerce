package com.rest_api.fs14backend.product;

import com.rest_api.fs14backend.category.Category;
import com.rest_api.fs14backend.category.CategoryService;
import com.rest_api.fs14backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.findProducts();
    }

    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable UUID id) {
        Product product = productService.findProductById(id);
        if (product == null) {
            throw new NotFoundException("ID not found");
        }
        return product;
    }

    @GetMapping("/title/{title}")
    public Product getProductByTitle(@PathVariable String title) {
        Product product = productService.findProductByTitle(title);
        if (product == null) {
            throw new NotFoundException("Product title not found");
        }
        return product;
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody ProductDTO productDTO) {
        UUID categoryId = productDTO.getCategoryId();
        Category category = categoryService.findById(categoryId);
        Product product = productMapper.toProduct(productDTO, category);
        return productService.createProduct(product);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable UUID id) {
        productService.deleteProductById(id);
    }
}