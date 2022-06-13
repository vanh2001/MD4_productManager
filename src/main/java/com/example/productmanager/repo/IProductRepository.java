package com.example.productmanager.repo;

import com.example.productmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findAllByNameContaining (String name);
}
