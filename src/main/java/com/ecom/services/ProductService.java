package com.ecom.services;

import com.ecom.model.Product;
import com.ecom.repositories.ProductRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Product createNewProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(@NotNull Product product) {
        if (product.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product id not present");
        }

        boolean doesProductExists = repo.existsById(product.getId());

        if (!doesProductExists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product id not found");
        }

        return repo.save(product);
    }

    public Boolean deleteProductById(String id) {
        boolean doesProductExists = repo.existsById(id);

        if (!doesProductExists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product id not found");
        }

        repo.deleteById(id);

        return true;
    }
}
