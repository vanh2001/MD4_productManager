package com.example.productmanager.controller;

import com.example.productmanager.model.Product;
import com.example.productmanager.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping()
    public ResponseEntity<Iterable<Product>> findAllProduct(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Product> findByName(@RequestParam String name){
        productService.findByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
