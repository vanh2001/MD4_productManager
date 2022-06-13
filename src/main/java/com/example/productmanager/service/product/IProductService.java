package com.example.productmanager.service.product;

import com.example.productmanager.model.Product;
import com.example.productmanager.service.IGeneralService;

import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {
    Optional<Product> findByName(String name);
}
