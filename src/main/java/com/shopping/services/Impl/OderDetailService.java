package com.shopping.services.Impl;


import com.shopping.configuration.JwtAuthenticationFilter;
import com.shopping.entity.User;
import com.shopping.entity.shopping.*;
import com.shopping.repository.CartRepository;
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
    @Autowired
    private CartRepository cartRepository;

    public List<OderDetail> getOderDetails(String status) {
        String username = JwtAuthenticationFilter.USER_CURRENT;
        User user = userRepository.findByUsername(username);
        if (status.equals("All")) {
            return oderDetailRepository.findByUser(user);
        } else {
            return oderDetailRepository.findOderByOderStatus(status);
        }
    }


    public List<OderDetail> getAllOrderDetails(String status) {
        if (status.equals("All")) {
            return oderDetailRepository.findAll();
        } else {
            return oderDetailRepository.findOderByOderStatus(status);
        }
    }

    public void markOrderAsDelivered(Long oderId) {
        OderDetail oderDetail = oderDetailRepository.findById(oderId).get();

        if (oderDetail != null) {
            oderDetail.setOderStatus("Delivered");
            oderDetailRepository.save(oderDetail);
        }
    }

    public void markOrderAsDestroy(Long oderId) {
        OderDetail oderDetail = oderDetailRepository.findById(oderId).get();

        if (oderDetail != null) {
            oderDetail.setOderStatus("Cancel");
            oderDetailRepository.save(oderDetail);
        }
    }

    public void placeOder(OderInput oderInput, boolean isCartCheckout) {
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

            //empty the cart
            if (!isCartCheckout) {
                List<Cart> carts = cartRepository.findByUser(user);
                carts.stream().forEach(x -> cartRepository.deleteById(x.getCartId()));
            }

            this.oderDetailRepository.save(oderDetail);
        }


    }
}
