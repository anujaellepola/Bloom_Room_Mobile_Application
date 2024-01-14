package com.example.kdhdcsecmu5913;

public class MainModel {

    String Name, Price, Category, furl;

    MainModel(){

    }
    public MainModel(String name, String price, String category, String furl) {
        Name = name;
        Price = price;
        Category = category;
        this.furl = furl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl;
    }
}
