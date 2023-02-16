package com.shopping.controller;


import com.shopping.entity.shopping.Category;
import com.shopping.entity.shopping.ImageModel;
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
    public ResponseEntity<?> getProduct(@RequestParam(defaultValue = "0") int pageNumber,
                                        @RequestParam(defaultValue = "") String searchKey) {
        return ResponseEntity.ok(this.productService.getProducts(pageNumber, searchKey));
    }

    //delete
    @DeleteMapping("/{pId}")
    public void deleteProduct(@PathVariable("pId") Long pId) {
        this.productService.deleteProduct(pId);
    }

    //get category by product
    @GetMapping("/category/{cId}")
    public List<Product> getProductOfCategory(@RequestParam(defaultValue = "0") int pageNumber,
                                              @RequestParam(defaultValue = "") String searchKey,
                                              @PathVariable("cId") Long cId) {
        Category category = new Category();
        category.setcId(cId);
        return this.productService.getProductOfCategory(category, pageNumber, searchKey);
    }

    //get active product
    @GetMapping("/active")
    public List<Product> getActiveProduct(@RequestParam(defaultValue = "0") int pageNumber,
                                          @RequestParam(defaultValue = "") String searchKey) {
        return this.productService.getActiveProduct(pageNumber, searchKey);
    }

    //get active product of manufacturer
    @GetMapping("/category/active/{cId}")
    public List<Product> getActiveProduct(@RequestParam(defaultValue = "0") int pageNumber,
                                          @RequestParam(defaultValue = "") String searchKey,
                                          @PathVariable("cId") Long cId) {
        Category category = new Category();
        category.setcId(cId);
        return this.productService.getActiveProductOfCategory(category, pageNumber, searchKey);
    }

    @GetMapping("/{isSingleProductCheckOut}/{pId}")
    public List<Product> getProductDetails(@PathVariable(name = "isSingleProductCheckOut") boolean isSingleProductCheckOut,
                                           @PathVariable(name = "pId") Long pId) {
        return productService.getProductDetail(isSingleProductCheckOut, pId);
    }
}
