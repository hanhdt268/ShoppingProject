package com.shopping.controller;


import com.shopping.entity.shopping.OderDetail;
import com.shopping.entity.shopping.OderInput;
import com.shopping.services.Impl.OderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/")
    public List<OderDetail> getOderDetails() {
        return this.oderDetailService.getOderDetails();
    }

    @GetMapping("/getAllOrderDetails")
    public List<OderDetail> getAllOrderDetails() {
        return this.oderDetailService.getAllOrderDetails();
    }

    //delivery
    @GetMapping("/markOrderAsDelivered/{oderId}")
    public void markOrderAsDelivered(@PathVariable("oderId") Long oderId) {
        this.oderDetailService.markOrderAsDelivered(oderId);
    }


    //cancel

    @GetMapping("/cancelOder/{oderId}")
    public void markOrderAsDestroy(@PathVariable("oderId") Long oderId) {
        this.oderDetailService.markOrderAsDestroy(oderId);
    }

}
