package com.shopping.entity.shopping;


import com.shopping.entity.User;

import javax.persistence.*;

@Entity
public class OderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oderId;
    private String oderFullName;
    private String oderFullOder;
    private String oderContactNumber;

    private String oderAlternateContact;

    private String oderStatus;
    private Double oderAmount;


    @OneToOne
    private Product product;

    @OneToOne
    private User user;

    public OderDetail() {
    }

    public OderDetail(String oderFullName, String oderFullOder, String oderContactNumber, String oderAlternateContact, String oderStatus, Double oderAmount, Product product, User user) {
        this.oderFullName = oderFullName;
        this.oderFullOder = oderFullOder;
        this.oderContactNumber = oderContactNumber;
        this.oderAlternateContact = oderAlternateContact;
        this.oderStatus = oderStatus;
        this.oderAmount = oderAmount;
        this.product = product;
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getOderId() {
        return oderId;
    }

    public void setOderId(Long oderId) {
        this.oderId = oderId;
    }

    public String getOderFullName() {
        return oderFullName;
    }

    public void setOderFullName(String oderFullName) {
        this.oderFullName = oderFullName;
    }

    public String getOderFullOder() {
        return oderFullOder;
    }

    public void setOderFullOder(String oderFullOder) {
        this.oderFullOder = oderFullOder;
    }

    public String getOderContactNumber() {
        return oderContactNumber;
    }

    public void setOderContactNumber(String oderContactNumber) {
        this.oderContactNumber = oderContactNumber;
    }

    public String getOderAlternateContact() {
        return oderAlternateContact;
    }

    public void setOderAlternateContact(String oderAlternateContact) {
        this.oderAlternateContact = oderAlternateContact;
    }

    public String getOderStatus() {
        return oderStatus;
    }

    public void setOderStatus(String oderStatus) {
        this.oderStatus = oderStatus;
    }

    public Double getOderAmount() {
        return oderAmount;
    }

    public void setOderAmount(Double oderAmount) {
        this.oderAmount = oderAmount;
    }
}
