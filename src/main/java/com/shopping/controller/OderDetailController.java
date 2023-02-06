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

    @PostMapping("/")
    public void placeOder(@RequestBody OderInput oderInput) {
        oderDetailService.placeOder(oderInput);
    }
}
