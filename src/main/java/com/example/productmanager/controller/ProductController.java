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

    @GetMapping("/search")
    public ResponseEntity<Iterable<Product>> findByName(@RequestParam String name){
        return new ResponseEntity<>(productService.findAllByNameContaining(name),HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<Iterable<Product>> findAllByOrderByPriceAsc(){
        return new ResponseEntity<>(productService.findAllByOrderByPriceAsc(),HttpStatus.OK);
    }
}
