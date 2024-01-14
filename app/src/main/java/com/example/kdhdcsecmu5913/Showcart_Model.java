package com.example.kdhdcsecmu5913;

public class Showcart_Model {
    String category;
    String price;

    public Showcart_Model(){

    }
    public Showcart_Model(String category, String price) {
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

