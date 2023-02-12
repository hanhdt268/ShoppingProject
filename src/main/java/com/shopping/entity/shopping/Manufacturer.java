//package com.shopping.entity.shopping;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//@Entity
//public class Manufacturer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long mId;
//    private String title;
//    private String description;
//
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Category category;
//
//    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<Product> products = new LinkedHashSet<>();
//
//    public Manufacturer() {
//    }
//
//    public Manufacturer(Long mId, String title, String description) {
//        this.mId = mId;
//        this.title = title;
//        this.description = description;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
//
//    public Long getmId() {
//        return mId;
//    }
//
//    public void setmId(Long mId) {
//        this.mId = mId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}
//
