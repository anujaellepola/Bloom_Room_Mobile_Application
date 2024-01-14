package com.example.kdhdcsecmu5913;

public class MainModel2 {
    String Price, Category;
    MainModel2(){

    }
    public MainModel2(String price, String category) {
        Price = price;
        Category = category;
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
}
