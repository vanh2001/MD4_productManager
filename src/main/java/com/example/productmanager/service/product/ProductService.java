package com.example.productmanager.service.product;

import com.example.productmanager.model.Product;
import com.example.productmanager.repo.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllByNameContaining(String name) {
        return productRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Product> findAllByOrderByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public Iterable<Product> findTop4New() {
        return productRepository.findTop4New();
    }

    @Override
    public Iterable<Product> findProductByCategoryId(Long id) {
        return productRepository.findProductByCategoryId(id);
    }

    @Override
    public Iterable<Product> findAllByPriceBetween(int from, int to) {
        return productRepository.findAllByPriceBetween(from, to);
    }
}
