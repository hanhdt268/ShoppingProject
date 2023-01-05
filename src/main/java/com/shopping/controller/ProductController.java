package com.shopping.controller;


import com.shopping.entity.shopping.Category;
import com.shopping.entity.shopping.Product;
import com.shopping.services.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;


    //create product
    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(this.productService.addProduct(product));
    }


    //update product
    @PutMapping("/")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(this.productService.updateProduct(product));
    }

    //get product by id
    @GetMapping("/{pId}")
    public ResponseEntity<?> getProductById(@PathVariable("pId") Long pId) {
        return ResponseEntity.ok(this.productService.getProductById(pId));
    }

    //getAll
    @GetMapping("/")
    public ResponseEntity<?> getProduct() {
        return ResponseEntity.ok(this.productService.getProducts());
    }

    //delete
    @DeleteMapping("/{pId}")
    public void deleteProduct(@PathVariable("pId") Long pId) {
        this.productService.deleteProduct(pId);
    }

    //get category by product
    @GetMapping("/category/{cId}")
    public List<Product> getProductOfCategory(@PathVariable("cId") Long cId) {
        Category category = new Category();
        category.setcId(cId);
        return this.productService.getProductOfCategory(category);
    }
}
