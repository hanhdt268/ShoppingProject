package com.shopping.controller;


import com.shopping.entity.shopping.OderInput;
import com.shopping.services.Impl.OderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oder")
@CrossOrigin("*")
public class OderDetailController {

    @Autowired
    private OderDetailService oderDetailService;

    @PostMapping("/{isCartCheckout}")
    public void placeOder(@PathVariable(name = "isCartCheckout") boolean isCartCheckout, @RequestBody OderInput oderInput) {
        oderDetailService.placeOder(oderInput, isCartCheckout);
    }
}
