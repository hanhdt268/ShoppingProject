package com.shopping.controller;


import com.shopping.entity.shopping.ImageModel;
import com.shopping.entity.shopping.Manufacturer;
import com.shopping.entity.shopping.Product;
import com.shopping.repository.ProductRepository;
import com.shopping.services.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductRepository productRepository;


    //create product
    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Product> addProduct(@RequestPart("product") Product product,
                                              @RequestPart("imageFile") MultipartFile[] file) {
//        return ResponseEntity.ok(this.productService.addProduct(product));
        try {
            Set<ImageModel> imageModels = uploadImage(file);
            product.setProductImages(imageModels);
            return ResponseEntity.ok(this.productService.addProduct(product));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();
        for (MultipartFile file : multipartFiles) {
            ImageModel imageModel = new ImageModel(

                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    //update product
    @PutMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Product> updateProduct(@RequestPart("product") Product product,
                                                 @RequestPart("imageFile") MultipartFile[] file) {
//        return ResponseEntity.ok(this.productService.updateProduct(product));
        try {
            Set<ImageModel> imageModels = uploadImage(file);
            product.setProductImages(imageModels);
            return ResponseEntity.ok(this.productService.updateProduct(product));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
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
    @GetMapping("/manufacturer/{mId}")
    public List<Product> getProductOfCategory(@PathVariable("mId") Long mId) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setmId(mId);
        return this.productService.getProductOfCategory(manufacturer);
    }

    //get active product
    @GetMapping("/active")
    public List<Product> getActiveProduct() {
        return this.productService.getActiveProduct();
    }

    //get active product of manufacturer
    @GetMapping("/manufacturer/active/{mId}")
    public List<Product> getActiveProduct(@PathVariable("mId") Long mId) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setmId(mId);
        return this.productService.getActiveProductOfManu(manufacturer);
    }

    @GetMapping("/{isSingleProductCheckOut}/{pId}")
    public List<Product> getProductDetails(@PathVariable(name = "isSingleProductCheckOut") boolean isSingleProductCheckOut,
                                           @PathVariable(name = "pId") Long pId) {
        return productService.getProductDetail(isSingleProductCheckOut, pId);
    }
}
