package com.shopping.controller;

import com.shopping.entity.User;
import com.shopping.entity.shopping.Oder;
import com.shopping.entity.shopping.Product;
import com.shopping.services.Impl.OderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/oder")
@CrossOrigin("*")
public class OderController {

    @Autowired
    private OderServiceImpl oderService;

    //add oder
    @PostMapping("/")
    public ResponseEntity<Oder> addOder(@RequestBody Oder oder) {
        oder.setData(new Date());
        return ResponseEntity.ok(this.oderService.addOder(oder));
    }

    //update
    @PutMapping("/")
    public ResponseEntity<Oder> updateOder(@RequestBody Oder oder) {
        oder.setData(new Date());
        return ResponseEntity.ok(this.oderService.updateOder(oder));
    }


    //get oder by id
    @GetMapping("/{oId}")
    public ResponseEntity<?> getOderById(@PathVariable("oId") Long oId) {
        return ResponseEntity.ok(this.oderService.getOderById(oId));
    }


    //get all
    @GetMapping("/")
    public ResponseEntity<?> getOder() {
        return ResponseEntity.ok(this.oderService.getOder());
    }

    //delete
    @DeleteMapping("/{oId}")
    public void deleteOder(@PathVariable("oId") Long oId) throws Exception {
        try {
            this.oderService.deleteOder(oId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error");
        }
    }

    //get oder by product
    @GetMapping("/product/{pId}")
    public List<Oder> getOderOfProduct(@PathVariable("pId") Long pId) {
        Product product = new Product();
        product.setpId(pId);
        return this.oderService.getOderOfProduct(product);
    }

    //get oder by user
    @GetMapping("/user/{id}")
    public List<Oder> getOderOfUser(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        return this.oderService.getOderOfUser(user);
    }
}
