package com.shopping.entity.shopping;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pId;
    private String title;
    private String description;
    private String price;
    private String discountPrice;
    private String images;
    private Boolean active = false;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "product_image", joinColumns = {
            @JoinColumn(name = "product_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "image_id")
    }
    )
    private Set<ImageModel> productImage;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Oder> oders = new HashSet<>();

    public Product() {
    }

    public Product(Long pId, String title, String description, String price, String discountPrice, String images) {
        this.pId = pId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPrice = discountPrice;
        this.images = images;
    }

    public Set<ImageModel> getProductImage() {
        return productImage;
    }

    public void setProductImage(Set<ImageModel> productImage) {
        this.productImage = productImage;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Oder> getOders() {
        return oders;
    }

    public void setOders(Set<Oder> oders) {
        this.oders = oders;
    }
}
