package com.shopping.entity.shopping;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "laptop_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dId;
    private String cpu;
    private String ram;
    private String hardDrive;

    private String Screen;
    private String Graphic;
    private String Connector;
    private String Special;
    private String operatingSystem;
    private String design;

    private String sizeMass;
    private String releaseTime;

    @OneToMany(mappedBy = "productDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    public ProductDetails() {
    }

    public ProductDetails(Long dId, String cpu, String ram, String hardDrive, String screen, String graphic, String connector, String special, String operatingSystem, String design, String sizeMass, String releaseTime) {
        this.dId = dId;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDrive = hardDrive;
        Screen = screen;
        Graphic = graphic;
        Connector = connector;
        Special = special;
        this.operatingSystem = operatingSystem;
        this.design = design;
        this.sizeMass = sizeMass;
        this.releaseTime = releaseTime;
    }

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getScreen() {
        return Screen;
    }

    public void setScreen(String screen) {
        Screen = screen;
    }

    public String getGraphic() {
        return Graphic;
    }

    public void setGraphic(String graphic) {
        Graphic = graphic;
    }

    public String getConnector() {
        return Connector;
    }

    public void setConnector(String connector) {
        Connector = connector;
    }

    public String getSpecial() {
        return Special;
    }

    public void setSpecial(String special) {
        Special = special;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getSizeMass() {
        return sizeMass;
    }

    public void setSizeMass(String sizeMass) {
        this.sizeMass = sizeMass;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
