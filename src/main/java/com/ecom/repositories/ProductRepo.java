package com.ecom.repositories;

import com.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
}
