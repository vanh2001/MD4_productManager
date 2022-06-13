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

//    Hiện danh sách
    @GetMapping()
    public ResponseEntity<Iterable<Product>> findAllProduct(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

//    Tìm theo tên
    @GetMapping("/search")
    public ResponseEntity<Iterable<Product>> findByName(@RequestParam String name){
        return new ResponseEntity<>(productService.findAllByNameContaining(name),HttpStatus.OK);
    }

//    Hiện danh sách sắp xếp tăng dần
    @GetMapping("/sort")
    public ResponseEntity<Iterable<Product>> findAllByOrderByPriceAsc(){
        return new ResponseEntity<>(productService.findAllByOrderByPriceAsc(),HttpStatus.OK);
    }

//    Hiện 4 sản phẩm mới nhất
    @GetMapping("/findTop4")
    public ResponseEntity<Iterable<Product>> findTop4New(){
        return new ResponseEntity<>(productService.findTop4New(), HttpStatus.OK);
    }

//    Hiện sản phẩm 1 loại nào đó
    @GetMapping("/findProductByCategoryId/{id}")
    public ResponseEntity<Iterable<Product>> findProductByCategoryId(@PathVariable Long id){
        return new ResponseEntity<>(productService.findProductByCategoryId(id), HttpStatus.OK);
    }

//    Hiện sản phẩm theo khoảng giá

}
