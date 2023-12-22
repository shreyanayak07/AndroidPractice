package com.example.androidpractice;


public class Offer {
    private String code;
    private double discount;

    public Offer(String code, double discount) {
        this.code = code;
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public double getDiscount() {
        return discount;
    }
}
