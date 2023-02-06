package com.shopping.entity.shopping;


import java.util.List;

public class OderInput {

    private String fullName;
    private String fullAddress;
    private String contactNumber;
    private String alternateContact;
    private List<OderProductQuantity> oderProductQuantityList;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAlternateContact() {
        return alternateContact;
    }

    public void setAlternateContact(String alternateContact) {
        this.alternateContact = alternateContact;
    }

    public List<OderProductQuantity> getOderProductQuantityList() {
        return oderProductQuantityList;
    }

    public void setOderProductQuantityList(List<OderProductQuantity> oderProductQuantityList) {
        this.oderProductQuantityList = oderProductQuantityList;
    }
}
