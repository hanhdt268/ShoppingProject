package com.shopping.services.Impl;


import com.shopping.configuration.JwtAuthenticationFilter;
import com.shopping.entity.User;
import com.shopping.entity.shopping.OderDetail;
import com.shopping.entity.shopping.OderInput;
import com.shopping.entity.shopping.OderProductQuantity;
import com.shopping.entity.shopping.Product;
import com.shopping.repository.OderDetailRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderDetailService {


    public static final String ODER_PLACED = "Placed";
    @Autowired
    private OderDetailRepository oderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public void placeOder(OderInput oderInput) {
        List<OderProductQuantity> productQuantityList = oderInput.getOderProductQuantityList();
        for (OderProductQuantity o : productQuantityList) {
            Product product = this.productRepository.findById(o.getpId()).get();
            String currentUser = JwtAuthenticationFilter.USER_CURRENT;
            User user = userRepository.findByUsername(currentUser);

            OderDetail oderDetail = new OderDetail(
                    oderInput.getFullName(),
                    oderInput.getFullAddress(),
                    oderInput.getContactNumber(),
                    oderInput.getAlternateContact(),
                    ODER_PLACED,
                    product.getDiscountPrice() * o.getQuantity(),
                    product,
                    user
            );
            this.oderDetailRepository.save(oderDetail);
        }
    }
}
