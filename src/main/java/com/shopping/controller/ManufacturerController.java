//package com.shopping.controller;
//
//import com.shopping.entity.shopping.Category;
//import com.shopping.entity.shopping.Manufacturer;
//import com.shopping.services.Impl.ManufacturerServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/manufacturer")
//@CrossOrigin("*")
//public class ManufacturerController {
//
//    @Autowired
//    private ManufacturerServiceImpl manufacturerService;
//
//
//    @PostMapping("/")
//    public ResponseEntity<Manufacturer> addManufacturer(@RequestBody Manufacturer manufacturer) {
//        return ResponseEntity.ok(this.manufacturerService.addManufacturer(manufacturer));
//    }
//
//    @PutMapping("/")
//    public ResponseEntity<Manufacturer> updateManufacturer(@RequestBody Manufacturer manufacturer) {
//        return ResponseEntity.ok(this.manufacturerService.updateManufacturer(manufacturer));
//    }
//
//    @GetMapping("/")
//    public ResponseEntity<?> getManufacturer() {
//        return ResponseEntity.ok(this.manufacturerService.getManufacturers());
//    }
//
//    @GetMapping("/{mId}")
//    public ResponseEntity<?> getManufacturerById(@PathVariable("mId") Long mId) {
//        return ResponseEntity.ok(this.manufacturerService.getManufacturerById(mId));
//    }
//
//    @DeleteMapping("/{mId}")
//    public void deleteManufacturer(@PathVariable("mId") Long mId) {
//        this.manufacturerService.deleteManufacturerById(mId);
//    }
//
//    //get Manufacturer by category
//    @GetMapping("/category/{cId}")
//    public List<Manufacturer> getManufacturerOfCategory(@PathVariable("cId") Long cId) {
//        Category category = new Category();
//        category.setcId(cId);
//        return this.manufacturerService.getManufacturerOfCategory(category);
//    }
//
//}
