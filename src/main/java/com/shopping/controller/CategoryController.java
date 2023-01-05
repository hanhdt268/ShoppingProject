package com.shopping.controller;


import com.shopping.entity.shopping.Category;
import com.shopping.services.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    //add category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(this.categoryService.addCategory(category));
    }

    //update
    @PutMapping("/")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        return ResponseEntity.ok(this.categoryService.updateCategory(category));
    }

    //get category by id
    @GetMapping("/{cId}")
    public ResponseEntity<?> getCategoriesById(@PathVariable("cId") Long cId) {
        return ResponseEntity.ok(this.categoryService.getCategoriesById(cId));
    }

    //get all
    @GetMapping("/")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    @DeleteMapping("/{cId}")
    public void delete(@PathVariable("cId") Long cId) {
        this.categoryService.deleteCategory(cId);
    }
}
