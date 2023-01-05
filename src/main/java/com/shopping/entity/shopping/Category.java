package com.shopping.entity.shopping;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Enabled;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cId;
    private String title;
    private String description;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Product> products = new LinkedHashSet<>();
    public Category() {
    }

    public Category(Long cId, String title, String description) {
        this.cId = cId;
        this.title = title;
        this.description = description;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
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
}
