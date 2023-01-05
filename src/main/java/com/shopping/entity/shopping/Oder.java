package com.shopping.entity.shopping;

import com.shopping.entity.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Oder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oId;

    private String name;
    private String address;
    private String phone;
    private String status;
    private Date data;
    private String quantity;
    private String amount;


    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Oder() {
    }

    public Oder(Long oId, String name, String address, String phone, String status, Date data, String quantity, String amount) {
        this.oId = oId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.data = data;
        this.quantity = quantity;
        this.amount = amount;

    }

    public Long getoId() {
        return oId;
    }

    public void setoId(Long oId) {
        this.oId = oId;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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
}
