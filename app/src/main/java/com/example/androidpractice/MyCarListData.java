package com.example.androidpractice;

public class MyCarListData {
    private String price;
    private String description;
    private int imgId;


    public MyCarListData(String price, String description, int imgId) {
        this.price = price;
        this.description = description;
        this.imgId = imgId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
