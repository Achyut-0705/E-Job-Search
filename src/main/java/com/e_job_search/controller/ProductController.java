package com.e_job_search.controller;


import com.e_job_search.model.Product;
import com.e_job_search.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(
            @PathVariable String id
    ) {
        return service.getProductById(id);
    }

    @PostMapping("/product")
    public Product createProduct(
            @RequestBody Product product
    ) {
        return service.createNewProduct(product);
    }

    @PatchMapping("/product")
    public Product updateProduct(
            @RequestBody Product product
    ) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public Boolean deleteProduct(@PathVariable String id) {
        return service.deleteProductById(id);
    }
}
