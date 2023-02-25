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

    @GetMapping("/{status}")
    public List<OderDetail> getOderDetails(@PathVariable("status") String status) {
        return this.oderDetailService.getOderDetails(status);
    }

    @GetMapping("/getAllOrderDetails/{status}")
    public List<OderDetail> getAllOrderDetails(@PathVariable("status") String status) {
        return this.oderDetailService.getAllOrderDetails(status);
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
